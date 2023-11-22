package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 251823
 * @description 智能交通外接雷达信息入参
 * @date 2020/12/14
 */
public class NET_IN_TRAFFIC_SNAP_RADAR_INFO extends NetSDKLib.SdkStructure{
	
	/**
	 * 结构体大小
	 * */
	public int dwSize;
	   
	/**
	 * 通道号
	 * */ 
	public int nChannel;
		
	public NET_IN_TRAFFIC_SNAP_RADAR_INFO() {
	  this.dwSize = this.size();
	}

}
