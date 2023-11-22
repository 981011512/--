package com.cf.forward.dh.lib.enumeration;

/**
 * @author 47081
 * @version 1.0
 * @description 音频数据类型
 * @date 2021/2/22
 */
public enum EM_AUDIO_DATA_TYPE {
  /** 默认 */
  EM_AUDIO_DATA_TYPE_DEFAULT,
  /** 音频强制转换为AAC */
  EM_AUDIO_DATA_TYPE_AAC,
  /** 音频强制转换为G711A */
  EM_AUDIO_DATA_TYPE_G711A,
  /** 音频强制转换为G711U */
  EM_AUDIO_DATA_TYPE_G711U,
  /** 音频强制转换为MP2 */
  EM_AUDIO_DATA_TYPE_MP2;

  public static EM_AUDIO_DATA_TYPE getAudioDataType(int type) {
    for (EM_AUDIO_DATA_TYPE audioType : EM_AUDIO_DATA_TYPE.values()) {
      if (audioType.ordinal() == type) {
        return audioType;
      }
    }
    return EM_AUDIO_DATA_TYPE_DEFAULT;
  }
}
