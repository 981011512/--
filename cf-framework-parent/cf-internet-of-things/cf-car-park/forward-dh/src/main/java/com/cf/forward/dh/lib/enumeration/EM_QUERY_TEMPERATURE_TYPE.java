package com.cf.forward.dh.lib.enumeration;

/**
 * @author 251823
 * @description 温度类型
 * @date 2021/02/22
 */
public enum EM_QUERY_TEMPERATURE_TYPE {
	// 未知
	EM_QUERY_TEMPERATURE_TYPE_UNKNOWN(-1, "未知"),
	// 全部
	EM_QUERY_TEMPERATURE_TYPE_ALL(0, "全部"),
	// 低温
	EM_QUERY_TEMPERATURE_TYPE_LOW(1, "低温"),
	// 正常
	EM_QUERY_TEMPERATURE_TYPE_NORMAL(2, "正常"),
	// 高温
	EM_QUERY_TEMPERATURE_TYPE_HIGH(3, "高温");

	private int value;
	private String note;

	private EM_QUERY_TEMPERATURE_TYPE(int givenValue, String note) {
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
		for (EM_QUERY_TEMPERATURE_TYPE enumType : EM_QUERY_TEMPERATURE_TYPE.values()) {
			if (givenValue == enumType.getValue()) {
				return enumType.getNote();
			}
		}
		return null;
	}

	public static int getValueByNote(String givenNote) {
		for (EM_QUERY_TEMPERATURE_TYPE enumType : EM_QUERY_TEMPERATURE_TYPE.values()) {
			if (givenNote.equals(enumType.getNote())) {
				return enumType.getValue();
			}
		}
		return -2;
	}
}
