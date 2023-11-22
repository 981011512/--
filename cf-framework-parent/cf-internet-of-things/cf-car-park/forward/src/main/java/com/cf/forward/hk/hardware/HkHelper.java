package com.cf.forward.hk.hardware;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.net.NetUtil;
import com.cf.carpark.device.camera.hk.HkRequestParam;
import com.cf.carpark.domain.CfCarParkPackage;
import com.cf.forward.hk.config.DevInfoCallBack;
import com.cf.forward.hk.config.HkForwardProperties;
import com.cf.forward.hk.hardware.handle.DvrMessageHandleImpl;
import com.cf.forward.hk.hardware.hcsdk.HCNetSDK;
import com.cf.forward.hk.task.SpaceNumAsyncTask;
import com.cf.forward.hk.utils.IpUtil;
import com.cf.forward.hk.utils.NumerUtils;
import com.cf.forward.hk.web.domain.CarParkSpaceInfo;
import com.cf.forward.hk.web.domain.CarType;
import com.cf.forward.hk.web.domain.ScanCarInfo;
import com.cf.framework.utils.CarUtil;
import com.cf.framework.utils.DateUtil;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author why
 */
@Slf4j
@Service
public class HkHelper implements HkHelperInterface {

    @Autowired
    private HkForwardProperties properties;

    @Autowired
    private SpaceNumAsyncTask spaceNumAsyncTask;

    @Autowired
    private DvrMessageHandleImpl dvrMessageHandle;

    public static String projectPath = System.getProperty("user.dir");

    /**
     * LED 文字  超时时间
     */
    private static volatile long dynOutTime = 0;

    private static volatile long staticOutTime = 0;

    /**
     * LED 出口 空闲显示文字
     */
    private static final String ledOutFreeText = "一车一杆 损毁赔偿 一路顺风";

    public static HCNetSDK hCNetSDK = HCNetSDK.INSTANCE;
    /**
     * 设备登录信息
     */
    HCNetSDK.NET_DVR_USER_LOGIN_INFO m_strLoginInfo = new HCNetSDK.NET_DVR_USER_LOGIN_INFO();
    /**
     * 设备信息
     */
    HCNetSDK.NET_DVR_DEVICEINFO_V40 m_strDeviceInfo = new HCNetSDK.NET_DVR_DEVICEINFO_V40();
    /**
     * 已登录设备的IP地址
     */
    String m_sDeviceIP;
    /**
     * 设备用户名
     */
    String m_sUsername;
    /**
     * 设备密码
     */
    String m_sPassword;

    /**
     * 用户句柄
     */
    public static int lUserID;
    /**
     * 报警布防句柄
     */
    int lAlarmHandle;
    /**
     * 报警监听句柄
     */
    int lListenHandle;
    /**
     * 报警回调函数实现
     */
    public static FMSGCallBack fMSFCallBack;
    /**
     * 报警回调函数实现
     */
    public static FMSGCallBack_V31 fMSFCallBack_V31;

    /**
     * 扫车牌
     */
    private static final ScanCarInfo scanCarInfo = new ScanCarInfo();

    DevInfoCallBack fVehicleCrtlCB = null;

