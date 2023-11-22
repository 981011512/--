package com.cf.charging.service;

import com.cf.charging.domain.CfChargingStationPaymentAgency;
import com.cf.charging.domain.CfChargingStationPaymentAgencyExample;
import com.cf.charging.domain.request.CfChargingStationPaymentAgencyQuery;

import java.util.List;

/**
 * 充电站支付账号管理服务
 */
public interface CfChargingStationPaymentAgencyService {

    CfChargingStationPaymentAgency add(CfChargingStationPaymentAgency cfChargingStationPaymentAgency);

    CfChargingStationPaymentAgency update(CfChargingStationPaymentAgency cfChargingStationPaymentAgency);

    Integer delete(String id);

    CfChargingStationPaymentAgencyExample getExampleByQuery(CfChargingStationPaymentAgencyQuery cfChargingStationPaymentAgencyQuery);

    List<CfChargingStationPaymentAgency> getListByQuery(CfChargingStationPaymentAgencyQuery cfChargingStationPaymentAgencyQuery);

    Integer countByQuery(CfChargingStationPaymentAgencyQuery cfChargingStationPaymentAgencyQuery);

}
