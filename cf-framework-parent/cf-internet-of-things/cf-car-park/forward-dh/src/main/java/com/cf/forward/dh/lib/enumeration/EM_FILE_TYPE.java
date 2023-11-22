package com.cf.forward.dh.lib.enumeration;

/**
 * @author 251823
 * @description 文件类型
 * @date 2021/02/22
 */
public enum EM_FILE_TYPE {
	// 未知
	EM_FILE_TYPE_UNKNOWN(0, "未知"),
	// jpg 图片
	EM_FILE_TYPE_JPG(1, "jpg图片"),
	// dav 文件
	EM_FILE_TYPE_DAV(2, "dav文件");

	private int value;
	private String note;

	private EM_FILE_TYPE(int givenValue, String note) {
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
		for (EM_FILE_TYPE enumType : EM_FILE_TYPE.values()) {
			if (givenValue == enumType.getValue()) {
				return enumType.getNote();
			}
		}
		return null;
	}

	public static int getValueByNote(String givenNote) {
		for (EM_FILE_TYPE enumType : EM_FILE_TYPE.values()) {
			if (givenNote.equals(enumType.getNote())) {
				return enumType.getValue();
			}
		}
		return -2;
	}
}
