package cn.com.yusys.loan.loanbatch;

import cn.com.yusys.loan.loanbatch.boot.LoanBatchApplication;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = {LoanBatchApplication.class})
@RunWith(SpringRunner.class)
@Slf4j
public class LoanBatchApplicationTests {

	@Test
	void contextLoads() {
		BaseDto<BaseDto> baseDto = new BaseDto();
		baseDto.setKey("1");
		BaseDto<String> baseDto1 = new BaseDto();
		baseDto1.setKey("2");
		baseDto1.setData("abc");
		String data = baseDto1.getData();
		baseDto.setData(baseDto1);
		log.info(JSON.toJSONString(baseDto));
	}

}
