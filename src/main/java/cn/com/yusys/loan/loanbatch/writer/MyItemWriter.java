package cn.com.yusys.loan.loanbatch.writer;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * @author ：hanjl
 * @date ：Created in 2021/10/18 0018 17:22
 * @description：
 */
public class MyItemWriter implements ItemWriter<String> {

    @Override
    public void write(List<? extends String> items) throws Exception {
        for (String item : items) {
            System.out.println(item);
        }
    }

}
