package com.cf.charging.service;

import com.cf.charging.domain.CfChargingStationDeviceLinkUser;
import com.cf.charging.domain.CfChargingStationDeviceLinkUserExample;
import com.cf.charging.domain.request.CfChargingStationDeviceLinkUserQuery;

import java.util.List;

/**
 * 充电站设备关联人员管理
 */
public interface CfChargingStationDeviceLinkUserService {

    CfChargingStationDeviceLinkUser add(CfChargingStationDeviceLinkUser cfChargingStationDeviceLinkUser);

    CfChargingStationDeviceLinkUser update(CfChargingStationDeviceLinkUser cfChargingStationDeviceLinkUser);

    Integer updateByQuery(CfChargingStationDeviceLinkUser cfChargingStationDeviceLinkUser, CfChargingStationDeviceLinkUserQuery cfChargingStationDeviceLinkUserQuery);

    Integer delete(String id);

    CfChargingStationDeviceLinkUserExample getExampleByQuery(CfChargingStationDeviceLinkUserQuery cfChargingStationDeviceLinkUserQuery);

    List<CfChargingStationDeviceLinkUser> getListByQuery(CfChargingStationDeviceLinkUserQuery cfChargingStationDeviceLinkUserQuery);

    Integer countByQuery(CfChargingStationDeviceLinkUserQuery cfChargingStationDeviceLinkUserQuery);

    Integer deleteByQuery(CfChargingStationDeviceLinkUserQuery cfChargingStationDeviceLinkUserQuery);

    Integer batchAdd(List<CfChargingStationDeviceLinkUser> cfChargingStationDeviceLinkUserList);

}
