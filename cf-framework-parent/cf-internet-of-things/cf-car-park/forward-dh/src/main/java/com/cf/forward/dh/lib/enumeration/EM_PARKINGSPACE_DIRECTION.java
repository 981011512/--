package com.cf.forward.dh.lib.enumeration;

/**
 * 停车方向
 *
 * @author 47040
 * @since Created in 2020/11/18 14:48
 */
public enum EM_PARKINGSPACE_DIRECTION {
    /**
     * 未知
     */
    EM_PARKINGSPACE_DIRECTION_UNKNOWN(0, "未知"),
    /**
     * 逆向
     */
    EM_PARKINGSPACE_DIRECTION_REVERSE(1, "逆向"),
    /**
     * 正向
     */
    EM_PARKINGSPACE_DIRECTION_FORWARD(2, "正向");

    private int value;
    private String note;

    EM_PARKINGSPACE_DIRECTION(int givenValue, String note) {
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
        for (EM_PARKINGSPACE_DIRECTION enumType : EM_PARKINGSPACE_DIRECTION.values()) {
            if (givenValue == enumType.getValue()) {
                return enumType.getNote();
            }
        }
        return null;
    }

    public static int getValueByNote(String givenNote) {
        for (EM_PARKINGSPACE_DIRECTION enumType : EM_PARKINGSPACE_DIRECTION.values()) {
            if (givenNote.equals(enumType.getNote())) {
                return enumType.getValue();
            }
        }
        return -1;
    }

    public static EM_PARKINGSPACE_DIRECTION getEnum(int value) {
        for (EM_PARKINGSPACE_DIRECTION e : EM_PARKINGSPACE_DIRECTION.values()) {
            if (e.getValue() == value)
                return e;
        }
        return EM_PARKINGSPACE_DIRECTION.EM_PARKINGSPACE_DIRECTION_UNKNOWN;
    }
}
