package com.cf.carpark.device.camera.ZhenShi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class WhiteListOperate implements Serializable {

    private byte operate_type;  //操作类型(0:增加，1：删除)

    private IssuedWhitelist[] white_list_data;

    @JsonProperty("operate_type")
    public byte getOperate_type() {
        return operate_type;
    }

    public void setOperate_type(byte operate_type) {
        this.operate_type = operate_type;
    }

    @JsonProperty("white_list_data")
    public IssuedWhitelist[] getWhite_list_data() {
        return white_list_data;
    }

    public void setWhite_list_data(IssuedWhitelist[] white_list_data) {
        this.white_list_data = white_list_data;
    }
}
