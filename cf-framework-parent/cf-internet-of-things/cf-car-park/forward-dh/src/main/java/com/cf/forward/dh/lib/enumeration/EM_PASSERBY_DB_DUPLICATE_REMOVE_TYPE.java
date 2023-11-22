package com.cf.forward.dh.lib.enumeration;

/**
 * @author 47081
 * @version 1.0
 * @description 路人库去重策略类型
 * @date 2021/2/22
 */
public enum EM_PASSERBY_DB_DUPLICATE_REMOVE_TYPE {
  /** 未知 */
  EM_DUPLICATE_REMOVE_TYPE_UNKNOWN(-1, "未知"),
  /** 无条件去重 */
  EM_DUPLICATE_REMOVE_TYPE_ALL(0, "无条件去重"),
  /** 按时间间隔去重 */
  EM_DUPLICATE_REMOVE_TYPE_TIME(1, "按时间间隔去重"),
  /** 按时间段间隔去重 */
  EM_DUPLICATE_REMOVE_TYPE_TIME_SLOT(2, "按时间段间隔去重");
  private int type;
  private String desc;

  EM_PASSERBY_DB_DUPLICATE_REMOVE_TYPE(int type, String desc) {
    this.type = type;
    this.desc = desc;
  }

  public int getType() {
    return type;
  }

  public String getDesc() {
    return desc;
  }

  public static EM_PASSERBY_DB_DUPLICATE_REMOVE_TYPE getDuplicateRemoveType(int type) {
    for (EM_PASSERBY_DB_DUPLICATE_REMOVE_TYPE removeType :
        EM_PASSERBY_DB_DUPLICATE_REMOVE_TYPE.values()) {
      if (removeType.type == type) {
        return removeType;
      }
    }
    return EM_DUPLICATE_REMOVE_TYPE_UNKNOWN;
  }
}
