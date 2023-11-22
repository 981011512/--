package com.cf.logistics.service.impl;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.IdWorker;
import com.cf.logistics.domain.CfLogisticsQueue;
import com.cf.logistics.domain.CfLogisticsQueueExample;
import com.cf.logistics.domain.request.CfLogisticsQueueQuery;
import com.cf.logistics.service.CfLogisticsQueueService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfLogisticsQueueServiceImpl implements CfLogisticsQueueService {

    @Autowired
    private com.cf.logistics.dao.mapper.CfLogisticsQueueMapper CfLogisticsQueueMapper;
    @Autowired
    private IdWorker idWorker;

    @Override
    public CfLogisticsQueue add(CfLogisticsQueue cfLogisticsQueue) {
        if(cfLogisticsQueue.getId()==null){
            cfLogisticsQueue.setId(idWorker.nextLongId());
        }
        CfLogisticsQueueMapper.insertSelective(cfLogisticsQueue);
        return cfLogisticsQueue;
    }

    @Override
    public CfLogisticsQueue update(CfLogisticsQueue cfLogisticsQueue) {
        CfLogisticsQueueMapper.updateByPrimaryKeySelective(cfLogisticsQueue);
        return cfLogisticsQueue;
    }

    @Override
    public int updateByQuery(CfLogisticsQueue CfLogisticsQueue, CfLogisticsQueueQuery cfLogisticsQueueQuery) {
        return CfLogisticsQueueMapper.updateByExampleSelective(CfLogisticsQueue,getExampleByQuery(cfLogisticsQueueQuery));
    }

    @Override
    public int delete(Long id) {
        return CfLogisticsQueueMapper.deleteByPrimaryKey(id);
    }

    @Override
    public CfLogisticsQueue findById(Long id) {
        return CfLogisticsQueueMapper.selectByPrimaryKey(id);
    }

    @Override
    public CfLogisticsQueue findById(Long id, boolean expectEmpty) {
        CfLogisticsQueue cfLogisticsQueue = findById(id);
        if(expectEmpty && cfLogisticsQueue!=null){
            ExceptionCast.cast(CommonCode.DUPLICATE_DATA);
        }
        if(!expectEmpty && cfLogisticsQueue==null){
            ExceptionCast.cast(CommonCode.NO_MORE_DATAS);
        }
        return cfLogisticsQueue;
    }

    @Override
    public List<CfLogisticsQueue> getListByQuery(CfLogisticsQueueQuery cfLogisticsQueueQuery) {
        return CfLogisticsQueueMapper.selectByExample(getExampleByQuery(cfLogisticsQueueQuery));
    }

    @Override
    public Integer countByQuery(CfLogisticsQueueQuery cfLogisticsQueueQuery) {
        cfLogisticsQueueQuery.setPage(null);
        cfLogisticsQueueQuery.setOrderBy(null);
        return CfLogisticsQueueMapper.countByExample(getExampleByQuery(cfLogisticsQueueQuery));
    }

    @Override
    public CfLogisticsQueueExample getExampleByQuery(CfLogisticsQueueQuery cfLogisticsQueueQuery) {
        CfLogisticsQueueExample cfLogisticsQueueExample = new CfLogisticsQueueExample();
        CfLogisticsQueueExample.Criteria criteria = cfLogisticsQueueExample.createCriteria();

        if(cfLogisticsQueueQuery.getLogisticsStorehouseId()!=null){
            criteria.andLogisticsStorehouseIdEqualTo(cfLogisticsQueueQuery.getLogisticsStorehouseId());
        }
        if(cfLogisticsQueueQuery.getLogisticsStorehouseIds()!=null && cfLogisticsQueueQuery.getLogisticsStorehouseIds().size()>0){
            criteria.andLogisticsStorehouseIdIn(cfLogisticsQueueQuery.getLogisticsStorehouseIds());
        }
        if(cfLogisticsQueueQuery.getLogisticsPlatformId()!=null){
            criteria.andLogisticsPlatformIdEqualTo(cfLogisticsQueueQuery.getLogisticsPlatformId());
        }

        if(StringUtils.isNotEmpty(cfLogisticsQueueQuery.getOrderBy())){
            cfLogisticsQueueExample.setOrderByClause(cfLogisticsQueueQuery.getOrderBy());
        }
        if(cfLogisticsQueueQuery.getPage()!=null && cfLogisticsQueueQuery.getSize()!=null){
            PageHelper.startPage(cfLogisticsQueueQuery.getPage(), cfLogisticsQueueQuery.getSize());
        }
        return cfLogisticsQueueExample;
    }
}
