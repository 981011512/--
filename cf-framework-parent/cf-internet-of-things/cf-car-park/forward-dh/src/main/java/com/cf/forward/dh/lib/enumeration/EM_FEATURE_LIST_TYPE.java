package com.cf.forward.dh.lib.enumeration;

/**
 * @author 251823
 * @description 睿厨着装检特征列表
 * @date 2021/01/11
 */
public enum EM_FEATURE_LIST_TYPE {
	// 未知
	EM_FEATURE_LIST_UNKNOWN(0, "未知"),

	// 是否戴口罩
	EM_FEATURE_LIST_HAS_MASK(1, "是否戴口罩"),

	// 是否戴厨师帽
	EM_FEATURE_LIST_HAS_CHEF_HAT(2, "是否戴厨师帽"),

	// 是否穿厨师服
	EM_FEATURE_LIST_HAS_CHEF_CLOTHES(3, "是否穿厨师服"),

	// 厨师服的颜色
	EM_FEATURE_LIST_CHEF_CLOTHES_COLOR(4, "厨师服的颜色");

	private int value;
	private String note;

	private EM_FEATURE_LIST_TYPE(int givenValue, String note) {
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
		for (EM_FEATURE_LIST_TYPE enumType : EM_FEATURE_LIST_TYPE.values()) {
			if (givenValue == enumType.getValue()) {
				return enumType.getNote();
			}
		}
		return null;
	}

	public static int getValueByNote(String givenNote) {
		for (EM_FEATURE_LIST_TYPE enumType : EM_FEATURE_LIST_TYPE.values()) {
			if (givenNote.equals(enumType.getNote())) {
				return enumType.getValue();
			}
		}
		return -1;
	}
}
