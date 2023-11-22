package com.cf.forward.dh.lib.enumeration;

/**
 * 单个平台接入启动选项
 *
 * @author 47040
 * @version 1.0.0
 * @since Created in 2021/3/9 8:42
 */
public enum EM_SERVER_OPTION {
    /**
     * 未知
     */
    EM_SERVER_OPTION_UNKNOWN(0, "未知"),
    /**
     * 平台接入不启动
     */
    EM_SERVER_OPTION_DISABLE(1, "平台接入不启动"),
    /**
     * 以28181接入方式开启
     */
    EM_SERVER_OPTION_GB28181(2, "以28181接入方式开启"),
    /**
     * 以35114接入方式开启
     */
    EM_SERVER_OPTION_GB35114(3, "以35114接入方式开启");

    /**
     * 枚举值
     */
    private final int value;
    /**
     * 枚举描述
     */
    private final String note;

    EM_SERVER_OPTION(int givenValue, String note) {
        this.value = givenValue;
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public int getValue() {
        return value;
    }

    /**
     * 依据枚举值返回描述
     *
     * @param givenValue 枚举值
     * @return 对应描述
     */
    public static String getNoteByValue(int givenValue) {
        for (EM_SERVER_OPTION enumType : EM_SERVER_OPTION.values()) {
            if (givenValue == enumType.getValue()) {
                return enumType.getNote();
            }
        }
        return null;
    }

    /**
     * 依据描述返回枚举值
     *
     * @param givenNote 枚举描述
     * @return 对应枚举值
     */
    public static int getValueByNote(String givenNote) {
        for (EM_SERVER_OPTION enumType : EM_SERVER_OPTION.values()) {
            if (givenNote.equals(enumType.getNote())) {
                return enumType.getValue();
            }
        }
        return -1;
    }

    /**
     * 依据枚举值返回枚举类型
     *
     * @param value 枚举值
     * @return 对应枚举类型
     */
    public static EM_SERVER_OPTION getEnum(int value) {
        for (EM_SERVER_OPTION e : EM_SERVER_OPTION.values()) {
            if (e.getValue() == value)
                return e;
        }
        return EM_SERVER_OPTION.EM_SERVER_OPTION_UNKNOWN;
    }

}
