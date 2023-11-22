package com.cf.forward.dh.lib.enumeration;

/**
 * @author 47081
 * @version 1.0
 * @description 录像的类型
 * @date 2021/2/22
 */
public enum EM_VIDEO_TYPE {
  /** 未知 */
  EM_VIDEO_TYPE_UNKNOWN,
  /** 全部 */
  EM_VIDEO_TYPE_ALL,
  /** 手动保存的录像 */
  EM_VIDEO_TYPE_MANUAL,
  /** 报警录像 */
  EM_VIDEO_TYPE_ALARM;

  public EM_VIDEO_TYPE getVideoType(int type) {
    for (EM_VIDEO_TYPE videoType : EM_VIDEO_TYPE.values()) {
      if (videoType.ordinal() == type) {
        return videoType;
      }
    }
    return EM_VIDEO_TYPE_UNKNOWN;
  }
}
