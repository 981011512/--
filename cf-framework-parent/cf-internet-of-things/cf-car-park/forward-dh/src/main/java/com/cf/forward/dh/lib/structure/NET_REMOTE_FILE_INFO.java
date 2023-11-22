package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 47081
 * @version 1.0
 * @description 文件信息
 * @date 2021/2/22
 */
public class NET_REMOTE_FILE_INFO extends NetSDKLib.SdkStructure {
  /** 文件绝对路径 */
  public byte[] szPath = new byte[256];
  /** 文件大小，单位：字节 */
  public int nSize;
  /** 预留字节 */
  public byte[] byReserved = new byte[508];
}
