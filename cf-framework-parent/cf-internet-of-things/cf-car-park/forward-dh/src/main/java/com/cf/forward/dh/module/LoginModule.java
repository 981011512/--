package com.cf.forward.dh.module;

import com.cf.forward.dh.config.CameraConfig;
import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.ToolKits;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 登陆接口实现
 * 主要有 ：初始化、登陆、登出功能
 */
public class LoginModule {

	public static NetSDKLib netsdk 		= NetSDKLib.NETSDK_INSTANCE;
	public static NetSDKLib configsdk 	= NetSDKLib.CONFIG_INSTANCE;

	// 设备信息
	public static NetSDKLib.NET_DEVICEINFO_Ex m_stDeviceInfo = new NetSDKLib.NET_DEVICEINFO_Ex();

	// 登陆句柄
	public static Map<String, NetSDKLib.LLong> m_hLoginHandleList = new HashMap<>();

	//序列号和事件订阅句柄对应关系
	public static Map<Long, String> uuidTologinHandleList = new HashMap<>();

	private static boolean bInit    = false;
	private static boolean bLogopen = false;

	/**
	 * \if ENGLISH_LANG
	 * Init
	 * \else
	 * 初始化
	 * \endif
	 */
	public static boolean init(NetSDKLib.fDisConnect disConnect, NetSDKLib.fHaveReConnect haveReConnect) {
		bInit = netsdk.CLIENT_Init(disConnect, null);
		if(!bInit) {
			System.out.println("Initialize SDK failed");
			return false;
		}

		//打开日志，可选
		NetSDKLib.LOG_SET_PRINT_INFO setLog = new NetSDKLib.LOG_SET_PRINT_INFO();
        File path = new File(CameraConfig.logPath);
        if (!path.exists()) {
            path.mkdir();
        }
//		String logPath = path.getAbsoluteFile().getParent() + "\\sdklog\\" + ToolKits.getDate() + ".log";
		String logPath = CameraConfig.getDllPath() + "log/dh-sdk-log/" + ToolKits.getDate() + ".log";
		setLog.nPrintStrategy = 0;
		setLog.bSetFilePath = 1;
		System.arraycopy(logPath.getBytes(), 0, setLog.szLogFilePath, 0, logPath.getBytes().length);
		System.out.println(logPath);
		setLog.bSetPrintStrategy = 1;
		bLogopen = netsdk.CLIENT_LogOpen(setLog);
		if(!bLogopen ) {
			System.err.println("Failed to open NetSDK log");
		}

		// 设置断线重连回调接口，设置过断线重连成功回调函数后，当设备出现断线情况，SDK内部会自动进行重连操作
		// 此操作为可选操作，但建议用户进行设置
		netsdk.CLIENT_SetAutoReconnect(haveReConnect, null);

		//设置登录超时时间和尝试次数，可选
		int waitTime = 5000; //登录请求响应超时时间设置为5S
		int tryTimes = 1;    //登录时尝试建立链接1次
		netsdk.CLIENT_SetConnectTime(waitTime, tryTimes);


		// 设置更多网络参数，NET_PARAM的nWaittime，nConnectTryNum成员与CLIENT_SetConnectTime
		// 接口设置的登录设备超时时间和尝试次数意义相同,可选
		NetSDKLib.NET_PARAM netParam = new NetSDKLib.NET_PARAM();
		netParam.nConnectTime = 10000;      // 登录时尝试建立链接的超时时间
		netParam.nGetConnInfoTime = 3000;   // 设置子连接的超时时间
		netsdk.CLIENT_SetNetworkParam(netParam);

		return true;
	}

	/**
	 * \if ENGLISH_LANG
	 * CleanUp
	 * \else
	 * 清除环境
	 * \endif
	 */
	public static void cleanup() {
		if(bLogopen) {
			netsdk.CLIENT_LogClose();
		}

		if(bInit) {
			netsdk.CLIENT_Cleanup();
		}
	}

	/**
	 * \if ENGLISH_LANG
	 * Login Device
	 * \else
	 * 登录设备
	 * \endif
	 */
	public static boolean login(String m_strIp, int m_nPort, String m_strUser, String m_strPassword, String uuid) {
		//IntByReference nError = new IntByReference(0);
		//入参
		NetSDKLib.NET_IN_LOGIN_WITH_HIGHLEVEL_SECURITY pstInParam=new NetSDKLib.NET_IN_LOGIN_WITH_HIGHLEVEL_SECURITY();
		pstInParam.nPort=m_nPort;
		pstInParam.szIP=m_strIp.getBytes();
		pstInParam.szPassword=m_strPassword.getBytes();
		pstInParam.szUserName=m_strUser.getBytes();
		//出参
		NetSDKLib.NET_OUT_LOGIN_WITH_HIGHLEVEL_SECURITY pstOutParam=new NetSDKLib.NET_OUT_LOGIN_WITH_HIGHLEVEL_SECURITY();
		pstOutParam.stuDeviceInfo=m_stDeviceInfo;
		//m_hLoginHandle = netsdk.CLIENT_LoginEx2(m_strIp, m_nPort, m_strUser, m_strPassword, 0, null, m_stDeviceInfo, nError);
//		new NetSDKLib.LLong(0)
		if(m_hLoginHandleList.get(uuid)==null){
			m_hLoginHandleList.put(uuid, netsdk.CLIENT_LoginWithHighLevelSecurity(pstInParam, pstOutParam));
		}else{
			return false;
		}
		if(m_hLoginHandleList.get(uuid).longValue() == 0) {
			System.err.printf("Login Device[%s] Port[%d]Failed. %s\n", m_strIp, m_nPort, "");
		} else {
			System.out.println("Login Success [ " + m_strIp + " ]");
		}

		return m_hLoginHandleList.get(uuid).longValue() == 0? false:true;
	}
}
