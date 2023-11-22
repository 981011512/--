package com.cf.forward.dh.lib.enumeration;

/**
 * @author 251823
 * @description 智能类型
 * @date 2021/01/11
 */
public enum CFG_EM_FACEDETECT_TYPE {
	// 未知
	CFG_EM_FACEDETECT_TYPE_UNKNOWN(0, "未知"),

	// 可见光
	CFG_EM_FACEDETECT_TYPE_VISUAL(1, "可见光"),

	// 红外
	CFG_EM_FACEDETECT_TYPE_THERMAL(2, "红外"),

	// 按时间段切换
	CFG_EM_FACEDETECT_TYPE_SWITCHBYTIME(3, "按时间段切换");

	private int value;
	private String note;

	private CFG_EM_FACEDETECT_TYPE(int givenValue, String note) {
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
		for (CFG_EM_FACEDETECT_TYPE enumType : CFG_EM_FACEDETECT_TYPE.values()) {
			if (givenValue == enumType.getValue()) {
				return enumType.getNote();
			}
		}
		return null;
	}

	public static int getValueByNote(String givenNote) {
		for (CFG_EM_FACEDETECT_TYPE enumType : CFG_EM_FACEDETECT_TYPE.values()) {
			if (givenNote.equals(enumType.getNote())) {
				return enumType.getValue();
			}
		}
		return -1;
	}

}
