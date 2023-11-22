package com.cf.forward.dh.common;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.NetSDKLib.*;

import java.util.Locale;
import java.util.ResourceBundle;

public final class Res {
	
	private static ResourceBundle bundle;
	
	private Res() {
		switchLanguage(LanguageType.Chinese);
	}

	private static class StringBundleHolder {
		private static Res instance = new Res();
	}
	
	public static Res string() {
		return StringBundleHolder.instance;
	}
	
	public static enum LanguageType {
		English,
		Chinese
	}
	
	public ResourceBundle getBundle() {
		return bundle;
	}
	
	/**
	 * \if ENGLISH_LANG
	 * Switch between Chinese and English
	 * \else
	 * 中英文切换
	 * \endif
	 */
	public void switchLanguage(LanguageType type) {
		switch(type) {
			case Chinese:
				bundle = ResourceBundle.getBundle("res", new Locale("zh", "CN"));
				break;
			case English:
				bundle = ResourceBundle.getBundle("res", new Locale("en", "US"));
				break;
			default:
				break;
		}
	}
	
	public String getSwitchLanguage() {
		return bundle.getString("SWITCH_LANGUAGE");
	}
	
	public String getRealplay() {
		return bundle.getString("REALPLAY");
	}
	
	public String getMultiRealplay() {
		return bundle.getString("MULTIREALPLAY");
	}
	
	public String getDownloadRecord() {
		return bundle.getString("DOWNLOAD_RECORD");
	}
	
	public String getITSEvent() {
		return bundle.getString("ITS_EVENT");
	}
	
	public String getOnline() {
		return bundle.getString("ONLINE");
	}
	
	public String getDisConnectReconnecting() {
		return bundle.getString("DISCONNECT_RECONNECTING");
	}
	
	public String getDisConnect() {
		return bundle.getString("DISCONNECT");
	}
	
	public String getPromptMessage() {
		return bundle.getString("PROMPT_MESSAGE");
	}
	
	public String getErrorMessage() {
		return bundle.getString("ERROR_MESSAGE");
	}
	
	public String getReconnectSucceed() {
		return bundle.getString("RECONNECT_SUCCEED");
	}
	
	public String getSucceed() {
		return bundle.getString("SUCCEED");
	}
	
	public String getFailed() {
		return bundle.getString("FAILED");
	}
	
	public String getYear() {
		return bundle.getString("YEAR");
	}
	
	public String getMonth() {
		return bundle.getString("MONTH");
	}
	
	public String getDay() {
		return bundle.getString("DAY");
	}
	
	public String getHour() {
		return bundle.getString("HOUR");
	}
	
	public String getMinute() {
		return bundle.getString("MINUTE");
	}
	
	public String getSecond() {
		return bundle.getString("SECOND");
	}
	
	public String getSunday() {
		return bundle.getString("SUNDAY");
	}
	
	public String getMonday() {
		return bundle.getString("MONDAY");
	}
	
	public String getTuesday() {
		return bundle.getString("TUESDAY");
	}
	
	public String getWednesday() {
		return bundle.getString("WEDNESDAY");
	}
	
	public String getThursday() {
		return bundle.getString("THURSDAY");
	}
	
	public String getFriday() {
		return bundle.getString("FRIDAY");
	}
	
	public String getSaturday() {
		return bundle.getString("SATURDAY");
	}
	
	public String[] getWeek() {
		String[] weekdays = {getSunday(),
							 getMonday(),
				    		 getTuesday(),
				    		 getWednesday(),
				    		 getThursday(),
				    		 getFriday(),
				    		 getSaturday()
		};
		
		return weekdays;
	}
	
	public String getConfirm() {
		return bundle.getString("CONFIRM");
	}
	
	public String getCancel() {
		return bundle.getString("CANCEL");
	}
	
	public String getDateChooser() {
		return bundle.getString("DATE_CHOOSER");
	}
	
	public String getFunctionList() {
		return bundle.getString("FUNCTIONLIST");
	}

	public String getLogin() {
		return bundle.getString("LOGIN");
	}
	
	public String getLogout() {
		return bundle.getString("LOGOUT");
	}
	
	public String getDeviceIp() {
		return bundle.getString("DEVICE_IP");
	}
	
	public String getIp() {
		return bundle.getString("IP");
	}
	
	public String getPort() {
		return bundle.getString("DEVICE_PORT");
	}
	
	public String getUserId() {
		return bundle.getString("USER_ID");
	}
	
	public String getTemp() {
		return bundle.getString("TEMPERATURE");
	}
	
	public String getMaskstutas() {
		return bundle.getString("MASK_STATUS");
	}
	
	public String getUserName(boolean space) {
		return bundle.getString("USER_NAME");
	}
	
	public String getCardNo() {
		return bundle.getString("CARD_NO");
	}
	
	public String getUserName() {
		return bundle.getString("USERNAME");
	}
	
	public String getPassword() {
		return bundle.getString("PASSWORD");
	}
	
	
	public String getLoginFailed() {
		return bundle.getString("LOGIN_FAILED");
	}
	
	public String getInputDeviceIP() {
		return bundle.getString("PLEASE_INPUT_DEVICE_IP");
	}
	
	public String getInputDevicePort() {
		return bundle.getString("PLEASE_INPUT_DEVICE_PORT");
	}
	
	public String getInputUsername() {
		return bundle.getString("PLEASE_INPUT_DEVICE_USERNAME");
	}
	
	public String getInputPassword() {
		return bundle.getString("PLEASE_INPUT_DEVICE_PASSWORD");
	}
	
	public String getInputConfirmPassword() {
		return bundle.getString("PLEASE_INPUT_CONFIRM_PASSWORD");
	}
	
	public String getStartRealPlay() {
		return bundle.getString("START_REALPLAY");
	}
	
	public String getStopRealPlay() {
		return bundle.getString("STOP_REALPLAY");
	}
	
	public String getChn() {
		return bundle.getString("CHN");
	}
	
	public String getChannel() {
		return bundle.getString("CHANNEL");
	}
	
	public String getStreamType() {
		return bundle.getString("STREAM_TYPE");
	}
	
	public String getMasterAndSub() {
		return bundle.getString("MASTER_AND_SUB_STREAM");
	}
	
	public String getMasterStream() {
		return bundle.getString("MASTER_STREAM");
	}
	
	public String getSubStream() {
		return bundle.getString("SUB_STREAM");
	}
	
	public String getPTZ() {
		return bundle.getString("PTZ");
	}
	
	public String getPtzControlAndCapture() {
		return bundle.getString("PTZCONTROL_CAPTURE");
	}
	
	public String getCapturePicture() {
		return bundle.getString("CAPTURE_PICTURE");
	}
	
	public String getLocalCapture() {
		return bundle.getString("LOCAL_CAPTURE");
	}
	
	public String getRemoteCapture() {
		return bundle.getString("REMOTE_CAPTURE");
	}
	
	public String getTimerCapture() {
		return bundle.getString("TIMER_CAPTURE");
	}
	
	public String getStopCapture() {
		return bundle.getString("STOP_CAPTURE");
	}
	
	public String getInterval() {
		return bundle.getString("INTERVAL");
	}
	
	public String getTimeIntervalIllegal() {
		return bundle.getString("TIME_INTERVAL_ILLEGAL");
	}
	
	public String getNeedStartRealPlay() {
		return bundle.getString("PLEASE_START_REALPLAY");
	}
	
	public String getPTZControl() {
		return bundle.getString("PTZ_CONTROL");
	}
	
	public String getLeftUp() {
		return bundle.getString("LEFT_UP");
	}
	
	public String getUp() {
		return bundle.getString("UP");
	}
	
	public String getRightUp() {
		return bundle.getString("RIGHT_UP");
	}
	
	public String getLeft() {
		return bundle.getString("LEFT");
	}
	
	public String getRight() {
		return bundle.getString("RIGHT");
	}
	
	public String getLeftDown() {
		return bundle.getString("LEFT_DOWN");
	}
	
	public String getDown() {
		return bundle.getString("DOWN");
	}
	
	public String getRightDown() {
		return bundle.getString("RIGHT_DOWN");
	}
	
	public String getSpeed() {
		return bundle.getString("SPEED");
	}
	
	public String getZoomAdd() {
		return bundle.getString("ZOOM_ADD");
	}
	
	public String getZoomDec() {
		return bundle.getString("ZOOM_DEC");
	}
	
	public String getFocusAdd() {
		return bundle.getString("FOCUS_ADD");
	}
	
	public String getFocusDec() {
		return bundle.getString("FOCUS_DEC");
	}
	
	public String getIrisAdd() {
		return bundle.getString("IRIS_ADD");
	}
	
	public String getIrisDec() {
		return bundle.getString("IRIS_DEC");
	}
	
	public String getIndex() {
		return bundle.getString("INDEX");
	}
	
	public String getEventPicture() {
		return bundle.getString("EVENT_PICTURE");
	}
	
	public String getPlatePicture() {
		return bundle.getString("PLATE_PICTURE");
	}
	
	public String getEventName() {
		return bundle.getString("EVENT_NAME");
	}
	
	public String getLicensePlate() {
		return bundle.getString("LICENSE_PLATE");
	}
	
	public String getEventTime() {
		return bundle.getString("EVENT_TIME");
	}
	
	public String getPlateType() {
		return bundle.getString("PLATE_TYPE");
	}
	
	public String getPlateColor() {
		return bundle.getString("PLATE_COLOR");
	}
	
	public String getVehicleColor() {
		return bundle.getString("VEHICLE_COLOR");
	}
	
	public String getVehicleType() {
		return bundle.getString("VEHICLE_TYPE");
	}
	
	public String getVehicleSize() {
		return bundle.getString("VEHICLE_SIZE");
	}
	
	public String getFileCount() {
		return bundle.getString("FILE_COUNT");
	}
	
	public String getFileIndex() {
		return bundle.getString("FILE_INDEX");
	}
	
	public String getGroupId() {
		return bundle.getString("GROUP_ID");
	}
	
	public String getIllegalPlace() {
		return bundle.getString("ILLEGAL_PLACE");
	}
	
	public String getLaneNumber() {
		return bundle.getString("LANE_NUMBER");
	}
	
	public String getEventInfo() {
		return bundle.getString("EVENT_INFO");
	}
	
	public String getNoPlate() {
		return bundle.getString("NO_PLATENUMBER");
	}
	
	public String[] getTrafficTableName() {
		String[] name = {getIndex(),
						 getEventName(), 
						 getLicensePlate(), 
						 getEventTime(), 
						 getPlateType(), 	
						 getPlateColor(), 	
						 getVehicleColor(), 
						 getVehicleType(), 
						 getVehicleSize(),
						 getFileCount(),
						 getFileIndex(),
						 getGroupId(),
						 getIllegalPlace(),
						 getLaneNumber()};
		return name;
	}
	
	public String getOperate() {
		return bundle.getString("OPERATE");
	}
	
	public String getAttach() {
		return bundle.getString("ATTACH");
	}
	
	public String getDetach() {
		return bundle.getString("DETACH");
	}
	
