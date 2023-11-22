package com.cf.charging.service;

import com.cf.charging.domain.CfChargingStationDevice;
import com.cf.charging.domain.CfChargingStationDeviceExample;
import com.cf.charging.domain.request.CfChargingStationDeviceQuery;

import java.util.List;

/**
 * 充电站设备管理服务
 */
public interface CfChargingStationDeviceService {

    CfChargingStationDevice add(CfChargingStationDevice cfChargingStationDevice);

    CfChargingStationDevice update(CfChargingStationDevice cfChargingStationDevice);

    Integer delete(String id);

    CfChargingStationDevice findById(String id);

    CfChargingStationDevice findById(String id, boolean expectEmpty);

    CfChargingStationDeviceExample getExampleByQuery(CfChargingStationDeviceQuery cfChargingStationDeviceQuery);

    List<CfChargingStationDevice> getListByQuery(CfChargingStationDeviceQuery cfChargingStationDeviceQuery);

    Integer countByQuery(CfChargingStationDeviceQuery cfChargingStationDeviceQuery);
}
