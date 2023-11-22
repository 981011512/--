package com.cf.charging.service.impl;

import com.cf.charging.service.CfChargingStationDeviceTypeService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfChargingStationDeviceTypeServiceImpl implements CfChargingStationDeviceTypeService {
}
