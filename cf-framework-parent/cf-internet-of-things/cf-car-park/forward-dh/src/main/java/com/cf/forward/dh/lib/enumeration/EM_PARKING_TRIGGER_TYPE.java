package com.cf.forward.dh.lib.enumeration;

/**
 * 车位抓拍触发类型
 *
 * @author 47040
 * @since Created in 2020/11/18 15:06
 */
public enum EM_PARKING_TRIGGER_TYPE {
    /**
     * 未知
     */
    EM_PARKING_TRIGGER_TYPE_UNKNOWN(-1, "未知"),
    /**
     * 非手动触发
     */
    EM_PARKING_TRIGGER_TYPE_NONMANUAL(0, "非手动触发"),
    /**
     * 手动触发
     */
    EM_PARKING_TRIGGER_TYPE_MANUAL(1, "手动触发");

    private int value;
    private String note;

    EM_PARKING_TRIGGER_TYPE(int givenValue, String note) {
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
        for (EM_PARKING_TRIGGER_TYPE enumType : EM_PARKING_TRIGGER_TYPE.values()) {
            if (givenValue == enumType.getValue()) {
                return enumType.getNote();
            }
        }
        return null;
    }

    public static int getValueByNote(String givenNote) {
        for (EM_PARKING_TRIGGER_TYPE enumType : EM_PARKING_TRIGGER_TYPE.values()) {
            if (givenNote.equals(enumType.getNote())) {
                return enumType.getValue();
            }
        }
        return -1;
    }

    public static EM_PARKING_TRIGGER_TYPE getEnum(int value) {
        for (EM_PARKING_TRIGGER_TYPE e : EM_PARKING_TRIGGER_TYPE.values()) {
            if (e.getValue() == value)
                return e;
        }
        return EM_PARKING_TRIGGER_TYPE.EM_PARKING_TRIGGER_TYPE_UNKNOWN;
    }

}
