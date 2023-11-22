package com.cf.carpark.device.camera.HuaXia;

import java.io.Serializable;

/**
 * 开闸数据
 */
public class GpioData implements Serializable {
    private String ionum;   //通道
    private String action;  //操作

    public String getIonum() {
        return ionum;
    }

    public void setIonum(String ionum) {
        this.ionum = ionum;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
