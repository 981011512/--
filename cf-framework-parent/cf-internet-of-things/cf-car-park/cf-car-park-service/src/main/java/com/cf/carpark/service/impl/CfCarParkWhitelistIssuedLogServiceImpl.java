package com.cf.carpark.service.impl;

import com.cf.carpark.dao.mapper.CfCarParkWhitelistIssuedLogMapper;
import com.cf.carpark.domain.CfCarParkWhitelistIssuedLog;
import com.cf.carpark.domain.CfCarParkWhitelistIssuedLogExample;
import com.cf.carpark.domain.request.CfCarParkWhitelistIssuedLogQuery;
import com.cf.carpark.service.CfCarParkWhitelistIssuedLogService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfCarParkWhitelistIssuedLogServiceImpl implements CfCarParkWhitelistIssuedLogService {

    @Autowired
    private CfCarParkWhitelistIssuedLogMapper cfCarParkWhitelistIssuedLogMapper;

    @Override
    public Integer batchAdd(List<CfCarParkWhitelistIssuedLog> cfCarParkWhitelistIssuedLogList) {
        return cfCarParkWhitelistIssuedLogMapper.batchAdd(cfCarParkWhitelistIssuedLogList);
    }

    @Override
    public List<CfCarParkWhitelistIssuedLog> getListByQuery(CfCarParkWhitelistIssuedLogQuery cfCarParkWhitelistIssuedLogQuery) {
        return cfCarParkWhitelistIssuedLogMapper.selectByExample(getExampleByQuery(cfCarParkWhitelistIssuedLogQuery));
    }

    @Override
    public CfCarParkWhitelistIssuedLogExample getExampleByQuery(CfCarParkWhitelistIssuedLogQuery cfCarParkWhitelistIssuedLogQuery) {
        CfCarParkWhitelistIssuedLogExample cfCarParkWhitelistIssuedLogExample = new CfCarParkWhitelistIssuedLogExample();
        CfCarParkWhitelistIssuedLogExample.Criteria criteria = cfCarParkWhitelistIssuedLogExample.createCriteria();
        if(cfCarParkWhitelistIssuedLogQuery.getDeviceSn()!=null){
            criteria.andDeviceSnEqualTo(cfCarParkWhitelistIssuedLogQuery.getDeviceSn());
        }
        if(cfCarParkWhitelistIssuedLogQuery.getNumberPlate()!=null){
            criteria.andNumberPlateEqualTo(cfCarParkWhitelistIssuedLogQuery.getNumberPlate());
        }
        if(cfCarParkWhitelistIssuedLogQuery.getNumberPlates()!=null && cfCarParkWhitelistIssuedLogQuery.getNumberPlates().size()>0){
            criteria.andNumberPlateIn(cfCarParkWhitelistIssuedLogQuery.getNumberPlates());
        }
        return cfCarParkWhitelistIssuedLogExample;
    }

    @Override
    public Integer deleteByQuery(CfCarParkWhitelistIssuedLogQuery cfCarParkWhitelistIssuedLogQuery) {
        return cfCarParkWhitelistIssuedLogMapper.deleteByExample(getExampleByQuery(cfCarParkWhitelistIssuedLogQuery));
    }
}
