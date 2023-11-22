package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.enumeration.EM_UPLOAD_FLAG;

/**
 * @author 47081
 * @version 1.0
 * @description 客户端信息
 * @date 2021/2/22
 */
public class NET_UPLOAD_CLIENT_INFO extends NetSDKLib.SdkStructure {
  /** 平台客户端的标识，当前是IPv4地址或者MAC地址 */
  public byte[] szClientID = new byte[20];
  /** 平台上传标识 ,对应枚举{@link EM_UPLOAD_FLAG} */
  public int emUploadFlag;
  /** 上传到平台的UTC时间 */
  public NET_TIME stuUploadTime;
  /** 预留 */
  public byte[] byReserved = new byte[64];
}
