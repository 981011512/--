package com.cf.forward.dh.lib.enumeration;

/**
 * @author 251823
 * @version 1.0
 * @description 进口类型
 * @date 2020/11/07
 */
public enum EM_ENTRY_TYPE {

	// 未知
	EM_ENTRY_TYPE_UNKNOWN(0, "未知"),
	// 左转
	EM_ENTRY_TYPE_TURN_LEFT(1, "左转"),
	// 直行
	EM_ENTRY_TYPE_STRAIGHT(2, "直行"),
	// 右转
	EM_ENTRY_TYPE_TRUN_RIGHT(3, "右转"),
	// 掉头
	EM_ENTRY_TYPE_TURN_ROUND(4, "掉头");

	private int value;
	private String note;

	private EM_ENTRY_TYPE(int givenValue, String note) {
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
		for (EM_ENTRY_TYPE enumType : EM_ENTRY_TYPE.values()) {
			if (givenValue == enumType.getValue()) {
				return enumType.getNote();
			}
		}
		return null;
	}

	public static int getValueByNote(String givenNote) {
		for (EM_ENTRY_TYPE enumType : EM_ENTRY_TYPE.values()) {
			if (givenNote.equals(enumType.getNote())) {
				return enumType.getValue();
			}
		}
		return -1;
	}

}
