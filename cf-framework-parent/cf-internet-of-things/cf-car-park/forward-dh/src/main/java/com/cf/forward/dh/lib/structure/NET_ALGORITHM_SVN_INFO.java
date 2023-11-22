package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 47081
 * @version 1.0
 * @description 算法构建svn信息
 * @date 2021/2/20
 */
public class NET_ALGORITHM_SVN_INFO extends NetSDKLib.SdkStructure {
  /** svn地址 */
  public byte[] szAddr = new byte[512];
  /** svn版本号 */
  public int nRevision;
  /** 保留字节 */
  public byte[] byReserved = new byte[1020];
}
