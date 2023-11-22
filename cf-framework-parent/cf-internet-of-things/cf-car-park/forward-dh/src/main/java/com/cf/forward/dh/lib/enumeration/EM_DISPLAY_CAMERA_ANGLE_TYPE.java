package com.cf.forward.dh.lib.enumeration;

/**
 * @author 251823
 * @description 摄像头安装角度显示方式
 * @date 2021/01/11
 */
public enum EM_DISPLAY_CAMERA_ANGLE_TYPE {
	
	// 未知的显示方式
	EM_DISPLAY_CAMERA_ANGLE_UNKNOWN(0, "未知的显示方式"),

	// 按角度值配置(默认)
	EM_DISPLAY_CAMERA_ANGLE_NUM(1, "按角度值配置"),

	// 按模式配置，0~20展示为顶装,21~90展示为斜装，配置时按60下发
	EM_DISPLAY_CAMERA_ANGLE_MODE(2, "按模式配置");

	private int value;
	private String note;

	private EM_DISPLAY_CAMERA_ANGLE_TYPE(int givenValue, String note) {
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
		for (EM_DISPLAY_CAMERA_ANGLE_TYPE enumType : EM_DISPLAY_CAMERA_ANGLE_TYPE.values()) {
			if (givenValue == enumType.getValue()) {
				return enumType.getNote();
			}
		}
		return null;
	}

	public static int getValueByNote(String givenNote) {
		for (EM_DISPLAY_CAMERA_ANGLE_TYPE enumType : EM_DISPLAY_CAMERA_ANGLE_TYPE.values()) {
			if (givenNote.equals(enumType.getNote())) {
				return enumType.getValue();
			}
		}
		return -1;
	}

}
