package com.cf.forward.dh.lib.enumeration;

/**
 * @author 47081
 * @version 1.0
 * @description 路人库满时覆盖策略
 * @date 2021/2/22
 */
public enum EM_PASSERBY_DB_OVERWRITE_TYPE {
  /** 未知 */
  EM_OVERWRITE_TYPE_UNKNOWN(-1, "未知"),
  /** 满停止 */
  EM_OVERWRITE_TYPE_FULL_STOP(0, "满停止"),
  /** 满覆盖 */
  EM_OVERWRITE_TYPE_FULL_COVERAGE(1, "满覆盖");
  private int type;
  private String desc;

  EM_PASSERBY_DB_OVERWRITE_TYPE(int type, String desc) {
    this.type = type;
    this.desc = desc;
  }

  public int getType() {
    return type;
  }

  public String getDesc() {
    return desc;
  }

  public static EM_PASSERBY_DB_OVERWRITE_TYPE getOverwriteType(int type) {
    for (EM_PASSERBY_DB_OVERWRITE_TYPE overwriteType : EM_PASSERBY_DB_OVERWRITE_TYPE.values()) {
      if (overwriteType.type == type) {
        return overwriteType;
      }
    }
    return EM_OVERWRITE_TYPE_UNKNOWN;
  }
}
