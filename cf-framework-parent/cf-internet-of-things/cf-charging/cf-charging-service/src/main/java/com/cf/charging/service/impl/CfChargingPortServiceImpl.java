package com.cf.charging.service.impl;

import com.cf.charging.dao.mapper.CfChargingPortMapper;
import com.cf.charging.domain.CfChargingPort;
import com.cf.charging.domain.CfChargingPortExample;
import com.cf.charging.domain.request.CfChargingPortQuery;
import com.cf.charging.service.CfChargingPortService;
import com.cf.framework.utils.IdWorker;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfChargingPortServiceImpl implements CfChargingPortService {

    @Autowired
    private CfChargingPortMapper cfChargingPortMapper;
    @Autowired
    private IdWorker idWorker;

    @Override
    public CfChargingPort add(CfChargingPort cfChargingPort) {
        cfChargingPort.setId(idWorker.nextId());
        cfChargingPortMapper.insertSelective(cfChargingPort);
        return cfChargingPort;
    }

    @Override
    public CfChargingPort update(CfChargingPort cfChargingPort) {
        cfChargingPortMapper.updateByPrimaryKeySelective(cfChargingPort);
        return cfChargingPort;
    }

    @Override
    public Integer updateByQuery(CfChargingPort cfChargingPort, CfChargingPortQuery cfChargingPortQuery) {
        return cfChargingPortMapper.updateByExampleSelective(cfChargingPort, getExampleByQuery(cfChargingPortQuery));
    }

    @Override
    public Integer delete(String id) {
        return cfChargingPortMapper.deleteByPrimaryKey(id);
    }

    @Override
    public CfChargingPortExample getExampleByQuery(CfChargingPortQuery cfChargingPortQuery) {
        CfChargingPortExample cfChargingPortExample = new CfChargingPortExample();
        CfChargingPortExample.Criteria criteria = cfChargingPortExample.createCriteria();
        if(cfChargingPortQuery.getId()!=null){
            criteria.andIdEqualTo(cfChargingPortQuery.getId());
        }
        if(cfChargingPortQuery.getChargingStationId()!=null){
            criteria.andChargingStationIdEqualTo(cfChargingPortQuery.getChargingStationId());
        }
        if(cfChargingPortQuery.getChargingDeviceId()!=null){
            criteria.andChargingDeviceIdEqualTo(cfChargingPortQuery.getChargingDeviceId());
        }
        if(cfChargingPortQuery.getPortNumber()!=null){
            criteria.andPortNumberEqualTo(cfChargingPortQuery.getPortNumber());
        }
        if(StringUtils.isNotEmpty(cfChargingPortQuery.getOrderBy())){
            cfChargingPortExample.setOrderByClause(cfChargingPortQuery.getOrderBy());
        }
        if(cfChargingPortQuery.getPage()!=null && cfChargingPortQuery.getSize()!=null){
            PageHelper.startPage(cfChargingPortQuery.getPage(), cfChargingPortQuery.getSize());
        }
        return cfChargingPortExample;
    }

    @Override
    public List<CfChargingPort> getListByQuery(CfChargingPortQuery cfChargingPortQuery) {
        return cfChargingPortMapper.selectByExample(getExampleByQuery(cfChargingPortQuery));
    }

    @Override
    public Integer countByQuery(CfChargingPortQuery cfChargingPortQuery) {
        cfChargingPortQuery.setPage(null);
        return cfChargingPortMapper.countByExample(getExampleByQuery(cfChargingPortQuery));
    }
}
