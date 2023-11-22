package com.cf.forward.dh.lib.enumeration;

public enum EM_VOLTAGE_STATE_TYPE {
    EM_VOLTAGE_STATE_UNKNOWN(1,"电压状态未知"),                           // 未知
    EM_VOLTAGE_STATE_OVER (2, "电压过高"),                           // 过压
    EM_VOLTAGE_STATE_NORMAL (3, "电压正常"),                           // 正常
    EM_VOLTAGE_STATE_UNDER (4, "欠压");                           // 欠压

    private int value;
    private String note;

    private EM_VOLTAGE_STATE_TYPE(int givenValue, String note) {
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
        for (EM_VOLTAGE_STATE_TYPE enumType : EM_VOLTAGE_STATE_TYPE.values()) {
            if (givenValue == enumType.getValue()) {
                return enumType.getNote();
            }
        }
        return null;
    }

    public static int getValueByNote(String givenNote) {
        for (EM_VOLTAGE_STATE_TYPE enumType : EM_VOLTAGE_STATE_TYPE.values()) {
            if (givenNote.equals(enumType.getNote())) {
                return enumType.getValue();
            }
        }
        return -1;
    }
}
