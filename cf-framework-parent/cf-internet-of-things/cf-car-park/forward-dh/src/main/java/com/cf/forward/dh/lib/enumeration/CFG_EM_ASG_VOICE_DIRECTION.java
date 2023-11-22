package com.cf.forward.dh.lib.enumeration;

/**
 * @author 47081
 * @version 1.0
 * @description 闸机进出语音方向
 * @date 2021/2/7
 */
public enum CFG_EM_ASG_VOICE_DIRECTION {
  CFG_EM_ASG_VOICE_DIRECTION_UNKNOWN(0, "未知"),
  CFG_EM_ASG_VOICE_DIRECTION_ENTER(1, "进入"),
  CFG_EM_ASG_VOICE_DIRECTION_LEAVE(2, "离开");
  private int direction;
  private String desc;

  CFG_EM_ASG_VOICE_DIRECTION(int direction, String desc) {
    this.direction = direction;
    this.desc = desc;
  }

  public static CFG_EM_ASG_VOICE_DIRECTION getVoiceDirection(int direction) {
    for (CFG_EM_ASG_VOICE_DIRECTION voiceDirection : CFG_EM_ASG_VOICE_DIRECTION.values()) {
      if (voiceDirection.direction == direction) {
        return voiceDirection;
      }
    }
    return CFG_EM_ASG_VOICE_DIRECTION_UNKNOWN;
  }

  public int getDirection() {
    return direction;
  }

  public void setDirection(int direction) {
    this.direction = direction;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }
}
