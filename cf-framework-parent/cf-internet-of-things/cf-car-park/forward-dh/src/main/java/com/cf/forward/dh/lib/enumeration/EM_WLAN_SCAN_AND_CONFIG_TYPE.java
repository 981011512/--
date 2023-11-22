package com.cf.forward.dh.lib.enumeration;

/**
 * @author 47081
 * @version 1.0
 * @description wifi扫描及配置支持的版本类型
 * @date 2021/2/22
 */
public enum EM_WLAN_SCAN_AND_CONFIG_TYPE {
  /** 未知 */
  EM_WLAN_SCAN_AND_CONFIG_UNKNOWN,
  /** V2:二代协议 */
  EM_WLAN_SCAN_AND_CONFIG_V2,
  /** v3:三代协议 */
  EM_WLAN_SCAN_AND_CONFIG_V3;

  public EM_WLAN_SCAN_AND_CONFIG_TYPE getWlanScanAndConfigType(int type) {
    for (EM_WLAN_SCAN_AND_CONFIG_TYPE configType : EM_WLAN_SCAN_AND_CONFIG_TYPE.values()) {
      if (configType.ordinal() == type) {
        return configType;
      }
    }
    return EM_WLAN_SCAN_AND_CONFIG_UNKNOWN;
  }
}
