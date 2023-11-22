package com.cf.pay.service;

import com.cf.pay.domain.CfUserPaymentAgency;
import com.cf.pay.domain.CfUserPaymentAgencyExample;
import com.cf.pay.domain.request.CfUserPaymentAgencyQuery;

import java.util.List;
import java.util.Map;

/**
 * 用户名下的支付账户管理
 *
 * @ClassName CfUserPaymentAgencyService
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/9/009 20:07
 * @Version 1.0
 **/
public interface CfUserPaymentAgencyService {

    /**
     * 根据id获取一条数据
     * @param id
     * @return
     */
    public CfUserPaymentAgency findById(String id);

    /**
     * 根据id获取一条数据
     * @param id
     * @param expectEmpty 是否期望为空
     * @return
     */
    public CfUserPaymentAgency findById(String id, Boolean expectEmpty);

    /**
     * 根据用户id和支付机构简称获取商户支付账号数据
     * @param uid
     * @param paymentAgencyShortName
     * @return
     */
    public CfUserPaymentAgency findByUidAndPaymentAgencyShortName(String uid, String paymentAgencyShortName);

    public CfUserPaymentAgencyExample getExampleByQuery(CfUserPaymentAgencyQuery cfUserPaymentAgencyQuery);

    public List<CfUserPaymentAgency> getListByQuery(CfUserPaymentAgencyQuery cfUserPaymentAgencyQuery);

    /**
     * 根据条件查询用户支付账号数据列表
     * @param conditions example {"字段名":"表别名"}
     * @param allowFiledsMap example {"字段名":"表别名"}
     * @param allowFileds example {"字段名"}
     * @return
     */
    public List<CfUserPaymentAgency> selectListByCondition(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds);

    /**
     * 根据条件查询用户支付账号数据列表数
     * @param conditions example {"字段名":"表别名"}
     * @param allowFiledsMap example {"字段名":"表别名"}
     * @param allowFileds example {"字段名"}
     * @return
     */
    public Integer selectListByConditionCounts(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds);

    public CfUserPaymentAgency add(CfUserPaymentAgency cfUserPaymentAgency);

    public CfUserPaymentAgency update(CfUserPaymentAgency cfUserPaymentAgency);

    public Integer delete(String id);

    /**
     * 根据停车场id和支付机构简称查询支付数据
     * @param carParkId
     * @param paymentAgencyShortName
     * @return
     */
    List<CfUserPaymentAgency> selectListByCarParkIdAndPaymentAgencyShortName(String carParkId, String paymentAgencyShortName);

}
