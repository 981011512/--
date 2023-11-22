package com.cf.forward.dh.lib.enumeration;

/**
 * @author 47081
 * @version 1.0
 * @description
 * @date 2021/3/2
 */
public enum EM_REAL_DATA_TYPE {
  EM_REAL_DATA_TYPE_PRIVATE(0, "私有码流"),
  EM_REAL_DATA_TYPE_GBPS(1, "国标PS码流"),
  EM_REAL_DATA_TYPE_TS(2, "TS码流"),
  EM_REAL_DATA_TYPE_MP4(3, "MP4文件"),
  EM_REAL_DATA_TYPE_H264(4, "裸H264码流"),
  EM_REAL_DATA_TYPE_FLV_STREAM(5, "流式FLV");
  private int type;
  private String desc;

  public int getType() {
    return type;
  }

  public String getDesc() {
    return desc;
  }

  EM_REAL_DATA_TYPE(int type, String desc) {
    this.type = type;
    this.desc = desc;
  }
}
