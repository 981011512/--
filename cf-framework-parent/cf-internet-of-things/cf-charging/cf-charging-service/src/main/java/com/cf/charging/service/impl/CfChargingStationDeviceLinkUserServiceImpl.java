package com.cf.charging.service.impl;

import com.cf.charging.dao.mapper.CfChargingStationDeviceLinkUserMapper;
import com.cf.charging.domain.CfChargingStationDeviceLinkUser;
import com.cf.charging.domain.CfChargingStationDeviceLinkUserExample;
import com.cf.charging.domain.request.CfChargingStationDeviceLinkUserQuery;
import com.cf.charging.service.CfChargingStationDeviceLinkUserService;
import com.cf.framework.utils.IdWorker;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfChargingStationDeviceLinkUserServiceImpl implements CfChargingStationDeviceLinkUserService {

    @Autowired
    private CfChargingStationDeviceLinkUserMapper cfChargingStationDeviceLinkUserMapper;
    @Autowired
    private IdWorker idWorker;

    @Override
    public CfChargingStationDeviceLinkUser add(CfChargingStationDeviceLinkUser cfChargingStationDeviceLinkUser) {
        cfChargingStationDeviceLinkUser.setId(idWorker.nextId());
        cfChargingStationDeviceLinkUserMapper.insertSelective(cfChargingStationDeviceLinkUser);
        return cfChargingStationDeviceLinkUser;
    }

    @Override
    public CfChargingStationDeviceLinkUser update(CfChargingStationDeviceLinkUser cfChargingStationDeviceLinkUser) {
        cfChargingStationDeviceLinkUserMapper.updateByPrimaryKeySelective(cfChargingStationDeviceLinkUser);
        return cfChargingStationDeviceLinkUser;
    }

    @Override
    public Integer updateByQuery(CfChargingStationDeviceLinkUser cfChargingStationDeviceLinkUser, CfChargingStationDeviceLinkUserQuery cfChargingStationDeviceLinkUserQuery) {
        return cfChargingStationDeviceLinkUserMapper.updateByExampleSelective(cfChargingStationDeviceLinkUser, getExampleByQuery(cfChargingStationDeviceLinkUserQuery));
    }

    @Override
    public Integer delete(String id) {
        return cfChargingStationDeviceLinkUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public CfChargingStationDeviceLinkUserExample getExampleByQuery(CfChargingStationDeviceLinkUserQuery cfChargingStationDeviceLinkUserQuery) {
        CfChargingStationDeviceLinkUserExample cfChargingStationDeviceLinkUserExample = new CfChargingStationDeviceLinkUserExample();
        CfChargingStationDeviceLinkUserExample.Criteria criteria = cfChargingStationDeviceLinkUserExample.createCriteria();

        if(cfChargingStationDeviceLinkUserQuery.getChargingStationId()!=null){
            criteria.andChargingStationIdEqualTo(cfChargingStationDeviceLinkUserQuery.getChargingStationId());
        }
        if(cfChargingStationDeviceLinkUserQuery.getUid()!=null){
            criteria.andUidEqualTo(cfChargingStationDeviceLinkUserQuery.getUid());
        }
        if(cfChargingStationDeviceLinkUserQuery.getDeviceId()!=null){
            criteria.andDeviceIdEqualTo(cfChargingStationDeviceLinkUserQuery.getDeviceId());
        }

        if(StringUtils.isNotEmpty(cfChargingStationDeviceLinkUserQuery.getOrderBy())){
            cfChargingStationDeviceLinkUserExample.setOrderByClause(cfChargingStationDeviceLinkUserQuery.getOrderBy());
        }
        if(cfChargingStationDeviceLinkUserQuery.getPage()!=null && cfChargingStationDeviceLinkUserQuery.getSize()!=null){
            PageHelper.startPage(cfChargingStationDeviceLinkUserQuery.getPage(), cfChargingStationDeviceLinkUserQuery.getSize());
        }
        return cfChargingStationDeviceLinkUserExample;
    }

    @Override
    public List<CfChargingStationDeviceLinkUser> getListByQuery(CfChargingStationDeviceLinkUserQuery cfChargingStationDeviceLinkUserQuery) {
        return cfChargingStationDeviceLinkUserMapper.selectByExample(getExampleByQuery(cfChargingStationDeviceLinkUserQuery));
    }

    @Override
    public Integer countByQuery(CfChargingStationDeviceLinkUserQuery cfChargingStationDeviceLinkUserQuery) {
        cfChargingStationDeviceLinkUserQuery.setPage(null);
        return cfChargingStationDeviceLinkUserMapper.countByExample(getExampleByQuery(cfChargingStationDeviceLinkUserQuery));
    }

    @Override
    public Integer deleteByQuery(CfChargingStationDeviceLinkUserQuery cfChargingStationDeviceLinkUserQuery) {
        return cfChargingStationDeviceLinkUserMapper.deleteByExample(getExampleByQuery(cfChargingStationDeviceLinkUserQuery));
    }

    @Override
    public Integer batchAdd(List<CfChargingStationDeviceLinkUser> cfChargingStationDeviceLinkUserList) {
        String batchAddLinkSQL = "insert into cf_charging_station_device_link_user (id, device_id, uid, charging_station_id) values ";
        for(CfChargingStationDeviceLinkUser cfChargingStationDeviceLinkUser: cfChargingStationDeviceLinkUserList){
            batchAddLinkSQL += "('"+idWorker.nextId()+"','"+cfChargingStationDeviceLinkUser.getDeviceId()+"','"+cfChargingStationDeviceLinkUser.getUid()+"','"+cfChargingStationDeviceLinkUser.getChargingStationId()+"'),";
        }
        batchAddLinkSQL = batchAddLinkSQL.substring(0, batchAddLinkSQL.length()-1);
        return cfChargingStationDeviceLinkUserMapper.batchAdd(batchAddLinkSQL);
    }
}