    /**
     * 初始化
     */
    @PostConstruct
    public void init() {
        //注册之前先注销已注册的用户,预览情况下不可注销
        if (lUserID > -1) {
            //先注销
            hCNetSDK.NET_DVR_Logout(lUserID);
            lUserID = -1;
        }
        Boolean flag = hCNetSDK.NET_DVR_Init();

        if (flag) {
            log.info("======================  初始化成功 ===================");
        } else {
            log.info("======================  初始化失败 ===================");
        }
        //注册
        // 设备ip地址
        m_sDeviceIP = properties.getDeviceIP();
        m_strLoginInfo.sDeviceAddress = new byte[HCNetSDK.NET_DVR_DEV_ADDRESS_MAX_LEN];
        System.arraycopy(m_sDeviceIP.getBytes(), 0, m_strLoginInfo.sDeviceAddress, 0, m_sDeviceIP.length());
        //设备用户名
        m_sUsername = properties.getUsername();
        m_strLoginInfo.sUserName = new byte[HCNetSDK.NET_DVR_LOGIN_USERNAME_MAX_LEN];
        System.arraycopy(m_sUsername.getBytes(), 0, m_strLoginInfo.sUserName, 0, m_sUsername.length());
        //设备密码
        m_sPassword = new String(properties.getPassword());
        m_strLoginInfo.sPassword = new byte[HCNetSDK.NET_DVR_LOGIN_PASSWD_MAX_LEN];
        System.arraycopy(m_sPassword.getBytes(), 0, m_strLoginInfo.sPassword, 0, m_sPassword.length());
        m_strLoginInfo.wPort = Short.parseShort(properties.getPort());
        //是否异步登录：0- 否，1- 是
        m_strLoginInfo.bUseAsynLogin = false;
        m_strLoginInfo.write();
        lUserID = hCNetSDK.NET_DVR_Login_V40(m_strLoginInfo, m_strDeviceInfo);
        if (lUserID == -1) {
            log.info(m_sDeviceIP + "注册失败，错误号:{}", hCNetSDK.NET_DVR_GetLastError());
        } else {
            log.info(m_sDeviceIP + "注册成功");
        }
        setupAlarmChan();
        startAlarmListen();
//        List<CfCarParkPackage> cfCarParkPackageList = new ArrayList<>();
//        CfCarParkPackage cfCarParkPackage = new CfCarParkPackage();
//        cfCarParkPackage.setId("145643145645131");
//        cfCarParkPackage.setStartTime(1634785427000l);
//        cfCarParkPackage.setEndTime(1637463827000l);
//        cfCarParkPackage.setNumberPlate("京A88888");
//        cfCarParkPackageList.add(cfCarParkPackage);
//        addCarPackageList(cfCarParkPackageList, (byte)0);
    }

    /**
     * 开始布防
     */
    private void setupAlarmChan() {
        if (lUserID == -1) {
            log.info(m_sDeviceIP + "请先注册");
            return;
        }
        //尚未布防,需要布防
        if (lAlarmHandle <= -1) {
        }
        if (fMSFCallBack_V31 == null) {
            fMSFCallBack_V31 = new FMSGCallBack_V31();
            Pointer pUser = null;
            // dvr，全称为Digital Video Recorder（硬盘录像机）  ---- 扫车牌
            if (!hCNetSDK.NET_DVR_SetDVRMessageCallBack_V31(fMSFCallBack_V31, pUser)) {
                System.out.println(m_sDeviceIP + "设置回调函数失败!");
            }
        }
        HCNetSDK.NET_DVR_SETUPALARM_PARAM m_strAlarmInfo = new HCNetSDK.NET_DVR_SETUPALARM_PARAM();
        m_strAlarmInfo.dwSize = m_strAlarmInfo.size();
        //智能交通布防优先级：0- 一等级（高），1- 二等级（中），2- 三等级（低）
        m_strAlarmInfo.byLevel = 1;
        //智能交通报警信息上传类型：0- 老报警信息（NET_DVR_PLATE_RESULT），1- 新报警信息(NET_ITS_PLATE_RESULT)
        m_strAlarmInfo.byAlarmInfoType = 1;
        //布防类型(仅针对门禁主机、人证设备)：0-客户端布防(会断网续传)，1-实时布防(只上传实时数据)
        m_strAlarmInfo.byDeployType = 1;
        m_strAlarmInfo.write();
        lAlarmHandle = hCNetSDK.NET_DVR_SetupAlarmChan_V41(lUserID, m_strAlarmInfo);
        if (lAlarmHandle == -1) {
            log.info(m_sDeviceIP + "布防失败，错误号:" + hCNetSDK.NET_DVR_GetLastError());
        } else {
            log.info(m_sDeviceIP + "布防成功");
        }
    }

