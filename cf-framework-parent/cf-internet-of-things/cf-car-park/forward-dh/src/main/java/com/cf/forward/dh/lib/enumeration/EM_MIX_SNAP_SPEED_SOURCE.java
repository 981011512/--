package com.cf.forward.dh.lib.enumeration;

/**
 * @author 47081
 * @version 1.0
 * @description 视频抓拍速度来源
 * @date 2021/2/22
 */
public enum EM_MIX_SNAP_SPEED_SOURCE {
  /** 未知 */
  EM_SNAP_SPEED_SOURCE_UNKNOWN,
  /** 视频 */
  EM_SNAP_SPEED_SOURCE_VIDEO,
  /** 雷达 */
  EM_SNAP_SPEED_SOURCE_RADAR;

  public static EM_MIX_SNAP_SPEED_SOURCE getMixSnapSpeedSource(int source) {
    for (EM_MIX_SNAP_SPEED_SOURCE speedSource : EM_MIX_SNAP_SPEED_SOURCE.values()) {
      if (speedSource.ordinal() == source) {
        return speedSource;
      }
    }
    return EM_SNAP_SPEED_SOURCE_UNKNOWN;
  }
}