	public String getOpenStrobe() {
		return bundle.getString("OPEN_STROBE");
	}
	
	public String getCloseStrobe() {
		return bundle.getString("CLOSE_STROBE");
	}
	
	public String getOpenStrobeFailed() {
		return bundle.getString("OPEN_STROBE_FAILED");
	}
	
	public String getManualCapture() {
		return bundle.getString("MANUAL_CAPTURE");
	}
	
	public String getManualCaptureSucceed() {
		return  bundle.getString("MANUALSNAP_SUCCEED");
	}
	
	public String getManualCaptureFailed() {
		return  bundle.getString("MANUALSNAP_FAILED");
	}
    
    /*
     * 车辆大小对照表
     */
    public String getTrafficSize(int nVehicleSize) {
    	String vehicleClass = "";
    	for(int i = 0; i < 5; i++) {
      		if( ((byte)nVehicleSize & (1 << i)) > 0 ) {
      			switch (i) {
				case 0:
					vehicleClass = bundle.getString("LIGHT_DUTY");
					break;
				case 1:
					vehicleClass = bundle.getString("MEDIUM");
					break;
				case 2:
					vehicleClass = bundle.getString("OVER_SIZE");
					break;
				case 3:
					vehicleClass = bundle.getString("MINI_SIZE");
					break;
				case 4:
					vehicleClass = bundle.getString("LARGE_SIZE");
					break;
				}
      		}
      	} 
    	
    	return vehicleClass;
    }
	
    /*
     * 获取事件名称
     */
    public String getEventName(int type) {
    	String name = "";
    	switch (type) {
			case NetSDKLib.EVENT_IVS_TRAFFICJUNCTION:  ///< 交通路口事件
				name = bundle.getString("EVENT_IVS_TRAFFICJUNCTION");
				break;
			case NetSDKLib.EVENT_IVS_TRAFFIC_RUNREDLIGHT: ///< 闯红灯事件
				name = bundle.getString("EVENT_IVS_TRAFFIC_RUNREDLIGHT");
				break;
			case NetSDKLib.EVENT_IVS_TRAFFIC_OVERLINE: ///< 压车道线事件
				name = bundle.getString("EVENT_IVS_TRAFFIC_OVERLINE");
				break;
			case NetSDKLib.EVENT_IVS_TRAFFIC_RETROGRADE: ///< 逆行事件
				name = bundle.getString("EVENT_IVS_TRAFFIC_RETROGRADE");
				break;
			case NetSDKLib.EVENT_IVS_TRAFFIC_TURNLEFT: ///< 违章左转
				name = bundle.getString("EVENT_IVS_TRAFFIC_TURNLEFT");
				break;
			case NetSDKLib.EVENT_IVS_TRAFFIC_TURNRIGHT: ///< 违章右转
				name = bundle.getString("EVENT_IVS_TRAFFIC_TURNRIGHT");
				break;
			case NetSDKLib.EVENT_IVS_TRAFFIC_UTURN: ///< 违章掉头
				name = bundle.getString("EVENT_IVS_TRAFFIC_UTURN");
				break;
			case NetSDKLib.EVENT_IVS_TRAFFIC_OVERSPEED: ///< 超速
				name = bundle.getString("EVENT_IVS_TRAFFIC_OVERSPEED");
				break;
			case NetSDKLib.EVENT_IVS_TRAFFIC_UNDERSPEED: ///< 低速
				name = bundle.getString("EVENT_IVS_TRAFFIC_UNDERSPEED");
				break;
			case NetSDKLib.EVENT_IVS_TRAFFIC_PARKING: ///< 违章停车
				name = bundle.getString("EVENT_IVS_TRAFFIC_PARKING");
				break;
			case NetSDKLib.EVENT_IVS_TRAFFIC_WRONGROUTE: ///< 不按车道行驶
				name = bundle.getString("EVENT_IVS_TRAFFIC_WRONGROUTE");
				break;
			case NetSDKLib.EVENT_IVS_TRAFFIC_CROSSLANE: ///< 违章变道
				name = bundle.getString("EVENT_IVS_TRAFFIC_CROSSLANE");
				break;
			case NetSDKLib.EVENT_IVS_TRAFFIC_OVERYELLOWLINE: ///< 压黄线
				name = bundle.getString("EVENT_IVS_TRAFFIC_OVERYELLOWLINE");
				break;
			case NetSDKLib.EVENT_IVS_TRAFFIC_YELLOWPLATEINLANE: ///< 黄牌车占道事件
				name = bundle.getString("EVENT_IVS_TRAFFIC_YELLOWPLATEINLANE");
				break;
			case NetSDKLib.EVENT_IVS_TRAFFIC_PEDESTRAINPRIORITY: ///< 斑马线行人优先事件
				name = bundle.getString("EVENT_IVS_TRAFFIC_PEDESTRAINPRIORITY");
				break;
			case NetSDKLib.EVENT_IVS_TRAFFIC_MANUALSNAP: ///< 交通手动抓拍事件
				name = bundle.getString("EVENT_IVS_TRAFFIC_MANUALSNAP");
				break;
			case NetSDKLib.EVENT_IVS_TRAFFIC_VEHICLEINROUTE: ///< 有车占道事件
				name = bundle.getString("EVENT_IVS_TRAFFIC_VEHICLEINROUTE");
				break;
			case NetSDKLib.EVENT_IVS_TRAFFIC_VEHICLEINBUSROUTE: ///< 占用公交车道事件
				name = bundle.getString("EVENT_IVS_TRAFFIC_VEHICLEINBUSROUTE");
				break;
			case NetSDKLib.EVENT_IVS_TRAFFIC_BACKING: ///< 违章倒车事件
				name = bundle.getString("EVENT_IVS_TRAFFIC_BACKING");
				break;
			case NetSDKLib.EVENT_IVS_TRAFFIC_PARKINGSPACEPARKING: ///< 车位有车事件
				name = bundle.getString("EVENT_IVS_TRAFFIC_PARKINGSPACEPARKING");
				break;
			case NetSDKLib.EVENT_IVS_TRAFFIC_PARKINGSPACENOPARKING: ///< 车位无车事件
				name = bundle.getString("EVENT_IVS_TRAFFIC_PARKINGSPACENOPARKING");
				break;
			case NetSDKLib.EVENT_IVS_TRAFFIC_WITHOUT_SAFEBELT: ///< 交通未系安全带事件
				name = bundle.getString("EVENT_IVS_TRAFFIC_WITHOUT_SAFEBELT");
				break;
			default:
				break;
		}
    	
    	return name;
    }
	
    public String getRecordType() {
    	return bundle.getString("RECORD_TYPE");
    }
    
    public String getStartTime() {
    	return bundle.getString("START_TIME");
    }
    
    public String getEndTime() {
    	return bundle.getString("END_TIME");
    }
    
    public String[] getDownloadTableName() {
    	String[] name = {getIndex(), 
						 getChannel(),
						 getRecordType(), 
						 getStartTime(), 
						 getEndTime()}; 	
    	return name;
    }
    
    public String getDownloadByFile() {
    	return bundle.getString("DOWNLOAD_RECORD_BYFILE");
    }
    
    public String getQuery() {
    	return bundle.getString("QUERY");
    }
    
    public String getDownload() {
    	return bundle.getString("DOWNLOAD");
    }
    
    public String getStopDownload() {
    	return bundle.getString("STOP_DOWNLOAD");
    }
    
    public String getDownloadByTime() {
    	return bundle.getString("DOWNLOAD_RECORD_BYTIME");
    }
    
    public String getSelectTimeAgain() {
    	return bundle.getString("PLEASE_SELECT_TIME_AGAIN");
    }
    
    public String getSelectRowWithData() {
    	return bundle.getString("PLEASE_FIRST_SELECT_ROW_WITH_DATA");
    }
    
    public String getQueryRecord() {
    	return bundle.getString("PLEASE_FIRST_QUERY_RECORD");
    }
    
    public String getDownloadCompleted() {
    	return bundle.getString("DOWNLOAD_COMPLETED");
    }
    
	/**
	 * 获取录像类型
	 */
	public String getRecordTypeStr(int nRecordFileType) {
		String recordTypeStr = "";
		switch(nRecordFileType) {
			case 0:
                recordTypeStr = bundle.getString("GENERAL_RECORD");
                break;
			case 1:
			    recordTypeStr = bundle.getString("ALARM_RECORD");
                break;
			case 2:
			    recordTypeStr = bundle.getString("MOTION_DETECTION");
                break;
			case 3:
			    recordTypeStr = bundle.getString("CARD_NUMBER_RECORD");
                break;
			case 5:
			    recordTypeStr = bundle.getString("INTELLIGENT_DETECTION");
                break;
			case 19:
			    recordTypeStr = bundle.getString("POS_RECORD");
                break;
            default:
            	break;
		}
		
		return recordTypeStr;
	}
    
	public int getRecordTypeInt(String recordFileStr) {
		int recordType = -1;
		if(recordFileStr.equals(bundle.getString("GENERAL_RECORD"))) {
			recordType = 0;
		} else if(recordFileStr.equals(bundle.getString("ALARM_RECORD"))) {
			recordType = 1;
		} else if(recordFileStr.equals(bundle.getString("MOTION_DETECTION"))) {
			recordType = 2;
		} else if(recordFileStr.equals(bundle.getString("CARD_NUMBER_RECORD"))) {
			recordType = 3;
		}else if(recordFileStr.equals(bundle.getString("INTELLIGENT_DETECTION"))){
			recordType=11;
		}else if(recordFileStr.equals(bundle.getString("POS_RECORD"))){
			recordType=19;
		}

		
		return recordType;
	}  
    
	/**
	 * 语音对讲
	 */
	public String getTalk() {
		return bundle.getString("TALK");
	}
	
	public String getTransmitType() {
    	return bundle.getString("TRANSMIT_TYPE");
    }
	
	public String getLocalTransmitType() {
    	return bundle.getString("LOCAL_TRANSMIT_TYPE");
    }
	
	public String getRemoteTransmitType() {
    	return bundle.getString("REMOTE_TRANSMIT_TYPE");
    }
	
	public String getTransmitChannel() {
    	return bundle.getString("TRANSMIT_CHANNEL");
    }
	
	public String getStartTalk() {
    	return bundle.getString("START_TALK");
    }
	
	public String getStopTalk() {
    	return bundle.getString("STOP_TALK");
    }
	
	public String getTalkFailed() {
    	return bundle.getString("TALK_FAILED");
    }
    
	public String getDeviceSearchAndInit() {
		return bundle.getString("DEVICESEARCH_DEVICEINIT");
	}
	
    public String getDeviceSearchOperate() {
    	return bundle.getString("DEVICESEARCH_OPERATE");
    }
    
    public String getDeviceSearchResult() {
    	return bundle.getString("DEVICESEARCH_RESULT");
    }
    
    public String getDeviceInit() {
    	return bundle.getString("DEVICEINIT");
    }
    
    public String getStartSearch() {
    	return bundle.getString("START_SEARCH");
    }
    
