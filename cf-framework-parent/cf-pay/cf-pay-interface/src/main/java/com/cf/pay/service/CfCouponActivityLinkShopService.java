package com.cf.pay.service;

import com.cf.pay.domain.CfCouponActivityLinkShop;
import com.cf.pay.domain.CfCouponActivityLinkShopExample;
import com.cf.pay.domain.request.CfCouponActivityLinkShopQuery;

import java.util.List;

public interface CfCouponActivityLinkShopService {

    CfCouponActivityLinkShop add(CfCouponActivityLinkShop cfCouponActivityLinkShop);

    CfCouponActivityLinkShop update(CfCouponActivityLinkShop cfCouponActivityLinkShop);

    Integer delete(String id);

    CfCouponActivityLinkShopExample getExampleByQuery(CfCouponActivityLinkShopQuery cfCouponActivityLinkShopQuery);

    List<CfCouponActivityLinkShop> getListByQuery(CfCouponActivityLinkShopQuery cfCouponActivityLinkShopQuery);

    Integer countByQuery(CfCouponActivityLinkShopQuery cfCouponActivityLinkShopQuery);

    List<CfCouponActivityLinkShop> selectByQuery(CfCouponActivityLinkShopQuery cfCouponActivityLinkShopQuery);

}
