package com.cf.forward.dh.lib.enumeration;

/**
 * @author 47081
 * @version 1.0
 * @description 输出有效模式
 * @date 2021/2/22
 */
public enum EM_ALARMOUT_POLE {
  /** 未知 */
  EM_ALARMOUT_POLE_UNKNOWN,
  /** 低电平有效 */
  EM_ALARMOUT_POLE_LOW,
  /** 高电平有效 */
  EM_ALARMOUT_POLE_HIGH;

  public static EM_ALARMOUT_POLE getAlarmOutPole(int pole) {
    for (EM_ALARMOUT_POLE alarmOutPole : EM_ALARMOUT_POLE.values()) {
      if (alarmOutPole.ordinal() == pole) {
        return alarmOutPole;
      }
    }
    return EM_ALARMOUT_POLE_UNKNOWN;
  }
}
