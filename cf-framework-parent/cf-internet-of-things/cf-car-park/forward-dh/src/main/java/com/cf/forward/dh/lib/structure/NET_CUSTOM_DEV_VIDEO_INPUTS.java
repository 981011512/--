package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.enumeration.EM_VIDEOINPUTS_SERVICE_TYPE;

/**
 * 视频输入信息
 *
 * @author ： 47040
 * @since ： Created in 2020/8/13 10:29 EM_VIDEOINPUTS_SERVICE_TYPE
 */
public class NET_CUSTOM_DEV_VIDEO_INPUTS extends NetSDKLib.SdkStructure {

  /** 主码流URL地址（注：接入设备协议类型为General时有效，此时主辅码流URL不能同时为空） */
  public byte[] szMainStreamUrl = new byte[256];
  /** 辅码流URL地址（注：接入设备协议类型为General时有效，此时主辅码流URL不能同时为空） */
  public byte[] szExtraStreamUrl = new byte[256];
  /** 服务类型，对应枚举{@link EM_VIDEOINPUTS_SERVICE_TYPE} */
  public int emServiceType;
  /** 预留字节 */
  public byte[] byReserved = new byte[508];
}
