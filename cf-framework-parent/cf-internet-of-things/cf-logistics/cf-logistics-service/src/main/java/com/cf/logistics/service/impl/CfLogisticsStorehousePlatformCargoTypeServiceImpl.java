package com.cf.logistics.service.impl;

import com.cf.framework.utils.IdWorker;
import com.cf.logistics.dao.mapper.CfLogisticsStorehousePlatformCargoTypeMapper;
import com.cf.logistics.domain.CfLogisticsStorehouse;
import com.cf.logistics.domain.CfLogisticsStorehousePlatformCargoType;
import com.cf.logistics.domain.CfLogisticsStorehousePlatformCargoTypeExample;
import com.cf.logistics.domain.request.CfLogisticsStorehousePlatformCargoTypeQuery;
import com.cf.logistics.service.CfLogisticsStorehousePlatformCargoTypeService;
import com.cf.logistics.service.CfLogisticsStorehouseService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfLogisticsStorehousePlatformCargoTypeServiceImpl implements CfLogisticsStorehousePlatformCargoTypeService {

    @Autowired
    private CfLogisticsStorehousePlatformCargoTypeMapper cfLogisticsStorehousePlatformCargoTypeMapper;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private CfLogisticsStorehouseService cfLogisticsStorehouseService;

    @Override
    public CfLogisticsStorehousePlatformCargoType add(CfLogisticsStorehousePlatformCargoType cfLogisticsStorehousePlatformCargoType) {
        cfLogisticsStorehousePlatformCargoType.setId(idWorker.nextLongId());
        bindFactoryId(cfLogisticsStorehousePlatformCargoType);
        cfLogisticsStorehousePlatformCargoTypeMapper.insertSelective(cfLogisticsStorehousePlatformCargoType);
        return cfLogisticsStorehousePlatformCargoType;
    }

    @Override
    public CfLogisticsStorehousePlatformCargoType update(CfLogisticsStorehousePlatformCargoType cfLogisticsStorehousePlatformCargoType) {
        bindFactoryId(cfLogisticsStorehousePlatformCargoType);
        cfLogisticsStorehousePlatformCargoTypeMapper.updateByPrimaryKeySelective(cfLogisticsStorehousePlatformCargoType);
        return cfLogisticsStorehousePlatformCargoType;
    }

    /**
     * 绑定工厂id
     * @param cfLogisticsStorehousePlatformCargoType
     */
    private void bindFactoryId(CfLogisticsStorehousePlatformCargoType cfLogisticsStorehousePlatformCargoType){
        cfLogisticsStorehousePlatformCargoType.setFactoryId(cfLogisticsStorehouseService.findById(cfLogisticsStorehousePlatformCargoType.getLogisticsStorehouseId(), false).getFactoryId());
    }

    @Override
    public Integer delete(Long id) {
        return cfLogisticsStorehousePlatformCargoTypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer deleteByQuery(CfLogisticsStorehousePlatformCargoTypeQuery cfLogisticsStorehousePlatformCargoTypeQuery) {
        return cfLogisticsStorehousePlatformCargoTypeMapper.deleteByExample(getExampleByQuery(cfLogisticsStorehousePlatformCargoTypeQuery));
    }

    @Override
    public List<CfLogisticsStorehousePlatformCargoType> getListByQuery(CfLogisticsStorehousePlatformCargoTypeQuery cfLogisticsStorehousePlatformCargoTypeQuery) {
        return cfLogisticsStorehousePlatformCargoTypeMapper.selectByExample(getExampleByQuery(cfLogisticsStorehousePlatformCargoTypeQuery));
    }

    @Override
    public Integer countByQuery(CfLogisticsStorehousePlatformCargoTypeQuery cfLogisticsStorehousePlatformCargoTypeQuery) {
        cfLogisticsStorehousePlatformCargoTypeQuery.setPage(null);
        cfLogisticsStorehousePlatformCargoTypeQuery.setOrderBy(null);
        return cfLogisticsStorehousePlatformCargoTypeMapper.countByExample(getExampleByQuery(cfLogisticsStorehousePlatformCargoTypeQuery));
    }

    @Override
    public CfLogisticsStorehousePlatformCargoTypeExample getExampleByQuery(CfLogisticsStorehousePlatformCargoTypeQuery cfLogisticsStorehousePlatformCargoTypeQuery) {
        CfLogisticsStorehousePlatformCargoTypeExample cfLogisticsStorehousePlatformCargoTypeExample = new CfLogisticsStorehousePlatformCargoTypeExample();
        CfLogisticsStorehousePlatformCargoTypeExample.Criteria criteria = cfLogisticsStorehousePlatformCargoTypeExample.createCriteria();
        if(cfLogisticsStorehousePlatformCargoTypeQuery.getLogisticsStorehouseId()!=null){
            criteria.andLogisticsStorehouseIdEqualTo(cfLogisticsStorehousePlatformCargoTypeQuery.getLogisticsStorehouseId());
        }
        if(cfLogisticsStorehousePlatformCargoTypeQuery.getLogisticsStorehousePlatformId()!=null){
            criteria.andLogisticsStorehousePlatformIdEqualTo(cfLogisticsStorehousePlatformCargoTypeQuery.getLogisticsStorehousePlatformId());
        }
        if(cfLogisticsStorehousePlatformCargoTypeQuery.getLogisticsStorehousePlatformIds()!=null && cfLogisticsStorehousePlatformCargoTypeQuery.getLogisticsStorehousePlatformIds().size()>0){
            criteria.andLogisticsStorehousePlatformIdIn(cfLogisticsStorehousePlatformCargoTypeQuery.getLogisticsStorehousePlatformIds());
        }
        if(cfLogisticsStorehousePlatformCargoTypeQuery.getFactoryId()!=null){
            criteria.andFactoryIdEqualTo(cfLogisticsStorehousePlatformCargoTypeQuery.getFactoryId());
        }
        if(cfLogisticsStorehousePlatformCargoTypeQuery.getCargoType()!=null){
            criteria.andCargoTypeEqualTo(cfLogisticsStorehousePlatformCargoTypeQuery.getCargoType());
        }
        if(StringUtils.isNotEmpty(cfLogisticsStorehousePlatformCargoTypeQuery.getOrderBy())){
            cfLogisticsStorehousePlatformCargoTypeExample.setOrderByClause(cfLogisticsStorehousePlatformCargoTypeQuery.getOrderBy());
        }
        if(cfLogisticsStorehousePlatformCargoTypeQuery.getPage()!=null && cfLogisticsStorehousePlatformCargoTypeQuery.getSize()!=null){
            PageHelper.startPage(cfLogisticsStorehousePlatformCargoTypeQuery.getPage(), cfLogisticsStorehousePlatformCargoTypeQuery.getSize());
        }
        return cfLogisticsStorehousePlatformCargoTypeExample;
    }
}
