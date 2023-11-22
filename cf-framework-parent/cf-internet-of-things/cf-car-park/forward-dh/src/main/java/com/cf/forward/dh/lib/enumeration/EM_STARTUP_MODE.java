package com.cf.forward.dh.lib.enumeration;

/**
 * @author 47081
 * @version 1.0
 * @description 启动模式
 * @date 2021/2/7
 */
public enum EM_STARTUP_MODE {
  /** 未知 */
  EM_STARTUP_MODE_UNKNOWN(-1, "未知"),
  /** 正常启动模式 */
  EM_STARTUP_MODE_NORMAL(0, "正常启动模式"),
  /** 零位设置启动模式 */
  EM_STARTUP_MODE_ZERO_SETTING(1, "零位设置启动模式"),
  /** 老化测试启动模式 */
  EM_STARTUP_MODE_AGING_TEST(2, "老化测试启动模式");

  private int mode;
  private String desc;

  EM_STARTUP_MODE(int mode, String desc) {
    this.mode = mode;
    this.desc = desc;
  }

  public static EM_STARTUP_MODE getStartupMode(int mode) {
    for (EM_STARTUP_MODE startMode : EM_STARTUP_MODE.values()) {
      if (startMode.mode == mode) {
        return startMode;
      }
    }
    return EM_STARTUP_MODE_UNKNOWN;
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
