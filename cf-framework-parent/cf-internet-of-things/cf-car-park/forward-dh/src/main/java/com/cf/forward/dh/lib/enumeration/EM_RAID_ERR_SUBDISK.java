package com.cf.forward.dh.lib.enumeration;

public enum EM_RAID_ERR_SUBDISK {

    EM_RAID_ERR_SUBDISK_UNKNOWN(0, "未知"),                         // 未知
    EM_RAID_ERR_SUBDISK_OFFLINE(1, "离线"),                         // 离线
    EM_RAID_ERR_SUBDISK_FAULTY(2, "异常"),                          // 异常
    EM_RAID_ERR_SUBDISK_WRITEERR(3, "写错误");                      // 写错误


    private int value;
    private String note;

    private EM_RAID_ERR_SUBDISK(int givenValue, String note) {
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
        for (EM_RAID_ERR_SUBDISK enumType : EM_RAID_ERR_SUBDISK.values()) {
            if (givenValue == enumType.getValue()) {
                return enumType.getNote();
            }
        }
        return null;
    }

    public static int getValueByNote(String givenNote) {
        for (EM_RAID_ERR_SUBDISK enumType : EM_RAID_ERR_SUBDISK.values()) {
            if (givenNote.equals(enumType.getNote())) {
                return enumType.getValue();
            }
        }
        return -1;
    }
}
