package com.cf.forward.dh.lib.enumeration;

/**
 * 红绿灯触发源
 *
 * @author ： 47040
 * @since ： Created in 2020/8/29 16:43
 */
public enum EM_TRFAFFIC_LIGHT_SOURCE {

    /**
     * 未知
     */
    EM_TRFAFFIC_LIGHT_SOURCE_UNKNOWN(0, "未知"),
    /**
     * 信号检测器
     */
    EM_TRFAFFIC_LIGHT_SOURCE_SIGNAL(1, "信号检测器"),
    /**
     * DSP(算法检测)
     */
    EM_TRFAFFIC_LIGHT_SOURCE_DSP(2, "DSP(算法检测)"),
    /**
     * 网络信号检测器
     */
    EM_TRFAFFIC_LIGHT_SOURCE_NET_SIGNAL(3, "网络信号检测器");

    private int value;
    private String note;

    EM_TRFAFFIC_LIGHT_SOURCE(int givenValue, String note) {
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
        for (EM_TRFAFFIC_LIGHT_SOURCE enumType : EM_TRFAFFIC_LIGHT_SOURCE.values()) {
            if (givenValue == enumType.getValue()) {
                return enumType.getNote();
            }
        }
        return null;
    }

    public static int getValueByNote(String givenNote) {
        for (EM_TRFAFFIC_LIGHT_SOURCE enumType : EM_TRFAFFIC_LIGHT_SOURCE.values()) {
            if (givenNote.equals(enumType.getNote())) {
                return enumType.getValue();
            }
        }
        return -1;
    }
}
