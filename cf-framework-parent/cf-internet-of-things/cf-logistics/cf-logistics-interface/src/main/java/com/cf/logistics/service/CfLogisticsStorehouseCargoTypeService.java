package com.cf.logistics.service;

import com.cf.logistics.domain.CfLogisticsStorehouseCargoType;
import com.cf.logistics.domain.CfLogisticsStorehouseCargoTypeExample;
import com.cf.logistics.domain.request.CfLogisticsStorehouseCargoTypeQuery;

import java.util.List;

public interface CfLogisticsStorehouseCargoTypeService {

    CfLogisticsStorehouseCargoType add(CfLogisticsStorehouseCargoType cfLogisticsStorehouseCargoType);

    CfLogisticsStorehouseCargoType update(CfLogisticsStorehouseCargoType cfLogisticsStorehouseCargoType);

    Integer delete(Long id);

    Integer deleteByQuery(CfLogisticsStorehouseCargoTypeQuery cfLogisticsStorehouseCargoTypeQuery);

    List<CfLogisticsStorehouseCargoType> getListByQuery(CfLogisticsStorehouseCargoTypeQuery cfLogisticsStorehouseCargoTypeQuery);

    Integer countByQuery(CfLogisticsStorehouseCargoTypeQuery cfLogisticsStorehouseCargoTypeQuery);

    CfLogisticsStorehouseCargoTypeExample getExampleByQuery(CfLogisticsStorehouseCargoTypeQuery cfLogisticsStorehouseCargoTypeQuery);

}
