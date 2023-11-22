package com.cf.forward.dh.lib.enumeration;

/**
 * 探测物体的传感器类型
 *
 * @author ： 47040
 * @since ： Created in 2020/12/17 13:45
 */
public enum EM_DETECT_SENSOR_TYPE {
    /**
     * 未知
     */
    EM_DETECT_SENSOR_TYPE_UNKNOWN(0, "未知"),
    /**
     * 线圈
     */
    EM_DETECT_SENSOR_TYPE_COIL(1, "线圈"),
    /**
     * 视频
     */
    EM_DETECT_SENSOR_TYPE_VIDEO(2, "视频"),
    /**
     * 雷达
     */
    EM_DETECT_SENSOR_TYPE_RADAR(3, "雷达"),
    /**
     * 5G
     */
    EM_DETECT_SENSOR_TYPE_5G(4, "5G"),
    /**
     * 融合
     */
    EM_DETECT_SENSOR_TYPE_FUSION(5, "融合");

    private final int value;
    private final String note;

    EM_DETECT_SENSOR_TYPE(int givenValue, String note) {
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
        for (EM_DETECT_SENSOR_TYPE enumType : EM_DETECT_SENSOR_TYPE.values()) {
            if (givenValue == enumType.getValue()) {
                return enumType.getNote();
            }
        }
        return null;
    }

    public static int getValueByNote(String givenNote) {
        for (EM_DETECT_SENSOR_TYPE enumType : EM_DETECT_SENSOR_TYPE.values()) {
            if (givenNote.equals(enumType.getNote())) {
                return enumType.getValue();
            }
        }
        return -1;
    }

    public static EM_DETECT_SENSOR_TYPE getEnum(int value) {
        for (EM_DETECT_SENSOR_TYPE e : EM_DETECT_SENSOR_TYPE.values()) {
            if (e.getValue() == value)
                return e;
        }
        return EM_DETECT_SENSOR_TYPE.EM_DETECT_SENSOR_TYPE_UNKNOWN;
    }
}
