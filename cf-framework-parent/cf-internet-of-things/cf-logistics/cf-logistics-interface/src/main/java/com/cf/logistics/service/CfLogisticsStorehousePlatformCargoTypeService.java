package com.cf.logistics.service;

import com.cf.logistics.domain.CfLogisticsStorehousePlatformCargoType;
import com.cf.logistics.domain.CfLogisticsStorehousePlatformCargoTypeExample;
import com.cf.logistics.domain.request.CfLogisticsStorehousePlatformCargoTypeQuery;

import java.util.List;

public interface CfLogisticsStorehousePlatformCargoTypeService {

    CfLogisticsStorehousePlatformCargoType add(CfLogisticsStorehousePlatformCargoType cfLogisticsStorehousePlatformCargoType);

    CfLogisticsStorehousePlatformCargoType update(CfLogisticsStorehousePlatformCargoType cfLogisticsStorehousePlatformCargoType);

    Integer delete(Long id);

    Integer deleteByQuery(CfLogisticsStorehousePlatformCargoTypeQuery cfLogisticsStorehousePlatformCargoTypeQuery);

    List<CfLogisticsStorehousePlatformCargoType> getListByQuery(CfLogisticsStorehousePlatformCargoTypeQuery cfLogisticsStorehousePlatformCargoTypeQuery);

    Integer countByQuery(CfLogisticsStorehousePlatformCargoTypeQuery cfLogisticsStorehousePlatformCargoTypeQuery);

    CfLogisticsStorehousePlatformCargoTypeExample getExampleByQuery(CfLogisticsStorehousePlatformCargoTypeQuery cfLogisticsStorehousePlatformCargoTypeQuery);
}
