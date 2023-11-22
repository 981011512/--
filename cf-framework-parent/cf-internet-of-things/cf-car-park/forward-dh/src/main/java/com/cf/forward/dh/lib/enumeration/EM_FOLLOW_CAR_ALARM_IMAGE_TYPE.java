package com.cf.forward.dh.lib.enumeration;

/**
 * @author 251823
 * @description 跟随车辆报警图片类型
 * @date 2021/01/13
 */
public enum EM_FOLLOW_CAR_ALARM_IMAGE_TYPE {
	// 未知
	EM_FOLLOW_CAR_ALARM_IMAGE_TYPE_UNKNOWN(-1, "未知"),

	// 全景图
	EM_FOLLOW_CAR_ALARM_IMAGE_TYPE_PANORAMA(0, "全景图"),

	// 小图
	EM_FOLLOW_CAR_ALARM_IMAGE_TYPE_SMALL_PICTURE(1, "小图");

	private int value;
	private String note;

	private EM_FOLLOW_CAR_ALARM_IMAGE_TYPE(int givenValue, String note) {
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
		for (EM_FOLLOW_CAR_ALARM_IMAGE_TYPE enumType : EM_FOLLOW_CAR_ALARM_IMAGE_TYPE.values()) {
			if (givenValue == enumType.getValue()) {
				return enumType.getNote();
			}
		}
		return null;
	}

	public static int getValueByNote(String givenNote) {
		for (EM_FOLLOW_CAR_ALARM_IMAGE_TYPE enumType : EM_FOLLOW_CAR_ALARM_IMAGE_TYPE.values()) {
			if (givenNote.equals(enumType.getNote())) {
				return enumType.getValue();
			}
		}
		return -2;
	}
}
