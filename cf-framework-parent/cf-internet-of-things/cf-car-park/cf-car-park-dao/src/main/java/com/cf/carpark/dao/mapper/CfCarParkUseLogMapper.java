package com.cf.carpark.dao.mapper;

import com.cf.carpark.domain.CfCarParkUseLog;
import com.cf.carpark.domain.CfCarParkUseLogExample;
import com.cf.carpark.domain.request.CfCarParkUseLogQuery;
import com.cf.carpark.domain.request.CfCountCarParkUseLogQuery;
import com.cf.carpark.domain.request.CountPayAmountByDutyQuery;
import com.cf.framework.domain.report.CountByDay;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface CfCarParkUseLogMapper {
    int countByExample(CfCarParkUseLogExample example);

    int deleteByExample(CfCarParkUseLogExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfCarParkUseLog record);

    int insertSelective(CfCarParkUseLog record);

    List<CfCarParkUseLog> selectByExample(CfCarParkUseLogExample example);

    CfCarParkUseLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfCarParkUseLog record, @Param("example") CfCarParkUseLogExample example);

    int updateByExample(@Param("record") CfCarParkUseLog record, @Param("example") CfCarParkUseLogExample example);

    int updateByPrimaryKeySelective(CfCarParkUseLog record);

    int updateByPrimaryKey(CfCarParkUseLog record);

    List<CfCarParkUseLog> selectByQuery(CfCarParkUseLogQuery cfCarParkUseLogQuery);

    List<CfCarParkUseLog> selectByQueryContainOrder(CfCarParkUseLogQuery cfCarParkUseLogQuery);

    /**
     * 根据条件查询停车记录数据列表
     * @param conditions
     * @return
     */
    List<CfCarParkUseLog> selectListByCondition(String conditions);

    /**
     * 根据条件查询停车记录数据列表数
     * @param conditions
     * @return
     */
    Integer selectListByConditionCounts(String conditions);

    /**
     * 统计前N天每天的停车记录数
     * @param cfCountCarParkUseLogQuery
     * @return
     */
    List<CountByDay> limitDaysCountByDay(CfCountCarParkUseLogQuery cfCountCarParkUseLogQuery);

    /**
     * 获取某个年份某个月数的停车数
     * @param cfCountCarParkUseLogQuery
     * @return
     */
    List<CountByDay> yearMonthCountByDay(CfCountCarParkUseLogQuery cfCountCarParkUseLogQuery);

    /**
     * 获取某个年份每个月份的停车数
     * @param cfCountCarParkUseLogQuery
     * @return
     */
    List<CountByDay> yearCountByMonth(CfCountCarParkUseLogQuery cfCountCarParkUseLogQuery);

    /**
     * 统计岗亭值班人员一段时间内各渠道收费情况
     * @param countPayAmountByDutyQuery
     * @return
     */
    BigDecimal countPayAmountByDuty(CountPayAmountByDutyQuery countPayAmountByDutyQuery);

    Integer countByQuery(CfCarParkUseLogQuery cfCarParkUseLogQuery);

    /**
     * 统计某个字段
     * @param cfCarParkUseLogQuery
     * @return
     */
    Long countByField(CfCarParkUseLogQuery cfCarParkUseLogQuery);
}