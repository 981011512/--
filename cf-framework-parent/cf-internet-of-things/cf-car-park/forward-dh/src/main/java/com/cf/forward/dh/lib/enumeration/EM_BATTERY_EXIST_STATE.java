package com.cf.forward.dh.lib.enumeration;

public enum EM_BATTERY_EXIST_STATE {

    EM_BATTERY_EXIST_STATE_UNKNOWN(0, "电池在位未知"),
    EM_BATTERY_EXIST_STATE_EXIST(1, "电池在位"),                      // 电池在位
    EM_BATTERY_EXIST_STATE_MISSING(2, "电池丢失");                     // 电池丢失

    private int value;
    private String note;

    private EM_BATTERY_EXIST_STATE(int givenValue, String note) {
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
        for (EM_BATTERY_EXIST_STATE enumType : EM_BATTERY_EXIST_STATE.values()) {
            if (givenValue == enumType.getValue()) {
                return enumType.getNote();
            }
        }
        return null;
    }

    public static int getValueByNote(String givenNote) {
        for (EM_BATTERY_EXIST_STATE enumType : EM_BATTERY_EXIST_STATE.values()) {
            if (givenNote.equals(enumType.getNote())) {
                return enumType.getValue();
            }
        }
        return -1;
    }

}
