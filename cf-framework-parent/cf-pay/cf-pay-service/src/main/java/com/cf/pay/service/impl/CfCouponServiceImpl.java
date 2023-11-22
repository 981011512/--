package com.cf.pay.service.impl;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.DbUtils;
import com.cf.framework.utils.IdWorker;
import com.cf.pay.dao.mapper.CfCouponLinkShopMapper;
import com.cf.pay.dao.mapper.CfCouponMapper;
import com.cf.pay.domain.CfCoupon;
import com.cf.pay.domain.CfCouponExample;
import com.cf.pay.domain.request.CfCouponQuery;
import com.cf.pay.service.CfCouponService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfCouponServiceImpl implements CfCouponService {

    @Autowired
    private CfCouponMapper cfCouponMapper;
    @Autowired
    private CfCouponLinkShopMapper cfCouponLinkShopMapper;
    @Autowired
    private IdWorker idWorker;

    @Override
    public List<CfCoupon> getListByQuery(CfCouponQuery cfCouponQuery) {
        return cfCouponMapper.selectByExample(getExampleByQuery(cfCouponQuery));
    }

    @Override
    public CfCouponExample getExampleByQuery(CfCouponQuery cfCouponQuery) {
        CfCouponExample cfCouponExample = new CfCouponExample();
        CfCouponExample.Criteria criteria = cfCouponExample.createCriteria();
        if(StringUtils.isNotEmpty(cfCouponQuery.getId())){
            criteria.andIdEqualTo(cfCouponQuery.getId());
        }
        if(cfCouponQuery.getToUid()!=null){
            criteria.andToUidEqualTo(cfCouponQuery.getToUid());
        }
        if(cfCouponQuery.getScenes()!=null){
            criteria.andScenesEqualTo(cfCouponQuery.getScenes());
        }
        if(cfCouponQuery.getShopId()!=null){
            criteria.andShopIdEqualTo(cfCouponQuery.getShopId());
        }
        if(cfCouponQuery.getDenomination()!=null){
            criteria.andDenominationEqualTo(cfCouponQuery.getDenomination());
        }
        if(cfCouponQuery.getMinDenomination()!=null){
            criteria.andDenominationGreaterThanOrEqualTo(cfCouponQuery.getMinDenomination());
        }
        if(cfCouponQuery.getMaxDenomination()!=null){
            criteria.andDenominationLessThanOrEqualTo(cfCouponQuery.getMaxDenomination());
        }
        if(cfCouponQuery.getMinEffectiveTime()!=null){
            criteria.andEffectiveTimeGreaterThanOrEqualTo(cfCouponQuery.getMinEffectiveTime());
        }
        if(cfCouponQuery.getMaxEffectiveTime()!=null){
            criteria.andEffectiveTimeLessThanOrEqualTo(cfCouponQuery.getMaxEffectiveTime());
        }
        if(cfCouponQuery.getMinExpireTime()!=null){
            criteria.andExpireTimeGreaterThanOrEqualTo(cfCouponQuery.getMinExpireTime());
        }
        if(cfCouponQuery.getMaxExpireTime()!=null){
            criteria.andExpireTimeLessThanOrEqualTo(cfCouponQuery.getMaxExpireTime());
        }
        if(cfCouponQuery.getStatus()!=null){
            criteria.andStatusEqualTo(cfCouponQuery.getStatus());
        }
        if(cfCouponQuery.getGoodsId()!=null){
            criteria.andGoodsIdEqualTo(cfCouponQuery.getGoodsId());
        }

        if(StringUtils.isNotEmpty(cfCouponQuery.getOrderBy())){
            cfCouponExample.setOrderByClause(cfCouponQuery.getOrderBy());
        }

        if(cfCouponQuery.getPage()!=null && cfCouponQuery.getSize()!=null){
            PageHelper.startPage(cfCouponQuery.getPage(), cfCouponQuery.getSize());
        }

        return cfCouponExample;
    }

    @Override
    public CfCoupon findById(String id) {
        return cfCouponMapper.selectByPrimaryKey(id);
    }

    @Override
    public CfCoupon findById(String id, boolean expectEmpty) {
        CfCoupon cfCoupon = findById(id);
        if(expectEmpty && cfCoupon!=null){
            ExceptionCast.cast(CommonCode.DUPLICATE_DATA);
        }else if(!expectEmpty && cfCoupon==null){
            ExceptionCast.cast(CommonCode.NO_MORE_DATAS);
        }
        return cfCoupon;
    }

    @Override
    public CfCoupon add(CfCoupon cfCoupon) {
        cfCoupon.setId(idWorker.nextId());
        cfCoupon.setCreateTime(System.currentTimeMillis());
        cfCouponMapper.insert(cfCoupon);
        return cfCoupon;
    }

    @Override
    public CfCoupon update(CfCoupon cfCoupon) {
        cfCouponMapper.updateByPrimaryKey(cfCoupon);
        return cfCoupon;
    }

    @Override
    public CfCoupon updateByPrimaryKeySelective(CfCoupon cfCoupon) {
        cfCouponMapper.updateByPrimaryKeySelective(cfCoupon);
        return cfCoupon;
    }

    @Override
    public int updateByQuery(CfCouponQuery cfCouponQuery, CfCoupon cfCoupon) {
        return cfCouponMapper.updateByExampleSelective(cfCoupon, getExampleByQuery(cfCouponQuery));
    }

    @Override
    public List<CfCoupon> selectListByCondition(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds) {
        String sql = "SELECT cpn.* FROM cf_coupon cpn";
        sql = DbUtils.makeQuery(conditions, allowFiledsMap, allowFileds, sql, false);
        return cfCouponMapper.selectListByCondition(sql);
    }

    @Override
    public Integer selectListByConditionCounts(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds) {
        String sql = "SELECT count(*) FROM cf_coupon cpn";
        conditions.remove("group");
        sql = DbUtils.makeQuery(conditions, allowFiledsMap, allowFileds, sql, false);
        return cfCouponMapper.selectListByConditionCounts(sql);
    }

    @Override
    public Integer delete(String id) {
        return cfCouponMapper.deleteByPrimaryKey(id);
    }

    @Override
    public CfCoupon addCouponAndLinkshops(CfCoupon cfCoupon, String shopIds, String scene) {
        CfCoupon coupon = add(cfCoupon);
        if(StringUtils.isNotEmpty(shopIds)){
            String batchAddLinkShopsSQL = "insert into cf_coupon_link_shop (id, coupon_id, shop_id, scene) values ";
            String[] shopIdArray = shopIds.split(",");
            for(String shopId: shopIdArray){
                batchAddLinkShopsSQL += "('"+idWorker.nextId()+"','"+coupon.getId()+"','"+shopId+"','"+scene+"'),";
            }
            batchAddLinkShopsSQL = batchAddLinkShopsSQL.substring(0, batchAddLinkShopsSQL.length()-1);
            cfCouponLinkShopMapper.batchAdd(batchAddLinkShopsSQL);
        }
        return coupon;
    }

    @Override
    public List<CfCoupon> getAvailableByShopIdAndScenes(Long nowTime, String shopId, Byte scenes, String goodsId, String uid) {

        List<CfCoupon> availableByShopIdAndScenes = null;
        if(StringUtils.isNotEmpty(goodsId)){
            uid = null;
            availableByShopIdAndScenes = cfCouponMapper.getAvailableByShopIdAndScenesAndUidOrGoodsId(nowTime, shopId, scenes, null, goodsId);
        }
        if((availableByShopIdAndScenes==null || availableByShopIdAndScenes.size()==0) && StringUtils.isNotEmpty(uid)){
            availableByShopIdAndScenes = cfCouponMapper.getAvailableByShopIdAndScenesAndUidOrGoodsId(nowTime, shopId, scenes, uid, "");
        }
        return availableByShopIdAndScenes;
    }

    @Override
    public List<CfCoupon> getAvailableByShopIdAndScenesAndLinkUids(Long nowTime, String shopId, Byte scenes, String goodsId) {
        return cfCouponMapper.getAvailableByShopIdAndScenesAndLinkUids(nowTime, shopId, scenes, goodsId);
    }
}
