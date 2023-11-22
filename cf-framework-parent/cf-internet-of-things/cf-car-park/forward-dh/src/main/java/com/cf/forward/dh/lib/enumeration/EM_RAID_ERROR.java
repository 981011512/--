package com.cf.forward.dh.lib.enumeration;

public enum EM_RAID_ERROR {

    EM_RAID_ERROR_UNKNOW(0, "未知"),
    EM_RAID_ERROR_FAILED(1, "RAID错误"),                      // RAID错误
    EM_RAID_ERROR_DEGRADED(2, "RAID降级");                     // RAID降级

    private int value;
    private String note;

    private EM_RAID_ERROR(int givenValue, String note) {
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
        for (EM_RAID_ERROR enumType : EM_RAID_ERROR.values()) {
            if (givenValue == enumType.getValue()) {
                return enumType.getNote();
            }
        }
        return null;
    }

    public static int getValueByNote(String givenNote) {
        for (EM_RAID_ERROR enumType : EM_RAID_ERROR.values()) {
            if (givenNote.equals(enumType.getNote())) {
                return enumType.getValue();
            }
        }
        return -1;
    }
}