    /**
     * 启动监听
     */
    private void startAlarmListen() {
        String localIp = "";
        LinkedHashSet<String> localIps = NetUtil.localIpv4s();
        if (ObjectUtils.isEmpty(localIps)) {
            localIp = properties.getLocalIP();
        } else {
            localIp = localIps.iterator().next();
        }
        //设备ip地址
        String m_sListenIP = localIp;
        int iListenPort = IpUtil.getPort(10000, 20000);
        Pointer pUser = null;
        if (fMSFCallBack == null) {
            fMSFCallBack = new FMSGCallBack();
        }
        lListenHandle = hCNetSDK.NET_DVR_StartListen_V30(m_sListenIP, (short) iListenPort, fMSFCallBack, pUser);
        if (lListenHandle < 0) {
            log.info(m_sDeviceIP + "启动监听失败，错误号:{}", hCNetSDK.NET_DVR_GetLastError());
        } else {
            log.info(m_sDeviceIP + "启动监听成功");
        }
    }

    class FMSGCallBack_V31 implements HCNetSDK.FMSGCallBack_V31 {
        /**
         * 报警信息回调函数
         */
        @Override
        public boolean invoke(int lCommand, HCNetSDK.NET_DVR_ALARMER pAlarmer, Pointer pAlarmInfo, int dwBufLen, Pointer pUser) {
            log.info("=====================报警信息回调函数 FMSGCallBack_V31=====================");
            AlarmDataHandle(lCommand, pAlarmer, pAlarmInfo, dwBufLen, pUser);
            return true;
        }
    }

    class FMSGCallBack implements HCNetSDK.FMSGCallBack {
        /**
         * 报警信息回调函数
         */
        @Override
        public void invoke(int lCommand, HCNetSDK.NET_DVR_ALARMER pAlarmer, Pointer pAlarmInfo, int dwBufLen, Pointer pUser) {
            log.info("=====================报警信息回调函数  startAlarmListen 监听===================================");
            AlarmDataHandle(lCommand, pAlarmer, pAlarmInfo, dwBufLen, pUser);
        }
    }

