package com.cf.forward.dh.lib.enumeration;

/**
 * @author 47081
 * @version 1.0
 * @description 平台呼出类型
 * @date 2021/2/22
 */
public enum NET_EM_OFFLINE_CALL_TYPE {
  /** 未知 */
  NET_EM_OFFLINE_CALL_UNKNOWN(-1, "未知"),
  /** 在线呼出 */
  NET_EM_OFFLINE_CALL_ONLINECALL(0, "在线呼出"),
  /** 断线呼出 */
  NET_EM_OFFLINE_CALL_OFFLINECALL(1, "断线呼出"),
  /** 其他 */
  NET_EM_OFFLINE_CALL_NONE(255, "其他");
  private int type;
  private String desc;

  NET_EM_OFFLINE_CALL_TYPE(int type, String desc) {
    this.type = type;
    this.desc = desc;
  }

  public int getType() {
    return type;
  }

  public String getDesc() {
    return desc;
  }

  public static NET_EM_OFFLINE_CALL_TYPE getOfflineCallType(int type) {
    for (NET_EM_OFFLINE_CALL_TYPE offlineCall : NET_EM_OFFLINE_CALL_TYPE.values()) {
      if (offlineCall.type == type) {
        return offlineCall;
      }
    }
    return NET_EM_OFFLINE_CALL_UNKNOWN;
  }
}
