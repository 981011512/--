package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 47081
 * @version 1.0
 * @description 人脸比对事件触发对应球机信息
 * @date 2021/2/22
 */
public class NET_FACECOMPARISON_PTZ_INFO extends NetSDKLib.SdkStructure {
  /** 球机抓拍到人脸时预置点名称 */
  public byte[] szPresetName = new byte[64];
  /** 球机抓拍到人脸时预置点编号 */
  public int dwPresetNumber;
  /** 字节对齐 */
  public byte[] byReserved1 = new byte[4];
  /** 保留字节 */
  public byte[] byReserved = new byte[256];
}
