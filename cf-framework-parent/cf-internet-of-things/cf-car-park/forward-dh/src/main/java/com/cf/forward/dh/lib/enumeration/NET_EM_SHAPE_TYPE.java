package com.cf.forward.dh.lib.enumeration;

/**
 * 景物形状
 *
 * @author ： 47040
 * @since ： Created in 2020/10/26 16:01
 */
public enum NET_EM_SHAPE_TYPE {
    /**
     * 未知
     */
    NET_EM_SHAPE_TYPE_UNKNOWN(-1, "未知"),
    /**
     * 折线形
     */
    NET_EM_SHAPE_TYPE_MANSARD(0, "折线形"),
    /**
     * 扇形
     */
    NET_EM_SHAPE_TYPE_SECTOR(1, "扇形");

    private int value;
    private String note;

    NET_EM_SHAPE_TYPE(int givenValue, String note) {
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
        for (NET_EM_SHAPE_TYPE enumType : NET_EM_SHAPE_TYPE.values()) {
            if (givenValue == enumType.getValue()) {
                return enumType.getNote();
            }
        }
        return null;
    }

    public static int getValueByNote(String givenNote) {
        for (NET_EM_SHAPE_TYPE enumType : NET_EM_SHAPE_TYPE.values()) {
            if (givenNote.equals(enumType.getNote())) {
                return enumType.getValue();
            }
        }
        return -1;
    }

    public static NET_EM_SHAPE_TYPE getEnum(int value) {
        for (NET_EM_SHAPE_TYPE e : NET_EM_SHAPE_TYPE.values()) {
            if (e.getValue() == value)
                return e;
        }
        return NET_EM_SHAPE_TYPE.NET_EM_SHAPE_TYPE_UNKNOWN;
    }
}
