package com.cf.carpark.service.impl;

import com.cf.carpark.dao.mapper.CfCarParkCheckpointMapper;
import com.cf.carpark.domain.CfCarParkCheckpoint;
import com.cf.carpark.domain.CfCarParkCheckpointExample;
import com.cf.carpark.domain.CfCarParkLinkUser;
import com.cf.carpark.domain.request.CfCarParkCheckpointQuery;
import com.cf.carpark.domain.request.CfCarParkLinkUserQuery;
import com.cf.carpark.service.CfCarParkCheckpointService;
import com.cf.carpark.service.CfCarParkLinkUserService;
import com.cf.framework.domain.carpark.response.CarParkCode;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.IdWorker;
import com.cf.framework.utils.StringTools;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 停车场出入口
 *
 * @ClassName CfCarParkCheckpointServiceImpl
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/7/007 7:53
 * @Version 1.0
 **/
@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfCarParkCheckpointServiceImpl implements CfCarParkCheckpointService {

    @Autowired
    private CfCarParkCheckpointMapper cfCarParkCheckpointMapper;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private CfCarParkLinkUserService cfCarParkLinkUserService;

    @Override
    public CfCarParkCheckpoint findById(String id) {
        return cfCarParkCheckpointMapper.selectByPrimaryKey(id);
    }

    @Override
    public CfCarParkCheckpoint findById(String id, Boolean expectEmpty) {
        CfCarParkCheckpoint cfCarParkCheckpoint = findById(id);
        if(expectEmpty && cfCarParkCheckpoint!=null){
            ExceptionCast.cast(CommonCode.DUPLICATE_DATA);
        }else if(!expectEmpty && cfCarParkCheckpoint==null){
            ExceptionCast.cast(CarParkCode.CHECKPOINT_DOES_NOT_EXIST);
        }
        return cfCarParkCheckpoint;
    }

    @Override
    public List<CfCarParkCheckpoint> getListByQuery(CfCarParkCheckpointQuery cfCarParkCheckpointQuery) {
        return cfCarParkCheckpointMapper.selectByExample(getExampleByQuery(cfCarParkCheckpointQuery));
    }

    @Override
    public CfCarParkCheckpointExample getExampleByQuery(CfCarParkCheckpointQuery cfCarParkCheckpointQuery) {
        CfCarParkCheckpointExample cfCarParkCheckpointExample = new CfCarParkCheckpointExample();
        CfCarParkCheckpointExample.Criteria criteria = cfCarParkCheckpointExample.createCriteria();
        if(StringUtils.isNotEmpty(cfCarParkCheckpointQuery.getId())){
            criteria.andIdEqualTo(cfCarParkCheckpointQuery.getId());
        }
        if(cfCarParkCheckpointQuery.getIds()!=null && cfCarParkCheckpointQuery.getIds().size()>0){
            criteria.andIdIn(cfCarParkCheckpointQuery.getIds());
        }
        if(StringUtils.isNotEmpty(cfCarParkCheckpointQuery.getName())){
            criteria.andNameLike("%"+cfCarParkCheckpointQuery.getName()+"%");
        }
        if(StringUtils.isNotEmpty(cfCarParkCheckpointQuery.getCarParkId())){
            criteria.andCarParkIdEqualTo(cfCarParkCheckpointQuery.getCarParkId());
        }
        if(cfCarParkCheckpointQuery.getDutyUid()!=null){
            criteria.andDutyUidEqualTo(cfCarParkCheckpointQuery.getDutyUid());
        }
        if(StringUtils.isNotEmpty(cfCarParkCheckpointQuery.getDirection())){
            criteria.andDirectionEqualTo(cfCarParkCheckpointQuery.getDirection());
        }
        if(cfCarParkCheckpointQuery.getFloor()!=null){
            criteria.andFloorEqualTo(cfCarParkCheckpointQuery.getFloor());
        }
        if(cfCarParkCheckpointQuery.getMode()!=null){
            criteria.andModeEqualTo(cfCarParkCheckpointQuery.getMode());
        }
        if(cfCarParkCheckpointQuery.getStatus()!=null){
            criteria.andStatusEqualTo(cfCarParkCheckpointQuery.getStatus());
        }
        if(cfCarParkCheckpointQuery.getAllowTemporaryCar()!=null){
            criteria.andAllowTemporaryCarEqualTo(cfCarParkCheckpointQuery.getAllowTemporaryCar());
        }
        if(cfCarParkCheckpointQuery.getAllowUnconditionalOpen()!=null){
            criteria.andAllowUnconditionalOpenEqualTo(cfCarParkCheckpointQuery.getAllowUnconditionalOpen());
        }
        if(StringUtils.isNotEmpty(cfCarParkCheckpointQuery.getOrderBy())){
            cfCarParkCheckpointExample.setOrderByClause(cfCarParkCheckpointQuery.getOrderBy());
        }
        if(cfCarParkCheckpointQuery.getPage()!=null && cfCarParkCheckpointQuery.getSize()!=null){
            PageHelper.startPage(cfCarParkCheckpointQuery.getPage(), cfCarParkCheckpointQuery.getSize());
        }
        return cfCarParkCheckpointExample;
    }

    @Override
    public List<CfCarParkCheckpoint> selectByQuery(CfCarParkCheckpointQuery cfCarParkCheckpointQuery) {
        return cfCarParkCheckpointMapper.selectByQuery(cfCarParkCheckpointQuery);
    }

    @Override
    public CfCarParkCheckpoint add(CfCarParkCheckpoint cfCarParkCheckpoint) {
        cfCarParkCheckpoint.setId(idWorker.nextId());
        cfCarParkCheckpointMapper.insertSelective(cfCarParkCheckpoint);
        return cfCarParkCheckpoint;
    }

    @Override
    public CfCarParkCheckpoint update(CfCarParkCheckpoint cfCarParkCheckpoint) {
        findById(cfCarParkCheckpoint.getId(), false);
        cfCarParkCheckpointMapper.updateByPrimaryKeySelective(cfCarParkCheckpoint);
        return cfCarParkCheckpoint;
    }

    @Override
    public Integer updateByQuery(CfCarParkCheckpoint cfCarParkCheckpoint, CfCarParkCheckpointQuery cfCarParkCheckpointQuery) {
        CfCarParkCheckpointExample cfCarParkCheckpointExample = getExampleByQuery(cfCarParkCheckpointQuery);
        return cfCarParkCheckpointMapper.updateByExampleSelective(cfCarParkCheckpoint, cfCarParkCheckpointExample);
    }

    @Override
    public Integer delete(String id) {
        return cfCarParkCheckpointMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer deleteByQuery(CfCarParkCheckpointQuery cfCarParkCheckpointQuery) {
        return cfCarParkCheckpointMapper.deleteByExample(getExampleByQuery(cfCarParkCheckpointQuery));
    }

    @Override
    public List<CfCarParkCheckpoint> selectNearbyCheckPoint(CfCarParkCheckpointQuery cfCarParkCheckpointQuery) {
        if(cfCarParkCheckpointQuery.getDistance()==null && StringUtils.isEmpty(cfCarParkCheckpointQuery.getCarParkId())){
            ExceptionCast.cast(CommonCode.INVALID_PARAM,"carparkId and distance provide at least one parameter");
        }
        Integer page = cfCarParkCheckpointQuery.getPage();
        cfCarParkCheckpointQuery.setPage((page-1)*cfCarParkCheckpointQuery.getSize());
        return cfCarParkCheckpointMapper.selectNearbyCheckPoint(cfCarParkCheckpointQuery);
    }

    @Override
    public Integer removeCheckPointDutyByUid(String uid) {
        CfCarParkCheckpointExample cfCarParkCheckpointExample = new CfCarParkCheckpointExample();
        CfCarParkCheckpointExample.Criteria criteria = cfCarParkCheckpointExample.createCriteria();
        criteria.andDutyUidEqualTo(uid);

        CfCarParkCheckpoint cfCarParkCheckpoint = new CfCarParkCheckpoint();
        cfCarParkCheckpoint.setDutyUid("");
        return cfCarParkCheckpointMapper.updateByExampleSelective(cfCarParkCheckpoint, cfCarParkCheckpointExample);
    }

    @Override
    public CfCarParkCheckpoint checkUserAuthOfCheckPoint(UserBasicInfo userBasicInfo, String checkPointId) {
        CfCarParkCheckpoint cfCarParkCheckpoint = findById(checkPointId, false);

        //判断是否为超级管理员
        if(StringTools.findStringInArray(userBasicInfo.getRoleFlag().split(","), "admin")>=0){
            return cfCarParkCheckpoint;
        }

        //判断是否为物业管理员
        if(StringTools.findStringInArray(userBasicInfo.getRoleFlag().split(","), "property_admin")>=0){
            //判断该管理员是否有管理该停车场
            CfCarParkLinkUserQuery cfCarParkLinkUserQuery = new CfCarParkLinkUserQuery();
            cfCarParkLinkUserQuery.setUid(userBasicInfo.getId());
            cfCarParkLinkUserQuery.setCarParkId(cfCarParkCheckpoint.getCarParkId());
            Integer integer = cfCarParkLinkUserService.countByQuery(cfCarParkLinkUserQuery);
            if(integer>0){
                return cfCarParkCheckpoint;
            }
        }

        //其它人员只能在值班时开闸
        if(cfCarParkCheckpoint.getDutyUid().equals(userBasicInfo.getId())){
            return cfCarParkCheckpoint;
        }

        ExceptionCast.cast(CarParkCode.NO_PERMISSION);
        return null;
    }
}
