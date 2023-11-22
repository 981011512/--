package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
/**
 * @author 251823
 * @description 设备安装位置的GPS坐标信息 
 * @date 2021/02/01
 */
public class CFG_DEVLOCATION_INFO extends NetSDKLib.SdkStructure{
	
	/**
	 * 经度 单位百万分之一度，范围0-360度
	 */
	public int unLongitude;
	
	/**
	 * 纬度 单位百万分之一度，范围0-360度
	 */
	public int unLatitude;
	
	/**
	 * 海拔 单位米
	 */
	public double dbAltitude;
	
	/**
	 * GPS信息按照配置上报
	 */
	public int bConfigEnable;
	
	/**
	 * 设备高度 单位米
	 */
	public float fHeight;
	
	
	
	

}
