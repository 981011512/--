package com.cf.forward.dh.lib.enumeration;

/**
 * @author 47081
 * @version 1.0
 * @description 二维码是否过期
 * @date 2021/2/22
 */
public enum EM_QRCODE_IS_EXPIRED {
  /** 未知 */
  EM_QRCODE_EXPIRED_UNKNOWN,
  /** 未过期 */
  EM_QRCODE_NO_EXPIRED,
  /** 过期 */
  EM_QRCODE_EXPIRED;

  public static EM_QRCODE_IS_EXPIRED getQrCodeExpired(int expired) {
    for (EM_QRCODE_IS_EXPIRED qrcodeExpired : EM_QRCODE_IS_EXPIRED.values()) {
      if (qrcodeExpired.ordinal() == expired) {
        return qrcodeExpired;
      }
    }
    return EM_QRCODE_EXPIRED_UNKNOWN;
  }
}
