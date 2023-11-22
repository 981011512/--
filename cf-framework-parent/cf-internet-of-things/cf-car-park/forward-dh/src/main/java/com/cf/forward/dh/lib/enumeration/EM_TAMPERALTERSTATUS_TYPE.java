package com.cf.forward.dh.lib.enumeration;

/**
 * @author 47081
 * @version 1.0
 * @description 设备锁状态
 * @date 2021/2/22
 */
public enum EM_TAMPERALTERSTATUS_TYPE {
  /** 未知 */
  EM_TAMPERALTERSTATUS_UNKNOWN(-1, "未知"),
  /** 关闭 */
  EM_TAMPERALTERSTATUS_CLOSE(0, "关闭"),
  /** 开启 */
  EM_TAMPERALTERSTATUS_OPEN(1, "开启");
  private int type;
  private String desc;

  EM_TAMPERALTERSTATUS_TYPE(int type, String desc) {
    this.type = type;
    this.desc = desc;
  }

  public int getType() {
    return type;
  }

  public String getDesc() {
    return desc;
  }

  public static EM_TAMPERALTERSTATUS_TYPE getTamperaltersStatus(int type) {
    for (EM_TAMPERALTERSTATUS_TYPE statusType : EM_TAMPERALTERSTATUS_TYPE.values()) {
      if (statusType.type == type) {
        return statusType;
      }
    }
    return EM_TAMPERALTERSTATUS_UNKNOWN;
  }
}
