package cn.com.yusys.loan.loanbatch.mapper;

import cn.com.yusys.loan.loanbatch.pojo.SBrBch;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ：hanjl
 * @date ：Created in 2021/11/6 0006 17:07
 * @description：
 */
public interface SBrBchMapper {

    @Select("select * from s_br_bch where BR_NO = #{brNo}")
    SBrBch selectByBrNo(@Param("brNo") String brNo);

    @Select("select * from s_br_bch")
    List<SBrBch> selectAll();

    @Select("<script>" +
            "select * from s_br_bch where " +
            "(BR_NO,BR_NAME) in " +
            "<foreach item='item' index='index' collection='sbrbchs' open='(' separator=',' close=')'>  " +
            "(#{item.brNo},#{item.brName}) " +
            "</foreach>" +
            "</script>")
    List<SBrBch> selectTest(@Param("sbrbchs") List<SBrBch> sbrbchs);
}
