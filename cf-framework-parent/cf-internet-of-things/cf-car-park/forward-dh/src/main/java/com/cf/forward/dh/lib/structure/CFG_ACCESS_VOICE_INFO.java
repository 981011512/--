package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.enumeration.CFG_EM_ASG_VOICE_DIRECTION;
import com.cf.forward.dh.lib.enumeration.CFG_EM_VOICE_ID;

/**
 * @author 47081
 * @version 1.0
 * @description 门禁开门语音信息
 * @date 2021/2/7
 */
public class CFG_ACCESS_VOICE_INFO extends NetSDKLib.SdkStructure {
  /** 语音ID,{@link CFG_EM_VOICE_ID} */
  public int emVoiceID;
  /** 语音内容 */
  public byte[] szVoiceContent = new byte[128];
  /** 语音文件路径及名称 */
  public byte[] szFileName = new byte[128];
  /** 闸机进出语音方向,{@link CFG_EM_ASG_VOICE_DIRECTION} */
  public int emAsgVoiceDirection;
  /** 预留字段 */
  public byte[] byReserved = new byte[1020];
}
