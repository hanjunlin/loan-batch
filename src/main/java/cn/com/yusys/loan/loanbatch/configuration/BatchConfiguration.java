package cn.com.yusys.loan.loanbatch.configuration;

import cn.com.yusys.loan.loanbatch.processor.MyItemProcessor;
import cn.com.yusys.loan.loanbatch.reader.MyItemReader;
import cn.com.yusys.loan.loanbatch.writer.MyItemWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.*;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import java.io.File;

/**
 * @author ：hanjl
 * @date ：Created in 2021/10/18 0018 17:23
 * @description：
 */
@Configuration
@EnableBatchProcessing
@Slf4j
public class BatchConfiguration extends DefaultBatchConfigurer {

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Bean(name = "processor")
    public ItemProcessor processor() {
        return new MyItemProcessor();
    }

    @Bean(name = "writer")
    public ItemWriter<String> writer() {
        return new MyItemWriter();
    }

    @Bean
    public ItemReader<String> textReader() {
        FlatFileItemReader<String> reader = new FlatFileItemReader<>();
        File file = new File("D:\\FTP\\ttest.txt");
        reader.setResource(new FileSystemResource(file));
        reader.setLineMapper(new LineMapper<String>() {
            @Override
            public String mapLine(String line, int lineNumber) throws Exception {
                return line;
            }
        });
        return reader;
    }

    @Bean(name = "stringReader")
    @StepScope
    public ItemReader<String> stringReader(@Value("#{jobParameters['date']}") String date) {
        return new MyItemReader(date);
    }

    @Bean(name = "myStep")
    public Step myStep(@Qualifier("stringReader") ItemReader reader, @Qualifier("processor") ItemProcessor processor, @Qualifier("writer") ItemWriter writer) {
        return stepBuilderFactory
                .get("step1")
                //这个chunk size是最后调用写入的时候，一次性写入多少条已处理的数据
                .<String, String>chunk(10)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();

    }

    @Bean(name = "myJob")
    public Job MyJob(@Qualifier("myStep") Step myStep) {
        log.info("生成--MyJob...");
        return jobBuilderFactory
                .get("MyJOB")
                .listener(new JobExecutionListenerSupport() {
                    //所有处理结束后调用
                    @Override
                    public void afterJob(JobExecution jobExecution) {
                        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
                            System.out.println("OK");
                        }
                    }
                })
                .flow(myStep)
                .end()
                .build();
    }

}