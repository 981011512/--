package com.cf.forward.dh.lib.enumeration;

/**
 * @author 251823
 * @description 人体检测及人体识别支持的脸部特征（定制）
 * @date 2021/01/11
 */
public enum CFG_EM_FACE_TRAIT {
	// 未知
	CFG_EM_FACE_TRAIT_UNKNOWN(0, "未知"),

	// 性别
	CFG_EM_FACE_TRAIT_SEX(1, "性别"),

	// 年龄
	CFG_EM_FACE_TRAIT_AGE(2, "年龄"),

	// 眼镜
	CFG_EM_FACE_TRAIT_GLASSES(3, "眼镜"),

    // 胡子
	CFG_EM_FACE_TRAIT_BEARD(4, "胡子"),

    // 肤色
	CFG_EM_FACE_TRAIT_COMPLEXION(5, "肤色"),

    // 口罩
	CFG_EM_FACE_TRAIT_MASK(6, "口罩"),

    // 表情
	CFG_EM_FACE_TRAIT_EMOTION(7, "表情");

	private int value;
	private String note;

	private CFG_EM_FACE_TRAIT(int givenValue, String note) {
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
		for (CFG_EM_FACE_TRAIT enumType : CFG_EM_FACE_TRAIT.values()) {
			if (givenValue == enumType.getValue()) {
				return enumType.getNote();
			}
		}
		return null;
	}

	public static int getValueByNote(String givenNote) {
		for (CFG_EM_FACE_TRAIT enumType : CFG_EM_FACE_TRAIT.values()) {
			if (givenNote.equals(enumType.getNote())) {
				return enumType.getValue();
			}
		}
		return -1;
	}
}
