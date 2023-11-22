package com.cf.logistics.service;

import com.cf.logistics.domain.CfLogisticsQueue;
import com.cf.logistics.domain.CfLogisticsQueueExample;
import com.cf.logistics.domain.request.CfLogisticsQueueQuery;

import java.util.List;

public interface CfLogisticsQueueService {

    CfLogisticsQueue add(CfLogisticsQueue cfLogisticsQueue);

    CfLogisticsQueue update(CfLogisticsQueue cfLogisticsQueue);

    int updateByQuery(CfLogisticsQueue cfLogisticsQueue, CfLogisticsQueueQuery cfLogisticsQueueQuery);

    int delete(Long id);

    CfLogisticsQueue findById(Long id);

    CfLogisticsQueue findById(Long id, boolean expectEmpy);

    List<CfLogisticsQueue> getListByQuery(CfLogisticsQueueQuery cfLogisticsQueueQuery);

    Integer countByQuery(CfLogisticsQueueQuery cfLogisticsQueueQuery);

    CfLogisticsQueueExample getExampleByQuery(CfLogisticsQueueQuery cfLogisticsQueueQuery);
    
}
