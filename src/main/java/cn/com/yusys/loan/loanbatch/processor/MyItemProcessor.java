package cn.com.yusys.loan.loanbatch.processor;

import org.springframework.batch.item.ItemProcessor;

/**
 * @author ：hanjl
 * @date ：Created in 2021/10/18 0018 17:21
 * @description：
 */
public class MyItemProcessor implements ItemProcessor<String, String> {

    @Override
    public String process(String s) throws Exception {
        return s + "---------PROCESSED";
    }

}
