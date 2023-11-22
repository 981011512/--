package com.cf.forward.dh.lib.enumeration;

/**
 * @author 251823
 * @description 智能交通道闸运行状态
 * @date 2020/12/14
 */
public enum EM_TRAFFIC_SNAP_STROBE_RUN_STATE {
	// 未知
	EM_TRAFFIC_SNAP_STROBE_RUN_STATE_UNKNOWN(-1, "未知"),
	// 关
	EM_TRAFFIC_SNAP_STROBE_RUN_STATE_CLOSE(0, "关"),
	// 开
	EM_TRAFFIC_SNAP_STROBE_RUN_STATE_OPEN(1, "开"),
	// 正在开
	EM_TRAFFIC_SNAP_STROBE_RUN_STATE_OPENING(2, "正在开"),
	// 正在关
	EM_TRAFFIC_SNAP_STROBE_RUN_STATE_CLOSING(3, "正在关"),
	// 停
	EM_TRAFFIC_SNAP_STROBE_RUN_STATE_STOP(4, "停");

	private int value;
	private String note;

	private EM_TRAFFIC_SNAP_STROBE_RUN_STATE(int givenValue, String note) {
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
		for (EM_TRAFFIC_SNAP_STROBE_RUN_STATE enumType : EM_TRAFFIC_SNAP_STROBE_RUN_STATE.values()) {
			if (givenValue == enumType.getValue()) {
				return enumType.getNote();
			}
		}
		return null;
	}

	public static int getValueByNote(String givenNote) {
		for (EM_TRAFFIC_SNAP_STROBE_RUN_STATE enumType : EM_TRAFFIC_SNAP_STROBE_RUN_STATE.values()) {
			if (givenNote.equals(enumType.getNote())) {
				return enumType.getValue();
			}
		}
		return -2;
	}
}
