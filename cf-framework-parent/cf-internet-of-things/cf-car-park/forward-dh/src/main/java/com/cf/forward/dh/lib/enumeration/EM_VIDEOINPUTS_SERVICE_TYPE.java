package com.cf.forward.dh.lib.enumeration;

/**
 * 服务类型
 *
 * @author ： 47040
 * @since ： Created in 2020/8/13 10:22
 */
public enum EM_VIDEOINPUTS_SERVICE_TYPE {

    /**
     * 自动
     */
    EM_VIDEOINPUTS_SERVICE_TYPE_AUTO(0, "自动"),
    /**
     * TCP
     */
    EM_VIDEOINPUTS_SERVICE_TYPE_TCP(1, "TCP"),
    /**
     * UDP
     */
    EM_VIDEOINPUTS_SERVICE_TYPE_UDP(2, "UDP"),
    /**
     * 组播
     */
    EM_VIDEOINPUTS_SERVICE_TYPE_MULTICAST(3, "组播");

    private int value;
    private String note;

    private EM_VIDEOINPUTS_SERVICE_TYPE(int givenValue, String note) {
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
        for (EM_VIDEOINPUTS_SERVICE_TYPE enumType : EM_VIDEOINPUTS_SERVICE_TYPE.values()) {
            if (givenValue == enumType.getValue()) {
                return enumType.getNote();
            }
        }
        return null;
    }

    public static int getValueByNote(String givenNote) {
        for (EM_VIDEOINPUTS_SERVICE_TYPE enumType : EM_VIDEOINPUTS_SERVICE_TYPE.values()) {
            if (givenNote.equals(enumType.getNote())) {
                return enumType.getValue();
            }
        }
        return -1;
    }

}
