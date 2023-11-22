package com.cf.forward.dh.lib.enumeration;

/**
 * @author 251823
 * @description 可选择特写模式
 * @date 2021/01/11
 */
public enum EM_SUPPORT_CLOSE_UP_TYPE {
	// 未知
	EM_SUPPORT_CLOSE_UP_TYPE_UNKNOWN(0, "未知"),

	// 跟踪模式
	EM_SUPPORT_CLOSE_UP_TYPE_TRACK_MODE(1, "跟踪模式"),

	// 固定模式
	EM_SUPPORT_CLOSE_UP_TYPE_FIXED_MODE(2, "固定模式"),

	// 指定区域模式
	EM_SUPPORT_CLOSE_UP_TYPE_DESIGNED_REGION_MODE(3, "指定区域模式");

	private int value;
	private String note;

	private EM_SUPPORT_CLOSE_UP_TYPE(int givenValue, String note) {
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
		for (EM_SUPPORT_CLOSE_UP_TYPE enumType : EM_SUPPORT_CLOSE_UP_TYPE.values()) {
			if (givenValue == enumType.getValue()) {
				return enumType.getNote();
			}
		}
		return null;
	}

	public static int getValueByNote(String givenNote) {
		for (EM_SUPPORT_CLOSE_UP_TYPE enumType : EM_SUPPORT_CLOSE_UP_TYPE.values()) {
			if (givenNote.equals(enumType.getNote())) {
				return enumType.getValue();
			}
		}
		return -1;
	}
}
