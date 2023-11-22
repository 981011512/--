package com.cf.forward.dh.lib.enumeration;

public enum NET_RADIOMETRY_ALARMCONTION {

    /**
     * 未知
     */
    NET_RADIOMETRY_ALARMCONTION_UNKNOWN(0, "未知"),
    /**
     * 小于
     */
    NET_RADIOMETRY_ALARMCONTION_BELOW(1, "小于"),
    /**
     * 等于
     */
    NET_RADIOMETRY_ALARMCONTION_MATCH(2, "等于"),
    /**
     * 大于
     */
    NET_RADIOMETRY_ALARMCONTION_ABOVE(3, "大于");

    private int value;
    private String note;

    NET_RADIOMETRY_ALARMCONTION(int givenValue, String note) {
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
        for (NET_RADIOMETRY_ALARMCONTION enumType : NET_RADIOMETRY_ALARMCONTION.values()) {
            if (givenValue == enumType.getValue()) {
                return enumType.getNote();
            }
        }
        return null;
    }

    public static int getValueByNote(String givenNote) {
        for (NET_RADIOMETRY_ALARMCONTION enumType : NET_RADIOMETRY_ALARMCONTION.values()) {
            if (givenNote.equals(enumType.getNote())) {
                return enumType.getValue();
            }
        }
        return -1;
    }

}
