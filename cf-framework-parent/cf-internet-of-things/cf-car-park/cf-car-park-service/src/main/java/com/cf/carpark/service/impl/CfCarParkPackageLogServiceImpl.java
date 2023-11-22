package com.cf.carpark.service.impl;

import com.cf.carpark.dao.mapper.CfCarParkPackageLogMapper;
import com.cf.carpark.domain.CfCarParkPackageLog;
import com.cf.carpark.domain.CfCarParkPackageLogExample;
import com.cf.carpark.domain.request.CfCarParkPackageLogQuery;
import com.cf.carpark.service.CfCarParkPackageLogService;
import com.cf.framework.utils.IdWorker;
import com.github.pagehelper.PageHelper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfCarParkPackageLogServiceImpl implements CfCarParkPackageLogService {

    @Autowired
    private CfCarParkPackageLogMapper cfCarParkPackageLogMapper;
    @Autowired
    private IdWorker idWorker;

    @Override
    public CfCarParkPackageLog add(CfCarParkPackageLog cfCarParkPackageLog) {
        cfCarParkPackageLog.setId(idWorker.nextId());
        cfCarParkPackageLog.setActionTime(System.currentTimeMillis());
        cfCarParkPackageLogMapper.insert(cfCarParkPackageLog);
        return cfCarParkPackageLog;
    }

    @Override
    public CfCarParkPackageLog update(CfCarParkPackageLog cfCarParkPackageLog) {
        cfCarParkPackageLogMapper.updateByPrimaryKey(cfCarParkPackageLog);
        return cfCarParkPackageLog;
    }

    @Override
    public Integer delete(String id) {
        return cfCarParkPackageLogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer deleteByQuery(CfCarParkPackageLogQuery cfCarParkPackageLogQuery) {
        return cfCarParkPackageLogMapper.deleteByExample(getExampleByQuery(cfCarParkPackageLogQuery));
    }

    @Override
    public CfCarParkPackageLogExample getExampleByQuery(CfCarParkPackageLogQuery cfCarParkPackageLogQuery) {
        CfCarParkPackageLogExample cfCarParkPackageLogExample = new CfCarParkPackageLogExample();
        CfCarParkPackageLogExample.Criteria criteria = cfCarParkPackageLogExample.createCriteria();
        if(cfCarParkPackageLogQuery.getPackageId()!=null){
            criteria.andPackageIdEqualTo(cfCarParkPackageLogQuery.getPackageId());
        }
        if(cfCarParkPackageLogQuery.getPage()!=null && cfCarParkPackageLogQuery.getSize()!=null){
            PageHelper.startPage(cfCarParkPackageLogQuery.getPage(), cfCarParkPackageLogQuery.getSize());
        }
        return cfCarParkPackageLogExample;
    }

    @Override
    public Integer countByQuery(CfCarParkPackageLogQuery cfCarParkPackageLogQuery) {
        cfCarParkPackageLogQuery.setPage(null);
        return cfCarParkPackageLogMapper.countByExample(getExampleByQuery(cfCarParkPackageLogQuery));
    }

    @Override
    public List<CfCarParkPackageLog> getListByQuery(CfCarParkPackageLogQuery cfCarParkPackageLogQuery) {
        return cfCarParkPackageLogMapper.selectByExample(getExampleByQuery(cfCarParkPackageLogQuery));
    }

    @Override
    public List<CfCarParkPackageLog> selectByQuery(CfCarParkPackageLogQuery cfCarParkPackageLogQuery) {
        return cfCarParkPackageLogMapper.selectByQuery(cfCarParkPackageLogQuery);
    }
}
