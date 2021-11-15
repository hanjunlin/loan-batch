package cn.com.yusys.loan.loanbatch.mapper;

import cn.com.yusys.loan.loanbatch.boot.LoanBatchApplication;
import cn.com.yusys.loan.loanbatch.pojo.SBrBch;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = {LoanBatchApplication.class})
@RunWith(SpringRunner.class)
public class SBrBchMapperTest {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private SBrBchMapper mapper;
    @Test
    public void selectByBrNo(){
        SBrBch sBrBch = mapper.selectByBrNo("1");
        log.info("json:" + JSON.toJSONString(sBrBch));
    }

    @Test
    public void selectTest(){
        List<SBrBch> sBrBches = mapper.selectAll();
        List<SBrBch> sBrBches1 = mapper.selectTest(sBrBches);
        log.info("json:" + JSON.toJSONString(sBrBches1));
    }
}