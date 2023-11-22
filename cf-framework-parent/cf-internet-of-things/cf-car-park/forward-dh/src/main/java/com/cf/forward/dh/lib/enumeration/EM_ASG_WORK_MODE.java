package com.cf.forward.dh.lib.enumeration;

/**
 * @author 47081
 * @version 1.0
 * @description 工作模式
 * @date 2021/2/7
 */
public enum EM_ASG_WORK_MODE {
  /** 未知 */
  EM_ASG_WORK_MODE_UNKNOWN(-1, "未知"),
  /** 常闭模式 */
  EM_ASG_WORK_MODE_CLOSE(0, "常闭模式"),
  EM_ASG_WORK_MODE_OPEN(1, "常开模式");

  private int mode;
  private String desc;

  EM_ASG_WORK_MODE(int mode, String desc) {
    this.mode = mode;
    this.desc = desc;
  }

  public static EM_ASG_WORK_MODE getAsgWorkMode(int mode) {
    for (EM_ASG_WORK_MODE workMode : EM_ASG_WORK_MODE.values()) {
      if (workMode.mode == mode) {
        return workMode;
      }
    }
    return EM_ASG_WORK_MODE_UNKNOWN;
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
