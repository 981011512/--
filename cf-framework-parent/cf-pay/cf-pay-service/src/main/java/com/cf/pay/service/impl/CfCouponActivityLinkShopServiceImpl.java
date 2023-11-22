package com.cf.pay.service.impl;

import com.cf.framework.utils.IdWorker;
import com.cf.pay.dao.mapper.CfCouponActivityLinkShopMapper;
import com.cf.pay.domain.CfCouponActivityLinkShop;
import com.cf.pay.domain.CfCouponActivityLinkShopExample;
import com.cf.pay.domain.request.CfCouponActivityLinkShopQuery;
import com.cf.pay.service.CfCouponActivityLinkShopService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfCouponActivityLinkShopServiceImpl implements CfCouponActivityLinkShopService {

    @Autowired
    private CfCouponActivityLinkShopMapper cfCouponActivityLinkShopMapper;
    @Autowired
    private IdWorker idWorker;

    @Override
    public CfCouponActivityLinkShop add(CfCouponActivityLinkShop cfCouponActivityLinkShop) {
        cfCouponActivityLinkShop.setId(idWorker.nextId());
        cfCouponActivityLinkShopMapper.insert(cfCouponActivityLinkShop);
        return cfCouponActivityLinkShop;
    }

    @Override
    public CfCouponActivityLinkShop update(CfCouponActivityLinkShop cfCouponActivityLinkShop) {
        cfCouponActivityLinkShopMapper.updateByPrimaryKey(cfCouponActivityLinkShop);
        return cfCouponActivityLinkShop;
    }

    @Override
    public Integer delete(String id) {
        return cfCouponActivityLinkShopMapper.deleteByPrimaryKey(id);
    }

    @Override
    public CfCouponActivityLinkShopExample getExampleByQuery(CfCouponActivityLinkShopQuery cfCouponActivityLinkShopQuery) {
        CfCouponActivityLinkShopExample cfCouponActivityLinkShopExample = new CfCouponActivityLinkShopExample();
        CfCouponActivityLinkShopExample.Criteria criteria = cfCouponActivityLinkShopExample.createCriteria();
        if(StringUtils.isNotEmpty(cfCouponActivityLinkShopQuery.getCouponActivityId())){
            criteria.andCouponActivityIdEqualTo(cfCouponActivityLinkShopQuery.getCouponActivityId());
        }
        if(StringUtils.isNotEmpty(cfCouponActivityLinkShopQuery.getShopId())){
            criteria.andShopIdEqualTo(cfCouponActivityLinkShopQuery.getShopId());
        }
        if(StringUtils.isNotEmpty(cfCouponActivityLinkShopQuery.getScene())){
            criteria.andSceneEqualTo(cfCouponActivityLinkShopQuery.getScene());
        }
        if(cfCouponActivityLinkShopQuery.getRequireUsing()!=null){
            criteria.andRequireUsingEqualTo(cfCouponActivityLinkShopQuery.getRequireUsing());
        }
        if(cfCouponActivityLinkShopQuery.getPage()!=null && cfCouponActivityLinkShopQuery.getSize()!=null){
            PageHelper.startPage(cfCouponActivityLinkShopQuery.getPage(), cfCouponActivityLinkShopQuery.getSize());
        }
        return cfCouponActivityLinkShopExample;
    }

    @Override
    public List<CfCouponActivityLinkShop> getListByQuery(CfCouponActivityLinkShopQuery cfCouponActivityLinkShopQuery) {
        return cfCouponActivityLinkShopMapper.selectByExample(getExampleByQuery(cfCouponActivityLinkShopQuery));
    }

    @Override
    public Integer countByQuery(CfCouponActivityLinkShopQuery cfCouponActivityLinkShopQuery) {
        cfCouponActivityLinkShopQuery.setPage(null);
        return cfCouponActivityLinkShopMapper.countByExample(getExampleByQuery(cfCouponActivityLinkShopQuery));
    }

    @Override
    public List<CfCouponActivityLinkShop> selectByQuery(CfCouponActivityLinkShopQuery cfCouponActivityLinkShopQuery) {
        return cfCouponActivityLinkShopMapper.selectByQuery(cfCouponActivityLinkShopQuery);
    }
}
