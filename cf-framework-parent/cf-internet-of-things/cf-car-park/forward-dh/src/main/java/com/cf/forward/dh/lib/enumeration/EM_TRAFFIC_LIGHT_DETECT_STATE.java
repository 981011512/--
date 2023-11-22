package com.cf.forward.dh.lib.enumeration;

/**
 * @author 251823
 * @version 1.0
 * @description 红绿灯状态
 * @date 2020/11/07
 */
public enum EM_TRAFFIC_LIGHT_DETECT_STATE {
	// 未知
	EM_TRAFFIC_DETECT_STATE_UNKNOWN(-1, "未知"),
	// 红灯
	EM_TRAFFIC_DETECT_STATE_RED(0, "红灯"),
	// 绿灯
	EM_TRAFFIC_DETECT_STATE_GREEN(1, "绿灯");

	private int value;
	private String note;

	private EM_TRAFFIC_LIGHT_DETECT_STATE(int givenValue, String note) {
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
		for (EM_TRAFFIC_LIGHT_DETECT_STATE enumType : EM_TRAFFIC_LIGHT_DETECT_STATE.values()) {
			if (givenValue == enumType.getValue()) {
				return enumType.getNote();
			}
		}
		return null;
	}

	public static int getValueByNote(String givenNote) {
		for (EM_TRAFFIC_LIGHT_DETECT_STATE enumType : EM_TRAFFIC_LIGHT_DETECT_STATE.values()) {
			if (givenNote.equals(enumType.getNote())) {
				return enumType.getValue();
			}
		}
		return -2;
	}
}
