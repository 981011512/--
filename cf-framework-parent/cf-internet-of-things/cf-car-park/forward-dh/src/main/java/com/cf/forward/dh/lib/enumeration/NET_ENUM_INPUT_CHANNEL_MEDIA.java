package com.cf.forward.dh.lib.enumeration;

/**
 * 输入媒体介质
 *
 * @author ： 47040
 * @since ： Created in 2020/9/28 16:05
 */
public enum NET_ENUM_INPUT_CHANNEL_MEDIA {
    /**
     * 未知
     */
    NET_ENUM_INPUT_MEDIA_UNKNOWN(0, "未知"),
    /**
     * VGA
     */
    NET_ENUM_INPUT_MEDIA_VGA(1, "VGA"),
    /**
     * HDMI
     */
    NET_ENUM_INPUT_MEDIA_HDMI(2, "HDMI");

    private int value;
    private String note;

    NET_ENUM_INPUT_CHANNEL_MEDIA(int givenValue, String note) {
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
        for (NET_ENUM_INPUT_CHANNEL_MEDIA enumType : NET_ENUM_INPUT_CHANNEL_MEDIA.values()) {
            if (givenValue == enumType.getValue()) {
                return enumType.getNote();
            }
        }
        return null;
    }

    public static int getValueByNote(String givenNote) {
        for (NET_ENUM_INPUT_CHANNEL_MEDIA enumType : NET_ENUM_INPUT_CHANNEL_MEDIA.values()) {
            if (givenNote.equals(enumType.getNote())) {
                return enumType.getValue();
            }
        }
        return -1;
    }

    public static NET_ENUM_INPUT_CHANNEL_MEDIA getEnum(int value) {
        for (NET_ENUM_INPUT_CHANNEL_MEDIA e : NET_ENUM_INPUT_CHANNEL_MEDIA.values()) {
            if (e.getValue() == value)
                return e;
        }
        return NET_ENUM_INPUT_CHANNEL_MEDIA.NET_ENUM_INPUT_MEDIA_UNKNOWN;
    }
}
