package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.enumeration.EM_PASSERBY_DB_DUPLICATE_REMOVE_TYPE;

/**
 * @author 47081
 * @version 1.0
 * @description 路人库去重策略配置(选填)
 * @date 2021/2/22
 */
public class PASSERBY_DB_DUPLICATE_REMOVE_CONFIG_INFO extends NetSDKLib.SdkStructure {
  /** 使能开关，TRUE：开 FALSE：关 */
  public boolean bEnable;
  /** 路人库去重策略类型,对应枚举{@link EM_PASSERBY_DB_DUPLICATE_REMOVE_TYPE} */
  public int emDuplicateRemoveType;
  /** 时间段间隔(emDuplicateRemoveType 为 EM_DUPLICATE_REMOVE_TYPE_TIME_SLOT有效) */
  public NetSDKLib.NET_TSECT[] stuTimeSection =
      (NetSDKLib.NET_TSECT[]) new NetSDKLib.NET_TSECT().toArray(8 * 6);
  /** 时间间隔，单位分钟（emDuplicateRemoveType 为 EM_DUPLICATE_REMOVE_TYPE_TIME有效） */
  public int dwInterval;
  /** 字节保留 */
  public byte[] byReserved1 = new byte[4];
  /** 字节保留 */
  public byte[] byReserved = new byte[256];
}
