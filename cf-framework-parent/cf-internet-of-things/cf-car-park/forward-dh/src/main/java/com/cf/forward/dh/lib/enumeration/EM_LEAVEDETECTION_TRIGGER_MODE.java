package com.cf.forward.dh.lib.enumeration;

/**
 * @author 251823
 * @description 离岗的触发模式
 * @date 2021/03/15
 */
public enum EM_LEAVEDETECTION_TRIGGER_MODE {
	// 未知
	EM_LEAVEDETECTION_TRIGGER_UNKNOEN(0, "未知"),
	// 无人
	EM_LEAVEDETECTION_TRIGGER_NOPERSON(1, "无人"),
	// 离开
	EM_LEAVEDETECTION_TRIGGER_LEAVE(2, "离开"),
	// 静止(睡岗)
	EM_LEAVEDETECTION_TRIGGER_STATIC(3, "静止(睡岗)"),
	// 不在允许值岗人数范围内(值岗人数异常)
	EM_LEAVEDETECTION_TRIGGER_OUTPERSONLIMIT(4, "不在允许值岗人数范围内(值岗人数异常)");

	private int value;
	private String note;

	private EM_LEAVEDETECTION_TRIGGER_MODE(int givenValue, String note) {
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
		for (EM_LEAVEDETECTION_TRIGGER_MODE enumType : EM_LEAVEDETECTION_TRIGGER_MODE.values()) {
			if (givenValue == enumType.getValue()) {
				return enumType.getNote();
			}
		}
		return null;
	}

	public static int getValueByNote(String givenNote) {
		for (EM_LEAVEDETECTION_TRIGGER_MODE enumType : EM_LEAVEDETECTION_TRIGGER_MODE.values()) {
			if (givenNote.equals(enumType.getNote())) {
				return enumType.getValue();
			}
		}
		return -1;
	}

}
