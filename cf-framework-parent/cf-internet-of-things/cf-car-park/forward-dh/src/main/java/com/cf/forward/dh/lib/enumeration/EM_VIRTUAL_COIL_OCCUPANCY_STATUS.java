package com.cf.forward.dh.lib.enumeration;

/**
 * 虚拟线圈占用状态
 *
 * @author ： 47040
 * @since ： Created in 2020/12/17 11:50
 */
public enum EM_VIRTUAL_COIL_OCCUPANCY_STATUS {
    /**
     * 未知
     */
    EM_VIRTUAL_COIL_OCCUPANCY_STATUS_UNKNOWN(-1,"未知"),
    /**
     * 未占用
     */
    EM_VIRTUAL_COIL_OCCUPANCY_STATUS_UNOCCUPY(0,"未占用"),
    /**
     * 占用
     */
    EM_VIRTUAL_COIL_OCCUPANCY_STATUS_OCCUPY(1,"占用");

    private final int value;
    private final String note;

    EM_VIRTUAL_COIL_OCCUPANCY_STATUS(int givenValue, String note) {
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
        for (EM_VIRTUAL_COIL_OCCUPANCY_STATUS enumType : EM_VIRTUAL_COIL_OCCUPANCY_STATUS.values()) {
            if (givenValue == enumType.getValue()) {
                return enumType.getNote();
            }
        }
        return null;
    }

    public static int getValueByNote(String givenNote) {
        for (EM_VIRTUAL_COIL_OCCUPANCY_STATUS enumType : EM_VIRTUAL_COIL_OCCUPANCY_STATUS.values()) {
            if (givenNote.equals(enumType.getNote())) {
                return enumType.getValue();
            }
        }
        return -1;
    }

    public static EM_VIRTUAL_COIL_OCCUPANCY_STATUS getEnum(int value) {
        for (EM_VIRTUAL_COIL_OCCUPANCY_STATUS e : EM_VIRTUAL_COIL_OCCUPANCY_STATUS.values()) {
            if (e.getValue() == value)
                return e;
        }
        return EM_VIRTUAL_COIL_OCCUPANCY_STATUS.EM_VIRTUAL_COIL_OCCUPANCY_STATUS_UNKNOWN;
    }
}
