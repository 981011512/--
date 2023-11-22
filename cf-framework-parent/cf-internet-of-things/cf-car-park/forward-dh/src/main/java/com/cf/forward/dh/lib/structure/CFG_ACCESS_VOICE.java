package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.enumeration.CFG_EM_VOICE_ID;

/**
 * @author 47081
 * @version 1.0
 * @description 门禁开门提示声
 * @date 2021/2/7
 */
public class CFG_ACCESS_VOICE extends NetSDKLib.SdkStructure {
  /** 当前播放语音ID,{@link CFG_EM_VOICE_ID} */
  public int emCurrentVoiceID;

  public CFG_ACCESS_VOICE_INFO[] arrayVoiceInfo =
      (CFG_ACCESS_VOICE_INFO[]) new CFG_ACCESS_VOICE_INFO().toArray(16); // 语音列表
  public int nVoiceCount; // arrayVoiceInfo 个数
  public byte[] byReserved = new byte[1024]; // 预留字段
}
