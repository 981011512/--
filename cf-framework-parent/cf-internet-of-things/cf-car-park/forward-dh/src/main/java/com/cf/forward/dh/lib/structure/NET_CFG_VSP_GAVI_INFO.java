package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib.SdkStructure;
/**
 * @author 119178
 * @description 公安视频图像信息应用系统接入配置(对应枚举值 {@link NET_EM_CFG_OPERATE_TYPE})
 * @date 2020/6/9
 */
public class NET_CFG_VSP_GAVI_INFO extends SdkStructure{
	/**
	 *  结构体大小
	 */
	public int						dwSize;		
	/**
	 *  注册平台个数
	 */
	public int							nGaviInfoCount;         		
	/**
	 * 注册平台信息
	 */
	public NET_VSP_GAVI_INFO[]			stuGaviInfo=(NET_VSP_GAVI_INFO[])new NET_VSP_GAVI_INFO().toArray(16); 
	/**
	 * stuPlatformInfo个数
	 */
	public int							nPlatformCount;		
	/**
	 * 接入平台范围信息，不允许修改
	 */
	public NET_VSP_GAVI_PLATFORM_INFO[]  stuPlatformInfo =(NET_VSP_GAVI_PLATFORM_INFO[])new NET_VSP_GAVI_PLATFORM_INFO().toArray(64);				
	
	public NET_CFG_VSP_GAVI_INFO()
    {
        this.dwSize = this.size();
    }
}
