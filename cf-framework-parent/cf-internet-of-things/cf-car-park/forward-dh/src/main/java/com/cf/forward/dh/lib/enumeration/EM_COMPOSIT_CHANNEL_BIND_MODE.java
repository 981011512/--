package com.cf.forward.dh.lib.enumeration;

/**
 * 默认组合通道绑定模式
 *
 * @author ： 47040
 * @since ： Created in 2020/9/27 15:32
 */
public enum EM_COMPOSIT_CHANNEL_BIND_MODE {
    /**
     * 未知
     */
    EM_COMPOSIT_CHANNEL_BIND_MODE_UNKNOWN(0, "未知"),
    /**
     * 自动
     */
    EM_COMPOSIT_CHANNEL_BIND_MODE_AUTOMATIC(1, "自动"),
    /**
     * 半自动
     */
    EM_COMPOSIT_CHANNEL_BIND_MODE_SEMIAUTOMATIC(2, "半自动"),
    /**
     * 手动
     */
    EM_COMPOSIT_CHANNEL_BIND_MODE_MANUAL(3, "手动");

    private int value;
    private String note;

    EM_COMPOSIT_CHANNEL_BIND_MODE(int givenValue, String note) {
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
        for (EM_COMPOSIT_CHANNEL_BIND_MODE enumType : EM_COMPOSIT_CHANNEL_BIND_MODE.values()) {
            if (givenValue == enumType.getValue()) {
                return enumType.getNote();
            }
        }
        return null;
    }

    public static int getValueByNote(String givenNote) {
        for (EM_COMPOSIT_CHANNEL_BIND_MODE enumType : EM_COMPOSIT_CHANNEL_BIND_MODE.values()) {
            if (givenNote.equals(enumType.getNote())) {
                return enumType.getValue();
            }
        }
        return -1;
    }

    public static EM_COMPOSIT_CHANNEL_BIND_MODE getEnum(int value) {
        for (EM_COMPOSIT_CHANNEL_BIND_MODE e : EM_COMPOSIT_CHANNEL_BIND_MODE.values()) {
            if (e.getValue() == value)
                return e;
        }
        return EM_COMPOSIT_CHANNEL_BIND_MODE.EM_COMPOSIT_CHANNEL_BIND_MODE_UNKNOWN;
    }
}
