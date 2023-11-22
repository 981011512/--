package com.cf.logistics.service.impl;

import com.cf.framework.utils.IdWorker;
import com.cf.logistics.dao.mapper.CfLogisticsStorehouseCargoTypeMapper;
import com.cf.logistics.domain.CfLogisticsStorehouseCargoType;
import com.cf.logistics.domain.CfLogisticsStorehouseCargoTypeExample;
import com.cf.logistics.domain.request.CfLogisticsStorehouseCargoTypeQuery;
import com.cf.logistics.service.CfLogisticsStorehouseCargoTypeService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfLogisticsStorehouseCargoTypeServiceImpl implements CfLogisticsStorehouseCargoTypeService {

    @Autowired
    private CfLogisticsStorehouseCargoTypeMapper cfLogisticsStorehouseCargoTypeMapper;
    @Autowired
    private IdWorker idWorker;

    @Override
    public CfLogisticsStorehouseCargoType add(CfLogisticsStorehouseCargoType cfLogisticsStorehouseCargoType) {
        cfLogisticsStorehouseCargoType.setId(idWorker.nextLongId());
        cfLogisticsStorehouseCargoTypeMapper.insertSelective(cfLogisticsStorehouseCargoType);
        return cfLogisticsStorehouseCargoType;
    }

    @Override
    public CfLogisticsStorehouseCargoType update(CfLogisticsStorehouseCargoType cfLogisticsStorehouseCargoType) {
        cfLogisticsStorehouseCargoTypeMapper.updateByPrimaryKeySelective(cfLogisticsStorehouseCargoType);
        return cfLogisticsStorehouseCargoType;
    }

    @Override
    public Integer delete(Long id) {
        return cfLogisticsStorehouseCargoTypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer deleteByQuery(CfLogisticsStorehouseCargoTypeQuery cfLogisticsStorehouseCargoTypeQuery) {
        return cfLogisticsStorehouseCargoTypeMapper.deleteByExample(getExampleByQuery(cfLogisticsStorehouseCargoTypeQuery));
    }

    @Override
    public List<CfLogisticsStorehouseCargoType> getListByQuery(CfLogisticsStorehouseCargoTypeQuery cfLogisticsStorehouseCargoTypeQuery) {
        return cfLogisticsStorehouseCargoTypeMapper.selectByExample(getExampleByQuery(cfLogisticsStorehouseCargoTypeQuery));
    }

    @Override
    public Integer countByQuery(CfLogisticsStorehouseCargoTypeQuery cfLogisticsStorehouseCargoTypeQuery) {
        cfLogisticsStorehouseCargoTypeQuery.setPage(null);
        cfLogisticsStorehouseCargoTypeQuery.setOrderBy(null);
        return cfLogisticsStorehouseCargoTypeMapper.countByExample(getExampleByQuery(cfLogisticsStorehouseCargoTypeQuery));
    }

    @Override
    public CfLogisticsStorehouseCargoTypeExample getExampleByQuery(CfLogisticsStorehouseCargoTypeQuery cfLogisticsStorehouseCargoTypeQuery) {
        CfLogisticsStorehouseCargoTypeExample cfLogisticsStorehouseCargoTypeExample = new CfLogisticsStorehouseCargoTypeExample();
        CfLogisticsStorehouseCargoTypeExample.Criteria criteria = cfLogisticsStorehouseCargoTypeExample.createCriteria();
        if(cfLogisticsStorehouseCargoTypeQuery.getLogisticsStorehouseId()!=null){
            criteria.andLogisticsStorehouseIdEqualTo(cfLogisticsStorehouseCargoTypeQuery.getLogisticsStorehouseId());
        }
        if(StringUtils.isNotEmpty(cfLogisticsStorehouseCargoTypeQuery.getOrderBy())){
            cfLogisticsStorehouseCargoTypeExample.setOrderByClause(cfLogisticsStorehouseCargoTypeQuery.getOrderBy());
        }
        if(cfLogisticsStorehouseCargoTypeQuery.getPage()!=null && cfLogisticsStorehouseCargoTypeQuery.getSize()!=null){
            PageHelper.startPage(cfLogisticsStorehouseCargoTypeQuery.getPage(), cfLogisticsStorehouseCargoTypeQuery.getSize());
        }
        return cfLogisticsStorehouseCargoTypeExample;
    }
}
