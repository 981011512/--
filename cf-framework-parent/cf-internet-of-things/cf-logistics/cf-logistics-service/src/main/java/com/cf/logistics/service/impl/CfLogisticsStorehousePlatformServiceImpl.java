package com.cf.logistics.service.impl;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.IdWorker;
import com.cf.logistics.domain.CfLogisticsStorehousePlatform;
import com.cf.logistics.domain.CfLogisticsStorehousePlatformExample;
import com.cf.logistics.domain.request.CfLogisticsStorehousePlatformQuery;
import com.cf.logistics.service.CfLogisticsStorehousePlatformService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import com.cf.logistics.dao.mapper.CfLogisticsStorehousePlatformMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfLogisticsStorehousePlatformServiceImpl implements CfLogisticsStorehousePlatformService {

    @Autowired
    private CfLogisticsStorehousePlatformMapper cfLogisticsStorehousePlatformMapper;
    @Autowired
    private IdWorker idWorker;

    @Override
    public CfLogisticsStorehousePlatform add(CfLogisticsStorehousePlatform cfLogisticsStorehousePlatform) {
        if(cfLogisticsStorehousePlatform.getId()==null){
            cfLogisticsStorehousePlatform.setId(idWorker.nextLongId());
        }
        cfLogisticsStorehousePlatformMapper.insertSelective(cfLogisticsStorehousePlatform);
        return cfLogisticsStorehousePlatform;
    }

    @Override
    public CfLogisticsStorehousePlatform update(CfLogisticsStorehousePlatform cfLogisticsStorehousePlatform) {
        if(cfLogisticsStorehousePlatform.getUsedQueueCapacity()!=null && cfLogisticsStorehousePlatform.getQueueCapacity()!=null && cfLogisticsStorehousePlatform.getUsedQueueCapacity()>=cfLogisticsStorehousePlatform.getQueueCapacity()){
            //如果已经使用容量超额了，设置状态为爆满
            cfLogisticsStorehousePlatform.setPlatformStatus((byte)2);
        }
        cfLogisticsStorehousePlatformMapper.updateByPrimaryKeySelective(cfLogisticsStorehousePlatform);
        return cfLogisticsStorehousePlatform;
    }

    @Override
    public int updateByQuery(CfLogisticsStorehousePlatform CfLogisticsStorehousePlatform, CfLogisticsStorehousePlatformQuery cfLogisticsStorehousePlatformQuery) {
        return cfLogisticsStorehousePlatformMapper.updateByExampleSelective(CfLogisticsStorehousePlatform,getExampleByQuery(cfLogisticsStorehousePlatformQuery));
    }

    @Override
    public int delete(Long id) {
        return cfLogisticsStorehousePlatformMapper.deleteByPrimaryKey(id);
    }

    @Override
    public CfLogisticsStorehousePlatform findById(Long id) {
        return cfLogisticsStorehousePlatformMapper.selectByPrimaryKey(id);
    }

    @Override
    public CfLogisticsStorehousePlatform findById(Long id, boolean expectEmpty) {
        CfLogisticsStorehousePlatform cfLogisticsStorehousePlatform = findById(id);
        if(expectEmpty && cfLogisticsStorehousePlatform!=null){
            ExceptionCast.cast(CommonCode.DUPLICATE_DATA);
        }
        if(!expectEmpty && cfLogisticsStorehousePlatform==null){
            ExceptionCast.cast(CommonCode.NO_MORE_DATAS);
        }
        return cfLogisticsStorehousePlatform;
    }

    @Override
    public List<CfLogisticsStorehousePlatform> getListByQuery(CfLogisticsStorehousePlatformQuery cfLogisticsStorehousePlatformQuery) {
        return cfLogisticsStorehousePlatformMapper.selectByExample(getExampleByQuery(cfLogisticsStorehousePlatformQuery));
    }

    @Override
    public Integer countByQuery(CfLogisticsStorehousePlatformQuery cfLogisticsStorehousePlatformQuery) {
        cfLogisticsStorehousePlatformQuery.setPage(null);
        cfLogisticsStorehousePlatformQuery.setOrderBy(null);
        return cfLogisticsStorehousePlatformMapper.countByExample(getExampleByQuery(cfLogisticsStorehousePlatformQuery));
    }

    @Override
    public CfLogisticsStorehousePlatformExample getExampleByQuery(CfLogisticsStorehousePlatformQuery cfLogisticsStorehousePlatformQuery) {
        CfLogisticsStorehousePlatformExample cfLogisticsStorehousePlatformExample = new CfLogisticsStorehousePlatformExample();
        CfLogisticsStorehousePlatformExample.Criteria criteria = cfLogisticsStorehousePlatformExample.createCriteria();

        if(cfLogisticsStorehousePlatformQuery.getIds()!=null && cfLogisticsStorehousePlatformQuery.getIds().size()>0){
            criteria.andIdIn(cfLogisticsStorehousePlatformQuery.getIds());
        }
        if(cfLogisticsStorehousePlatformQuery.getStorehouseId()!=null){
            criteria.andStorehouseIdEqualTo(cfLogisticsStorehousePlatformQuery.getStorehouseId());
        }
        if(cfLogisticsStorehousePlatformQuery.getHandleUid()!=null){
            criteria.andHandleUidEqualTo(cfLogisticsStorehousePlatformQuery.getHandleUid());
        }

        if(StringUtils.isNotEmpty(cfLogisticsStorehousePlatformQuery.getOrderBy())){
            cfLogisticsStorehousePlatformExample.setOrderByClause(cfLogisticsStorehousePlatformQuery.getOrderBy());
        }
        if(cfLogisticsStorehousePlatformQuery.getPage()!=null && cfLogisticsStorehousePlatformQuery.getSize()!=null){
            PageHelper.startPage(cfLogisticsStorehousePlatformQuery.getPage(), cfLogisticsStorehousePlatformQuery.getSize());
        }
        return cfLogisticsStorehousePlatformExample;
    }
    
}
