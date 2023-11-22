package com.cf.charging.service;

import com.cf.charging.domain.CfChargingStationRules;
import com.cf.charging.domain.CfChargingStationRulesExample;
import com.cf.charging.domain.request.CfChargingStationRulesQuery;

import java.util.List;

/**
 * 充电站收费规则管理服务
 */
public interface CfChargingStationRulesService {

    CfChargingStationRules add(CfChargingStationRules cfChargingStationRules) throws Exception;

    CfChargingStationRules update(CfChargingStationRules cfChargingStationRules) throws Exception;

    Integer delete(String id);

    CfChargingStationRulesExample getExampleByQuery(CfChargingStationRulesQuery cfChargingStationRulesQuery);

    List<CfChargingStationRules> getListByQuery(CfChargingStationRulesQuery cfChargingStationRulesQuery);

    Integer countByQuery(CfChargingStationRulesQuery cfChargingStationRulesQuery);

    CfChargingStationRules validAndHandleChargingRulesStartEndTime(CfChargingStationRules cfChargingStationRules);

}
