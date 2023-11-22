package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 251823
 * @description MEDIAFILE_ANATOMY_TEMP_DETECT_INFO 中 nEventType 为 EVENT_IVS_ANATOMY_TEMP_DETECT 时，pEventData 类型
 * @date 2021/02/22
 */
public class NET_ANATOMY_TEMP_DETECT_ANATOMYTEMPDETECT_RESULT extends NetSDKLib.SdkStructure {
	/**
	 * 预留字段
	 */
	public byte[] byReserved = new byte[1024];

}
