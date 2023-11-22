package com.cf.forward.dh.module;

import com.cf.forward.dh.entity.CameraInfo;
import com.cf.forward.dh.entity.LedContents;
import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.NetSDKLib.CtrlType;
import com.cf.forward.dh.lib.NetSDKLib.NET_TIME;
import com.cf.forward.dh.lib.ToolKits;
import com.cf.forward.dh.lib.enumeration.NET_EM_CFG_OPERATE_TYPE;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Map;


/**
 * \if ENGLISH_LANG
 * Device Control Interface
 * contains:reboot device、setup device time and query device time
 * \else
 * 设备控制接口实现
 * 包含: 重启、时间同步、获取时间功能
 * \endif
 */
public class DeviceControlModule {

	/**
	 * \if ENGLISH_LANG
	 * Reboot Device
	 * \else
	 * 重启设备
	 * \endif
	 */
    public static boolean reboot() {

//        if (!LoginModule.netsdk.CLIENT_ControlDevice(LoginModule.m_hLoginHandle, CtrlType.CTRLTYPE_CTRL_REBOOT, null, 3000)) {
//        	System.err.println("CLIENT_ControlDevice Failed!");
//    		return false;
//        }
        return true;
    }

    /**
	 * \if ENGLISH_LANG
	 * Setup Device Time
	 * \else
	 * 时间同步
	 * \endif
	 */
    public static boolean setTime(String date) {
    	NET_TIME deviceTime = new NET_TIME();
    	if (date == null) {
    		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date = dateFormat.format(new java.util.Date());
    	}

    	String[] dateTime = date.split(" ");
        String[] arrDate = dateTime[0].split("-");
        String[] arrTime = dateTime[1].split(":");
        deviceTime.dwYear = Integer.parseInt(arrDate[0]);
        deviceTime.dwMonth = Integer.parseInt(arrDate[1]);
        deviceTime.dwDay = Integer.parseInt(arrDate[2]);
        deviceTime.dwHour = Integer.parseInt(arrTime[0]);
        deviceTime.dwMinute = Integer.parseInt(arrTime[1]);
        deviceTime.dwSecond = Integer.parseInt(arrTime[2]);

//        if (!LoginModule.netsdk.CLIENT_SetupDeviceTime(LoginModule.m_hLoginHandle, deviceTime)) {
//    		System.err.println("CLIENT_SetupDeviceTime Failed!");
//    		return false;
//        }
        return true;
    }

    /**
  	 * \if ENGLISH_LANG
  	 * Get Device Current Time
  	 * \else
  	 * 获取设备当前时间
  	 * \endif
  	 */
    public static String getTime() {
    	NET_TIME deviceTime = new NET_TIME();

//    	if (!LoginModule.netsdk.CLIENT_QueryDeviceTime(LoginModule.m_hLoginHandle, deviceTime, 3000)) {
//    		System.err.println("CLIENT_QueryDeviceTime Failed!");
//    		return null;
//    	}

    	String date = deviceTime.toStringTime();
    	date = date.replace("/", "-");

    	return date;
    }

	/**
	 * 开闸
	 */
	public static boolean New_OpenStrobe(CameraInfo cameraInfo) {
		NetSDKLib.NET_CTRL_OPEN_STROBE openStrobe = new NetSDKLib.NET_CTRL_OPEN_STROBE();
		openStrobe.nChannelId = 0;
//		String plate = new String("浙A12345");
		openStrobe.emOpenType = 2;

//		System.arraycopy(plate.getBytes(), 0, openStrobe.szPlateNumber, 0, plate.getBytes().length);
		openStrobe.write();
		if (LoginModule.netsdk.CLIENT_ControlDevice(LoginModule.m_hLoginHandleList.get(cameraInfo.getUuid()), NetSDKLib.CtrlType.CTRLTYPE_CTRL_OPEN_STROBE, openStrobe.getPointer(),  3000)) {
			System.out.println("Open Success!");
		} else {
			System.err.println("Failed to Open.");
			return false;
		}
		openStrobe.read();

		return true;
	}