    public String getStopSearch() {
    	return bundle.getString("STOP_SEARCH");
    }
    
    public String getPleaseSelectInitializedDevice() {
    	return bundle.getString("PLEASE_FIRST_SELECT_INITIALIZED_DEVICE");
    }
    
    public String getDeviceSearch() {
    	return bundle.getString("DEVICESEARCH");
    }
    
    public String getDevicePointToPointSearch() {
    	return bundle.getString("DEVICE_POINT_TO_POINT_SEARCH");
    }
    
    public String getStartIp() {
    	return bundle.getString("START_IP");
    }
    
    public String getEndIp() {
    	return bundle.getString("END_IP");
    }
    
    public String getControlScope() {
    	return bundle.getString("THE_IP_CONTROL_SCOPE");
    }
    
    public String getDeviceType() {
    	return bundle.getString("DEVICE_TYPE");
    }
    
    public String getDeviceMac() {
    	return bundle.getString("MAC");
    }
    
    public String getDeviceSn() {
    	return bundle.getString("SN");
    }
    
    public String getDeviceInitState() {
    	return bundle.getString("DEVICE_INIT_STATE");
    }
    
    public String getInitPasswd() {
    	return bundle.getString("INIT_PASSWD");
    }
    
    public String[] getDeviceTableName() {
    	String[] name = {getIndex(),
    					 getDeviceInitState(),
    					 getIpVersion(),
    					 getDeviceIp(),
    					 getPort(),
    					 getSubMask(),
    					 getGetway(),
    				     getDeviceMac(),				 
    					 getDeviceType(),
    					 getDetailType(),
    					 getHttpPort()};
    	
    	return name; 
    }
    
    public String getIpVersion() {
    	return bundle.getString("IP_VERSION");
    }
    
    public String getSubMask() {
    	return bundle.getString("SUB_MASK");
    }
    
    public String getGetway() {
    	return bundle.getString("GETWAY");
    }
    
    public String getDetailType() {
    	return bundle.getString("DETAIL_TYPE");
    }
    
    public String getHttpPort() {
    	return bundle.getString("HTTP_PORT");
    }
    
    public String getLocalIp() {
    	return bundle.getString("LOCAL_IP");
    }
    
    public String getInitialized() {
    	return bundle.getString("INITIALIZED");
    }
    
    public String getNotInitialized() {
    	return bundle.getString("NOT_INITIALIZED");
    }
    
    public String getOldDevice() {
    	return bundle.getString("OLD_DEVICE");
    }
    
    public String getNotSupportInitialization() {
    	return bundle.getString("DONOT_SUPPORT_INITIALIZATION");
    }
    
    public String getPhone() {
    	return bundle.getString("PHONE");
    }
    
    public String getMail() {
    	return bundle.getString("MAIL");
    }
    
    public String getInputPhone() {
    	return bundle.getString("PLEASE_INPUT_PHONE");
    }
    
    public String getInputMail() {
    	return bundle.getString("PLEASE_INPUT_MAIL");
    }
    
    public String getConfirmPassword() {
    	return bundle.getString("CONFIRM_PASSWORD");
    }
    
    public String getInconsistent() {
    	return bundle.getString("INCONSISTENT");
    }
    
    public String getCheckIp() {
    	return bundle.getString("PLEASE_CHECK_IP");
    }
    
    // 0-老设备，没有初始化功能 1-未初始化账号 2-已初始化账户
    public String getInitStateInfo(int initStatus) {
    	String initStateInfo = "";
    	switch(initStatus) {
    		case 0:
    			initStateInfo = getInitialized();
    			break;
    		case 1:
    			initStateInfo = getNotInitialized();
    			break;
    		case 2:
    			initStateInfo = getInitialized();
    			break;
    	}
    	return initStateInfo;
    }
    
    public String  getAlarmListen() {
    	return bundle.getString("ALARM_LISTEN");
    }
    
    public String  getStartListen() {
    	return bundle.getString("START_LISTEN");
    }
    
    public String  getStopListen() {
    	return bundle.getString("STOP_LISTEN");
    }
    public String getStopListenFailed(){
		return bundle.getString("STOP_LISTEN_FAILED");
	}
    public String  getShowAlarmEvent() {
    	return bundle.getString("SHOW_ALARM_EVENT");
    }
    
    public String  getAlarmMessage() {
    	return bundle.getString("ALARM_MESSAGE");
    }
    
    public String getExternalAlarm() {
    	return bundle.getString("EXTERNAL_ALARM");
    }
    
    public String getMotionAlarm() {
    	return bundle.getString("MOTION_ALARM");
    }
    
    public String getVideoLostAlarm() {
    	return bundle.getString("VIDEOLOST_ALARM");
    }
    
    public String getShelterAlarm() {
    	return bundle.getString("SHELTER_ALARM");
    }
    
    public String getDiskFullAlarm() {
    	return bundle.getString("DISKFULL_ALARM");
    }
    
    public String getDiskErrorAlarm() {
    	return bundle.getString("DISKERROR_ALARM");
    }
    
    public String getAlarmListenFailed() {
    	return bundle.getString("ALARM_LISTEN_FAILED");
    }
    
    public String getStart() {
    	return bundle.getString("START");
    }
    
    public String getStop() {
    	return bundle.getString("STOP");
    }
    
    public String getDeviceControl() {
    	return bundle.getString("DEVICE_CONTROL");
    }
    
    public String getDeviceReboot() {
    	return bundle.getString("DEVICE_REBOOT");
    }
    
    public String getSyncTime() {
    	return bundle.getString("SYNCHRONIZE_TIME");
    }
    
    public String getCurrentTime() {
    	return bundle.getString("CURRENT_TIME");
    }
    
    public String getReboot() {
    	return bundle.getString("REBOOT");
    }
    
    public String getRebootTips() {
    	return bundle.getString("REBOOT_TIPS");
    }
    
    public String getGetTime() {
    	return bundle.getString("GET_TIME");
    }
    
    public String getSetTime() {
    	return bundle.getString("SET_TIME");
    }
    
    public String getOperateSuccess() {
    	return bundle.getString("OPERATE_SUCCESS");
    }

    public String getFaceRecognition() {
    	return bundle.getString("FACERECOGNITION");
    }
    
    public String[] getGroupTable() {
    	String[] faceTable = {getFaceGroupId(),
    						  getFaceGroupName(),
				    		  bundle.getString("PERSON_COUNT")};
    	return faceTable;
    }
    
    public String getFaceGroupId() {
    	return bundle.getString("FACE_GROUP_ID");
    }
    
    public String getFaceGroupName() {
    	return bundle.getString("FACE_GROUP_NAME");
    }
    
    public String getGroupOperate() {
    	return bundle.getString("GROUP_OPERATE");
    }
    
    public String getPersonOperate() {
    	return bundle.getString("PERSON_OPERATE");
    }
    
    public String getGlobalPicture() {
    	return bundle.getString("GLOBAL_PICTURE");
    }
    
    public String getPersonPicture() {
    	return bundle.getString("PERSON_PICTURE");
    }
    
    public String getCandidatePicture() {
    	return bundle.getString("CANDIDATE_PICTURE");
    }
    
    public String getTime() {
    	return bundle.getString("TIME");
    }
    
    public String getSex() {
    	return bundle.getString("SEX");
    }
    
    public String getAge() {
    	return bundle.getString("AGE");
    }
 
    
    public String getColor() {
    	return bundle.getString("COLOR");
    }
    
    public String getEye() {
    	return bundle.getString("EYE");
    }
    
    public String getMouth() {
    	return bundle.getString("MOUTH");
    }
    
    public String getMask() {
    	return bundle.getString("MASK");
    }
    
    public String getBeard() {
    	return bundle.getString("BEARD");
    }
    
    public String getName() {
    	return bundle.getString("NAME");
    }
    
    public String getBirthday() {
    	return bundle.getString("BIRTHDAY");
    }
    
    public String getIdNo() {
    	return bundle.getString("ID_NO");
    }
    
    public String getIdType() {
    	return bundle.getString("ID_TYPE");
    }
    
    public String getSimilarity() {
    	return bundle.getString("SIMILARITY");
    }
    
    public String getFaceDetectEvent() {
    	return bundle.getString("FACE_DETECT_EVENT");
    }
    
    public String getFaceRecognitionEvent() {
    	return bundle.getString("FACE_RECOGNITION_EVENT");
    }
    
    public String getUid() {
    	return bundle.getString("UID");
    }
    
    public String getGlasses() {
    	return bundle.getString("GLASSES");
    }
    
    public String getPicturePath() {
    	return bundle.getString("PICTURE_PATH");
    }
    
    public String getFaceLibraryID() {
    	return bundle.getString("FACE_LIBRARY_ID");
    }
    
    public String getFaceLibraryName() {
    	return bundle.getString("FACE_LIBRARY_NAME");
    }
    
    public String[] getPersonTable() {
    	String[] personTable = {getUid(), getName(), getSex(), getBirthday(), getIdType(), getIdNo()};
    	return personTable;
    }
    
    public String[] getDispositionTable() {
    	String[] dispositionTable = {getChannel(), getSimilarity()};
    	return dispositionTable;
    }
    
    public String getUnKnow() {
    	return bundle.getString("UNKNOW");
    }
    
    public String getMale() {
    	return bundle.getString("MALE");
    }
    
    public String getFemale() {
    	return bundle.getString("FEMALE");
    }
    
    public String[] getSexStringsFind() {
    	String[] faceSexStr = {getUnLimited(), getMale(), getFemale()}; 	
    	return faceSexStr;
    }
    
    public String[] getIdStringsFind() {
    	String[] idStr = {getUnLimited(), getIdCard(), getPassport(),};
    	return idStr;
    }
    
    public String[] getSexStrings() {
    	String[] faceSexStr = {getUnKnow(), getMale(), getFemale()}; 	
    	return faceSexStr;
    }
    
    public String[] getIdStrings() {
    	String[] idStr = {getUnKnow(), getIdCard(), getPassport(),};
    	return idStr;
    }
    
    public String getIdCard() {
    	return bundle.getString("ID_CARD");
    }
    
    public String getPassport() {
    	return bundle.getString("PASSPORT");
    }
    
    public String getOfficeCard() {
    	return bundle.getString("OFFICE_CARD");
    }
    
    public String getIdType(int idType) {
    	String str = "";
    	switch(idType) {
	    	case 0:
	    		str = getUnKnow();
	    		break;
	    	case 1:
	    		str = getIdCard();
	    		break;
	    	case 2:
	    		str =  getPassport();
	    		break;
	    	case 3:
	    		str =  getOfficeCard();
	    		break;
			default :
				str = getUnKnow();
				break;
		}
		return str;
    }
    
    public String getSex(int sex) {
    	String str = ""; 	
    	switch(sex) {
	    	case 0:
	    		str = getUnKnow();
	    		break;
	    	case 1:
	    		str = getMale();
	    		break;
	    	case 2:
	    		str = getFemale();
	    		break;
    		default :
    			str = getUnKnow();
    			break;
    	}
    	return str;
    }
    
