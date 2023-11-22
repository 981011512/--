package com.cf.logistics.service;

import com.cf.logistics.domain.CfLogisticsStorehouse;
import com.cf.logistics.domain.CfLogisticsStorehouseExample;
import com.cf.logistics.domain.request.CfLogisticsStorehouseQuery;

import java.util.List;

public interface CfLogisticsStorehouseService {

    CfLogisticsStorehouse add(CfLogisticsStorehouse cfLogisticsStorehouse);

    CfLogisticsStorehouse update(CfLogisticsStorehouse cfLogisticsStorehouse);

    int updateByQuery(CfLogisticsStorehouse cfLogisticsStorehouse, CfLogisticsStorehouseQuery cfLogisticsStorehouseQuery);

    int delete(Long id);

    CfLogisticsStorehouse findById(Long id);

    CfLogisticsStorehouse findById(Long id, boolean expectEmpy);

    List<CfLogisticsStorehouse> getListByQuery(CfLogisticsStorehouseQuery cfLogisticsStorehouseQuery);

    Integer countByQuery(CfLogisticsStorehouseQuery cfLogisticsStorehouseQuery);

    CfLogisticsStorehouseExample getExampleByQuery(CfLogisticsStorehouseQuery cfLogisticsStorehouseQuery);

    /**
     * 获取附近的物流仓库
     * @param cfLogisticsStorehouseQuery
     * @return
     */
    List<CfLogisticsStorehouse> selectNearLogisticsStorehouse(CfLogisticsStorehouseQuery cfLogisticsStorehouseQuery);

    /**
     * 根据Query条件查询仓库数据，会联表查询工厂数据
     * @param cfLogisticsStorehouseQuery
     * @return
     */
    List<CfLogisticsStorehouse> selectListByQuery(CfLogisticsStorehouseQuery cfLogisticsStorehouseQuery);


}
