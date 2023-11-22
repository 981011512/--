package com.cf.forward.dh.lib.enumeration;

/**
 * @author 251823
 * @description 人体检测及人体识别支持的脸部抓拍策略（定制）
 * @date 2021/01/11
 */
public enum CFG_EM_FACE_SNAP_POLICY {
	// 未知
	CFG_EM_FACE_SNAP_POLICY_UNKNOWN(0, "未知"),

	// 实时抓拍模式(当前的通用模式，实时性优先)
	CFG_EM_FACE_SNAP_POLICY_REALTIME(1, "实时抓拍模式"),

	// 优选抓拍模式，在设定的延时区间(OptimalTime)内挑选评分最高的抓图，准确性优先但延时较大
	CFG_EM_FACE_SNAP_POLICY_OPTIMAL(2, "优选抓拍模式"),

	// 质量抓拍模式，在Optimal的基础上，如果图片质量好于阈值提前结束优选，提高实时性
	CFG_EM_FACE_SNAP_POLICY_QUALITY(3, "质量抓拍模式"),

	// 识别优先抓拍模式，在优选时间内，以一定间隔帧数多次进行比对；一旦比对成功则立即结束优选，以提高对比成功率，取代质量优先模式
	CFG_EM_FACE_SNAP_POLICY_RECOGNITION(4, "识别优先抓拍模式"),

	// 快速优选，从检测到人脸/人体开始，抓拍一定帧数内的质量最好的人脸或人体,定制
	CFG_EM_FACE_SNAP_POLICY_QUICK(5, "快速优选"),

	// 全程优选，抓拍全程质量最好的人脸人体，定制
	CFG_EM_FACE_SNAP_POLICY_FULLTRACK(6, "全程优选"),

	// 间隔抓拍，定制
	CFG_EM_FACE_SNAP_POLICY_INTERVAL(7, "间隔抓拍"),

	// 单人模式，常用于门禁，定制
	CFG_EM_FACE_SNAP_POLICY_SINGLE(8, "单人模式"),

	// 高精度模式，增强人脸识别，定制，增强人脸识别，定制
	CFG_EM_FACE_SNAP_POLICY_PRECISION(9, "高精度模式");

	private int value;
	private String note;

	private CFG_EM_FACE_SNAP_POLICY(int givenValue, String note) {
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
		for (CFG_EM_FACE_SNAP_POLICY enumType : CFG_EM_FACE_SNAP_POLICY.values()) {
			if (givenValue == enumType.getValue()) {
				return enumType.getNote();
			}
		}
		return null;
	}

	public static int getValueByNote(String givenNote) {
		for (CFG_EM_FACE_SNAP_POLICY enumType : CFG_EM_FACE_SNAP_POLICY.values()) {
			if (givenNote.equals(enumType.getNote())) {
				return enumType.getValue();
			}
		}
		return -1;
	}
}
