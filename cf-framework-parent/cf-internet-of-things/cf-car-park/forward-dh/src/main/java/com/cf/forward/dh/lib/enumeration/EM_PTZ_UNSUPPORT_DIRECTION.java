package com.cf.forward.dh.lib.enumeration;
/**
 * @author 251823
 * @description 云台不支持的转动方向
 * @date 2021/02/05
 */
public enum EM_PTZ_UNSUPPORT_DIRECTION {

	// 未知
	EM_PTZ_UNSUPPORT_DIRECTION_UNKNOWN(0, "未知"),

	// 上
	EM_PTZ_UNSUPPORT_DIRECTION_UP(1, "上"),

	// 下
	EM_PTZ_UNSUPPORT_DIRECTION_DOWN(2, "下"),
	
	// 左
	EM_PTZ_UNSUPPORT_DIRECTION_LEFT(3, "左"),
	
	// 右
	EM_PTZ_UNSUPPORT_DIRECTION_RIGHT(4, "右"),
	
	// 左上
	EM_PTZ_UNSUPPORT_DIRECTION_LEFTUP(5, "左上"),
	
	// 右上
	EM_PTZ_UNSUPPORT_DIRECTION_RIGHTUP(6, "右上"),
	
	// 左下
	EM_PTZ_UNSUPPORT_DIRECTION_LEFTDOWN(7, "左下"),
	
	// 右下
	EM_PTZ_UNSUPPORT_DIRECTION_RIGHTDOWN(8, "右下");
	

	private int value;
	private String note;

	private EM_PTZ_UNSUPPORT_DIRECTION(int givenValue, String note) {
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
		for (EM_PTZ_UNSUPPORT_DIRECTION enumType : EM_PTZ_UNSUPPORT_DIRECTION.values()) {
			if (givenValue == enumType.getValue()) {
				return enumType.getNote();
			}
		}
		return null;
	}

	public static int getValueByNote(String givenNote) {
		for (EM_PTZ_UNSUPPORT_DIRECTION enumType : EM_PTZ_UNSUPPORT_DIRECTION.values()) {
			if (givenNote.equals(enumType.getNote())) {
				return enumType.getValue();
			}
		}
		return -1;
	}

}
