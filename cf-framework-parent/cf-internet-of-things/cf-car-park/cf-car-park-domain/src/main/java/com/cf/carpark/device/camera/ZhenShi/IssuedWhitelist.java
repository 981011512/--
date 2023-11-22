package com.cf.carpark.device.camera.ZhenShi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 白名单
 */
public class IssuedWhitelist implements Serializable {

    private String plate; //车牌号(编码请自行转为GB2312)

    private byte enable;    //当前名单是否有效（0：无效， 1,：有效）

    private byte need_alarm;    //当前名单是否为黑名单（0：否，1：黑名单）

    private String enable_time; //当前名单生效时间，如：2018-01-01 11:11:11

    private String overdue_time;    //当前名单过期时间，如：2018-01-01 11:11:11

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public byte getEnable() {
        return enable;
    }

    public void setEnable(byte enable) {
        this.enable = enable;
    }

    @JsonProperty("need_alarm")
    public byte getNeed_alarm() {
        return need_alarm;
    }

    public void setNeed_alarm(byte need_alarm) {
        this.need_alarm = need_alarm;
    }

    @JsonProperty("enable_time")
    public String getEnable_time() {
        return enable_time;
    }

    public void setEnable_time(String enable_time) {
        this.enable_time = enable_time;
    }

    @JsonProperty("overdue_time")
    public String getOverdue_time() {
        return overdue_time;
    }

    public void setOverdue_time(String overdue_time) {
        this.overdue_time = overdue_time;
    }
}
