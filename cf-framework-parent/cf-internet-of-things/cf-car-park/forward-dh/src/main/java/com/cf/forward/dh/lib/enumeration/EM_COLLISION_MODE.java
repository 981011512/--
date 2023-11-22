package com.cf.forward.dh.lib.enumeration;

/**
 * @author 47081
 * @version 1.0
 * @description 闸机防冲撞模式
 * @date 2021/2/7
 */
public enum EM_COLLISION_MODE {
  /** 未知 */
  EM_COLLISION_MODE_UNKNOWN(-1, "未知"),
  /** 2s松开离合 */
  EM_COLLISION_MODE_2S(0, "2s松开离合"),
  /** 5s松开离合 */
  EM_COLLISION_MODE_5S(1, "5s松开离合"),
  /** 人员离开松开离合 */
  EM_COLLISION_MODE_LEAVING(2, "人员离开松开离合");
  private int mode;
  private String desc;

  EM_COLLISION_MODE(int mode, String desc) {
    this.mode = mode;
    this.desc = desc;
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
