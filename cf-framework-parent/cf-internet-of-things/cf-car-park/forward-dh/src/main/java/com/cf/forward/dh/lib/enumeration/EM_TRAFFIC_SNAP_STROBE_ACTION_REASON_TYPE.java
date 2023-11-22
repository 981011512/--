package com.cf.forward.dh.lib.enumeration;

/**
 * @author 251823
 * @description 智能交通道闸上次开关闸原因
 * @date 2020/12/14
 */
public enum EM_TRAFFIC_SNAP_STROBE_ACTION_REASON_TYPE {
	// 未知
	EM_TRAFFIC_SNAP_STROBE_ACTION_REASON_TYPE_UNKNOWN(0, "未知"),
	// 遥感器开闸
	EM_TRAFFIC_SNAP_STROBE_ACTION_REASON_TYPE_CONTROL_SWITCH_ON(1, "遥感器开闸"),
	// 遥感器关闸
	EM_TRAFFIC_SNAP_STROBE_ACTION_REASON_TYPE_CONTROL_SWITCH_OFF(2, "遥感器关闸"),
	// 地感LOOP1自动触发开闸
	EM_TRAFFIC_SNAP_STROBE_ACTION_REASON_TYPE_LOOP_LOOP1_OPEN(3, "地感LOOP1自动触发开闸"),
	// 地感LOOP1自动触发关闸
	EM_TRAFFIC_SNAP_STROBE_ACTION_REASON_TYPE_LOOP_LOOP1_CLOSE(4, "地感LOOP1自动触发关闸"),
	// 地感LOOP2自动触发开闸
	EM_TRAFFIC_SNAP_STROBE_ACTION_REASON_TYPE_LOOP_LOOP2_OPEN(5, "地感LOOP2自动触发开闸"),
	// 外部开关开闸
	EM_TRAFFIC_SNAP_STROBE_ACTION_REASON_TYPE_EXTERNAL_SWITCH_OPEN(6, "外部开关开闸"),
	// 外部开关关闸
	EM_TRAFFIC_SNAP_STROBE_ACTION_REASON_TYPE_EXTERNAL_SWITCH_CLOSE(7, "外部开关关闸"),
	// 内部开关开闸
	EM_TRAFFIC_SNAP_STROBE_ACTION_REASON_TYPE_INTERNAL_SWITCH_OPEN(8, "内部开关开闸"),
	// 内部开关关闸
	EM_TRAFFIC_SNAP_STROBE_ACTION_REASON_TYPE_INTERNAL_SWITCH_CLOSE(9, "内部开关关闸"),
	// 自动延时关闸
	EM_TRAFFIC_SNAP_STROBE_ACTION_REASON_TYPE_AUTOMATIC_DELAY_CLOSE(10, "自动延时关闸"),
	// 遇阻反弹开闸
	EM_TRAFFIC_SNAP_STROBE_ACTION_REASON_TYPE_OBSTACLE_REBOUND_TO_OPEN(11, "遇阻反弹开闸"),
	// 红外防砸开闸
	EM_TRAFFIC_SNAP_STROBE_ACTION_REASON_TYPE_INFRARED_ANTI_SMASHING_OPEN(12, "红外防砸开闸"),
	// 红外防砸关闸
	EM_TRAFFIC_SNAP_STROBE_ACTION_REASON_TYPE_INFRARED_ANTI_SMASHING_CLOSE(13, "红外防砸关闸"),
	// 压力波开闸
	EM_TRAFFIC_SNAP_STROBE_ACTION_REASON_TYPE_PRESSURE_WAVE_OPEN(14, "压力波开闸"),
	// 压力波关闸
	EM_TRAFFIC_SNAP_STROBE_ACTION_REASON_TYPE_PRESSURE_WAVE_CLOSE(15, "压力波关闸");

	private int value;
	private String note;

	private EM_TRAFFIC_SNAP_STROBE_ACTION_REASON_TYPE(int givenValue, String note) {
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
		for (EM_TRAFFIC_SNAP_STROBE_ACTION_REASON_TYPE enumType : EM_TRAFFIC_SNAP_STROBE_ACTION_REASON_TYPE.values()) {
			if (givenValue == enumType.getValue()) {
				return enumType.getNote();
			}
		}
		return null;
	}

	public static int getValueByNote(String givenNote) {
		for (EM_TRAFFIC_SNAP_STROBE_ACTION_REASON_TYPE enumType : EM_TRAFFIC_SNAP_STROBE_ACTION_REASON_TYPE.values()) {
			if (givenNote.equals(enumType.getNote())) {
				return enumType.getValue();
			}
		}
		return -1;
	}
}
