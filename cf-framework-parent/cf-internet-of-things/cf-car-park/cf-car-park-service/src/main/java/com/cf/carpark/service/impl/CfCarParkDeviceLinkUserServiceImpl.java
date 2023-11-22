package com.cf.carpark.service.impl;

import com.cf.carpark.dao.mapper.CfCarParkDeviceLinkUserMapper;
import com.cf.carpark.domain.CfCarParkDeviceLinkUser;
import com.cf.carpark.domain.CfCarParkDeviceLinkUserExample;
import com.cf.carpark.domain.request.CfCarParkDeviceLinkUserQuery;
import com.cf.carpark.service.CfCarParkDeviceLinkUserService;
import com.cf.framework.utils.IdWorker;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfCarParkDeviceLinkUserServiceImpl implements CfCarParkDeviceLinkUserService {

    @Autowired
    private CfCarParkDeviceLinkUserMapper cfCarParkDeviceLinkUserMapper;
    @Autowired
    private IdWorker idWorker;

    @Override
    public CfCarParkDeviceLinkUser add(CfCarParkDeviceLinkUser cfCarParkDeviceLinkUser) {
        cfCarParkDeviceLinkUser.setId(idWorker.nextId());
        cfCarParkDeviceLinkUserMapper.insert(cfCarParkDeviceLinkUser);
        return cfCarParkDeviceLinkUser;
    }

    @Override
    public Integer batchAdd(List<CfCarParkDeviceLinkUser> cfCarParkDeviceLinkUsers) {
        String batchAddLinkSQL = "insert into cf_car_park_device_link_user (id, device_id, check_point_id, uid, car_park_id) values ";
        for(CfCarParkDeviceLinkUser cfCarParkDeviceLinkUser: cfCarParkDeviceLinkUsers){
            batchAddLinkSQL += "('"+idWorker.nextId()+"','"+cfCarParkDeviceLinkUser.getDeviceId()+"','"+cfCarParkDeviceLinkUser.getCheckPointId()+"','"+cfCarParkDeviceLinkUser.getUid()+"','"+cfCarParkDeviceLinkUser.getCarParkId()+"'),";
        }
        batchAddLinkSQL = batchAddLinkSQL.substring(0, batchAddLinkSQL.length()-1);
        return cfCarParkDeviceLinkUserMapper.batchAdd(batchAddLinkSQL);
    }

    @Override
    public Integer deleteByQuery(CfCarParkDeviceLinkUserQuery cfCarParkDeviceLinkUserQuery) {
        return cfCarParkDeviceLinkUserMapper.deleteByExample(getExampleByQuery(cfCarParkDeviceLinkUserQuery));
    }

    @Override
    public List<CfCarParkDeviceLinkUser> getListByQuery(CfCarParkDeviceLinkUserQuery cfCarParkDeviceLinkUserQuery) {
        return cfCarParkDeviceLinkUserMapper.selectByExample(getExampleByQuery(cfCarParkDeviceLinkUserQuery));
    }

    @Override
    public CfCarParkDeviceLinkUserExample getExampleByQuery(CfCarParkDeviceLinkUserQuery cfCarParkDeviceLinkUserQuery) {
        CfCarParkDeviceLinkUserExample cfCarParkDeviceLinkUserExample = new CfCarParkDeviceLinkUserExample();
        CfCarParkDeviceLinkUserExample.Criteria criteria = cfCarParkDeviceLinkUserExample.createCriteria();
        if(cfCarParkDeviceLinkUserQuery.getDeviceId()!=null){
            criteria.andDeviceIdEqualTo(cfCarParkDeviceLinkUserQuery.getDeviceId());
        }
        if(cfCarParkDeviceLinkUserQuery.getCheckPointId()!=null){
            criteria.andCheckPointIdEqualTo(cfCarParkDeviceLinkUserQuery.getCheckPointId());
        }
        if(cfCarParkDeviceLinkUserQuery.getUid()!=null){
            criteria.andUidEqualTo(cfCarParkDeviceLinkUserQuery.getUid());
        }
        if(cfCarParkDeviceLinkUserQuery.getCarParkId()!=null){
            criteria.andCarParkIdEqualTo(cfCarParkDeviceLinkUserQuery.getCarParkId());
        }
        if(cfCarParkDeviceLinkUserQuery.getDeviceIds()!=null && cfCarParkDeviceLinkUserQuery.getDeviceIds().size()>0){
            criteria.andDeviceIdIn(cfCarParkDeviceLinkUserQuery.getDeviceIds());
        }
        return cfCarParkDeviceLinkUserExample;
    }
}
