package com.cf.forward.dh.lib.enumeration;

/**
 * @author 47081
 * @version 1.0
 * @description 光盘状态
 * @date 2021/2/22
 */
public enum EM_DISK_STATE {
  /** 未知 */
  EM_DISK_STATE_UNKNOWN,
  /** 已放磁盘 */
  EM_DISK_STATE_EXIST,
  /** 未放磁盘 */
  EM_DISK_STATE_NO_EXIST,
  /** 需要换盘 */
  EM_DISK_STATE_NEED_CHANGE;

  public static EM_DISK_STATE getDiskState(int state) {
    for (EM_DISK_STATE diskState : EM_DISK_STATE.values()) {
      if (diskState.ordinal() == state) {
        return diskState;
      }
    }
    return EM_DISK_STATE_UNKNOWN;
  }
}
