package com.cf.forward.dh.lib.enumeration;

/**
 * @author 251823
 * @description 智能交通雷达检测线圈匹配状态
 * @date 2020/12/14
 */
public enum EM_TRAFFIC_SNAP_RADAR_COIL_MATCH_STATE {
	// 未知
	EM_TRAFFIC_SNAP_RADAR_COIL_MATCH_STATE_UNKNOWN(-1, "未知"),
	// 不匹配
	EM_TRAFFIC_SNAP_RADAR_COIL_MATCH_STATE_MISMATCH(0, "不匹配"),
	// 匹配
	EM_TRAFFIC_SNAP_RADAR_COIL_MATCH_STATE_MATCH(1, "匹配"),
	// 不检测
	EM_TRAFFIC_SNAP_RADAR_COIL_MATCH_STATE_NO_DETECT(2, "不检测");

	private int value;
	private String note;

	private EM_TRAFFIC_SNAP_RADAR_COIL_MATCH_STATE(int givenValue, String note) {
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
		for (EM_TRAFFIC_SNAP_RADAR_COIL_MATCH_STATE enumType : EM_TRAFFIC_SNAP_RADAR_COIL_MATCH_STATE.values()) {
			if (givenValue == enumType.getValue()) {
				return enumType.getNote();
			}
		}
		return null;
	}

	public static int getValueByNote(String givenNote) {
		for (EM_TRAFFIC_SNAP_RADAR_COIL_MATCH_STATE enumType : EM_TRAFFIC_SNAP_RADAR_COIL_MATCH_STATE.values()) {
			if (givenNote.equals(enumType.getNote())) {
				return enumType.getValue();
			}
		}
		return -2;
	}
}
