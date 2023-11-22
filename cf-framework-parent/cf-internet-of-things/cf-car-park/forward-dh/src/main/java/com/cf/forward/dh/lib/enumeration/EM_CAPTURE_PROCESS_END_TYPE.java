package com.cf.forward.dh.lib.enumeration;

public enum EM_CAPTURE_PROCESS_END_TYPE {

    /**
     * 未知
     */
    EM_CAPTURE_PROCESS_END_TYPE_UNKNOWN(-1,"未知"),
    /**
     * 异常
     */
    EM_CAPTURE_PROCESS_END_TYPE_ABNORMAL(0,"异常"),
    /**
     * 正常
     */
    EM_CAPTURE_PROCESS_END_TYPE_NORMAL(1,"正常");

    private int value;
    private String note;

    private EM_CAPTURE_PROCESS_END_TYPE(int givenValue, String note) {
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
        for (EM_CAPTURE_PROCESS_END_TYPE enumType : EM_CAPTURE_PROCESS_END_TYPE.values()) {
            if (givenValue == enumType.getValue()) {
                return enumType.getNote();
            }
        }
        return null;
    }

    public static int getValueByNote(String givenNote) {
        for (EM_CAPTURE_PROCESS_END_TYPE enumType : EM_CAPTURE_PROCESS_END_TYPE.values()) {
            if (givenNote.equals(enumType.getNote()) ) {
                return enumType.getValue();
            }
        }
        return -1;
    }

}
