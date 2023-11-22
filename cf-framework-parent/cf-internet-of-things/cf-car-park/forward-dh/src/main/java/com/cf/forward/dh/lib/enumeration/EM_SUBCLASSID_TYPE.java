package com.cf.forward.dh.lib.enumeration;

/**
 * @author ： 47040
 * @since ： Created in 2020/12/28 16:07
 */
public enum EM_SUBCLASSID_TYPE {

    EM_SUBCLASSID_UNKNOWN(0,"未知"),
    EM_SUBCLASSID_ASSISTDEVICE(1,"辅助设备 (ITSE使用)");

    private final int value;
    private final String note;

    EM_SUBCLASSID_TYPE(int givenValue, String note) {
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
        for (EM_SUBCLASSID_TYPE enumType : EM_SUBCLASSID_TYPE.values()) {
            if (givenValue == enumType.getValue()) {
                return enumType.getNote();
            }
        }
        return null;
    }

    public static int getValueByNote(String givenNote) {
        for (EM_SUBCLASSID_TYPE enumType : EM_SUBCLASSID_TYPE.values()) {
            if (givenNote.equals(enumType.getNote())) {
                return enumType.getValue();
            }
        }
        return -1;
    }

    public static EM_SUBCLASSID_TYPE getEnum(int value) {
        for (EM_SUBCLASSID_TYPE e : EM_SUBCLASSID_TYPE.values()) {
            if (e.getValue() == value)
                return e;
        }
        return EM_SUBCLASSID_TYPE.EM_SUBCLASSID_UNKNOWN;
    }

}
