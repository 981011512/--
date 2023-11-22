package com.cf.carpark.device.camera;

import com.cf.carpark.device.camera.ZhenShi.Response_AlarmInfoPlate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 臻识相机 回复实体
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
public class ZhenShiResponse911202002050 implements Serializable {
    Response_AlarmInfoPlate Response_AlarmInfoPlate;

    @JsonProperty("Response_AlarmInfoPlate")
    public com.cf.carpark.device.camera.ZhenShi.Response_AlarmInfoPlate getResponse_AlarmInfoPlate() {
        return Response_AlarmInfoPlate;
    }

    public void setResponse_AlarmInfoPlate(com.cf.carpark.device.camera.ZhenShi.Response_AlarmInfoPlate response_AlarmInfoPlate) {
        Response_AlarmInfoPlate = response_AlarmInfoPlate;
    }
}
