package com.cf.forward.dh.lib.enumeration;

/**
 * @author 251823
 * @description 标定区域类型
 * @date 2021/01/11
 */
public enum EM_CALIBRATEAREA_TYPE {
	// 错误
	EM_CALIBRATEAREA_TYPE_ERR(0, "err"),

	//地面，需要N条竖直线段+M条水平线段（（N=3，M=1）；（N=2，M=2）；今后扩展）
	EM_CALIBRATEAREA_TYPE_GROUD(1, "Groud"),

	//水平面，需要水平面上一点到地面点的投影垂直线段
	EM_CALIBRATEAREA_TYPE_HORIZONTAL(2, "Horizontal"),

	//垂直面，需要垂直面与地面的交线
	EM_CALIBRATEAREA_TYPE_VERTICAL(3, "Vertical"),

	//任意平面，N条竖直线段，及每条长度（N=3，及今后扩展）
	EM_CALIBRATEAREA_TYPE_ANY(4, "Any");

	private int value;
	private String note;

	private EM_CALIBRATEAREA_TYPE(int givenValue, String note) {
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
		for (EM_CALIBRATEAREA_TYPE enumType : EM_CALIBRATEAREA_TYPE.values()) {
			if (givenValue == enumType.getValue()) {
				return enumType.getNote();
			}
		}
		return null;
	}

	public static int getValueByNote(String givenNote) {
		for (EM_CALIBRATEAREA_TYPE enumType : EM_CALIBRATEAREA_TYPE.values()) {
			if (givenNote.equals(enumType.getNote())) {
				return enumType.getValue();
			}
		}
		return -1;
	}
}
