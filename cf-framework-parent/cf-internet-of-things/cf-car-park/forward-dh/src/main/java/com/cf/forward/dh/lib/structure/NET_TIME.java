package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

import java.util.Calendar;
import java.util.Date;

/**
 * 时间
 *
 * @author 47081
 */
public class NET_TIME extends NetSDKLib.SdkStructure {
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

  public NET_TIME() {
    super();
  }

  public NET_TIME(int dwYear, int dwMonth, int dwDay, int dwHour, int dwMinute, int dwSecond) {
    this.dwYear = dwYear;
    this.dwMonth = dwMonth;
    this.dwDay = dwDay;
    this.dwHour = dwHour;
    this.dwMinute = dwMinute;
    this.dwSecond = dwSecond;
  }

  /**
   * 字符串解析时间
   *
   * @param date 时间字符串,举例2020/5/20/12/20/34
   */
  public NET_TIME(String date) {
    String[] dates = date.split("/");
    this.dwYear = Integer.parseInt(dates[0]);
    this.dwMonth = Integer.parseInt(dates[1]);
    this.dwDay = Integer.parseInt(dates[2]);
    this.dwHour = Integer.parseInt(dates[3]);
    this.dwMinute = Integer.parseInt(dates[4]);
    this.dwSecond = Integer.parseInt(dates[5]);
  }

  // 用于列表中显示
  public String toStringTime() {
    return String.format(
        "%02d/%02d/%02d %02d:%02d:%02d", dwYear, dwMonth, dwDay, dwHour, dwMinute, dwSecond);
  }

  public String toStringTimeEx() {
    return String.format(
        "%02d-%02d-%02d %02d:%02d:%02d", dwYear, dwMonth, dwDay, dwHour, dwMinute, dwSecond);
  }

  public String toString() {
    return String.format(
        "%02d%02d%02d%02d%02d%02d", dwYear, dwMonth, dwDay, dwHour, dwMinute, dwSecond);
  }

  public Date toDate() {
    Calendar instance = Calendar.getInstance();
    instance.set(this.dwYear, this.dwMonth, this.dwDay, this.dwHour, this.dwMinute, this.dwSecond);
    return instance.getTime();
  }
}
