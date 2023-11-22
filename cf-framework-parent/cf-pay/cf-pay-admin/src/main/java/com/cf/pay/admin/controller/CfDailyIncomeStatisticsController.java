package com.cf.pay.admin.controller;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.utils.DateUtil;
import com.cf.pay.admin.swagger.CfDailyIncomeStatisticsSwagger;
import com.cf.pay.domain.CfDailyIncomeStatistics;
import com.cf.pay.domain.request.CfDailyIncomeStatisticsQuery;
import com.cf.pay.domain.type.CountModel;
import com.cf.pay.service.CfDailyIncomeStatisticsService;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("dailyIncomeStatistics/")
public class CfDailyIncomeStatisticsController implements CfDailyIncomeStatisticsSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 10000, check = false)
    private CfDailyIncomeStatisticsService cfDailyIncomeStatisticsService;

    @PreAuthorize("hasAuthority('pay-CfDailyIncomeStatisticsController-getListByQuery')")
    @Override
    @RequestMapping(value = "getListByQuery", method = RequestMethod.GET)
    public ResponseResult getListByQuery(CfDailyIncomeStatisticsQuery cfDailyIncomeStatisticsQuery) throws Exception {
        List<CfDailyIncomeStatistics> cfDailyIncomeStatistics = cfDailyIncomeStatisticsService.getListByQuery(cfDailyIncomeStatisticsQuery);
        if(cfDailyIncomeStatistics==null || cfDailyIncomeStatistics.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfDailyIncomeStatistics);
    }

    @PreAuthorize("hasAuthority('pay-CfDailyIncomeStatisticsController-countYear')")
    @Override
    @RequestMapping(value = "countYear", method = RequestMethod.GET)
    public ResponseResult countYear(String year) throws Exception {
        if(StringUtils.isEmpty(year)){
            year = DateUtil.stampToDate(System.currentTimeMillis(), "yyyy");
        }
        final String _year = year;
        Integer month = new Integer(DateUtil.stampToDate(System.currentTimeMillis(), "MM"));
        for(int i=1; i<=month; i++){
            final Long current = DateUtil.dateToStamp(year+"-"+(i<10?"0"+i:i)+"-01 23:59:59","yyyy-MM-dd HH:mm:ss");
            final String dateStr = DateUtil.stampToDate(DateUtil.minMillisecondBaseOnTheDayToTimestamp(current),"yyyy-MM-dd");
            Thread thread = new Thread(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    cfDailyIncomeStatisticsService.statisticsDatas(dateStr,DateUtil.getMonthStartTime(current,"GMT+8:00"),DateUtil.getMonthEndTime(current,"GMT+8:00"),CountModel.COUNT_MODEL_MONTH);
                }
            });
            thread.start();
        }
        Thread thread = new Thread(new Runnable() {
            final Long current = DateUtil.dateToStamp(_year+"-06-01 23:59:59","yyyy-MM-dd HH:mm:ss");
            final String dateStr = DateUtil.stampToDate(DateUtil.minMillisecondBaseOnTheDayToTimestamp(current),"yyyy-MM-dd");
            @SneakyThrows
            @Override
            public void run() {
                cfDailyIncomeStatisticsService.statisticsDatas(dateStr,DateUtil.getYearStartTime(current,"GMT+8:00"),DateUtil.getYearEndTime(current,"GMT+8:00"),CountModel.COUNT_MODEL_YEAR);
            }
        });
        thread.start();
        return new ResponseResult(CommonCode.SUCCESS);
    }

    @PreAuthorize("hasAuthority('pay-CfDailyIncomeStatisticsController-countMonth')")
    @Override
    @RequestMapping(value = "countMonth", method = RequestMethod.GET)
    public ResponseResult countMonth(String yearAndMonth) throws Exception {
        if(StringUtils.isEmpty(yearAndMonth)){
            yearAndMonth = DateUtil.stampToDate(System.currentTimeMillis(), "yyyy-MM");
        }
        Integer day = new Integer(DateUtil.stampToDate(System.currentTimeMillis(), "dd"));
        for(int i=1; i<=day.intValue(); i++){
            final Long current = DateUtil.dateToStamp(yearAndMonth+"-"+(i<10?"0"+i:i)+" 23:59:59","yyyy-MM-dd HH:mm:ss");
            final String dateStr = DateUtil.stampToDate(DateUtil.minMillisecondBaseOnTheDayToTimestamp(current),"yyyy-MM-dd");
            Thread thread = new Thread(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    Long startTime = DateUtil.minMillisecondBaseOnTheDayToTimestamp(current);
                    Long endTime = DateUtil.maxMillisecondBaseOnTheDayToTimestamp(current);
                    cfDailyIncomeStatisticsService.statisticsDatas(dateStr, startTime, endTime, CountModel.COUNT_MODEL_DAY);
                }
            });
            thread.start();
        }
        return new ResponseResult(CommonCode.SUCCESS);
    }
}
