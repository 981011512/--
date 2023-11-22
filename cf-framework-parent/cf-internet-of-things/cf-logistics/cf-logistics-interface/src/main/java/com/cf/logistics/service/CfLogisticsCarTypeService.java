package com.cf.logistics.service;

import com.cf.logistics.domain.CfLogisticsCarType;
import com.cf.logistics.domain.CfLogisticsCarTypeExample;
import com.cf.logistics.domain.request.CfLogisticsCarTypeQuery;

import java.util.List;

public interface CfLogisticsCarTypeService {

    CfLogisticsCarType add(CfLogisticsCarType CfLogisticsCarType);

    CfLogisticsCarType update(CfLogisticsCarType CfLogisticsCarType);

    int updateByQuery(CfLogisticsCarType CfLogisticsCarType, CfLogisticsCarTypeQuery CfLogisticsCarTypeQuery);

    int delete(Long id);

    CfLogisticsCarType findById(Long id);

    CfLogisticsCarType findById(Long id, boolean expectEmpy);

    List<CfLogisticsCarType> getListByQuery(CfLogisticsCarTypeQuery CfLogisticsCarTypeQuery);

    Integer countByQuery(CfLogisticsCarTypeQuery CfLogisticsCarTypeQuery);

    CfLogisticsCarTypeExample getExampleByQuery(CfLogisticsCarTypeQuery CfLogisticsCarTypeQuery);
    
}
