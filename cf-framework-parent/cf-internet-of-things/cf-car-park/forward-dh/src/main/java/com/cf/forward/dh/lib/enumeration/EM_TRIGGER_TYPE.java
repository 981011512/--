package com.cf.forward.dh.lib.enumeration;

/**
 * @author ： 47040
 * @since ： Created in 2020/8/19 10:21
 */
public enum EM_TRIGGER_TYPE {
    /**
     * 未知类型
     */
    EM_TRIGGER_TYPE_UNKNOWN(-1,"未知类型"),
    /**
     * 车检器
     */
    EM_TRIGGER_TYPE_CAR_INSPECTION_DEV(0,"车检器"),	   // 车检器
    /**
     * 雷达
     */
    EM_TRIGGER_TYPE_DADAR(1,"雷达"),
    /**
     * 视频
     */
    EM_TRIGGER_TYPE_VIDEO(2,"视频");

    private int value;
    private String note;

    private EM_TRIGGER_TYPE(int givenValue, String note) {
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
        for (EM_TRIGGER_TYPE enumType : EM_TRIGGER_TYPE.values()) {
            if (givenValue == enumType.getValue()) {
                return enumType.getNote();
            }
        }
        return null;
    }

    public static int getValueByNote(String givenNote) {
        for (EM_TRIGGER_TYPE enumType : EM_TRIGGER_TYPE.values()) {
            if (givenNote.equals(enumType.getNote()) ) {
                return enumType.getValue();
            }
        }
        return -1;
    }
}
