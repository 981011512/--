package com.cf.carpark.device.camera;

import com.cf.carpark.device.camera.ZhenShi.AlarmInfoPlate;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 臻识相机
 * 设备类型	300万高清车牌识别一体机
 *
 * 软件版本	9.1.1.202002050
 *
 * 系统版本	x177.u177.k330.r178
 *
 * 算法版本	pr3.1_v2019122091
 *
 * @ClassName ZhenShi911202002050
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/1/001 13:59
 * @Version 1.0
 **/
public class ZhenShi911202002050 implements Serializable {
    AlarmInfoPlate AlarmInfoPlate;

    @JsonProperty("AlarmInfoPlate")
    public AlarmInfoPlate getAlarmInfoPlate() {
        return AlarmInfoPlate;
    }

    public void setAlarmInfoPlate(AlarmInfoPlate alarmInfoPlate) {
        AlarmInfoPlate = alarmInfoPlate;
    }
}
