package com.cf.forward.dh.lib.enumeration;

/**
 * @author 47081
 * @version 1.0
 * @description 二维码状态
 * @date 2021/2/22
 */
public enum EM_QRCODE_STATE {
  /** 未知 */
  EM_QRCODE_STATE_UNKNOWN,
  /** 已批准 */
  EM_QRCODE_STATE_CLEARED,
  /** 未批准 */
  EM_QRCODE_STATE_NOCLEARED;

  public static EM_QRCODE_STATE getQrcodeState(int state) {
    for (EM_QRCODE_STATE qrcodeState : EM_QRCODE_STATE.values()) {
      if (qrcodeState.ordinal() == state) {
        return qrcodeState;
      }
    }
    return EM_QRCODE_STATE_UNKNOWN;
  }
}
