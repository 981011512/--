package com.cf.logistics.service;

import com.cf.logistics.domain.CfLogisticsStorehousePlatform;
import com.cf.logistics.domain.CfLogisticsStorehousePlatformExample;
import com.cf.logistics.domain.request.CfLogisticsStorehousePlatformQuery;

import java.util.List;

public interface CfLogisticsStorehousePlatformService {

    CfLogisticsStorehousePlatform add(CfLogisticsStorehousePlatform CfLogisticsStorehousePlatform);

    CfLogisticsStorehousePlatform update(CfLogisticsStorehousePlatform CfLogisticsStorehousePlatform);

    int updateByQuery(CfLogisticsStorehousePlatform CfLogisticsStorehousePlatform, CfLogisticsStorehousePlatformQuery CfLogisticsStorehousePlatformQuery);

    int delete(Long id);

    CfLogisticsStorehousePlatform findById(Long id);

    CfLogisticsStorehousePlatform findById(Long id, boolean expectEmpy);

    List<CfLogisticsStorehousePlatform> getListByQuery(CfLogisticsStorehousePlatformQuery CfLogisticsStorehousePlatformQuery);

    Integer countByQuery(CfLogisticsStorehousePlatformQuery CfLogisticsStorehousePlatformQuery);

    CfLogisticsStorehousePlatformExample getExampleByQuery(CfLogisticsStorehousePlatformQuery CfLogisticsStorehousePlatformQuery);
}
