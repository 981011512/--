package com.cf.forward.dh.lib.enumeration;

/**
 * 下载文件方式
 *
 * @author ： 47040
 * @since ： Created in 2020/12/28 15:25
 */
public enum EM_DOWNLOAD_FILE_TYPE {

    EM_DOWNLOAD_BY_FILENAME(0,"按文件名下载"),
    EM_DOWNLOAD_BY_CONDITION(1,"按条件下载");

    private final int value;
    private final String note;

    EM_DOWNLOAD_FILE_TYPE(int givenValue, String note) {
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
        for (EM_DOWNLOAD_FILE_TYPE enumType : EM_DOWNLOAD_FILE_TYPE.values()) {
            if (givenValue == enumType.getValue()) {
                return enumType.getNote();
            }
        }
        return null;
    }

    public static int getValueByNote(String givenNote) {
        for (EM_DOWNLOAD_FILE_TYPE enumType : EM_DOWNLOAD_FILE_TYPE.values()) {
            if (givenNote.equals(enumType.getNote())) {
                return enumType.getValue();
            }
        }
        return -1;
    }

    public static EM_DOWNLOAD_FILE_TYPE getEnum(int value) {
        for (EM_DOWNLOAD_FILE_TYPE e : EM_DOWNLOAD_FILE_TYPE.values()) {
            if (e.getValue() == value)
                return e;
        }
        return EM_DOWNLOAD_FILE_TYPE.EM_DOWNLOAD_BY_FILENAME;
    }

}