    /**
     * 报警信息回调函数
     * 一字要设置空闲LED 字幕
     */
    private void AlarmDataHandle(int lCommand, HCNetSDK.NET_DVR_ALARMER pAlarmer, Pointer pAlarmInfo, int dwBufLen, Pointer pUser) {
//        log.info(" >>>>>>>>>>>>===========  进入回调,开始识别车牌 ==========<<<<<<<<<<<<<");
//        log.info("开始时间：{}", System.currentTimeMillis());
        // === 第一步: 读取数据
        String deviceIp = new String(pAlarmer.sDeviceIP).trim();
        String serialNo = new String(pAlarmer.sSerialNumber).trim();
        HCNetSDK.NET_ITS_PLATE_RESULT strItsPlateResult = new HCNetSDK.NET_ITS_PLATE_RESULT();
        strItsPlateResult.write();
        Pointer pItsPlateInfo = strItsPlateResult.getPointer();
        pItsPlateInfo.write(0, pAlarmInfo.getByteArray(0, strItsPlateResult.size()), 0, strItsPlateResult.size());
        strItsPlateResult.read();
        try {
            // 第二步: 查找车牌
            String srt3 = new String(strItsPlateResult.struPlateInfo.sLicense, "GBK");
            if (StringUtils.isEmpty(srt3) || NumerUtils.isNumeric(srt3)) {
                staticOutTime = 0L;
                return;
            }
            // 原始数据::绿浙AD12345
//            log.info("================原始数据::{}", srt3);
            String carNo = srt3.substring(1).trim();
//            boolean isCarNo = CarUtil.isCarNo(carNo);
            CarParkSpaceInfo carParkSpaceInfo = SpaceNumAsyncTask.carParkSpaceInfo;
            //同一车牌3秒内不能发两次请求
            Date scanTime = scanCarInfo.getScanTime();
            String numberPlate = scanCarInfo.getNumberPlate();
            if (carNo.equals(numberPlate) && null != scanTime && System.currentTimeMillis() - scanTime.getTime() < 3000L) {
                staticOutTime = 0L;
                return;
            } else {
                scanCarInfo.setScanTime(new Date());
                scanCarInfo.setNumberPlate(carNo);
            }
            // 第三步: 处理图片
            String carType = CarType.getCarType(strItsPlateResult.byVehicleType + "".trim());
            String plateColor = srt3.substring(0, 1).trim();
            String carCountry = srt3.substring(1, 2).trim();
            HkRequestParam hkRequestParam = new HkRequestParam();
            hkRequestParam.setCarNo(carNo);
            hkRequestParam.setCarType(carType);
            hkRequestParam.setCarCountry(carCountry);
            hkRequestParam.setCarColor(plateColor);
            hkRequestParam.setCameraIp(deviceIp);
            hkRequestParam.setSerialNo(serialNo);
            String smallImagePath = projectPath + File.separator + "car_small_img" + File.separator + deviceIp.replace(".", "_") + File.separator;
            String bigImagePath = projectPath + File.separator + "car_big_img" + File.separator + deviceIp.replace(".", "_") + File.separator;
            DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
            String carImgName = carNo + "-" + format.format(new Date()) + ".jpg";
            log.info("第三步: 处理图片");

            byte[] smallBytes = null;
            byte[] bigBytes = null;

            for (int i = 0; i < strItsPlateResult.dwPicNum; i++) {
                if (strItsPlateResult.struPicInfo[i].dwDataLen > 0) {
                    if (strItsPlateResult.struPicInfo[i].byType == 0) {
                        //车牌图片
                        smallImagePath = smallImagePath + carImgName;
                        log.info("车辆小图文件路径" + smallImagePath);
                        HCNetSDK.NET_ITS_PICTURE_INFO picture_info = strItsPlateResult.struPicInfo[i];
                        smallBytes = picture_info.pBuffer.getByteArray(0, picture_info.dwDataLen);
//                        FileUtil.writeBytes(bytes, smallImagePath);
                    }
                    if (strItsPlateResult.struPicInfo[i].byType == 1) {
                        //车辆场景图片
                        bigImagePath = bigImagePath + carImgName;
                        log.info("车辆大图文件路径" + bigImagePath);
                        HCNetSDK.NET_ITS_PICTURE_INFO picture_info = strItsPlateResult.struPicInfo[i];
                        bigBytes = picture_info.pBuffer.getByteArray(0, picture_info.dwDataLen);
//                        FileUtil.writeBytes(bytes, bigImagePath);
                    }
                }
            }
            // 第四步: 判断入口出口,
//                log.info("第四步: 判断入口出口");
            dvrMessageHandle.carInAndOut(carParkSpaceInfo.getDirection(), hkRequestParam, deviceIp, serialNo, smallBytes, bigBytes);

        } catch (UnsupportedEncodingException e) {
            log.info("处理出错", e);
            e.printStackTrace();
            staticOutTime = 0L;
            return;
        }
        log.info("结束时间：{}", System.currentTimeMillis());
    }

    // =====================================================
    // =====================================================
    // =================      道闸  START
    // =====================================================
    // =====================================================

    /**
     * 道闸
     *
     * @param isOpen true 开 ,  false 关
     * @return true 成功 ，false 失败
     */
    @Override
    public boolean openAndClose(boolean isOpen) {
        HCNetSDK.NET_DVR_BARRIERGATE_CFG daozha = new HCNetSDK.NET_DVR_BARRIERGATE_CFG();
        daozha.dwSize = daozha.size();
        daozha.dwChannel = 1;
        daozha.byLaneNo = 1;
        daozha.byBarrierGateCtrl = isOpen ? (byte) 1 : (byte) 0;
        daozha.byUnlock = (byte) 1;
        //类似memset
        daozha.write();
        int dwCommand = 3128;
        boolean bCtrl = hCNetSDK.NET_DVR_RemoteControl(lUserID, dwCommand, daozha.getPointer(), daozha.size());
        if (bCtrl) {
            log.info(" =============  成功 =============");
        } else {
            log.info(" =============  失败：{} =============", hCNetSDK.NET_DVR_GetLastError());
        }
        return bCtrl;
    }

