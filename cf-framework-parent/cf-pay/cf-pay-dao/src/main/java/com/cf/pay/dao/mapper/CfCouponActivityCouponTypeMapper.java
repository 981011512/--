package com.cf.pay.dao.mapper;

import com.cf.pay.domain.CfCouponActivityCouponType;
import com.cf.pay.domain.CfCouponActivityCouponTypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfCouponActivityCouponTypeMapper {
    int countByExample(CfCouponActivityCouponTypeExample example);

    int deleteByExample(CfCouponActivityCouponTypeExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfCouponActivityCouponType record);

    int insertSelective(CfCouponActivityCouponType record);

    List<CfCouponActivityCouponType> selectByExample(CfCouponActivityCouponTypeExample example);

    CfCouponActivityCouponType selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfCouponActivityCouponType record, @Param("example") CfCouponActivityCouponTypeExample example);

    int updateByExample(@Param("record") CfCouponActivityCouponType record, @Param("example") CfCouponActivityCouponTypeExample example);

    int updateByPrimaryKeySelective(CfCouponActivityCouponType record);

    int updateByPrimaryKey(CfCouponActivityCouponType record);
}