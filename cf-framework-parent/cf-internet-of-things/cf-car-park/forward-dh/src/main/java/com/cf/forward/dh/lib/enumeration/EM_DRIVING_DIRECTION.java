package com.cf.forward.dh.lib.enumeration;

public enum EM_DRIVING_DIRECTION {

    /**
     * 未知
     */
    EM_DRIVING_DIRECTION_UNKNOWN(0,"未知"),
    /**
     * 驶入
     */
    EM_DRIVING_DIRECTION_IN(1,"驶入"),
    /**
     * 驶出
     */
    EM_DRIVING_DIRECTION_OUT(2,"驶出");

    private int value;
    private String note;

    private EM_DRIVING_DIRECTION(int givenValue, String note) {
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
        for (EM_DRIVING_DIRECTION enumType : EM_DRIVING_DIRECTION.values()) {
            if (givenValue == enumType.getValue()) {
                return enumType.getNote();
            }
        }
        return null;
    }

    public static int getValueByNote(String givenNote) {
        for (EM_DRIVING_DIRECTION enumType : EM_DRIVING_DIRECTION.values()) {
            if (givenNote.equals(enumType.getNote()) ) {
                return enumType.getValue();
            }
        }
        return -1;
    }
}
