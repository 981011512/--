package com.cf.charging.service.impl;

import com.cf.charging.dao.mapper.CfChargingStationLinkUserMapper;
import com.cf.charging.domain.CfChargingStationDevice;
import com.cf.charging.domain.CfChargingStationDeviceLinkUser;
import com.cf.charging.domain.CfChargingStationLinkUser;
import com.cf.charging.domain.CfChargingStationLinkUserExample;
import com.cf.charging.domain.request.CfChargingStationDeviceLinkUserQuery;
import com.cf.charging.domain.request.CfChargingStationDeviceQuery;
import com.cf.charging.domain.request.CfChargingStationLinkUserQuery;
import com.cf.charging.service.CfChargingStationDeviceLinkUserService;
import com.cf.charging.service.CfChargingStationDeviceService;
import com.cf.charging.service.CfChargingStationLinkUserService;
import com.cf.framework.utils.IdWorker;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfChargingStationLinkUserServiceImpl implements CfChargingStationLinkUserService {

    @Autowired
    private CfChargingStationLinkUserMapper cfChargingStationLinkUserMapper;
    @Autowired
    private CfChargingStationDeviceLinkUserService cfChargingStationDeviceLinkUserService;
    @Autowired
    private CfChargingStationDeviceService cfChargingStationDeviceService;
    @Autowired
    private IdWorker idWorker;

    @Override
    public CfChargingStationLinkUser add(CfChargingStationLinkUser cfChargingStationLinkUser) {
        cfChargingStationLinkUser.setId(idWorker.nextId());
        cfChargingStationLinkUserMapper.insertSelective(cfChargingStationLinkUser);
        updateDeviceLinkers(cfChargingStationLinkUser);
        return cfChargingStationLinkUser;
    }

    @Override
    public CfChargingStationLinkUser update(CfChargingStationLinkUser cfChargingStationLinkUser) {
        cfChargingStationLinkUserMapper.updateByPrimaryKeySelective(cfChargingStationLinkUser);
        updateDeviceLinkers(cfChargingStationLinkUser);
        return cfChargingStationLinkUser;
    }

    @Override
    public Integer delete(String id) {
        CfChargingStationLinkUserQuery cfChargingStationLinkUserQuery = new CfChargingStationLinkUserQuery();
        cfChargingStationLinkUserQuery.setId(id);
        List<CfChargingStationLinkUser> cfChargingStationLinkUsers = getListByQuery(cfChargingStationLinkUserQuery);
        if(cfChargingStationLinkUsers==null || cfChargingStationLinkUsers.size()==0){
            return 0;
        }
        cfChargingStationLinkUsers.get(0).setId(null);
        updateDeviceLinkers(cfChargingStationLinkUsers.get(0));
        return cfChargingStationLinkUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public CfChargingStationLinkUserExample getExampleByQuery(CfChargingStationLinkUserQuery cfChargingStationLinkUserQuery) {
        CfChargingStationLinkUserExample cfChargingStationLinkUserExample = new CfChargingStationLinkUserExample();
        CfChargingStationLinkUserExample.Criteria criteria = cfChargingStationLinkUserExample.createCriteria();

        if(StringUtils.isNotEmpty(cfChargingStationLinkUserQuery.getChargingStationId())){
            criteria.andChargingStationIdEqualTo(cfChargingStationLinkUserQuery.getChargingStationId());
        }
        if(StringUtils.isNotEmpty(cfChargingStationLinkUserQuery.getUid())){
            criteria.andUidEqualTo(cfChargingStationLinkUserQuery.getUid());
        }
        if(cfChargingStationLinkUserQuery.getAllowDelete()!=null){
            criteria.andAllowDeleteEqualTo(cfChargingStationLinkUserQuery.getAllowDelete());
        }
        if(cfChargingStationLinkUserQuery.getAllowEdit()!=null){
            criteria.andAllowEditEqualTo(cfChargingStationLinkUserQuery.getAllowEdit());
        }

        if(StringUtils.isNotEmpty(cfChargingStationLinkUserQuery.getOrderBy())){
            cfChargingStationLinkUserExample.setOrderByClause(cfChargingStationLinkUserQuery.getOrderBy());
        }
        if(cfChargingStationLinkUserQuery.getPage()!=null && cfChargingStationLinkUserQuery.getSize()!=null){
            PageHelper.startPage(cfChargingStationLinkUserQuery.getPage(), cfChargingStationLinkUserQuery.getSize());
        }
        return cfChargingStationLinkUserExample;
    }

    @Override
    public List<CfChargingStationLinkUser> getListByQuery(CfChargingStationLinkUserQuery cfChargingStationLinkUserQuery) {
        return cfChargingStationLinkUserMapper.selectByExample(getExampleByQuery(cfChargingStationLinkUserQuery));
    }

    @Override
    public Integer countByQuery(CfChargingStationLinkUserQuery cfChargingStationLinkUserQuery) {
        cfChargingStationLinkUserQuery.setPage(null);
        return cfChargingStationLinkUserMapper.countByExample(getExampleByQuery(cfChargingStationLinkUserQuery));
    }

    private void updateDeviceLinkers(CfChargingStationLinkUser cfChargingStationLinkUser){
        //先删掉所有
        CfChargingStationDeviceLinkUserQuery cfChargingStationDeviceLinkUserQuery = new CfChargingStationDeviceLinkUserQuery();
        cfChargingStationDeviceLinkUserQuery.setChargingStationId(cfChargingStationLinkUser.getChargingStationId());
        cfChargingStationDeviceLinkUserQuery.setUid(cfChargingStationLinkUser.getUid());
        cfChargingStationDeviceLinkUserService.deleteByQuery(cfChargingStationDeviceLinkUserQuery);

        if(cfChargingStationLinkUser.getId()==null){
            //表示删除
            return;
        }

        //查询该充电站下所有的硬件
        CfChargingStationDeviceQuery cfChargingStationDeviceQuery = new CfChargingStationDeviceQuery();
        cfChargingStationDeviceQuery.setChargingStationId(cfChargingStationLinkUser.getChargingStationId());
        List<CfChargingStationDevice> cfChargingStationDevices = cfChargingStationDeviceService.getListByQuery(cfChargingStationDeviceQuery);

        if(cfChargingStationDevices!=null && cfChargingStationDevices.size()>0){
            //重新增加
            List<CfChargingStationDeviceLinkUser> cfChargingStationDeviceLinkUserList = new ArrayList<>();
            for (CfChargingStationDevice cfChargingStationDevice: cfChargingStationDevices){
                CfChargingStationDeviceLinkUser cfChargingStationDeviceLinkUser = new CfChargingStationDeviceLinkUser();
                cfChargingStationDeviceLinkUser.setDeviceId(cfChargingStationDevice.getId());
                cfChargingStationDeviceLinkUser.setChargingStationId(cfChargingStationDevice.getChargingStationId());
                cfChargingStationDeviceLinkUser.setUid(cfChargingStationLinkUser.getUid());
                cfChargingStationDeviceLinkUserList.add(cfChargingStationDeviceLinkUser);
            }
            cfChargingStationDeviceLinkUserService.batchAdd(cfChargingStationDeviceLinkUserList);
        }

    }
}
