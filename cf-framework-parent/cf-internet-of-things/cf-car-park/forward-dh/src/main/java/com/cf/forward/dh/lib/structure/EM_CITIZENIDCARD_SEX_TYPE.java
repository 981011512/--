package com.cf.forward.dh.lib.structure;

public enum EM_CITIZENIDCARD_SEX_TYPE {
    /**
     * 未知
     */
    EM_CITIZENIDCARD_SEX_TYPE_UNKNOWN(0, "未知"),
    /**
     * 男
     */
    EM_CITIZENIDCARD_SEX_TYPE_MALE(1, "男"),
    /**
     * 女
     */
    EM_CITIZENIDCARD_SEX_TYPE_FEMALE(2, "女"),
    /**
     * 未说明
     */
    EM_CITIZENIDCARD_SEX_TYPE_UNTOLD(3, "未说明");

    private int value;
    private String note;

    private EM_CITIZENIDCARD_SEX_TYPE(int givenValue, String note) {
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
        for (EM_CITIZENIDCARD_SEX_TYPE enumType : EM_CITIZENIDCARD_SEX_TYPE.values()) {
            if (givenValue == enumType.getValue()) {
                return enumType.getNote();
            }
        }
        return null;
    }

    public static int getValueByNote(String givenNote) {
        for (EM_CITIZENIDCARD_SEX_TYPE enumType : EM_CITIZENIDCARD_SEX_TYPE.values()) {
            if (givenNote.equals(enumType.getNote())) {
                return enumType.getValue();
            }
        }
        return -1;
    }
}
