package com.cf.carpark.dao.mapper;

import com.cf.carpark.domain.CfCarParkCoupon;
import com.cf.carpark.domain.CfCarParkCouponExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfCarParkCouponMapper {
    int countByExample(CfCarParkCouponExample example);

    int deleteByExample(CfCarParkCouponExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfCarParkCoupon record);

    int insertSelective(CfCarParkCoupon record);

    List<CfCarParkCoupon> selectByExample(CfCarParkCouponExample example);

    CfCarParkCoupon selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfCarParkCoupon record, @Param("example") CfCarParkCouponExample example);

    int updateByExample(@Param("record") CfCarParkCoupon record, @Param("example") CfCarParkCouponExample example);

    int updateByPrimaryKeySelective(CfCarParkCoupon record);

    int updateByPrimaryKey(CfCarParkCoupon record);
}