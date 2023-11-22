package com.cf.forward.dh.lib.enumeration;/**
 * @author 47081
 * @descriptio
 * @date 2020/11/9
 * @version 1.0
 */

/**
 * @author 47081
 * @version 1.0
 * @description 支持的焦距模式对应枚举
 * @date 2020/11/9
 */
public enum EM_SUPPORT_FOCUS_MODE {
    ENUM_SUPPORT_FOCUS_CAR(1, "看清车模式"),
    ENUM_SUPPORT_FOCUS_PLATE(2, "看清车牌模式"),
    ENUM_SUPPORT_FOCUS_PEOPLE(3, "看清人模式"),
    ENUM_SUPPORT_FOCUS_FACE(4, "看清人脸模式");

    private EM_SUPPORT_FOCUS_MODE(int mode, String desc) {
        this.mode = mode;
        this.desc = desc;
    }

    private int mode;
    private String desc;

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
