package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 47081
 * @version 1.0
 * @description 算法构建信息
 * @date 2021/2/20
 */
public class NET_ALGORITHM_BUILD_INFO extends NetSDKLib.SdkStructure {
  public NET_ALGORITHM_SVN_INFO stuSvnInfo; // 算法SVN信息
  /** 保留字节 */
  public byte[] byReserved = new byte[1024];
}
