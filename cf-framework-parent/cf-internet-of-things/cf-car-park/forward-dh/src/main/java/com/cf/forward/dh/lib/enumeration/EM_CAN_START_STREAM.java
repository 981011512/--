package com.cf.forward.dh.lib.enumeration;

/**
 * 拉流使能
 *
 * @author ： 47040
 * @since ： Created in 2020/9/17 15:53
 */
public enum EM_CAN_START_STREAM {

    /**
     * 未知
     */
    EM_CAN_START_STREAM_UNKNOWN(-1, "未知"),

    /**
     * 不拉流
     */
    EM_CAN_START_STREAM_OFF(0, "不拉流"),

    /**
     * 拉流
     */
    EM_CAN_START_STREAM_ON(1, "拉流");

    private int value;
    private String note;

    EM_CAN_START_STREAM(int givenValue, String note) {
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
        for (EM_CAN_START_STREAM enumType : EM_CAN_START_STREAM.values()) {
            if (givenValue == enumType.getValue()) {
                return enumType.getNote();
            }
        }
        return null;
    }

    public static int getValueByNote(String givenNote) {
        for (EM_CAN_START_STREAM enumType : EM_CAN_START_STREAM.values()) {
            if (givenNote.equals(enumType.getNote())) {
                return enumType.getValue();
            }
        }
        return -1;
    }

    public static EM_CAN_START_STREAM getEnum(int value) {
        for (EM_CAN_START_STREAM e : EM_CAN_START_STREAM.values()) {
            if (e.getValue() == value)
                return e;
        }
        return EM_CAN_START_STREAM.EM_CAN_START_STREAM_UNKNOWN;
    }
}
