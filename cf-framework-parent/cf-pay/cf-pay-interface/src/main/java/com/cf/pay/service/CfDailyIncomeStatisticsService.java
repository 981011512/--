package com.cf.pay.service;

import com.cf.pay.domain.CfDailyIncomeStatistics;
import com.cf.pay.domain.CfDailyIncomeStatisticsExample;
import com.cf.pay.domain.request.CfDailyIncomeStatisticsQuery;

import java.util.List;

public interface CfDailyIncomeStatisticsService {

    CfDailyIncomeStatistics add(CfDailyIncomeStatistics cfDailyIncomeStatistics);

    CfDailyIncomeStatistics update(CfDailyIncomeStatistics cfDailyIncomeStatistics);

    Integer updateByQuery(CfDailyIncomeStatistics cfDailyIncomeStatistics, CfDailyIncomeStatisticsQuery cfDailyIncomeStatisticsQuery);

    Integer delete(String id);

    Integer deleteByQuery(CfDailyIncomeStatisticsQuery cfDailyIncomeStatisticsQuery);

    CfDailyIncomeStatisticsExample getExampleByQuery(CfDailyIncomeStatisticsQuery cfDailyIncomeStatisticsQuery);

    List<CfDailyIncomeStatistics> getListByQuery(CfDailyIncomeStatisticsQuery cfDailyIncomeStatisticsQuery);

    Integer countByQuery(CfDailyIncomeStatisticsQuery cfDailyIncomeStatisticsQuery);

    /**
     * 统计
     * @param dateStr
     * @param startTime
     * @param endTime
     * @param countModel 统计模式(year-按年统计/month-按月统计/day-按天统计)
     * @throws Exception
     */
    void statisticsDatas(String dateStr, Long startTime, Long endTime, String countModel) throws Exception;

}
