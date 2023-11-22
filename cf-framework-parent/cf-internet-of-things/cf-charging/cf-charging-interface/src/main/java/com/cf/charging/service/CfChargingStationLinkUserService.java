package com.cf.charging.service;

import com.cf.charging.domain.CfChargingStationLinkUser;
import com.cf.charging.domain.CfChargingStationLinkUserExample;
import com.cf.charging.domain.request.CfChargingStationLinkUserQuery;

import java.util.List;

/**
 * 充电站关联用户管理服务
 */
public interface CfChargingStationLinkUserService {

    CfChargingStationLinkUser add(CfChargingStationLinkUser cfChargingStationLinkUser);

    CfChargingStationLinkUser update(CfChargingStationLinkUser cfChargingStationLinkUser);

    Integer delete(String id);

    CfChargingStationLinkUserExample getExampleByQuery(CfChargingStationLinkUserQuery cfChargingStationLinkUserQuery);

    List<CfChargingStationLinkUser> getListByQuery(CfChargingStationLinkUserQuery cfChargingStationLinkUserQuery);

    Integer countByQuery(CfChargingStationLinkUserQuery cfChargingStationLinkUserQuery);
}
