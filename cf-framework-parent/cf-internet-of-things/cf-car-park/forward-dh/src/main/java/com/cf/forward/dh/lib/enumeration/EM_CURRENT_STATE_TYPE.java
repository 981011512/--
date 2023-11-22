package com.cf.forward.dh.lib.enumeration;

public enum EM_CURRENT_STATE_TYPE {
    EM_CURRENT_STATE_UNKNOWN(0, "电流状态未知"),
    EM_CURRENT_STATE_OVER_CURRENT(1, "电流过载"),                      // 电流过载
    EM_CURRENT_STATE_NORMAL(2, "电流正常"),                            // 电流正常
    EM_CURRENT_STATE_UNDER_CURRENT(3, "电源欠流");                     // 电源欠流

    private int value;
    private String note;

    private EM_CURRENT_STATE_TYPE(int givenValue, String note) {
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
        for (EM_CURRENT_STATE_TYPE enumType : EM_CURRENT_STATE_TYPE.values()) {
            if (givenValue == enumType.getValue()) {
                return enumType.getNote();
            }
        }
        return null;
    }

    public static int getValueByNote(String givenNote) {
        for (EM_CURRENT_STATE_TYPE enumType : EM_CURRENT_STATE_TYPE.values()) {
            if (givenNote.equals(enumType.getNote())) {
                return enumType.getValue();
            }
        }
        return -1;
    }

}
