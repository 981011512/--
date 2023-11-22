package com.cf.forward.dh.lib.enumeration;

/**
 * 信号灯指示状态
 *
 * @author ： 47040
 * @since ： Created in 2020/8/29 17:02
 */
public enum NET_TRAFFIC_LIGHT_STATUS {

    /**
     * 未知
     */
    LIGHT_STATUS_UNKNOWN(0, "未知"),
    /**
     * 红灯
     */
    LIGHT_STATUS_RED(1, "红灯"),
    /**
     * 绿灯
     */
    LIGHT_STATUS_GREEN(2, "绿灯"),
    /**
     * 黄灯
     */
    LIGHT_STATUS_YELLOW(3, "黄灯");

    private int value;
    private String note;

    NET_TRAFFIC_LIGHT_STATUS(int givenValue, String note) {
        this.value = givenValue;
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public int getValue() {
        return value;
    }

    public static String getNoteByValue(int givenValue) {
        for (NET_TRAFFIC_LIGHT_STATUS enumType : NET_TRAFFIC_LIGHT_STATUS.values()) {
            if (givenValue == enumType.getValue()) {
                return enumType.getNote();
            }
        }
        return null;
    }

    public static int getValueByNote(String givenNote) {
        for (NET_TRAFFIC_LIGHT_STATUS enumType : NET_TRAFFIC_LIGHT_STATUS.values()) {
            if (givenNote.equals(enumType.getNote())) {
                return enumType.getValue();
            }
        }
        return -1;
    }
}
