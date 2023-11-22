package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 47081
 * @version 1.0
 * @description 独立算法升级支持的AI方案信息
 * @date 2021/2/20
 */
public class NET_ALGORITHM_UPGRADE_AI_INFO extends NetSDKLib.SdkStructure {
  /** 算法SDK信息 */
  public NET_ALGORITHM_SDK_INFO[] stuSdkInfo =
      (NET_ALGORITHM_SDK_INFO[]) new NET_ALGORITHM_SDK_INFO().toArray(32);
  /** 实际返回的算法sdk个数, 即stuSdkInfo数组的有效元素个数 */
  public int nRetSdkNum;
  /** 保留字节 */
  public byte[] byReserved = new byte[1020];
}
