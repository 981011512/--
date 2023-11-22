package com.cf.logistics.service.impl;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.IdWorker;
import com.cf.logistics.dao.mapper.CfLogisticsQueuingAreaPlatformMapper;
import com.cf.logistics.domain.CfLogisticsQueuingAreaPlatform;
import com.cf.logistics.domain.CfLogisticsQueuingAreaPlatformExample;
import com.cf.logistics.domain.request.CfLogisticsQueuingAreaPlatformQuery;
import com.cf.logistics.service.CfLogisticsQueuingAreaPlatformService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfLogisticsQueuingAreaPlatformServiceImpl implements CfLogisticsQueuingAreaPlatformService {

    @Autowired
    private CfLogisticsQueuingAreaPlatformMapper cfLogisticsQueuingAreaPlatformMapper;
    @Autowired
    private IdWorker idWorker;

    @Override
    public CfLogisticsQueuingAreaPlatform add(CfLogisticsQueuingAreaPlatform cfLogisticsQueuingAreaPlatform) {
        cfLogisticsQueuingAreaPlatform.setId(idWorker.nextLongId());
        cfLogisticsQueuingAreaPlatformMapper.insertSelective(cfLogisticsQueuingAreaPlatform);
        return cfLogisticsQueuingAreaPlatform;
    }

    @Override
    public CfLogisticsQueuingAreaPlatform update(CfLogisticsQueuingAreaPlatform cfLogisticsQueuingAreaPlatform) {
        cfLogisticsQueuingAreaPlatformMapper.updateByPrimaryKeySelective(cfLogisticsQueuingAreaPlatform);
        return cfLogisticsQueuingAreaPlatform;
    }

    @Override
    public Integer delete(Long id) {
        return cfLogisticsQueuingAreaPlatformMapper.deleteByPrimaryKey(id);
    }

    @Override
    public CfLogisticsQueuingAreaPlatform findById(Long id) {
        return cfLogisticsQueuingAreaPlatformMapper.selectByPrimaryKey(id);
    }

    @Override
    public CfLogisticsQueuingAreaPlatform findById(Long id, boolean expectEmpty) {
        CfLogisticsQueuingAreaPlatform cfLogisticsQueuingAreaPlatform = findById(id);
        if(expectEmpty && cfLogisticsQueuingAreaPlatform!=null){
            ExceptionCast.cast(CommonCode.DUPLICATE_DATA);
        }
        if(!expectEmpty && cfLogisticsQueuingAreaPlatform==null){
            ExceptionCast.cast(CommonCode.NO_MORE_DATAS);
        }
        return cfLogisticsQueuingAreaPlatform;
    }

    @Override
    public CfLogisticsQueuingAreaPlatformExample getExampleByQuery(CfLogisticsQueuingAreaPlatformQuery cfLogisticsQueuingAreaPlatformQuery) {
        CfLogisticsQueuingAreaPlatformExample cfLogisticsQueuingAreaPlatformExample = new CfLogisticsQueuingAreaPlatformExample();
        CfLogisticsQueuingAreaPlatformExample.Criteria criteria = cfLogisticsQueuingAreaPlatformExample.createCriteria();

        if(cfLogisticsQueuingAreaPlatformQuery.getLogisticsStorehousePlatformIds()!=null && cfLogisticsQueuingAreaPlatformQuery.getLogisticsStorehousePlatformIds().size()>0){
            criteria.andLogisticsStorehousePlatformIdIn(cfLogisticsQueuingAreaPlatformQuery.getLogisticsStorehousePlatformIds());
        }
        if(StringUtils.isNotEmpty(cfLogisticsQueuingAreaPlatformQuery.getOrderBy())){
            cfLogisticsQueuingAreaPlatformExample.setOrderByClause(cfLogisticsQueuingAreaPlatformQuery.getOrderBy());
        }
        if(cfLogisticsQueuingAreaPlatformQuery.getPage()!=null && cfLogisticsQueuingAreaPlatformQuery.getSize()!=null){
            PageHelper.startPage(cfLogisticsQueuingAreaPlatformQuery.getPage(), cfLogisticsQueuingAreaPlatformQuery.getSize());
        }
        return cfLogisticsQueuingAreaPlatformExample;
    }

    @Override
    public List<CfLogisticsQueuingAreaPlatform> getListByQuery(CfLogisticsQueuingAreaPlatformQuery cfLogisticsQueuingAreaPlatformQuery) {
        return cfLogisticsQueuingAreaPlatformMapper.selectByExample(getExampleByQuery(cfLogisticsQueuingAreaPlatformQuery));
    }

    @Override
    public Integer countByQuery(CfLogisticsQueuingAreaPlatformQuery cfLogisticsQueuingAreaPlatformQuery) {
        cfLogisticsQueuingAreaPlatformQuery.setPage(null);
        cfLogisticsQueuingAreaPlatformQuery.setOrderBy(null);
        return cfLogisticsQueuingAreaPlatformMapper.countByExample(getExampleByQuery(cfLogisticsQueuingAreaPlatformQuery));
    }

    @Override
    public List<CfLogisticsQueuingAreaPlatform> selectByQuery(CfLogisticsQueuingAreaPlatformQuery cfLogisticsQueuingAreaPlatformQuery) {
        return cfLogisticsQueuingAreaPlatformMapper.selectByQuery(cfLogisticsQueuingAreaPlatformQuery);
    }
}