    public String getUnLimited() {
    	return bundle.getString("UNLIMITED");
    }
    
    public String getUnidentified() {
    	return bundle.getString("UNIDENTIFIED");
    }
    
    public String getHaveBeard() {
    	return bundle.getString("HAVE_BEARD");
    }
    
    public String getNoBeard() {
    	return bundle.getString("NO_BEARD");
    }
    
	public String getBeardState(int beard) {
		String str = "";	
		switch (beard) {
			case 0:
				str = getUnKnow();
				break;
			case 1:
				str = getUnidentified();	
					break;
			case 2:
				str = getNoBeard();	
				break;
			case 3:
				str = getHaveBeard();	
				break;
			default:
				str = getUnKnow();
    			break;
		}	
		return str;
	}
	
	public String getOpenMouth() {
		return bundle.getString("OPEN_MOUTH");
	}
	
	public String getCloseMouth() {
		return bundle.getString("CLOSE_MOUTH");
	}
	
	public String getMouthState(int mouth) {
		String str = "";	
		switch (mouth) {
			case 0:
				str = getUnKnow();
				break;
			case 1:
				str = getUnidentified();
					break;
			case 2:
				str = getCloseMouth();	
				break;
			case 3:
				str = getOpenMouth();	
				break;
			default:
				str = getUnKnow();
				break;
		}	
		return str;
	}
	
	public String getYellowColor() {
		return bundle.getString("YELLOW_COLOR");
	}
	
	public String getBlackColor() {
		return bundle.getString("BLACK_COLOR");
	}
	
	public String getWhiteColor() {
		return bundle.getString("WHITE_COLOR");
	}

	public String getColor(int color) {
		String str = "";	
		switch (color) {
			case 0:
				str = getUnKnow();
				break;
			case 1:
				str = getUnidentified();	
					break;
			case 2:
				str = getYellowColor();
				break;
			case 3:
				str = getBlackColor();
				break;
			case 4:
				str = getWhiteColor();
				break;
			default:
				str = getUnKnow();
				break;
		}	
		return str;
	}
	
	public String getOpenEye() {
		return bundle.getString("OPEN_EYE");
	}
	
	public String getCloseEye() {
		return bundle.getString("CLOSE_EYE");
	}
	
	public String getEyeState(int eye) {
		String str = getUnidentified();	
		switch (eye) {
			case 0:
				str = getUnKnow();
				break;
			case 1:
				str = getUnidentified();	
					break;
			case 2:
				str = getCloseEye();	
				break;
			case 3:
				str = getOpenEye();	
				break;
			default:
				str = getUnKnow();
				break;
		}	
		return str;
	}
	
	public String getSmile() {
		return bundle.getString("SMILE");
	}
	
	public String getAnger() {
		return bundle.getString("ANGER");
	}
	
	public String getSadness() {
		return bundle.getString("SADNESS");
	}
	
	public String getDisgust() {
		return bundle.getString("DISGUST");
	}
	
	public String getFear() {
		return bundle.getString("FEAR");
	}
	
	public String getSurprise() {
		return bundle.getString("SURPRISE");
	}
	
	public String getNeutral() {
		return bundle.getString("NEUTRAL");
	}
	
	public String getLaugh() {
		return bundle.getString("LAUGH");
	}
	
	public String getFaceFeature(int type) {
		String str = "";
		switch (type) {
			case 0:
				str = getUnKnow();
				break;
			case 1:
				str = getWearGlasses();
				break;
			case 2:
				str = getSmile();
				break;
			case 3:
				str = getAnger();
				break;
			case 4:
				str = getSadness();
				break;
			case 5:
				str = getDisgust();
				break;
			case 6:
				str = getFear();
				break;
			case 7:
				str = getSurprise();
				break;
			case 8:
				str = getNeutral();
				break;
			case 9:
				str = getLaugh();
				break;
			default:
				str = getUnKnow();
				break;
		}
		return str;
	}
	
	public String getWearMask() {
		return bundle.getString("WEAR_MASK");
	}
	
	public String geNoMask() {
		return bundle.getString("NO_MASK");
	}
	
	public String getMaskState(int type) {
		String maskStateStr = "";
		switch (type) {
			case 0:
				maskStateStr = getUnKnow();
				break;
			case 1:
				maskStateStr = getUnidentified();
				break;
			case 2:
				maskStateStr = geNoMask();
				break;
			case 3:
				maskStateStr = getWearMask();
				break;
			default:
				maskStateStr = getUnKnow();
				break;
		}
		return maskStateStr;
	}
	
	public String getWearGlasses() {
		return bundle.getString("WEAR_GLASSES");
	}
	
	public String getNoGlasses() {
		return bundle.getString("NO_GLASSES");
	}
	
	public String getGlasses(int byGlasses) {
		String glassesStr = "";
		switch (byGlasses) {
			case 0:
				glassesStr = getUnKnow();
				break;
			case 1:
				glassesStr = getNoGlasses();
				break;
			case 2:
				glassesStr = getWearGlasses();
				break;
			default:
				break;
		}
		return glassesStr;
	}
	
	public String getAdd() {
		return bundle.getString("ADD");
	}
	
	public String getModify() {
		return bundle.getString("MODIFY");
	}
	
	public String getDelete() {
		return bundle.getString("DELETE");
	}
	
	public String getFresh() {
		return bundle.getString("FRESH");
	}
	
	public String getAddGroup() {
		return bundle.getString("ADD_GROUP");
	}
	
	public String getModifyGroup() {
		return bundle.getString("MODIFY_GROUP");
	}
	
	public String getDelGroup() {
		return bundle.getString("DEL_GROUP");
	}
	
	public String getDisposition() {
		return bundle.getString("DISPOSITION");
	}
	
	public String getDelDisposition() {
		return bundle.getString("DEL_DISPOSITION");
	}
	
	public String getSimilarityRange() {
		return bundle.getString("SIMILARITY_RANGE");
	}
	
	public String getFindCondition() {
		return bundle.getString("FIND_CONDITION");
	}
	
	public String getFindPerson() {
		return bundle.getString("FIND_PERSON");
	}
	
	public String getAddPerson() {
		return bundle.getString("ADD_PERSON");
	}
	
	public String getModifyPerson() {
		return bundle.getString("MODIFY_PERSON");
	}
	
	public String getDelPerson() {
		return bundle.getString("DEL_PERSON");
	}
	
	public String getPreviousPage() {
		return bundle.getString("PREVIOUSPAGE");
	}
	
	public String getLastPage() {
		return bundle.getString("LASTPAGE");
	}
	
	public String getSelectPicture() {
		return bundle.getString("SELECT_PICTURE");
	}
	
	public String getSearchByPic() {
		return bundle.getString("SEARCH_BY_PIC");
	}
	
	public String getDownloadQueryPicture() {
		return bundle.getString("DOWNLOAD_QUERY_PICTURE");
	}
	
	public String getFaceLibrary() {
		return bundle.getString("FACE_LIBRARY");
	}
	
	public String getChooseFacePic() {
		return bundle.getString("CHOOSE_FACE_PIC");
	}
	
	public String getHistoryLibrary() {
		return bundle.getString("HISTORY_LIBRARY");
	}
	
	public String getEventType() {
		return bundle.getString("EVENT_TYPE");
	}
	
	public String getStranger() {
		return bundle.getString("STRANGER");
	}
	
	public String getInputGroupName() {
		return bundle.getString("PLEASE_INPUT_GROUPNAME");
	}
	
	public String getSelectGroup() {
		return bundle.getString("PLEASE_SELECT_GROUP");
	}
	
	public String getSelectPerson() {
		return bundle.getString("PLEASE_SELECT_PERSON");
	}
	
	public String getAddDispositionInfo() {
		return bundle.getString("PLEASE_ADD_DISPOSITION_INFO");
	}
	
	public String getSelectDelDispositionInfo() {
		return bundle.getString("PLEASE_SELECT_DEL_DISPOSITION_INFO");
	}
	
	public String getPagesNumber() {
		return bundle.getString("PAGES_NUMBER");
	}
	
	public String getAutoRegister() {
		return bundle.getString("AUTOREGISTER");
	}
	
	public String getAutoRegisterListen() {
		return bundle.getString("AUTOREGISTER_LISTEN");
	}
	
	public String getDeviceConfig() {
		return bundle.getString("DEVICE_CONFIG");
	}
	
	public String getDeviceList() {
		return bundle.getString("DEVICE_LIST");
	}
	
	public String getDeviceManager() {
		return bundle.getString("DEVICE_MANAGER");
	}
	
	public String getAddDevice() {
		return bundle.getString("ADD_DEVICE");
	}
	
	public String getModifyDevice() {
		return bundle.getString("MODIFY_DEVICE");
	}
	
	public String getDeleteDevice() {
		return bundle.getString("DELETE_DEVICE");
	}
	
	public String getClearDevice() {
		return bundle.getString("CLEAR_DEVICE");
	}
	
	public String getImportDevice() {
		return bundle.getString("IMPORT_DEVICE");
	}
	
	public String getExportDevice() {
		return bundle.getString("EXPORT_DEVICE");
	}
	
	public String getFunctionOperate() {
		return bundle.getString("FUNCTION") + bundle.getString("OPERATE");
	}
	
	public String getDeviceID() {
		return bundle.getString("DEVICE_ID");
	}
	
	public String getEnable() {
		return bundle.getString("ENABLE");
	}
	
	public String getRegisterAddress() {
		return bundle.getString("REGISTER_ADDRESS");
	}
	
	public String getRegisterPort() {
		return bundle.getString("REGISTER_PORT");
	}
	
	public String getGet() {
		return bundle.getString("GET");
	}
	
	public String getSet() {
		return bundle.getString("SET");
	}
	
	public String getAlreadyExisted() {
		return bundle.getString("ALREADY_EXISTED");
	}
	
	public String getWhetherNoToCover() {
		return bundle.getString("ALREADY_EXISTED_WHETHER_OR_NOT_TO_COVER");
	}
	
	public String getFileOpened(){
		return bundle.getString("FILE_OPEN_PLEASE_CLOSE_FILE");
	}
	
	public String getImportCompletion() {
		return bundle.getString("IMPORT_COMPLETION");
	}
	
	public String getExportCompletion() {
		return bundle.getString("EXPORT_COMPLETION");
	}
	
	public String getFileNotExist() {
		return bundle.getString("FILE_NOT_EXIST");
	}
	
	public String getRecord() {
		return bundle.getString("RECORD");
	}
	
	public String getInput() {
		return bundle.getString("PLEASE_INPUT");
	}
	
	public String getMaximumSupport() {
		return bundle.getString("MAX_SUPPORT_100");
	}
	
	public String getDeviceLogined() {
		return bundle.getString("DEVICE_LOGIN");
	}
	
	public String getAttendance() {
		return bundle.getString("ATTENDANCE");
	}
	
	public String getFingerPrintOperate() {
		return bundle.getString("FINGERPRINT_OPERATE");
	}
	
