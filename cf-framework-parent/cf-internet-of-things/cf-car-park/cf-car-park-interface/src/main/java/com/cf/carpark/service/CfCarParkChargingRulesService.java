package com.cf.carpark.service;

import com.cf.carpark.domain.CfCarPark;
import com.cf.carpark.domain.CfCarParkChargingRules;
import com.cf.carpark.domain.CfCarParkChargingRulesExample;
import com.cf.carpark.domain.CfCarParkUseLog;
import com.cf.carpark.domain.ext.CfCarParkOrder;
import com.cf.carpark.domain.request.CfCarParkChargingRulesQuery;
import com.cf.pay.domain.CfOrder;
import com.cf.pay.domain.CfUserPaymentAgency;
import com.cf.pay.domain.request.CCBScannedChargebackForm;
import com.cf.pay.domain.response.ResultMap;

import java.util.List;

/**
 * 请在此填写描述
 *
 * @ClassName CfCarParkChargingRulesService
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/5/005 16:20
 * @Version 1.0
 **/
public interface CfCarParkChargingRulesService {

    /**
     * 计算应付金额，同时处理支付相关业务操作
     * @param cfCarParkUseLogId
     * @param uid
     * @param payTypeId
     * @param ipAddress
     * @return
     * @throws Exception
     */
    public ResultMap calculateTheAmounPayableAndHandlePay(String cfCarParkUseLogId, String uid, String payTypeId, String ipAddress) throws Exception;

    /**
     * 计算应付金额，同时处理支付相关业务操作(包含优惠券)
     * @param cfCarParkUseLogId
     * @param uid
     * @param couponId
     * @param payTypeId
     * @param ipAddress
     * @return
     * @throws Exception
     */
    public ResultMap calculateTheAmounPayableAndHandlePay(String cfCarParkUseLogId, String uid, String couponId, String payTypeId, String ipAddress) throws Exception;

    /**
     * 计算应付金额
     * @param cfCarParkUseLogId
     * @param uid
     * @param queryMode 模式(query_only-只查询不更新订单/query_and_query-查询且会更新停车记录和相关订单)
     * @return
     */
    public CfCarParkOrder calculateTheAmounPayable(String cfCarParkUseLogId, String uid, String queryMode) throws Exception ;

    /**
     * 计算应付金额
     * @param cfCarParkUseLog
     * @param uid
     * @param queryMode 模式(query_only-只查询不更新订单/query_and_update-查询且会更新停车记录和相关订单)
     * @return
     */
    public CfCarParkOrder calculateTheAmounPayable(CfCarParkUseLog cfCarParkUseLog, String uid, String queryMode) throws Exception ;

    /**
     * 调试性计算应付金额
     * @param cfCarParkUseLog
     * @return
     * @throws Exception
     */
    CfCarParkOrder deBugCalculateTheAmounPayable(CfCarParkUseLog cfCarParkUseLog) throws Exception ;

    /**
     * 处理预约订单(若存在预约，考虑是否需要生成新订单，若预支付费用刚好足够不生成订单且无需额外支付，若预支付费用多余则部分退款，若不足以支付则生成新订单)
     * @param cfCarParkUseLog
     * @param cfOrder
     * @param cfOrderList
     * @return
     */
    public CfOrder handleParkingSpaceSubscribeOrder(CfCarParkUseLog cfCarParkUseLog, CfOrder cfOrder, List<CfOrder> cfOrderList);

    /**
     * 每日固定模式计算停车费
     * @param startTime
     * @param endTime
     * @param cfCarPark
     * @param unitPrice
     * @param currentCalculateingCarType
     * @param calculateingCfCarPark
     * @param counts
     * @param upperLimitTime 上限时间
     * @return
     * @throws Exception
     */
    public Double fixedCalculateTheAmounPayable(Long startTime, Long endTime, CfCarPark cfCarPark, Double unitPrice, String currentCalculateingCarType, CfCarPark calculateingCfCarPark, Integer counts, Long upperLimitTime) throws Exception;

    /**
     * 24小时固定模式计算停车费
     * @param startTime
     * @param endTime
     * @param cfCarPark
     * @param unitPrice
     * @param currentCalculateingCarType
     * @param calculateingCfCarPark
     * @param counts
     * @return
     * @throws Exception
     */
    Double fixed24HoursCalculateTheAmounPayable(Long startTime, Long endTime, CfCarPark cfCarPark, Double unitPrice, String currentCalculateingCarType, CfCarPark calculateingCfCarPark, Integer counts) throws Exception;

