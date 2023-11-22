package com.cf.forward.dh.lib.enumeration;

/**
 * @author 47081
 * @version 1.0
 * @description 通道宽度
 * @date 2021/2/7
 */
public enum EM_CHANNEL_WIDTH {
  /** 未知 */
  EM_CHANNEL_WIDTH_UNKNOWN(-1, "未知"),
  /** 600mm */
  EM_CHANNEL_WIDTH_600(0, "600mm"),
  /** 700mm */
  EM_CHANNEL_WIDTH_700(1, "700mm"),
  /** 800mm */
  EM_CHANNEL_WIDTH_800(2, "800mm"),
  /** 900mm */
  EM_CHANNEL_WIDTH_900(3, "900mm"),
  /** 1000mm */
  EM_CHANNEL_WIDTH_1000(4, "1000mm"),
  /** 1100mm */
  EM_CHANNEL_WIDTH_1100(5, "1100mm"),
  /** 1200mm */
  EM_CHANNEL_WIDTH_1200(6, "1200mm");
  private int emWidth;
  private String desc;

  EM_CHANNEL_WIDTH(int emWidth, String desc) {
    this.emWidth = emWidth;
    this.desc = desc;
  }

  public int getEmWidth() {
    return emWidth;
  }

  public void setEmWidth(int emWidth) {
    this.emWidth = emWidth;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }
  public static EM_CHANNEL_WIDTH getChannelWidth(int emWidth){
    for (EM_CHANNEL_WIDTH channelWidth :EM_CHANNEL_WIDTH.values() ) {
        if(channelWidth.emWidth==emWidth){
          return channelWidth;
        }
    }
    return EM_CHANNEL_WIDTH_UNKNOWN;
  }
}
