package com.cf.pay.service;

import com.cf.pay.domain.CfCoupon;
import com.cf.pay.domain.CfCouponExample;
import com.cf.pay.domain.request.CfCouponQuery;

import java.util.List;
import java.util.Map;

public interface CfCouponService {

    /**
     * 根据条件查询优惠券列表
     * @param cfCouponQuery
     * @return
     */
    public List<CfCoupon> getListByQuery(CfCouponQuery cfCouponQuery);

    CfCouponExample getExampleByQuery(CfCouponQuery cfCouponQuery);

    public CfCoupon findById(String id);

    public CfCoupon findById(String id, boolean expectEmpty);

    public CfCoupon add(CfCoupon cfCoupon);

    public CfCoupon update(CfCoupon cfCoupon);

    public CfCoupon updateByPrimaryKeySelective(CfCoupon cfCoupon);

    int updateByQuery(CfCouponQuery cfCouponQuery, CfCoupon cfCoupon);

    public Integer delete(String id);

    /**
     * 根据条件查询优惠券数据列表
     * @param conditions example {"字段名":"表别名"}
     * @param allowFiledsMap example {"字段名":"表别名"}
     * @param allowFileds example {"字段名"}
     * @return
     */
    public List<CfCoupon> selectListByCondition(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds);

    /**
     * 根据条件查询优惠券数据列表数
     * @param conditions example {"字段名":"表别名"}
     * @param allowFiledsMap example {"字段名":"表别名"}
     * @param allowFileds example {"字段名"}
     * @return
     */
    public Integer selectListByConditionCounts(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds);

    /**
     * 添加优惠券和其关联的店铺数据
     * @param cfCoupon
     * @param shopIds
     * @param scene
     * @return
     */
    CfCoupon addCouponAndLinkshops(CfCoupon cfCoupon, String shopIds, String scene);

    /**
     * 获取车牌或用户指定店铺指定类型的可用优惠券数据列表
     * @param nowTime
     * @param shopId
     * @param scenes
     * @param goodsId
     * @param uid
     * @return
     */
    List<CfCoupon> getAvailableByShopIdAndScenes(Long nowTime, String shopId, Byte scenes, String goodsId, String uid);

    /**
     * 获取指定店铺和绑定车辆人，车牌号的可用优惠券数据列表
     * @param nowTime
     * @param shopId
     * @param scenes
     * @return
     */
    List<CfCoupon> getAvailableByShopIdAndScenesAndLinkUids(Long nowTime, String shopId, Byte scenes, String goodsId);

}
