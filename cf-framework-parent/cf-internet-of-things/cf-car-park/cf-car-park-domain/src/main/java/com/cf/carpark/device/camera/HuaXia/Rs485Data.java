package com.cf.carpark.device.camera.HuaXia;

import java.io.Serializable;

/**
 * 485数据
 */
public class Rs485Data implements Serializable {
    private String encodetype;
    private String data;

    public String getEncodetype() {
        return encodetype;
    }

    public void setEncodetype(String encodetype) {
        this.encodetype = encodetype;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
