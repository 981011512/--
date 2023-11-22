package com.cf.logistics.service;

import com.cf.logistics.domain.CfLogisticsFactory;
import com.cf.logistics.domain.CfLogisticsFactoryExample;
import com.cf.logistics.domain.request.CfLogisticsFactoryQuery;

import java.util.List;

public interface CfLogisticsFactoryService {

    CfLogisticsFactory add(CfLogisticsFactory cfLogisticsFactory);

    CfLogisticsFactory update(CfLogisticsFactory cfLogisticsFactory);

    Integer delete(Long id);

    CfLogisticsFactory findById(Long id);

    CfLogisticsFactory findById(Long id, boolean expectEmpty);

    CfLogisticsFactoryExample getExampleByQuery(CfLogisticsFactoryQuery cfLogisticsFactoryQuery);

    List<CfLogisticsFactory> getListByQuery(CfLogisticsFactoryQuery cfLogisticsFactoryQuery);

    Integer countByQuery(CfLogisticsFactoryQuery cfLogisticsFactoryQuery);

    /**
     * 获取附近的物流工厂
     * @param cfLogisticsFactoryQuery
     * @return
     */
    List<CfLogisticsFactory> selectNearLogisticsFactory(CfLogisticsFactoryQuery cfLogisticsFactoryQuery);

}
