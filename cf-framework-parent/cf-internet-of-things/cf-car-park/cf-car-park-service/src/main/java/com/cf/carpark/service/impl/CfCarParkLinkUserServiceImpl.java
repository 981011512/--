package com.cf.carpark.service.impl;

import com.cf.carpark.dao.mapper.CfCarParkLinkUserMapper;
import com.cf.carpark.domain.*;
import com.cf.carpark.domain.request.CfCarParkDeviceLinkUserQuery;
import com.cf.carpark.domain.request.CfCarParkDeviceQuery;
import com.cf.carpark.domain.request.CfCarParkLinkUserQuery;
import com.cf.carpark.domain.type.ActionType;
import com.cf.carpark.service.CfCarParkDeviceLinkUserService;
import com.cf.carpark.service.CfCarParkDeviceService;
import com.cf.carpark.service.CfCarParkLinkUserService;
import com.cf.framework.domain.carpark.response.CarParkCode;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.IdWorker;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfCarParkLinkUserServiceImpl implements CfCarParkLinkUserService {

    @Autowired
    private CfCarParkLinkUserMapper cfCarParkLinkUserMapper;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private CfCarParkDeviceLinkUserService cfCarParkDeviceLinkUserService;
    @Autowired
    private CfCarParkDeviceService cfCarParkDeviceService;

    @Override
    public CfCarParkLinkUser add(CfCarParkLinkUser cfCarParkLinkUser) {
        checkRepeatData(cfCarParkLinkUser);
        if(cfCarParkLinkUser.getCheckPointIds()==null){
            cfCarParkLinkUser.setCheckPointIds("");
        }
        updateDeviceLinkers(cfCarParkLinkUser);
        cfCarParkLinkUser.setId(idWorker.nextId());
        cfCarParkLinkUserMapper.insert(cfCarParkLinkUser);
        return cfCarParkLinkUser;
    }

    @Override
    public Integer delete(String id) {
        CfCarParkLinkUser cfCarParkLinkUser = findById(id, false);
        cfCarParkLinkUser.setId(null);
        updateDeviceLinkers(cfCarParkLinkUser);
        return cfCarParkLinkUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer deleteByQuery(CfCarParkLinkUserQuery cfCarParkLinkUserQuery) {
        return cfCarParkLinkUserMapper.deleteByExample(getExampleByQuery(cfCarParkLinkUserQuery));
    }

    @Override
    public CfCarParkLinkUser update(CfCarParkLinkUser cfCarParkLinkUser) {
        checkRepeatData(cfCarParkLinkUser);
        if(cfCarParkLinkUser.getCheckPointIds()==null){
            cfCarParkLinkUser.setCheckPointIds("");
        }
        updateDeviceLinkers(cfCarParkLinkUser);
        cfCarParkLinkUserMapper.updateByPrimaryKey(cfCarParkLinkUser);
        return cfCarParkLinkUser;
    }

    @Override
    public Integer updateByQuery(CfCarParkLinkUser cfCarParkLinkUser, CfCarParkLinkUserQuery cfCarParkLinkUserQuery) {
        return cfCarParkLinkUserMapper.updateByExampleSelective(cfCarParkLinkUser, getExampleByQuery(cfCarParkLinkUserQuery));
    }

    @Override
    public CfCarParkLinkUser findById(String id) {
        return cfCarParkLinkUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public CfCarParkLinkUser findById(String id, boolean expectEmpty) {
        CfCarParkLinkUser cfCarParkLinkUser = cfCarParkLinkUserMapper.selectByPrimaryKey(id);
        if(expectEmpty && cfCarParkLinkUser!=null){
            ExceptionCast.cast(CommonCode.DUPLICATE_DATA);
        }
        if(!expectEmpty && cfCarParkLinkUser==null){
            ExceptionCast.cast(CommonCode.NO_MORE_DATAS);
        }
        return cfCarParkLinkUser;
    }

    @Override
    public CfCarParkLinkUserExample getExampleByQuery(CfCarParkLinkUserQuery cfCarParkLinkUserQuery) {
        CfCarParkLinkUserExample cfCarParkLinkUserExample = new CfCarParkLinkUserExample();
        CfCarParkLinkUserExample.Criteria criteria = cfCarParkLinkUserExample.createCriteria();
        if(StringUtils.isNotEmpty(cfCarParkLinkUserQuery.getCarParkId())){
            criteria.andCarParkIdEqualTo(cfCarParkLinkUserQuery.getCarParkId());
        }
        if(StringUtils.isNotEmpty(cfCarParkLinkUserQuery.getUid())){
            criteria.andUidEqualTo(cfCarParkLinkUserQuery.getUid());
        }
        if(cfCarParkLinkUserQuery.getAllowDelete()!=null){
            criteria.andAllowDeleteEqualTo(cfCarParkLinkUserQuery.getAllowDelete());
        }
        if(cfCarParkLinkUserQuery.getAllowEdit()!=null){
            criteria.andAllowEditEqualTo(cfCarParkLinkUserQuery.getAllowEdit());
        }
        return cfCarParkLinkUserExample;
    }

    @Override
    public List<CfCarParkLinkUser> getListByQuery(CfCarParkLinkUserQuery cfCarParkLinkUserQuery) {
        return cfCarParkLinkUserMapper.selectByExample(getExampleByQuery(cfCarParkLinkUserQuery));
    }

    @Override
    public List<CfCarParkLinkUser> selectByQueryLeftJoinUser(CfCarParkLinkUserQuery cfCarParkLinkUserQuery) {
        return cfCarParkLinkUserMapper.selectByQueryLeftJoinUser(cfCarParkLinkUserQuery);
    }

    @Override
    public Integer countByQuery(CfCarParkLinkUserQuery cfCarParkLinkUserQuery) {
        cfCarParkLinkUserQuery.setPage(null);
        return cfCarParkLinkUserMapper.countByExample(getExampleByQuery(cfCarParkLinkUserQuery));
    }

    @Override
    public boolean checkSaasAction(UserBasicInfo userBasicInfo, String cfCarParkId, String action) {
        if(userBasicInfo.getRoleFlag().indexOf("admin")>-1){
            return true;
        }
        CfCarParkLinkUserQuery cfCarParkLinkUserQuery = new CfCarParkLinkUserQuery();
        cfCarParkLinkUserQuery.setCarParkId(cfCarParkId);
        cfCarParkLinkUserQuery.setUid(userBasicInfo.getId());
        List<CfCarParkLinkUser> cfCarParkLinkUsers = getListByQuery(cfCarParkLinkUserQuery);
        if(cfCarParkLinkUsers==null || cfCarParkLinkUsers.size()==0){
            ExceptionCast.cast(CarParkCode.NO_PERMISSION);
        }
        if(cfCarParkLinkUsers.get(0).getCreater()==(byte)1){
            return true;
        }
        if(action.equals(ActionType.EDIT) && cfCarParkLinkUsers.get(0).getAllowEdit()!=(byte)1){
            ExceptionCast.cast(CarParkCode.NO_PERMISSION);
        }
        if(action.equals(ActionType.DELETE) && cfCarParkLinkUsers.get(0).getAllowDelete()!=(byte)1){
            ExceptionCast.cast(CarParkCode.NO_PERMISSION);
        }
        return true;
    }

    @Override
    public void checkHostOrAdminer(UserBasicInfo userBasicInfo, String cfCarParkId) {
        boolean checkSaasActionResult = checkSaasAction(userBasicInfo, cfCarParkId, "");
        if(!checkSaasActionResult){
            ExceptionCast.cast(CarParkCode.NO_PERMISSION);
        }
    }

    @Override
    public void checkRepeatData(CfCarParkLinkUser cfCarParkLinkUser) {
        CfCarParkLinkUserQuery cfCarParkLinkUserQuery = new CfCarParkLinkUserQuery();
        cfCarParkLinkUserQuery.setUid(cfCarParkLinkUser.getUid());
        cfCarParkLinkUserQuery.setCarParkId(cfCarParkLinkUser.getCarParkId());
        cfCarParkLinkUserQuery.setPage(1);
        cfCarParkLinkUserQuery.setSize(1);
        List<CfCarParkLinkUser> cfCarParkLinkUsers = getListByQuery(cfCarParkLinkUserQuery);
        if(cfCarParkLinkUsers!=null && cfCarParkLinkUsers.size()>0){
            if((StringUtils.isNotEmpty(cfCarParkLinkUser.getId()) && !cfCarParkLinkUsers.get(0).getId().equals(cfCarParkLinkUser.getId())) || StringUtils.isEmpty(cfCarParkLinkUser.getId())){
                ExceptionCast.cast(CommonCode.DUPLICATE_DATA);
            }
        }
    }

    private void updateDeviceLinkers(CfCarParkLinkUser cfCarParkLinkUser){
        //先删掉所有
        CfCarParkDeviceLinkUserQuery cfCarParkDeviceLinkUserQuery = new CfCarParkDeviceLinkUserQuery();
        cfCarParkDeviceLinkUserQuery.setCarParkId(cfCarParkLinkUser.getCarParkId());
        cfCarParkDeviceLinkUserQuery.setUid(cfCarParkLinkUser.getUid());
        cfCarParkDeviceLinkUserService.deleteByQuery(cfCarParkDeviceLinkUserQuery);

        if(cfCarParkLinkUser.getId()==null){
            //表示删除操作
            return;
        }

        //查询该停车场下所有的硬件
        CfCarParkDeviceQuery cfCarParkDeviceQuery = new CfCarParkDeviceQuery();
        cfCarParkDeviceQuery.setCarParkId(cfCarParkLinkUser.getCarParkId());
        List<CfCarParkDevice> cfCarParkDevices = cfCarParkDeviceService.getListByQuery(cfCarParkDeviceQuery);

        if(cfCarParkDevices!=null && cfCarParkDevices.size()>0){
            //重新增加
            List<CfCarParkDeviceLinkUser> cfCarParkDeviceLinkUsers = new ArrayList<>();
            for (CfCarParkDevice cfCarParkDevice: cfCarParkDevices){
                CfCarParkDeviceLinkUser cfCarParkDeviceLinkUser = new CfCarParkDeviceLinkUser();
                cfCarParkDeviceLinkUser.setDeviceId(cfCarParkDevice.getId());
                cfCarParkDeviceLinkUser.setCarParkId(cfCarParkDevice.getCarParkId());
                cfCarParkDeviceLinkUser.setUid(cfCarParkLinkUser.getUid());
                cfCarParkDeviceLinkUser.setCheckPointId(cfCarParkDevice.getCheckpointId());
                cfCarParkDeviceLinkUsers.add(cfCarParkDeviceLinkUser);
            }
            cfCarParkDeviceLinkUserService.batchAdd(cfCarParkDeviceLinkUsers);
        }

    }
}
