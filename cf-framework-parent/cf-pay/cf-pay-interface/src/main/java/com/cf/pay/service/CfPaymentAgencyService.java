package com.cf.pay.service;

import com.cf.pay.domain.CfPaymentAgency;
import com.cf.pay.domain.CfPaymentAgencyExample;
import com.cf.pay.domain.request.CfPaymentAgencyQuery;
import com.cf.pay.domain.request.CfUserPaymentAgencyQuery;

import java.util.List;
import java.util.Map;

/**
 * 支付机构
 *
 * @ClassName CfPaymentAgencyService
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/7/007 15:43
 * @Version 1.0
 **/
public interface CfPaymentAgencyService {

    /**
     * 根据短名获取数据
     * @param shortName
     * @return
     */
    List<CfPaymentAgency> findByShortName(String shortName);

    /**
     * 根据短名获取数据
     * @param shortName
     * @param expectEmpty
     * @return
     */
    CfPaymentAgency findByShortName(String shortName, Boolean expectEmpty);

    /**
     * 获取指定停车场的支付方式(机构)数据列表
     * @param carParkId
     * @param useScenes 使用场景
     * @return
     */
    List<CfPaymentAgency> getPaymentAgencyListByCarParkId(String carParkId, String useScenes);

    public CfPaymentAgencyExample getExampleByQuery(CfPaymentAgencyQuery cfPaymentAgencyQuery);

    public List<CfPaymentAgency> getListByQuery(CfPaymentAgencyQuery cfPaymentAgencyQuery);

    public CfPaymentAgency add(CfPaymentAgency cfPaymentAgency);

    public CfPaymentAgency update(CfPaymentAgency cfPaymentAgency);

    public Integer delete(String id);

    /**
     * 根据条件查询支付机构数据列表
     * @param conditions example {"字段名":"表别名"}
     * @param allowFiledsMap example {"字段名":"表别名"}
     * @param allowFileds example {"字段名"}
     * @return
     */
    public List<CfPaymentAgency> selectListByCondition(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds);

    /**
     * 根据条件查询支付机构数据列表数
     * @param conditions example {"字段名":"表别名"}
     * @param allowFiledsMap example {"字段名":"表别名"}
     * @param allowFileds example {"字段名"}
     * @return
     */
    public Integer selectListByConditionCounts(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds);
}
