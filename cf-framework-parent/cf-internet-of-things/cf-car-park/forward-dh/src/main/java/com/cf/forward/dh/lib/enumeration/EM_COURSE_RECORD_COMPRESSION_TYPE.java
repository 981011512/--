package com.cf.forward.dh.lib.enumeration;

/**
 * 课程录像压缩类型
 *
 * @author ： 47040
 * @since ： Created in 2020/9/28 16:55
 */
public enum EM_COURSE_RECORD_COMPRESSION_TYPE {
    /**
     * 未知
     */
    EM_COURSE_RECORD_COMPRESSION_TYPE_UNKNOWN(0, "未知"),
    /**
     * H.264 默认值
     */
    EM_COURSE_RECORD_COMPRESSION_TYPE_H264(1, "H.264 默认值"),
    /**
     * H.265
     */
    EM_COURSE_RECORD_COMPRESSION_TYPE_H265(2, "H.265");

    private int value;
    private String note;

    EM_COURSE_RECORD_COMPRESSION_TYPE(int givenValue, String note) {
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
        for (EM_COURSE_RECORD_COMPRESSION_TYPE enumType : EM_COURSE_RECORD_COMPRESSION_TYPE.values()) {
            if (givenValue == enumType.getValue()) {
                return enumType.getNote();
            }
        }
        return null;
    }

    public static int getValueByNote(String givenNote) {
        for (EM_COURSE_RECORD_COMPRESSION_TYPE enumType : EM_COURSE_RECORD_COMPRESSION_TYPE.values()) {
            if (givenNote.equals(enumType.getNote())) {
                return enumType.getValue();
            }
        }
        return -1;
    }

    public static EM_COURSE_RECORD_COMPRESSION_TYPE getEnum(int value) {
        for (EM_COURSE_RECORD_COMPRESSION_TYPE e : EM_COURSE_RECORD_COMPRESSION_TYPE.values()) {
            if (e.getValue() == value)
                return e;
        }
        return EM_COURSE_RECORD_COMPRESSION_TYPE.EM_COURSE_RECORD_COMPRESSION_TYPE_UNKNOWN;
    }
}
