package com.cf.forward.dh.lib.enumeration;

/**
 * 下载数据类型
 *
 * @author ： 47040
 * @since ： Created in 2020/12/28 16:03
 */
public enum EM_DOWNLOAD_DATA_TYPE {

    EM_DOWNLOAD_DATA_RECORD(0, "录像"),
    EM_DOWNLOAD_DATA_PICTURE(1, "图片");

    private final int value;
    private final String note;

    EM_DOWNLOAD_DATA_TYPE(int givenValue, String note) {
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
        for (EM_DOWNLOAD_DATA_TYPE enumType : EM_DOWNLOAD_DATA_TYPE.values()) {
            if (givenValue == enumType.getValue()) {
                return enumType.getNote();
            }
        }
        return null;
    }

    public static int getValueByNote(String givenNote) {
        for (EM_DOWNLOAD_DATA_TYPE enumType : EM_DOWNLOAD_DATA_TYPE.values()) {
            if (givenNote.equals(enumType.getNote())) {
                return enumType.getValue();
            }
        }
        return -1;
    }

    public static EM_DOWNLOAD_DATA_TYPE getEnum(int value) {
        for (EM_DOWNLOAD_DATA_TYPE e : EM_DOWNLOAD_DATA_TYPE.values()) {
            if (e.getValue() == value)
                return e;
        }
        return EM_DOWNLOAD_DATA_TYPE.EM_DOWNLOAD_DATA_RECORD;
    }

}
