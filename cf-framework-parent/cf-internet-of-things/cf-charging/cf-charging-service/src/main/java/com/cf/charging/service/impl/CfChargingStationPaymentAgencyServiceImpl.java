package com.cf.charging.service.impl;

import com.cf.charging.dao.mapper.CfChargingStationPaymentAgencyMapper;
import com.cf.charging.domain.CfChargingStationPaymentAgency;
import com.cf.charging.domain.CfChargingStationPaymentAgencyExample;
import com.cf.charging.domain.request.CfChargingStationPaymentAgencyQuery;
import com.cf.charging.service.CfChargingStationPaymentAgencyService;
import com.cf.framework.utils.IdWorker;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfChargingStationPaymentAgencyServiceImpl implements CfChargingStationPaymentAgencyService {

    @Autowired
    private CfChargingStationPaymentAgencyMapper cfChargingStationPaymentAgencyMapper;
    @Autowired
    private IdWorker idWorker;

    @Override
    public CfChargingStationPaymentAgency add(CfChargingStationPaymentAgency cfChargingStationPaymentAgency) {
        cfChargingStationPaymentAgency.setId(idWorker.nextId());
        cfChargingStationPaymentAgencyMapper.insertSelective(cfChargingStationPaymentAgency);
        return cfChargingStationPaymentAgency;
    }

    @Override
    public CfChargingStationPaymentAgency update(CfChargingStationPaymentAgency cfChargingStationPaymentAgency) {
        cfChargingStationPaymentAgencyMapper.updateByPrimaryKeySelective(cfChargingStationPaymentAgency);
        return cfChargingStationPaymentAgency;
    }

    @Override
    public Integer delete(String id) {
        return cfChargingStationPaymentAgencyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public CfChargingStationPaymentAgencyExample getExampleByQuery(CfChargingStationPaymentAgencyQuery cfChargingStationPaymentAgencyQuery) {
        CfChargingStationPaymentAgencyExample cfChargingStationPaymentAgencyExample = new CfChargingStationPaymentAgencyExample();
        CfChargingStationPaymentAgencyExample.Criteria criteria = cfChargingStationPaymentAgencyExample.createCriteria();

        if(StringUtils.isNotEmpty(cfChargingStationPaymentAgencyQuery.getChargingStationId())){
            criteria.andChargingStationIdEqualTo(cfChargingStationPaymentAgencyQuery.getChargingStationId());
        }
        if(cfChargingStationPaymentAgencyQuery.getChargingStationIds()!=null && cfChargingStationPaymentAgencyQuery.getChargingStationIds().size()>0){
            criteria.andChargingStationIdIn(cfChargingStationPaymentAgencyQuery.getChargingStationIds());
        }
        if(StringUtils.isNotEmpty(cfChargingStationPaymentAgencyQuery.getUserPaymentAgency())){
            criteria.andUserPaymentAgencyEqualTo(cfChargingStationPaymentAgencyQuery.getUserPaymentAgency());
        }
        if(StringUtils.isNotEmpty(cfChargingStationPaymentAgencyQuery.getOrderBy())){
            cfChargingStationPaymentAgencyExample.setOrderByClause(cfChargingStationPaymentAgencyQuery.getOrderBy());
        }
        if(cfChargingStationPaymentAgencyQuery.getPage()!=null && cfChargingStationPaymentAgencyQuery.getSize()!=null){
            PageHelper.startPage(cfChargingStationPaymentAgencyQuery.getPage(), cfChargingStationPaymentAgencyQuery.getSize());
        }
        return cfChargingStationPaymentAgencyExample;
    }

    @Override
    public List<CfChargingStationPaymentAgency> getListByQuery(CfChargingStationPaymentAgencyQuery cfChargingStationPaymentAgencyQuery) {
        return cfChargingStationPaymentAgencyMapper.selectByExample(getExampleByQuery(cfChargingStationPaymentAgencyQuery));
    }

    @Override
    public Integer countByQuery(CfChargingStationPaymentAgencyQuery cfChargingStationPaymentAgencyQuery) {
        cfChargingStationPaymentAgencyQuery.setPage(null);
        return cfChargingStationPaymentAgencyMapper.countByExample(getExampleByQuery(cfChargingStationPaymentAgencyQuery));
    }
}