	public String getUserOperate() {
		return bundle.getString("USER_OPERATE");
	}
	
	public String getOperateByUserId() {
		return bundle.getString("OPERATE_BY_USER_ID");
	}
	
	public String getOperateByFingerPrintId() {
		return bundle.getString("OPERATE_BY_FINGERPRINT_ID");
	}
	
	public String getSearch() {
		return bundle.getString("SEARCH");
	}
	
	public String getQueryCondition() {
		return bundle.getString("QUERY_CONDITION");
	}
	
	public String getFingerPrintId() {
		return bundle.getString("FINGERPRINT_ID");
	}
	
	public String getSearchFingerPrint() {
		return bundle.getString("SEARCH_FINGERPRINT");
	}
	
	public String getAddFingerPrint() {
		return bundle.getString("ADD_FINGERPRINT");
	}
	
	public String getDeleteFingerPrint() {
		return bundle.getString("DELETE_FINGERPRINT");
	}
	
	public String getSubscribe() {
		return bundle.getString("SUBSCRIBE");
	}
	
	public String getUnSubscribe() {
		return bundle.getString("UNSUBSCRIBE");
	}
	
	public String getUserList() {
		return bundle.getString("USER_LIST");
	}
	
	public String getNextPage() {
		return bundle.getString("NEXT_PAGE");
	}
	
	public String getUserInfo() {
		return bundle.getString("USER_INFO");
	}
	
	public String getDoorOpenMethod() {
		return bundle.getString("DOOROPEN_METHOD");
	}
	
	public String getFingerPrint() {
		return bundle.getString("FINGERPRINT");
	}
	
	public String getFingerPrintInfo() {
		return bundle.getString("FINGERPRINT_INFO");
	}
	
	public String getFingerPrintData() {
		return bundle.getString("FINGERPRINT_DATA");
	}
	
	public String getCard() {
		return bundle.getString("CARD");
	}
	
	public String getDeleteFingerPrintPrompt() {
		return bundle.getString("DELETE_FINGERPRINT_PROMPT");
	}
	
	public String getSubscribeFailed() {
		return bundle.getString("SUBSCRIBE_FAILED");
	}
	
	public String getFingerPrintIdIllegal() {
		return bundle.getString("FINGERPRINT_ID_ILLEGAL");
	}
	
	public String getcFingerPrintCollection() {
		return bundle.getString("FINGERPRINT_COLLECTION");
	}
	
	public String getStartCollection() {
		return bundle.getString("START_COLLECTION");
	}
	
	public String getStopCollection() {
		return bundle.getString("STOP_COLLECTION");
	}
	
	public String getInCollection() {
		return bundle.getString("IN_THE_COLLECTION");
	}
	
	public String getcCompleteCollection() {
		return bundle.getString("COLLECTION_COMPLETED");
	}
	
	public String getCollectionFailed() {
		return bundle.getString("COLLECTION_FAILED");
	}
	
	public String getFingerPrintIdNotExist() {
		return bundle.getString("FINGERPRINT_ID_NOT_EXIST");
	}
	
	public String getUserIdExceedLength() {
		return bundle.getString("USER_ID_EXCEED_LENGTH");
	}
	
	public String getUserNameExceedLength() {
		return bundle.getString("USER_NAME_EXCEED_LENGTH");
	}
	
	public String getCardNoExceedLength() {
		return bundle.getString("CARD_NO_EXCEED_LENGTH");
	}
	
	public String getCardNameExceedLength() {
		return bundle.getString("CARD_NAME_EXCEED_LENGTH");
	}
	
	public String getCardPasswdExceedLength() {
		return bundle.getString("CARD_PASSWD_EXCEED_LENGTH");
	}
	
	public String getGate() {
		return bundle.getString("GATE");
	}
	
	public String getCardOperate() {
		return bundle.getString("CARD_OPERATE");
	}
	
	public String getCardInfo() {
		return bundle.getString("CARD_INFO");
	}
	
	public String getCardManager() {
		return bundle.getString("CARD_MANAGER");
	}
	
	public String getClear() {
		return bundle.getString("CLEAR");
	}
	
	public String getOpenStatus() {
		return bundle.getString("OPEN_STATUS");
	}
	
	public String getOpenMethod() {
		return bundle.getString("OPEN_METHOD");
	}
	
	public String getCardName() {
		return bundle.getString("CARD_NAME");
	}
	
	public String getCardStatus() {
		return bundle.getString("CARD_STATUS");
	}
	
	public String getCardPassword() {
		return bundle.getString("CARD_PASSWORD");
	}
	
	public String getCardType() {
		return bundle.getString("CARD_TYPE");
	}
	
	public String getCardNum() {
		return bundle.getString("CARD_NUM");
	}
	
	public String getUseTimes() {
		return bundle.getString("USE_TIMES");
	}
	
	public String getIsFirstEnter() {
		return bundle.getString("IS_FIRST_ENTER");
	}
	
	public String getIsValid() {
		return bundle.getString("IS_VALID");
	}
	
	public String getValidPeriod() {
		return bundle.getString("VALID_PERIOD");
	}
	
	public String getValidStartTime() {
		return bundle.getString("VALID_START_TIME");
	}
	
	public String getValidEndTime() {
		return bundle.getString("VALID_END_TIME");
	}
	
	public String getRecordNo() {
		return bundle.getString("RECORD_NO");
	}
	
	public String getFirstEnter() {
		return bundle.getString("FIRST_ENTER");
	}
	
	public String getNoFirstEnter() {
		return bundle.getString("NO_FIRST_ENTER");
	}
	
	public String getValid() {
		return bundle.getString("VALID");
	}
	
	public String getInValid() {
		return bundle.getString("INVALID");
	}
	
	public String getSelectCard() {
		return bundle.getString("PLEASE_SELECT_CARD");
	}
	
	public String getInputCardNo() {
		return bundle.getString("PLEASE_INPUT_CARDNO");
	}
	
	public String getInputUserId() {
		return bundle.getString("PLEASE_INPUT_USERID");
	}
	
	public String getWantClearAllInfo() {
		return bundle.getString("WANT_CLEAR_ALL_INFO");
	}
	
	public String getFailedAddCard() {
		return bundle.getString("ADD_CARD_INDO_FAILED");
	}
	
	public String getSucceedAddCardAndPerson() {
		return bundle.getString("ADD_CARD_INFO_AND_PERSON_PICTURE_SUCCEED");
	}
	
	public String getSucceedAddCardButFailedAddPerson() {
		return bundle.getString("ADD_CARD_INFO_SUCCEED_BUT_ADD_PERSON_PICTURE_FAILED");
	}
	
	public String getCardExistedSucceedAddPerson() {
		return bundle.getString("CARD_EXISTED_ADD_PERSON_PICTURE_SUCCEED");
	}
	
	public String getSucceedModifyCard() {
		return bundle.getString("MODIFY_CARD_INFO_SUCCEED");
	}
	
	public String getFailedModifyCard() {
		return bundle.getString("MODIFY_CARD_INFO_FAILED");
	}
	
	public String getSucceedModifyCardAndPerson() {
		return bundle.getString("MODIFY_CARD_INFO_AND_PERSON_PICTURE_SUCCEED");
	}
	
	public String getSucceedModifyCardButFailedModifyPerson() {
		return bundle.getString("MODIFY_CARD_INFO_SUCCEED_BUT_MODIFY_PERSON_PICTURE_FAILED");
	}
	
	public String[] getCardTable() {
		return new String[] {getIndex(),
							 getCardNo(),
							 getCardName(),
							 getRecordNo(),
							 getUserId(),			
							 getCardPassword(), 
							 getCardStatus(),
							 getCardType(),
							 getUseTimes(),
							 getIsFirstEnter(),
							 getIsValid(),
							 getValidStartTime(),
							 getValidEndTime()};
	}
	
	/*
	 * 用于列表显示
	 */
	public String getCardStatus(int status) {
		String statusString = "";
		switch(status) {
			case NET_ACCESSCTLCARD_STATE.NET_ACCESSCTLCARD_STATE_UNKNOWN:   // 未知
				statusString = bundle.getString("STATE_UNKNOWN");
				break;
			case NET_ACCESSCTLCARD_STATE.NET_ACCESSCTLCARD_STATE_NORMAL:   // 正常
				statusString = bundle.getString("STATE_NORMAL");
				break;
			case NET_ACCESSCTLCARD_STATE.NET_ACCESSCTLCARD_STATE_LOSE:   // 挂失
				statusString = bundle.getString("STATE_LOSE");
				break;
			case NET_ACCESSCTLCARD_STATE.NET_ACCESSCTLCARD_STATE_LOGOFF:   // 注销
				statusString = bundle.getString("STATE_LOGOFF");
				break;
			case NET_ACCESSCTLCARD_STATE.NET_ACCESSCTLCARD_STATE_FREEZE:   // 冻结
				statusString = bundle.getString("STATE_FREEZE");
				break;
			case NET_ACCESSCTLCARD_STATE.NET_ACCESSCTLCARD_STATE_ARREARAGE:   // 欠费
				statusString = bundle.getString("STATE_ARREARS"); 
				break;
			case NET_ACCESSCTLCARD_STATE.NET_ACCESSCTLCARD_STATE_OVERDUE:  // 逾期
				statusString = bundle.getString("STATE_OVERDUE");
				break;
			case NET_ACCESSCTLCARD_STATE.NET_ACCESSCTLCARD_STATE_PREARREARAGE:  // 预欠费
				statusString = bundle.getString("STATE_PREARREARS");
				break;
			default:
				statusString = bundle.getString("STATE_UNKNOWN");
				break;
		}
		
		return statusString;					
	}
	
	/*
	 * 根据控件的索引，获取对应的卡状态的Int值, 用于添加 和 修改卡信息
	 */
	public int getCardStatusInt(int index) {
		int status = 0;
		switch(index) {
			case 1:   // 未知
				status = NET_ACCESSCTLCARD_STATE.NET_ACCESSCTLCARD_STATE_UNKNOWN;
				break;
			case 0:   // 正常
				status = NET_ACCESSCTLCARD_STATE.NET_ACCESSCTLCARD_STATE_NORMAL;
				break;
			case 2:   // 挂失
				status = NET_ACCESSCTLCARD_STATE.NET_ACCESSCTLCARD_STATE_LOSE;
				break;
			case 3:   // 注销
				status = NET_ACCESSCTLCARD_STATE.NET_ACCESSCTLCARD_STATE_LOGOFF;
				break;
			case 4:   // 冻结
				status = NET_ACCESSCTLCARD_STATE.NET_ACCESSCTLCARD_STATE_FREEZE;
				break;
			case 5:   // 欠费
				status = NET_ACCESSCTLCARD_STATE.NET_ACCESSCTLCARD_STATE_ARREARAGE;
				break;
			case 6:  // 逾期
				status = NET_ACCESSCTLCARD_STATE.NET_ACCESSCTLCARD_STATE_OVERDUE;
				break;
			case 7:  // 预欠费
				status = NET_ACCESSCTLCARD_STATE.NET_ACCESSCTLCARD_STATE_PREARREARAGE;
				break;
			default:
				status = NET_ACCESSCTLCARD_STATE.NET_ACCESSCTLCARD_STATE_UNKNOWN;
				break;		
		}
		
		return status;					
	}
	
