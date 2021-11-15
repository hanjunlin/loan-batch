package cn.com.yusys.loan.loanbatch.reader;

import cn.com.yusys.loan.loanbatch.mapper.SBrBchMapper;
import cn.com.yusys.loan.loanbatch.pojo.SBrBch;
import cn.com.yusys.loan.loanbatch.util.SpringUtil;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisPagingItemReader;

/**
 * @author ：hanjl
 * @date ：Created in 2021/11/6 0006 18:41
 * @description：
 */
public class DBReader extends MyBatisPagingItemReader<SBrBch> {

    public DBReader(SqlSessionFactory sqlSessionFactory, String name) {
        SBrBchMapper mapper = SpringUtil.getBean(SBrBchMapper.class);

        setSqlSessionFactory(sqlSessionFactory);
        setQueryId("com.sl.entity." + name + "selectList");
        setPageSize(100);
    }

}
