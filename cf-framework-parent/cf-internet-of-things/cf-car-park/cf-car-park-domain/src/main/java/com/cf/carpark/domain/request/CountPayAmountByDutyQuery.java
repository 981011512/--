package com.cf.carpark.domain.request;

import java.io.Serializable;

/**
 * 统计停车场值班人的收费情况实体
 */
public class CountPayAmountByDutyQuery implements Serializable {

    private String handleUid;

    private Long minTime;

    private Long maxTime;

    private String paymentAgencyShortName;

    private String countMode;   //岗亭现金计费模式(real_time-实时，该人员值班到现在的金额/day-每日统计)

    private static final long serialVersionUID = 1L;

    public String getHandleUid() {
        return handleUid;
    }

    public void setHandleUid(String handleUid) {
        this.handleUid = handleUid;
    }

    public Long getMinTime() {
        return minTime;
    }

    public void setMinTime(Long minTime) {
        this.minTime = minTime;
    }

    public Long getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(Long maxTime) {
        this.maxTime = maxTime;
    }

    public String getPaymentAgencyShortName() {
        return paymentAgencyShortName;
    }

    public void setPaymentAgencyShortName(String paymentAgencyShortName) {
        this.paymentAgencyShortName = paymentAgencyShortName;
    }

    public String getCountMode() {
        return countMode;
    }

    public void setCountMode(String countMode) {
        this.countMode = countMode;
    }
}