	/**
	 * 关闸
	 * @param cameraInfo
	 */
	public static void New_CloseStrobe(CameraInfo cameraInfo) {
		NetSDKLib.NET_CTRL_CLOSE_STROBE closeStrobe = new NetSDKLib.NET_CTRL_CLOSE_STROBE();
		closeStrobe.nChannelId = 0;
		closeStrobe.write();
		if (LoginModule.netsdk.CLIENT_ControlDeviceEx(LoginModule.m_hLoginHandleList.get(cameraInfo.getUuid()), NetSDKLib.CtrlType.CTRLTYPE_CTRL_CLOSE_STROBE, closeStrobe.getPointer(), null, 3000)) {
			System.out.println("Close Success!");
		} else {
			System.err.println("Failed to Close.");
		}
		closeStrobe.read();
	}

	/**
	 * 抓拍
	 * @param cameraInfo
	 */
	public static void capture(CameraInfo cameraInfo) {
		NetSDKLib.NET_CTRL_CLOSE_STROBE closeStrobe = new NetSDKLib.NET_CTRL_CLOSE_STROBE();
		closeStrobe.nChannelId = 0;
		closeStrobe.write();
		if (LoginModule.netsdk.CLIENT_ControlDeviceEx(LoginModule.m_hLoginHandleList.get(cameraInfo.getUuid()), NetSDKLib.CtrlType.CTRLTYPE_MANUAL_SNAP, closeStrobe.getPointer(), null, 3000)) {
			System.out.println("capture Success!");
		} else {
			System.err.println("capture to Close.");
		}
		closeStrobe.read();
	}

	/**
	 * 播放语音和显示文字
	 */
	public static void playVoice(LedContents ledContents, CameraInfo cameraInfo) throws Exception {
		if(StringUtils.isEmpty(ledContents.getContents1())){
			return;
		}
		int emType=NetSDKLib.CtrlType.CTRLTYPE_CTRL_SET_PARK_INFO;

		NetSDKLib.NET_CTRL_SET_PARK_INFO msg = new NetSDKLib.NET_CTRL_SET_PARK_INFO();

		msg.szPlateNumber = new String(ledContents.getContents1()).getBytes("GBK");
		msg.nParkTime = 60;	//设置停车时长，单位分钟
		msg.szMasterofCar = new String(ledContents.getContents2()).getBytes("GBK");	//车主名称
		msg.szUserType = new String(ledContents.getVoiceContents()).getBytes("GBK");	//用户身份
//		msg.nRemainDay = 30;	//剩余天数
		msg.nPassEnable = 1;	//0:不允许车辆通过 1:允许车辆通过

		//设置入场时间
//		msg.stuInTime.dwYear = 2022;
//		msg.stuInTime.dwMonth = 4;
//		msg.stuInTime.dwDay = 23;
//		msg.stuInTime.dwHour = 8;
//		msg.stuInTime.dwMinute = 42;
//		msg.stuInTime.dwSecond = 1;
		//设置出场时间
//		msg.stuOutTime.dwYear = 2022;
//		msg.stuOutTime.dwMonth = 4;
//		msg.stuOutTime.dwDay = 26;
//		msg.stuOutTime.dwHour = 17;
//		msg.stuOutTime.dwMinute = 26;
//		msg.stuOutTime.dwSecond = 13;

//		msg.szParkCharge = new String("66.3").getBytes("GBK");	//停车费
//		msg.nRemainSpace = 12;	//剩余车位

		msg.emCarStatus=1;	//过车状态 	0;   // 未知状态；1;   // 过车状态；2;   // 无车状态
//		msg.szSubUserType = new String("临时车").getBytes("GBK");	//用户类型
		msg.szRemarks = new String(ledContents.getContents3()).getBytes("GBK");	//备注信息
		msg.szCustom = new String(ledContents.getContents4()).getBytes("GBK");	//自定义信息

		msg.write();
		if (LoginModule.netsdk.CLIENT_ControlDevice(LoginModule.m_hLoginHandleList.get(cameraInfo.getUuid()), emType, msg.getPointer(), 3000)) {
			System.out.println("Play Success!");
		} else {
			System.err.println("Failed to Play.");
		}
	}
}
