package com.cf.forward.dh.lib.enumeration;

/**
 * 课程录像类型
 *
 * @author ： 47040
 * @since ： Created in 2020/9/28 16:31
 */
public enum EM_COURSE_RECORD_TYPE {
    /**
     * 未知
     */
    EM_COURSE_RECORD_TYPE_UNKNOWN(-1, "未知"),

    /**
     * 全部录像类型
     */
    EM_COURSE_RECORD_TYPE_ALL(0, "全部录像类型"),

    /**
     * 导播录像类型
     */
    EM_COURSE_RECORD_TYPE_GUIDED_BROADCAST(1, "导播录像类型"),

    /**
     * 互动录像类型
     */
    EM_COURSE_RECORD_TYPE_GUIDED_INTERACTION(2, "互动录像类型");

    private int value;
    private String note;

    EM_COURSE_RECORD_TYPE(int givenValue, String note) {
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
        for (EM_COURSE_RECORD_TYPE enumType : EM_COURSE_RECORD_TYPE.values()) {
            if (givenValue == enumType.getValue()) {
                return enumType.getNote();
            }
        }
        return null;
    }

    public static int getValueByNote(String givenNote) {
        for (EM_COURSE_RECORD_TYPE enumType : EM_COURSE_RECORD_TYPE.values()) {
            if (givenNote.equals(enumType.getNote())) {
                return enumType.getValue();
            }
        }
        return -1;
    }

    public static EM_COURSE_RECORD_TYPE getEnum(int value) {
        for (EM_COURSE_RECORD_TYPE e : EM_COURSE_RECORD_TYPE.values()) {
            if (e.getValue() == value)
                return e;
        }
        return EM_COURSE_RECORD_TYPE.EM_COURSE_RECORD_TYPE_UNKNOWN;
    }
}
