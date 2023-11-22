package com.cf.logistics.service;

import com.cf.logistics.domain.CfLogisticsCargoType;
import com.cf.logistics.domain.CfLogisticsCargoTypeExample;
import com.cf.logistics.domain.request.CfLogisticsCargoTypeQuery;

import java.util.List;

public interface CfLogisticsCargoTypeService {

    CfLogisticsCargoType add(CfLogisticsCargoType cfLogisticsCargoType);

    CfLogisticsCargoType update(CfLogisticsCargoType cfLogisticsCargoType);

    int updateByQuery(CfLogisticsCargoType cfLogisticsCargoType, CfLogisticsCargoTypeQuery cfLogisticsCargoTypeQuery);

    int delete(Long id);

    CfLogisticsCargoType findById(Long id);

    CfLogisticsCargoType findById(Long id, boolean expectEmpy);

    List<CfLogisticsCargoType> getListByQuery(CfLogisticsCargoTypeQuery cfLogisticsCargoTypeQuery);

    Integer countByQuery(CfLogisticsCargoTypeQuery cfLogisticsCargoTypeQuery);

    CfLogisticsCargoTypeExample getExampleByQuery(CfLogisticsCargoTypeQuery cfLogisticsCargoTypeQuery);
}
