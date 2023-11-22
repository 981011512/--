package com.cf.charging.service.impl;

import com.cf.charging.dao.mapper.CfChargingStationMapper;
import com.cf.charging.domain.CfChargingStation;
import com.cf.charging.domain.CfChargingStationExample;
import com.cf.charging.domain.CfChargingUseLog;
import com.cf.charging.domain.request.CfChargingStationQuery;
import com.cf.charging.service.CfChargingStationService;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.DateUtil;
import com.cf.framework.utils.DbUtils;
import com.cf.framework.utils.IdWorker;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfChargingStationServiceImpl implements CfChargingStationService {

    @Autowired
    private CfChargingStationMapper cfChargingStationMapper;
    @Autowired
    private IdWorker idWorker;

    @Override
    public CfChargingStation add(CfChargingStation cfChargingStation) {
        cfChargingStation.setId(idWorker.nextId());
        cfChargingStationMapper.insertSelective(cfChargingStation);
        return cfChargingStation;
    }

    @Override
    public CfChargingStation update(CfChargingStation cfChargingStation) {
        cfChargingStationMapper.updateByPrimaryKeySelective(cfChargingStation);
        return cfChargingStation;
    }

    @Override
    public Integer updateByQuery(CfChargingStation cfChargingStation, CfChargingStationQuery cfChargingStationQuery) {
        return cfChargingStationMapper.updateByExampleSelective(cfChargingStation, getExampleByQuery(cfChargingStationQuery));
    }

    @Override
    public Integer delete(String id) {
        return cfChargingStationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public CfChargingStation findById(String id) {
        return cfChargingStationMapper.selectByPrimaryKey(id);
    }

    @Override
    public CfChargingStation findById(String id, boolean expectEmty) {
        CfChargingStation cfChargingStation = findById(id);
        if(expectEmty && cfChargingStation!=null){
            ExceptionCast.cast(CommonCode.DUPLICATE_DATA);
        }else if(!expectEmty && cfChargingStation==null){
            ExceptionCast.cast(CommonCode.NO_MORE_DATAS);
        }
        return cfChargingStation;
    }

    @Override
    public CfChargingStationExample getExampleByQuery(CfChargingStationQuery cfChargingStationQuery) {
        CfChargingStationExample cfChargingStationExample = new CfChargingStationExample();
        CfChargingStationExample.Criteria criteria = cfChargingStationExample.createCriteria();
        if(StringUtils.isNotEmpty(cfChargingStationQuery.getId())){
            criteria.andIdEqualTo(cfChargingStationQuery.getId());
        }
        if(cfChargingStationQuery.getIds()!=null && cfChargingStationQuery.getIds().size()>0){
            criteria.andIdIn(cfChargingStationQuery.getIds());
        }
        if(StringUtils.isNotEmpty(cfChargingStationQuery.getStationName())){
            criteria.andStationNameLike("%"+cfChargingStationQuery.getStationName()+"%");
        }
        if(cfChargingStationQuery.getMinPositionX()!=null){
            criteria.andPositionXGreaterThanOrEqualTo(cfChargingStationQuery.getMinPositionX());
        }
        if(cfChargingStationQuery.getMaxPositionX()!=null){
            criteria.andPositionXLessThanOrEqualTo(cfChargingStationQuery.getMaxPositionX());
        }
        if(cfChargingStationQuery.getMinPositionY()!=null){
            criteria.andPositionYGreaterThanOrEqualTo(cfChargingStationQuery.getMinPositionY());
        }
        if(cfChargingStationQuery.getMaxPositionY()!=null){
            criteria.andPositionYLessThanOrEqualTo(cfChargingStationQuery.getMaxPositionY());
        }
        if(cfChargingStationQuery.getMinStartBusinessTime()!=null){
            criteria.andStartBusinessTimeGreaterThanOrEqualTo(cfChargingStationQuery.getMinStartBusinessTime());
        }
        if(cfChargingStationQuery.getMaxStartBusinessTime()!=null){
            criteria.andStartBusinessTimeLessThanOrEqualTo(cfChargingStationQuery.getMaxStartBusinessTime());
        }
        if(cfChargingStationQuery.getMinEndBusinessTime()!=null){
            criteria.andEndBusinessTimeGreaterThanOrEqualTo(cfChargingStationQuery.getMinEndBusinessTime());
        }
        if(cfChargingStationQuery.getMaxEndBusinessTime()!=null){
            criteria.andEndBusinessTimeLessThanOrEqualTo(cfChargingStationQuery.getMaxEndBusinessTime());
        }

        if(StringUtils.isNotEmpty(cfChargingStationQuery.getOrderBy())){
            cfChargingStationExample.setOrderByClause(cfChargingStationQuery.getOrderBy());
        }
        if(cfChargingStationQuery.getPage()!=null && cfChargingStationQuery.getSize()!=null){
            PageHelper.startPage(cfChargingStationQuery.getPage(), cfChargingStationQuery.getSize());
        }
        return cfChargingStationExample;
    }

    @Override
    public List<CfChargingStation> getListByQuery(CfChargingStationQuery cfChargingStationQuery) {
        return cfChargingStationMapper.selectByExample(getExampleByQuery(cfChargingStationQuery));
    }

    @Override
    public Integer countByQuery(CfChargingStationQuery cfChargingStationQuery) {
        cfChargingStationQuery.setPage(null);
        return cfChargingStationMapper.countByExample(getExampleByQuery(cfChargingStationQuery));
    }

    @Override
    public List<CfChargingStation> selectListByCondition(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds) {
        String sql = "SELECT cst.* FROM cf_charging_station cst";
        sql = DbUtils.makeQuery(conditions, allowFiledsMap, allowFileds, sql, false);
        return cfChargingStationMapper.selectListByCondition(sql);
    }

    @Override
    public Integer selectListByConditionCounts(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds) {
        String sql = "SELECT count(*) FROM cf_charging_station cst";
        conditions.remove("group");
        sql = DbUtils.makeQuery(conditions, allowFiledsMap, allowFileds, sql, false);
        return cfChargingStationMapper.selectListByConditionCounts(sql);
    }

    @Override
    public List<CfChargingStation> selectContalDistanceListByQuery(CfChargingStationQuery cfChargingStationQuery) throws Exception{
        int page = (cfChargingStationQuery.getPage() - 1)*cfChargingStationQuery.getSize();
        cfChargingStationQuery.setPage(page);
        return cfChargingStationMapper.selectContalDistanceListByQuery(cfChargingStationQuery);
    }

    @Override
    public Integer increaseOrreduceFieldValue(CfChargingStation cfChargingStation) {
        return cfChargingStationMapper.increaseOrreduceFieldValue(cfChargingStation);
    }
}
