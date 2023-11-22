package com.cf.pay.service;

import com.cf.pay.domain.CfCouponActivityCouponType;
import com.cf.pay.domain.CfCouponActivityCouponTypeExample;
import com.cf.pay.domain.request.CfCouponActivityCouponTypeQuery;

import java.util.List;

public interface CfCouponActivityCouponTypeService {

    CfCouponActivityCouponType add(CfCouponActivityCouponType cfCouponActivityCouponType);

    /**
     * 店主添加优惠券活动优惠券类型(设置发券时的 金额,有效期)
     * @param shopkeeperId
     * @param cfCouponActivityCouponType
     * @return
     */
    CfCouponActivityCouponType shopkeeperAddCouponType(String shopkeeperId, CfCouponActivityCouponType cfCouponActivityCouponType);

    CfCouponActivityCouponType update(CfCouponActivityCouponType cfCouponActivityCouponType);

    CfCouponActivityCouponType findById(String id);

    CfCouponActivityCouponType findById(String id, boolean expectEmpty);

    /**
     * 店主更新优惠券活动优惠券类型(设置发券时的 金额,有效期)
     * @param shopkeeperId
     * @param cfCouponActivityCouponType
     * @return
     */
    CfCouponActivityCouponType shopkeeperUpdateCouponType(String shopkeeperId, CfCouponActivityCouponType cfCouponActivityCouponType);

    Integer delete(String id);

    /**
     * 店主删除优惠券活动优惠券类型(设置发券时的 金额,有效期)
     * @param shopkeeperId
     * @param id
     * @return
     */
    Integer shopkeeperDelete(String shopkeeperId, String id);

    CfCouponActivityCouponTypeExample getExampleByQuery(CfCouponActivityCouponTypeQuery cfCouponActivityCouponTypeQuery);

    List<CfCouponActivityCouponType> getListByQuery(CfCouponActivityCouponTypeQuery cfCouponActivityCouponTypeQuery);

    Integer countByQuery(CfCouponActivityCouponTypeQuery cfCouponActivityCouponTypeQuery);

}
