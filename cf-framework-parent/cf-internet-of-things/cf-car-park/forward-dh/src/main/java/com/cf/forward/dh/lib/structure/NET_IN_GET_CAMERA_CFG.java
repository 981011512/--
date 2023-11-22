package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
/**
 * @author 251823
 * @version 1.0
 * @description {@link NetSDKLib#CLIENT_GetCameraCfg}的入参
 * @date 2020/11/06
 */
public class NET_IN_GET_CAMERA_CFG extends NetSDKLib.SdkStructure{
	
	
	// 结构体大小
	public int dwSize;
	   
	// 相机编号
	public int nCameraNo;
		
	public NET_IN_GET_CAMERA_CFG() {
	  this.dwSize = this.size();
	}

}
