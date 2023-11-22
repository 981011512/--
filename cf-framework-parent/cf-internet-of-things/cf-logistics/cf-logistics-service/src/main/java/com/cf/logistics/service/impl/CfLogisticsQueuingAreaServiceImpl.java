package com.cf.logistics.service.impl;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.DbUtils;
import com.cf.framework.utils.IdWorker;
import com.cf.logistics.dao.mapper.CfLogisticsQueuingAreaMapper;
import com.cf.logistics.domain.CfLogisticsQueuingArea;
import com.cf.logistics.domain.CfLogisticsQueuingAreaExample;
import com.cf.logistics.domain.request.CfLogisticsQueuingAreaQuery;
import com.cf.logistics.service.CfLogisticsQueuingAreaService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfLogisticsQueuingAreaServiceImpl implements CfLogisticsQueuingAreaService {

    @Autowired
    private CfLogisticsQueuingAreaMapper cfLogisticsQueuingAreaMapper;
    @Autowired
    private IdWorker idWorker;

    @Override
    public CfLogisticsQueuingArea add(CfLogisticsQueuingArea cfLogisticsQueuingArea) {
        cfLogisticsQueuingArea.setId(idWorker.nextLongId());
        cfLogisticsQueuingAreaMapper.insertSelective(cfLogisticsQueuingArea);
        return cfLogisticsQueuingArea;
    }

    @Override
    public CfLogisticsQueuingArea update(CfLogisticsQueuingArea cfLogisticsQueuingArea) {
        cfLogisticsQueuingAreaMapper.updateByPrimaryKeySelective(cfLogisticsQueuingArea);
        return cfLogisticsQueuingArea;
    }

    @Override
    public Integer delete(Long id) {
        return cfLogisticsQueuingAreaMapper.deleteByPrimaryKey(id);
    }

    @Override
    public CfLogisticsQueuingArea findById(Long id) {
        return cfLogisticsQueuingAreaMapper.selectByPrimaryKey(id);
    }

    @Override
    public CfLogisticsQueuingArea findById(Long id, boolean expectEmpty) {
        CfLogisticsQueuingArea cfLogisticsQueuingArea = findById(id);
        if(expectEmpty && cfLogisticsQueuingArea!=null){
            ExceptionCast.cast(CommonCode.DUPLICATE_DATA);
        }
        if(!expectEmpty && cfLogisticsQueuingArea==null){
            ExceptionCast.cast(CommonCode.NO_MORE_DATAS);
        }
        return cfLogisticsQueuingArea;
    }

    @Override
    public CfLogisticsQueuingAreaExample getExampleByQuery(CfLogisticsQueuingAreaQuery cfLogisticsQueuingAreaQuery) {
        CfLogisticsQueuingAreaExample cfLogisticsQueuingAreaExample = new CfLogisticsQueuingAreaExample();
        CfLogisticsQueuingAreaExample.Criteria criteria = cfLogisticsQueuingAreaExample.createCriteria();
        if(cfLogisticsQueuingAreaQuery.getIds()!=null && cfLogisticsQueuingAreaQuery.getIds().size()>0){
            criteria.andIdIn(cfLogisticsQueuingAreaQuery.getIds());
        }
        if(StringUtils.isNotEmpty(cfLogisticsQueuingAreaQuery.getAreaName())){
            criteria.andAreaNameLike("%"+cfLogisticsQueuingAreaQuery.getAreaName()+"%");
        }
        if(cfLogisticsQueuingAreaQuery.getGroupFlag()!=null){
            criteria.andGroupFlagEqualTo(cfLogisticsQueuingAreaQuery.getGroupFlag());
        }

        if(StringUtils.isNotEmpty(cfLogisticsQueuingAreaQuery.getOrderBy())){
            cfLogisticsQueuingAreaExample.setOrderByClause(cfLogisticsQueuingAreaQuery.getOrderBy());
        }
        if(cfLogisticsQueuingAreaQuery.getPage()!=null && cfLogisticsQueuingAreaQuery.getSize()!=null){
            PageHelper.startPage(cfLogisticsQueuingAreaQuery.getPage(), cfLogisticsQueuingAreaQuery.getSize());
        }
        return cfLogisticsQueuingAreaExample;
    }

    @Override
    public List<CfLogisticsQueuingArea> getListByQuery(CfLogisticsQueuingAreaQuery cfLogisticsQueuingAreaQuery) {
        return cfLogisticsQueuingAreaMapper.selectByExample(getExampleByQuery(cfLogisticsQueuingAreaQuery));
    }

    @Override
    public List<CfLogisticsQueuingArea> selectListByQuery(CfLogisticsQueuingAreaQuery cfLogisticsQueuingAreaQuery) {
        ArrayList<String> allowOrderBy = new ArrayList<>();
        allowOrderBy.add("lgqa.used_queue_capacity asc");
        allowOrderBy.add("lgqa.used_queue_capacity desc");
        cfLogisticsQueuingAreaQuery.setOrderBy(DbUtils.makeAllowOrderBy(allowOrderBy,cfLogisticsQueuingAreaQuery.getOrderBy()));
        return cfLogisticsQueuingAreaMapper.selectListByQuery(cfLogisticsQueuingAreaQuery);
    }

    @Override
    public Integer countByQuery(CfLogisticsQueuingAreaQuery cfLogisticsQueuingAreaQuery) {
        cfLogisticsQueuingAreaQuery.setPage(null);
        cfLogisticsQueuingAreaQuery.setOrderBy(null);
        return cfLogisticsQueuingAreaMapper.countByExample(getExampleByQuery(cfLogisticsQueuingAreaQuery));
    }
}
