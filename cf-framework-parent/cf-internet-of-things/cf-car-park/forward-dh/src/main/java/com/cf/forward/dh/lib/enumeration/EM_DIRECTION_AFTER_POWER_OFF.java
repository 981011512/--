package com.cf.forward.dh.lib.enumeration;

/**
 * @author 47081
 * @version 1.0
 * @description 闸机断电以后门摆动放向
 * @date 2021/2/7
 */
public enum EM_DIRECTION_AFTER_POWER_OFF {
  /** 未知 */
  EM_DIRECTION_AFTER_POWER_OFF_UNKNOWN(-1, "未知"),
  /** 进门方向 */
  EM_DIRECTION_AFTER_POWER_OFF_IN(0, "进门方向"),
  /** 出门方向 */
  EM_DIRECTION_AFTER_POWER_OFF_OUT(1, "出门方向");
  private int mode;
  private String desc;

  EM_DIRECTION_AFTER_POWER_OFF(int mode, String desc) {
    this.mode = mode;
    this.desc = desc;
  }

  public static EM_DIRECTION_AFTER_POWER_OFF getEmDirectionAfterPowerOff(int mode) {
    for (EM_DIRECTION_AFTER_POWER_OFF powerOff : EM_DIRECTION_AFTER_POWER_OFF.values()) {
      if (powerOff.mode == mode) {
        return powerOff;
      }
    }
    return EM_DIRECTION_AFTER_POWER_OFF_UNKNOWN;
  }

  public int getMode() {
    return mode;
  }

  public void setMode(int mode) {
    this.mode = mode;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }
}
