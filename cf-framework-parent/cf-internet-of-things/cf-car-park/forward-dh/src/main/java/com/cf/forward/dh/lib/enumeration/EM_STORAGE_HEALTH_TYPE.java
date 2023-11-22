package com.cf.forward.dh.lib.enumeration;

/**
 * @author 251823
 * @description 健康状态标识
 * @date 2021/01/21
 */
public enum EM_STORAGE_HEALTH_TYPE {
	// 未知
	EM_STORAGE_HEALTH_UNKNOWN(-1, "未知"),

	// 设备不支持健康检测功能
	EM_STORAGE_HEALTH_UNSUPPORT(0, "设备不支持健康检测功能"),

	// 支持健康检测功能且获取数据成功
	EM_STORAGE_HEALTH_SUPPORT_AND_SUCCESS(1, "支持健康检测功能且获取数据成功"),

	// 支持健康检测功能但获取数据失败
	EM_STORAGE_HEALTH_SUPPORT_AND_FAIL(2, "支持健康检测功能但获取数据失败");

	private int value;
	private String note;

	private EM_STORAGE_HEALTH_TYPE(int givenValue, String note) {
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
		for (EM_STORAGE_HEALTH_TYPE enumType : EM_STORAGE_HEALTH_TYPE.values()) {
			if (givenValue == enumType.getValue()) {
				return enumType.getNote();
			}
		}
		return null;
	}

	public static int getValueByNote(String givenNote) {
		for (EM_STORAGE_HEALTH_TYPE enumType : EM_STORAGE_HEALTH_TYPE.values()) {
			if (givenNote.equals(enumType.getNote())) {
				return enumType.getValue();
			}
		}
		return -2;
	}

}
