package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 47081
 * @version 1.0
 * @description 算法sdk信息
 * @date 2021/2/20
 */
public class NET_ALGORITHM_SDK_INFO extends NetSDKLib.SdkStructure {
  /** 算法 api 头文件版本 */
  public int nApiVersion;
  /** 编译平台代号 */
  public int nCompiler;
  /** 算法sdk名称 */
  public byte[] szSdkName = new byte[128];
  /** 算法sdk版本信息 */
  public byte[] szSdkVersion = new byte[64];
  /** 保留字节 */
  public byte[] byReserved = new byte[1024];
}
