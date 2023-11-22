package com.cf.forward.dh.lib.enumeration;

/**
 * @author 251823
 * @description 隐私保护的物体类型
 * @date 2021/01/11
 */
public enum EM_PRIVACY_MASK_TYPE {
	// 未知类型
	EM_PRIVACY_MASK_UNKNOWN(0, "未知类型"),

	// 人脸
	EM_PRIVACY_MASK_HUMAN_FACE(1, "人脸"),

	// 人体
	EM_PRIVACY_MASK_HUMAN(2, "人体");

	private int value;
	private String note;

	private EM_PRIVACY_MASK_TYPE(int givenValue, String note) {
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
		for (EM_PRIVACY_MASK_TYPE enumType : EM_PRIVACY_MASK_TYPE.values()) {
			if (givenValue == enumType.getValue()) {
				return enumType.getNote();
			}
		}
		return null;
	}

	public static int getValueByNote(String givenNote) {
		for (EM_PRIVACY_MASK_TYPE enumType : EM_PRIVACY_MASK_TYPE.values()) {
			if (givenNote.equals(enumType.getNote())) {
				return enumType.getValue();
			}
		}
		return -1;
	}

}
