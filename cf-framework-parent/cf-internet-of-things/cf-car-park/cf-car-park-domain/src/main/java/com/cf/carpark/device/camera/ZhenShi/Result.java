package com.cf.carpark.device.camera.ZhenShi;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @ClassName Result
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/1/001 15:02
 * @Version 1.0
 **/
public class Result {
    PlateResult PlateResult;

    @JsonProperty("PlateResult")
    public com.cf.carpark.device.camera.ZhenShi.PlateResult getPlateResult() {
        return PlateResult;
    }

    public void setPlateResult(com.cf.carpark.device.camera.ZhenShi.PlateResult plateResult) {
        PlateResult = plateResult;
    }
}
