package com.cf.forward.dh.lib.enumeration;

/**
 * @author 251823
 * @description 存储设备状态
 * @date 2021/01/21
 */
public enum EM_STORAGE_DEVICE_STATUS {
	// 未知
	EM_STORAGE_DEVICE_UNKNOWN(0, "未知"),

	// 获取设备失败
	EM_STORAGE_DEVICE_ERROR(1, "获取设备失败"),

	// 正在读取设备
	EM_STORAGE_DEVICE_INITIALIZING(2, "正在读取设备"),

	// 获取设备成功
	EM_STORAGE_DEVICE_SUCCESS(3, "获取设备成功");

	private int value;
	private String note;

	private EM_STORAGE_DEVICE_STATUS(int givenValue, String note) {
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
		for (EM_STORAGE_DEVICE_STATUS enumType : EM_STORAGE_DEVICE_STATUS.values()) {
			if (givenValue == enumType.getValue()) {
				return enumType.getNote();
			}
		}
		return null;
	}

	public static int getValueByNote(String givenNote) {
		for (EM_STORAGE_DEVICE_STATUS enumType : EM_STORAGE_DEVICE_STATUS.values()) {
			if (givenNote.equals(enumType.getNote())) {
				return enumType.getValue();
			}
		}
		return -1;
	}

}
