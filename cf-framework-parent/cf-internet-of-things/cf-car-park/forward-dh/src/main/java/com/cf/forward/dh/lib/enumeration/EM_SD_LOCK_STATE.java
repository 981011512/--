package com.cf.forward.dh.lib.enumeration;

/**
 * @author 251823
 * @description SD卡加锁状态
 * @date 2021/01/21
 */
public enum EM_SD_LOCK_STATE {

	// 未知
	EM_SD_LOCK_STATE_UNKNOWN(-1, "未知"),

	// 未进行过加锁的状态, 如出厂状态，或清除密码时状态
	EM_SD_LOCK_STATE_NORMAL(0, "未进行过加锁的状态"),

	// 加锁
	EM_SD_LOCK_STATE_LOCKED(1, "加锁"),

	// 未加锁（加锁后解锁）
	EM_SD_LOCK_STATE_UNLOCKED(2, "未加锁");

	private int value;
	private String note;

	private EM_SD_LOCK_STATE(int givenValue, String note) {
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
		for (EM_SD_LOCK_STATE enumType : EM_SD_LOCK_STATE.values()) {
			if (givenValue == enumType.getValue()) {
				return enumType.getNote();
			}
		}
		return null;
	}

	public static int getValueByNote(String givenNote) {
		for (EM_SD_LOCK_STATE enumType : EM_SD_LOCK_STATE.values()) {
			if (givenNote.equals(enumType.getNote())) {
				return enumType.getValue();
			}
		}
		return -2;
	}

}
