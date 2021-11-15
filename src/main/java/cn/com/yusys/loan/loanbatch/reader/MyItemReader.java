package cn.com.yusys.loan.loanbatch.reader;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

/**
 * @author ：hanjl
 * @date ：Created in 2021/10/18 0018 17:19
 * @description：
 */
@Slf4j
public class MyItemReader implements ItemReader<String> {

    public MyItemReader(String date) {
        log.info("date:" + date);
    }

    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        return RandomStringUtils.randomAlphabetic(10);
    }

}
