package com.cf.forward.dh.lib.enumeration;

/**
 * 下载时间类型
 *
 * @author ： 47040
 * @since ： Created in 2020/12/28 15:58
 */
public enum EM_DOWNLOAD_TIME_TYPE {

    EM_DOWNLOAD_TIME_SNAP(0, "抓拍时间"),
    EM_DOWNLOAD_TIME_STORAGE(1, "存储时间");

    private final int value;
    private final String note;

    EM_DOWNLOAD_TIME_TYPE(int givenValue, String note) {
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
        for (EM_DOWNLOAD_TIME_TYPE enumType : EM_DOWNLOAD_TIME_TYPE.values()) {
            if (givenValue == enumType.getValue()) {
                return enumType.getNote();
            }
        }
        return null;
    }

    public static int getValueByNote(String givenNote) {
        for (EM_DOWNLOAD_TIME_TYPE enumType : EM_DOWNLOAD_TIME_TYPE.values()) {
            if (givenNote.equals(enumType.getNote())) {
                return enumType.getValue();
            }
        }
        return -1;
    }

    public static EM_DOWNLOAD_TIME_TYPE getEnum(int value) {
        for (EM_DOWNLOAD_TIME_TYPE e : EM_DOWNLOAD_TIME_TYPE.values()) {
            if (e.getValue() == value)
                return e;
        }
        return EM_DOWNLOAD_TIME_TYPE.EM_DOWNLOAD_TIME_SNAP;
    }

}
