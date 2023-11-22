package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 47081
 * @version 1.0
 * @description MEDIA_QUERY_TRAFFICCAR对应的查询条件 参数扩展
 * @date 2021/2/22
 */
public class NET_MEDIA_QUERY_TRAFFICCAR_PARAM_EX extends NetSDKLib.SdkStructure {
  /** 违法代码 */
  public byte[] szViolationCode = new byte[16];
  /** 国籍，2字节，符合ISO3166规范 */
  public byte[] szCountry = new byte[4];
  /** 保留字节 */
  public byte[] byReserved = new byte[1020];
}
