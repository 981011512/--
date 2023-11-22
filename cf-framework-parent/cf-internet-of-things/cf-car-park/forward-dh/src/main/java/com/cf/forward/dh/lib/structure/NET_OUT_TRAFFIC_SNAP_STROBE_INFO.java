package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 251823
 * @description 智能交通外接道闸信息出参
 * @date 2020/12/14
 */
public class NET_OUT_TRAFFIC_SNAP_STROBE_INFO extends NetSDKLib.SdkStructure{
	
	/**
	 * 结构体大小
	 * */
	public int dwSize;
	
	/**
	 * 设备编号
	 * */
	public byte[] szSerialNo = new byte[128];
	
	/**
	 * 生产厂商
	 * */
	public byte[] szVendor = new byte[32];
	
	/**
	 * 设备型号 
	 * */
	public byte[] szDevType = new byte[32];
	
	/**
	 * 工作状态 { @link EM_TRAFFIC_SNAP_DEVICE_WORK_STATE}
	 * */
	public int emWorkState;
	
	/**
	 * 故障代码{ @link EM_TRAFFIC_SNAP_STROBE_FAULT_CODE_TYPE}
	 * */
	public int emFaultCode;
	
	/**
	 * 出厂后开闸运行次数(开闸算一次，关闸不算)	
	 * */
	public int nOpenStrobeCount;
	
	/**
	 * 运行状态{ @link EM_TRAFFIC_SNAP_STROBE_RUN_STATE}
	 * */
	public int emRunState;
	
	/**
	 * 道闸开关闸原因{ @link EM_TRAFFIC_SNAP_STROBE_ACTION_REASON_TYPE }
	 * */
	public int emStrobeActionReason;
	
	/**
	 * 强继电器状态{  @link EM_RELAY_STATE_TYPE	}
	 * */
	public int emHeavyCurrentRelayState;
	
	/**
	 * 信号继电器1{  @link EM_RELAY_STATE_TYPE	}
	 * */
	public int emSignalRelay1State;
	
	/**
	 * 信号继电器2{  @link EM_RELAY_STATE_TYPE	}
	 * */
	public int emSignalRelay2State;
	
	/**
	 * 地感输入信号{ @link EM_TRAFFIC_SNAP_GROUND_SENSE_IN_STATE_TYPE}
	 * */
	public int emGroundSenseInState;
	
	/**
	 * 开闸输入状态{ @link EM_TRAFFIC_SNAP_STROBE_IN_STATE_TYPE}
	 * */
	public int emStrobeInPutState;
	
	/**
	 * 栏杆状态{ @link EM_TRAFFIC_SNAP_STROBE_RAIL_STATE_TYPE}
	 * */
	public int emRailState;
	
	/**
	 * 串口号（连接相机的端口号）
	 * */
	public int nCommPort;
	
	/**
	  * 保留字节 
	  * */
	public byte[] byReserved = new byte[1020];	 
	 
	public NET_OUT_TRAFFIC_SNAP_STROBE_INFO() {
		  this.dwSize = this.size();
	}
	
}
