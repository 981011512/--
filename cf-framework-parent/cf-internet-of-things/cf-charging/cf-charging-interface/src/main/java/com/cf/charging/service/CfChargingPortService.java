package com.cf.charging.service;

import com.cf.charging.domain.CfChargingPort;
import com.cf.charging.domain.CfChargingPortExample;
import com.cf.charging.domain.request.CfChargingPortQuery;

import java.util.List;

/**
 * 充电站设备充电口管理服务
 */
public interface CfChargingPortService {

    CfChargingPort add(CfChargingPort cfChargingPort);

    CfChargingPort update(CfChargingPort cfChargingPort);

    Integer updateByQuery(CfChargingPort cfChargingPort, CfChargingPortQuery cfChargingPortQuery);

    Integer delete(String id);

    CfChargingPortExample getExampleByQuery(CfChargingPortQuery cfChargingPortQuery);

    List<CfChargingPort> getListByQuery(CfChargingPortQuery cfChargingPortQuery);

    Integer countByQuery(CfChargingPortQuery cfChargingPortQuery);
}
