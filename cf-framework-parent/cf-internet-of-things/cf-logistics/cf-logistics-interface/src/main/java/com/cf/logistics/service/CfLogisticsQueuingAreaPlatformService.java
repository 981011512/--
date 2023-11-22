package com.cf.logistics.service;

import com.cf.logistics.domain.CfLogisticsQueuingAreaPlatform;
import com.cf.logistics.domain.CfLogisticsQueuingAreaPlatformExample;
import com.cf.logistics.domain.request.CfLogisticsQueuingAreaPlatformQuery;

import java.util.List;

public interface CfLogisticsQueuingAreaPlatformService {

    CfLogisticsQueuingAreaPlatform add(CfLogisticsQueuingAreaPlatform cfLogisticsQueuingAreaPlatform);

    CfLogisticsQueuingAreaPlatform update(CfLogisticsQueuingAreaPlatform cfLogisticsQueuingAreaPlatform);

    Integer delete(Long id);

    CfLogisticsQueuingAreaPlatform findById(Long id);

    CfLogisticsQueuingAreaPlatform findById(Long id, boolean expectEmpty);

    CfLogisticsQueuingAreaPlatformExample getExampleByQuery(CfLogisticsQueuingAreaPlatformQuery cfLogisticsQueuingAreaPlatformQuery);

    List<CfLogisticsQueuingAreaPlatform> getListByQuery(CfLogisticsQueuingAreaPlatformQuery cfLogisticsQueuingAreaPlatformQuery);

    Integer countByQuery(CfLogisticsQueuingAreaPlatformQuery cfLogisticsQueuingAreaPlatformQuery);

    List<CfLogisticsQueuingAreaPlatform> selectByQuery(CfLogisticsQueuingAreaPlatformQuery cfLogisticsQueuingAreaPlatformQuery);

}
