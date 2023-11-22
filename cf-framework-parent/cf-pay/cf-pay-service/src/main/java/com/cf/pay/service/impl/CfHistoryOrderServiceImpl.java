package com.cf.pay.service.impl;

import com.cf.framework.utils.IdWorker;
import com.cf.pay.dao.mapper.CfHistoryOrderMapper;
import com.cf.pay.domain.CfHistoryOrder;
import com.cf.pay.domain.CfHistoryOrderExample;
import com.cf.pay.domain.request.CfHistoryOrderQuery;
import com.cf.pay.service.CfHistoryOrderService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfHistoryOrderServiceImpl implements CfHistoryOrderService {

    @Autowired
    private CfHistoryOrderMapper cfHistoryOrderMapper;
    @Autowired
    private IdWorker idWorker;

    @Override
    public CfHistoryOrder add(CfHistoryOrder cfHistoryOrder) {
        cfHistoryOrder.setId(idWorker.nextId());
        cfHistoryOrderMapper.insertSelective(cfHistoryOrder);
        return cfHistoryOrder;
    }

    @Override
    public CfHistoryOrderExample getExampleByQuery(CfHistoryOrderQuery cfHistoryOrderQuery) {
        CfHistoryOrderExample cfHistoryOrderExample = new CfHistoryOrderExample();
        CfHistoryOrderExample.Criteria criteria = cfHistoryOrderExample.createCriteria();
        if(cfHistoryOrderQuery.getShopId()!=null){
            criteria.andShopIdEqualTo(cfHistoryOrderQuery.getShopId());
        }
        if(cfHistoryOrderQuery.getOrderTime()!=null){
            criteria.andOrderTimeEqualTo(cfHistoryOrderQuery.getOrderTime());
        }
        if(StringUtils.isNotEmpty(cfHistoryOrderQuery.getOrderBy())){
            cfHistoryOrderExample.setOrderByClause(cfHistoryOrderQuery.getOrderBy());
        }

        if(cfHistoryOrderQuery.getPage()!=null && cfHistoryOrderQuery.getSize()!=null){
            PageHelper.startPage(cfHistoryOrderQuery.getPage(), cfHistoryOrderQuery.getSize());
        }

        return cfHistoryOrderExample;
    }

    @Override
    public List<CfHistoryOrder> getListByQuery(CfHistoryOrderQuery cfHistoryOrderQuery) {
        return cfHistoryOrderMapper.selectByExample(getExampleByQuery(cfHistoryOrderQuery));
    }

    @Override
    public Integer countByQuery(CfHistoryOrderQuery cfHistoryOrderQuery) {
        cfHistoryOrderQuery.setPage(null);
        return cfHistoryOrderMapper.countByExample(getExampleByQuery(cfHistoryOrderQuery));
    }
}
