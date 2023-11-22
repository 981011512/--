package com.cf.forward.dh.lib.enumeration;

/**
 * @author 47081
 * @version 1.0
 * @description 录像文件的状态
 * @date 2021/2/22
 */
public enum EM_VIDEO_FILE_STATE {
  /** 未知 */
  EM_VIDEO_FILE_STATE_UNKNOWN,
  /** 正在写 */
  EM_VIDEO_FILE_STATE_TEMPORARY,
  /** 已写完并正常关闭文件句柄 */
  EM_VIDEO_FILE_STATE_COMPLETE;

  public static EM_VIDEO_FILE_STATE getVideoFileState(int status) {
    for (EM_VIDEO_FILE_STATE fileState : EM_VIDEO_FILE_STATE.values()) {
      if (fileState.ordinal() == status) {
        return fileState;
      }
    }
    return EM_VIDEO_FILE_STATE_UNKNOWN;
  }
}
