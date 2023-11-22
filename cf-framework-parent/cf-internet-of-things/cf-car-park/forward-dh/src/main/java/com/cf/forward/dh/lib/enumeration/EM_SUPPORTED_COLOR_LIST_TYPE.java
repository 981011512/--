package com.cf.forward.dh.lib.enumeration;

/**
 * @author 251823
 * @description 检测符合要求的厨师服颜色不报警(无此字段表示不检测厨师服颜色)
 * @date 2021/01/11
 */
public enum EM_SUPPORTED_COLOR_LIST_TYPE {

	// 未知
	EM_SUPPORTED_COLOR_LIST_TYPE_UNKNOWN(0, "未知"),

	// 黑色
	EM_SUPPORTED_COLOR_LIST_TYPE_BLACK(1, "黑色"),

	// 白色
	EM_SUPPORTED_COLOR_LIST_TYPE_WHITE(2, "白色"),

	// 红色
	EM_SUPPORTED_COLOR_LIST_TYPE_RED(3, "红色");

	private int value;
	private String note;

	private EM_SUPPORTED_COLOR_LIST_TYPE(int givenValue, String note) {
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
		for (EM_SUPPORTED_COLOR_LIST_TYPE enumType : EM_SUPPORTED_COLOR_LIST_TYPE.values()) {
			if (givenValue == enumType.getValue()) {
				return enumType.getNote();
			}
		}
		return null;
	}

	public static int getValueByNote(String givenNote) {
		for (EM_SUPPORTED_COLOR_LIST_TYPE enumType : EM_SUPPORTED_COLOR_LIST_TYPE.values()) {
			if (givenNote.equals(enumType.getNote())) {
				return enumType.getValue();
			}
		}
		return -1;
	}

}
