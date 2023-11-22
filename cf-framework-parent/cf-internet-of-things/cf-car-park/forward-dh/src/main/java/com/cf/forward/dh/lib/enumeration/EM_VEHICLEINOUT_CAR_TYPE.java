package com.cf.forward.dh.lib.enumeration;

/**
 * 车辆类型
 *
 * @author ： 47040
 * @since ： Created in 2020/12/17 13:50
 */
public enum EM_VEHICLEINOUT_CAR_TYPE {
    /**
     * 未知类型
     */
    EM_VEHICLEINOUT_CAR_TYPE_UNKNOWN(0, "未知类型"),
    /**
     * 小型客车
     */
    EM_VEHICLEINOUT_CAR_TYPE_CAR(1, "小型客车"),
    /**
     * 面包车
     */
    EM_VEHICLEINOUT_CAR_TYPE_VAN(2, "面包车"),
    /**
     * 货车
     */
    EM_VEHICLEINOUT_CAR_TYPE_TRUCK(3, "货车"),
    /**
     * 公交车
     */
    EM_VEHICLEINOUT_CAR_TYPE_BUS(4, "公交车"),
    /**
     * 大货车
     */
    EM_VEHICLEINOUT_CAR_TYPE_LORRY(5, "大货车"),
    /**
     * 大车
     */
    EM_VEHICLEINOUT_CAR_TYPE_CART(6, "大车");

    private final int value;
    private final String note;

    EM_VEHICLEINOUT_CAR_TYPE(int givenValue, String note) {
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
        for (EM_VEHICLEINOUT_CAR_TYPE enumType : EM_VEHICLEINOUT_CAR_TYPE.values()) {
            if (givenValue == enumType.getValue()) {
                return enumType.getNote();
            }
        }
        return null;
    }

    public static int getValueByNote(String givenNote) {
        for (EM_VEHICLEINOUT_CAR_TYPE enumType : EM_VEHICLEINOUT_CAR_TYPE.values()) {
            if (givenNote.equals(enumType.getNote())) {
                return enumType.getValue();
            }
        }
        return -1;
    }

    public static EM_VEHICLEINOUT_CAR_TYPE getEnum(int value) {
        for (EM_VEHICLEINOUT_CAR_TYPE e : EM_VEHICLEINOUT_CAR_TYPE.values()) {
            if (e.getValue() == value)
                return e;
        }
        return EM_VEHICLEINOUT_CAR_TYPE.EM_VEHICLEINOUT_CAR_TYPE_UNKNOWN;
    }

}
