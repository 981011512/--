package com.cf.forward.dh.lib.enumeration;

/**
 * @author 251823
 * @description 车辆种类划分类型
 * @date 2021/01/11
 */
public enum EM_VEHICLE_TYPE_SPLIT {
	// 未知
	EM_VEHICLE_TYPE_SPLIT_UNKNOWN(0, "未知"),

	// 按功能划分
	EM_VEHICLE_TYPE_SPLIT_FUNC(1, "按功能划分"),

	// 按标准划分
	EM_VEHICLE_TYPE_SPLIT_STANDARD(2, "按标准划分");

	private int value;
	private String note;

	private EM_VEHICLE_TYPE_SPLIT(int givenValue, String note) {
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
		for (EM_VEHICLE_TYPE_SPLIT enumType : EM_VEHICLE_TYPE_SPLIT.values()) {
			if (givenValue == enumType.getValue()) {
				return enumType.getNote();
			}
		}
		return null;
	}

	public static int getValueByNote(String givenNote) {
		for (EM_VEHICLE_TYPE_SPLIT enumType : EM_VEHICLE_TYPE_SPLIT.values()) {
			if (givenNote.equals(enumType.getNote())) {
				return enumType.getValue();
			}
		}
		return -1;
	}

}
