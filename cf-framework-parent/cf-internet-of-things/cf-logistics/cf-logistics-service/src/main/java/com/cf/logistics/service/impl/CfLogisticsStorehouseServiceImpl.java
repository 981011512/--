package com.cf.logistics.service.impl;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.IdWorker;
import com.cf.logistics.dao.mapper.CfLogisticsStorehouseMapper;
import com.cf.logistics.domain.CfLogisticsStorehouse;
import com.cf.logistics.domain.CfLogisticsStorehouseExample;
import com.cf.logistics.domain.request.CfLogisticsStorehouseQuery;
import com.cf.logistics.service.CfLogisticsStorehouseService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfLogisticsStorehouseServiceImpl implements CfLogisticsStorehouseService {

    @Autowired
    private CfLogisticsStorehouseMapper cfLogisticsStorehouseMapper;
    @Autowired
    private IdWorker idWorker;

    @Override
    public CfLogisticsStorehouse add(CfLogisticsStorehouse cfLogisticsStorehouse) {
        if(cfLogisticsStorehouse.getId()==null){
            cfLogisticsStorehouse.setId(idWorker.nextLongId());
        }
        cfLogisticsStorehouseMapper.insertSelective(cfLogisticsStorehouse);
        return cfLogisticsStorehouse;
    }

    @Override
    public CfLogisticsStorehouse update(CfLogisticsStorehouse cfLogisticsStorehouse) {
        cfLogisticsStorehouseMapper.updateByPrimaryKeySelective(cfLogisticsStorehouse);
        return cfLogisticsStorehouse;
    }

    @Override
    public int updateByQuery(CfLogisticsStorehouse cfLogisticsStorehouse, CfLogisticsStorehouseQuery cfLogisticsStorehouseQuery) {
        return cfLogisticsStorehouseMapper.updateByExampleSelective(cfLogisticsStorehouse,getExampleByQuery(cfLogisticsStorehouseQuery));
    }

    @Override
    public int delete(Long id) {
        return cfLogisticsStorehouseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public CfLogisticsStorehouse findById(Long id) {
        return cfLogisticsStorehouseMapper.selectByPrimaryKey(id);
    }

    @Override
    public CfLogisticsStorehouse findById(Long id, boolean expectEmpty) {
        CfLogisticsStorehouse cfLogisticsStorehouse = findById(id);
        if(expectEmpty && cfLogisticsStorehouse!=null){
            ExceptionCast.cast(CommonCode.DUPLICATE_DATA);
        }
        if(!expectEmpty && cfLogisticsStorehouse==null){
            ExceptionCast.cast(CommonCode.NO_MORE_DATAS,"指定的物流仓库不存在");
        }
        return cfLogisticsStorehouse;
    }

    @Override
    public List<CfLogisticsStorehouse> getListByQuery(CfLogisticsStorehouseQuery cfLogisticsStorehouseQuery) {
        return cfLogisticsStorehouseMapper.selectByExample(getExampleByQuery(cfLogisticsStorehouseQuery));
    }

    @Override
    public Integer countByQuery(CfLogisticsStorehouseQuery cfLogisticsStorehouseQuery) {
        cfLogisticsStorehouseQuery.setPage(null);
        cfLogisticsStorehouseQuery.setOrderBy(null);
        return cfLogisticsStorehouseMapper.countByExample(getExampleByQuery(cfLogisticsStorehouseQuery));
    }

    @Override
    public CfLogisticsStorehouseExample getExampleByQuery(CfLogisticsStorehouseQuery cfLogisticsStorehouseQuery) {
        CfLogisticsStorehouseExample cfLogisticsStorehouseExample = new CfLogisticsStorehouseExample();
        CfLogisticsStorehouseExample.Criteria criteria = cfLogisticsStorehouseExample.createCriteria();

        if(cfLogisticsStorehouseQuery.getIds()!=null && cfLogisticsStorehouseQuery.getIds().size()>0){
            criteria.andIdIn(cfLogisticsStorehouseQuery.getIds());
        }
        if(StringUtils.isNotEmpty(cfLogisticsStorehouseQuery.getStorehouseName())){
            criteria.andStorehouseNameLike("%"+cfLogisticsStorehouseQuery.getStorehouseName()+"%");
        }
        if(cfLogisticsStorehouseQuery.getCountryId()!=null){
            criteria.andCountryIdEqualTo(cfLogisticsStorehouseQuery.getCountryId());
        }
        if(cfLogisticsStorehouseQuery.getProvinceId()!=null){
            criteria.andProvinceIdEqualTo(cfLogisticsStorehouseQuery.getProvinceId());
        }
        if(cfLogisticsStorehouseQuery.getStateOrCityId()!=null){
            criteria.andStateOrCityIdEqualTo(cfLogisticsStorehouseQuery.getStateOrCityId());
        }
        if(cfLogisticsStorehouseQuery.getZoneOrCountyId()!=null){
            criteria.andZoneOrCountyIdEqualTo(cfLogisticsStorehouseQuery.getZoneOrCountyId());
        }
        if(cfLogisticsStorehouseQuery.getFactoryId()!=null){
            criteria.andFactoryIdEqualTo(cfLogisticsStorehouseQuery.getFactoryId());
        }

        if(StringUtils.isNotEmpty(cfLogisticsStorehouseQuery.getOrderBy())){
            cfLogisticsStorehouseExample.setOrderByClause(cfLogisticsStorehouseQuery.getOrderBy());
        }
        if(cfLogisticsStorehouseQuery.getPage()!=null && cfLogisticsStorehouseQuery.getSize()!=null){
            PageHelper.startPage(cfLogisticsStorehouseQuery.getPage(), cfLogisticsStorehouseQuery.getSize());
        }
        return cfLogisticsStorehouseExample;
    }

    @Override
    public List<CfLogisticsStorehouse> selectNearLogisticsStorehouse(CfLogisticsStorehouseQuery cfLogisticsStorehouseQuery) {
        return cfLogisticsStorehouseMapper.selectNearLogisticsStorehouse(cfLogisticsStorehouseQuery);
    }

    @Override
    public List<CfLogisticsStorehouse> selectListByQuery(CfLogisticsStorehouseQuery cfLogisticsStorehouseQuery) {
        return cfLogisticsStorehouseMapper.selectListByQuery(cfLogisticsStorehouseQuery);
    }
}
