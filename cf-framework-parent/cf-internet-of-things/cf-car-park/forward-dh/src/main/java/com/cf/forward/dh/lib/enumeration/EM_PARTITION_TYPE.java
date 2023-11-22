package com.cf.forward.dh.lib.enumeration;

/**
 * @author 251823
 * @description 分区类型
 * @date 2021/01/21
 */
public enum EM_PARTITION_TYPE {
	// 未知
	EM_PARTITION_UNKNOWN(0, "未知"),

	// 读写
	EM_PARTITION_READ_WIRTE(1, "读写"),

	// 只读
	EM_PARTITION_READ_ONLY(2, "只读"),

	// 一般的
	EM_PARTITION_READ_GENERIC(3, "一般的");

	private int value;
	private String note;

	private EM_PARTITION_TYPE(int givenValue, String note) {
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
		for (EM_PARTITION_TYPE enumType : EM_PARTITION_TYPE.values()) {
			if (givenValue == enumType.getValue()) {
				return enumType.getNote();
			}
		}
		return null;
	}

	public static int getValueByNote(String givenNote) {
		for (EM_PARTITION_TYPE enumType : EM_PARTITION_TYPE.values()) {
			if (givenNote.equals(enumType.getNote())) {
				return enumType.getValue();
			}
		}
		return -1;
	}

}
