package com.cf.pay.service.impl;

import com.cf.framework.utils.IdWorker;
import com.cf.pay.dao.mapper.CfScoreTypeMapper;
import com.cf.pay.domain.CfScoreType;
import com.cf.pay.domain.CfScoreTypeExample;
import com.cf.pay.domain.request.CfScoreTypeQuery;
import com.cf.pay.service.CfScoreTypeService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfScoreTypeServiceImpl implements CfScoreTypeService {

    @Autowired
    private CfScoreTypeMapper cfScoreTypeMapper;
    @Autowired
    private IdWorker idWorker;

    @Override
    public CfScoreType add(CfScoreType scoreType) {
        scoreType.setId(idWorker.nextId());
        cfScoreTypeMapper.insert(scoreType);
        return scoreType;
    }

    @Override
    public CfScoreType update(CfScoreType scoreType) {
        cfScoreTypeMapper.updateByPrimaryKey(scoreType);
        return scoreType;
    }

    @Override
    public Integer delete(String id) {
        return cfScoreTypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public CfScoreTypeExample getExampleByQuery(CfScoreTypeQuery cfScoreTypeQuery) {
        CfScoreTypeExample cfScoreTypeExample = new CfScoreTypeExample();
        CfScoreTypeExample.Criteria criteria = cfScoreTypeExample.createCriteria();
        if(cfScoreTypeQuery.getId()!=null){
            criteria.andIdEqualTo(cfScoreTypeQuery.getId());
        }
        if(cfScoreTypeQuery.getKeyFlag()!=null){
            criteria.andKeyFlagEqualTo(cfScoreTypeQuery.getKeyFlag());
        }
        return cfScoreTypeExample;
    }

    @Override
    public List<CfScoreType> getListByQuery(CfScoreTypeQuery cfScoreTypeQuery) {
        return cfScoreTypeMapper.selectByExample(getExampleByQuery(cfScoreTypeQuery));
    }
}
