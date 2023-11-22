package com.cf.forward.dh.lib.enumeration;

/**
 * @author 251823
 * @description 智能分析实例类型
 * @date 2021/01/11
 */
public enum CFG_EM_INSTANCE_SUBCLASS_TYPE {

	// 本地实例
	CFG_EM_INSTANCE_SUBCLASS_TYPE_LOCAL(0, "本地实例"),

	// 远程实例
	CFG_EM_INSTANCE_SUBCLASS_TYPE_REMOTE(1, "远程实例");

	private int value;
	private String note;

	private CFG_EM_INSTANCE_SUBCLASS_TYPE(int givenValue, String note) {
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
		for (CFG_EM_INSTANCE_SUBCLASS_TYPE enumType : CFG_EM_INSTANCE_SUBCLASS_TYPE.values()) {
			if (givenValue == enumType.getValue()) {
				return enumType.getNote();
			}
		}
		return null;
	}

	public static int getValueByNote(String givenNote) {
		for (CFG_EM_INSTANCE_SUBCLASS_TYPE enumType : CFG_EM_INSTANCE_SUBCLASS_TYPE.values()) {
			if (givenNote.equals(enumType.getNote())) {
				return enumType.getValue();
			}
		}
		return -1;
	}
}
