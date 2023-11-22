package com.cf.carpark.device.camera.HuaXia;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 华夏相机 推送数据包实体
 */
public class HuaXia implements Serializable {
    private String type;
    private String car_plate;   //老版本 车牌号字段
    private String plate_num;   //新版本 车牌号字段
    private String car_logo;
    private String color;
    private String car_color;
    private String start_time;
    private String park_id;
    private String camera_id;   //老版本 相机序列号id
    private String cam_id;   //新版本 相机序列号id
    @JsonProperty("VehicleType")
    private String VehicleType;
    private String picture;
    private String closeup_pic;
    private String bigImagePath;
    private String smallImagePath;
    private String berthcode;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCar_plate() {
        return car_plate;
    }

    public void setCar_plate(String car_plate) {
        this.car_plate = car_plate;
    }

    public String getPlate_num() {
        return plate_num;
    }

    public void setPlate_num(String plate_num) {
        this.plate_num = plate_num;
    }

    public String getCar_logo() {
        return car_logo;
    }

    public void setCar_logo(String car_logo) {
        this.car_logo = car_logo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCar_color() {
        return car_color;
    }

    public void setCar_color(String car_color) {
        this.car_color = car_color;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getPark_id() {
        return park_id;
    }

    public void setPark_id(String park_id) {
        this.park_id = park_id;
    }

    public String getCamera_id() {
        return camera_id;
    }

    public void setCamera_id(String camera_id) {
        this.camera_id = camera_id;
    }

    public String getCam_id() {
        return cam_id;
    }

    public void setCam_id(String cam_id) {
        this.cam_id = cam_id;
    }

    public String getVehicleType() {
        return VehicleType;
    }

    public void setVehicleType(String vehicleType) {
        VehicleType = vehicleType;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getCloseup_pic() {
        return closeup_pic;
    }

    public void setCloseup_pic(String closeup_pic) {
        this.closeup_pic = closeup_pic;
    }

    public String getBigImagePath() {
        return bigImagePath;
    }

    public void setBigImagePath(String bigImagePath) {
        this.bigImagePath = bigImagePath;
    }

    public String getSmallImagePath() {
        return smallImagePath;
    }

    public void setSmallImagePath(String smallImagePath) {
        this.smallImagePath = smallImagePath;
    }

    public String getBerthcode() {
        return berthcode;
    }

    public void setBerthcode(String berthcode) {
        this.berthcode = berthcode;
    }
}
