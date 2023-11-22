package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 47081
 * @version 1.0
 * @description 平场自动校正周期范围
 * @date 2021/2/22
 */
public class NET_FFCPERIOD_RANGE extends NetSDKLib.SdkStructure {
  /** 最大值(NTSC制式) */
  public int nMaxN;
  /** 最大值(PAL制式) */
  public int nMaxP;
  /** 最小值 */
  public int nMin;
  /** 步长 */
  public int nStep;
  /** 保留字节 */
  public byte[] reserved = new byte[16];
}
