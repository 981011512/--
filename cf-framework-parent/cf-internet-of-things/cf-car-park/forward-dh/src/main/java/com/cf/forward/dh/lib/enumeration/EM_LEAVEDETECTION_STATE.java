package com.cf.forward.dh.lib.enumeration;
/**
 * @author 251823
 * @description 检测状态
 * @date 2021/03/15
 */
public enum EM_LEAVEDETECTION_STATE {
	// 未知
	EM_LEAVEDETECTION_STATE_UNKNOWN(0, "未知"),
	// 离岗
	EM_LEAVEDETECTION_STATE_LEAVE(1, "离岗"),
	// 在岗
	EM_LEAVEDETECTION_STATE_ON_THE_JOB(2, "在岗");


	private int value;
	private String note;

	private EM_LEAVEDETECTION_STATE(int givenValue, String note) {
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
		for (EM_LEAVEDETECTION_STATE enumType : EM_LEAVEDETECTION_STATE.values()) {
			if (givenValue == enumType.getValue()) {
				return enumType.getNote();
			}
		}
		return null;
	}

	public static int getValueByNote(String givenNote) {
		for (EM_LEAVEDETECTION_STATE enumType : EM_LEAVEDETECTION_STATE.values()) {
			if (givenNote.equals(enumType.getNote())) {
				return enumType.getValue();
			}
		}
		return -1;
	}

}
