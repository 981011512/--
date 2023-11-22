package com.cf.pay.service;

import com.cf.framework.domain.report.CountByDay;
import com.cf.pay.domain.CfOrder;
import com.cf.pay.domain.CfOrderExample;
import com.cf.pay.domain.CfUserPaymentAgency;
import com.cf.pay.domain.request.CfCountFinanceQuery;
import com.cf.pay.domain.request.CfOrderQuery;
import com.cf.pay.domain.response.ResultMap;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 订单管理
 *
 * @ClassName CfOrderService
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/2/002 9:08
 * @Version 1.0
 **/
public interface CfOrderService {

    /**
     * 新增订单记录
     * @param cfOrder
     * @return
     */
    public CfOrder add(CfOrder cfOrder);

    /**
     * 更新订单记录
     * @param cfOrder
     * @return
     */
    public CfOrder update(CfOrder cfOrder);

    /**
     * 只更新部分字段
     * @param cfOrder
     * @return
     */
    public CfOrder updateByPrimaryKeySelective(CfOrder cfOrder);

    /**
     * 根据id获取一条订单数据
     * @param id
     * @return
     */
    public CfOrder findById(String id);

    /**
     * 根据id获取一条订单数据
     * @param id
     * @param expectEmpty   是否期望为空
     * @return
     */
    public CfOrder findById(String id, Boolean expectEmpty);

    public CfOrderExample getExampleByQuery(CfOrderQuery cfOrderQuery);

    /**
     * 根据查询条件获取订单数据列表
     * @return
     */
    public List<CfOrder> getListByQuery(CfOrderQuery cfOrderQuery);

    /**
     * 根据条件查询订单数据列表
     * @param conditions example {"字段名":"表别名"}
     * @param allowFiledsMap example {"字段名":"表别名"}
     * @param allowFileds example {"字段名"}
     * @return
     */
    public List<CfOrder> selectListByCondition(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds);

    public Integer countByQuery(CfOrderQuery cfOrderQuery);

    public Integer deleteByQuery(CfOrderQuery cfOrderQuery);

    public Integer updateByQuery(CfOrder cfOrder, CfOrderQuery cfOrderQuery);

    /**
     * 结束子订单
     * @param cfOrder
     */
    void overChildrenOrder(CfOrder cfOrder);

    /**
     * 根据条件查询订单数据列表数
     * @param conditions example {"字段名":"表别名"}
     * @param allowFiledsMap example {"字段名":"表别名"}
     * @param allowFileds example {"字段名"}
     * @return
     */
    public Integer selectListByConditionCounts(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds);

    /**
     * 为指定的订单进行支付
     * @param cfOrder
     * @param cfUserPaymentAgencyId
     * @param ip    客户端ip地址
     * @return
     */
    public ResultMap payForOrder(CfOrder cfOrder, String cfUserPaymentAgencyId, String ip) throws Exception ;

    /**
     * 根据不同的支付机构获取对应的预支付订单数据
     * @param cfUserPaymentAgency
     * @param cfOrder
     * @param ip
     * @return
     */
    public ResultMap getUnifiedOrderByPaymentAgency(CfUserPaymentAgency cfUserPaymentAgency, CfOrder cfOrder, String ip) throws Exception ;

    /**
     * 处理支付成功的订单
     * @param cfOrder
     */
    public void handlePaySuccessfulOrder(CfOrder cfOrder);

    /**
     * 统计前N天每天的停车记录数(支持传入地区或停车场)
     * @param cfCountFinanceQuery
     * @return
     */
    public List<CountByDay> limitDaysCountByDay(CfCountFinanceQuery cfCountFinanceQuery);

    /**
     * 统计前N天每天的支付金额(支持传入地区或停车场)
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
    Integer flushOrderId(String newOrderId, String oldOrderId);

    /**
     * 支付成功后处理
     * @param cfOrder
     * @param paiedTotalFee
     */
    Object paySuccessAndupdateOrder(CfOrder cfOrder, BigDecimal paiedTotalFee) throws Exception;

    /**
     * 查询第三方支付订单
     * @param platform
     * @param orderId
     * @return
     */
    Object queryThirdPartyOrder(String platform, String orderId) throws Exception;

    BigDecimal countByField(CfOrderQuery cfOrderQuery);

}
