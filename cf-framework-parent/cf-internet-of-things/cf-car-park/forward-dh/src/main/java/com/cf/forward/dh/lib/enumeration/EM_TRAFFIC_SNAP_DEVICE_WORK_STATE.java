package com.cf.forward.dh.lib.enumeration;

/**
 * @author 251823
 * @description 智能交通外接设备工作状态
 * @date 2020/12/14
 */
public enum EM_TRAFFIC_SNAP_DEVICE_WORK_STATE {
	// 未知
	EM_TRAFFIC_SNAP_DEVICE_WORK_STATE_UNKNOWN(-1, "未知"),
	// 故障
	EM_TRAFFIC_SNAP_DEVICE_WORK_STATE_FAULT(0, "故障"),
	// 正常
	EM_TRAFFIC_SNAP_DEVICE_WORK_STATE_NORMAL(1, "正常"),
	// 关闭
	EM_TRAFFIC_SNAP_DEVICE_WORK_STATE_CLOSE(2, "关闭");

	private int value;
	private String note;

	private EM_TRAFFIC_SNAP_DEVICE_WORK_STATE(int givenValue, String note) {
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
		for (EM_TRAFFIC_SNAP_DEVICE_WORK_STATE enumType : EM_TRAFFIC_SNAP_DEVICE_WORK_STATE.values()) {
			if (givenValue == enumType.getValue()) {
				return enumType.getNote();
			}
		}
		return null;
	}

	public static int getValueByNote(String givenNote) {
		for (EM_TRAFFIC_SNAP_DEVICE_WORK_STATE enumType : EM_TRAFFIC_SNAP_DEVICE_WORK_STATE.values()) {
			if (givenNote.equals(enumType.getNote())) {
				return enumType.getValue();
			}
		}
		return -2;
	}
}
