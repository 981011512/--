package com.cf.carpark.device.camera.ZhenShi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 白名单
 */
public class IssuedWhiteNewlist implements Serializable {

    private String plate; //车牌号(编码请自行转为GB2312)

    private byte enable;    //当前名单是否有效（0：无效， 1,：有效）

    private byte need_alarm;    //当前名单是否为黑名单（0：否，1：黑名单）

    private String enable_time; //当前名单生效时间，如：2018-01-01 11:11:11

    private String overdue_time;    //当前名单过期时间，如：2018-01-01 11:11:11

    private String create_time;    //创建时间

    private byte time_seg_enable;    //0:否 1:是,启用了时间段才会生效

    private String seg_time_start;    //生效时间段

    private String seg_time_end;    //结束时间段

    private String vehicle_code;    //用户自定义的注释，也是一个字符串。最长32个字符

    private String vehicle_comment;    //用户自定义的注释，也是一个字符串。最长32个字符

    private Integer customer_id;    //用户自己定义ID，是一个整数，数据库内不保证唯一性

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

    @JsonProperty("create_time")
    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public byte getTime_seg_enable() {
        return time_seg_enable;
    }

    public void setTime_seg_enable(byte time_seg_enable) {
        this.time_seg_enable = time_seg_enable;
    }

    public String getSeg_time_start() {
        return seg_time_start;
    }

    public void setSeg_time_start(String seg_time_start) {
        this.seg_time_start = seg_time_start;
    }

    public String getSeg_time_end() {
        return seg_time_end;
    }

    public void setSeg_time_end(String seg_time_end) {
        this.seg_time_end = seg_time_end;
    }

    public String getVehicle_code() {
        return vehicle_code;
    }

    public void setVehicle_code(String vehicle_code) {
        this.vehicle_code = vehicle_code;
    }

    public String getVehicle_comment() {
        return vehicle_comment;
    }

    public void setVehicle_comment(String vehicle_comment) {
        this.vehicle_comment = vehicle_comment;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }
}
