package com.cf.forward.dh.lib.enumeration;

/**
 * @author 251823
 * @description 音频解码能力数据流源类型
 * @date 2021/01/06
 */
public enum EM_AUDIO_DATA_SOURCE_TYPE {
	// 未知数据类型
	EM_AUDIO_DATA_SOURCE_TYPE_UNKNOWN(-1, "未知数据类型"),

	// 对讲数据
	EM_AUDIO_DATA_SOURCE_TYPE_TALK(0, "对讲数据"),

	// 普通音频数据，如伴音
	EM_AUDIO_DATA_SOURCE_TYPE_NORMAL(1, "普通音频数据，如伴音"),

	// 报警音频数据流
	EM_AUDIO_DATA_SOURCE_TYPE_ALARM(2, "报警音频数据流");

	private int value;
	private String note;

	private EM_AUDIO_DATA_SOURCE_TYPE(int givenValue, String note) {
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
		for (EM_AUDIO_DATA_SOURCE_TYPE enumType : EM_AUDIO_DATA_SOURCE_TYPE.values()) {
			if (givenValue == enumType.getValue()) {
				return enumType.getNote();
			}
		}
		return null;
	}

	public static int getValueByNote(String givenNote) {
		for (EM_AUDIO_DATA_SOURCE_TYPE enumType : EM_AUDIO_DATA_SOURCE_TYPE.values()) {
			if (givenNote.equals(enumType.getNote())) {
				return enumType.getValue();
			}
		}
		return -2;
	}
}
