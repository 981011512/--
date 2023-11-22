package com.cf.carpark.device.led;

import java.io.Serializable;

public class VoicePlay implements Serializable {

    private String value;   //播报内容

    private String type;    //类型 plaintext-纯文本/fee-缴费金额/duration-时长/date-日期

    private String playMode;    //播报模式 only_add-只添加/add_and_play-添加并播报/clean_and_add_play-清除之前的，添加当前内容，并播报

    private int status;    //状态(0-待填充/1-已填充)

    Integer serialChannel;  //通道 一般选 0

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPlayMode() {
        return playMode;
    }

    public void setPlayMode(String playMode) {
        this.playMode = playMode;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSerialChannel() {
        return serialChannel;
    }

    public void setSerialChannel(Integer serialChannel) {
        this.serialChannel = serialChannel;
    }
}
