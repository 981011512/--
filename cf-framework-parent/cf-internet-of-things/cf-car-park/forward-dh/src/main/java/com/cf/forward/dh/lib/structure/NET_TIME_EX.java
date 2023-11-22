package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 47081
 * @version 1.0
 * @description \if ENGLISH_LANG
 *     <p>\else
 *     <p>\endif
 * @date 2020/8/11
 */
public class NET_TIME_EX extends NetSDKLib.SdkStructure {
  /** 年 */
  public int dwYear;
  /** 月 */
  public int dwMonth;
  /** 日 */
  public int dwDay;
  /** 时 */
  public int dwHour;
  /** 分 */
  public int dwMinute;
  /** 秒 */
  public int dwSecond;
  /** 毫秒 */
  public int dwMillisecond;
  /** utc时间(获取时0表示无效，非0有效 下发无效) */
  public int dwUTC;
  /** 保留字段 */
  public int[] dwReserved = new int[1];

  public void setTime(int year, int month, int day, int hour, int minute, int second) {
    this.dwYear = year;
    this.dwMonth = month;
    this.dwDay = day;
    this.dwHour = hour;
    this.dwMinute = minute;
    this.dwSecond = second;
    this.dwMillisecond = 0;
  }

  public String toString() {
    return dwYear + "/" + dwMonth + "/" + dwDay + " " + dwHour + ":" + dwMinute + ":" + dwSecond;
  }

  // 用于列表中显示
  public String toStringTime() {
    return String.format(
        "%02d/%02d/%02d %02d:%02d:%02d", dwYear, dwMonth, dwDay, dwHour, dwMinute, dwSecond);
  }

  // 存储文件名使用
  public String toStringTitle() {
    return String.format(
        "Time_%02d%02d%02d_%02d%02d%02d", dwYear, dwMonth, dwDay, dwHour, dwMinute, dwSecond);
  }
}