	/*
	 * 根据字符串，获取控件对应的索引
	 */
	public int getCardStatusChomBoxIndex(String status) {
		int index = 0;
		
		if(status.equals(bundle.getString("STATE_UNKNOWN"))) {
			index = 1;
		} else if(status.equals(bundle.getString("STATE_NORMAL"))){
			index = 0;
		} else if(status.equals(bundle.getString("STATE_LOSE"))) {
			index = 2;
		} else if(status.equals(bundle.getString("STATE_LOGOFF"))) {
			index = 3;
		} else if(status.equals(bundle.getString("STATE_FREEZE"))) {
			index = 4;
		} else if(status.equals(bundle.getString("STATE_ARREARS"))) {
			index = 5;
		} else if(status.equals(bundle.getString("STATE_OVERDUE"))) {
			index = 6;
		} else if(status.equals(bundle.getString("STATE_PREARREARS"))) {
			index = 7;
		} 
		
		return index;
	}
	
	public String[] getCardStatusList() {
		return new String[]{
							bundle.getString("STATE_NORMAL"),
							bundle.getString("STATE_UNKNOWN"), 
							bundle.getString("STATE_LOSE"),
							bundle.getString("STATE_LOGOFF"),
							bundle.getString("STATE_FREEZE"),
							bundle.getString("STATE_ARREARS"),
							bundle.getString("STATE_OVERDUE"),
							bundle.getString("STATE_PREARREARS")};
	}
	
	/*
	 * 用于列表显示
	 */
	public String getCardType(int type) {
		String cardTypeString = "";
		
		switch(type) {
			case NET_ACCESSCTLCARD_TYPE.NET_ACCESSCTLCARD_TYPE_UNKNOWN:  // 未知
				cardTypeString = bundle.getString("CARD_UNKNOW");
				break;
			case NET_ACCESSCTLCARD_TYPE.NET_ACCESSCTLCARD_TYPE_GENERAL:  // 一般卡
				cardTypeString = bundle.getString("CARD_GENERAL");
				break;
			case NET_ACCESSCTLCARD_TYPE.NET_ACCESSCTLCARD_TYPE_VIP:      // VIP卡
				cardTypeString = bundle.getString("CARD_VIP");
				break;
			case NET_ACCESSCTLCARD_TYPE.NET_ACCESSCTLCARD_TYPE_GUEST:    // 来宾卡
				cardTypeString = bundle.getString("CARD_GUEST");
				break;
			case NET_ACCESSCTLCARD_TYPE.NET_ACCESSCTLCARD_TYPE_PATROL:   // 巡逻卡
				cardTypeString = bundle.getString("CARD_PATROL");
				break;
			case NET_ACCESSCTLCARD_TYPE.NET_ACCESSCTLCARD_TYPE_BLACKLIST: // 黑名单卡
				cardTypeString = bundle.getString("CARD_BACKLIST");
				break;
			case NET_ACCESSCTLCARD_TYPE.NET_ACCESSCTLCARD_TYPE_CORCE:     // 胁迫卡
				cardTypeString = bundle.getString("CARD_COERCE");
				break;
			case NET_ACCESSCTLCARD_TYPE.NET_ACCESSCTLCARD_TYPE_POLLING:   // 巡检卡
				cardTypeString = bundle.getString("CARD_POLLING");
				break;
			case NET_ACCESSCTLCARD_TYPE.NET_ACCESSCTLCARD_TYPE_MOTHERCARD: // 母卡
				cardTypeString = bundle.getString("CARD_MOTHERCARD");
				break;
			default:
				cardTypeString = bundle.getString("CARD_UNKNOW");
				break;
		}

		return cardTypeString;
	}
	
	/*
	 * 根据控件索引，获取对应的卡类型Int值
	 */
	public int getCardTypeInt(int index) {
		int type = 0;
		
		switch(index) {
			case 1:
				type = NET_ACCESSCTLCARD_TYPE.NET_ACCESSCTLCARD_TYPE_UNKNOWN;
				break;
			case 0:
				type = NET_ACCESSCTLCARD_TYPE.NET_ACCESSCTLCARD_TYPE_GENERAL;
				break;
			case 2:
				type = NET_ACCESSCTLCARD_TYPE.NET_ACCESSCTLCARD_TYPE_VIP;
				break;
			case 3:
				type = NET_ACCESSCTLCARD_TYPE.NET_ACCESSCTLCARD_TYPE_GUEST;
				break;
			case 4:
				type = NET_ACCESSCTLCARD_TYPE.NET_ACCESSCTLCARD_TYPE_PATROL;
				break;
			case 5:
				type = NET_ACCESSCTLCARD_TYPE.NET_ACCESSCTLCARD_TYPE_BLACKLIST;
				break;
			case 6:
				type = NET_ACCESSCTLCARD_TYPE.NET_ACCESSCTLCARD_TYPE_CORCE;
				break;
			case 7:
				type = NET_ACCESSCTLCARD_TYPE.NET_ACCESSCTLCARD_TYPE_POLLING;
				break;
			case 8:
				type = NET_ACCESSCTLCARD_TYPE.NET_ACCESSCTLCARD_TYPE_MOTHERCARD;
				break;
			default:
				type = NET_ACCESSCTLCARD_TYPE.NET_ACCESSCTLCARD_TYPE_UNKNOWN;
				break;
		}

		return type;
	}
	
	/*
	 * 根据字符串，获取控件的索引
	 */
	public int getCardTypeChomBoxIndex(String type) {
		int index = 0;
		
		if(type.equals(bundle.getString("CARD_UNKNOW"))) {
			index = 1;
		} else if(type.equals(bundle.getString("CARD_GENERAL"))){
			index = 0;
		} else if(type.equals(bundle.getString("CARD_VIP"))) {
			index = 2;
		} else if(type.equals(bundle.getString("CARD_GUEST"))) {
			index = 3;
		} else if(type.equals(bundle.getString("CARD_PATROL"))) {
			index = 4;
		} else if(type.equals(bundle.getString("CARD_BACKLIST"))) {
			index = 5;
		} else if(type.equals(bundle.getString("CARD_COERCE"))) {
			index = 6;
		} else if(type.equals(bundle.getString("CARD_POLLING"))) {
			index = 7;
		} else if(type.equals(bundle.getString("CARD_MOTHERCARD"))) {
			index = 8;
		}
		
		return index;
	}
	
	public String[] getCardTypeList() {
		return new String[]{
							bundle.getString("CARD_GENERAL"),
							bundle.getString("CARD_UNKNOW"), 
							bundle.getString("CARD_VIP"),
							bundle.getString("CARD_GUEST"),
							bundle.getString("CARD_PATROL"),
							bundle.getString("CARD_BACKLIST"),
							bundle.getString("CARD_COERCE"),
							bundle.getString("CARD_POLLING"),
							bundle.getString("CARD_MOTHERCARD")};
	}
	
	public String getMaskStatus(int emMaskStatus) {
		String MaskStatus = "";
		switch(emMaskStatus) {
		case EM_MASK_STATE_TYPE.EM_MASK_STATE_UNKNOWN:
			MaskStatus = bundle.getString("EM_MASK_STATE_UNKNOWN");
			break;
		case EM_MASK_STATE_TYPE.EM_MASK_STATE_NODISTI:
			MaskStatus = bundle.getString("EM_MASK_STATE_NODISTI");
			break;
		case EM_MASK_STATE_TYPE.EM_MASK_STATE_NOMASK:
			MaskStatus = bundle.getString("EM_MASK_STATE_NOMASK");
			break;
		case EM_MASK_STATE_TYPE.EM_MASK_STATE_WEAR:
			MaskStatus = bundle.getString("EM_MASK_STATE_WEAR");
			break;
		}
		return MaskStatus;
	}
	
