package com.cf.logistics.service;

import com.cf.logistics.domain.CfLogisticsStorehouseLinkUser;
import com.cf.logistics.domain.CfLogisticsStorehouseLinkUserExample;
import com.cf.logistics.domain.request.CfLogisticsStorehouseLinkUserQuery;

import java.util.List;

public interface CfLogisticsStorehouseLinkUserService {

    CfLogisticsStorehouseLinkUser add(CfLogisticsStorehouseLinkUser cfLogisticsStorehouseLinkUser);

    CfLogisticsStorehouseLinkUser update(CfLogisticsStorehouseLinkUser cfLogisticsStorehouseLinkUser);

    int updateByQuery(CfLogisticsStorehouseLinkUser CfLogisticsStorehouseLinkUser, CfLogisticsStorehouseLinkUserQuery cfLogisticsStorehouseLinkUserQuery);

    int delete(Long id);

    CfLogisticsStorehouseLinkUser findById(Long id);

    CfLogisticsStorehouseLinkUser findById(Long id, boolean expectEmpy);

    List<CfLogisticsStorehouseLinkUser> getListByQuery(CfLogisticsStorehouseLinkUserQuery cfLogisticsStorehouseLinkUserQuery);

    List<CfLogisticsStorehouseLinkUser> selectListByQuery(CfLogisticsStorehouseLinkUserQuery cfLogisticsStorehouseLinkUserQuery);

    Integer countByQuery(CfLogisticsStorehouseLinkUserQuery cfLogisticsStorehouseLinkUserQuery);

    CfLogisticsStorehouseLinkUserExample getExampleByQuery(CfLogisticsStorehouseLinkUserQuery cfLogisticsStorehouseLinkUserQuery);

    /**
     * 检查是否有重复添加
     * @param cfLogisticsStorehouseLinkUser
     */
    void checkRepeat(CfLogisticsStorehouseLinkUser cfLogisticsStorehouseLinkUser);
    
}
