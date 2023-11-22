package com.cf.carpark.service;

import com.cf.carpark.domain.CfCarParkLinkUser;
import com.cf.carpark.domain.CfCarParkPaymentAgency;
import com.cf.carpark.domain.CfCarParkPaymentAgencyExample;
import com.cf.carpark.domain.request.CfCarParkPaymentAgencyQuery;
import com.cf.pay.domain.CfUserPaymentAgency;

import java.util.List;

/**
 * 停车场与支付机构关联管理
 *
 * @ClassName CfCarParkPaymentAgencyService
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/10/010 10:02
 * @Version 1.0
 **/
public interface CfCarParkPaymentAgencyService {

    /**
     * 根据停车场id和用户与支付机构关联表id查询停车场对应的支付配置数据
     * @param carParkId
     * @param userPaymentAgencyId
     * @return
     */
    public CfCarParkPaymentAgency findByCarParkIdAndUserPaymentAgencyId(String carParkId, String userPaymentAgencyId);

    public CfCarParkPaymentAgency add(CfCarParkPaymentAgency cfCarParkPaymentAgency);

    public CfCarParkPaymentAgency update(CfCarParkPaymentAgency cfCarParkPaymentAgency);

    public Integer delete(String id);

    public Integer deleteByQuery(CfCarParkPaymentAgencyQuery cfCarParkPaymentAgencyQuery);

    public CfCarParkPaymentAgencyExample getExampleByQuery(CfCarParkPaymentAgencyQuery cfCarParkPaymentAgencyQuery);

    public List<CfCarParkPaymentAgency> getListByQuery(CfCarParkPaymentAgencyQuery cfCarParkPaymentAgencyQuery);

    public Integer countByQuery(CfCarParkPaymentAgencyQuery cfCarParkPaymentAgencyQuery);

    public CfCarParkPaymentAgency findById(String id);

    public CfCarParkPaymentAgency findById(String id, boolean expectEmpty);

    List<CfCarParkPaymentAgency> selectByQuery(CfCarParkPaymentAgencyQuery cfCarParkPaymentAgencyQuery);

    /**
     * 根据停车场id和支付机构简称获取支付配置信息
     * @param carParkId
     * @param paymentAgency
     * @return
     */
    CfUserPaymentAgency getUserPaymentAgencyByCarParkIdAndShortName(String carParkId, String paymentAgency);

    /**
     * 检查重复数据
     * @param cfCarParkPaymentAgency
     */
    void checkRepeatData(CfCarParkPaymentAgency cfCarParkPaymentAgency);

}
