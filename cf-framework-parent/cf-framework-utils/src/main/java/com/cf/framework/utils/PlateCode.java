package com.cf.framework.utils;

/**
 * 语音屏幕  【威视】
 */
public class PlateCode {
    private String data;
    private int type;   //语音还是文本    1 文本   2 语音
    private int row;    // 行数   语音为 0
    private int color;        //B=0 系统默认色， B=1 红色， B=2 绿色， B=3 黄色， B=4 蓝色， B=5 紫色， B=7 白色

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
