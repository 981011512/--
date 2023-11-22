package com.cf.charging.service.impl;

import com.cf.carpark.domain.CfCarParkChargingRules;
import com.cf.charging.dao.mapper.CfChargingStationRulesMapper;
import com.cf.charging.domain.CfChargingStationRules;
import com.cf.charging.domain.CfChargingStationRulesExample;
import com.cf.charging.domain.request.CfChargingStationRulesQuery;
import com.cf.charging.service.CfChargingStationRulesService;
import com.cf.framework.domain.carpark.response.CarParkCode;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.DateUtil;
import com.cf.framework.utils.IdWorker;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfChargingStationRulesServiceImpl implements CfChargingStationRulesService {

    @Autowired
    private CfChargingStationRulesMapper cfChargingStationRulesMapper;
    @Autowired
    private IdWorker idWorker;

    @Override
    public CfChargingStationRules add(CfChargingStationRules cfChargingStationRules) throws Exception {
        cfChargingStationRules.setId(idWorker.nextId());
        cfChargingStationRules.setCreateTime(System.currentTimeMillis());
        cfChargingStationRules.setUpdateTime(cfChargingStationRules.getCreateTime());
        validAndHandleChargingRulesStartEndTime(cfChargingStationRules);
        cfChargingStationRulesMapper.insertSelective(cfChargingStationRules);
        cfChargingStationRules.setStartTime(DateUtil.MillisecondBaseOnTheDayToTimestamp(cfChargingStationRules.getStartTime()));
        cfChargingStationRules.setEndTime(DateUtil.MillisecondBaseOnTheDayToTimestamp(cfChargingStationRules.getEndTime()));
        return cfChargingStationRules;
    }

    @Override
    public CfChargingStationRules update(CfChargingStationRules cfChargingStationRules) throws Exception {
        cfChargingStationRules.setUpdateTime(System.currentTimeMillis());
        validAndHandleChargingRulesStartEndTime(cfChargingStationRules);
        cfChargingStationRulesMapper.updateByPrimaryKeySelective(cfChargingStationRules);
        cfChargingStationRules.setStartTime(DateUtil.MillisecondBaseOnTheDayToTimestamp(cfChargingStationRules.getStartTime()));
        cfChargingStationRules.setEndTime(DateUtil.MillisecondBaseOnTheDayToTimestamp(cfChargingStationRules.getEndTime()));
        return cfChargingStationRules;
    }

    @Override
    public Integer delete(String id) {
        return cfChargingStationRulesMapper.deleteByPrimaryKey(id);
    }

    @Override
    public CfChargingStationRulesExample getExampleByQuery(CfChargingStationRulesQuery cfChargingStationRulesQuery) {
        CfChargingStationRulesExample cfChargingStationRulesExample = new CfChargingStationRulesExample();
        CfChargingStationRulesExample.Criteria criteria = cfChargingStationRulesExample.createCriteria();

        if(cfChargingStationRulesQuery.getMinStartTime()!=null && cfChargingStationRulesQuery.getMinStartTime()>0){
            criteria.andStartTimeGreaterThanOrEqualTo(cfChargingStationRulesQuery.getMinStartTime());
        }
        if(cfChargingStationRulesQuery.getMaxStartTime()!=null && cfChargingStationRulesQuery.getMaxStartTime()>0){
            criteria.andStartTimeLessThanOrEqualTo(cfChargingStationRulesQuery.getMaxStartTime());
        }
        if(cfChargingStationRulesQuery.getMinEndTime()!=null && cfChargingStationRulesQuery.getMinEndTime()>0){
            criteria.andEndTimeGreaterThanOrEqualTo(cfChargingStationRulesQuery.getMinEndTime());
        }
        if(cfChargingStationRulesQuery.getMaxEndTime()!=null && cfChargingStationRulesQuery.getMaxEndTime()>0){
            criteria.andEndTimeLessThanOrEqualTo(cfChargingStationRulesQuery.getMaxEndTime());
        }
        if(cfChargingStationRulesQuery.getStatus()!=null){
            criteria.andStatusEqualTo(cfChargingStationRulesQuery.getStatus());
        }
        if(StringUtils.isNotEmpty(cfChargingStationRulesQuery.getChargingStationId())){
            criteria.andChargingStationIdEqualTo(cfChargingStationRulesQuery.getChargingStationId());
        }
        if(cfChargingStationRulesQuery.getChargingDeviceType()!=null){
            criteria.andChargingDeviceTypeEqualTo(cfChargingStationRulesQuery.getChargingDeviceType());
        }

        if(StringUtils.isNotEmpty(cfChargingStationRulesQuery.getOrderBy())){
            cfChargingStationRulesExample.setOrderByClause(cfChargingStationRulesQuery.getOrderBy());
        }else{
            cfChargingStationRulesExample.setOrderByClause("start_time ASC");
        }
        if(cfChargingStationRulesQuery.getPage()!=null && cfChargingStationRulesQuery.getSize()!=null){
            PageHelper.startPage(cfChargingStationRulesQuery.getPage(), cfChargingStationRulesQuery.getSize());
        }
        return cfChargingStationRulesExample;
    }

    @Override
    public List<CfChargingStationRules> getListByQuery(CfChargingStationRulesQuery cfChargingStationRulesQuery) {
        return cfChargingStationRulesMapper.selectByExample(getExampleByQuery(cfChargingStationRulesQuery));
    }

    @Override
    public Integer countByQuery(CfChargingStationRulesQuery cfChargingStationRulesQuery) {
        cfChargingStationRulesQuery.setPage(null);
        return cfChargingStationRulesMapper.countByExample(getExampleByQuery(cfChargingStationRulesQuery));
    }

    @Override
    public CfChargingStationRules validAndHandleChargingRulesStartEndTime(CfChargingStationRules cfChargingStationRules) {
        if(cfChargingStationRules.getEndTime()<=cfChargingStationRules.getStartTime()){
            ExceptionCast.cast(CarParkCode.END_TIME_MUST_BE_GREATER_THAN_START_TIME);
        }
        try {
            cfChargingStationRules.setStartTime(DateUtil.getMillisecondBaseOnTheDay(cfChargingStationRules.getStartTime()));
            cfChargingStationRules.setEndTime(DateUtil.getMillisecondBaseOnTheDay(cfChargingStationRules.getEndTime()));
        } catch (Exception e) {
            ExceptionCast.cast(CommonCode.SERVER_ERROR, e.getMessage());
        }
        return cfChargingStationRules;
    }
}
