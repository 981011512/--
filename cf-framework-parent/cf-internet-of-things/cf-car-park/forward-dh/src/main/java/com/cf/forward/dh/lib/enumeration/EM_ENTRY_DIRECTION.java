package com.cf.forward.dh.lib.enumeration;

/**
 * @author 251823
 * @version 1.0
 * @description 进口方向
 * @date 2020/11/07
 */
public enum EM_ENTRY_DIRECTION {

	// 未知
	EM_ENTRY_UNKNOWN(0, "未知"),
	// 北向南
	EM_ENTRY_NORTH_TO_SOUTH(1, "北向南"),
	// 东北向西南
	EM_ENTRY_EASTNORTH_TO_WESTSOUTH(2, "东北向西南"),
	// 东向西
	EM_ENTRY_EAST_TO_WEST(3, "东向西"),
	// 东南向西北
	EM_ENTRY_EASTSOUTH_TO_WESTNORTH(4, "东南向西北"),
	// 南向北
	EM_ENTRY_SOUTH_TO_NORTH(5, "南向北"),
	// 西南向东北
	EM_ENTRY_WESTSOUTH_TO_EASTSOUTH(6, "西南向东北"),
	// 西向东
	EM_ENTRY_WEST_TO_EAST(7, "西向东"),
	// 西北向东南
	EM_ENTRY_WESTNORTH_TO_EASTSOUTH(8, "西北向东南");

	private int value;
	private String note;

	private EM_ENTRY_DIRECTION(int givenValue, String note) {
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
		for (EM_ENTRY_DIRECTION enumType : EM_ENTRY_DIRECTION.values()) {
			if (givenValue == enumType.getValue()) {
				return enumType.getNote();
			}
		}
		return null;
	}

	public static int getValueByNote(String givenNote) {
		for (EM_ENTRY_DIRECTION enumType : EM_ENTRY_DIRECTION.values()) {
			if (givenNote.equals(enumType.getNote())) {
				return enumType.getValue();
			}
		}
		return -1;
	}
}
