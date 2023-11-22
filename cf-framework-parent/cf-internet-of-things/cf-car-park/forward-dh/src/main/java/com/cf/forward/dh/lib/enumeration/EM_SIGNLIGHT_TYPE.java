package com.cf.forward.dh.lib.enumeration;

/**
 * @author 251823
 * @description 灯光类型
 * @date 2020/11/19
 */
public enum EM_SIGNLIGHT_TYPE {
	// 未知
	EM_SIGNLIGHT_TYPE_UNKNOWN(0, "未知"),

	// 自动，按照sensor自动切换
	EM_SIGNLIGHT_TYPE_AUTO(1, "自动，按照sensor自动切换"),

	// 定时模式
	EM_SIGNLIGHT_TYPE_TIMING(2, "定时模式"),

	// 常灭
	EM_SIGNLIGHT_TYPE_OFF(3, "常灭"),

	// 常亮模式
	EM_SIGNLIGHT_TYPE_ON(4, "常亮模式");

	private int value;
	private String note;

	private EM_SIGNLIGHT_TYPE(int givenValue, String note) {
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
		for (EM_SIGNLIGHT_TYPE enumType : EM_SIGNLIGHT_TYPE.values()) {
			if (givenValue == enumType.getValue()) {
				return enumType.getNote();
			}
		}
		return null;
	}

	public static int getValueByNote(String givenNote) {
		for (EM_SIGNLIGHT_TYPE enumType : EM_SIGNLIGHT_TYPE.values()) {
			if (givenNote.equals(enumType.getNote())) {
				return enumType.getValue();
			}
		}
		return -1;
	}
}
