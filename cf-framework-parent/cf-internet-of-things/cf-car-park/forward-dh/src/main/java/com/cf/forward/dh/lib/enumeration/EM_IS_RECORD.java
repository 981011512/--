package com.cf.forward.dh.lib.enumeration;

/**
 * 录像使能
 *
 * @author ： 47040
 * @since ： Created in 2020/9/17 15:57
 */
public enum EM_IS_RECORD {
    /**
     * 未知
     */
    EM_IS_RECORD_UNKNOWN(0, "未知"),
    /**
     * 录像
     */
    EM_IS_RECORD_ON(1, "录像"),
    /**
     * 不录像
     */
    EM_IS_RECORD_OFF(2, "不录像");

    private int value;
    private String note;

    EM_IS_RECORD(int givenValue, String note) {
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
        for (EM_IS_RECORD enumType : EM_IS_RECORD.values()) {
            if (givenValue == enumType.getValue()) {
                return enumType.getNote();
            }
        }
        return null;
    }

    public static int getValueByNote(String givenNote) {
        for (EM_IS_RECORD enumType : EM_IS_RECORD.values()) {
            if (givenNote.equals(enumType.getNote())) {
                return enumType.getValue();
            }
        }
        return -1;
    }

    public static EM_IS_RECORD getEnum(int value) {
        for (EM_IS_RECORD e : EM_IS_RECORD.values()) {
            if (e.getValue() == value)
                return e;
        }
        return EM_IS_RECORD.EM_IS_RECORD_UNKNOWN;
    }
}
