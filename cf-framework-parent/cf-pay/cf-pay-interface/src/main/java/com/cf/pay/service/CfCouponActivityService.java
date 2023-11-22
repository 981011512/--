package com.cf.pay.service;

import com.cf.pay.domain.*;
import com.cf.pay.domain.CfCouponActivity;
import com.cf.pay.domain.request.CfCouponActivityQuery;
import com.cf.pay.domain.request.CfCouponQuery;
import com.cf.pay.domain.response.ResultMap;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface CfCouponActivityService {

    /**
     * 根据条件查询优惠券活动那个列表
     * @param cfCouponActivityQuery
     * @return
     */
    public List<CfCouponActivity> getListByQuery(CfCouponActivityQuery cfCouponActivityQuery);

    public CfCouponActivityExample getExampleByQuery(CfCouponActivityQuery cfCouponActivityQuery);

    public Integer countByQuery(CfCouponActivityQuery cfCouponActivityQuery);

    public CfCouponActivity findById(String id);

    public CfCouponActivity findById(String id, boolean expectEmpty);

    public CfCouponActivity add(CfCouponActivity cfCouponActivity);

    public CfCouponActivity update(CfCouponActivity cfCouponActivity);

    /**
     * 根据id更新赋值的字段
     * @param cfCouponActivity
     * @return
     */
    CfCouponActivity updateByPrimaryKeySelective(CfCouponActivity cfCouponActivity);

    /**
     * 通过手机号将活动绑定到指定的用户
     * @param cfCouponActivity
     * @return
     */
    CfCouponActivity linkUserByPhone(CfCouponActivity cfCouponActivity);



    public Integer delete(String id);

    /**
     * 根据条件查询优惠券活动数据列表
     * @param conditions example {"字段名":"表别名"}
     * @param allowFiledsMap example {"字段名":"表别名"}
     * @param allowFileds example {"字段名"}
     * @return
     */
    public List<CfCouponActivity> selectListByCondition(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds);

    /**
     * 根据条件查询优惠券数据列表数
     * @param conditions example {"字段名":"表别名"}
     * @param allowFiledsMap example {"字段名":"表别名"}
     * @param allowFileds example {"字段名"}
     * @return
     */
    public Integer selectListByConditionCounts(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds);

    /**
     *  根据店主id和优惠活动id查询数据
     * @param mainBodyId
     * @param activityId
     * @return
     */
    CfCouponActivity checkActivityAscription(String mainBodyId, String activityId);

    /**
     * 员工或者店主直接给车辆赠送优惠券
     * @param uid
     * @param toUid
     * @param numberPlate
     * @param couponType
     * @param cfCouponActivityId
     * @param quantity
     * @param cfCouponActivityCouponType
     * @return
     */
    CfCoupon staffOrShopkeeperGiveCouponToCar(String uid, String toUid, String numberPlate, Byte couponType, String cfCouponActivityId, Integer quantity, CfCouponActivityCouponType cfCouponActivityCouponType) throws Exception;

    /**
     * 更新优惠券活动的已发行量
     * @param id
     * @param changeValue   变化的值
     * @return
     */
    Integer updateIssuedQuotaById(String id, BigDecimal changeValue);

    /**
     * 更新自动发送余额
     * @param id
     * @param changeValue   变化的值
     * @return
     */
    Integer updateAutoGiveAwayOverageQuotaById(String id, BigDecimal changeValue);

    /**
     * 更新次数券余额
     * @param id
     * @param changeValue   变化的值
     * @return
     */
    Integer updateRemainingTimesById(String id, BigDecimal changeValue);

    /**
     * 更新时长券余额
     * @param id
     * @param changeValue   变化的值
     * @return
     */
    Integer updateRemainingTimeById(String id, BigDecimal changeValue);

    /**
     * 通过二维码领取优惠券
     * @param uid
     * @param qrCodeId
     * @param numberPlate
     * @param cfCouponActivityCouponType
     * @return
     */
    CfCoupon getCouponByQrCode(String uid, String qrCodeId, String numberPlate, CfCouponActivityCouponType cfCouponActivityCouponType) throws Exception;

    /**
     * 检查车辆是否还在停车场中
     * @param numberPlate
     * @param carParkIds
     * @return
     */
    Integer checkCarIsInPark(String numberPlate, List<String> carParkIds);

    /**
     * 检查多个车辆是否还在停车场中
     * @param numberPlates
     * @param carParkIds
     * @return 返回在停车场内的车牌号
     */
    List<String> checkCarIsInPark(List<String> numberPlates, List<String> carParkIds);

    /**
     * 给优惠券活动充值
     * @param uid
     * @param couponActivityId
     * @param amountOfMoney 充值金额
     * @param useScenes 使用场景
     * @param couponType 优惠券类型
     * @param ip
     * @return
     */
    ResultMap rechargeToCouponActivity(String uid, String couponActivityId, BigDecimal amountOfMoney, String useScenes, String ip, Byte couponType) throws Exception;

    /**
     * 获取优惠券活动主店铺id
     * @param couponActivityType
     * @param couponActivityId
     * @return
     */
    String getCouponActivityMainShopId(byte couponActivityType, String couponActivityId);

    /**
     * 获取活动关联的店铺
     * @param couponActivityType
     * @param couponActivityId
     * @return
     */
    List<CfCouponActivityLinkShop> getCouponActivityLinkShops(byte couponActivityType, String couponActivityId);

    /**
     * 处理自动赠送优惠券额度
     */
    void handleAutoGiveAway() throws Exception;

}
