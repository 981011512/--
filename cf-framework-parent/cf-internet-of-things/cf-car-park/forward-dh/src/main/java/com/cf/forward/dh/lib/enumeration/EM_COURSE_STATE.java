package com.cf.forward.dh.lib.enumeration;

/**
 * 课程状态
 *
 * @author ： 47040
 * @since ： Created in 2020/9/17 16:00
 */
public enum EM_COURSE_STATE {
    /**
     * 未知
     */
    EM_COURSE_STATE_UNKNOWN(0, "未知"),
    /**
     * 未录制
     */
    EM_COURSE_STATE_NOT_RECORD(1, "未录制"),
    /**
     * 录制中
     */
    EM_COURSE_STATE_IN_RECORDING(2, "录制中"),
    /**
     * 已录制
     */
    EM_COURSE_STATE_ALREADY_RECORDED(3, "已录制");

    private int value;
    private String note;

    EM_COURSE_STATE(int givenValue, String note) {
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
        for (EM_COURSE_STATE enumType : EM_COURSE_STATE.values()) {
            if (givenValue == enumType.getValue()) {
                return enumType.getNote();
            }
        }
        return null;
    }

    public static int getValueByNote(String givenNote) {
        for (EM_COURSE_STATE enumType : EM_COURSE_STATE.values()) {
            if (givenNote.equals(enumType.getNote())) {
                return enumType.getValue();
            }
        }
        return -1;
    }
}
