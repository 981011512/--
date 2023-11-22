package com.cf.forward.dh.lib.enumeration;

/**
 * @author 251823
 * @description SD卡加密功能标识
 * @date 2021/01/21
 */
public enum EM_SD_ENCRYPT_FLAG {
	// 未知
	EM_SD_ENCRYPT_UNKNOWN(-1, "未知"),

	// 设备不支持SD卡加密功能
	EM_SD_ENCRYPT_UNSUPPORT(0, "设备不支持SD卡加密功能"),

	// 支持SD卡加密功能且获取数据成功
	EM_SD_ENCRYPT_SUPPORT_AND_GETDATA_SUCCESS(1, "支持SD卡加密功能且获取数据成功"),

	// 支持SD卡加密功能但获取数据失败
	EM_SD_ENCRYPT_SUPPORT_AND_GETDATA_FAIL(2, "支持SD卡加密功能但获取数据失败");

	private int value;
	private String note;

	private EM_SD_ENCRYPT_FLAG(int givenValue, String note) {
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
		for (EM_SD_ENCRYPT_FLAG enumType : EM_SD_ENCRYPT_FLAG.values()) {
			if (givenValue == enumType.getValue()) {
				return enumType.getNote();
			}
		}
		return null;
	}

	public static int getValueByNote(String givenNote) {
		for (EM_SD_ENCRYPT_FLAG enumType : EM_SD_ENCRYPT_FLAG.values()) {
			if (givenNote.equals(enumType.getNote())) {
				return enumType.getValue();
			}
		}
		return -2;
	}

}
