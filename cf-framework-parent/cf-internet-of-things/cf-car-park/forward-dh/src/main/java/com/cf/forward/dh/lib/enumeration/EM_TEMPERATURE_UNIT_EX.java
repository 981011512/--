package com.cf.forward.dh.lib.enumeration;

/**
 * 温度单位
 *
 * @author 47040
 * @version 1.0.0
 * @since Created in 2021/3/8 20:45
 */
public enum EM_TEMPERATURE_UNIT_EX {

    /**
     * 未知
     */
    EM_TEMPERATURE_EX_UNKNOWN(0, "未知"),
    /**
     * 摄氏度
     */
    EM_TEMPERATURE_EX_CENTIGRADE(1, "摄氏度"),
    /**
     * 华氏度
     */
    EM_TEMPERATURE_EX_FAHRENHEIT(2, "华氏度"),
    /**
     * 开尔文
     */
    EM_TEMPERATURE_EX_KELVIN(3, "开尔文");

    private final int value;
    private final String note;

    EM_TEMPERATURE_UNIT_EX(int givenValue, String note) {
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
        for (EM_TEMPERATURE_UNIT_EX enumType : EM_TEMPERATURE_UNIT_EX.values()) {
            if (givenValue == enumType.getValue()) {
                return enumType.getNote();
            }
        }
        return null;
    }

    public static int getValueByNote(String givenNote) {
        for (EM_TEMPERATURE_UNIT_EX enumType : EM_TEMPERATURE_UNIT_EX.values()) {
            if (givenNote.equals(enumType.getNote())) {
                return enumType.getValue();
            }
        }
        return -1;
    }

    public static EM_TEMPERATURE_UNIT_EX getEnum(int value) {
        for (EM_TEMPERATURE_UNIT_EX e : EM_TEMPERATURE_UNIT_EX.values()) {
            if (e.getValue() == value)
                return e;
        }
        return EM_TEMPERATURE_UNIT_EX.EM_TEMPERATURE_EX_UNKNOWN;
    }

}
