package com.cf.carpark.device.led;

import java.io.Serializable;

/**
 * LED显示屏 显示和播报规则
 */
public class PlayRule implements Serializable {

    private ShowContent approach;   //入场
    private ShowContent freeOut;   //免费出场
    private ShowContent payOut;   //缴费入场
    private ShowContent abnormalOut;   //异常入场

    public ShowContent getApproach() {
        return approach;
    }

    public void setApproach(ShowContent approach) {
        this.approach = approach;
    }

    public ShowContent getFreeOut() {
        return freeOut;
    }

    public void setFreeOut(ShowContent freeOut) {
        this.freeOut = freeOut;
    }

    public ShowContent getPayOut() {
        return payOut;
    }

    public void setPayOut(ShowContent payOut) {
        this.payOut = payOut;
    }

    public ShowContent getAbnormalOut() {
        return abnormalOut;
    }

    public void setAbnormalOut(ShowContent abnormalOut) {
        this.abnormalOut = abnormalOut;
    }


}
