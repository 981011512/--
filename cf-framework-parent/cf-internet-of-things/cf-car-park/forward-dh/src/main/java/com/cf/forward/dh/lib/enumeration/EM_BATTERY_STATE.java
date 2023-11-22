package com.cf.forward.dh.lib.enumeration;

public enum EM_BATTERY_STATE {
    EM_BATTERY_STATE_UNKNOWN(0, "电量未知"),
    EM_BATTERY_STATE_NORMAL(1, "电量正常"),                      // 电量正常
    EM_BATTERY_STATE_LOW(2, "电量低");                     // 电量低

    private int value;
    private String note;

    private EM_BATTERY_STATE(int givenValue, String note) {
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
        for (EM_BATTERY_STATE enumType : EM_BATTERY_STATE.values()) {
            if (givenValue == enumType.getValue()) {
                return enumType.getNote();
            }
        }
        return null;
    }

    public static int getValueByNote(String givenNote) {
        for (EM_BATTERY_STATE enumType : EM_BATTERY_STATE.values()) {
            if (givenNote.equals(enumType.getNote())) {
                return enumType.getValue();
            }
        }
        return -1;
    }
}
