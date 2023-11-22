package com.cf.forward.dh.lib.enumeration;

/**
 * @author 251823
 * @description 道闸栏状态
 * @date 2020/12/15
 */
public enum EM_TRAFFICSTROBE_STATUS {

	// 未知
	NET_TRAFFICSTROBE_STATUS_UNKNOWN(0, "未知"),
	// 道闸栏关闭
	NET_TRAFFICSTROBE_STATUS_CLOSE_COMPLETE(1, "道闸栏关闭"),
	// 道闸栏打开
	NET_TRAFFICSTROBE_STATUS_OPEN_COMPLETE(2, "道闸栏打开"),
	// 道闸栏未完全关闭
	NET_TRAFFICSTROBE_STATUS_NOT_CLOSE_COMPLETE(3, "道闸栏未完全关闭"),
	// 道闸栏未完全打开
	NET_TRAFFICSTROBE_STATUS_NOT_OPEN_COMPLETE(4, "道闸栏未完全打开"),
	// 道闸停止
	NET_TRAFFICSTROBE_STATUS_NOT_STROBE_STOP(5, "道闸停止");

	private int value;
	private String note;

	private EM_TRAFFICSTROBE_STATUS(int givenValue, String note) {
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
		for (EM_TRAFFICSTROBE_STATUS enumType : EM_TRAFFICSTROBE_STATUS.values()) {
			if (givenValue == enumType.getValue()) {
				return enumType.getNote();
			}
		}
		return null;
	}

	public static int getValueByNote(String givenNote) {
		for (EM_TRAFFICSTROBE_STATUS enumType : EM_TRAFFICSTROBE_STATUS.values()) {
			if (givenNote.equals(enumType.getNote())) {
				return enumType.getValue();
			}
		}
		return -1;
	}
}
