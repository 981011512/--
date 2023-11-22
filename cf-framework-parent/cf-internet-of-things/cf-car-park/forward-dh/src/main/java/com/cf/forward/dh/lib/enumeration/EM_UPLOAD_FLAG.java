package com.cf.forward.dh.lib.enumeration;

/**
 * @author 47081
 * @version 1.0
 * @description 上传标识
 * @date 2021/2/22
 */
public enum EM_UPLOAD_FLAG {
  /** 未知 */
  EM_UPLOAD_FLAG_UNKNOWN,
  /** 成功 */
  EM_UPLOAD_FLAG_SUCCEED,
  /** 失败 */
  EM_UPLOAD_FLAG_FAILED;

  public static EM_UPLOAD_FLAG getUploadFlag(int flag) {
    for (EM_UPLOAD_FLAG upload : EM_UPLOAD_FLAG.values()) {
      if (upload.ordinal() == flag) {
        return upload;
      }
    }
    return EM_UPLOAD_FLAG_UNKNOWN;
  }
}
