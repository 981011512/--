package com.cf.forward.dh.lib.enumeration;

/**
 * @author 251823
 * @description 智能交通栏杆状态
 * @date 2020/12/14
 */
public enum EM_TRAFFIC_SNAP_STROBE_RAIL_STATE_TYPE {
	// 未知
	TRAFFIC_SNAP_STROBE_RAIL_STATE_TYPE_UNKNOWN(-1, "未知"),
	// 正常
	TRAFFIC_SNAP_STROBE_RAIL_STATE_TYPE_NORMAL(0, "正常"),
	// 脱落
	TRAFFIC_SNAP_STROBE_RAIL_STATE_TYPE_FALL_OFF(1, "脱落"),
	// 不支持
	EM_TRAFFIC_SNAP_STROBE_IN_STATE_TYPE_NO_SUPPORT(255, "不支持");

	private int value;
	private String note;

	private EM_TRAFFIC_SNAP_STROBE_RAIL_STATE_TYPE(int givenValue, String note) {
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
		for (EM_TRAFFIC_SNAP_STROBE_RAIL_STATE_TYPE enumType : EM_TRAFFIC_SNAP_STROBE_RAIL_STATE_TYPE.values()) {
			if (givenValue == enumType.getValue()) {
				return enumType.getNote();
			}
		}
		return null;
	}

	public static int getValueByNote(String givenNote) {
		for (EM_TRAFFIC_SNAP_STROBE_RAIL_STATE_TYPE enumType : EM_TRAFFIC_SNAP_STROBE_RAIL_STATE_TYPE.values()) {
			if (givenNote.equals(enumType.getNote())) {
				return enumType.getValue();
			}
		}
		return -2;
	}

}
