package com.cf.forward.dh.lib.enumeration;

/**
 * @author 47081
 * @version 1.0
 * @description 紧急报警状态
 * @date 2021/2/22
 */
public enum EM_EMERGENCYSTATUS_TYPE {
  /** 未知 */
  EM_EMERGENCYSTATUS_UNKNOWN(-1, "未知"),
  EM_EMERGENCYSTATUS_CLOSE(0, "关闭"),
  EM_EMERGENCYSTATUS_OPEN(1, "开启");
  private int type;
  private String desc;

  EM_EMERGENCYSTATUS_TYPE(int type, String desc) {
    this.type = type;
    this.desc = desc;
  }

  public int getType() {
    return type;
  }

  public String getDesc() {
    return desc;
  }

  public static EM_EMERGENCYSTATUS_TYPE getEmergencyStatusType(int type) {
    for (EM_EMERGENCYSTATUS_TYPE emergencyStatus : EM_EMERGENCYSTATUS_TYPE.values()) {
      if (emergencyStatus.type == type) {
        return emergencyStatus;
      }
    }
    return EM_EMERGENCYSTATUS_UNKNOWN;
  }
}
