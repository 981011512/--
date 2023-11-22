package com.cf.forward.dh.lib.enumeration;

/**
 * @author 251823
 * @description 人体检测及人体识别支持的身体特征（定制）
 * @date 2021/01/11
 */
public enum CFG_EM_BODY_TRAIT {
	// 未知
	CFG_EM_BODY_TRAIT_UNKNOWN(0, "未知"),

	// 性别
	CFG_EM_BODY_TRAIT_SEX(1, "性别"),

	// 年龄组
	CFG_EM_BODY_TRAIT_AGEGROUP(2, "年龄组"),

	// 上衣
	CFG_EM_BODY_TRAIT_COATTYPE(3, "上衣"),

	// 裤子
	CFG_EM_BODY_TRAIT_TROUSERSTYPE(4, "裤子"),

	// 人体角度
	CFG_EM_BODY_TRAIT_ANGLE(5, "人体角度"),

	// 上衣模式
	CFG_EM_BODY_TRAIT_UPPERPATTERN(6, "上衣模式"),

	// 裤子颜色
	CFG_EM_BODY_TRAIT_TROUSERSCOLOR(7, "裤子颜色"),

	// 打伞
	CFG_EM_BODY_TRAIT_UMBRELLA(8, "打伞"),

	// 雨伞颜色
	CFG_EM_BODY_TRAIT_UMBRELLACOLOR(9, "雨伞颜色"),

	// 胸前报东西
	CFG_EM_BODY_TRAIT_HOLD(10, "胸前报东西"),

	// 裤子模式
	CFG_EM_BODY_TRAIT_TROUSERSPATTERN(11, "裤子模式"),

	// 帽子款式
	CFG_EM_BODY_TRAIT_HATTYPE(12, "帽子款式"),

	// 帽子颜色
	CFG_EM_BODY_TRAIT_HATCOLOR(13, "帽子颜色"),

	// 上衣款式
	CFG_EM_BODY_TRAIT_UPPERTYPE(14, "上衣款式"),

	// 上衣颜色
	CFG_EM_BODY_TRAIT_COATCOLOR(15, "上衣颜色"),

	// 发型
	CFG_EM_BODY_TRAIT_HAIRSTYLE(16, "发型"),

	// 头发颜色
	CFG_EM_BODY_TRAIT_HAIRCOLOR(17, "头发颜色"),
	
	// 鞋子款式
	CFG_EM_BODY_TRAIT_SHOESTYPE(18, "鞋子款式"),
	
	// 鞋子颜色
	CFG_EM_BODY_TRAIT_SHOESCOLOR(19, "鞋子颜色"),
	// 箱包款式
	CFG_EM_BODY_TRAIT_BAG(20, "箱包款式"),
	
	// 箱包颜色
	CFG_EM_BODY_TRAIT_BAGCOLOR(21, "箱包颜色"),
	
	// 口罩
	CFG_EM_BODY_TRAIT_MASK(22, "口罩"),

	// 口罩颜色
	CFG_EM_BODY_TRAIT_MASKCOLOR(23, "口罩颜色");

	private int value;
	private String note;

	private CFG_EM_BODY_TRAIT(int givenValue, String note) {
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
		for (CFG_EM_BODY_TRAIT enumType : CFG_EM_BODY_TRAIT.values()) {
			if (givenValue == enumType.getValue()) {
				return enumType.getNote();
			}
		}
		return null;
	}

	public static int getValueByNote(String givenNote) {
		for (CFG_EM_BODY_TRAIT enumType : CFG_EM_BODY_TRAIT.values()) {
			if (givenNote.equals(enumType.getNote())) {
				return enumType.getValue();
			}
		}
		return -1;
	}
}
