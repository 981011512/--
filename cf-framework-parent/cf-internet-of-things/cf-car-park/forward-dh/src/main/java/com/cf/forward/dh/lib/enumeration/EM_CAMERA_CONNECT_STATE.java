package com.cf.forward.dh.lib.enumeration;

/**
 * @author 251823
 * @version 1.0
 * @description 相机连接状态
 * @date 2020/11/09
 */
public enum EM_CAMERA_CONNECT_STATE {
	// 未知
	EM_CAMERA_CONNECT_STATE_UNKNOWN(-1, "未知"),
	// 北向南
	EM_CAMERA_CONNECT_STATE_UNCONNECT(0, "未连接"),
	// 东北向西南
	EM_CAMERA_CONNECT_STATE_CONNECTED(1, "已连接");

	private int value;
	private String note;

	private EM_CAMERA_CONNECT_STATE(int givenValue, String note) {
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
		for (EM_CAMERA_CONNECT_STATE enumType : EM_CAMERA_CONNECT_STATE.values()) {
			if (givenValue == enumType.getValue()) {
				return enumType.getNote();
			}
		}
		return null;
	}

	public static int getValueByNote(String givenNote) {
		for (EM_CAMERA_CONNECT_STATE enumType : EM_CAMERA_CONNECT_STATE.values()) {
			if (givenNote.equals(enumType.getNote())) {
				return enumType.getValue();
			}
		}
		return -2;
	}

}
