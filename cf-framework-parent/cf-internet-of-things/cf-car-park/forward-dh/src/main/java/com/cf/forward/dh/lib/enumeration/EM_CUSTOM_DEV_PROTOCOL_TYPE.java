package com.cf.forward.dh.lib.enumeration;

/**
 * @author ： 47040
 * @since ： Created in 2020/8/13 9:54
 */
public enum EM_CUSTOM_DEV_PROTOCOL_TYPE {

    /**
     * Private
     */
    EM_CUSTOM_DEV_PROTOCOL_TYPE_PRIVATE(0, "Private"),
    /**
     * Dahua2
     */
    EM_CUSTOM_DEV_PROTOCOL_TYPE_DAHUA2(1, "Dahua2"),
    /**
     * Dahua3
     */
    EM_CUSTOM_DEV_PROTOCOL_TYPE_DAHUA3(2, "Dahua3"),
    /**
     * 以URL形式添加的设备
     */
    EM_CUSTOM_DEV_PROTOCOL_TYPE_GENERAL(3, "以URL形式添加的设备"),
    /**
     * Onvif接入
     */
    EM_CUSTOM_DEV_PROTOCOL_TYPE_ONVIF(4, "Onvif接入"),
    /**
     * Onvif加密形式接入
     */
    EM_CUSTOM_DEV_PROTOCOL_TYPE_ONVIFS(5, "Onvif加密形式接入"),
    /**
     * 国标28181接入
     */
    EM_CUSTOM_DEV_PROTOCOL_TYPE_GB28181(6, "国标28181接入"),
    /**
     * 海康Ehome协议
     */
    EM_CUSTOM_DEV_PROTOCOL_TYPE_EHOME(7, "海康Ehome协议"),
    /**
     * 主动注册
     */
    EM_CUSTOM_DEV_PROTOCOL_TYPE_DAHUA_REG(8, "主动注册");

    private int value;
    private String note;

    private EM_CUSTOM_DEV_PROTOCOL_TYPE(int givenValue, String note) {
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
        for (EM_CUSTOM_DEV_PROTOCOL_TYPE enumType : EM_CUSTOM_DEV_PROTOCOL_TYPE.values()) {
            if (givenValue == enumType.getValue()) {
                return enumType.getNote();
            }
        }
        return null;
    }

    public static int getValueByNote(String givenNote) {
        for (EM_CUSTOM_DEV_PROTOCOL_TYPE enumType : EM_CUSTOM_DEV_PROTOCOL_TYPE.values()) {
            if (givenNote.equals(enumType.getNote()) ) {
                return enumType.getValue();
            }
        }
        return -1;
    }
}
