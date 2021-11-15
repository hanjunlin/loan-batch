package cn.com.yusys.loan.loanbatch.web.rest;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.NoSuchJobException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author ：hanjl
 * @date ：Created in 2021/11/15 0015 11:32
 * @description：
 */
@RestController
@RequestMapping("/api/test")
public class MyJobLauncher {

    private final Job myJob;

    private final JobLauncher jobLauncher;

    @Autowired
    public MyJobLauncher(Job myJob, JobLauncher jobLauncher) {
        this.myJob = myJob;
        this.jobLauncher = jobLauncher;
    }

    @PostMapping("/myjob")
    public String myjob() throws NoSuchJobException, JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
        JobExecution jobExecution = jobLauncher.run(myJob, createJobParams());
        if (!jobExecution.getExitStatus().equals(ExitStatus.COMPLETED)) {
            throw new RuntimeException(String.format("%s Job execution failed.", myJob.getName()));
        }
        return myJob.getName();
    }

    private JobParameters createJobParams() {
        return new JobParametersBuilder().addDate("date", new Date()).toJobParameters();
    }

}
