package com.cf.pay.dao.mapper;

import com.cf.pay.domain.CfDailyIncomeStatistics;
import com.cf.pay.domain.CfDailyIncomeStatisticsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfDailyIncomeStatisticsMapper {
    int countByExample(CfDailyIncomeStatisticsExample example);

    int deleteByExample(CfDailyIncomeStatisticsExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfDailyIncomeStatistics record);

    int insertSelective(CfDailyIncomeStatistics record);

    List<CfDailyIncomeStatistics> selectByExample(CfDailyIncomeStatisticsExample example);

    CfDailyIncomeStatistics selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfDailyIncomeStatistics record, @Param("example") CfDailyIncomeStatisticsExample example);

    int updateByExample(@Param("record") CfDailyIncomeStatistics record, @Param("example") CfDailyIncomeStatisticsExample example);

    int updateByPrimaryKeySelective(CfDailyIncomeStatistics record);

    int updateByPrimaryKey(CfDailyIncomeStatistics record);
}