package com.cf.pay.service;

import com.cf.pay.domain.CfStaffCouponLog;
import com.cf.pay.domain.CfStaffCouponLogExample;
import com.cf.pay.domain.request.CfStaffCouponLogQuery;

import java.math.BigDecimal;
import java.util.List;

public interface CfStaffCouponLogService {

    CfStaffCouponLog add(CfStaffCouponLog cfStaffCouponLog);

    CfStaffCouponLog update(CfStaffCouponLog cfStaffCouponLog);

    Integer delete(String id);

    CfStaffCouponLogExample getExampleByQuery(CfStaffCouponLogQuery cfStaffCouponLogQuery);

    List<CfStaffCouponLog> getListByQuery(CfStaffCouponLogQuery cfStaffCouponLogQuery);

    Integer countByQuery(CfStaffCouponLogQuery cfStaffCouponLogQuery);

    List<CfStaffCouponLog> selectByQuery(CfStaffCouponLogQuery cfStaffCouponLogQuery);

    /**
     * 统计某个用户在指定活动，时间中的发券额度
     * @param cfStaffCouponLogQuery
     * @return
     */
    BigDecimal countDenominationByQuery(CfStaffCouponLogQuery cfStaffCouponLogQuery);

}
