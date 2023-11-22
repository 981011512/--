package com.cf.pay.dao.mapper;

import com.cf.pay.domain.CfCouponActivityLinkShop;
import com.cf.pay.domain.CfCouponActivityLinkShopExample;
import com.cf.pay.domain.request.CfCouponActivityLinkShopQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfCouponActivityLinkShopMapper {
    int countByExample(CfCouponActivityLinkShopExample example);

    int deleteByExample(CfCouponActivityLinkShopExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfCouponActivityLinkShop record);

    int insertSelective(CfCouponActivityLinkShop record);

    List<CfCouponActivityLinkShop> selectByExample(CfCouponActivityLinkShopExample example);

    CfCouponActivityLinkShop selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfCouponActivityLinkShop record, @Param("example") CfCouponActivityLinkShopExample example);

    int updateByExample(@Param("record") CfCouponActivityLinkShop record, @Param("example") CfCouponActivityLinkShopExample example);

    int updateByPrimaryKeySelective(CfCouponActivityLinkShop record);

    int updateByPrimaryKey(CfCouponActivityLinkShop record);

    List<CfCouponActivityLinkShop> selectByQuery(CfCouponActivityLinkShopQuery cfCouponActivityLinkShopQuery);
}