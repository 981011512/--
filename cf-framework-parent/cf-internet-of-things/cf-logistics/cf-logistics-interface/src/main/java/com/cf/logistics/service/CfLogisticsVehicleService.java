package com.cf.logistics.service;

import com.cf.logistics.domain.CfLogisticsVehicle;
import com.cf.logistics.domain.CfLogisticsVehicleExample;
import com.cf.logistics.domain.request.CfLogisticsVehicleQuery;

import java.util.List;

public interface CfLogisticsVehicleService {

    CfLogisticsVehicle add(CfLogisticsVehicle cfLogisticsVehicle);

    CfLogisticsVehicle update(CfLogisticsVehicle cfLogisticsVehicle);

    Integer delete(Long id);

    CfLogisticsVehicle findById(Long id);

    CfLogisticsVehicle findById(Long id, boolean expect);

    CfLogisticsVehicleExample getExampleByQuer(CfLogisticsVehicleQuery cfLogisticsVehicleQuery);

    List<CfLogisticsVehicle> getListByQuery(CfLogisticsVehicleQuery cfLogisticsVehicleQuery);

    Integer countByQuery(CfLogisticsVehicleQuery cfLogisticsVehicleQuery);

    /**
     * 同步TMS物流系统车辆信息
     */
    List<CfLogisticsVehicle> synchronizeTmsVehicle()throws Exception;

}
