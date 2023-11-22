package com.cf.carpark.service.impl;

import com.cf.carpark.dao.mapper.CfCarParkVisitMapper;
import com.cf.carpark.domain.CfCarParkVisit;
import com.cf.carpark.domain.CfCarParkVisitExample;
import com.cf.carpark.domain.request.CfCarParkVisitQuery;
import com.cf.carpark.service.CfCarParkVisitService;
import com.cf.framework.domain.carpark.response.CarParkCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.DbUtils;
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
public class CfCarParkVisitServiceImpl implements CfCarParkVisitService {

    @Autowired
    private IdWorker idWorker;
    @Autowired
    private CfCarParkVisitMapper cfCarParkVisitMapper;

    @Override
    public CfCarParkVisit add(CfCarParkVisit cfCarParkVisit) {
        cfCarParkVisit.setId(idWorker.nextLongId());
        cfCarParkVisit.setCreateTime(System.currentTimeMillis());
        cfCarParkVisitMapper.insertSelective(cfCarParkVisit);
        return cfCarParkVisit;
    }

    @Override
    public CfCarParkVisit update(CfCarParkVisit cfCarParkVisit) {
        cfCarParkVisitMapper.updateByPrimaryKeySelective(cfCarParkVisit);
        return cfCarParkVisit;
    }

    @Override
    public Integer updateByQuery(CfCarParkVisit cfCarParkVisit, CfCarParkVisitQuery cfCarParkVisitQuery) {
        return cfCarParkVisitMapper.updateByExampleSelective(cfCarParkVisit, getExampleByQuery(cfCarParkVisitQuery));
    }

    @Override
    public Integer delete(Long id) {
        return cfCarParkVisitMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer deleteByQuery(CfCarParkVisitQuery cfCarParkVisitQuery) {
        return cfCarParkVisitMapper.deleteByExample(getExampleByQuery(cfCarParkVisitQuery));
    }

    @Override
    public CfCarParkVisit findById(Long id) {
        return cfCarParkVisitMapper.selectByPrimaryKey(id);
    }

    @Override
    public CfCarParkVisit findById(Long id, boolean expectEmpty) {
        CfCarParkVisit cfCarParkVisit = findById(id);
        if(cfCarParkVisit==null && !expectEmpty){
            ExceptionCast.cast(CarParkCode.VISIT_RECORD_NOT_FOUND);
        }
        if(cfCarParkVisit!=null && expectEmpty){
            ExceptionCast.cast(CarParkCode.VISIT_RECORD_ALREADY_EXISTS);
        }
        return cfCarParkVisit;
    }

    @Override
    public CfCarParkVisitExample getExampleByQuery(CfCarParkVisitQuery cfCarParkVisitQuery) {
        CfCarParkVisitExample cfCarParkVisitExample = new CfCarParkVisitExample();
        CfCarParkVisitExample.Criteria criteria = cfCarParkVisitExample.createCriteria();
        if(cfCarParkVisitQuery.getCarParkId()!=null){
            criteria.andCarParkIdEqualTo(cfCarParkVisitQuery.getCarParkId());
        }
        if(cfCarParkVisitQuery.getCarParkIds()!=null && cfCarParkVisitQuery.getCarParkIds().size()>0){
            criteria.andCarParkIdIn(cfCarParkVisitQuery.getCarParkIds());
        }
        if(cfCarParkVisitQuery.getFromUid()!=null){
            criteria.andFromUidEqualTo(cfCarParkVisitQuery.getFromUid());
        }
        if(cfCarParkVisitQuery.getToUid()!=null){
            criteria.andToUidEqualTo(cfCarParkVisitQuery.getToUid());
        }
        if(cfCarParkVisitQuery.getPlateNumber()!=null){
            criteria.andPlateNumberEqualTo(cfCarParkVisitQuery.getPlateNumber());
        }
        if(cfCarParkVisitQuery.getMinCreateTime()!=null){
            criteria.andCreateTimeGreaterThanOrEqualTo(cfCarParkVisitQuery.getMinCreateTime());
        }
        if(cfCarParkVisitQuery.getMaxCreateTime()!=null){
            criteria.andCreateTimeLessThanOrEqualTo(cfCarParkVisitQuery.getMaxCreateTime());
        }

        if(cfCarParkVisitQuery.getProcessTime()!=null){
            criteria.andProcessTimeEqualTo(cfCarParkVisitQuery.getProcessTime());
        }
        if(cfCarParkVisitQuery.getMinProcessTime()!=null){
            criteria.andProcessTimeGreaterThanOrEqualTo(cfCarParkVisitQuery.getMinProcessTime());
        }
        if(cfCarParkVisitQuery.getMaxProcessTime()!=null){
            criteria.andProcessTimeLessThanOrEqualTo(cfCarParkVisitQuery.getMaxProcessTime());
        }

        if(cfCarParkVisitQuery.getVisitTime()!=null){
            criteria.andVisitTimeEqualTo(cfCarParkVisitQuery.getVisitTime());
        }
        if(cfCarParkVisitQuery.getMinVisitTime()!=null){
            criteria.andVisitTimeGreaterThanOrEqualTo(cfCarParkVisitQuery.getMinVisitTime());
        }
        if(cfCarParkVisitQuery.getMaxVisitTime()!=null){
            criteria.andVisitTimeLessThanOrEqualTo(cfCarParkVisitQuery.getMaxVisitTime());
        }



        if(StringUtils.isNotEmpty(cfCarParkVisitQuery.getOrderBy())){
            cfCarParkVisitExample.setOrderByClause(cfCarParkVisitQuery.getOrderBy());
        }
        if(cfCarParkVisitQuery.getPage()!=null && cfCarParkVisitQuery.getSize()!=null){
            PageHelper.startPage(cfCarParkVisitQuery.getPage(), cfCarParkVisitQuery.getSize());
        }
        return cfCarParkVisitExample;
    }

    @Override
    public List<CfCarParkVisit> getListByQuery(CfCarParkVisitQuery cfCarParkVisitQuery) {
        return cfCarParkVisitMapper.selectByExample(getExampleByQuery(cfCarParkVisitQuery));
    }

    @Override
    public Integer countByQuery(CfCarParkVisitQuery cfCarParkVisitQuery) {
        cfCarParkVisitQuery.setPage(null);
        cfCarParkVisitQuery.setSize(null);
        return cfCarParkVisitMapper.countByExample(getExampleByQuery(cfCarParkVisitQuery));
    }

    @Override
    public List<CfCarParkVisit> selectContinByQuery(CfCarParkVisitQuery cfCarParkVisitQuery) {
        ArrayList<String> allowOrderBy = new ArrayList<>();
        allowOrderBy.add("cpvt.create_time asc");
        allowOrderBy.add("cpvt.create_time desc");
        allowOrderBy.add("cpvt.process_time asc");
        allowOrderBy.add("cpvt.process_time desc");
        allowOrderBy.add("cpvt.visit_time asc");
        allowOrderBy.add("cpvt.visit_time desc");
        allowOrderBy.add("cpvt.expiration_time asc");
        allowOrderBy.add("cpvt.expiration_time desc");
        cfCarParkVisitQuery.setOrderBy(DbUtils.makeAllowOrderBy(allowOrderBy,cfCarParkVisitQuery.getOrderBy()));
        return cfCarParkVisitMapper.selectContinByQuery(cfCarParkVisitQuery);
    }
}
