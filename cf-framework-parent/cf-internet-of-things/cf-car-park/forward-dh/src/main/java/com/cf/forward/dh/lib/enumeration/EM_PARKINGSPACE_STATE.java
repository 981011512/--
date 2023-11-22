package com.cf.forward.dh.lib.enumeration;

/**
 * 车位状态
 *
 * @author 47040
 * @since Created in 2020/11/18 13:36
 */
public enum EM_PARKINGSPACE_STATE {
    /**
     * 未知
     */
    EM_PARKINGSPACE_STATE_UNKNOWN(-1, "未知"),
    /**
     * 车位无车
     */
    EM_PARKINGSPACE_STATE_NOPARKING(0, "车位无车"),
    /**
     * 车位有车
     */
    EM_PARKINGSPACE_STATE_PARKING(1, "车位有车");

    private final int value;
    private final String note;

    EM_PARKINGSPACE_STATE(int givenValue, String note) {
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
        for (EM_PARKINGSPACE_STATE enumType : EM_PARKINGSPACE_STATE.values()) {
            if (givenValue == enumType.getValue()) {
                return enumType.getNote();
            }
        }
        return null;
    }

    public static int getValueByNote(String givenNote) {
        for (EM_PARKINGSPACE_STATE enumType : EM_PARKINGSPACE_STATE.values()) {
            if (givenNote.equals(enumType.getNote())) {
                return enumType.getValue();
            }
        }
        return -1;
    }

    public static EM_PARKINGSPACE_STATE getEnum(int value) {
        for (EM_PARKINGSPACE_STATE e : EM_PARKINGSPACE_STATE.values()) {
            if (e.getValue() == value)
                return e;
        }
        return EM_PARKINGSPACE_STATE.EM_PARKINGSPACE_STATE_UNKNOWN;
    }
}
