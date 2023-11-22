package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 47081
 * @version 1.0
 * @description 测温信息
 * @date 2021/2/23
 */
public class NET_CUSTOM_MEASURE_TEMPER extends NetSDKLib.SdkStructure {
  /** 车辆左侧温度值 */
  public float fLeft;
  /** 车辆右侧温度值 */
  public float fRight;
  /** 车辆发动机位置温度值 (车头) */
  public float fHead;
  /** 温度单位,对应枚举{@link NetSDKLib.EM_TEMPERATURE_UNIT} */
  public int emUnit;
}
