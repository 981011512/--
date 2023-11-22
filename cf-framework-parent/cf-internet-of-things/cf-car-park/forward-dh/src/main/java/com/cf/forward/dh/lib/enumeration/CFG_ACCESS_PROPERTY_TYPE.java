package com.cf.forward.dh.lib.enumeration;

/**
 * @author 47081
 * @version 1.0
 * @description 门禁单双向配置类型
 * @date 2021/2/7
 */
public enum CFG_ACCESS_PROPERTY_TYPE {
  /** 未知 */
  CFG_ACCESS_PROPERTY_UNKNOWN(0, "未知"),
  /** 双向门禁 */
  CFG_ACCESS_PROPERTY_BIDIRECT(1, "双向门禁"),
  /** 单向门禁 */
  CFG_ACCESS_PROPERTY_UNIDIRECT(2, "单向门禁");
  /** 枚举值 */
  private int type;
  /** 枚举对应的类型描述 */
  private String desc;

  CFG_ACCESS_PROPERTY_TYPE(int type, String desc) {
    this.type = type;
    this.desc = desc;
  }

}
