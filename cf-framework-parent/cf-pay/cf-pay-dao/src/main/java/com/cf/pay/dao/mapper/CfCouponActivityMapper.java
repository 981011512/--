package com.cf.pay.dao.mapper;

import com.cf.pay.domain.CfCouponActivity;
import com.cf.pay.domain.CfCouponActivityExample;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface CfCouponActivityMapper {
    int countByExample(CfCouponActivityExample example);

    int deleteByExample(CfCouponActivityExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfCouponActivity record);

    int insertSelective(CfCouponActivity record);

    List<CfCouponActivity> selectByExample(CfCouponActivityExample example);

    CfCouponActivity selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfCouponActivity record, @Param("example") CfCouponActivityExample example);

    int updateByExample(@Param("record") CfCouponActivity record, @Param("example") CfCouponActivityExample example);

    int updateByPrimaryKeySelective(CfCouponActivity record);

    int updateByPrimaryKey(CfCouponActivity record);


    /**
     * 根据条件查询优惠券活动数据列表
     * @param conditions
     * @return
     */
    List<CfCouponActivity> selectListByCondition(String conditions);

    /**
     * 根据条件查询优惠券活动数据列表数
     * @param conditions
     * @return
     */
    Integer selectListByConditionCounts(String conditions);

    /**
     * 更显优惠券活动的已发行量
     * @param id
     * @param changeValue
     * @return
     */
    Integer updateIssuedQuotaById(@Param("id") String id, @Param("changeValue") BigDecimal changeValue);

    /**
     * 更新自动发送余额
     * @param id
     * @param changeValue
     * @return
     */
    Integer updateAutoGiveAwayOverageQuotaById(@Param("id") String id, @Param("changeValue") BigDecimal changeValue);

    /**
     * 更新次数券余额
     * @param id
     * @param changeValue
     * @return
     */
    Integer updateRemainingTimesById(@Param("id") String id, @Param("changeValue") BigDecimal changeValue);

    /**
     * 更新时长券余额
     * @param id
     * @param changeValue
     * @return
     */
    Integer updateRemainingTimeById(@Param("id") String id, @Param("changeValue") BigDecimal changeValue);

    /**
     * 检查车辆是否还在停车场中
     * @param numberPlate
     * @return
     */
    Integer checkCarIsInPark(String numberPlate);
}