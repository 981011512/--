package com.cf.pay.service.impl;

import com.cf.framework.utils.IdWorker;
import com.cf.pay.dao.mapper.CfCouponLinkShopMapper;
import com.cf.pay.domain.CfCouponLinkShop;
import com.cf.pay.domain.CfCouponLinkShopExample;
import com.cf.pay.domain.response.CfCouponLinkShopQuery;
import com.cf.pay.service.CfCouponLinkShopService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfCouponLinkShopServiceImpl implements CfCouponLinkShopService {

    @Autowired
    private CfCouponLinkShopMapper cfCouponLinkShopMapper;
    @Autowired
    private IdWorker idWorker;

    @Override
    public CfCouponLinkShop add(CfCouponLinkShop cfCouponLinkShop) {
        cfCouponLinkShop.setId(idWorker.nextId());
        cfCouponLinkShopMapper.insert(cfCouponLinkShop);
        return cfCouponLinkShop;
    }

    @Override
    public CfCouponLinkShop update(CfCouponLinkShop cfCouponLinkShop) {
        int i = cfCouponLinkShopMapper.updateByPrimaryKey(cfCouponLinkShop);
        return cfCouponLinkShop;
    }

    @Override
    public Integer delete(String id) {
        return cfCouponLinkShopMapper.deleteByPrimaryKey(id);
    }

    @Override
    public CfCouponLinkShopExample getExampleByQuery(CfCouponLinkShopQuery cfCouponLinkShopQuery) {
        CfCouponLinkShopExample cfCouponLinkShopExample = new CfCouponLinkShopExample();
        CfCouponLinkShopExample.Criteria criteria = cfCouponLinkShopExample.createCriteria();
        if(StringUtils.isNotEmpty(cfCouponLinkShopQuery.getCouponId())){
            criteria.andCouponIdEqualTo(cfCouponLinkShopQuery.getCouponId());
        }
        if(StringUtils.isNotEmpty(cfCouponLinkShopQuery.getShopId())){
            criteria.andShopIdEqualTo(cfCouponLinkShopQuery.getShopId());
        }
        return cfCouponLinkShopExample;
    }

    @Override
    public List<CfCouponLinkShop> getListByQuery(CfCouponLinkShopQuery cfCouponLinkShopQuery) {
        return cfCouponLinkShopMapper.selectByExample(getExampleByQuery(cfCouponLinkShopQuery));
    }

    @Override
    public Integer countByQuery(CfCouponLinkShopQuery cfCouponLinkShopQuery) {
        return cfCouponLinkShopMapper.countByExample(getExampleByQuery(cfCouponLinkShopQuery));
    }

    @Override
    public Integer deleteByQuery(CfCouponLinkShopQuery cfCouponLinkShopQuery) {
        return cfCouponLinkShopMapper.deleteByExample(getExampleByQuery(cfCouponLinkShopQuery));
    }

    @Override
    public List<CfCouponLinkShop> batchAdd(List<CfCouponLinkShop> cfCouponLinkShopList) {
        if(cfCouponLinkShopList!=null && cfCouponLinkShopList.size()>0){
            String batchAddLinkShopsSQL = "insert into cf_coupon_link_shop (id, coupon_id, shop_id, scene) values ";
            for(CfCouponLinkShop cfCouponLinkShop: cfCouponLinkShopList){
                cfCouponLinkShop.setId(idWorker.nextId());
                batchAddLinkShopsSQL += "('"+cfCouponLinkShop.getId()+"','"+cfCouponLinkShop.getCouponId()+"','"+cfCouponLinkShop.getShopId()+"','"+cfCouponLinkShop.getScene()+"'),";
            }
            batchAddLinkShopsSQL = batchAddLinkShopsSQL.substring(0, batchAddLinkShopsSQL.length()-1);
            cfCouponLinkShopMapper.batchAdd(batchAddLinkShopsSQL);
        }
        return cfCouponLinkShopList;
    }
}
