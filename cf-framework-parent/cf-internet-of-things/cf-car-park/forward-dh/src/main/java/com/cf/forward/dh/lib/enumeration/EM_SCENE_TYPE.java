package com.cf.forward.dh.lib.enumeration;

/**
 * @author 251823
 * @description 应用场景, 内容与EM_SCENE_CLASS_TYPE一致
 * @date 2021/01/16
 */
public enum EM_SCENE_TYPE {

	// 未知
	EM_SCENE_UNKNOW(0, "未知"),
	// 普通场景
	EM_SCENE_NORMAL(1, "Normal"),
	// 交通场景
	EM_SCENE_TRAFFIC(2, "Traffic"),
	// 交通巡视
	EM_SCENE_TRAFFIC_PATROL(3, "TrafficPatrol"),
	// 人脸检测/人脸识别
	EM_SCENE_FACEDETECTION(4, "FaceDetection"),
	// ATM
	EM_SCENE_ATM(5, "ATM"),
	// 室内行为分析，和普通规则相同，对室内场景的算法优化版
	EM_SCENE_INDOOR(6, "Indoor"),
	// 人脸识别
	EM_SCENE_FACERECOGNITION(7, "FaceRecognition"),
	// 监狱
	EM_SCENE_PRISON(8, "Prison"),
	// 客流量统计
	EM_SCENE_NUMBERSTAT(9, "NumberStat"),
	// 热度图
	EM_SCENE_HEAT_MAP(10, "HeatMap"),
	// 视频诊断
	EM_SCENE_VIDEODIAGNOSIS(11, "VideoDiagnosis"),
	// 车辆特征检测分析
	EM_SCENE_VEHICLEANALYSE(12, "VehicleAnalyse"),
	// 自动录播
	EM_SCENE_COURSERECORD(13, "CourseRecord"),
	// 车载场景(车载行业用，不同于智能交通的Traffic)
	EM_SCENE_VEHICLE(14, "Vehicle"),
	// 起立检测
	EM_SCENE_STANDUPDETECTION(15, "StandUpDetection"),
	// 卡口
	EM_SCENE_GATE(16, "Gate"),
	// 多预置点人脸检测，配置一条规则但可以在不同预置点下生效
	EM_SCENE_SDFACEDETECTION(17, "SDFaceDetect"),
	// 球机热度图计划
	EM_SCENE_HEAT_MAP_PLAN(18, "HeatMapPlan"),
	// 球机客流量统计计划
	EM_SCENE_NUMBERSTAT_PLAN(19, "NumberStatPlan"),
	// 金融人脸检测，包括正常人脸、异常人脸、相邻人脸、头盔人脸等针对ATM场景特殊优化
	EM_SCENE_ATMFD(20, "ATMFD"),
	// 高速交通事件检测
	EM_SCENE_HIGHWAY(21, "Highway"),
	// 城市交通事件检测
	EM_SCENE_CITY(22, "City"),
	// 民用简易跟踪
	EM_SCENE_LETRACK(23, "LeTrack"),
	// 打靶相机
	EM_SCENE_SCR(24, "SCR"),
	// 立体视觉(双目)
	EM_SCENE_STEREO_VISION(25, "StereoVision"),
	// 人体检测
	EM_SCENE_HUMANDETECT(26, "HumanDetect"),
	// 人脸分析(同时支持人脸检测、人脸识别、人脸属性等综合型业务)
	EM_SCENE_FACEANALYSIS(27, "FaceAnalysis"),
	// X光检测
	EM_SCENE_XRAY_DETECTION(28, "XRayDetection"),
	// 双目相机客流量统计
	EM_SCENE_STEREO_NUMBER(29, "StereoNumber"),
	// 人群分布图
	EM_SCENE_CROWD_DISTRI_MAP(30, "CrowdDistriMap"),
	// 目标检测(含人机非等物体)
	EM_SCENE_OBJECTDETECT(31, "ObjectDetect"),
	// IVSS人脸检测
	EM_SCENE_FACEATTRIBUTE(32, "FaceAttribute"),
	// IVSS人脸识别
	EM_SCENE_FACECOMPARE(33, "FaceCompare"),
	// 立体行为分析(典型场景ATM舱)
	EM_SCENE_STEREO_BEHAVIOR(34, "StereoBehavior"),
	// 智慧城管
	EM_SCENE_INTELLICITYMANAGER(35, "IntelliCityMgr"),
	// 防护舱（ATM舱内）
	EM_SCENE_PROTECTIVECABIN(36, "ProtectiveCabin"),
	// 飞机行为检测
	EM_SCENE_AIRPLANEDETECT(37, "AirplaneDetect"),
	// 人群态势（人群分布图服务）
	EM_SCENE_CROWDPOSTURE(38, "CrowdPosture"),
	// 打电话检测
	EM_SCENE_PHONECALLDETECT(39, "PhoneCallDetect"),
	// 烟雾检测
	EM_SCENE_SMOKEDETECTION(40, "SmokeDetection"),
	// 船只检测
	EM_SCENE_BOATDETECTION(41, "BoatDetection"),
	// 吸烟检测
	EM_SCENE_SMOKINGDETECT(42, "SmokingDetect"),
	// 水利监测
	EM_SCENE_WATERMONITOR(43, "WaterMonitor"),
	// 生成图规则
	EM_SCENE_GENERATEGRAPHDETECTION(44, "GenerateGraphDetection"),
	// 交通停车
	EM_SCENE_TRAFFIC_PARK(45, "TrafficPark"),
	// 作业检测
	EM_SCENE_OPERATEMONITOR(46, "OperateMonitor"),
	// 智慧零售大类
	EM_SCENE_INTELLI_RETAIL(47, "IntelliRetail"),
	// 教育智慧课堂
	EM_SCENE_CLASSROOM_ANALYSE(48, "ClassroomAnalyse"),
	// 特征向量提取大类
	EM_SCENE_FEATURE_ABSTRACT(49, "FeatureAbstract"),
	// 人体检测
	EM_SCENE_FACEBODY_DETECT(50, "FaceBodyDetect"),
	// 人体识别
	EM_SCENE_FACEBODY_ANALYSE(51, "FaceBodyAnalyse"),
	// 车辆密度
	EM_SCENE_VEHICLES_DISTRI(52, "VehiclesDistri"),
	// 智慧养殖检测
	EM_SCENE_INTELLI_BREED(53, "IntelliBreed"),
	// 监狱行为分析
	EM_SCENE_INTELLI_PRISON(54, "IntelliPrison"),
	// 电力检测
	EM_SCENE_ELECTRIC_DETECT(55, "ElectricDetect"),
	// 雷检检测
	EM_SCENE_RADAR_DETECT(56, "RadarDetect"),
	// 车位检测大类
	EM_SCENE_PARKINGSPACE(57, "ParkingSpace"),
	// 智慧金融
	EM_SCENE_INTELLI_FINANCE(58, "IntelliFinance"),
	// CrowdAbnormal
	EM_SCENE_CROWD_ABNORMAL(59, "CrowdAbnormal"),
	// 超温检测
	EM_SCENE_ANATOMYTEMP_DETECT(60, "AnatomyTempDetect"),
	// 天气监控
	EM_SCENE_WEATHER_MONITOR(61, "WeatherMonitor"),
	// 电梯门禁
	EM_SCENE_ELEVATOR_ACCESS_CONTROL(62, "ElevatorAccessControl"),
	// 违章建筑
	EM_SCENE_BREAK_RULE_BUILDING(63, "BreakRuleBuilding"),
	// 全景交通
	EM_SCENE_PANORAMA_TRAFFIC(64, "PanoramaTraffic"),
	// 人像检测
	EM_SCENE_PORTRAIT_DETECT(65, "PortraitDetect"),
	// 传送带阻塞
	EM_SCENE_CONVEY_OR_BLOCK(66, "ConveyorBlock"),
	// 厨房有害动物检测
	EM_SCENE_KITCHEN_ANIMAL(67, "KitchenAnimal"),
	// 万物检测
	EM_SCENE_ALLSEEINGEYE(68, "AllSeeingEye"),
	// 驾驶行为分析
	EM_SCENE_DRIVE(69, "Drive"),
	// 高级驾驶辅助系统
	EM_SCENE_DRIVEASSISTANT(70, "DriveAssistant"),
	// 车内驾驶舱监测
	EM_SCENE_INCABINMONITOR(71, "InCabinMonitor"),
	// 盲区检测
	EM_SCENE_BLINDSPOTDETECTION(72, "BlindSpotDetection");

	private int value;
	private String note;

	private EM_SCENE_TYPE(int givenValue, String note) {
		this.value = givenValue;
		this.note = note;
	}

	public String getNote() {
		return note;
	}

	public int getValue() {
		return value;
	}

	public static String getNoteByValue(int givenValue) {
		for (EM_SCENE_TYPE enumType : EM_SCENE_TYPE.values()) {
			if (givenValue == enumType.getValue()) {
				return enumType.getNote();
			}
		}
		return null;
	}

	public static int getValueByNote(String givenNote) {
		for (EM_SCENE_TYPE enumType : EM_SCENE_TYPE.values()) {
			if (givenNote.equals(enumType.getNote())) {
				return enumType.getValue();
			}
		}
		return -1;
	}

}