    /**
     * 每日动态模式计算停车费
     * @param startTime
     * @param endTime
     * @param totalFee
     * @param carType
     * @param calculateingCfCarPark
     * @param counts
     * @param carParkChargingRules
     * @param upperLimitTime
     * @param countFee  已经统计到的部分金额(如果upperLimitTime大于0时需要用到)
     * @param originalStartTime 原始开始时间(如果upperLimitTime大于0时需要用到)
     * @return
     * @throws Exception
     */
    public Double dynamicCalculateTheAmounPayable(Long startTime, Long endTime, Double totalFee, String carType, CfCarPark calculateingCfCarPark, Integer counts, List<CfCarParkChargingRules> carParkChargingRules, Long upperLimitTime, Double countFee, Long originalStartTime) throws Exception;

    /**
     * 24小时动态模式计算停车费
     * @param totalTime 总停车时间
     * @param startCountTime 开始计费的时间(不是开始时间，而是从开始时间起那时从0累计)
     * @param carType   类型类
     * @param calculateingCfCarPark
     * @param counts
     * @param carParkChargingRules
     * @param currentPrice
     * @return
     * @throws Exception
     */
    public Double dynamic24HoursCalculateTheAmounPayable(Long totalTime, Long startCountTime, String carType, CfCarPark calculateingCfCarPark, Integer counts, List<CfCarParkChargingRules> carParkChargingRules, double currentPrice) throws Exception;

    /**
     * 根据停车场获取收费规则
     * @param carParkId
     * @return
     */
    public List<CfCarParkChargingRules> getListByCarParkId(String carParkId) throws Exception ;

    /**
     * 根据条件查询收费规则
     * @param cfCarParkChargingRulesQuery
     * @return
     */
    public List<CfCarParkChargingRules> getListByCondition(CfCarParkChargingRulesQuery cfCarParkChargingRulesQuery);

    /**
     * 新增
     * @param cfCarParkChargingRules
     * @return
     */
    public CfCarParkChargingRules add(CfCarParkChargingRules cfCarParkChargingRules) throws Exception ;

    /**
     * 更新
     * @param cfCarParkChargingRules
     * @return
     */
    public CfCarParkChargingRules update(CfCarParkChargingRules cfCarParkChargingRules) throws Exception ;

    /**
     * 删除
     * @param cfCarParkChargingRulesId
     * @return
     */
    public Integer delete(String cfCarParkChargingRulesId);

    public Integer deleteByQuery(CfCarParkChargingRulesQuery cfCarParkChargingRulesQuery);

    CfCarParkChargingRulesExample getExampleByQuery(CfCarParkChargingRulesQuery cfCarParkChargingRulesQuery);

    /**
     * 校验和处理车场计费规则的起止时间
     * @param cfCarParkChargingRules
     * @return
     */
    public CfCarParkChargingRules validAndHandleChargingRulesStartEndTime(CfCarParkChargingRules cfCarParkChargingRules);

    /**
     * 给停车场记录进行支付停车费
     * @param cfOrder
     * @param payTypeId
     * @param ipAddress
     * @return
     */
    public ResultMap payForCarUseLog(CfOrder cfOrder, String payTypeId, String ipAddress) throws Exception ;

    /**
     * 停车场自动扣费
     * @param cfCarParkUseLog
     * @param numberPlate
     * @return
     */
    CfOrder automaticPayment(CfCarParkUseLog cfCarParkUseLog, String numberPlate) throws Exception;

    /**
     * 使用账户余额支付停车费
     * @param cfOrder
     * @return
     */
    CfOrder accountPay(CfOrder cfOrder);

    /**
     * 建行测试支付
     * @param carParkUseLogId
     * @param numberPlate
     * @return
     */
    CfOrder ccbPayTest(String carParkUseLogId, String numberPlate) throws Exception;

    /**
     * 自动使用券抵扣
     * @param cfOrder
     * @return
     */
    CfOrder autoUseCouponDeduction(CfOrder cfOrder);

    /**
     * 被扫码扣款
     * @param cfOrder
     * @param cfUserPaymentAgency
     * @param ccbScannedChargebackForm
     * @return
     */
    CfOrder scannedChargeback(CfOrder cfOrder, CfUserPaymentAgency cfUserPaymentAgency, CCBScannedChargebackForm ccbScannedChargebackForm) throws Exception;

    /**
     * 车费免密支付
     * @param cfOrder
     * @param cfUserPaymentAgency
     * @param ccbScannedChargebackForm
     * @return
     */
    CfOrder secretFreePayment(CfOrder cfOrder, CfUserPaymentAgency cfUserPaymentAgency, CCBScannedChargebackForm ccbScannedChargebackForm) throws Exception;

}
