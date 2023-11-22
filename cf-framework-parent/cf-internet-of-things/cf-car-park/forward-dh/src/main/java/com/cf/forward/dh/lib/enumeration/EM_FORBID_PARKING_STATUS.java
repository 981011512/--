package com.cf.forward.dh.lib.enumeration;

/**
 * 禁停状态
 *
 * @author 47040
 * @since Created in 2020/11/18 14:53
 */
public enum EM_FORBID_PARKING_STATUS {
    /**
     * 未知
     */
    EM_FORBID_PARKING_STATUS_UNKNOWN(0, "未知"),
    /**
     * 未禁止
     */
    EM_FORBID_PARKING_STATUS_NOT_FORBID(1, "未禁止"),
    /**
     * 禁止
     */
    EM_FORBID_PARKING_STATUS_FORBID(2, "禁止");

    private int value;
    private String note;

    EM_FORBID_PARKING_STATUS(int givenValue, String note) {
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
        for (EM_FORBID_PARKING_STATUS enumType : EM_FORBID_PARKING_STATUS.values()) {
            if (givenValue == enumType.getValue()) {
                return enumType.getNote();
            }
        }
        return null;
    }

    public static int getValueByNote(String givenNote) {
        for (EM_FORBID_PARKING_STATUS enumType : EM_FORBID_PARKING_STATUS.values()) {
            if (givenNote.equals(enumType.getNote())) {
                return enumType.getValue();
            }
        }
        return -1;
    }

    public static EM_FORBID_PARKING_STATUS getEnum(int value) {
        for (EM_FORBID_PARKING_STATUS e : EM_FORBID_PARKING_STATUS.values()) {
            if (e.getValue() == value)
                return e;
        }
        return EM_FORBID_PARKING_STATUS.EM_FORBID_PARKING_STATUS_UNKNOWN;
    }
}
