package com.cf.forward.dh.listener;

import cn.hutool.http.HttpUtil;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.cf.carpark.device.camera.hk.HkRequestParam;
import com.cf.carpark.device.camera.hk.HkResponse;
import com.cf.carpark.device.led.ShowContent;
import com.cf.carpark.device.led.TextPlay;
import com.cf.carpark.device.led.VoicePlay;
import com.cf.carpark.domain.type.DeviceBrand;
import com.cf.forward.dh.config.DhForwardProperties;
import com.cf.forward.dh.entity.CameraInfo;
import com.cf.forward.dh.entity.LedConfig;
import com.cf.forward.dh.entity.LedContents;
import com.cf.forward.dh.entity.LogInfo;
import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.ToolKits;
import com.cf.forward.dh.module.AlarmListenModule;
import com.cf.forward.dh.module.DeviceControlModule;
import com.cf.forward.dh.module.LoginModule;
import com.cf.forward.dh.utils.SpringContextUtil;
import com.cf.forward.dh.yangbang.YangBangController;
import com.cf.framework.utils.BeanUtils;
import com.cf.framework.utils.IdWorker;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jna.Pointer;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Socket;
import java.util.*;

public class AlarmListener {

	public static Map<String, CameraInfo> cameraInfoList;
	private static Logger logger = LoggerFactory.getLogger(AlarmListener.class);

	public static boolean openHeartbeatMinitor = false;

	public Map<String, CameraInfo> getCameraInfo(){
		return cameraInfoList;
	}

	/**
	 * 初始化设备
	 */
	public void  init(){
		if (!LoginModule.init(new DisConnect(), new HaveReConnect())){
			logger.error("初始化设备失败");
			throw new RuntimeException("初始化设备失败");
		}
	}

	//登录摄像
	public boolean login(CameraInfo camera) {
		if(LoginModule.login(
				camera.getIp(),
				camera.getPort(),
				camera.getUsername(),
				camera.getPassword(),
				camera.getUuid())) {

		} else {
			throw new RuntimeException("登录失败：");
		}
		return true;
	}

	//摄像头退出登录
	public void logout() {
		AlarmListenModule.stopListen();
		LoginModule.cleanup();
	}

	//监听警报
	public boolean listen(CameraInfo camera){
		if(AlarmListenModule.startListen(analyzerDataCB, camera.getUuid())){
			logger.info("监听成功");
			heartBeatMonitor(camera);
		}else{
			logger.error("监听失败");
			throw new RuntimeException("监听失败");
		}
		return true;
	}

	//停止监听
	public void stopListen(){
		AlarmListenModule.stopListen();
	}


	public void start(CameraInfo camera) throws IOException {
		if(AlarmListener.cameraInfoList==null){
			AlarmListener.cameraInfoList = new HashMap<>();
		}
		System.out.println("已启动设备序号为:"+camera.getUuid());
		AlarmListener.cameraInfoList.put(camera.getUuid(), camera);
		//初始化设备
		LoginModule.init(new DisConnect(), new HaveReConnect());
		/**
		 * 1、进行登录操作
		 * 2、进行报警监听
		 */
		if (login(camera)){
			listen(camera);
		}
//        while (true){}
	}

