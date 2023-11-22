package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 251823
 * @version 1.0
 * @description {@link NetSDKLib#CLIENT_GetCameraInfo}的出参
 * @date 2020/11/09
 */
public class NET_OUT_GET_CAMERA_INFO extends NetSDKLib.SdkStructure {

	// 结构体大小
	public int dwSize;

	// 相机编号
	public int nCameraNo;

	// 相机连接状态{@link EM_CAMERA_CONNECT_STATE}
	public int emConnectState;

	// 返回的红绿灯通道数
	public int nRetLightInfoNum;

	// 相机对应的红绿灯通道状态
	public NET_LIGHTINFO_CFG[] stuLightInfos = new NET_LIGHTINFO_CFG[16];

	public NET_OUT_GET_CAMERA_INFO() {
		for (int i = 0; i < stuLightInfos.length; i++) {
			stuLightInfos[i] = new NET_LIGHTINFO_CFG();
		}
		this.dwSize = this.size();
	}

}
