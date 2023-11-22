package com.cf.logistics.service.impl;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.IdWorker;
import com.cf.logistics.dao.mapper.CfLogisticsCargoTypeMapper;
import com.cf.logistics.domain.CfLogisticsCargoType;
import com.cf.logistics.domain.CfLogisticsCargoTypeExample;
import com.cf.logistics.domain.request.CfLogisticsCargoTypeQuery;
import com.cf.logistics.service.CfLogisticsCargoTypeService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfLogisticsCargoTypeServiceImpl implements CfLogisticsCargoTypeService {

    @Autowired
    private CfLogisticsCargoTypeMapper CfLogisticsCargoTypeMapper;
    @Autowired
    private IdWorker idWorker;

    @Override
    public CfLogisticsCargoType add(CfLogisticsCargoType cfLogisticsCargoType) {
        if(cfLogisticsCargoType.getId()==null){
            cfLogisticsCargoType.setId(idWorker.nextLongId());
        }
        CfLogisticsCargoTypeMapper.insertSelective(cfLogisticsCargoType);
        return cfLogisticsCargoType;
    }

    @Override
    public CfLogisticsCargoType update(CfLogisticsCargoType cfLogisticsCargoType) {
        CfLogisticsCargoTypeMapper.updateByPrimaryKeySelective(cfLogisticsCargoType);
        return cfLogisticsCargoType;
    }

    @Override
    public int updateByQuery(CfLogisticsCargoType CfLogisticsCargoType, CfLogisticsCargoTypeQuery cfLogisticsCargoTypeQuery) {
        return CfLogisticsCargoTypeMapper.updateByExampleSelective(CfLogisticsCargoType,getExampleByQuery(cfLogisticsCargoTypeQuery));
    }

    @Override
    public int delete(Long id) {
        return CfLogisticsCargoTypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public CfLogisticsCargoType findById(Long id) {
        return CfLogisticsCargoTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public CfLogisticsCargoType findById(Long id, boolean expectEmpty) {
        CfLogisticsCargoType cfLogisticsCargoType = findById(id);
        if(expectEmpty && cfLogisticsCargoType!=null){
            ExceptionCast.cast(CommonCode.DUPLICATE_DATA);
        }
        if(!expectEmpty && cfLogisticsCargoType==null){
            ExceptionCast.cast(CommonCode.NO_MORE_DATAS);
        }
        return cfLogisticsCargoType;
    }

    @Override
    public List<CfLogisticsCargoType> getListByQuery(CfLogisticsCargoTypeQuery cfLogisticsCargoTypeQuery) {
        return CfLogisticsCargoTypeMapper.selectByExample(getExampleByQuery(cfLogisticsCargoTypeQuery));
    }

    @Override
    public Integer countByQuery(CfLogisticsCargoTypeQuery cfLogisticsCargoTypeQuery) {
        cfLogisticsCargoTypeQuery.setPage(null);
        cfLogisticsCargoTypeQuery.setOrderBy(null);
        return CfLogisticsCargoTypeMapper.countByExample(getExampleByQuery(cfLogisticsCargoTypeQuery));
    }

    @Override
    public CfLogisticsCargoTypeExample getExampleByQuery(CfLogisticsCargoTypeQuery cfLogisticsCargoTypeQuery) {
        CfLogisticsCargoTypeExample cfLogisticsCargoTypeExample = new CfLogisticsCargoTypeExample();
        CfLogisticsCargoTypeExample.Criteria criteria = cfLogisticsCargoTypeExample.createCriteria();

        if(StringUtils.isNotEmpty(cfLogisticsCargoTypeQuery.getOrderBy())){
            cfLogisticsCargoTypeExample.setOrderByClause(cfLogisticsCargoTypeQuery.getOrderBy());
        }
        if(cfLogisticsCargoTypeQuery.getPage()!=null && cfLogisticsCargoTypeQuery.getSize()!=null){
            PageHelper.startPage(cfLogisticsCargoTypeQuery.getPage(), cfLogisticsCargoTypeQuery.getSize());
        }
        return cfLogisticsCargoTypeExample;
    }
}
