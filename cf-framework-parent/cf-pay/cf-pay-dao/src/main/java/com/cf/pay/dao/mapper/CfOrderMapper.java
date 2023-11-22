package com.cf.pay.dao.mapper;

import com.cf.framework.domain.report.CountByDay;
import com.cf.pay.domain.CfOrder;
import com.cf.pay.domain.CfOrderExample;
import com.cf.pay.domain.request.CfCountFinanceQuery;
import com.cf.pay.domain.request.CfOrderQuery;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface CfOrderMapper {
    int countByExample(CfOrderExample example);

    int deleteByExample(CfOrderExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfOrder record);

    int insertSelective(CfOrder record);

    List<CfOrder> selectByExample(CfOrderExample example);

    CfOrder selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfOrder record, @Param("example") CfOrderExample example);

    int updateByExample(@Param("record") CfOrder record, @Param("example") CfOrderExample example);

    int updateByPrimaryKeySelective(CfOrder record);

    int updateByPrimaryKey(CfOrder record);

    /**
     * 根据条件查询订单数据列表
     * @param conditions
     * @return
     */
    List<CfOrder> selectListByCondition(String conditions);

    /**
     * 根据条件查询订单数据列表数
     * @param conditions
     * @return
     */
    Integer selectListByConditionCounts(String conditions);

    /**
     * 统计前N天每天的停车记录数(支持传入地区或停车场)
     * @param cfCountFinanceQuery
     * @return
     */
    public List<CountByDay> limitDaysCountByDay(CfCountFinanceQuery cfCountFinanceQuery);

    /**
     * 统计前N天每天已支付金额(支持传入地区或停车场)
     * @param cfCountFinanceQuery
     * @return
     */
    public List<CountByDay> limitDaysCountByDayFromPayTime(CfCountFinanceQuery cfCountFinanceQuery);

    /**
     * 获取某个年份某个月数的停车数(支持传入地区或停车场)
     * @param cfCountFinanceQuery
     * @return
     */
    public List<CountByDay> yearMonthCountByDay(CfCountFinanceQuery cfCountFinanceQuery);

    /**
     * 获取某个年份每个月份的停车数
     * @param cfCountFinanceQuery
     * @return
     */
    public List<CountByDay> yearCountByMonth(CfCountFinanceQuery cfCountFinanceQuery);

    /**
     * 刷新订单id
     * @param newOrderId
     * @param oldOrderId
     * @return
     */
    Integer flushOrderId(@Param("newOrderId") String newOrderId, @Param("oldOrderId") String oldOrderId);

    BigDecimal countByField(CfOrderQuery cfOrderQuery);
}