package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 251823
 * @description 签名灯信息
 * @date 2020/11/06
 */
public class NET_VIDEOTALK_SIGNLIGHT_INFO extends NetSDKLib.SdkStructure{
	
	/**
	 * 灯光类型
	 * */
	public int emSignLightType; //@link EM_SIGNLIGHT_TYPE
	
	/**
	 * 有效时间段个数
	 * */
	public int nTimeSectionsNum;
		
	/**
	 * 抓拍时间段
	 * */	
	public NetSDKLib.NET_TSECT[] stuTimeSection = new NetSDKLib.NET_TSECT[6];
			
	/**
	 * 预留字节
	 * */
	public byte[] bReserved = new byte[64];
	
	
	public NET_VIDEOTALK_SIGNLIGHT_INFO() {
        for (int i = 0; i < stuTimeSection.length; i++) {
        	stuTimeSection[i] = new NetSDKLib.NET_TSECT();
        }
    }		

}
