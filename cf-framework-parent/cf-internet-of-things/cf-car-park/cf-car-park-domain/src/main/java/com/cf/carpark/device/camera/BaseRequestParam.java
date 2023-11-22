package com.cf.carpark.device.camera;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseRequestParam implements Serializable {

    /**
     * 设备条形码
     */
    private String serialNo;

    /**
     * 车牌号
     */
    private String carNo;

    /**
     * 车辆类型
     */
    private String carType;

    /**
     *  区域  ------> 省份
     */
    private String carCountry;

    /**
     * 车辆颜色
     */
    private String carColor;
}