	public String getOpenMethods(int emOpenMethod) {
		String openMethods = "";
		switch(emOpenMethod) {
			case NET_ACCESS_DOOROPEN_METHOD.NET_ACCESS_DOOROPEN_METHOD_UNKNOWN:
				openMethods = bundle.getString("NET_ACCESS_DOOROPEN_METHOD_UNKNOWN");
				break;
			case NET_ACCESS_DOOROPEN_METHOD.NET_ACCESS_DOOROPEN_METHOD_PWD_ONLY:
				openMethods = bundle.getString("NET_ACCESS_DOOROPEN_METHOD_PWD_ONLY");
				break;
			case NET_ACCESS_DOOROPEN_METHOD.NET_ACCESS_DOOROPEN_METHOD_CARD:
				openMethods = bundle.getString("NET_ACCESS_DOOROPEN_METHOD_CARD");
				break;
			case NET_ACCESS_DOOROPEN_METHOD.NET_ACCESS_DOOROPEN_METHOD_CARD_FIRST:
				openMethods = bundle.getString("NET_ACCESS_DOOROPEN_METHOD_CARD_FIRST");
				break;
			case NET_ACCESS_DOOROPEN_METHOD.NET_ACCESS_DOOROPEN_METHOD_PWD_FIRST:
				openMethods = bundle.getString("NET_ACCESS_DOOROPEN_METHOD_PWD_FIRST");
				break;
			case NET_ACCESS_DOOROPEN_METHOD.NET_ACCESS_DOOROPEN_METHOD_REMOTE:
				openMethods = bundle.getString("NET_ACCESS_DOOROPEN_METHOD_REMOTE");
				break;
			case NET_ACCESS_DOOROPEN_METHOD.NET_ACCESS_DOOROPEN_METHOD_BUTTON:
				openMethods = bundle.getString("NET_ACCESS_DOOROPEN_METHOD_BUTTON");
				break;
			case NET_ACCESS_DOOROPEN_METHOD.NET_ACCESS_DOOROPEN_METHOD_FINGERPRINT:
				openMethods = bundle.getString("NET_ACCESS_DOOROPEN_METHOD_FINGERPRINT");
				break;
			case NET_ACCESS_DOOROPEN_METHOD.NET_ACCESS_DOOROPEN_METHOD_PWD_CARD_FINGERPRINT:
				openMethods = bundle.getString("NET_ACCESS_DOOROPEN_METHOD_PWD_CARD_FINGERPRINT");
				break;
			case NET_ACCESS_DOOROPEN_METHOD.NET_ACCESS_DOOROPEN_METHOD_PWD_FINGERPRINT:
				openMethods = bundle.getString("NET_ACCESS_DOOROPEN_METHOD_PWD_FINGERPRINT");
				break;
			case NET_ACCESS_DOOROPEN_METHOD.NET_ACCESS_DOOROPEN_METHOD_CARD_FINGERPRINT:
				openMethods = bundle.getString("NET_ACCESS_DOOROPEN_METHOD_CARD_FINGERPRINT");
				break;
			case NET_ACCESS_DOOROPEN_METHOD.NET_ACCESS_DOOROPEN_METHOD_PERSONS:
				openMethods = bundle.getString("NET_ACCESS_DOOROPEN_METHOD_PERSONS");
				break;
			case NET_ACCESS_DOOROPEN_METHOD.NET_ACCESS_DOOROPEN_METHOD_KEY:
				openMethods = bundle.getString("NET_ACCESS_DOOROPEN_METHOD_KEY");
				break;			
			case NET_ACCESS_DOOROPEN_METHOD.NET_ACCESS_DOOROPEN_METHOD_COERCE_PWD:
				openMethods = bundle.getString("NET_ACCESS_DOOROPEN_METHOD_COERCE_PWD");
				break;
			case NET_ACCESS_DOOROPEN_METHOD.NET_ACCESS_DOOROPEN_METHOD_QRCODE:
				openMethods = bundle.getString("NET_ACCESS_DOOROPEN_METHOD_QRCODE");
				break;
			case NET_ACCESS_DOOROPEN_METHOD.NET_ACCESS_DOOROPEN_METHOD_FACE_RECOGNITION:
				openMethods = bundle.getString("NET_ACCESS_DOOROPEN_METHOD_FACE_RECOGNITION");
				break;
			case NET_ACCESS_DOOROPEN_METHOD.NET_ACCESS_DOOROPEN_METHOD_FACEIDCARD:
				openMethods = bundle.getString("NET_ACCESS_DOOROPEN_METHOD_FACEIDCARD");
				break;
			case NET_ACCESS_DOOROPEN_METHOD.NET_ACCESS_DOOROPEN_METHOD_FACEIDCARD_AND_IDCARD:
				openMethods = bundle.getString("NET_ACCESS_DOOROPEN_METHOD_FACEIDCARD_AND_IDCARD");
				break;
			case NET_ACCESS_DOOROPEN_METHOD.NET_ACCESS_DOOROPEN_METHOD_BLUETOOTH:
				openMethods = bundle.getString("NET_ACCESS_DOOROPEN_METHOD_BLUETOOTH");
				break;
			case NET_ACCESS_DOOROPEN_METHOD.NET_ACCESS_DOOROPEN_METHOD_CUSTOM_PASSWORD:
				openMethods = bundle.getString("NET_ACCESS_DOOROPEN_METHOD_CUSTOM_PASSWORD");
				break;
			case NET_ACCESS_DOOROPEN_METHOD.NET_ACCESS_DOOROPEN_METHOD_USERID_AND_PWD:
				openMethods = bundle.getString("NET_ACCESS_DOOROPEN_METHOD_USERID_AND_PWD");
				break;
			case NET_ACCESS_DOOROPEN_METHOD.NET_ACCESS_DOOROPEN_METHOD_FACE_AND_PWD:
				openMethods = bundle.getString("NET_ACCESS_DOOROPEN_METHOD_FACE_AND_PWD");
				break;
			case NET_ACCESS_DOOROPEN_METHOD.NET_ACCESS_DOOROPEN_METHOD_FINGERPRINT_AND_PWD:
				openMethods = bundle.getString("NET_ACCESS_DOOROPEN_METHOD_FINGERPRINT_AND_PWD");
				break;
			case NET_ACCESS_DOOROPEN_METHOD.NET_ACCESS_DOOROPEN_METHOD_FINGERPRINT_AND_FACE:
				openMethods = bundle.getString("NET_ACCESS_DOOROPEN_METHOD_FINGERPRINT_AND_FACE");
				break;
			case NET_ACCESS_DOOROPEN_METHOD.NET_ACCESS_DOOROPEN_METHOD_CARD_AND_FACE:
				openMethods = bundle.getString("NET_ACCESS_DOOROPEN_METHOD_CARD_AND_FACE");
				break;
			case NET_ACCESS_DOOROPEN_METHOD.NET_ACCESS_DOOROPEN_METHOD_FACE_OR_PWD:
				openMethods = bundle.getString("NET_ACCESS_DOOROPEN_METHOD_FACE_OR_PWD");
				break;
			case NET_ACCESS_DOOROPEN_METHOD.NET_ACCESS_DOOROPEN_METHOD_FINGERPRINT_OR_PWD:
				openMethods = bundle.getString("NET_ACCESS_DOOROPEN_METHOD_FINGERPRINT_OR_PWD");
				break;
			case NET_ACCESS_DOOROPEN_METHOD.NET_ACCESS_DOOROPEN_METHOD_FINGERPRINT_OR_FACE:
				openMethods = bundle.getString("NET_ACCESS_DOOROPEN_METHOD_FINGERPRINT_OR_FACE");
				break;
			case NET_ACCESS_DOOROPEN_METHOD.NET_ACCESS_DOOROPEN_METHOD_CARD_OR_FACE:
				openMethods = bundle.getString("NET_ACCESS_DOOROPEN_METHOD_CARD_OR_FACE");
				break;
			case NET_ACCESS_DOOROPEN_METHOD.NET_ACCESS_DOOROPEN_METHOD_CARD_OR_FINGERPRINT:
				openMethods = bundle.getString("NET_ACCESS_DOOROPEN_METHOD_CARD_OR_FINGERPRINT");
				break;
			case NET_ACCESS_DOOROPEN_METHOD.NET_ACCESS_DOOROPEN_METHOD_FINGERPRINT_AND_FACE_AND_PWD:
				openMethods = bundle.getString("NET_ACCESS_DOOROPEN_METHOD_FINGERPRINT_AND_FACE_AND_PWD");
				break;
			case NET_ACCESS_DOOROPEN_METHOD.NET_ACCESS_DOOROPEN_METHOD_CARD_AND_FACE_AND_PWD:
				openMethods = bundle.getString("NET_ACCESS_DOOROPEN_METHOD_CARD_AND_FACE_AND_PWD");
				break;
			case NET_ACCESS_DOOROPEN_METHOD.NET_ACCESS_DOOROPEN_METHOD_CARD_AND_FINGERPRINT_AND_PWD:
				openMethods = bundle.getString("NET_ACCESS_DOOROPEN_METHOD_CARD_AND_FINGERPRINT_AND_PWD");
				break;
			case NET_ACCESS_DOOROPEN_METHOD.NET_ACCESS_DOOROPEN_METHOD_CARD_AND_PWD_AND_FACE:
				openMethods = bundle.getString("NET_ACCESS_DOOROPEN_METHOD_CARD_AND_PWD_AND_FACE");
				break;
			case NET_ACCESS_DOOROPEN_METHOD.NET_ACCESS_DOOROPEN_METHOD_FINGERPRINT_OR_FACE_OR_PWD:
				openMethods = bundle.getString("NET_ACCESS_DOOROPEN_METHOD_FINGERPRINT_OR_FACE_OR_PWD");
				break;
			case NET_ACCESS_DOOROPEN_METHOD.NET_ACCESS_DOOROPEN_METHOD_CARD_OR_FACE_OR_PWD:
				openMethods = bundle.getString("NET_ACCESS_DOOROPEN_METHOD_CARD_OR_FACE_OR_PWD");
				break;
			case NET_ACCESS_DOOROPEN_METHOD.NET_ACCESS_DOOROPEN_METHOD_CARD_OR_FINGERPRINT_OR_FACE:
				openMethods = bundle.getString("NET_ACCESS_DOOROPEN_METHOD_CARD_OR_FINGERPRINT_OR_FACE");
				break;
			case NET_ACCESS_DOOROPEN_METHOD.NET_ACCESS_DOOROPEN_METHOD_CARD_AND_FINGERPRINT_AND_FACE_AND_PWD:
				openMethods = bundle.getString("NET_ACCESS_DOOROPEN_METHOD_CARD_AND_FINGERPRINT_AND_FACE_AND_PWD");
				break;
			case NET_ACCESS_DOOROPEN_METHOD.NET_ACCESS_DOOROPEN_METHOD_CARD_OR_FINGERPRINT_OR_FACE_OR_PWD:
				openMethods = bundle.getString("NET_ACCESS_DOOROPEN_METHOD_CARD_OR_FINGERPRINT_OR_FACE_OR_PWD");
				break;
			case NET_ACCESS_DOOROPEN_METHOD.NET_ACCESS_DOOROPEN_METHOD_FACEIPCARDANDIDCARD_OR_CARD_OR_FACE:
				openMethods = bundle.getString("NET_ACCESS_DOOROPEN_METHOD_FACEIPCARDANDIDCARD_OR_CARD_OR_FACE");
				break;
			case NET_ACCESS_DOOROPEN_METHOD.NET_ACCESS_DOOROPEN_METHOD_FACEIDCARD_OR_CARD_OR_FACE:
				openMethods = bundle.getString("NET_ACCESS_DOOROPEN_METHOD_FACEIDCARD_OR_CARD_OR_FACE");
				break;
			default:
				openMethods = bundle.getString("NET_ACCESS_DOOROPEN_METHOD_UNKNOWN");
				break;
		}
		
		return openMethods;
	}
	
	public String getShowInfo(String tag) {
		try {
			return bundle.getString(tag);
		}catch(Exception e) {
			return tag;
		}
	}
	
	public String getThermalCamera() {
		return getShowInfo("THERMAL_CAMERA");
	}
	
	public String[] getMeterTypeList() {
		String[] meterTypes = {getShowInfo("SPOT"), getShowInfo("LINE"), getShowInfo("AREA")};
		
		return meterTypes;
	}
	
	public String[] getTemperUnitList() {
		return new String[]{getShowInfo("CENTIGRADE"), getShowInfo("FAHRENHEIT")};
	}
	
	public String[] getPeriodList() {
		return new String[] {getShowInfo("FIVE_MINUTES"), getShowInfo("TEN_MINUTES"), 
				getShowInfo("FIFTEEN_MINUTES"), getShowInfo("THIRTY_MINUTES")};
	}
	
	public String[] getTemperStatusList() {
		return new String[]{getShowInfo("IDLE"), getShowInfo("ACQUIRING")};
	}
	
	public String getSearchingWait() {
		return bundle.getString("SEARCHING_WAITING");
	}

	


    ///////////// Human Number Statistic ///////////////

    public String getHumanNumberStatistic() {
        return bundle.getString("HUMAN_NUMBER_STATISTIC_TITLE");
    }

    public String getHumanNumberStatisticAttach() {
        return bundle.getString("HUMAN_NUMBER_STATISTIC_CONTROL");
    }

    public String getHumanNumberStatisticEventTitle() {
        return bundle.getString("HUMAN_NUMBER_STATISTIC_EVENT_TITLE");
    }

    public String getHumanNumberStatisticEventChannel() {
        return bundle.getString("HUMAN_NUMBER_STATISTIC_EVENT_CHANNEL");
    }

    public String getHumanNumberStatisticEventTime() {
        return bundle.getString("HUMAN_NUMBER_STATISTIC_EVENT_TIME");
    }

    public String getHumanNumberStatisticEventHourIn() {
        return bundle.getString("HUMAN_NUMBER_STATISTIC_EVENT_HOUR_IN");
    }

