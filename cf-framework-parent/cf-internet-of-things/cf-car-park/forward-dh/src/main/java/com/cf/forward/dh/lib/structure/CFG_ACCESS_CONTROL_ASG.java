package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.enumeration.*;

/**
 * @author 47081
 * @version 1.0
 * @description 门通道控制闸机参数
 * @date 2021/2/7
 */
public class CFG_ACCESS_CONTROL_ASG extends NetSDKLib.SdkStructure {
  /** 通行模式,{@link com.cf.forward.dh.lib.enumeration.EM_PASS_MODE} */
  public int emPassMode;
  /** 开门速度档位, 范围:0-7,对应1-8档 */
  public int nOpenDoorSpeed;
  /** 通行超时时间, 范围:2-60,单位：秒 */
  public int nPassTimeOut;
  /** 延时关门时间, 范围:0-60,单位：秒 */
  public int nCloseDelayTime;
  /** 闸机安全等级, 范围:0-4,对应1-5级 */
  public int nSecurityLevel;
  /** 二次开启功能开关;False：关闭,True：开启 */
  public boolean bSecondOpenEnable;
  /** 记忆功能开关;False：关闭,True：开启 */
  public boolean bMemoryModeEnable;
  /** 闸机防冲撞模式,参考枚举{@link EM_COLLISION_MODE} */
  public int emCollisionMode;
  /** 设备音量等级共8档, 范围:0-7, 0级表示静音 */
  public int nVolumeLevel;
  /** 闸机断电以后门摆动放向,{@link com.cf.forward.dh.lib.enumeration.EM_DIRECTION_AFTER_POWER_OFF} */
  public int emDirectionAfterPowerOff;
  /** 工作模式,{@link EM_ASG_WORK_MODE} */
  public int emWorkMode; // 工作模式
  /** 启动模式,{@link EM_STARTUP_MODE} */
  public int emStartUpMode;
  /** 主机侧门翼零位微调角度，进门方向右手边为主机侧门翼 */
  public int nMasterWingAngleAdjust;
  /** 从机侧门翼零位微调角度，进门方向左手边为从机侧门翼 */
  public int nSlaveWingAngleAdjust;
  /** 闸机类型,{@link EM_GATE_TYPE} */
  public int emGateType;
  /** 通道宽度,{@link EM_CHANNEL_WIDTH} */
  public int emChannelWidth;
  /** bSecondOpenEnable作用时间段，AccessTimeSchedule 配置索引 */
  public int nSecondOpenTimeSection;
  /** bMemoryModeEnable作用时间段，AccessTimeSchedule 配置索引 */
  public int nMemoryModeTimeSection;
  /** emWorkMode作用时间段，AccessTimeSchedule 配置索引 */
  public int nWorkModeTimeSection;
  /** 是否清理通行人数 */
  public boolean bClearPassNum;
  /** 保留字节 */
  public byte[] byReserved = new byte[112];
}
