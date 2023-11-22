package com.cf.forward.dh.lib.enumeration;

/**
 * 交通灯类型
 * @author ： 47040
 * @since ： Created in 2020/8/29 16:49
 */
public enum EM_TRFAFFIC_LIGHT_TYPE {
    /**
     * 未知
     */
    EM_TRFAFFIC_LIGHT_TYPE_UNKNOWN(0,"未知"),
    /**
     * 红灯
     */
    EM_TRFAFFIC_LIGHT_TYPE_RED(1,"红灯"),
    /**
     * 黄灯
     */
    EM_TRFAFFIC_LIGHT_TYPE_YELLOW(2,"黄灯"),
    /**
     * 绿灯
     */
    EM_TRFAFFIC_LIGHT_TYPE_GREEN(3,"绿灯");

    private int value;
    private String note;

    EM_TRFAFFIC_LIGHT_TYPE(int givenValue, String note) {
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
        for (EM_TRFAFFIC_LIGHT_TYPE enumType : EM_TRFAFFIC_LIGHT_TYPE.values()) {
            if (givenValue == enumType.getValue()) {
                return enumType.getNote();
            }
        }
        return null;
    }

    public static int getValueByNote(String givenNote) {
        for (EM_TRFAFFIC_LIGHT_TYPE enumType : EM_TRFAFFIC_LIGHT_TYPE.values()) {
            if (givenNote.equals(enumType.getNote())) {
                return enumType.getValue();
            }
        }
        return -1;
    }
}
