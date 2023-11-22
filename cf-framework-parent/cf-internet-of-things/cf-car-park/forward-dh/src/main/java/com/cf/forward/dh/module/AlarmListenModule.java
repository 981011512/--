package com.cf.forward.dh.module;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.NetSDKLib.fMessCallBack;
import com.cf.forward.dh.lib.ToolKits;
import com.cf.forward.dh.listener.AlarmListener;

/**
 * \if ENGLISH_LANG
 * alarm listen interface
 * contains: start and stop alarm listen
 * \else
 * 报警接口实现
 * 包含 ：向设备订阅报警和停止订阅报警
 * \endif
 */
public class AlarmListenModule {

	private static boolean bListening = false;

	// 智能订阅句柄
	public static NetSDKLib.LLong m_hAttachHandle = new NetSDKLib.LLong(0);

	/**
	 * \if ENGLISH_LANG
	 * start alarm listen
	 * \else
	 * 向设备订阅报警
	 * \endif
	 */
	public static boolean startListen(AlarmListener.AnalyzerDataCB analyzerDataCB, String uuid) {

		/**
		 * 说明：
		 * 	通道数可以在有登录是返回的信息 m_stDeviceInfo.byChanNum 获取
		 *  下列仅订阅了0通道的智能事件.
		 */
		int bNeedPicture = 1; // 是否需要图片

		m_hAttachHandle = LoginModule.netsdk.CLIENT_RealLoadPictureEx(LoginModule.m_hLoginHandleList.get(uuid), 0,  NetSDKLib.EVENT_IVS_ALL,
				bNeedPicture , analyzerDataCB , null , null);
		if( m_hAttachHandle.longValue() != 0  ) {
			System.out.println("CLIENT_RealLoadPictureEx Success  ChannelId : \n" + 0);
		} else {
			System.err.println("CLIENT_RealLoadPictureEx Failed!" + ToolKits.getErrorCodePrint());
			return false;
		}
		LoginModule.uuidTologinHandleList.put(m_hAttachHandle.longValue(),uuid);
		return true;
	}
	
	/**
	 * \if ENGLISH_LANG
	 * stop alarm listen
	 * \else
	 * 停止订阅报警
	 * \endif
	 */
	public static boolean stopListen() {

		if (!bListening) {
			return true;
		}
		
//	   	if (!LoginModule.netsdk.CLIENT_StopListen(LoginModule.m_hLoginHandle)) {
//			System.err.printf("CLIENT_StopListen Failed!");
//			return false;
//		} else {
//			System.out.println("CLIENT_StopListen success.");
//		}
	   	
	   	bListening = false;	
		return true;
	}

}	
	



