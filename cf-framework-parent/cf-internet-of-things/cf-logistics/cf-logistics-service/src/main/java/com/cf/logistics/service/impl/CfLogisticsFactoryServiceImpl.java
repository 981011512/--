package com.cf.logistics.service.impl;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.IdWorker;
import com.cf.logistics.dao.mapper.CfLogisticsFactoryMapper;
import com.cf.logistics.domain.CfLogisticsFactory;
import com.cf.logistics.domain.CfLogisticsFactoryExample;
import com.cf.logistics.domain.request.CfLogisticsFactoryQuery;
import com.cf.logistics.service.CfLogisticsFactoryService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfLogisticsFactoryServiceImpl implements CfLogisticsFactoryService {

    @Autowired
    private CfLogisticsFactoryMapper cfLogisticsFactoryMapper;
    @Autowired
    private IdWorker idWorker;

    @Override
    public CfLogisticsFactory add(CfLogisticsFactory cfLogisticsFactory) {
        cfLogisticsFactory.setId(idWorker.nextLongId());
        cfLogisticsFactoryMapper.insertSelective(cfLogisticsFactory);
        return cfLogisticsFactory;
    }

    @Override
    public CfLogisticsFactory update(CfLogisticsFactory cfLogisticsFactory) {
        cfLogisticsFactoryMapper.updateByPrimaryKeySelective(cfLogisticsFactory);
        return cfLogisticsFactory;
    }

    @Override
    public Integer delete(Long id) {
        return cfLogisticsFactoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public CfLogisticsFactory findById(Long id) {
        return cfLogisticsFactoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public CfLogisticsFactory findById(Long id, boolean expectEmpty) {
        CfLogisticsFactory cfLogisticsFactory = findById(id);
        if(expectEmpty && cfLogisticsFactory!=null){
            ExceptionCast.cast(CommonCode.DUPLICATE_DATA);
        }
        if(!expectEmpty && cfLogisticsFactory==null){
            ExceptionCast.cast(CommonCode.NO_MORE_DATAS);
        }
        return cfLogisticsFactory;
    }

    @Override
    public CfLogisticsFactoryExample getExampleByQuery(CfLogisticsFactoryQuery cfLogisticsFactoryQuery) {
        CfLogisticsFactoryExample cfLogisticsFactoryExample = new CfLogisticsFactoryExample();
        CfLogisticsFactoryExample.Criteria criteria = cfLogisticsFactoryExample.createCriteria();
        if(StringUtils.isNotEmpty(cfLogisticsFactoryQuery.getFactoryName())){
            criteria.andFactoryNameLike("%"+cfLogisticsFactoryQuery.getFactoryName()+"%");
        }

        if(StringUtils.isNotEmpty(cfLogisticsFactoryQuery.getOrderBy())){
            cfLogisticsFactoryExample.setOrderByClause(cfLogisticsFactoryQuery.getOrderBy());
        }
        if(cfLogisticsFactoryQuery.getPage()!=null && cfLogisticsFactoryQuery.getSize()!=null){
            PageHelper.startPage(cfLogisticsFactoryQuery.getPage(), cfLogisticsFactoryQuery.getSize());
        }
        return cfLogisticsFactoryExample;
    }

    @Override
    public List<CfLogisticsFactory> getListByQuery(CfLogisticsFactoryQuery cfLogisticsFactoryQuery) {
        return cfLogisticsFactoryMapper.selectByExample(getExampleByQuery(cfLogisticsFactoryQuery));
    }

    @Override
    public Integer countByQuery(CfLogisticsFactoryQuery cfLogisticsFactoryQuery) {
        cfLogisticsFactoryQuery.setPage(null);
        cfLogisticsFactoryQuery.setOrderBy(null);
        return cfLogisticsFactoryMapper.countByExample(getExampleByQuery(cfLogisticsFactoryQuery));
    }

    @Override
    public List<CfLogisticsFactory> selectNearLogisticsFactory(CfLogisticsFactoryQuery cfLogisticsFactoryQuery) {
        return cfLogisticsFactoryMapper.selectNearLogisticsFactory(cfLogisticsFactoryQuery);
    }
}