	public void send(HkRequestParam hkRequestParam, byte[] bigImageByte, byte[] smallImageByte){
	    try {
			IdWorker idWorker = SpringContextUtil.getBean(IdWorker.class);

			HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
			hkRequestParam.setBigImage("");
			hkRequestParam.setSmallImage("");
			hkRequestParam.setBigImagePath(idWorker.nextId()+".jpg");
			if(StringUtils.isEmpty(hkRequestParam.getCarNo())){
				hkRequestParam.setCarNo("无牌车");
			}
//			hkRequestParam.setSmallImagePath(idWorker.nextId()+".jpg");
			final String smallFileNameFinal = hkRequestParam.getSmallImagePath();
			final String bigFileNameFinal = hkRequestParam.getBigImagePath();

			Thread thread = new Thread(new Runnable() {
				@SneakyThrows
				@Override
				public void run() {
					//异步上传文件到oss
					try {
						if(bigImageByte!=null && bigImageByte.length>0){
							aliOssUpload(bigImageByte,bigFileNameFinal);
						}
						if(smallImageByte!=null && smallImageByte.length>0){
							aliOssUpload(smallImageByte,smallFileNameFinal);
						}
					} catch (Exception e) {

					}
				}
			});
			thread.start();
			ObjectMapper mapper = new ObjectMapper();
			String body = null;
			try {
				body = mapper.writeValueAsString(hkRequestParam);
			} catch (JsonProcessingException e) {
				logger.info("参赛序列化失败");
			}
			try {
				CameraInfo cameraInfo = AlarmListener.cameraInfoList.get(hkRequestParam.getSerialNo());
				String res = HttpUtil.post(cameraInfo.getServer()+"/carparklog/add?deviceBrand=dh", body);
				HkResponse hkResponse = mapper.readValue(res, HkResponse.class);
				//控制开关闸
				if(hkResponse.getOpenDoor().equals("on")){
					DeviceControlModule.New_OpenStrobe(cameraInfo);
				}else{
//					DeviceControlModule.New_CloseStrobe(cameraInfo);
				}

				//控制显示屏显示
				if(hkResponse.getPlayRule()!=null){
					if(StringUtils.isNotEmpty(ListenerStarter.propertiesCache.getLedBrand()) && ListenerStarter.propertiesCache.getLedBrand().equals("yang_bang")){
						List<String> contents = new ArrayList<>();
						if(StringUtils.isNotEmpty(hkResponse.getPlayRule().getApproach().getTextPlay().get("1").getValue())){
							for(Map.Entry<String, TextPlay> textPlayEntry : hkResponse.getPlayRule().getApproach().getTextPlay().entrySet()){
								TextPlay textPlay = hkResponse.getPlayRule().getApproach().getTextPlay().get(textPlayEntry.getKey());
								if( StringUtils.isNotEmpty(textPlay.getValue()) ){
									contents.add(textPlay.getValue());
								}
							}
						}else if(hkResponse.getPlayRule().getPayOut().getTextPlay().containsKey("1")){
							for(Map.Entry<String, TextPlay> textPlayEntry : hkResponse.getPlayRule().getPayOut().getTextPlay().entrySet()){
								TextPlay textPlay = hkResponse.getPlayRule().getPayOut().getTextPlay().get(textPlayEntry.getKey());
								if( StringUtils.isNotEmpty(textPlay.getValue()) ){
									contents.add(textPlay.getValue());
								}
							}
						}else if(hkResponse.getPlayRule().getAbnormalOut().getTextPlay().containsKey("1")){
							for(Map.Entry<String, TextPlay> textPlayEntry : hkResponse.getPlayRule().getAbnormalOut().getTextPlay().entrySet()){
								TextPlay textPlay = hkResponse.getPlayRule().getAbnormalOut().getTextPlay().get(textPlayEntry.getKey());
								if( StringUtils.isNotEmpty(textPlay.getValue()) ){
									contents.add(textPlay.getValue());
								}
							}
						}else if(hkResponse.getPlayRule().getFreeOut().getTextPlay().containsKey("1")){
							for(Map.Entry<String, TextPlay> textPlayEntry : hkResponse.getPlayRule().getFreeOut().getTextPlay().entrySet()){
								TextPlay textPlay = hkResponse.getPlayRule().getFreeOut().getTextPlay().get(textPlayEntry.getKey());
								if( StringUtils.isNotEmpty(textPlay.getValue()) ){
									contents.add(textPlay.getValue());
								}
							}
						}
						List<LedConfig> ledConfigs = ListenerStarter.propertiesCache.getLedConfigs();
						if(ledConfigs.size()>0){
							for(LedConfig ledConfig : ledConfigs){
								if(ledConfig.getUuid().equals(hkRequestParam.getSerialNo())){
									YangBangController.showText(ledConfig.getIp(), ledConfig.getPort(), contents);
								}

							}
						}
					}else{
						handleShowAndPaly(hkResponse.getPlayRule().getApproach(), cameraInfo);
						handleShowAndPaly(hkResponse.getPlayRule().getPayOut(), cameraInfo);
						handleShowAndPaly(hkResponse.getPlayRule().getAbnormalOut(), cameraInfo);
						handleShowAndPaly(hkResponse.getPlayRule().getFreeOut(), cameraInfo);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
        }catch (Exception e){
            logger.error("车牌发送错误",e);
        }
	}

	private String aliOssUpload(byte[] bytes, String filename) throws Exception{

		// 创建OSSClient实例。
		OSS ossClient = new OSSClientBuilder().build("请输入否则无法正常图片", "请输入否则无法正常图片", "请输入否则无法正常图片");

		//上传文件的输入流
		InputStream inputStream = new ByteArrayInputStream(bytes);

		// 创建PutObjectRequest对象。
		//第一个参数 Bucket名称
		//第二个参数 上传到oss文件路径和文件名称
		//第三个参数 上传文件输入流



		PutObjectRequest putObjectRequest = new PutObjectRequest("请输入否则无法正常图片", filename, inputStream);

		// 如果需要上传时设置存储类型与访问权限，请参考以下示例代码。
		// ObjectMetadata metadata = new ObjectMetadata();
		// metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
		// metadata.setObjectAcl(CannedAccessControlList.Private);
		// putObjectRequest.setMetadata(metadata);

		// 上传文件。
		PutObjectResult putObjectResult = ossClient.putObject(putObjectRequest);

		// 关闭OSSClient。
		ossClient.shutdown();
		return filename;
	}

	private void handleShowAndPaly(ShowContent showContent, CameraInfo cameraInfo) throws Exception{
		LedContents ledContents = new LedContents();
		//文本
		Map<String, TextPlay> textPlayList = showContent.getTextPlay();
		List<String> showContents = new ArrayList<>();
		for (Map.Entry<String, TextPlay> item: textPlayList.entrySet()){
			TextPlay textPlay = null;
			if(!(item.getValue() instanceof TextPlay)){
				textPlay = BeanUtils.deepMapToBean(TextPlay.class.newInstance().getClass(), (Map) item.getValue());
			}else{
				textPlay = item.getValue();
			}
			Integer serialChannel = 0;
			if(!(textPlay.getSerialChannel() instanceof Integer)){
				serialChannel = Integer.parseInt(textPlay.getSerialChannel()+"");
			}

			Integer row = 1;
			row = Integer.parseInt(item.getKey()+"");

			if(textPlay.getStatus()==1 && org.apache.commons.lang3.StringUtils.isNotEmpty(textPlay.getValue())){
				//先直接显示，暂时不管其它参数
				showContents.add(textPlay.getValue());
			}else if(row==2 && org.apache.commons.lang3.StringUtils.isEmpty(textPlay.getValue())){
				return;
			}
		}
		if(showContents.size()>0){
			ledContents.setContents1(showContents.get(0));
			ledContents.setContents2(showContents.get(1));
			if(showContents.size()>2){
				ledContents.setContents3(showContents.get(2));
				ledContents.setContents4(showContents.get(3));
			}
		}

		//语音
		Map<Integer, VoicePlay> voicePlayList = showContent.getVoicePlay();
		String playContents = "";
		int i = 0;
		for (Map.Entry<Integer, VoicePlay> item: voicePlayList.entrySet()){
			VoicePlay voicePlay = null;
			if(!(item.getValue() instanceof VoicePlay)){
				voicePlay = BeanUtils.deepMapToBean(VoicePlay.class.newInstance().getClass(), (Map) item.getValue());
			}else{
				voicePlay = item.getValue();
			}
			Integer serialChannel = 0;
			if(!(voicePlay.getSerialChannel() instanceof Integer)){
				serialChannel = Integer.parseInt(voicePlay.getSerialChannel()+"");
			}

			Integer row = 1;
			if(!(item.getKey() instanceof Integer)){
				row = Integer.parseInt(item.getKey()+"");
			}
			if(voicePlay.getStatus()==1 && StringUtils.isNotEmpty(voicePlay.getValue()) && i>0){
				//先播报示，暂时不管其它参数
				playContents += voicePlay.getValue();
			}
			i++;
		}
		if(StringUtils.isNotEmpty(playContents)) {
			//执行播报
			playContents = playContents.replace(".","点");
			ledContents.setVoiceContents(playContents);
		}else{
			return;
		}
		DeviceControlModule.playVoice(ledContents, cameraInfo);
	}

	/**
	 * 心跳监听
	 */
	public void heartBeatMonitor(CameraInfo camera){
		HkRequestParam dhRequestParamMoniter = new HkRequestParam();

		if(!camera.getOpenHeartbeatMinitor()){
			camera.setOpenHeartbeatMinitor(true);
			dhRequestParamMoniter.setDeviceBrand(DeviceBrand.DH);
			dhRequestParamMoniter.setSerialNo(camera.getUuid());
			logger.info("大华执行心跳包请求");
			//开启死循环发心跳包
			while (true){
				try{
					ObjectMapper mapper = new ObjectMapper();
					String body = null;
					Thread.sleep(1000); //延时1秒
					body = mapper.writeValueAsString(dhRequestParamMoniter);
					String res = HttpUtil.post(camera.getServer()+"/carparklog/pollingMonitoring?deviceBrand="+dhRequestParamMoniter.getDeviceBrand(), body);
					if(StringUtils.isEmpty(res)){
						continue;
					}
					HkResponse hkResponse = mapper.readValue(res, HkResponse.class);
					//控制开关闸
					if(hkResponse.getOpenDoor()!=null && hkResponse.getOpenDoor().equals("on")){
						//开闸
						DeviceControlModule.New_OpenStrobe(camera);
					}else if(hkResponse.getOpenDoor()!=null && hkResponse.getOpenDoor().equals("off")){
						//关闸
						DeviceControlModule.New_CloseStrobe(camera);
					}else if(hkResponse.getCaptureFrequency()!=null && hkResponse.getCaptureFrequency().byteValue()>(byte)0){
						//抓拍
						DeviceControlModule.capture(camera);
					}

					//控制显示屏显示
					if(hkResponse.getPlayRule()!=null){
						handleShowAndPaly(hkResponse.getPlayRule().getApproach(), camera);
						handleShowAndPaly(hkResponse.getPlayRule().getPayOut(), camera);
						handleShowAndPaly(hkResponse.getPlayRule().getAbnormalOut(), camera);
						handleShowAndPaly(hkResponse.getPlayRule().getFreeOut(), camera);
					}
				} catch (Exception e) {
					e.printStackTrace();
					continue;
				}
			}
		}
	}

	/////////////////以下是大华功能区域：function///////////////////
	////JNA Callback方法定义,断线回调
	private class DisConnect implements NetSDKLib.fDisConnect {
		public DisConnect() { }
		public void invoke(NetSDKLib.LLong m_hLoginHandle, String pchDVRIP, int nDVRPort, Pointer dwUser) {
			System.out.printf("Device[%s] Port[%d] DisConnect!\n", pchDVRIP, nDVRPort);
			LogInfo logInfo = new LogInfo()
					.getConnectLog("com.cf.forward.dh.listener.AlarmListener.DisConnect.invoke()",
							"尝试重连",
							pchDVRIP,
							nDVRPort+"");
		}
	}

	// device reconnect(success) callback class
	// 网络连接恢复回调函数原形
	private static class HaveReConnect implements NetSDKLib.fHaveReConnect {
		public void invoke(NetSDKLib.LLong m_hLoginHandle, String pchDVRIP, int nDVRPort, Pointer dwUser) {
			logger.info("ReConnect Device[%s] Port[%d]\n", pchDVRIP, nDVRPort);
			LogInfo logInfo = new LogInfo()
					.getConnectLog("com.cf.forward.dh.listener.AlarmListener.HaveReConnect.invoke()",
							"重连成功",
							pchDVRIP,
							nDVRPort+"");
		}
	}


	private AnalyzerDataCB analyzerDataCB = new AnalyzerDataCB();
	/*
	 * 智能报警事件回调
	 */
	public class AnalyzerDataCB implements NetSDKLib.fAnalyzerDataCallBack {
		public int invoke(NetSDKLib.LLong lAnalyzerHandle, int dwAlarmType,
						  Pointer pAlarmInfo, Pointer pBuffer, int dwBufSize,
						  Pointer dwUser, int nSequence, Pointer reserved)
		{
			if (lAnalyzerHandle.longValue() == 0) {
				return -1;
			}
			String uuid = LoginModule.uuidTologinHandleList.get(lAnalyzerHandle.longValue());

			//0x00000017
			if(dwAlarmType == NetSDKLib.EVENT_IVS_TRAFFICJUNCTION || dwAlarmType == NetSDKLib.EVENT_IVS_TRAFFIC_MANUALSNAP) {
				// 获取识别对象 车身对象 事件发生时间 车道号等信息
				GetStuObject(dwAlarmType, pAlarmInfo, pBuffer, dwBufSize, uuid);
				// 保存图片，获取图片缓存
//				savePlatePic(pBuffer, dwBufSize, trafficInfo);

			}

			return 0;
		}

		// 获取识别对象 车身对象 事件发生时间 车道号等信息
		private void GetStuObject(int dwAlarmType, Pointer pAlarmInfo, Pointer pBuffer, int dwBufferSize, String uuid)  {
			if(pAlarmInfo == null) {
				return;
			}

			if(dwAlarmType == NetSDKLib.EVENT_IVS_TRAFFICJUNCTION || dwAlarmType == NetSDKLib.EVENT_IVS_TRAFFIC_MANUALSNAP) {
				NetSDKLib.DEV_EVENT_TRAFFICJUNCTION_INFO msg = new NetSDKLib.DEV_EVENT_TRAFFICJUNCTION_INFO();
				ToolKits.GetPointerData(pAlarmInfo, msg);

//					trafficInfo.m_EventName = Res.string().getEventName(NetSDKLib.EVENT_IVS_TRAFFICJUNCTION);
				try {
					trafficInfo.m_PlateNumber = new String(msg.stuObject.szText, ListenerStarter.coding).trim();
					HkRequestParam hkRequestParam = new HkRequestParam();
					hkRequestParam.setCarNo(trafficInfo.m_PlateNumber);
					hkRequestParam.setSerialNo(uuid);
					hkRequestParam.setPlateColor(new String(msg.stTrafficCar.szPlateColor).trim());
					byte[] bigImageByte = null;
					if (pBuffer != null && dwBufferSize > 0 ) {
						bigImageByte = pBuffer.getByteArray(0, dwBufferSize);
					}
//						byte[] smallImageByte = getSmallImageByte(pBuffer, dwBufferSize, trafficInfo);

					send(hkRequestParam, bigImageByte, null);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
//					trafficInfo.m_PlateType = new String(msg.stTrafficCar.szPlateType).trim();
//					trafficInfo.m_FileCount = String.valueOf(msg.stuFileInfo.bCount);
//					trafficInfo.m_FileIndex = String.valueOf(msg.stuFileInfo.bIndex);
//					trafficInfo.m_GroupID =  String.valueOf(msg.stuFileInfo.nGroupId);
//					trafficInfo.m_IllegalPlace = ToolKits.GetPointerDataToByteArr(msg.stTrafficCar.szDeviceAddress);
//					trafficInfo.m_LaneNumber = String.valueOf(msg.nLane);
//					trafficInfo.m_PlateColor = new String(msg.stTrafficCar.szPlateColor).trim();
//					trafficInfo.m_VehicleColor = new String(msg.stTrafficCar.szVehicleColor).trim();
//					trafficInfo.m_VehicleType = new String(msg.stuVehicle.szObjectSubType).trim();
//					trafficInfo.m_VehicleSize = Res.string().getTrafficSize(msg.stTrafficCar.nVehicleSize);
//					trafficInfo.m_Utc = msg.UTC;
//					trafficInfo.m_bPicEnble = msg.stuObject.bPicEnble;
//					trafficInfo.m_OffSet = msg.stuObject.stPicInfo.dwOffSet;
//					trafficInfo.m_FileLength = msg.stuObject.stPicInfo.dwFileLenth;
//					trafficInfo.m_BoundingBox = msg.stuObject.BoundingBox;
			}
		}

	}

	/*
	 * 保存车牌小图:大华早期交通抓拍机，设备不传单独的车牌小图文件，只传车牌在大图中的坐标;由应用来自行裁剪。
	 * 2014年后，陆续有设备版本，支持单独传车牌小图，小图附录在pBuffer后面。
	 */
	private byte[] getSmallImageByte(Pointer pBuffer, int dwBufferSize, TRAFFIC_INFO trafficInfo) {

		String bigPicture; // 大图
		String platePicture; // 车牌图
		BufferedImage snapImage = null;
		BufferedImage plateImage = null;

		if (pBuffer == null || dwBufferSize <= 0 ) {
			return null;
		}
// 保存大图
		byte[] buffer = pBuffer.getByteArray(0, dwBufferSize);
		ByteArrayInputStream byteArrInput = new ByteArrayInputStream(buffer);

		try {
			snapImage = ImageIO.read(byteArrInput);
			if(snapImage == null) {
				return null;
			}
		} catch (IOException e2) {
			e2.printStackTrace();
		}

		if (trafficInfo.m_bPicEnble == 1) {
			//根据pBuffer中数据偏移保存小图图片文件
			if (trafficInfo.m_FileLength > 0) {

				int size = 0;
				if(dwBufferSize <= trafficInfo.m_OffSet) {
					return null;
				}

				if(trafficInfo.m_FileLength <= dwBufferSize - trafficInfo.m_OffSet) {
					size = trafficInfo.m_FileLength;
				} else {
					size = dwBufferSize - trafficInfo.m_OffSet;
				}
				byte[] bufPlate = pBuffer. getByteArray(trafficInfo.m_OffSet, size);
				ByteArrayInputStream byteArrInputPlate = new ByteArrayInputStream(bufPlate);
				try {
					plateImage = ImageIO.read(byteArrInputPlate);
					if(plateImage == null) {
						return null;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		else {
			if(trafficInfo.m_BoundingBox == null) {
				return null;
			}
			//根据大图中的坐标偏移计算显示车牌小图

			NetSDKLib.DH_RECT dhRect = trafficInfo.m_BoundingBox;
			//1.BoundingBox的值是在8192*8192坐标系下的值，必须转化为图片中的坐标
			//2.OSD在图片中占了64行,如果没有OSD，下面的关于OSD的处理需要去掉(把OSD_HEIGHT置为0)
			final int OSD_HEIGHT = 0;

			long nWidth = snapImage.getWidth(null);
			long nHeight = snapImage.getHeight(null);

			nHeight = nHeight - OSD_HEIGHT;
			if ((nWidth <= 0) || (nHeight <= 0)) {
				return null;
			}

			NetSDKLib.DH_RECT dstRect = new NetSDKLib.DH_RECT();

			dstRect.left.setValue((long)((double)(nWidth * dhRect.left.longValue()) / 8192.0));
			dstRect.right.setValue((long)((double)(nWidth * dhRect.right.longValue()) / 8192.0));
			dstRect.bottom.setValue((long)((double)(nHeight * dhRect.bottom.longValue()) / 8192.0));
			dstRect.top.setValue((long)((double)(nHeight * dhRect.top.longValue()) / 8192.0));

			int x = dstRect.left.intValue();
			int y = dstRect.top.intValue() + OSD_HEIGHT;
			int w = dstRect.right.intValue() - dstRect.left.intValue();
			int h = dstRect.bottom.intValue() - dstRect.top.intValue();

			if(x == 0 || y == 0 || w <= 0 || h <= 0) {
				return null;
			}

			try {
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				plateImage = snapImage.getSubimage(x, y, w, h);
				out.toByteArray();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	enum AlarmStatus {
		ALARM_START, ALARM_STOP
	}

	// struct of alarm event
	static class AlarmEventInfo {
		public static long index = 0;
		public long id;
		public int chn;
		public int type;
		public Date date;
		public AlarmStatus status;

		public AlarmEventInfo(int chn, int type, AlarmStatus status) {
			this.chn = chn;
			this.type = type;
			this.status = status;
			this.date = new Date();
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			AlarmEventInfo showInfo = (AlarmEventInfo) o;
			return chn == showInfo.chn && type == showInfo.type;
		}
	}

	private class TRAFFIC_INFO {
		private String m_EventName;         	  // 事件名称
		private String m_PlateNumber;       	  // 车牌号
		private String m_PlateType;               // 车牌类型
		private String m_PlateColor;      	  	  // 车牌颜色
		private String m_VehicleColor;    	  	  // 车身颜色
		private String m_VehicleType;       	  // 车身类型
		private String m_VehicleSize;     	  	  // 车辆大小
		private String m_FileCount;				  // 文件总数
		private String m_FileIndex;				  // 文件编号
		private String m_GroupID;				  // 组ID
		private String m_IllegalPlace;			  // 违法地点
		private String m_LaneNumber;              // 通道号
		private NetSDKLib.NET_TIME_EX m_Utc;      // 事件时间
		private int m_bPicEnble;       	  		  // 车牌对应信息，BOOL类型
		private int m_OffSet;          	  		  // 车牌偏移量
		private int m_FileLength;                 // 文件大小
		private NetSDKLib.DH_RECT m_BoundingBox;  // 包围盒
	}

	private final TRAFFIC_INFO trafficInfo = new TRAFFIC_INFO();
}
