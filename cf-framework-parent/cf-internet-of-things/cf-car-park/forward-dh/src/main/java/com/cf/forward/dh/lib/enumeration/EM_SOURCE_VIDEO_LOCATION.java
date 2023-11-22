package com.cf.forward.dh.lib.enumeration;

/**
 * @author 47081
 * @version 1.0
 * @description 视频诊断录像保存位置
 * @date 2021/2/22
 */
public enum EM_SOURCE_VIDEO_LOCATION {
  /** 未知 */
  EM_SOURCE_VIDEO_LOCATION_UNKNOWN,
  /** 存于设备 */
  EM_SOURCE_VIDEO_LOCATION_DEVICE,
  /** 存于平台 */
  EM_SOURCE_VIDEO_LOCATION_CENTER,
  /** 存于第三方云 */
  EM_SOURCE_VIDEO_LOCATION_THIRD;

  public EM_SOURCE_VIDEO_LOCATION getVideoLocation(int location) {
    for (EM_SOURCE_VIDEO_LOCATION videoLocation : EM_SOURCE_VIDEO_LOCATION.values()) {
      if (videoLocation.ordinal() == location) {
        return videoLocation;
      }
    }
    return EM_SOURCE_VIDEO_LOCATION_UNKNOWN;
  }
}
