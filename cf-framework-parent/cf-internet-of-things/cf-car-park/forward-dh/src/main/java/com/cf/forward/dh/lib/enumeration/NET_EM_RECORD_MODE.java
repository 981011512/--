package com.cf.forward.dh.lib.enumeration;

/**
 * 录像模式
 *
 * @author ： 47040
 * @since ： Created in 2020/9/28 15:39
 */
public enum NET_EM_RECORD_MODE {
    /**
     * 未知
     */
    NET_EM_RECORD_MODE_UNKNOWN(0, "未知"),
    /**
     * 课程录像模式
     */
    NET_EM_RECORD_MODE_COURSE(1, "课程录像模式"),
    /**
     * 普通模式
     */
    NET_EM_RECORD_MODE_NORMAL(2, "普通模式");

    private int value;
    private String note;

    NET_EM_RECORD_MODE(int givenValue, String note) {
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
        for (NET_EM_RECORD_MODE enumType : NET_EM_RECORD_MODE.values()) {
            if (givenValue == enumType.getValue()) {
                return enumType.getNote();
            }
        }
        return null;
    }

    public static int getValueByNote(String givenNote) {
        for (NET_EM_RECORD_MODE enumType : NET_EM_RECORD_MODE.values()) {
            if (givenNote.equals(enumType.getNote())) {
                return enumType.getValue();
            }
        }
        return -1;
    }

    public static NET_EM_RECORD_MODE getEnum(int value) {
        for (NET_EM_RECORD_MODE e : NET_EM_RECORD_MODE.values()) {
            if (e.getValue() == value)
                return e;
        }
        return NET_EM_RECORD_MODE.NET_EM_RECORD_MODE_UNKNOWN;
    }

}
