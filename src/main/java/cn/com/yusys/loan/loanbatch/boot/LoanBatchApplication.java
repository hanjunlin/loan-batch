package cn.com.yusys.loan.loanbatch.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"cn.com.yusys.loan.loanbatch"})
@MapperScan(basePackages = {"cn.com.yusys.loan.loanbatch.mapper"})
public class LoanBatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoanBatchApplication.class, args);
    }

}
