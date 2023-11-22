package com.cf.pay.dao.mapper;

import com.cf.pay.domain.CfCouponLinkShop;
import com.cf.pay.domain.CfCouponLinkShopExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfCouponLinkShopMapper {
    int countByExample(CfCouponLinkShopExample example);

    int deleteByExample(CfCouponLinkShopExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfCouponLinkShop record);

    int insertSelective(CfCouponLinkShop record);

    List<CfCouponLinkShop> selectByExample(CfCouponLinkShopExample example);

    CfCouponLinkShop selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfCouponLinkShop record, @Param("example") CfCouponLinkShopExample example);

    int updateByExample(@Param("record") CfCouponLinkShop record, @Param("example") CfCouponLinkShopExample example);

    int updateByPrimaryKeySelective(CfCouponLinkShop record);

    int updateByPrimaryKey(CfCouponLinkShop record);

    /**
     * 批量插入
     * @param batchAddSQL
     * @return
     */
    Integer batchAdd(String batchAddSQL);
}