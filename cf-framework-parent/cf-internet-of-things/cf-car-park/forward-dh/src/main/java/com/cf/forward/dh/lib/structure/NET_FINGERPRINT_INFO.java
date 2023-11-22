package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 47081
 * @version 1.0
 * @description 指纹数组信息
 * @date 2021/2/22
 */
public class NET_FINGERPRINT_INFO extends NetSDKLib.SdkStructure {
  /** 指纹个数 */
  public int nFingerNum;
  /** 指纹信息 */
  public byte[] szFingerInfo = new byte[8 * 2048];
  /** 保留字节 */
  public byte[] byReserved = new byte[1024];
}
