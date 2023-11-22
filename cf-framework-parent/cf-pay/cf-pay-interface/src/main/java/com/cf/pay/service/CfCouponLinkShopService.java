package com.cf.pay.service;

import com.cf.pay.domain.CfCouponLinkShop;
import com.cf.pay.domain.CfCouponLinkShopExample;
import com.cf.pay.domain.response.CfCouponLinkShopQuery;

import java.util.List;

/**
 * 优惠券使用范围(哪些停车场，哪些店铺等)管理服务
 */
public interface CfCouponLinkShopService {

    CfCouponLinkShop add(CfCouponLinkShop cfCouponLinkShop);

    CfCouponLinkShop update(CfCouponLinkShop cfCouponLinkShop);

    Integer delete(String id);

    CfCouponLinkShopExample getExampleByQuery(CfCouponLinkShopQuery cfCouponLinkShopQuery);

    List<CfCouponLinkShop> getListByQuery(CfCouponLinkShopQuery cfCouponLinkShopQuery);

    Integer countByQuery(CfCouponLinkShopQuery cfCouponLinkShopQuery);

    Integer deleteByQuery(CfCouponLinkShopQuery cfCouponLinkShopQuery);

    List<CfCouponLinkShop> batchAdd(List<CfCouponLinkShop> cfCouponLinkShopList);

}
