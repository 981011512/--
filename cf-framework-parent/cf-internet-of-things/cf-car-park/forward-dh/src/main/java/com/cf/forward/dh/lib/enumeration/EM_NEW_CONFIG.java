package com.cf.forward.dh.lib.enumeration;

import com.cf.forward.dh.lib.NetSDKLib;
import com.sun.jna.ptr.IntByReference;

/**
 * @author 47081
 * @version 1.0
 * @description 配置命令 对应接口{@link NetSDKLib#CLIENT_GetNewDevConfig(NetSDKLib.LLong, String, int,
 *     byte[], int, IntByReference, int)} {@link NetSDKLib#CLIENT_SetNewDevConfig(NetSDKLib.LLong,
 *     String, int, byte[], int, IntByReference, IntByReference, int)}
 * @date 2020/11/9
 */
public enum EM_NEW_CONFIG {
  /** 视频编码物件配置(对应 {@link NetSDKLib.NET_CFG_VideoWidget} ) */
  CFG_CMD_VIDEOWIDGET("VideoWidget"),
  /** 视频分析全局配置(对应{@link NetSDKLib.CFG_ANALYSEGLOBAL_INFO}) */
  CFG_CMD_ANALYSEGLOBAL("VideoAnalyseGlobal"),
  /** 物体的检测模块配置(对应 {@link NetSDKLib.CFG_ANALYSEMODULES_INFO}) */
  CFG_CMD_ANALYSEMODULE("VideoAnalyseModule"),
  /** 视频分析规则配置(对应 {@link NetSDKLib.CFG_ANALYSERULES_INFO}) */
  CFG_CMD_ANALYSERULE("VideoAnalyseRule"),
  /** 视频输入前端选项(对应{@link NetSDKLib.CFG_VIDEO_IN_OPTIONS}) */
  CFG_CMD_VIDEOINOPTIONS("VideoInOptions"),
  /** 雨刷模式相关配置(对应{@link NetSDKLib.CFG_RAINBRUSHMODE_INFO}数组) */
  CFG_CMD_RAINBRUSHMODE("RainBrushMode"),
  /** 雨刷配置(对应{@link NetSDKLib.CFG_RAINBRUSH_INFO}) */
  CFG_CMD_RAINBRUSH("RainBrush"),
  /** 图像通道属性配置(对应{@link NetSDKLib.CFG_ENCODE_INFO}) */
  CFG_CMD_ENCODE("Encode"),
  /** 云台通道变倍配置(对应{@link NetSDKLib.CFG_VIDEO_IN_ZOOM}) */
  CFG_CMD_VIDEO_IN_ZOOM("VideoInZoom"),
  /** 远程设备信息(对应 {@link NetSDKLib.AV_CFG_RemoteDevice} 数组), 通道无关) */
  CFG_CMD_REMOTEDEVICE("RemoteDevice"),
  /** 视频分析资源配置(对应 {@link NetSDKLib.CFG_ANALYSESOURCE_INFO}) */
  CFG_CMD_ANALYSESOURCE("VideoAnalyseSource"),
  /** 智能交通全局配置({@link NetSDKLib.CFG_TRAFFICGLOBAL_INFO}) */
  CFG_CMD_TRAFFICGLOBAL("TrafficGlobal"),
  /** 录像模式(对应 {@link NetSDKLib.AV_CFG_RecordMode} ) */
  CFG_CMD_RECORDMODE("RecordMode"),
  /** 警灯配置(对应 {@link NetSDKLib.CFG_ALARMLAMP_INFO}) */
  CFG_CMD_ALARMLAMP("AlarmLamp"),
  /** 报警输出通道配置(对应 {@link NetSDKLib.CFG_ALARMOUT_INFO} ) */
  CFG_CMD_ALARMOUT("AlarmOut"),
  /** 智能交通抓拍(对应 {@link NetSDKLib.CFG_TRAFFICSNAPSHOT_INFO} ) */
  CFG_CMD_INTELLECTIVETRAFFIC("TrafficSnapshot"),
  /** 智能交通抓拍( {@link NetSDKLib.CFG_TRAFFICSNAPSHOT_NEW_INFO} ) */
  CFG_CMD_TRAFFICSNAPSHOT_MULTI("TrafficSnapshotNew"),
  /** 时间同步服务器(对应 {@link NetSDKLib.CFG_NTP_INFO} ) */
  CFG_CMD_NTP("NTP"),
  /** 外部输入报警配置(对应 CFG_ALARMIN_INFO) */
  CFG_CMD_ALARMINPUT("Alarm"),
  /** 网络协议配置(对应 {@link NetSDKLib.CFG_DVRIP_INFO}) */
  CFG_CMD_DVRIP("DVRIP"),
  /** 网络配置(对应 {@link NetSDKLib.CFG_NETWORK_INFO}) */
  CFG_CMD_NETWORK("Network"),
  /** 电视墙配置(对应 {@link NetSDKLib.AV_CFG_MonitorWall} 数组), 通道无关) */
  CFG_CMD_MONITORWALL("MonitorWall"),
  /** RTMP配置(对应 {@link NetSDKLib.CFG_RTMP_INFO}) */
  CFG_CMD_RTMP("RTMP"),
  /** 门禁事件配置(对应 {@link NetSDKLib.CFG_ACCESS_EVENT_INFO} 数组) */
  CFG_CMD_ACCESS_EVENT("AccessControl"),
  /** 门禁刷卡时间段(对应 {@link NetSDKLib.CFG_ACCESS_TIMESCHEDULE_INFO}) */
  CFG_CMD_ACCESSTIMESCHEDULE("AccessTimeSchedule"),
  /** 普通配置 (对应 {@link NetSDKLib.CFG_DEV_DISPOSITION_INFO}) */
  CFG_CMD_DEV_GENERRAL("General"),
  /** 视频诊断参数表({@link NetSDKLib.CFG_VIDEODIAGNOSIS_PROFILE}) */
  CFG_CMD_VIDEODIAGNOSIS_PROFILE("VideoDiagnosisProfile"),
  /** 视频诊断任务表({@link NetSDKLib.CFG_VIDEODIAGNOSIS_TASK}) */
  CFG_CMD_VIDEODIAGNOSIS_TASK("VideoDiagnosisTask"),
  /** 视频诊断任务表({@link NetSDKLib.CFG_VIDEODIAGNOSIS_TASK}) */
  CFG_CMD_VIDEODIAGNOSIS_TASK_ONE("VideoDiagnosisTask.x"),
  /** 视频诊断计划表({@link NetSDKLib.CFG_VIDEODIAGNOSIS_PROJECT}) */
  CFG_CMD_VIDEODIAGNOSIS_PROJECT("VideoDiagnosisProject"),
  /** 热成像摄像头属性配置({@link NetSDKLib.CFG_THERMOGRAPHY_INFO}) */
  CFG_CMD_THERMO_GRAPHY("ThermographyOptions"),
  /** 热成像测温规则配置(对应 {@link NetSDKLib.CFG_RADIOMETRY_RULE_INFO}) */
  CFG_CMD_THERMOMETRY_RULE("ThermometryRule"),
  /** 温度统计配置({@link NetSDKLib.CFG_TEMP_STATISTICS_INFO}) */
  CFG_CMD_TEMP_STATISTICS("TemperatureStatistics"),
  /** 热成像测温全局配置({@link NetSDKLib.CFG_THERMOMETRY_INFO}) */
  CFG_CMD_THERMOMETRY("HeatImagingThermometry"),
  /** 通道录像组状态(对应 {@link NetSDKLib.CFG_DEVRECORDGROUP_INFO}) */
  CFG_CMD_DEVRECORDGROUP("DevRecordGroup"),
  /** 存储组信息(对应 {@link NetSDKLib.AV_CFG_StorageGroup}数组), 通道无关) */
  CFG_CMD_STORAGEGROUP("StorageGroup"),
  /** 云台巡航路径配置(对应 {@link NetSDKLib.CFG_PTZTOUR_INFO}) */
  CFG_CMD_PTZTOUR("PtzTour"),
  /** 云台预置点配置(对应结构 {@link NetSDKLib.PTZ_PRESET_INFO}) */
  CFG_CMD_PTZ_PRESET("PtzPreset"),
  /** 输入通道配置(对应 {@link NetSDKLib.CFG_VIDEO_IN_INFO}) */
  CFG_CMD_VIDEOIN("VideoIn"),
  /** 通道名称(对应 {@link NetSDKLib.AV_CFG_ChannelName}) */
  CFG_CMD_CHANNELTITLE("ChannelTitle"),
  /** 设备通过Wifi模块扫描周围无线设备配置({@link NetSDKLib.CFG_WIFI_SEARCH_INFO}) */
  CFG_CMD_WIFI_SEARCH("AroudWifiSearch"),
  /** 定时录像配置(对应 {@link NetSDKLib.CFG_RECORD_INFO}) */
  CFG_CMD_RECORD("Record"),
  /** 检测采集设备配置({@link NetSDKLib.CFG_SCADA_DEV_INFO}) */
  CFG_CMD_SCADA_DEV("SCADADev"),
  /** 告警屏蔽规则( CFG_ALARM_SHIELD_RULE_INFO) */
  CFG_CMD_ALARM_SHIELD_RULE("AlarmShieldRule"),
  /** 司法刻录配置(对应 CFG_JUDICATURE_INFO) */
  CFG_CMD_JUDICATURE("Judicature"),
  /** 云台配置(对应 CFG_PTZ_INFO) */
  CFG_CMD_PTZ("Ptz"),
  /** 多人多开门方式组合配置(CFG_OPEN_DOOR_GROUP_INFO) */
  CFG_CMD_OPEN_DOOR_GROUP("OpenDoorGroup"),
  /** 车位指示灯本机配置(对应 CFG_PARKING_SPACE_LIGHT_GROUP_INFO_ALL) */
  CFG_CMD_PARKING_SPACE_LIGHT_GROUP("ParkingSpaceLightGroup"),
  /** 灯光设备配置 (对应结构体 CFG_LIGHT_INFO) */
  CFG_CMD_LIGHT("Light"),
  /** 灯光设置(CFG_LIGHTING_INFO) */
  CFG_CMD_LIGHTING("Lighting"),
  /** 合成通道配置(对应 {@link NetSDKLib.CFG_COMPOSE_CHANNEL}) */
  CFG_CMD_COMPOSE_CHANNEL("ComposeChannel"),
  /** 司法审讯画中画(对应 CFG_PICINPIC_INFO)改为数组方式，兼容以前单个配置，根据长度区分 */
  CFG_CMD_PICINPIC("PicInPic"),
  /** 空闲动作配置(CFG_IDLE_MOTION_INFO) */
  CFG_CMD_IDLEMOTION_INFO("IdleMotion"),
  /** 语音激励(对应 {@link com.cf.forward.dh.lib.structure.CFG_AUDIO_SPIRIT}) */
  CFG_CMD_AUDIO_SPIRIT("AudioSpirit"),
  /** 设备安装位置的GPS坐标信息(对应 {@link com.cf.forward.dh.lib.structure.CFG_DEVLOCATION_INFO}) */
  CFG_CMD_DEVLOCATION("DevLocation"),
  /** 设备参数标定配置(对应 {@link com.cf.forward.dh.lib.structure.CFG_LOCATION_CALIBRATE_INFO}) */
  CFG_CMD_LOCATION_CALIBRATE("LocationCalibrate"),
  /** // 门禁基本配置(对应 {@link com.cf.forward.dh.lib.structure.CFG_ACCESS_GENERAL_INFO}) */
  CFG_CMD_ACCESS_GENERAL("AccessControlGeneral"),
  /**
   * // 无线网络连接设置(对应 CFG_WIRELESS_INFO)
   */
  CFG_CMD_WIRELESS("Wireless"),
  /**
   * // 报警服务器配置(对应 CFG_ALARMCENTER_INFO)
   */
  CFG_CMD_ALARMSERVER("AlarmServer"),
  /**
   * // 报警全局配置(对应 CFG_COMMGLOBAL_INFO)
   */
  CFG_CMD_COMMGLOBAL("CommGlobal"),
  /**
   * // 模拟量报警通道配置(对应 CFG_ANALOGALARM_INFO)
   */
  CFG_CMD_ANALOGALARM("AnalogAlarm"),
  /**
   * // 警号配置(对应 CFG_ALARMBELL_INFO)
   */
  CFG_CMD_ALARMBELL("AlarmBell"),
  /**
   * // 移动相关业务配置(对应 CFG_MOBILE_INFO)
   */
  CFG_CMD_MOBILE("Mobile"),
  /**
   * // (对应 CFG_PHONEEVENTNOTIFY_INFO)
   */
  CFG_CMD_PHONEEVENTNOTIFY("PhoneEventNotify"),
  /**
   * // 电话报警中心配置(CFG_PSTN_ALARM_CENTER_INFO)
   */
  CFG_CMD_PSTN_ALARM_SERVER("PSTNAlarmServer"),
  /**
   * // 音频输出音量(CFG_AUDIO_OUTPUT_VOLUME)
   */
  CFG_CMD_AUDIO_OUTPUT_VOLUME("AudioOutputVolume"),
  /**
   * // 音频输入音量(CFG_AUDIO_INPUT_VOLUME)
   */
  CFG_CMD_AUDIO_INPUT_VOLUME("AudioInputVolume"),
  /**
   * // 指示灯控制配置 (CFG_LIGHT_GLOBAL)
   */
  CFG_CMD_LIGHT_GLOBAL("LightGlobal"),
  /**
   * // 混合音频音量，用于庭审主机(CFG_AUDIO_MIX_VOLUME)
   */
  CFG_CMD_AUDIO_MIX_VOLUME("AudioMixVolume"),
  /**
   * // 报警键盘配置(CFG_ALARMKEYBOARD_INFO)
   */
  CFG_CMD_ALARMKEYBOARD("AlarmKeyboard"),
  /**
   * // 电源故障配置(CFG_POWERFAULT_INFO)
   */
  CFG_CMD_POWERFAULT("PowerFault"),
  /**
   * // 机箱入侵报警(防拆报警)配置(CFG_CHASSISINTRUSION_INFO)
   */
  CFG_CMD_CHASSISINTRUSION("ChassisIntrusion"),
  /**
   * // 扩展报警盒配置 (CFG_EXALARMBOX_INFO)
   */
  CFG_CMD_EXALARMBOX("ExAlarmBox"),
  /**
   * // 扩展报警输出配置(CFG_EXALARMOUTPUT_INFO)
   */
  CFG_CMD_EXALARMOUTPUT("ExAlarmOut"),
  /**
   * // 扩展报警输入配置(CFG_EXALARMINPUT_INFO)
   */
  CFG_CMD_EXALARMINPUT("ExAlarm"),
  /**
   * // 紧急事件配置(CFG_URGENCY_INFO)
   */
  CFG_CMD_URGENCY("Emergency"),
  /**
   * // 传感器采样(CFG_SENSORSAMPLING_INFO)
   */
  CFG_CMD_SENSORSAMPLING("SensorSampling"),
  CFG_CMD_STP("STP"), // 环网配置(CFG_STP_INFO)
  /**
   * // 报警子系统配置(CFG_ALARM_SUBSYSTEM_INFO)
   */
  CFG_CMD_ALARM_SUBSYSTEM("AlarmSubSystem"),
  /**
   * // 电池电量低配置(CFG_BATTERY_LOW_POWER_INFO)
   */
  CFG_CMD_BATTERY_LOW_POWER("BatteryLowPowerAlarm"),
  /**
   * // 抓图通道联动外设配置(CFG_SNAPLINKAGE_INFO)
   */
  CFG_CMD_SNAPLIKAGE("SnapLinkage"),
  /**
   * // 音频输入配置(CFG_AUDIO_INPUT)
   */
  CFG_CMD_AUDIOINPUT("AudioInput"),
  CFG_CMD_EMAIL("Email"), // 邮件发送配置(CFG_EMAIL_INFO)
  CFG_CMD_TRAFFIC_TRANSFER_OFFLINE(
      "TrafficTransferOffline"), // 传输离线文件配置(TRAFFIC_TRANSFER_OFFLINE_INFO)
  CFG_CMD_COMMSUBSCRIBE("CommSubscribe"), // 订阅串口数据配置(CFG_DEVCOMM_SUBSCRIBE)
  CFG_CMD_PARKINGSPACE_LIGHT_STATE(
      "ParkingSpaceLightState"), // 车位状态对应的车位指示灯(CFG_PARKINGSPACE_LIGHT_STATE)
  CFG_CMD_AIRCONDITION("AirCondition"), // 空调设备配置(CFG_AIRCONDITION_INFO)
  CFG_CMD_COMPRESS_PLAY("CompressPlay"), // 压缩回放配置(CFG_COMPRESS_PLAY_INFO)
  CFG_CMD_BUILDING("Building"), // VTO楼层配置(CFG_BUILDING_INFO)
  CFG_CMD_BUILDING_EXTERNAL("BuildingExternal"), // VTO楼层扩展配置(CFG_BUILDING_EXTERNAL_INFO)
  CFG_CMD_DIALRULE("DialRule"), // 拨号规则(CFG_DIALRULE_INFO)
  CFG_CMD_OIL_MASS_INFO("OilMassInfo"), // 车辆油箱配置(CFG_OIL_MASS_INFO)
  CFG_CMD_FISHEYE_INFO("FishEye"), // 鱼眼详细信息配置(CFG_FISHEYE_DETAIL_INFO)
  CFG_CMD_VTNOANSWER_FORWARD("VTNoAnswerForward"), // 平台下发呼叫无应答转移配置列表
  // (CFG_VT_NOANSWER_FORWARD_INFO)
  CFG_CMD_VTO_CALL("VTOCall"), // VTO呼叫配置(CFG_VTO_CALL_INFO)
  CFG_CMD_MACCONFLICT("MacConflict"), // MAC冲突报警配置(CFG_MACCONFLICT_INFO)
  CFG_CMD_MONITORWALL_COLL_TOUR("MonitorWallCollectionTour"), // 电视墙预案轮巡配置
  // (CFG_MONITORWALL_COLLECTION_TOUR_INFO)
  CFG_CMD_PSTN_BREAK_LINE("PSTNBreakLine"), // PSTN断线事件配置(CFG_PSTN_BREAK_LINE_INFO)
  CFG_CMD_NET_COLLECTION("NetCollection"), // 网络采集设备配置(CFG_NET_COLLECTION_INFO)
  CFG_CMD_ALARM_SLOT_BOND("AlarmSlotBond"), // 虚拟Slot节点与具体物理设备的对应关系
  // (CFG_ALARM_SLOT_BOND_INFO)
  CFG_CMD_TRAFFICSTROBE("TrafficStrobe"), // 道闸配置(CFG_TRAFFICSTROBE_INFO)
  CFG_CMD_TRAFFICVOICE("TrafficVoiceBroadcast"), // 智能交通语音播报配置( CFG_TRAFFICVOICE_BROADCAST)
  CFG_CMD_STANDING_TIME("StandingTime"), // 停车时间配置(CFG_STANDING_TIME_INFO)
  CFG_CMD_ENCLOSURE_TIME_SCHEDULE("EnclosureTimeSchedule"), // 电子围栏报警时间段配置
  // (CFG_ENCLOSURE_TIME_SCHEDULE_INFO)
  CFG_CMD_ECKCONFIG("ECKConfig"), // 停车场出入口控制器配置(CFG_ECKCONFIG_INFO)
  CFG_CMD_PARKING_CARD("ParkingCard"), // 停车场出入口刷卡报警事件配置(CFG_PARKING_CARD_INFO)
  CFG_CMD_RCEMERGENCY_CALL("RCEmergencyCall"), // 紧急呼叫报警事件配置(CFG_RCEMERGENCY_CALL_INFO)
  CFG_CMD_LANES_STATE_REPORT("LanesStateReport"), // 车道信息上报配置(CFG_LANES_STATE_REPORT)
  CFG_CMD_OPEN_DOOR_ROUTE("OpenDoorRoute"), // 开门路线集合，或称防反潜路线配置(CFG_OPEN_DOOR_ROUTE_INFO)
  CFG_CMD_BURNPLAN("BurnPlan"), // 刻录计划配置(对应 CFG_BURNPLAN_INFO)
  CFG_CMD_VSP_GAYS("VSP_GAYS"), // 公安一所平台接入配置(CFG_VSP_GAYS_INFO)
  CFG_CMD_AUDIODETECT("AudioDetect"), // 音频检测报警配置(CFG_AUDIO_DETECT_INFO数组)
  CFG_CMD_GUIDESCREEN("GuideScreen"), // 诱导屏系统配置(CFG_GUIDESCREEN_INFO)
  CFG_CMD_VTS_CALL_INFO("VTSCallInfo"), // VTS呼叫配置(CFG_VTS_CALL_INFO)
  CFG_CMD_DEV_LIST("DevList"), // 设备列表配置(CFG_DEV_LIST_INFO)
  CFG_CMD_CALIBRATE_MATRIX("CalibrateMatrix"), // 主从式跟踪器标定矩阵配置(CFG_CALIBRATE_MATRIX_INFO,
  // 新配置对应CFG_CALIBRATE_MATRIX_EX_INFO)
  CFG_CMD_DEFENCE_AREA_DELAY("DefenceAreaDelay"), // 防区延时配置(CFG_DEFENCE_AREA_DELAY_INFO)
  CFG_CMD_FLAT_FIELD_CORRECTION(
      "FlatFieldCorrection"), // 热成像平场聚焦校准配置(CFG_FLAT_FIELD_CORRECTION_INFO)
  CFG_CMD_THERMO_FUSION("ThermographyFusion"), // 热成像视频融合配置(CFG_THERMO_FUSION_INFO)
  CFG_CMD_LCE_STATE("LCEState"), // 热成像自研机芯中摄像头属性的局部对比度增强配置(CFG_LCE_STATE_INFO)
  CFG_CMD_LIGHTINGSCHEDULE("LightingSchedule"), // 灯光计划配置(对应 CFG_LIGHTINGSCHEDULE_INFO)
  CFG_CMD_EMERGENCY_RECORD_FOR_PULL("EmergencyRecordForPull"), //
  // 紧急录像存储配置，用于客户端主动拉的方式。在客户端拉流存储异常之后，进行紧急录像存储(CFG_EMERGENCY_RECORD_FOR_PULL_INFO)
  CFG_CMD_VIDEOIN_ANALYSERULE("VideoInAnalyseRule"), // 视频通道智能规则配置(CFG_VIDEOIN_ANALYSE_RULE_INFO)
  CFG_CMD_ACCESS_WORK_MODE("AccessWorkMode"), // 门锁工作模式(对应 CFG_ACCESS_WORK_MODE_INFO 数组)
  CFG_CMD_VIDEO_TALK_PHONE_GENERAL(
      "VideoTalkPhoneGeneral"), // 视频对讲电话通用配置(CFG_VIDEO_TALK_PHONE_GENERAL)
  CFG_CMD_TRAFFIC_SNAP_MOSAIC("TrafficSnapMosaic"), // 抓图合成配置(对应 CFG_TRAFFIC_SNAP_MOSAIC_INFO)
  CFG_CMD_SCENE_SNAP_RULE("SceneSnapShotWithRule"), // 场景抓拍设置(对应 CFG_SCENE_SNAPSHOT_RULE_INFO)
  CFG_CMD_VTO_INFO("VTOInfo"), // 门口机配置(对应 CFG_VTO_LIST)
  CFG_CMD_TS_POINT("TSPoint"), // 触摸屏校准配置(对应 CFG_TSPOINT_INFO)
  CFG_CMD_VTH_NUMBER_INFO("VTHNumberInfo"), // 室内机号码信息(对应 CFG_VTH_NUMBER_INFO)
  CFG_CMD_GPS("GPS"), // GPS配置(对应 CFG_GPS_INFO_ALL)
  CFG_CMD_VTO_BASIC_INFO("VTOBasicInfo"), // VTO基本信息 (对应 CFG_VTO_BASIC_INFO)
  CFG_CMD_SHORTCUT_CALL("ShortcutCall"), // 快捷号配置 (对应 CFG_SHORTCUT_CALL_INFO)
  CFG_CMD_GPS_LOCATION_VER("GPSLocationVersion"), // 记录集GPSLocation的版本号(对应 CFG_LOCATION_VER_INFO)
  CFG_CMD_PARKING_SPACE_ACCESS_FILTER("ParkingSpaceAccessFilter"), // 设备可访问地址过滤配置(对应
  // CFG_PARKING_SPACE_ACCESS_FILTER_INFO)
  CFG_CMD_WORK_TIME("WorkTime"), // 工作时间配置(对应 CFG_WORK_TIME_INFO)
  // CFG_PARKING_SPACE_LIGHT_GROUP_INFO_ALL)
  CFG_CMD_CUSTOM_AUDIO("CustomAudio"), // 自定义音频配置(CFG_CUSTOM_AUDIO)
  // CFG_WIFI_SEARCH_INFO)
  CFG_CMD_G3G4AUTOCHANGE("G3G4AutoChange"), // 车载设备通信模块3G 4G自动切换(CFG_G3G4AUTOCHANGE)
  CFG_CMD_CHECKCODE("CheckCode"), // 刷卡机校验码校验配置(对应 CFG_CHECKCODE_INFO)
  CFG_CMD_VSP_SCYDKD("VSP_SCYDKD"), // 四川移动看店启迪平台接入配置(对应 CFG_VSP_SCYDKD_INFO)
  CFG_CMD_VIDEOIN_DAYNIGHT("VideoInDayNight"), // 球机机芯日夜配置(对应 CFG_VIDEOIN_DAYNIGHT_INFO)
  CFG_CMD_PTZ_POWERUP("PowerUp"), // 云台开机动作设置(对应 CFG_PTZ_POWERUP_INFO)
  CFG_CMD_AUDIO_MIX_CHANNEL("AudioMixChannel"), // 配置定义每个纯音频通道的组成(对应
  // CFG_AUDIO_MIX_CHANNEL_INFO_ALL)
  CFG_CMD_AUDIO_TOUCH("AudioTouch"), // 变音，对音调进行变化(对应 CFG_AUDIO_TOUCH_INFO_ALL)
  CFG_CMD_VIDEO_MOSAIC("VideoMosaic"), // 马赛克叠加配置(对应CFG_VIDEO_MOSAIC_INFO)
  CFG_CMD_VTH_REMOTE_IPC_INFO("VTHRemoteIPCInfo"), // VTH中远程IPC配置(对应 CFG_VTH_REMOTE_IPC_INFO)
  // ，该配置是全局的，不区分通道
  CFG_CMD_UNFOCUSDETECT("UnFocusDetect"), // 虚焦检测配置(对应CFG_UNFOCUSDETECT_INFO)
  CFG_CMD_MOVE_DETECT("MovedDetect"), // 场景变更检测配置(对应CFG_MOVE_DETECT_INFO)
  CFG_CMD_FLOODLIGHT("Floodlight"), // 防护舱照明灯控制配置(对应
  // CFG_FLOODLIGHT_CONTROLMODE_INFO)
  CFG_CMD_AIRFAN("AirFan"), // 防护舱风扇控制配置(对应 CFG_AIRFAN_CONTROLMODE_INFO)
  CFG_CMD_WLAN("WLan"), // WLAN配置(对应 CFG_NETAPP_WLAN)
  CFG_CMD_SMART_ENCODE("SmartEncode"), // Smart H264编码方式(对应 CFG_SMART_ENCODE_INFO)
  CFG_CMD_VEHICLE_HIGH_SPEED("HighSpeed"), // 车载高速报警配置(对应 CFG_VEHICLE_HIGHSPEED_INFO )
  CFG_CMD_VEHICLE_LOW_SPEED("LowSpeed"), // 车载低速报警配置(对应 CFG_VEHICLE_LOWSPEED_INFO )
  CFG_CMD_PSTN_PERSON_SERVER("PSTNPersonServer"), // 个人电话接机配置(对应
  // CFG_PSTN_PERSON_SERVER_INFO_ALL )
  CFG_CMD_ARM_LINK("ArmLink"), // 布撤防联动配置(对应 CFG_ARMLINK_INFO )
  CFG_CMD_CABINLED_TIME_SCHEDULE(
      "CabinLedTimeSchedule"), // 防护舱Led显示计划配置(对应 CFG_CABINLED_TIME_SCHEDULE)
  CFG_CMD_PSTN_TESTPLAN("PSTNTestPlan"), // PSTN 测试计划配置(对应 CFG_PSTN_TESTPLAN_INFO)
  CFG_CMD_DEFENCE_ARMMODE("DefenceArmMode"), // 单防区布撤防使能配置(对应 CFG_DEFENCE_ARMMODE_INFO)
  CFG_CMD_SENSORMODE("SensorMode"), // 探测器安装工作模式配置(对应 CFG_SENSORMODE_INFO)
  CFG_CMD_RADAR_SPEED_MEASURE("RadarSpeedMeasure"), // 雷达测速配置 智能楼宇专用(对应
  // CFG_RADAR_SPEED_MEASURE_INFO)
  CFG_CMD_VIDEOINDEFOG("VideoInDefog"), // 透雾设置配置(对应结构体 CFG_VIDEOINDEFOG_LIST)
  CFG_CMD_AUDIO_OUT_EQUALIZER("AudioOutEqualizer"), // 音频输出均衡器配置(对应结构体CFG_AUDIO_OUTEQUALIZER_INFO)
  CFG_CMD_AUDIO_OUT_SUPPRESSION("AudioOutSuppression"), // 音频抑制设置(对应结构体CFG_AUDIO_SUPPRESSION_INFO)
  CFG_CMD_AUDIO_IN_CONTROL("AudioInControl"), // 音频输入控制(对应结构体CFG_AUDIO_INCONTROL_INFO)
  CFG_CMD_LASER_DIST_MEASURE("LaserDistMeasure"), // 激光测距器配置(对应结构体 CFG_LASER_DIST_MEASURE_INFO)
  CFG_CMD_OIL_4G_OVERFLOW("Oil4GFlow"), // 福山油田4G流量阈值及模式配置(对应结构体
  // CFG_OIL_4G_OVERFLOW_INFO)
  CFG_CMD_OIL_VIDEOWIDGET_4G_FLOW("VideoWidget4GFlow"), // 福山油田4G流量OSD叠加配置(对应结构体
  // CFG_OIL_VIDEOWIDGET_4G_FLOW_INFO)
  CFG_CMD_ATMOSPHERE_OSD("AtmosphereOSD"), // 气象信息叠加配置(对应结构体 CFG_CMD_ATMOSPHERE_OSD_INFO)
  CFG_CMD_PARK_SPACE_OUT_LIGHT("ParkSpaceOutLight"), // 外接指示灯配置(对应结构体 CFG_PARK_SPACE_OUT_LIGHT_INFO)
  CFD_CMD_VTO_CALL_INFO_EXTEND("VTOCallInfo"), // VTO呼叫配置扩展(对应结构体CFG_VTO_CALL_INFO_EXTEND)
  CFG_CMD_ACCESS_TEXTDISPLAY("AccessControlTextDisplay"), // 门禁文字提示显示配置(对应结构体
  // CFG_ACCESS_TEXTDISPLAY_INFO)
  CFG_CMD_NETNVR_ENCRYPT("NvrEncrypt"), // 杭师大视频加密项目配置信息，涉及IPC和NVR(
  // CFG_NETNVR_ENCRYPT_INFO )
  CFG_CMD_CURTAIN("Curtain"), // 窗帘配置(对应结构体 CFG_CURTAIN_INFO)
  CFG_CMD_FRESH_AIR("FreshAir"), // 新风配置(对应结构体 CFG_FRESH_AIR_INFO)
  CFG_CMD_GROUND_HEAT("GroundHeat"), // 地暖配置(对应结构体 CFG_GROUND_HEAT_INFO)
  CFG_CMD_SCENE_MODE("SceneMode"), // 情景模式(对应结构体 CFG_SCENE_MODE_INFO)
  CFG_CMD_AIO_APP_CONFIG("AIOAppConfig"), // AIOAppConfig参数设置(对应结构体
  // CFG_AIO_APP_CONFIG_INFO)
  CFG_CMD_HTTPS("Https"), // Https服务配置(对应结构体 CFG_HTTPS_INFO)
  CFG_CMD_NETAUTOADAPTORENCODE("NetAutoAdaptEncode"), // 网络自适应编码配置(对应结构体 CFG_NET_AUTO_ADAPT_ENCODE)
  CFG_CMD_USERLOCKALARM("UserLockAlarm"), // 登陆锁定配置(对应结构体 CFG_USERLOCKALARM_INFO)
  CFG_CMD_STROBOSCOPIC_LAMP("StroboscopicLamp"), // 频闪灯配置(对应结构体 CFG_STROBOSCOPIC_LAMP_INFO)
  CFG_CMD_FREECOMBINATION("FreeCombination"), // 自由分割模式的窗口配置 CFG_FREECOMBINATION_INFO )
  CFG_CMD_IOT_INFRARED_DETECT("IOT_InfraredDetect"), // 物联网红外检测配置(对应结构体CFG_IOT_INFRARED_DETECT_INFO)
  CFG_CMD_IOT_RECORD_HANDLE("IOT_RecordHandle"), // 物联网录像联动配置(对应结构体CFG_IOT_RECORD_HANDLE_INFO)
  CFG_CMD_IOT_SNAP_HANDLE("IOT_SnapHandle"), // 物联网抓图联动配置(对应结构体CFG_IOT_SNAP_HANDLE_INFO)
  CFG_CMD_PLATFORM_MONITOR_IPC("PlatformMonitorIPC"), // 平台侧监视IPC配置 CFG_PLATFORMMONITORIPC_INFO )
  CFG_CMD_CALLFORWARD("CallForward"), // 呼叫转移配置(对应结构体 CFG_CALLFORWARD_INFO)
  CFD_CMD_DOORBELLSOUND("DoorBellSound"), // 门铃配置(对应结构体CFG_DOOR_BELLSOUND_INFO)
  CFG_CMD_TELNET("Telnet"), // telnet配置(对应结构体CFG_TELNET_INFO)
  CFG_CMD_OSDSYSABNORMAL("OSDSysAbnormal"), // 显示异常信息的叠加配置(对应结构体 CFG_OSD_SYSABNORMAL_INFO)
  CFG_CMD_VIDEO_WIDGET2("VideoWidget2"), // 视频编码物件配置(对应结构体 CFG_VIDEO_WIDGET2_INFO)
  CFG_CMD_VIDEOWIDGET_NUMBERSTAT("VideoWidgetNumberStat"), // 人数统计叠加OSD配置(对应结构体
  // CFG_VIDEOWIDGET_NUMBERSTAT_INFO)
  CFG_CMD_PRIVACY_MASKING("PrivacyMasking"), // 隐私遮挡设置(对应结构体 CFG_PRIVACY_MASKING_INFO)
  CFG_CMD_DEVICE_INFO("DeviceInfo"), // 设备信息(对应结构体 CFG_DEVICE_INFO)
  CFG_CMD_POLICEID_MAP_INFO("PoliceMap"), // 警员ID和设备通道映射关系信息(对应结构体 CFG_POLICEID_MAP_INFO)
  CFG_CMD_GPS_NOT_ALIGNED("GpsNotAligned"), // GPS未定位配置(对应结构体 CFG_GPS_NOT_ALIGNED_INFO)
  CFG_CMD_WIRELESS_NOT_CONNECTED("WireLessNotConnected"), // 网络未连接（包括wifi，3G/4G）配置(对应结构体
  // CFG_WIRELESS_NOT_CONNECTED_INFO)
  CFG_CMD_MCS_GENERAL_CAPACITY_LOW("MCSGeneralCapacityLow"), // 微云常规容量告警配置
  // (对应结构体CFG_MCS_GENERAL_CAPACITY_LOW)
  CFG_CMD_MCS_DATA_NODE_OFFLINE("MCSDataNodeOffline"), // 微云存储节点下线(对应结构体CFG_MCS_DATA_NODE_OFFLINE)
  CFG_CMD_MCS_DISK_OFFLINE("MCSDiskOffline"), // 微云磁盘下线告警配置(对应结构体CFG_MCS_DISK_OFFLINE)
  CFG_CMD_MCS_DISK_SLOW("MCSDiskSlow"), // 微云磁盘变慢告警配置(对应结构体CFG_MCS_DISK_SLOW)
  CFG_CMD_MCS_DISK_BROKEN("MCSDiskBroken"), // 微云磁盘损坏告警配置(对应结构体CFG_MCS_DISK_BROKEN)
  CFG_CMD_MCS_DISK_UNKNOW_ERROR(
      "MCSDiskUnknowError"), // 微云磁盘未知错误告警配置(对应结构体CFG_MCS_DISK_UNKNOW_ERROR)
  CFG_CMD_MCS_METADATA_SERVER_ABNORMAL("MCSMetadataServerAbnormal"), // 微云元数据服务器异常告警配置
  // (对应结构体CFG_MCS_METADATA_SERVER_ABNORMAL)
  CFG_CMD_MCS_CATALOG_SERVER_ABNORMAL("MCSCatalogServerAbnormal"), // 微云目录服务器异常告警配置
  // (对应结构体CFG_MCS_CATALOG_SERVER_ABNORMAL)
  CFG_CMD_MCS_GENERAL_CAPACITY_RESUME("MCSGeneralCapacityResume"), // 微云常规容量告警恢复告警配置
  // (对应结构体CFG_MCS_GENERAL_CAPACITY_RESUME)
  CFG_CMD_MCS_DATA_NODE_ONLINE("MCSDataNodeOnline"), // 微云存储节点上线告警配置
  // (对应结构体CFG_MCS_DATA_NODE_ONLINE)
  CFG_CMD_MCS_DISK_ONLINE("MCSDiskOnline"), // 微云磁盘上线告警配置(对应结构体CFG_MCS_DISK_ONLINE)
  CFG_CMD_MCS_METADATA_SLAVE_ONLINE("MCSMetadataSlaveOnline"), // 微云元数据备机上线告警配置
  // (对应结构体CFG_MCS_METADATA_SLAVE_ONLINE)
  CFG_CMD_MCS_CATALOG_SERVER_ONLINE("MCSCatalogServerOnline"), // 微云目录服务器上线告警配置
  // (对应结构体CFG_MCS_CATALOG_SERVER_ONLINE)
  CFG_CMD_SECURITY_ALARMS_PRIVACY("SecurityAlarmsPrivacy"), // SecurityAlarms客户定制功能，隐私保护
  // (对应结构体CFG_SECURITY_ALARMS_PRIVACY)
  CFG_CMD_NO_FLY_TIME("NoFlyTime"), // 无人机禁飞时段配置 ( 对应结构体 CFG_NO_FLY_TIME_INFO )
  CFG_CMD_PWD_RESET("PwdReset"), // 密码重置功能使能配置 ( 对应结构体 CFG_PWD_RESET_INFO )
  CFG_CMD_NET_MONITOR_ABORT("NetMonitorAbort"), // 网络监视中断事件配置( 对应结构体
  // CFG_NET_MONITOR_ABORT_INFO )
  CFG_CMD_LOCAL_EXT_ALARM("LocalExtAlarm"), // 本地扩展报警配置 ( 对应结构体 CFG_LOCAL_EXT_ALARME_INFO )
  CFG_CMD_ACCESSCONTROL_DELAYSTRATEGY("DelayStrategy"), // 门禁卡欠费与预欠费状态配置(对应结构体
  // CFG_ACCESSCONTROL_DELAYSTRATEGY)
  CFG_CMD_VIDEO_TALK_PHONE_BASIC("VideoTalkPhoneBasic"), // 视频对讲电话基础配置( 对应结构体
  // CFG_VIDEO_TALK_PHONE_BASIC_INFO )
  CFG_CMD_APP_EVENT_LANGUAGE("AppEventLanguage"), // 手机推送消息的翻译目标语言配置(对应结构体
  // CFG_APP_EVENT_LANGUAGE_INFO )
  CFG_CMD_LOGIN_FAILURE_ALARM("LoginFailureAlarm"), // 登陆失败报警配置(对应结构体 CFG_LOGIN_FAILURE_ALARM)
  CFG_CMD_DROPBOXTOKEN("DropBoxToken"), // Dropbox Token 配置( 对应结构体
  // CFG_DROPBOXTOKEN_INFO)
  CFG_CMD_IDLINGTIME("IdlingTime"), // 怠速配置(对应结构体 CFG_IDLINGTIME_INFO)
  CFG_CMD_CARDIVERSTATE("CarDiverState"), // 汽车行驶状态配置(对应结构体 CFG_CARDIVERSTATE_INFO)
  CFG_CMD_VEHICLE("Vehicle"), // 车载配置(对应结构体 CFG_VEHICLE_INFO)
  CFG_CMD_PTZDEVICE("PtzDevice"), // 模拟云台配置( 对应结构体 CFG_PTZDEVICE_INFO)
  CFG_CMD_SMARTHOME_SCENELIST("SmartHomeSceneList"), // 美的地产智能家居场景列表
  // (对应结构体CFG_SMARTHOME_SCENELIST_INFO)
  CFG_CMD_LIGHTING_V2("Lighting_V2"), // 全彩相机补光灯灵敏度配置(对应结构体 CFG_LIGHTING_V2_INFO)
  CFG_CMD_KBUSER_PASSWORD("KbuserPassword"), // 键盘操作员用户配置(对应结构体CFG_KBUSER_USERS_INFO)
  CFG_CMD_ACCESS_OEM("AccessOEMSettings"), // 工行金库门禁信息配置，对应结构体CFG_ACCESS_OEM_INFO
  CFG_CMD_FIRE_WARNING_EXT("FireWarningExt"), // 火警配置扩展（对应结构体CFG_FIREWARNING_EXT_INFO）
  CFG_CMD_THERM_DENOISE("ThermDenoise"), // 热成像特有的机芯降噪，对应结构体CFG_THERM_DENOISE
  CFG_CMD_CONSTANT_LAMP("ConstantLamp"), // 智能交通灯光配置，对应结构体CFG_CONSTANT_LAMP_INFO
  CFG_CMD_TRAFFIC_IO("TrafficIO"), // 线圈IO配置，对应结构体CFG_TRAFFIC_IO
  CFG_CMD_MONITOR_WALL_COLLECTION_MAP("MonitorWallCollectionMap"), // 电视墙预关联配置,
  // 对应结构体CFG_MONITOR_WALL_COLLECTION_MAP_INFO,通道只支持传-1
  CFG_CMD_VIDEO_INPUT_GROUP("VideoInputGroup"), // 视频输入组配置,对应结构体CFG_VIDEO_INPUT_GROUP_INFO
  CFG_CMD_DOOR_NOT_CLOSE("DoorNotClosed"), // 门未关报警，对应结构体 CFG_DOOR_NOT_CLOSE_INFO
  CFG_CMD_BREAK_IN("BreakIn"), // 闯入报警，对应结构体 CFG_BREAK_IN_INFO
  CFG_CMD_ANTI_PASSBACK("AntiPassback"), // 反潜回报警，对应结构体 CFG_ANTI_PASSBACK_INFO
  CFG_CMD_DURESS("Duress"), // 胁迫报警，对应结构体 CFG_DURESS_INFO
  CFG_CMD_MALICIOUS_ACCESSCONTROL("MaliciousAccessControl"), // 非法超次报警报警，对应结构体
  // CFG_DOOR_MALICIOUS_ACCESSCONTROL_INFO
  CFG_CMD_REGULATOR_DETECT("RegulatorDetect"), // 标准黑体源异常报警，对应结构体
  // CFG_REGULATOR_DETECT_INFO.
  // 热成像通道有效

  CFG_CMD_REMOTE_ANALYSEGLOBAL("RemoteVideoAnalyseGlobal"), // 远程视频分析全局配置(对应
  // CFG_ANALYSEGLOBAL_INFO)
  CFG_CMD_REMOTE_ANALYSEMODULE("RemoteVideoAnalyseModule"); // 远程物体的检测模块配置(对应
  // CFG_ANALYSEMODULES_INFO)

  private String value;

  private EM_NEW_CONFIG(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
