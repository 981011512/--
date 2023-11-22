package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

import java.util.Arrays;

import static com.cf.forward.dh.lib.constant.SDKStructureFieldLenth.MAX_ADDRESS_LEN;
import static com.cf.forward.dh.lib.constant.SDKStructureFieldLenth.MAX_PASSWORD_LEN;

/**
 * @author 47081
 * @version 1.0
 * @description 门禁基本配置
 * @date 2021/2/7
 */
public class CFG_ACCESS_GENERAL_INFO extends NetSDKLib.SdkStructure {
  /** 开门音频文件路径 */
  public byte[] szOpenDoorAudioPath = new byte[MAX_ADDRESS_LEN];
  /** 关门音频文件路径 */
  public byte[] szCloseDoorAudioPath = new byte[MAX_ADDRESS_LEN];
  /** 有人音频文件路径 */
  public byte[] szInUsedAuidoPath = new byte[MAX_ADDRESS_LEN];
  /** 暂停使用音频文件路径 */
  public byte[] szPauseUsedAudioPath = new byte[MAX_ADDRESS_LEN];
  /** 门未关音频文件路径 */
  public byte[] szNotClosedAudioPath = new byte[MAX_ADDRESS_LEN];
  /** 等待提示音频文件路径 */
  public byte[] szWaitingAudioPath = new byte[MAX_ADDRESS_LEN];
  /** 开锁命令响应间隔时间,单位秒，取值10、15(默认值)、20 */
  public int nUnlockReloadTime;
  /** 开锁输出保持时间,单位秒，取值1、2(默认)、3、4、5、6、9、15。 */
  public int nUnlockHoldTime;

  // 能力,bool对应java中byte
  public byte abProjectPassword;
  public byte abAccessProperty;
  public byte abABLockInfo;
  public byte byReserved;

  /** 工程密码 */
  public byte[] szProjectPassword = new byte[MAX_PASSWORD_LEN];
  /** 门禁通道单双向配置,对应枚举{@link com.cf.forward.dh.lib.enumeration.CFG_ACCESS_PROPERTY_TYPE} */
  public int emAccessProperty;
  /** AB互锁信息 */
  public CFG_ABLOCK_INFO stuABLockInfo;
  /** 胁迫密码 */
  public byte[] szDuressPassword = new byte[MAX_PASSWORD_LEN];
  /** 胁迫使能 */
  public boolean bDuressEnable;
  /** 是否启用个性化密码 */
  public boolean bCustomPasswordEnable;
  /** 公共密码 */
  public byte[] szCommonPassword = new byte[MAX_PASSWORD_LEN];
  /** 梯控高峰时间段, 值为CFG_ACCESS_TIMESCHEDULE_INFO配置的数组下标 */
  public int nPeakTimeSection;
  /** 是否为梯控高峰期, TRUE:高峰期, FALSE:平峰期 */
  public boolean bPeakState;
  /** 远程校验超时时间,单位:秒, 默认值:5秒，范围[1-15] */
  public int nRemoteAuthTimeOut;
  /** 楼层权限信息，每一个bit对应一个楼层，bit值1表示公共层，0表示权限楼层 */
  public byte[] arrFloorPermission = new byte[64];
  /** arrFloorPermission 数组个数 */
  public int nFloorPermission;
  /** 门通道控制闸机参数 */
  public CFG_ACCESS_CONTROL_ASG stuAccessControlASG;
  /** 门禁开门提示音 */
  public CFG_ACCESS_VOICE stuAccessVoice;

  @Override
  public String toString() {
    return "CFG_ACCESS_GENERAL_INFO{" +
            "szOpenDoorAudioPath=" + Arrays.toString(szOpenDoorAudioPath) +
            ", szCloseDoorAudioPath=" + Arrays.toString(szCloseDoorAudioPath) +
            ", szInUsedAuidoPath=" + Arrays.toString(szInUsedAuidoPath) +
            ", szPauseUsedAudioPath=" + Arrays.toString(szPauseUsedAudioPath) +
            ", szNotClosedAudioPath=" + Arrays.toString(szNotClosedAudioPath) +
            ", szWaitingAudioPath=" + Arrays.toString(szWaitingAudioPath) +
            ", nUnlockReloadTime=" + nUnlockReloadTime +
            ", nUnlockHoldTime=" + nUnlockHoldTime +
            ", abProjectPassword=" + abProjectPassword +
            ", abAccessProperty=" + abAccessProperty +
            ", abABLockInfo=" + abABLockInfo +
            ", byReserved=" + byReserved +
            ", szProjectPassword=" + Arrays.toString(szProjectPassword) +
            ", emAccessProperty=" + emAccessProperty +
            ", stuABLockInfo=" + stuABLockInfo +
            ", szDuressPassword=" + Arrays.toString(szDuressPassword) +
            ", bDuressEnable=" + bDuressEnable +
            ", bCustomPasswordEnable=" + bCustomPasswordEnable +
            ", szCommonPassword=" + Arrays.toString(szCommonPassword) +
            ", nPeakTimeSection=" + nPeakTimeSection +
            ", bPeakState=" + bPeakState +
            ", nRemoteAuthTimeOut=" + nRemoteAuthTimeOut +
            ", arrFloorPermission=" + Arrays.toString(arrFloorPermission) +
            ", nFloorPermission=" + nFloorPermission +
            ", stuAccessControlASG=" + stuAccessControlASG +
            ", stuAccessVoice=" + stuAccessVoice +
            '}';
  }
}
