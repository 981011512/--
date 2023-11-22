package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 47081
 * @version 1.0
 * @description 卡号数组信息
 * @date 2021/2/22
 */
public class NET_CARDNOARRAY_INFO extends NetSDKLib.SdkStructure {
  /** 卡号个数 */
  public int nCardNum;
  /** 卡号信息 */
  public byte[] szCardInfo = new byte[5 * 64];
  /** 保留字节 */
  public byte[] byReserved = new byte[1024];
}
