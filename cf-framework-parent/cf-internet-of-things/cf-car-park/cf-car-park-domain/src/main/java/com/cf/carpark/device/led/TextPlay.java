package com.cf.carpark.device.led;

import java.io.Serializable;

public class TextPlay implements Serializable {

    private String type;    //类型 plaintext-纯文本/fee-缴费金额/duration-时长/date-日期

    private String value;   //值

    private String color;   //颜色 red-红色/green-绿色/yellow-黄色

    private int status;    //状态(0-待填充/1-已填充)

    Integer serialChannel;  //通道 一般选 0

    /**
     * 文字进入显示屏模式
     * show_now 立即显示
     * right_to_left    从右向左
     * left_to_right    从左向右
     * buttom_to_top    从下往上
     * top_to_buttom    从上往下
     * to_buttom    向下
     * to_top   向上
     * to_left  向左
     * to_right 向右
     * one_by_one   一个连一个
     * continuous_to_left   持续向左
     */
    private String inMode;

    /**
     * 文字离开显示屏模式
     */
    private String outMode;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getInMode() {
        return inMode;
    }

    public void setInMode(String inMode) {
        this.inMode = inMode;
    }

    public String getOutMode() {
        return outMode;
    }

    public void setOutMode(String outMode) {
        this.outMode = outMode;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Integer getSerialChannel() {
        return serialChannel;
    }

    public void setSerialChannel(Integer serialChannel) {
        this.serialChannel = serialChannel;
    }
}
