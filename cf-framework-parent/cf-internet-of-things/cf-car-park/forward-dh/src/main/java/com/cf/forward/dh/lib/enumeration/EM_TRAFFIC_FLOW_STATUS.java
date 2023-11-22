package com.cf.forward.dh.lib.enumeration;

/**
 * 流量状态
 *
 * @author ： 47040
 * @since ： Created in 2020/12/17 11:42
 */
public enum EM_TRAFFIC_FLOW_STATUS {

    /**
     * 未知
     */
    EM_TRAFFIC_FLOW_STATUS_UNKNOWN(0, "未知"),
    /**
     * 交通拥堵
     */
    EM_TRAFFIC_FLOW_STATUS_CONGESTION(1, "交通拥堵"),
    /**
     * 交通畅通
     */
    EM_TRAFFIC_FLOW_STATUS_SMOOTH(2, "交通畅通");

    private final int value;
    private final String note;

    EM_TRAFFIC_FLOW_STATUS(int givenValue, String note) {
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
        for (EM_TRAFFIC_FLOW_STATUS enumType : EM_TRAFFIC_FLOW_STATUS.values()) {
            if (givenValue == enumType.getValue()) {
                return enumType.getNote();
            }
        }
        return null;
    }

    public static int getValueByNote(String givenNote) {
        for (EM_TRAFFIC_FLOW_STATUS enumType : EM_TRAFFIC_FLOW_STATUS.values()) {
            if (givenNote.equals(enumType.getNote())) {
                return enumType.getValue();
            }
        }
        return -1;
    }

    public static EM_TRAFFIC_FLOW_STATUS getEnum(int value) {
        for (EM_TRAFFIC_FLOW_STATUS e : EM_TRAFFIC_FLOW_STATUS.values()) {
            if (e.getValue() == value)
                return e;
        }
        return EM_TRAFFIC_FLOW_STATUS.EM_TRAFFIC_FLOW_STATUS_UNKNOWN;
    }
}
