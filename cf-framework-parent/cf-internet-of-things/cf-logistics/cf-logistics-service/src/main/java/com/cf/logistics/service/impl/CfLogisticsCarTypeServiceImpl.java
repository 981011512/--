package com.cf.logistics.service.impl;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.IdWorker;
import com.cf.logistics.domain.CfLogisticsCarType;
import com.cf.logistics.domain.CfLogisticsCarTypeExample;
import com.cf.logistics.domain.request.CfLogisticsCarTypeQuery;
import com.cf.logistics.service.CfLogisticsCarTypeService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfLogisticsCarTypeServiceImpl implements CfLogisticsCarTypeService {

    @Autowired
    private com.cf.logistics.dao.mapper.CfLogisticsCarTypeMapper CfLogisticsCarTypeMapper;
    @Autowired
    private IdWorker idWorker;

    @Override
    public CfLogisticsCarType add(CfLogisticsCarType cfLogisticsCarType) {
        if(cfLogisticsCarType.getId()==null){
            cfLogisticsCarType.setId(idWorker.nextLongId());
        }
        CfLogisticsCarTypeMapper.insertSelective(cfLogisticsCarType);
        return cfLogisticsCarType;
    }

    @Override
    public CfLogisticsCarType update(CfLogisticsCarType cfLogisticsCarType) {
        CfLogisticsCarTypeMapper.updateByPrimaryKeySelective(cfLogisticsCarType);
        return cfLogisticsCarType;
    }

    @Override
    public int updateByQuery(CfLogisticsCarType CfLogisticsCarType, CfLogisticsCarTypeQuery cfLogisticsCarTypeQuery) {
        return CfLogisticsCarTypeMapper.updateByExampleSelective(CfLogisticsCarType,getExampleByQuery(cfLogisticsCarTypeQuery));
    }

    @Override
    public int delete(Long id) {
        return CfLogisticsCarTypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public CfLogisticsCarType findById(Long id) {
        return CfLogisticsCarTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public CfLogisticsCarType findById(Long id, boolean expectEmpty) {
        CfLogisticsCarType cfLogisticsCarType = findById(id);
        if(expectEmpty && cfLogisticsCarType!=null){
            ExceptionCast.cast(CommonCode.DUPLICATE_DATA);
        }
        if(!expectEmpty && cfLogisticsCarType==null){
            ExceptionCast.cast(CommonCode.NO_MORE_DATAS);
        }
        return cfLogisticsCarType;
    }

    @Override
    public List<CfLogisticsCarType> getListByQuery(CfLogisticsCarTypeQuery cfLogisticsCarTypeQuery) {
        return CfLogisticsCarTypeMapper.selectByExample(getExampleByQuery(cfLogisticsCarTypeQuery));
    }

    @Override
    public Integer countByQuery(CfLogisticsCarTypeQuery cfLogisticsCarTypeQuery) {
        cfLogisticsCarTypeQuery.setPage(null);
        cfLogisticsCarTypeQuery.setOrderBy(null);
        return CfLogisticsCarTypeMapper.countByExample(getExampleByQuery(cfLogisticsCarTypeQuery));
    }

    @Override
    public CfLogisticsCarTypeExample getExampleByQuery(CfLogisticsCarTypeQuery cfLogisticsCarTypeQuery) {
        CfLogisticsCarTypeExample cfLogisticsCarTypeExample = new CfLogisticsCarTypeExample();
        CfLogisticsCarTypeExample.Criteria criteria = cfLogisticsCarTypeExample.createCriteria();

        if(StringUtils.isNotEmpty(cfLogisticsCarTypeQuery.getOrderBy())){
            cfLogisticsCarTypeExample.setOrderByClause(cfLogisticsCarTypeQuery.getOrderBy());
        }
        if(cfLogisticsCarTypeQuery.getPage()!=null && cfLogisticsCarTypeQuery.getSize()!=null){
            PageHelper.startPage(cfLogisticsCarTypeQuery.getPage(), cfLogisticsCarTypeQuery.getSize());
        }
        return cfLogisticsCarTypeExample;
    }
}
