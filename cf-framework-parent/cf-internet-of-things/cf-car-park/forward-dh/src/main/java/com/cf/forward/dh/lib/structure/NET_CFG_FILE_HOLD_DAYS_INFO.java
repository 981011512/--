package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib.SdkStructure;

/**
 * 录像保存天数配置 (对应枚举 {@link NET_EM_CFG_FILE_HOLD_DAYS} )
 * @author 29779
 */
public class NET_CFG_FILE_HOLD_DAYS_INFO extends SdkStructure {
	public int               dwSize;
	
	/**
	 * 设置文件的保留天数，超过时间的将被删除，单位:天，取值范围0-65535，0表示没有天数限制
	 */
	public int               nDays;
	
	public NET_CFG_FILE_HOLD_DAYS_INFO() {
		this.dwSize = this.size();
	}
}
