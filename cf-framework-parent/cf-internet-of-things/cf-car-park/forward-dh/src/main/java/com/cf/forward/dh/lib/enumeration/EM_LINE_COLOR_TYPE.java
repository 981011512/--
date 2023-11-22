package com.cf.forward.dh.lib.enumeration;

/**
 * @author 47081
 * @version 1.0
 * @description 轨迹线颜色类型
 * @date 2020/8/24
 */
public enum EM_LINE_COLOR_TYPE {

    EM_LINE_COLOR_TYPE_UNKNOWN(0, "未知"),
    EM_LINE_COLOR_TYPE_RED(1, "红色"),
    EM_LINE_COLOR_TYPE_YELLOW(2, "黄色"),
    EM_LINE_COLOR_TYPE_BLUE(3, "蓝色"),
    EM_LINE_COLOR_TYPE_GREEN(4, "绿色"),
    EM_LINE_COLOR_TYPE_BLACK(5, "黑色"),
    EM_LINE_COLOR_TYPE_WHITE(6, "白色");

    private EM_LINE_COLOR_TYPE(int type, String color) {
        this.type = type;
        this.color = color;
    }

    private int type;
    private String color;

    public EM_LINE_COLOR_TYPE getColorType(int type) {
        for (EM_LINE_COLOR_TYPE color : EM_LINE_COLOR_TYPE.values()
        ) {
            if (color.getType() == type) {
                return color;
            }
        }
        return null;
    }

    public int getType() {
        return type;
    }

    public String getColor() {
        return color;
    }
}
