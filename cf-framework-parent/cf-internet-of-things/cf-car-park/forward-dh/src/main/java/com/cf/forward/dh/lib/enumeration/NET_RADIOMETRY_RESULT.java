package com.cf.forward.dh.lib.enumeration;

/**
 * 热成像测温点报警结果值类型
 */
public enum NET_RADIOMETRY_RESULT {

    /**
     * 未知
     */
    NET_RADIOMETRY_RESULT_UNKNOWN(0, "未知"),
    /**
     * 具体值
     */
    NET_RADIOMETRY_RESULT_VAL(1, "具体值"),
    /**
     * 最大
     */
    NET_RADIOMETRY_RESULT_MAX(2, "最大"),
    /**
     * 最小
     */
    NET_RADIOMETRY_RESULT_MIN(3, "最小"),
    /**
     * 平均
     */
    NET_RADIOMETRY_RESULT_AVR(4, "平均"),
    /**
     * 标准
     */
    NET_RADIOMETRY_RESULT_STD(5, "标准"),
    /**
     * 中间
     */
    NET_RADIOMETRY_RESULT_MID(6, "中间"),
    /**
     * ISO
     */
    NET_RADIOMETRY_RESULT_ISO(7, "ISO"),
    /**
     * 温差
     */
    NET_RADIOMETRY_RESULT_DIFF(8, "温差"),
    /**
     * 斜率
     */
    NET_RADIOMETRY_RESULT_SLOPE(9, "斜率");

    private int value;
    private String note;

    NET_RADIOMETRY_RESULT(int givenValue, String note) {
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
        for (NET_RADIOMETRY_RESULT enumType : NET_RADIOMETRY_RESULT.values()) {
            if (givenValue == enumType.getValue()) {
                return enumType.getNote();
            }
        }
        return null;
    }

    public static int getValueByNote(String givenNote) {
        for (NET_RADIOMETRY_RESULT enumType : NET_RADIOMETRY_RESULT.values()) {
            if (givenNote.equals(enumType.getNote())) {
                return enumType.getValue();
            }
        }
        return -1;
    }

}
