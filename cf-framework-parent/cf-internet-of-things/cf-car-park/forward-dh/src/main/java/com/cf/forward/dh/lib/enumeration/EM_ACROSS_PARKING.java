package com.cf.forward.dh.lib.enumeration;

/**
 * 是否跨位
 *
 * @author 47040
 * @since Created in 2020/11/18 14:40
 */
public enum EM_ACROSS_PARKING {
    /**
     * 未知
     */
    EM_ACROSS_PARKING_UNKNOWN(0, "未知"),
    /**
     * 未跨位
     */
    EM_ACROSS_PARKING_NO(1, "未跨位"),
    /**
     * 跨位
     */
    EM_ACROSS_PARKING_YES(2, "跨位");

    private int value;
    private String note;

    EM_ACROSS_PARKING(int givenValue, String note) {
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
        for (EM_ACROSS_PARKING enumType : EM_ACROSS_PARKING.values()) {
            if (givenValue == enumType.getValue()) {
                return enumType.getNote();
            }
        }
        return null;
    }

    public static int getValueByNote(String givenNote) {
        for (EM_ACROSS_PARKING enumType : EM_ACROSS_PARKING.values()) {
            if (givenNote.equals(enumType.getNote())) {
                return enumType.getValue();
            }
        }
        return -1;
    }

    public static EM_ACROSS_PARKING getEnum(int value) {
        for (EM_ACROSS_PARKING e : EM_ACROSS_PARKING.values()) {
            if (e.getValue() == value)
                return e;
        }
        return EM_ACROSS_PARKING.EM_ACROSS_PARKING_UNKNOWN;
    }
}
