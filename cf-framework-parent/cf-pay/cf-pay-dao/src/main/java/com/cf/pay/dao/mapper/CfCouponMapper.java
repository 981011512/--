package com.cf.pay.dao.mapper;

import com.cf.pay.domain.CfCoupon;
import com.cf.pay.domain.CfCouponExample;
import com.cf.pay.domain.request.CfCouponQuery;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface CfCouponMapper {
    int countByExample(CfCouponExample example);

    int deleteByExample(CfCouponExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfCoupon record);

    int insertSelective(CfCoupon record);

    List<CfCoupon> selectByExample(CfCouponExample example);

    CfCoupon selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfCoupon record, @Param("example") CfCouponExample example);

    int updateByExample(@Param("record") CfCoupon record, @Param("example") CfCouponExample example);

    int updateByPrimaryKeySelective(CfCoupon record);

    int updateByPrimaryKey(CfCoupon record);

    /**
     * 根据条件查询优惠券数据列表
     * @param conditions
     * @return
     */
    List<CfCoupon> selectListByCondition(String conditions);

    /**
     * 根据条件查询优惠券数据列表数
     * @param conditions
     * @return
     */
    Integer selectListByConditionCounts(String conditions);

    /**
     * 获取指定店铺指定类型的可用优惠券数据列表
     * @param nowTime
     * @param shopId
     * @param scenes
     * @return
     */
    List<CfCoupon> getAvailableByShopIdAndScenes(@Param("nowTime") Long nowTime, @Param("shopId") String shopId, @Param("scenes") Byte scenes,@Param("goodsId") String goodsId);

    /**
     * 获取指定店铺指定用户的可用优惠券数据列表
     * @param nowTime
     * @param shopId
     * @param scenes
     * @return
     */
    List<CfCoupon> getAvailableByShopIdAndScenesAndUid(@Param("nowTime") Long nowTime, @Param("shopId") String shopId, @Param("scenes") Byte scenes,@Param("uid") String uid);

    /**
     * 获取指定店铺指定用户或车牌号的可用优惠券数据列表
     * @param nowTime
     * @param shopId
     * @param scenes
     * @param uid
     * @param goodsId
     * @return
     */
    List<CfCoupon> getAvailableByShopIdAndScenesAndUidOrGoodsId(@Param("nowTime") Long nowTime, @Param("shopId") String shopId, @Param("scenes") Byte scenes,@Param("uid") String uid,@Param("goodsId") String goodsId);

    /**
     * 获取指定店铺和绑定车辆人，车牌号的可用优惠券数据列表
     * @param nowTime
     * @param shopId
     * @param scenes
     * @return
     */
    List<CfCoupon> getAvailableByShopIdAndScenesAndLinkUids(@Param("nowTime") Long nowTime, @Param("shopId") String shopId, @Param("scenes") Byte scenes,@Param("goodsId") String goodsId);

    /**
     * 根据条件统计对应字段数目
     * @param cfCouponQuery
     * @return
     */
    BigDecimal sumByFieldAndQuery(CfCouponQuery cfCouponQuery);
}