package com.cf.forward.dh.lib.enumeration;

/**
 * className：EM_EVENT_TYPE
 * description：
 * author：251589
 * createTime：2021/1/25 17:24
 *
 * @version v1.0
 */
public enum EM_EVENT_TYPE {
    /**
     * 订阅所有事件
     */
    EVENT_IVS_ALL(0x00000001, "订阅所有事件"),
    /**
     * 警戒线事件
     */
    EVENT_IVS_CROSSLINEDETECTION(0x00000002, "警戒线事件"),
    /**
     * 警戒区事件
     */
    EVENT_IVS_CROSSREGIONDETECTION(0x00000003, "警戒区事件"),
    /**
     * 贴条事件
     */
    EVENT_IVS_PASTEDETECTION(0x00000004, "贴条事件"),
    /**
     * 物品遗留事件
     */
    EVENT_IVS_LEFTDETECTION(0x00000005, "物品遗留事件"),
    /**
     * 停留事件
     */
    EVENT_IVS_STAYDETECTION(0x00000006, "停留事件"),
    /**
     * 徘徊事件
     */
    EVENT_IVS_WANDERDETECTION(0x00000007, "徘徊事件"),
    /**
     * 物品保全事件
     */
    EVENT_IVS_PRESERVATION(0x00000008, "物品保全事件"),
    /**
     * 移动事件
     */
    EVENT_IVS_MOVEDETECTION(0x00000009, "移动事件"),
    /**
     * 尾随事件
     */
    EVENT_IVS_TAILDETECTION(0x0000000A, "尾随事件"),
    /**
     * 聚众事件
     */
    EVENT_IVS_RIOTERDETECTION(0x0000000B, "聚众事件"),
    /**
     * 火警事件
     */
    EVENT_IVS_FIREDETECTION(0x0000000C, "火警事件"),
    /**
     * 烟雾报警事件
     */
    EVENT_IVS_SMOKEDETECTION(0x0000000D, "烟雾报警事件"),
    /**
     * 斗殴事件
     */
    EVENT_IVS_FIGHTDETECTION(0x0000000E, "斗殴事件"),
    /**
     * 流量统计事件
     */
    EVENT_IVS_FLOWSTAT(0x0000000F, "流量统计事件"),
    /**
     * 数量统计事件
     */
    EVENT_IVS_NUMBERSTAT(0x00000010, "数量统计事件"),
    /**
     * 摄像头覆盖事件
     */
    EVENT_IVS_CAMERACOVERDDETECTION(0x00000011, "摄像头覆盖事件"),
    /**
     * 摄像头移动事件
     */
    EVENT_IVS_CAMERAMOVEDDETECTION(0x00000012, "摄像头移动事件"),
    /**
     * 视频异常事件
     */
    EVENT_IVS_VIDEOABNORMALDETECTION(0x00000013, "视频异常事件"),
    /**
     * 视频损坏事件
     */
    EVENT_IVS_VIDEOBADDETECTION(0x00000014, "视频损坏事件"),
    /**
     * 交通管制事件
     */
    EVENT_IVS_TRAFFICCONTROL(0x00000015, "交通管制事件"),
    /**
     * 交通事故事件
     */
    EVENT_IVS_TRAFFICACCIDENT(0x00000016, "交通事故事件"),
    /**
     * 交通路口事件----老规则
     */
    EVENT_IVS_TRAFFICJUNCTION(0x00000017, "交通路口事件----老规则"),
    /**
     * 交通卡口事件----老规则
     */
    EVENT_IVS_TRAFFICGATE(0x00000018, "交通卡口事件----老规则"),
    /**
     * 交通抓拍事件
     */
    EVENT_TRAFFICSNAPSHOT(0x00000019, "交通抓拍事件"),
    /**
     * 人脸检测事件
     */
    EVENT_IVS_FACEDETECT(0x0000001A, "人脸检测事件"),
    /**
     * 交通拥堵事件
     */
    EVENT_IVS_TRAFFICJAM(0x0000001B, "交通拥堵事件"),
    /**
     * 非机动车占机动车车道事件
     */
    EVENT_IVS_TRAFFIC_NONMOTORINMOTORROUTE(0x0000001C, "非机动车占机动车车道事件"),
    /**
     * 交通违章-闯红灯事件
     */
    EVENT_IVS_TRAFFIC_RUNREDLIGHT(0x00000100, "交通违章-闯红灯事件"),
    /**
     * 交通违章-压车道线事件
     */
    EVENT_IVS_TRAFFIC_OVERLINE(0x00000101, "交通违章-压车道线事件"),
    /**
     * 交通违章-逆行事件
     */
    EVENT_IVS_TRAFFIC_RETROGRADE(0x00000102, "交通违章-逆行事件"),
    /**
     * 交通违章-违章左转
     */
    EVENT_IVS_TRAFFIC_TURNLEFT(0x00000103, "交通违章-违章左转"),
    /**
     * 交通违章-违章右转
     */
    EVENT_IVS_TRAFFIC_TURNRIGHT(0x00000104, "交通违章-违章右转"),
    /**
     * 交通违章-违章掉头
     */
    EVENT_IVS_TRAFFIC_UTURN(0x00000105, "交通违章-违章掉头"),
    /**
     * 交通违章-超速
     */
    EVENT_IVS_TRAFFIC_OVERSPEED(0x00000106, "交通违章-超速"),
    /**
     * 交通违章-低速
     */
    EVENT_IVS_TRAFFIC_UNDERSPEED(0x00000107, "交通违章-低速"),
    /**
     * 交通违章-违章停车
     */
    EVENT_IVS_TRAFFIC_PARKING(0x00000108, "交通违章-违章停车"),
    /**
     * 交通违章-不按车道行驶
     */
    EVENT_IVS_TRAFFIC_WRONGROUTE(0x00000109, "交通违章-不按车道行驶"),
    /**
     * 交通违章-违章变道
     */
    EVENT_IVS_TRAFFIC_CROSSLANE(0x0000010A, "交通违章-违章变道"),
    /**
     * 交通违章-压黄线
     */
    EVENT_IVS_TRAFFIC_OVERYELLOWLINE(0x0000010B, "交通违章-压黄线"),
    /**
     * 交通违章-路肩行驶事件
     */
    EVENT_IVS_TRAFFIC_DRIVINGONSHOULDER(0x0000010C, "交通违章-路肩行驶事件"),
    /**
     * 交通违章-黄牌车占道事件
     */
    EVENT_IVS_TRAFFIC_YELLOWPLATEINLANE(0x0000010E, "交通违章-黄牌车占道事件"),
    /**
     * 交通违章-礼让行人/斑马线行人优先事件
     */
    EVENT_IVS_TRAFFIC_PEDESTRAINPRIORITY(0x0000010F, "交通违章-礼让行人/斑马线行人优先事件"),
    /**
     * 电火花事件
     */
    EVENT_IVS_ELECTROSPARKDETECTION(0x00000110, "电火花事件"),
    /**
     * 交通违章-禁止通行事件
     */
    EVENT_IVS_TRAFFIC_NOPASSING(0x00000111, "交通违章-禁止通行事件"),
    /**
     * 异常奔跑事件
     */
    EVENT_IVS_ABNORMALRUNDETECTION(0x00000112, "异常奔跑事件"),
    /**
     * 人员逆行事件
     */
    EVENT_IVS_RETROGRADEDETECTION(0x00000113, "人员逆行事件"),
    /**
     * 区域内检测事件
     */
    EVENT_IVS_INREGIONDETECTION(0x00000114, "区域内检测事件"),
    /**
     * 物品搬移事件
     */
    EVENT_IVS_TAKENAWAYDETECTION(0x00000115, "物品搬移事件"),
    /**
     * 非法停车事件
     */
    EVENT_IVS_PARKINGDETECTION(0x00000116, "非法停车事件"),
    /**
     * 人脸识别事件
     */
    EVENT_IVS_FACERECOGNITION(0x00000117, "人脸识别事件"),
    /**
     * 交通手动抓拍事件
     */
    EVENT_IVS_TRAFFIC_MANUALSNAP(0x00000118, "交通手动抓拍事件"),
    /**
     * 交通流量统计事件
     */
    EVENT_IVS_TRAFFIC_FLOWSTATE(0x00000119, "交通流量统计事件"),
    /**
     * 交通滞留事件
     */
    EVENT_IVS_TRAFFIC_STAY(0x0000011A, "交通滞留事件"),
    /**
     * 有车占道事件
     */
    EVENT_IVS_TRAFFIC_VEHICLEINROUTE(0x0000011B, "有车占道事件"),
    /**
     * 视频移动侦测事件
     */
    EVENT_ALARM_MOTIONDETECT(0x0000011C, "视频移动侦测事件"),
    /**
     * 外部报警事件
     */
    EVENT_ALARM_LOCALALARM(0x0000011D, "外部报警事件"),
    /**
     * 看守所囚犯起身事件
     */
    EVENT_IVS_PRISONERRISEDETECTION(0x0000011E, "看守所囚犯起身事件"),
    /**
     * 翻越围栏事件
     */
    EVENT_IVS_CROSSFENCEDETECTION(0x0000011F, "翻越围栏事件"),
    /**
     * 交通违章-卡口事件----新规则
     */
    EVENT_IVS_TRAFFIC_TOLLGATE(0x00000120, "交通违章-卡口事件----新规则"),
    /**
     * 人员密集度检测
     */
    EVENT_IVS_DENSITYDETECTION(0x00000121, "人员密集度检测"),
    /**
     * 视频诊断结果事件
     */
    EVENT_IVS_VIDEODIAGNOSIS(0x00000122, "视频诊断结果事件"),
    /**
     * 排队检测报警事件
     */
    EVENT_IVS_QUEUEDETECTION(0x00000123, "排队检测报警事件"),
    /**
     * 占用公交车道事件
     */
    EVENT_IVS_TRAFFIC_VEHICLEINBUSROUTE(0x00000124, "占用公交车道事件"),
    /**
     * 违章倒车事件
     */
    EVENT_IVS_TRAFFIC_BACKING(0x00000125, "违章倒车事件"),
    /**
     * 声音异常检测
     */
    EVENT_IVS_AUDIO_ABNORMALDETECTION(0x00000126, "声音异常检测"),
    /**
     * 交通违章-闯黄灯事件
     */
    EVENT_IVS_TRAFFIC_RUNYELLOWLIGHT(0x00000127, "交通违章-闯黄灯事件"),
    /**
     * 攀高检测事件
     */
    EVENT_IVS_CLIMBDETECTION(0x00000128, "攀高检测事件"),
    /**
     * 离岗检测事件
     */
    EVENT_IVS_LEAVEDETECTION(0x00000129, "离岗检测事件"),
    /**
     * 黄网格线抓拍事件
     */
    EVENT_IVS_TRAFFIC_PARKINGONYELLOWBOX(0x0000012A, "黄网格线抓拍事件"),
    /**
     * 车位有车事件
     */
    EVENT_IVS_TRAFFIC_PARKINGSPACEPARKING(0x0000012B, "车位有车事件"),
    /**
     * 车位无车事件
     */
    EVENT_IVS_TRAFFIC_PARKINGSPACENOPARKING(0x0000012C, "车位无车事件"),
    /**
     * 交通行人事件
     */
    EVENT_IVS_TRAFFIC_PEDESTRAIN(0x0000012D, "交通行人事件"),
    /**
     * 交通抛洒物品事件
     */
    EVENT_IVS_TRAFFIC_THROW(0x0000012E, "交通抛洒物品事件"),
    /**
     * 交通空闲事件
     */
    EVENT_IVS_TRAFFIC_IDLE(0x0000012F, "交通空闲事件"),
    /**
     * 车载ACC断电报警事件
     */
    EVENT_ALARM_VEHICLEACC(0x00000130, "车载ACC断电报警事件"),
    /**
     * 车辆侧翻报警事件
     */
    EVENT_ALARM_VEHICLE_TURNOVER(0x00000131, "车辆侧翻报警事件"),
    /**
     * 车辆撞车报警事件
     */
    EVENT_ALARM_VEHICLE_COLLISION(0x00000132, "车辆撞车报警事件"),
    /**
     * 车载摄像头大角度扭转事件
     */
    EVENT_ALARM_VEHICLE_LARGE_ANGLE(0x00000133, "车载摄像头大角度扭转事件"),
    /**
     * 车位压线事件
     */
    EVENT_IVS_TRAFFIC_PARKINGSPACEOVERLINE(0x00000134, "车位压线事件"),
    /**
     * 多场景切换事件
     */
    EVENT_IVS_MULTISCENESWITCH(0x00000135, "多场景切换事件"),
    /**
     * 受限车牌事件
     */
    EVENT_IVS_TRAFFIC_RESTRICTED_PLATE(0x00000136, "受限车牌事件"),
    /**
     * 压停止线事件
     */
    EVENT_IVS_TRAFFIC_OVERSTOPLINE(0x00000137, "压停止线事件"),
    /**
     * 交通未系安全带事件
     */
    EVENT_IVS_TRAFFIC_WITHOUT_SAFEBELT(0x00000138, "交通未系安全带事件"),
    /**
     * 驾驶员抽烟事件
     */
    EVENT_IVS_TRAFFIC_DRIVER_SMOKING(0x00000139, "驾驶员抽烟事件"),
    /**
     * 驾驶员打电话事件
     */
    EVENT_IVS_TRAFFIC_DRIVER_CALLING(0x0000013A, "驾驶员打电话事件"),
    /**
     * 行人闯红灯事件
     */
    EVENT_IVS_TRAFFIC_PEDESTRAINRUNREDLIGHT(0x0000013B, "行人闯红灯事件"),
    /**
     * 未按规定依次通行
     */
    EVENT_IVS_TRAFFIC_PASSNOTINORDER(0x0000013C, "未按规定依次通行"),
    /**
     * 物体特征检测事件
     */
    EVENT_IVS_OBJECT_DETECTION(0x00000141, "物体特征检测事件"),
    /**
     * 模拟量报警通道的报警事件
     */
    EVENT_ALARM_ANALOGALARM(0x00000150, "模拟量报警通道的报警事件"),
    /**
     * 警戒线扩展事件
     */
    EVENT_IVS_CROSSLINEDETECTION_EX(0x00000151, "警戒线扩展事件"),
    /**
     * 普通录像
     */
    EVENT_ALARM_COMMON(0x00000152, "普通录像"),
    /**
     * 视频遮挡事件
     */
    EVENT_ALARM_VIDEOBLIND(0x00000153, "视频遮挡事件"),
    /**
     * 视频丢失事件
     */
    EVENT_ALARM_VIDEOLOSS(0x00000154, "视频丢失事件"),
    /**
     * 看守所下床事件
     */
    EVENT_IVS_GETOUTBEDDETECTION(0x00000155, "看守所下床事件"),
    /**
     * 巡逻检测事件
     */
    EVENT_IVS_PATROLDETECTION(0x00000156, "巡逻检测事件"),
    /**
     * 站岗检测事件
     */
    EVENT_IVS_ONDUTYDETECTION(0x00000157, "站岗检测事件"),
    /**
     * 门口机呼叫未响应事件
     */
    EVENT_IVS_NOANSWERCALL(0x00000158, "门口机呼叫未响应事件"),
    /**
     * 存储组不存在事件
     */
    EVENT_IVS_STORAGENOTEXIST(0x00000159, "存储组不存在事件"),
    /**
     * 硬盘空间低报警事件
     */
    EVENT_IVS_STORAGELOWSPACE(0x0000015A, "硬盘空间低报警事件"),
    /**
     * 存储错误事件
     */
    EVENT_IVS_STORAGEFAILURE(0x0000015B, "存储错误事件"),
    /**
     * 报警传输事件
     */
    EVENT_IVS_PROFILEALARMTRANSMIT(0x0000015C, "报警传输事件"),
    /**
     * 视频静态检测事件
     */
    EVENT_IVS_VIDEOSTATIC(0x0000015D, "视频静态检测事件"),
    /**
     * 视频定时检测事件
     */
    EVENT_IVS_VIDEOTIMING(0x0000015E, "视频定时检测事件"),
    /**
     * 热度图
     */
    EVENT_IVS_HEATMAP(0x0000015F, "热度图"),
    /**
     * 身份证信息读取事件
     */
    EVENT_IVS_CITIZENIDCARD(0x00000160, "身份证信息读取事件"),
    /**
     * 图片信息事件
     */
    EVENT_IVS_PICINFO(0x00000161, "图片信息事件"),
    /**
     * 上网登记事件
     */
    EVENT_IVS_NETPLAYCHECK(0x00000162, "上网登记事件"),
    /**
     * 车辆拥堵禁入事件
     */
    EVENT_IVS_TRAFFIC_JAM_FORBID_INTO(0x00000163, "车辆拥堵禁入事件"),
    /**
     * 定时抓图事件
     */
    EVENT_IVS_SNAPBYTIME(0x00000164, "定时抓图事件"),
    /**
     * 云台转动到预置点事件
     */
    EVENT_IVS_PTZ_PRESET(0x00000165, "云台转动到预置点事件"),
    /**
     * 红外线检测信息事件
     */
    EVENT_IVS_RFID_INFO(0x00000166, "红外线检测信息事件"),
    /**
     * 人起立检测事件
     */
    EVENT_IVS_STANDUPDETECTION(0x00000167, "人起立检测事件"),
    /**
     * 交通卡口称重事件
     */
    EVENT_IVS_QSYTRAFFICCARWEIGHT(0x00000168, "交通卡口称重事件"),
    /**
     * 卡口前后车牌合成事件
     */
    EVENT_IVS_TRAFFIC_COMPAREPLATE(0x00000169, "卡口前后车牌合成事件"),
    /**
     * 打靶像机事件
     */
    EVENT_IVS_SHOOTINGSCORERECOGNITION(0x0000016A, "打靶像机事件"),
    /**
     * 加油站提枪、挂枪事件
     */
    EVENT_IVS_TRAFFIC_FCC(0x0000016B, "加油站提枪、挂枪事件"),
    /**
     * 违章超限抓图上报事件,绍兴科技治超
     */
    EVENT_IVS_TRAFFIC_TRANSFINITE(0x0000016C, "违章超限抓图上报事件,绍兴科技治超"),
    /**
     * 场景变更事件
     */
    EVENT_IVS_SCENE_CHANGE(0x0000016D, "场景变更事件"),
    /**
     * 简单跟踪事件
     */
    EVENT_IVS_LETRACK(0x0000016E, "简单跟踪事件"),
    /**
     * 物体检测事件
     */
    EVENT_IVS_OBJECT_ACTION(0x0000016F, "物体检测事件"),
    /**
     * 预分析抓拍图片事件
     */
    EVENT_IVS_TRAFFIC_ANALYSE_PRESNAP(0x00000170, "预分析抓拍图片事件"),
    /**
     * 智能插座电量状态上报
     */
    EVENT_ALARM_EQSTATE(0x00000171, "智能插座电量状态上报"),
    /**
     * DVR/NVR设备上的IPC报警
     */
    EVENT_IVS_ALARM_IPC(0x00000172, "DVR/NVR设备上的IPC报警"),
    /**
     * POS录像查询事件
     */
    EVENT_IVS_POS_RECORD(0x00000173, "POS录像查询事件"),
    /**
     * 近距离接触事件
     */
    EVENT_IVS_NEAR_DISTANCE_DETECTION(0x00000174, "近距离接触事件"),
    /**
     * 行人特征检测事件
     */
    EVENT_IVS_OBJECTSTRUCTLIZE_PERSON(0x00000175, "行人特征检测事件"),
    /**
     * 非机动车特征检测事件
     */
    EVENT_IVS_OBJECTSTRUCTLIZE_NONMOTOR(0x00000176, "非机动车特征检测事件"),
    /**
     * 倒地报警事件
     */
    EVENT_IVS_TUMBLE_DETECTION(0x00000177, "倒地报警事件"),
    /**
     * 所有以traffic开头的事件,目前指的是
     */
    EVENT_IVS_TRAFFIC_ALL(0x000001FF, "所有以traffic开头的事件,目前指的是"),
    /**
     * EVENT_TRAFFICSNAPSHOT
     */
    //(EVENT_IVS_TRAFFICCONTROL, "EVENT_TRAFFICSNAPSHOT"),
    /**
     * EVENT_IVS_TRAFFIC_UNDERSPEED
     */
    //(EVENT_IVS_TRAFFIC_RUNREDLIGHT, "EVENT_IVS_TRAFFIC_UNDERSPEED"),
    /**
     * 所有智能分析事件
     */
    EVENT_IVS_VIDEOANALYSE(0x00000200, "所有智能分析事件"),
    /**
     * LinkSD事件
     */
    EVENT_IVS_LINKSD(0x00000201, "LinkSD事件"),
    /**
     * 车辆特征检测分析
     */
    EVENT_IVS_VEHICLEANALYSE(0x00000202, "车辆特征检测分析"),
    /**
     * 流量使用情况事件
     */
    EVENT_IVS_FLOWRATE(0x00000203, "流量使用情况事件"),
    /**
     * 门禁事件
     */
    EVENT_IVS_ACCESS_CTL(0x00000204, "门禁事件"),
    /**
     * SnapManual事件
     */
    EVENT_IVS_SNAPMANUAL(0x00000205, "SnapManual事件"),
    /**
     * RFID电子车牌标签事件
     */
    EVENT_IVS_TRAFFIC_ELETAGINFO(0x00000206, "RFID电子车牌标签事件"),
    /**
     * 生理疲劳驾驶事件
     */
    EVENT_IVS_TRAFFIC_TIREDPHYSIOLOGICAL(0x00000207, "生理疲劳驾驶事件"),
    /**
     * 车辆急转报警事件
     */
    EVENT_IVS_TRAFFIC_BUSSHARPTURN(0x00000208, "车辆急转报警事件"),
    /**
     * 人证比对事件
     */
    EVENT_IVS_CITIZEN_PICTURE_COMPARE(0x00000209, "人证比对事件"),
    /**
     * 开车低头报警事件
     */
    EVENT_IVS_TRAFFIC_TIREDLOWERHEAD(0x0000020A, "开车低头报警事件"),
    /**
     * 开车左顾右盼报警事件
     */
    EVENT_IVS_TRAFFIC_DRIVERLOOKAROUND(0x0000020B, "开车左顾右盼报警事件"),
    /**
     * 开车离岗报警事件
     */
    EVENT_IVS_TRAFFIC_DRIVERLEAVEPOST(0x0000020C, "开车离岗报警事件"),
    /**
     * 立体视觉站立事件
     */
    EVENT_IVS_MAN_STAND_DETECTION(0x0000020D, "立体视觉站立事件"),
    /**
     * 立体视觉区域内人数统计事件
     */
    EVENT_IVS_MAN_NUM_DETECTION(0x0000020E, "立体视觉区域内人数统计事件"),
    /**
     * 客流量统计事件
     */
    EVENT_IVS_STEREO_NUMBERSTAT(0x0000020F, "客流量统计事件"),
    /**
     * 开车打哈欠事件
     */
    EVENT_IVS_TRAFFIC_DRIVERYAWN(0x00000210, "开车打哈欠事件"),
    /**
     * 客流量统计计划
     */
    EVENT_IVS_NUMBERSTAT_PLAN(0x00000211, "客流量统计计划"),
    /**
     * 热度图计划
     */
    EVENT_IVS_HEATMAP_PLAN(0x00000212, "热度图计划"),
    /**
     * 呼叫无答应事件
     */
    EVENT_IVS_CALLNOANSWERED(0x00000213, "呼叫无答应事件"),
    /**
     * 无视邀请事件
     */
    EVENT_IVS_IGNOREINVITE(0x00000214, "无视邀请事件"),
    /**
     * 人体特征事件
     */
    EVENT_IVS_HUMANTRAIT(0x00000215, "人体特征事件"),
    /**
     * 乐橙人头检测事件
     */
    EVENT_ALARM_LE_HEADDETECTION(0x00000216, "乐橙人头检测事件"),
    /**
     * 人脸分析事件
     */
    EVENT_IVS_FACEANALYSIS(0x00000217, "人脸分析事件"),
    /**
     * 左转不礼让直行事件
     */
    EVENT_IVS_TRAFFIC_TURNLEFTAFTERSTRAIGHT(0x00000218, "左转不礼让直行事件"),
    /**
     * 大弯小转事件
     */
    EVENT_IVS_TRAFFIC_BIGBENDSMALLTURN(0x00000219, "大弯小转事件"),
    /**
     * 道路施工监测事件
     */
    EVENT_IVS_ROAD_CONSTRUCTION(0x0000021A, "道路施工监测事件"),
    /**
     * 路障检测事件
     */
    EVENT_IVS_ROAD_BLOCK(0x0000021B, "路障检测事件"),
    /**
     * 车辆加塞事件
     */
    EVENT_IVS_TRAFFIC_QUEUEJUMP(0x0000021C, "车辆加塞事件"),
    /**
     * 嫌疑车辆事件
     */
    EVENT_IVS_VEHICLE_SUSPICIOUSCAR(0x0000021D, "嫌疑车辆事件"),
    /**
     * 右转不礼让直行事件
     */
    EVENT_IVS_TRAFFIC_TURNRIGHTAFTERSTRAIGHT(0x0000021E, "右转不礼让直行事件"),
    /**
     * 右转不礼让直行行人
     */
    EVENT_IVS_TRAFFIC_TURNRIGHTAFTERPEOPLE(0x0000021F, "右转不礼让直行行人"),
    /**
     * 安装读卡器事件
     */
    EVENT_IVS_INSTALL_CARDREADER(0x00000220, "安装读卡器事件"),
    /**
     * Yale
     */
    EVENT_ALARM_YALE_DROPBOX_BADTOKEN(0x00000221, "Yale"),
    /**
     * 车载设备断电前抓拍上传事件
     */
    EVENT_IVS_ACC_OFF_SNAP(0x00000222, "车载设备断电前抓拍上传事件"),
    /**
     * X光检测事件
     */
    EVENI_IVS_XRAY_DETECTION(0x00000223, "X光检测事件"),
    /**
     * 未清车告警
     */
    EVENT_IVS_NOTCLEARCAR(0x00000224, "未清车告警"),
    /**
     * sos求救报警
     */
    EVENT_IVS_SOSALEART(0x00000225, "sos求救报警"),
    /**
     * 超载抓图
     */
    EVENT_IVS_OVERLOAD(0x00000226, "超载抓图"),
    /**
     * 非工作时间告警
     */
    EVENT_IVS_NONWORKINGTIME(0x00000227, "非工作时间告警"),
    /**
     * 远光灯违章事件
     */
    EVENT_IVS_TRAFFIC_HIGH_BEAM(0x00000228, "远光灯违章事件"),
    /**
     * 禁止货车事件
     */
    EVENT_IVS_TRAFFIC_TRUCKFORBID(0x00000229, "禁止货车事件"),
    /**
     * 无卡驾驶报警事件
     */
    EVENT_IVS_DRIVINGWITHOUTCARD(0x0000022A, "无卡驾驶报警事件"),
    /**
     * 车辆超速报警事件
     */
    EVENT_IVS_HIGHSPEED(0x0000022B, "车辆超速报警事件"),
    /**
     * 人群密度检测事件
     */
    EVENT_IVS_CROWDDETECTION(0x0000022C, "人群密度检测事件"),
    /**
     * 车间距过小报警事件
     */
    EVENT_IVS_TRAFFIC_CARDISTANCESHORT(0x0000022D, "车间距过小报警事件"),
    /**
     * 行人卡口事件
     */
    EVENT_IVS_PEDESTRIAN_JUNCTION(0x00000230, "行人卡口事件"),
    /**
     * 车牌对比事件
     */
    EVENT_IVS_VEHICLE_RECOGNITION(0x00000231, "车牌对比事件"),
    /**
     * 预置点图片变化事件
     */
    EVENT_IVS_PASS_CHANGE(0x00000232, "预置点图片变化事件"),
    /**
     * 违停相机定制单球车位检测规则事件
     */
    EVENT_IVS_TRAFFIC_PARKING_SPACEDETECTION(0x00000233, "违停相机定制单球车位检测规则事件"),
    /**
     * 违章进入待行区事件
     */
    EVENT_IVS_TRAFFIC_WAITINGAREA(0x00000234, "违章进入待行区事件"),
    /**
     * 机动车违法禁令标识事件
     */
    EVENT_IVS_TRAFFIC_BAN(0x00000235, "机动车违法禁令标识事件"),
    /**
     * POS机交易事件
     */
    EVENT_IVS_POS_EXCHANGE(0x00000236, "POS机交易事件"),
    /**
     * 立体行为分析打架/剧烈运动检测规则
     */
    EVENT_IVS_STEREO_FIGHTDETECTION(0x00000237, "立体行为分析打架/剧烈运动检测规则"),
    /**
     * 立体行为分析间距异常/人员靠近检测
     */
    EVENT_IVS_STEREO_DISTANCE_DETECTION(0x00000238, "立体行为分析间距异常/人员靠近检测"),
    /**
     * 立体行为分析跌倒检测规则
     */
    EVENT_IVS_STEREO_STEREOFALLDETECTION(0x00000239, "立体行为分析跌倒检测规则"),
    /**
     * 立体行为分析人员滞留检测规则
     */
    EVENT_IVS_STEREO_STAYDETECTION(0x0000023A, "立体行为分析人员滞留检测规则"),
    /**
     * 拉横幅事件
     */
    EVENT_IVS_BANNER_DETECTION(0x0000023B, "拉横幅事件"),
    /**
     * 普通打架事件
     */
    EVENT_IVS_NORMAL_FIGHTDETECTION(0x0000023C, "普通打架事件"),
    /**
     * 电动扶梯运行异常事件
     */
    EVENT_IVS_ELEVATOR_ABNORMAL(0x0000023D, "电动扶梯运行异常事件"),
    /**
     * 非机动车检测
     */
    EVENT_IVS_NONMOTORDETECT(0x0000023E, "非机动车检测"),
    /**
     * 机动车检测
     */
    EVENT_IVS_VEHICLEDETECT(0x0000023F, "机动车检测"),
    /**
     * 交通违章-B类违章停车
     */
    EVENT_IVS_TRAFFIC_PARKING_B(0x00000240, "交通违章-B类违章停车"),
    /**
     * 交通违章-C类违章停车
     */
    EVENT_IVS_TRAFFIC_PARKING_C(0x00000241, "交通违章-C类违章停车"),
    /**
     * 交通违章-D类违章停车
     */
    EVENT_IVS_TRAFFIC_PARKING_D(0x00000242, "交通违章-D类违章停车"),
    /**
     * IVSS人脸检测事件
     */
    EVENT_IVSS_FACEATTRIBUTE(0x00000243, "IVSS人脸检测事件"),
    /**
     * IVSS人脸识别事件
     */
    EVENT_IVSS_FACECOMPARE(0x00000244, "IVSS人脸识别事件"),
    /**
     * 火警事件
     */
    EVENT_IVS_FIREWARNING(0x00000245, "火警事件"),
    /**
     * 商铺占道经营事件
     */
    EVENT_IVS_SHOPPRESENCE(0x00000246, "商铺占道经营事件"),
    /**
     * 垃圾违章倾倒事件
     */
    EVENT_IVS_WASTEDUMPED(0x00000247, "垃圾违章倾倒事件"),
    /**
     * 抛洒物检测事件
     */
    EVENT_IVS_SPILLEDMATERIAL_DETECTION(0x00000248, "抛洒物检测事件"),
    /**
     * 立体行为分析人数异常检测
     */
    EVENT_IVS_STEREO_MANNUM_DETECTION(0x00000249, "立体行为分析人数异常检测"),
    /**
     * 异常间距事件
     */
    EVENT_IVS_DISTANCE_DETECTION(0x0000024A, "异常间距事件"),
    /**
     * 非机动车超载事件
     */
    EVENT_IVS_TRAFFIC_NONMOTOR_OVERLOAD(0x0000024B, "非机动车超载事件"),
    /**
     * 非机动车未戴安全帽事件
     */
    EVENT_IVS_TRAFFIC_NONMOTOR_WITHOUTSAFEHAT(0x0000024C, "非机动车未戴安全帽事件"),
    /**
     * 拥堵滞留斑马线事件
     */
    EVENT_IVS_TRAFFIC_JAM_STOP_ON_ZEBRACROSSING(0x0000024D, "拥堵滞留斑马线事件"),
    /**
     * 流动摊贩事件
     */
    EVENT_IVS_FLOWBUSINESS(0x0000024E, "流动摊贩事件"),
    /**
     * 城市机动车违停事件
     */
    EVENT_IVS_CITY_MOTORPARKING(0x0000024F, "城市机动车违停事件"),
    /**
     * 城市机非动车违停事件
     */
    EVENT_IVS_CITY_NONMOTORPARKING(0x00000250, "城市机非动车违停事件"),
    /**
     * 车道偏移预警
     */
    EVENT_IVS_LANEDEPARTURE_WARNNING(0X00000251, "车道偏移预警"),
    /**
     * 前向碰撞预警
     */
    EVENT_IVS_FORWARDCOLLISION_WARNNING(0x00000252, "前向碰撞预警"),
    /**
     * 物料堆放事件
     */
    EVENT_IVS_MATERIALSSTAY(0x00000253, "物料堆放事件"),
    /**
     * 非机动车装载伞具
     */
    EVENT_IVS_TRAFFIC_NONMOTOR_HOLDUMBRELLA(0x00000254, "非机动车装载伞具"),
    /**
     * 客户报警产品
     */
    EVENT_IVS_JABLOTRON_ALARM(0x00000255, "客户报警产品"),
    /**
     * 视频虚焦事件
     */
    EVENT_IVS_VIDEOUNFOCUS_ALARM(0x00000256, "视频虚焦事件"),
    /**
     * 漂浮物检测事件
     */
    EVENT_IVS_FLOATINGOBJECT_DETECTION(0x00000257, "漂浮物检测事件"),
    /**
     * 船舶检测事件
     */
    EVENT_IVS_SHIP_DETECTION(0x00000258, "船舶检测事件"),
    /**
     * 飞机行为检测事件
     */
    EVENT_IVS_AIRPLANE_DETECTION(0x00000259, "飞机行为检测事件"),
    /**
     * 打电话检测事件
     */
    EVENT_IVS_PHONECALL_DETECT(0x0000025A, "打电话检测事件"),
    /**
     * 吸烟检测事件
     */
    EVENT_IVS_SMOKING_DETECT(0x0000025B, "吸烟检测事件"),
    /**
     * 雷达限速报警事件
     */
    EVENT_IVS_RADAR_SPEED_LIMIT_ALARM(0x0000025C, "雷达限速报警事件"),
    /**
     * 水位检测事件
     */
    EVENT_IVS_WATER_LEVEL_DETECTION(0x0000025D, "水位检测事件"),
    /**
     * 违规撑伞检测事件
     */
    EVENT_IVS_HOLD_UMBRELLA(0x0000025E, "违规撑伞检测事件"),
    /**
     * 垃圾暴露检测事件
     */
    EVENT_IVS_GARBAGE_EXPOSURE(0x0000025F, "垃圾暴露检测事件"),
    /**
     * 垃圾桶满溢检测事件
     */
    EVENT_IVS_DUSTBIN_OVER_FLOW(0x00000260, "垃圾桶满溢检测事件"),
    /**
     * 门前脏乱检测事件
     */
    EVENT_IVS_DOOR_FRONT_DIRTY(0x00000261, "门前脏乱检测事件"),
    /**
     * 排队滞留时间报警事件
     */
    EVENT_IVS_QUEUESTAY_DETECTION(0X00000262, "排队滞留时间报警事件"),
    /**
     * 排队人数异常报警事件
     */
    EVENT_IVS_QUEUENUM_DETECTION(0X00000263, "排队人数异常报警事件"),
    /**
     * 生成图规则事件
     */
    EVENT_IVS_GENERATEGRAPH_DETECTION(0X00000264, "生成图规则事件"),
    /**
     * 交通违章-手动取证
     */
    EVENT_IVS_TRAFFIC_PARKING_MANUAL(0x00000265, "交通违章-手动取证"),
    /**
     * 安全帽检测事件
     */
    EVENT_IVS_HELMET_DETECTION(0x00000266, "安全帽检测事件"),
    /**
     * 包裹堆积程度检测事件
     */
    EVENT_IVS_DEPOSIT_DETECTION(0x00000267, "包裹堆积程度检测事件"),
    /**
     * 热点异常报警事件
     */
    EVENT_IVS_HOTSPOT_WARNING(0x00000268, "热点异常报警事件"),
    /**
     * 称重平台检测事件
     */
    EVENT_IVS_WEIGHING_PLATFORM_DETECTION(0x00000269, "称重平台检测事件"),
    /**
     * 课堂行为分析事件
     */
    EVENT_IVS_CLASSROOM_BEHAVIOR(0x0000026A, "课堂行为分析事件"),
    /**
     * 安全驾驶车距过近报警事件
     */
    EVENT_IVS_VEHICLE_DISTANCE_NEAR(0x0000026B, "安全驾驶车距过近报警事件"),
    /**
     * 驾驶员异常报警事件
     */
    EVENT_IVS_TRAFFIC_DRIVER_ABNORMAL(0x0000026C, "驾驶员异常报警事件"),
    /**
     * 驾驶员变更报警事件
     */
    EVENT_IVS_TRAFFIC_DRIVER_CHANGE(0x0000026D, "驾驶员变更报警事件"),
    /**
     * 工装
     */
    EVENT_IVS_WORKCLOTHES_DETECT(0x0000026E, "工装"),
    /**
     * 安检门人员报警事件
     */
    EVENT_IVS_SECURITYGATE_PERSONALARM(0x0000026F, "安检门人员报警事件"),
    /**
     * 单人独处事件
     */
    EVENT_IVS_STAY_ALONE_DETECTION(0x00000270, "单人独处事件"),
    /**
     * 交通路障检测事件
     */
    EVENT_IVS_TRAFFIC_ROAD_BLOCK(0x00000271, "交通路障检测事件"),
    /**
     * 交通道路施工检测事件
     */
    EVENT_IVS_TRAFFIC_ROAD_CONSTRUCTION(0x00000272, "交通道路施工检测事件"),
    /**
     * X光按物体检测规则配置,
     */
    EVENT_IVS_XRAY_DETECT_BYOBJECT(0x00000273, "X光按物体检测规则配置,"),
    /**
     * 作业统计事件
     */
    EVENT_IVS_WORKSTATDETECTION(0x00000274, "作业统计事件"),
    /**
     * 红外阻断事件
     */
    EVENT_IVS_INFRAREDBLOCK(0x00000275, "红外阻断事件"),
    /**
     * 特征提取事件
     */
    EVENT_IVS_FEATURE_ABSTRACT(0x00000276, "特征提取事件"),
    /**
     * 智能补货事件
     */
    EVENT_IVS_INTELLI_SHELF(0x00000277, "智能补货事件"),
    /**
     * 全景抓拍事件
     */
    EVENT_IVS_PANORAMA_SHOT(0x00000278, "全景抓拍事件"),
    /**
     * 智能视频移动侦测事件
     */
    EVENT_ALARM_SMARTMOTION_HUMAN(0x00000279, "智能视频移动侦测事件"),
    /**
     * 智能视频移动侦测事件
     */
    EVENT_ALARM_SMARTMOTION_VEHICLE(0x0000027A, "智能视频移动侦测事件"),
    /**
     * 车辆驶入驶出状态事件
     */
    EVENT_IVS_CAR_DRIVING_IN_OUT(0x0000027B, "车辆驶入驶出状态事件"),
    /**
     * 停车位状态事件
     */
    EVENT_IVS_PARKINGSPACE_STATUS(0x0000027C, "停车位状态事件"),
    /**
     * 暴力抛物检测
     */
    EVENT_IVS_VIOLENT_THROW_DETECTION(0x0000027D, "暴力抛物检测"),
    /**
     * 矿车超挂报警事件
     */
    EVENT_IVS_TRAMCARSECTIONS_DETECTION(0x0000027E, "矿车超挂报警事件"),
    /**
     * 报警盒通道的触发报警事件,
     */
    EVENT_IVS_ALARM_BOX_ALARM(0x0000027F, "报警盒通道的触发报警事件,"),
    /**
     * 人脸比对事件,
     */
    EVENT_IVS_FACE_COMPARISION(0x00000280, "人脸比对事件,"),
    /**
     * 人像检测事件
     */
    EVENT_IVS_FACEBODY_DETECT(0x00000281, "人像检测事件"),
    /**
     * 人像识别事件
     */
    EVENT_IVS_FACEBODY_ANALYSE(0x00000282, "人像识别事件"),
    /**
     * 加油站车辆检测事件
     */
    EVENT_IVS_GASSTATION_VEHICLE_DETECT(0x00000283, "加油站车辆检测事件"),
    /**
     * 道路场景车辆拥堵报警事件
     */
    EVENT_IVS_CONGESTION_DETECTION(0x00000284, "道路场景车辆拥堵报警事件"),
    /**
     * 停车场场景下停车车辆上限报警
     */
    EVENT_IVS_VEHICLELIMIT_DETECTION(0x00000285, "停车场场景下停车车辆上限报警"),
    /**
     * 动物检测事件,
     */
    EVENT_IVS_ANIMAL_DETECTION(0x00000286, "动物检测事件,"),
    /**
     * 橱窗张贴事件
     */
    EVENT_IVS_SHOP_WINDOW_POST(0x00000287, "橱窗张贴事件"),
    /**
     * 店招异常事件
     */
    EVENT_IVS_SHOP_SIGN_ABNORMAL(0x00000288, "店招异常事件"),
    /**
     * 智慧养殖检测事件
     */
    EVENT_IVS_BREED_DETECTION(0x00000289, "智慧养殖检测事件"),
    /**
     * 机场智能保障车辆检测事件
     */
    EVENT_IVS_AIRPORT_VEHICLE_DETECT(0x0000028A, "机场智能保障车辆检测事件"),
    /**
     * 智慧养殖猪体温检测
     */
    EVENT_IVS_PIG_TEMPERATURE_DETECT(0x0000028B, "智慧养殖猪体温检测"),
    /**
     * 人车共存事件
     */
    EVENT_IVS_MAN_CAR_COEXISTANCE(0x0000028C, "人车共存事件"),
    /**
     * 高空抛物检测
     */
    EVENT_IVS_HIGH_TOSS_DETECT(0x0000028D, "高空抛物检测"),
    /**
     * 电力检测手套检测事件
     */
    EVENT_IVS_ELECTRIC_GLOVE_DETECT(0x0000028E, "电力检测手套检测事件"),
    /**
     * 电力检测梯子检测事件
     */
    EVENT_IVS_ELECTRIC_LADDER_DETECT(0x0000028F, "电力检测梯子检测事件"),
    /**
     * 电力检测布幔检测事件
     */
    EVENT_IVS_ELECTRIC_CURTAIN_DETECT(0x00000290, "电力检测布幔检测事件"),
    /**
     * 电力检测围栏检测事件
     */
    EVENT_IVS_ELECTRIC_FENCE_DETECT(0x00000291, "电力检测围栏检测事件"),
    /**
     * 电力检测标识牌检测事件
     */
    EVENT_IVS_ELECTRIC_SIGNBOARD_DETECT(0x00000292, "电力检测标识牌检测事件"),
    /**
     * 电力检测安全带检测事件
     */
    EVENT_IVS_ELECTRIC_BELT_DETECT(0x00000293, "电力检测安全带检测事件"),
    /**
     * 雷达警戒线/绊线检测
     */
    EVENT_IVS_RADAR_LINE_DETECTION(0x00000294, "雷达警戒线/绊线检测"),
    /**
     * 雷达警戒区检测事件
     */
    EVENT_IVS_RADAR_REGION_DETECTION(0x00000295, "雷达警戒区检测事件"),
    /**
     * 异常音事件
     */
    EVENT_IVS_AUDIO_INTENSITY(0x00000296, "异常音事件"),
    /**
     * 室外停车位状态检测
     */
    EVENT_IVS_PARKING_LOT_STATUS_DETECTION(0x00000297, "室外停车位状态检测"),
    /**
     * 只用于规则配置
     */
    EVENT_IVS_VEHICLE_COMPARE(0x00000298, "只用于规则配置"),
    /**
     * 渣土车未遮盖载货检测事件
     */
    EVENT_IVS_DREGS_UNCOVERED(0x00000299, "渣土车未遮盖载货检测事件"),
    /**
     * 走动检测事件
     */
    EVENT_IVS_WALK_DETECTION(0x0000029A, "走动检测事件"),
    /**
     * 背对检测事件
     */
    EVENT_IVS_BACK_TO_DETECTION(0x0000029B, "背对检测事件"),
    /**
     * 板书检测事件
     */
    EVENT_IVS_WRITE_ON_THE_BOARD_DETECTION(0x0000029C, "板书检测事件"),
    /**
     * 智慧厨房穿着检测事件
     */
    EVENT_IVS_SMART_KITCHEN_CLOTHES_DETECTION(0x0000029D, "智慧厨房穿着检测事件"),
    /**
     * 睡觉检测事件
     */
    EVENT_IVS_SLEEP_DETECT(0x0000029E, "睡觉检测事件"),
    /**
     * 随意走动检测事件
     */
    EVENT_IVS_WALK_AROUND_DETECT(0x0000029F, "随意走动检测事件"),
    /**
     * 玩手机事件
     */
    EVENT_IVS_PLAY_MOBILEPHONE(0x00000300, "玩手机事件"),
    /**
     * 智慧金融违规物品检测事件
     */
    EVENT_IVS_FINANCE_CONTRABAND_DETECT(0x00000301, "智慧金融违规物品检测事件"),
    /**
     * 智慧金融现金交易检测事件
     */
    EVENT_IVS_FINANCE_CASH_TRANSACTION(0x00000302, "智慧金融现金交易检测事件"),
    /**
     * 人体温智能检测事件
     */
    EVENT_IVS_ANATOMY_TEMP_DETECT(0x00000303, "人体温智能检测事件"),
    /**
     * 活跃度统计规则
     */
    EVENT_IVS_ACTIVITY_ANALYSE(0x00000304, "活跃度统计规则"),
    /**
     * 门状态事件
     */
    EVENT_IVS_DOOR_STATUS(0x00000305, "门状态事件"),
    /**
     * Dhop自定义事件
     */
    EVENT_IVS_DHOP_CUSTOM(0x00000306, "Dhop自定义事件"),
    /**
     * Dhop自定义事件
     */
    EVENT_IVS_DHOP_CUSTOM_ONCE(0x00000307, "Dhop自定义事件"),
    /**
     * 起雾检测事件
     */
    EVENT_IVS_FOG_DETECTION(0x00000308, "起雾检测事件"),
    /**
     * 飙车事件
     */
    EVENT_IVS_TRAFFIC_VEHICLE_RACE(0x00000309, "飙车事件"),
    /**
     * 机动车超载
     */
    EVENT_IVS_TRAFFIC_MOTOR_OVERLOAD(0x0000030A, "机动车超载"),
    /**
     * 车牌污损
     */
    EVENT_IVS_TRAFFIC_PLATE_OCCLUSION(0x0000030B, "车牌污损"),
    /**
     * 非机动车进入电梯
     */
    EVENT_IVS_NONMOTOR_ENTRYING(0x0000030C, "非机动车进入电梯"),
    /**
     * 水位监测事件,
     */
    EVENT_IVS_WATER_STAGE_MONITOR(0x0000030D, "水位监测事件,"),
    /**
     * 道路安全预警
     */
    EVENT_IVS_TRAFFIC_ROAD_ALERT(0x0000030E, "道路安全预警"),
    /**
     * 违章建筑检测事件
     */
    EVENT_IVS_BREAK_RULE_BUILDING_DETECTION(0x0000030F, "违章建筑检测事件"),
    /**
     * 非机动车闯红灯
     */
    EVENT_IVS_TRAFFIC_NONMOTOR_RUN_REDLIGHT(0x00000310, "非机动车闯红灯"),
    /**
     * 占用应急车道事件
     */
    EVENT_IVS_TRAFFIC_VEHICLE_IN_EMERGENCY_LANE(0x00000311, "占用应急车道事件"),
    /**
     * 婴儿车检测事件
     */
    EVENT_IVS_PRAM_DETECTION(0x00000312, "婴儿车检测事件"),
    /**
     * 立体行为婴儿车检测事件
     */
    EVENT_IVS_STEREO_PRAM_DETECTION(0x00000313, "立体行为婴儿车检测事件"),
    /**
     * 大件行李箱检测事件
     */
    EVENT_IVS_BIG_BAGGAGE_DETECTION(0x00000314, "大件行李箱检测事件"),
    /**
     * 立体行为大件行李箱检测事件
     */
    EVENT_IVS_STEREO_BIG_BAGGAGE_DETECTION(0x00000315, "立体行为大件行李箱检测事件"),
    /**
     * 逃票检测事件
     */
    EVENT_IVS_TICKET_EVADE_DETECTION(0x00000316, "逃票检测事件"),
    /**
     * 立体行为逃票检测事件
     */
    EVENT_IVS_STEREO_TICKET_EVADE_DETECTION(0x00000317, "立体行为逃票检测事件"),
    /**
     * 输电线异物检测
     */
    EVENT_IVS_POWERLINE_FOREIGN_DETECITON(0x00000318, "输电线异物检测"),
    /**
     * 压导流线
     */
    EVENT_IVS_TRAFFIC_OVER_GUIDE_LINE(0x00000319, "压导流线"),
    /**
     * 交通卡口测量
     */
    EVENT_IVS_TRAFFIC_CAR_MEASUREMENT(0x00000320, "交通卡口测量"),
    /**
     * 不安规定使用转向灯事件
     */
    EVENT_IVS_TRAFFIC_WRONG_TURN_LIGHT(0x00000321, "不安规定使用转向灯事件"),
    /**
     * 交通事故事件
     */
    EVENT_IVS_TRAFFIC_REAREND_ACCIDENT(0x00000322, "交通事故事件"),
    /**
     * 对讲动作事件
     */
    EVENT_IVS_DO_TALK_ACTION(0x00000323, "对讲动作事件"),
    /**
     * 消防占道检测事件
     */
    EVENT_IVS_FIRE_LANE_DETECTION(0x00000324, "消防占道检测事件"),
    /**
     * 全景异常停车事件
     */
    EVENT_IVS_PARKING_DETECTION_FOR_PRMA(0x00000325, "全景异常停车事件"),
    /**
     * 全景交通拥堵事件
     */
    EVENT_IVS_TRAFFIC_JAM_FOR_PRMA(0x00000326, "全景交通拥堵事件"),
    /**
     * 全景交通事故事件
     */
    EVENT_IVS_TRAFFIC_ACCIDENT_FOR_PRMA(0x00000327, "全景交通事故事件"),
    /**
     * 非机动车逆行事件
     */
    EVENT_IVS_TRAFFIC_NON_MOTOR_RETROGRADE(0x00000328, "非机动车逆行事件"),
    /**
     * 非机动车越线停车事件
     */
    EVENT_IVS_TRAFFIC_NON_MOTOR_OVER_STOP_LINE(0x00000329, "非机动车越线停车事件"),
    /**
     * 车辆驶入事件
     */
    EVENT_IVS_CAR_DRIVING_IN(0x00000330, "车辆驶入事件"),
    /**
     * 车辆驶出事件
     */
    EVENT_IVS_CAR_DRIVING_OUT(0x00000331, "车辆驶出事件"),
    /**
     * 人像检测
     */
    EVENT_IVS_PORTRAIT_DETECTION(0x00000332, "人像检测"),
    /**
     * 特殊车辆检测
     */
    EVENT_IVS_TRAFFIC_SPECIAL_VEHICLE_DETECT(0x00000333, "特殊车辆检测"),
    /**
     * 未开照明灯事件
     */
    EVENT_IVS_TRAFFIC_HEAD_LAMP_OFF(0x00000334, "未开照明灯事件"),
    /**
     * 交通非机动车事件检测,
     */
    EVENT_IVS_TRAFFIC_NONMOTOR(0x00000335, "交通非机动车事件检测,"),
    /**
     * 交通违章上下客事件检测
     */
    EVENT_IVS_TRAFFIC_BOARD(0x00000336, "交通违章上下客事件检测"),
    /**
     * 交通能见度事件检测
     */
    EVENT_IVS_TRAFFIC_VISIBILITY(0x00000337, "交通能见度事件检测"),
    /**
     * 交通车辆清洁度检测事件检测
     */
    EVENT_IVS_TRAFFIC_VEHICLE_CLEANLINESS(0x00000338, "交通车辆清洁度检测事件检测"),
    /**
     * 全景交通车流
     */
    EVENT_IVS_TRAFFICFLOW_FOR_PRMA(0x00000339, "全景交通车流"),
    /**
     * 工程车未清洗
     */
    EVENT_IVS_TRUCKNOTCLEAN_FOR_PRMA(0x0000033A, "工程车未清洗"),
    /**
     * 异物占道事件
     */
    EVENT_IVS_ROADOCCUPATION_BY_FOREIGNOBJECT(0x0000033B, "异物占道事件"),
    /**
     * 车流量超过上限
     */
    EVENT_IVS_TRAFFICFLOW_OVER(0x0000033C, "车流量超过上限"),
    /**
     * 违规物品检测事件
     */
    EVENT_IVS_GOODS_DETECTION(0x0000033D, "违规物品检测事件"),
    /**
     * 传送带阻塞报警事件
     */
    EVENT_IVS_CONVEYORBLOCK_DETECTION(0x0000033E, "传送带阻塞报警事件"),
    /**
     * 全物体类型检测事件
     */
    EVENT_IVS_ANYTHING_DETECT(0x0000033F, "全物体类型检测事件"),
    /**
     * 目标异常事件
     */
    EVENT_IVS_OBJECT_ABNORMAL(0x00000340, "目标异常事件"),
    /**
     * 辅助驾驶
     */
    EVENT_IVS_DRIVE_ASSISTANT(0x00000341, "辅助驾驶"),
    /**
     * 驾驶行为分析
     */
    EVENT_IVS_DRIVE_ACTION_ANAYLSE(0x00000342, "驾驶行为分析"),
    /**
     * 驾驶行为分析
     */
    EVENT_IVS_DRIVE_HANDSOFF_STEERING_WHEEL(0x00000343, "驾驶行为分析"),
    /**
     * 驾驶行为分析
     */
    EVENT_IVS_DRIVE_BLIND_SPOT(0x00000344, "驾驶行为分析"),
    /**
     * 物品检测
     */
    EVENT_IVS_ARTICLE_DETECTION(0x00000345, "物品检测"),
    /**
     * 路侧停车位手动抓图
     */
    EVENT_IVS_TRAFFIC_PARKINGSPACE_MANUALSNAP(0x00000346, "路侧停车位手动抓图"),
    /**
     * 沿街晾晒事件
     */
    EVENT_IVS_STREET_SUNCURE(0x00000347, "沿街晾晒事件"),
    /**
     * 户外广告事件
     */
    EVENT_IVS_OUTDOOR_ADVERTISEMENT(0x00000348, "户外广告事件"),
    /**
     * 乱堆物料检测事件
     */
    EVENT_IVS_HUDDLE_MATERIAL(0x00000349, "乱堆物料检测事件"),
    /**
     * 进入消防通道检测
     */
    EVENT_IVS_FIRE_LINE_DETECTION(0x0000034A, "进入消防通道检测"),
    /**
     * 违法占用公交车道
     */
    EVENT_IVS_OCCUPY_BUS_LANE(0x0000034B, "违法占用公交车道"),
    /**
     * 求救检测事件
     */
    EVENT_IVS_DISTRESS_DETECTION(0x0000034C, "求救检测事件"),
    /**
     * 交通副驾驶未系安全带事件
     */
    EVENT_IVS_TRAFFIC_ASSISTANT_WITHOUT_SAFEBELT(0x0000034D, "交通副驾驶未系安全带事件"),
    /**
     * 读写组,原型为"ReadWrite*","ReadWrite*",代表读写组,
     */
    STOR_POINT_READ_WRITE(0x00001001, "读写组"),
    /**
     * 只读组
     */
    STOR_POINT_READ_ONLY(0x00001002, "只读组"),
    /**
     * 冗余组,和"ReadWirte"组一个冗余副本
     */
    STOR_POINT_REDUNDANT(0x00001003, "冗余组"),
    /**
     * 备份组,数据写满后停止,不会循环覆盖
     */
    STOR_POINT_BACKUP(0x00001004, "备份组,数据写满后停止,不会循环覆盖"),
    /**
     * 历史抽帧组,实时录像在指定时间后,抽帧并写入该组
     */
    STOR_POINT_DRAW_FRAME(0x00001005, "历史抽帧组,实时录像在指定时间后,抽帧并写入该组"),
    /**
     * 远程网络存储组
     */
    STOR_POINT_NAS_FTP(0x00001006, "远程网络存储组"),
    /**
     * 远程网络存储组
     */
    STOR_POINT_NAS_NFS(0x00001007, "远程网络存储组"),
    /**
     * 远程网络存储组
     */
    STOR_POINT_NAS_SMB(0x00001008, "远程网络存储组"),
    /**
     * 远程网络存储组
     */
    STOR_POINT_NAS_ISCSI(0x00001009, "远程网络存储组"),
    /**
     * 远程网络存储组
     */
    STOR_POINT_NAS_CLOUD(0x0000100A, "远程网络存储组");
    private int type;
    private String description;

    private EM_EVENT_TYPE(int type, String description) {
        this.type = type;
        this.description = description;
    }

    public static EM_EVENT_TYPE getEventType(int type) {
        for (EM_EVENT_TYPE event : EM_EVENT_TYPE.values()) {
            if (type == event.getType()) {
                return event;
            }
        }
        return null;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
