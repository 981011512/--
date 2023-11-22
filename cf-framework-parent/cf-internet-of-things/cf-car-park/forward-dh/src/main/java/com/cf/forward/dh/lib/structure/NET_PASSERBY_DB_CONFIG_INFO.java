package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.enumeration.EM_PASSERBY_DB_OVERWRITE_TYPE;

/**
 * @author 47081
 * @version 1.0
 * @description 路人库配置(选填)
 * @date 2021/2/22
 */
public class NET_PASSERBY_DB_CONFIG_INFO extends NetSDKLib.SdkStructure {
  /** 路人库最大注册数目 */
  public int dwCapacity;
  /** 路人库满时覆盖策略,对应枚举{@link EM_PASSERBY_DB_OVERWRITE_TYPE} */
  public int emOverWriteType;
  /** 路人库去重策略配置(选填) */
  public PASSERBY_DB_DUPLICATE_REMOVE_CONFIG_INFO stuDuplicateRemoveConfigInfo;
  /** 设置文件保留天数【范围：0~31】单位：天，超过时间将被删除 0：永不过期 */
  public int dwFileHoldTime;
  /** 字节对齐 */
  public byte[] byReserved1 = new byte[4];
  /** 字节保留 */
  public byte[] byReserved = new byte[256];
}
