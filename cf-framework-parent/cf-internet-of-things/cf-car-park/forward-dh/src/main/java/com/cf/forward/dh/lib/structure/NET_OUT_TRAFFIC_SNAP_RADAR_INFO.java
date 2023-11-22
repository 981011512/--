package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.NetSDKLib.NET_POINT;

/**
 * @author 251823
 * @description 查询智能交通外接雷达信息出参
 * @date 2020/12/14
 */
public class NET_OUT_TRAFFIC_SNAP_RADAR_INFO extends NetSDKLib.SdkStructure{
	
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
	 * 线圈匹配状态{ @link EM_TRAFFIC_SNAP_RADAR_COIL_MATCH_STATE}
	 * */
	public int emCoilMatch;
	
	/**
	 * 虚警坐标点信息
	 * */
	 public NET_POINT[] stuFakeAlarmPointInfo = (NET_POINT[])new NET_POINT().toArray(64);
	 	 
	 /**
	  * 实际返回虚警点个数
	  * */
	 public int nRetFakeAlarmPointNum;
	 
	 /**
	  * 继电器工作次数
	  * */
	 public int nRelayWorkCount;
	 
	 /**
	  * 检测汽车状态{ @link EM_TRAFFIC_SNAP_RADAR_DETECT_CAR_STATE}
	  * */
	 public int emDetectCarState;
	 
	 /**
	  * 串口号（连接相机的端口号）
	  * */
	 public int nCommPort;
	 
	 /**
	  * 保留字节 
	  * */
	 public byte[] byReserved = new byte[1020];	 	 

	 public NET_OUT_TRAFFIC_SNAP_RADAR_INFO() {
		 this.dwSize = this.size();
	 }
}
