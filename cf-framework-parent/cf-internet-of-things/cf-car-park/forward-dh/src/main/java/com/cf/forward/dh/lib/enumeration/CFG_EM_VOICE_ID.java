package com.cf.forward.dh.lib.enumeration;

/**
 * @author 47081
 * @version 1.0
 * @description 语音ID
 * @date 2021/2/7
 */
public enum CFG_EM_VOICE_ID {
  /** 未知 */
  CFG_EM_VOICE_ID_UNKNOWN(-1, "未知"),
  /** 验证成功(默认) */
  CFG_EM_VOICE_ID_VERIFY_SUCCESS(0, "验证成功(默认)"),
  /** 开门成功 */
  CFG_EM_VOICE_ID_OPENDOOR_SUCCESS(1, "开门成功"),
  /** 开锁成功 */
  CFG_EM_VOICE_ID_UNLOCK_SUCCESS(2, "开锁成功"),
  /** 刷卡成功 */
  CFG_EM_VOICE_ID_SWIPECARD_SUCCESS(3, "刷卡成功"),
  /** 欢迎光临 */
  CFG_EM_VOICE_ID_WELCOME(4, "欢迎光临"),
  /** 欢迎再次光临 */
  CFG_EM_VOICE_ID_WELCOME_BACK(5, "欢迎再次光临"),
  /** 谢谢 */
  CFG_EM_VOICE_ID_THANKS(6, "谢谢"),
  /** 自定义 */
  CFG_EM_VOICE_ID_CUSTOMIZED_VOICE(7, "自定义"),
  /** 无声音 */
  CFG_EM_VOICE_ID_NO_VOICE(8, "无声音"),
  /** 欢迎回家 */
  CFG_EM_VOICE_ID_WELCOME_HOME(9, "欢迎回家"),
  /** 一路顺风 */
  CFG_EM_VOICE_ID_GOOD_JOURNEY(10, "一路顺风"),
  /** 欢迎下次光临 */
  CFG_EM_VOICE_ID_WELCOME_BACK_NEXT(11, "欢迎下次光临"),
  /** 谢谢惠顾 */
  CFG_EM_VOICE_ID_THANKS_FOR_PATRONAGE(12, "谢谢惠顾");
  private int id;
  private String desc;

  CFG_EM_VOICE_ID(int id, String desc) {
    this.id = id;
    this.desc = desc;
  }

  public static CFG_EM_VOICE_ID getVoiceID(int id) {
    for (CFG_EM_VOICE_ID voiceID : CFG_EM_VOICE_ID.values()) {
      if (voiceID.id == id) {
        return voiceID;
      }
    }
    return CFG_EM_VOICE_ID_UNKNOWN;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }
}
