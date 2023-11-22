package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 251823
 * @description 道闸栏状态事件(对应结构体 ALARM_TRAFFICSTROBESTATE_INFO)
 * @date 2020/12/15
 */
public class ALARM_TRAFFICSTROBESTATE_INFO extends NetSDKLib.SdkStructure {

	/**
	 * 事件动作,0表示脉冲事件,1表示持续性事件开始,2表示持续性事件结束
	 */
	public byte bEventAction;

	/**
	 * 事件发生时间
	 */
	public NET_TIME stuTime;

	/**
	 * 视频通道号
	 */
	public int nChannelID;

	/**
	 * 道闸栏状态{ @link EM_TRAFFICSTROBE_STATUS}
	 */
	public int emStatus;

	/**
	 * 道闸开关闸原因{ @link EM_TRAFFIC_SNAP_STROBE_ACTION_REASON_TYPE}
	 */
	public int emStrobeActionReason;

	/**
	 * 预留字段
	 */
	public byte[] byReserved = new byte[1020];

}