    public String getHumanNumberStatisticEventHourOut() {
        return bundle.getString("HUMAN_NUMBER_STATISTIC_EVENT_HOUR_OUT");
    }

    public String getHumanNumberStatisticEventTodayIn() {
        return bundle.getString("HUMAN_NUMBER_STATISTIC_EVENT_TODAY_IN");
    }

    public String getHumanNumberStatisticEventTodayOut() {
        return bundle.getString("HUMAN_NUMBER_STATISTIC_EVENT_TODAY_OUT");
    }

    public String getHumanNumberStatisticEventTotalIn() {
        return bundle.getString("HUMAN_NUMBER_STATISTIC_EVENT_TOTAL_IN");
    }

    public String getHumanNumberStatisticEventTotalOut() {
        return bundle.getString("HUMAN_NUMBER_STATISTIC_EVENT_TOTAL_OUT");
    }

    public String getHumanNumberStatisticEventClearOSD() {
        return bundle.getString("HUMAN_NUMBER_STATIC_EVENT_OSD_CLEAR");
    }
    public String getVTOAlarmEventRoomNo(){
		return bundle.getString("VTO_ALARM_EVENT_ROOM_NO");
	}
	public String getVTOAlarmEventCardNo(){
		return bundle.getString("VTO_ALARM_EVENT_CARD_NO");
	}

	public String getVTOAlarmEventTime(){
		return bundle.getString("VTO_ALARM_EVENT_TIME");
	}
	public String getVTOAlarmEventOpenMethod(){
		return bundle.getString("VTO_ALARM_EVENT_OPEN_METHOD");
	}
	public String getVTOAlarmEventStatus(){
		return bundle.getString("VTO_ALARM_EVENT_STATUS");
	}
	public String getVTORealLoadRoomNO(){
		return bundle.getString("VTO_REAL_LOAD_ROOM_NO");
	}
	public String getVTORealLoadCardNo(){
		return bundle.getString("VTO_REAL_LOAD_CARD_NO");
	}
	public String getVTORealLoadTime(){
		return bundle.getString("VTO_REAL_LOAD_TIME");
	}
	public String getVTORealLoadEventInfo(){
		return bundle.getString("VTO_REAL_LOAD_EVENT_INFO");
	}
	public String getVTOOperateManagerTitle(){
		return bundle.getString("VTO_OPERATE_MANAGER_TITLE");
	}
	public String getInputRoomNo(){
		return bundle.getString("INPUT_ROOM_NO");
	}
	public String getRoomNoExceedLength(){
		return bundle.getString("ROOM_NO_EXCEED_LENGTH");
	}
	public String getVTOOperateManagerRecNo(){
		return bundle.getString("VTO_OPERATE_MANAGER_REC_NO");
	}
	public String getVTOOperateManagerRoomNo(){
		return bundle.getString("VTO_OPERATE_MANAGER_ROOM_NO");
	}
	public String getVTOOperateManagerCardNo(){
		return bundle.getString("VTO_OPERATE_MANAGER_CARD_NO");
	}
	public String getVTOOperateManagerFingerPrintData(){
		return bundle.getString("VTO_OPERATE_MANAGER_FINGER_PRINT_DATA");
	}
	public String getVTOOperateInfoTitle(){
		return bundle.getString("VTO_OPERATE_INFO_TITLE");
	}
	public String getVTOOperateCollectionFingerPrintTitle(){
		return bundle.getString("VTO_OPERATE_COLLECTION_FINGER_PRINT_TITLE");
	}
	public String getDoorOpen(){
		return bundle.getString("DOOR_OPEN");
	}
	public String getDoorClose(){
		return bundle.getString("DOOR_CLOSE");
	}
	public String getEventOperate(){
		return bundle.getString("EVENT_OPERATE");
	}
	public String getStartRealLoad(){
		return bundle.getString("START_REAL_LOAD_PIC");
	}
	public String getStopRealLoad(){
		return bundle.getString("STOP_REAL_LOAD_PIC");
	}
	public String getAlarmEvent(){
		return bundle.getString("ALARM_EVENT");
	}
	public String getRealLoadEvent(){
		return bundle.getString("REAL_LOAD_EVENT");
	}
	public String getCollectionResult(){
		return bundle.getString("COLLECTION_RESULT");
	}
	public String getNeedFingerPrint(){
		return bundle.getString("NEED_FINGER_PRINT");
	}
	public String getFaceInfo(){
		return bundle.getString("FACE_INFO");
	}
	public String getOpen(){
		return bundle.getString("OPEN");
	}

///////////////////////////////////点阵屏设置/////////////////////////////////////、
	public static String getmatrixScreen() {
		// TODO Auto-generated method stub
		return bundle.getString("MATRIX_SCREEN");
	}
	public String getPassingState(){
		return bundle.getString("PASSING_STATE");
	}
	public String getPassingCar(){
		return bundle.getString("PASSING_CAR");
	}
	public String getNoCar(){
		return bundle.getString("NO_CAR");
	}
	public String getInTime(){
		return bundle.getString("IN_TIME");
	}
	public String getOutTime(){
		return bundle.getString("OUT_TIME");
	}
	public String getPlateNumber(){
		return bundle.getString("PLATE_NUMBER");
	}
	public String getCarOwner(){
		return bundle.getString("CAR_OWNER");
	}
	public String getParkingTime(){
		return bundle.getString("PARKING_TIME");
	}
	public String getUserType(){
		return bundle.getString("USER_TYPE");
	}
	public String getMonthlyCardUser(){
		return bundle.getString("MONTHLY_CARD_USER");
	}
	
	public String getAnnualCardUser(){
		return bundle.getString("ANNUAL_CARD_USER");
	}
	
	public String getLongTermUser(){
		return bundle.getString("LONG_TERM_USER");
	}
	
	public String getTemporaryUser(){
		return bundle.getString("TEMPORARY_USER");
	}
	  
	public String getParkingCharge(){
		return bundle.getString("PARKING_CHARGE");
	}
	
	public String getDaysDue(){
		return bundle.getString("DAYS_DUE");
	}
	
	public String getRemainingParkingSpaces(){
		return bundle.getString("REMAINING_PARKING_SPACES");
	}

	public String getVehiclesNotAllowedToPass(){
		return bundle.getString("VEHICLES_NOT_ALLOWED_TO_PASS");
	}
	
	public String getAllowedVehiclesToPass(){
		return bundle.getString("ALLOWED_VEHICLES_TO_PASS");
	}
	
	public String getSetUp(){
		return bundle.getString("SET_UP");
	}
	
	public String getSetUpSuccess(){
		return bundle.getString("SUCCESSFULLY_ISSUED");
	}
	
	public String getSetUpFailed(){
		return bundle.getString("DELIVERY_FAILED");
	}
	
	public String getCostomUserInfo(){
		return bundle.getString("CUSTOM_USER_CLASS");
	}
	
	public String getRemarksInfo(){
		return bundle.getString("REMARKS_INFORMATION");
	}
	
	public String getCostomInfo(){
		return bundle.getString("CUSTOM_INFORMATION");
	}
	public String getVTO() {return bundle.getString("VTO");}
	public String getSCADA() {return bundle.getString("SCADA");}
	public String getModifyCardFaceFailed(){
		return bundle.getString("MODIFY_CARD_FACE_FAILED");
	}
	public String getRemoveCardFaceFailed(){
		return bundle.getString("REMOVE_CARD_FACE_FAILED");
	}
	public String getDownLoadPicture(){
		return bundle.getString("DOWNLOAD_PICTURE");
	}
	
	public String getEnterPicturePath(){
		return bundle.getString("ENTER_PICTURE_PATH");
	}
	
	public String getLoading(){
		return bundle.getString("LOADING");
	}
	
	public String getEndSearch(){
		return bundle.getString("END_SEARCH");
	}
	public String getRemoteOpenDoor(){return bundle.getString("REMOTE_OPEN_DOOR");}
	public String getQueryCardExistFailed(){return bundle.getString("QUERY_CARD_EXIST_FAILED");}
	public String getFindCardExist(){return bundle.getString("CARD_EXIST");}


	public String getSCADADeviceList(){
		return bundle.getString("SCADA_DEVICE_LIST");
	}

	public String getSCADAPointList(){
		return bundle.getString("SCADA_POINT_LIST");
	}

	public String getSCADAAlarmAttachInfo(){
		return bundle.getString("SCADA_ATTACH_ALARM");
	}

	public String getSCADAAttachInfo(){
		return bundle.getString("SCADA_ATTACH_INFO");
	}

	public String getSCADAAttach(){
		return bundle.getString("SCADA_ATTACH");
	}

	public String getListBtn(){
		return bundle.getString("BTN_LIST");
	}


	
	public String getScreenNumber(){return bundle.getString("SCREEN_NUMBER");}
	public String getContain(){return bundle.getString("TEXT_CONTENT");}
	public String getContainType(){return bundle.getString("TEXT_CONTENT_TYPE");}
	public String getContainColor(){return bundle.getString("TEXT_CONTENT_COLOR");}
	public String getScrollType(){return bundle.getString("SCROLL_TYPE");}
	public String getScrollSpeed(){return bundle.getString("SCROLL_SPEED");}
	
	public String getGreen(){return bundle.getString("GREEN");}
	public String getRed(){return bundle.getString("RED");}
	public String getYellow(){return bundle.getString("YELLOW");}
	public String getWhite(){return bundle.getString("WHITE");}
	
	public String getOrdinary(){return bundle.getString("ORDINARY");}
	public String getQRCode(){return bundle.getString("QR_CODE");}
	public String getLocalTime(){return bundle.getString("LOCAL_TIME");}
	public String getResource(){return bundle.getString("RESOURCE");}
	
	public String getNoRolling(){return bundle.getString("NOT_ROLLING");}
	public String getScrollLeftAndRight(){return bundle.getString("SCROLL_LEFT_AND_RIGHT");}
	public String getScrollTopAndDown(){return bundle.getString("SCROLL_UP_AND_DOWN");}
	public String getNumericString(){return bundle.getString("NUMBER_STRING");}
	public String getVoiceText(){return bundle.getString("VOICE_TEXT");}
	public String getIssued(){return bundle.getString("ISSUED");}
	public String getPrompt(){return bundle.getString("PROMPT");}

	public String getDeviceName(){return bundle.getString("DEVICE_NAME");}
	public String getPointID(){return bundle.getString("POINT_ID");}
	public String getPointName(){return bundle.getString("POINT_NAME");}
	public String getIfValidSignalPoint(){return bundle.getString("IF_VALID_SIGNAL_POINT");}
	public String getAlarmDescribe(){return bundle.getString("ALARM_DESCRIBE");}
	public String getAlarmDelay(){return bundle.getString("ALARM_DELAY");}
	public String getAlarmLevel(){return bundle.getString("ALARM_LEVEL");}
	public String getAlarmTime(){return bundle.getString("ALARM_TIME");}
	public String getAlarmType(){return bundle.getString("ALARM_TYPE");}
	public String getCollectTime(){return bundle.getString("COLLECT_TIME");}


}