    // =====================================================
    // =====================================================
    // =================      道闸  END
    // =====================================================
    // =====================================================


    //=====================================
    //=====================================
    // ==================================== LED屏显示
    // ====================================
    // ====================================

    @Override
    public void controlLED(String content, int showTime) {
        //时间
        dynOutTime = System.currentTimeMillis() + showTime * (1000L);
        controlLED(content, (byte) 2, (byte) 2, showTime);
    }

    private void controlLED(String content, byte mode, byte speed, int showTime) {
        HCNetSDK.NET_DVR_LEDDISPLAY_CFG struLEDDisplayCfg = new HCNetSDK.NET_DVR_LEDDISPLAY_CFG();
        struLEDDisplayCfg.read();
        struLEDDisplayCfg.dwSize = struLEDDisplayCfg.size();
        struLEDDisplayCfg.write();
        HCNetSDK.NET_DVR_STD_CONFIG struConfigParam = new HCNetSDK.NET_DVR_STD_CONFIG();
        struConfigParam.read();
        IntByReference dwChannel = new IntByReference(1);
        struConfigParam.lpCondBuffer = dwChannel.getPointer();
        struConfigParam.dwCondSize = 4;
        struConfigParam.lpInBuffer = null;
        struConfigParam.dwInSize = 0;
        struConfigParam.lpOutBuffer = struLEDDisplayCfg.getPointer();
        struConfigParam.dwOutSize = struLEDDisplayCfg.size();
        struConfigParam.byDataType = 0;
        struConfigParam.write();
        struConfigParam.read();
        struLEDDisplayCfg.read();
        //豫A12345欢迎光临 燃油国五2020年9月11日
        byte[] strLEDContent = new byte[0];
        try {
            strLEDContent = content.getBytes("GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 512; i++) {
            struLEDDisplayCfg.sDisplayInfo[i] = 0;
        }
        for (int i = 0; i < strLEDContent.length; i++) {
            struLEDDisplayCfg.sDisplayInfo[i] = strLEDContent[i];
        }
        //显示方式：0- 左移，1- 右移，2- 立即显示
        struLEDDisplayCfg.byDisplayMode = mode;
        //速度类型：0- 快，1- 中，2- 慢
        struLEDDisplayCfg.bySpeedType = speed;
        //显示时长，取值范围：1~60，单位：秒
        struLEDDisplayCfg.dwShowTime = showTime;
        struLEDDisplayCfg.write();
        struConfigParam.lpInBuffer = struLEDDisplayCfg.getPointer();
        struConfigParam.dwInSize = struLEDDisplayCfg.size();
        struConfigParam.lpOutBuffer = null;
        struConfigParam.dwOutSize = 0;
        struConfigParam.byDataType = 0;
        struConfigParam.write();
        boolean bSet = hCNetSDK.NET_DVR_SetSTDConfig(lUserID
                , HCNetSDK.NET_DVR_SET_LEDDISPLAY_CFG, struConfigParam);
        if (!bSet) {
            int iErr = hCNetSDK.NET_DVR_GetLastError();
            log.error("NET_DVR_SET_VOICEBROADCAST_CFG：LED屏幕显示配置失败，错误码：" + iErr);
        } else {
            log.info("LED屏幕显示配置成功:" + content);
        }
    }

    //=====================================
    //=====================================
    // ==================================== 语音播报
    // ====================================
    // ====================================
    @Override
    public void controlVoice(String content) {
        HCNetSDK.NET_DVR_VOICEBROADCAST_CFG struVoiceCastCfg = new HCNetSDK.NET_DVR_VOICEBROADCAST_CFG();
        struVoiceCastCfg.read();
        struVoiceCastCfg.dwSize = struVoiceCastCfg.size();
        byte[] strVoiceContent = new byte[0];
        try {
            strVoiceContent = content.getBytes("GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 128; i++) {
            struVoiceCastCfg.sInfo[i] = 0;
        }
        for (int i = 0; i < strVoiceContent.length; i++) {
            struVoiceCastCfg.sInfo[i] = strVoiceContent[i];
        }
        //语音播报次数， 1~10次
        struVoiceCastCfg.byBroadcastNum = 1;
        //语音播报间隔时间,1~5s
        struVoiceCastCfg.byIntervalTime = 1;
        struVoiceCastCfg.write();
        com.cf.forward.hk.hardware.hcsdk.HCNetSDK.NET_DVR_STD_CONFIG struConfigParam = new HCNetSDK.NET_DVR_STD_CONFIG();
        struConfigParam.read();
        IntByReference dwChannel1 = new IntByReference(1);
        struConfigParam.lpCondBuffer = dwChannel1.getPointer();
        struConfigParam.dwCondSize = 4;
        struConfigParam.lpInBuffer = struVoiceCastCfg.getPointer();
        struConfigParam.dwInSize = struVoiceCastCfg.size();
        struConfigParam.byDataType = 0;
        struConfigParam.write();
        boolean bSet = hCNetSDK.NET_DVR_SetSTDConfig(lUserID, HCNetSDK.NET_DVR_SET_VOICEBROADCAST_CFG, struConfigParam);
        if (!bSet) {
            int iErr = hCNetSDK.NET_DVR_GetLastError();
            log.error("NET_DVR_SET_VOICEBROADCAST_CFG语音播报设置失败，错误码：" + iErr);
        } else {
            log.info("语音播报设置成功:" + content);
        }
    }

    /**
     * LED 空闲监听
     */
    @Override
    public void ledOutFree() {
        long now = System.currentTimeMillis();
        if (now > (dynOutTime - 1000L)) {
            setStaticFree();
        }
    }

    @Override
    public void addCarPackageList(List<CfCarParkPackage> cfCarParkPackageList, byte byListType) {
        //int NET_DVR_StartRemoteConfig(int lUserID, int dwCommand, Pointer lpInBuffer, int dwInBufferLen, FRemoteConfigCallBack cbStateCallBack, Pointer pUserData);
        fVehicleCrtlCB = new DevInfoCallBack();

        int lhand = hCNetSDK.NET_DVR_StartRemoteConfig(lUserID,hCNetSDK.NET_DVR_VEHICLELIST_CTRL_START,null,0,fVehicleCrtlCB,Pointer.NULL);
        for(CfCarParkPackage cfCarParkPackage :cfCarParkPackageList){
            HCNetSDK.NET_DVR_VEHICLE_CONTROL_LIST_INFO info  =new  HCNetSDK.NET_DVR_VEHICLE_CONTROL_LIST_INFO();
            info.read();
            info.dwSize = info.size();
            info.dwChannel = 1; //通道号，出入口设备默认1
            String sLicense = cfCarParkPackage.getNumberPlate();
            try {
                info.sLicense = sLicense.getBytes("GBK"); //车牌号码
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            info.byListType = byListType; //名单属性（黑白名单）：0- 白名单，1- 黑名单
            /**
             * VCA_STANDARD92_PLATE
             * 0- 标准民用车与军车车牌
             * VCA_STANDARD02_PLATE
             * 1- 02式民用车牌
             * VCA_WJPOLICE_PLATE
             * 2- 武警车车牌
             * VCA_JINGCHE_PLATE
             * 3- 警车车牌
             * STANDARD92_BACK_PLATE
             * 4- 民用车双行尾牌
             * VCA_SHIGUAN_PLATE
             * 5- 使馆车牌
             * VCA_NONGYONG_PLATE
             * 6- 农用车车牌
             * VCA_MOTO_PLATE
             * 7- 摩托车车牌
             * NEW_ENERGY_PLATE
             * 8- 新能源车牌
             */
//            info.byPlateType = 4; //STANDARD92_BACK_PLATE 民用车双行尾牌
//            info.byPlateColor = 1; //VCA_YELLOW_PLATE 黄色车牌
            String cardNo = cfCarParkPackage.getId();   //卡号
            info.sCardNo = cardNo.getBytes();
            //有效开始时间  yyyy-MM-dd HH:mm:ss
            info.struStartTime.wYear = new Short(DateUtil.stampToDate(cfCarParkPackage.getStartTime(), "yyyy")).shortValue();
            info.struStartTime.byMonth = new Byte(DateUtil.stampToDate(cfCarParkPackage.getStartTime(), "MM")).byteValue();
            info.struStartTime.byDay = new Byte(DateUtil.stampToDate(cfCarParkPackage.getStartTime(), "dd")).byteValue();
            info.struStartTime.byHour = new Byte(DateUtil.stampToDate(cfCarParkPackage.getStartTime(), "HH")).byteValue();
            info.struStartTime.byMinute = new Byte(DateUtil.stampToDate(cfCarParkPackage.getStartTime(), "mm")).byteValue();
            info.struStartTime.bySecond = new Byte(DateUtil.stampToDate(cfCarParkPackage.getStartTime(), "ss")).byteValue();
            //有效结束时间
            info.struStopTime.wYear = new Short(DateUtil.stampToDate(cfCarParkPackage.getEndTime(), "yyyy")).shortValue();
            info.struStopTime.byMonth = new Byte(DateUtil.stampToDate(cfCarParkPackage.getEndTime(), "MM")).byteValue();
            info.struStopTime.byDay = new Byte(DateUtil.stampToDate(cfCarParkPackage.getEndTime(), "dd")).byteValue();
            info.struStopTime.byHour = new Byte(DateUtil.stampToDate(cfCarParkPackage.getEndTime(), "HH")).byteValue();
            info.struStopTime.byMinute = new Byte(DateUtil.stampToDate(cfCarParkPackage.getEndTime(), "mm")).byteValue();
            info.struStopTime.bySecond = new Byte(DateUtil.stampToDate(cfCarParkPackage.getEndTime(), "ss")).byteValue();
            info.write();
            hCNetSDK.NET_DVR_SendRemoteConfig(lhand,hCNetSDK.ENUM_SENDDATA,info.getPointer(),info.size());

            System.out.println("ip==="+m_sDeviceIP+"\t车牌\t"+cfCarParkPackage.getNumberPlate()+"\t添加白名单成功");
        }
    }

    /**
     * 设置静态LED
     */
    private void setStaticFree(){
        long now = System.currentTimeMillis();
        int time = 60;
        if (now > (staticOutTime - 1000L)) {
            staticOutTime = now + time * (1000L);
            String direction = SpaceNumAsyncTask.carParkSpaceInfo.getDirection();
            String carparkName = SpaceNumAsyncTask.carParkSpaceInfo.getCarparkName();
            Integer spaceNum = SpaceNumAsyncTask.carParkSpaceInfo.getSpaceNum();
            if (!ObjectUtils.isEmpty(direction) && "in".equals(direction)) {
                // 入场
                String content = "欢迎光临 " + carparkName + " ";
                if (null != spaceNum && spaceNum > 0) {
                    content = content + "剩余车位 " + spaceNum + "位";
                    this.controlLED(content, (byte) 2, (byte) 2, time);
                } else {
                    content = content + "车位已满";
                    controlLED(content, (byte) 2, (byte) 2, time);
                }
            } else {
                // 出场
                controlLED(ledOutFreeText, (byte) 2, (byte) 2, time);
            }
        }
    }
}
