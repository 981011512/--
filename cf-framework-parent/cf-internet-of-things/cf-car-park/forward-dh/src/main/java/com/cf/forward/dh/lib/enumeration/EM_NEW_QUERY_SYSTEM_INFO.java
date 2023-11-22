package com.cf.forward.dh.lib.enumeration;/**
 * @author 47081
 * @descriptio
 * @date 2020/11/9
 * @version 1.0
 */

import com.cf.forward.dh.lib.NetSDKLib;
import com.sun.jna.ptr.IntByReference;

/**
 * @author 47081
 * @version 1.0
 * @description 能力集命令枚举, 对应接口
 * {@link com.cf.forward.dh.lib.NetSDKLib#CLIENT_QueryNewSystemInfo(NetSDKLib.LLong, String, int, byte[], int, IntByReference, int)}
 * @date 2020/11/9
 */
public enum EM_NEW_QUERY_SYSTEM_INFO {
    /**
     * 视频分析能力集(对应 CFG_CAP_ANALYSE_INFO, pExtendInfo 对应 CFG_CAP_ANALYSE_REQ_EXTEND_INFO)
     */
    CFG_CAP_CMD_VIDEOANALYSE("devVideoAnalyse.getCaps"),
    /**
     * 视频分析能力集(对应CFG_CAP_ANALYSE_INFO_EX)
     */
    CFG_CAP_CMD_VIDEOANALYSE_EX("devVideoAnalyse.getCapsEx"),
    /**
     * 获取后端设备的的在线状态(对应CFG_REMOTE_DEVICE_STATUS)
     */
    CFG_NETAPP_REMOTEDEVICE("netApp.getRemoteDeviceStatus"),
    /**
     * 接入设备信息(对应 CFG_PRODUCT_DEFINITION_INFO)
     */
    CFG_CAP_CMD_PRODUCTDEFINITION("magicBox.getProductDefinition"),
    /**
     * 设备智能分析能力(对应CFG_CAP_DEVICE_ANALYSE_INFO)兼容老设备
     */
    CFG_DEVICE_CAP_CMD_VIDEOANALYSE("intelli.getVideoAnalyseDeviceChannels"),
    /**
     * 设备智能分析能力(对应CFG_CAP_DEVICE_ANALYSE_INFO)
     */
    CFG_DEVICE_CAP_NEW_CMD_VIDEOANALYSE("devVideoAnalyse.factory.getCollect"),
    /**
     * 获得CPU个数
     */
    CFG_CAP_CMD_CPU_COUNT("magicBox.getCPUCount"),
    /**
     * 获取CPU占用率
     */
    CFG_CAP_CMD_CPU_USAGE("magicBox.getCPUUsage"),
    /**
     * 获得内存容量
     */
    CFG_CAP_CMD_MEMORY_INFO("magicBox.getMemoryInfo"),
    /**
     * 获取设备类型(对应CFG_DEVICE_CLASS_INFO)
     */
    CFG_CAP_CMD_DEVICE_CLASS("magicBox.getDeviceClass"),
    /**
     * 获取设备状态信息 (对应CFG_CAP_TRAFFIC_DEVICE_STATUS)
     */
    CFG_CAP_CMD_DEVICE_STATE("trafficSnap.getDeviceStatus"),
    /**
     * 视频输入能力集(对应CFG_CAP_VIDEOINPUT_INFO)
     */
    CFG_CAP_CMD_VIDEOINPUT("devVideoInput.getCaps"),
    /**
     * 得到所有活动的用户信息(对应 CFG_ACTIVEALLUSER_INFO)
     */
    CFG_USERMANAGER_ACTIVEUSER("userManager.getActiveUserInfoAll"),
    /**
     * 获取视频统计摘要信息(对应CFG_VIDEOSATA_SUMMARY_INFO)
     */
    CFG_CAP_VIDEOSTAT_SUMMARY("videoStatServer.getSummary"),
    /**
     * 获取视频诊断服务能力(CFG_VIDEODIAGNOSIS_CAPS_INFO)
     */
    CFG_CAP_CMD_VIDEODIAGNOSIS_SERVER("videoDiagnosisServer.getCaps"),
    /**
     * 获取视频诊断通道数目(CFG_VIDEODIAGNOSIS_GETCOLLECT_INFO)
     */
    CFG_CMD_VIDEODIAGNOSIS_GETCOLLECT("videoDiagnosisServer.factory.getCollect"),
    /**
     * 获取视频诊断进行状态(CFG_VIDEODIAGNOSIS_STATE_INFO)
     */
    CFG_CMD_VIDEODIAGNOSIS_GETSTATE("videoDiagnosisServer.getState"),
    /**
     * 获取服务器上支持的服务列表(CFG_DEV_SERVICE_LIST)
     */
    CFG_CAP_CMD_SERVICE_LIST("system.listService"),
    /**
     * 获取服务器报警联动能力集(CFG_CAP_EVENTHANDLER_INFO)
     */
    CFG_CAP_CMD_EVENTHANDLER("capsManager.get&EventManagerEventHandler"),
    /**
     * 获取报警能力集(CFG_CAP_ALARM_INFO)
     */
    CFG_CAP_ALARM("alarm.getAlarmCaps"),
    /**
     * 获取音频分析能力集(CFG_CAP_AUDIO_ANALYSE_INFO)
     */
    CFG_CAP_CMD_AUDIO_ANALYSE("devAudioAnalyse.getCaps"),
    /**
     * 获取主从式跟踪器通道数目(对应结构体CFG_MASTERSLAVETRACKER_INFO)
     */
    CFG_CMD_MASTERSLAVE_GETCOLLECT("masterSlaveTracker.factory.getCollect"),
    /**
     * 获取主从式设备能力集(CFG_CAP_MASTERSLAVE_INFO)
     */
    CFG_CAP_CMD_MASTERSLAVE("capsManager.get&MasterSlaveTracker"),
    /**
     * 获取镜头聚焦状态信息 (对应CFG_CAP_FOCUS_STATUS)
     */
    CFG_CAP_CMD_FOCUS_STATE("devVideoInput.getFocusStatus"),
    /**
     * 获取网络应用能力集(对应CFG_CAP_NETAPP)
     */
    CFG_CAP_CMD_NETAPP("netApp.getCaps"),
    /**
     * 获取云台支持信息(CFG_CAP_PTZ_ENABLEINFO )
     */
    CFG_CAP_CMD_PTZ_ENABLE("ptz.factory.instance"),
    /**
     * 获取录像能力集(CFG_CAP_RECORD_INFO)
     */
    CFG_CAP_CMD_RECORD("recordManager.getCaps"),
    /**
     * 获取刻录管理能力集( CFG_CAP_BURN_MANAGER)
     */
    CFG_CAP_CMD_BURN_MANAGER("BurnManager.getCaps"),
    /**
     * 获取云台能力集
     * 对应结构体{@link com.cf.forward.dh.lib.structure.CFG_PTZ_PROTOCOL_CAPS_INFO}
     */
    CFG_CAP_CMD_PTZ("ptz.getCurrentProtocolCaps"),
    /**
     * 获取编码能力集(CFG_ENCODECAP)
     */
    CFG_CMD_ENCODE_GETCAPS("encode.getCaps"),
    /**
     * 视频输入能力集扩展(对应CFG_CAP_VIDEOINPUT_INFO_EX)
     */
    CFG_CAP_CMD_VIDEOINPUT_EX("devVideoInput.getCapsEx"),
    /**
     * 获取设备智能分析模式(对应 CFG_ANALYSE_MODE)
     */
    CFG_CAP_CMD_ANALYSE_MODE("intelli.getCaps.AnalyseMode"),
    /**
     * 获取设备报警联动能力,老协议已废除,新开发请使用该字段(CFG_CAP_EVENTMANAGER_INFO)
     */
    CFG_CAP_CMD_EVENTMANAGER("eventManager.getCaps"),
    /**
     * 获取文件能力(CFG_CAP_FILEMANAGER)
     */
    CFG_CAP_CMD_FILEMANAGER("FileManager.getCaps"),
    /**
     * 获取日志服务能力(CFG_CAP_LOG)
     */
    CFG_CAP_CMD_LOG("log.getCaps"),
    /**
     * 扬声器播放能力(CFG_CAP_SPEAK)
     */
    CFG_CAP_CMD_SPEAK("speak.getCaps"),
    /**
     * 门禁能力(CFG_CAP_ACCESSCONTROL)
     */
    CFG_CAP_CMD_ACCESSCONTROLMANAGER("accessControlManager.getCaps"),
    /**
     * 获取扩展报警能力集, (对应结构体 CFG_CAP_EXALARM_INFO)
     */
    CFG_CAP_CMD_EXALARM("alarm.getExAlarmCaps"),
    /**
     * 获取扩展报警盒能力集, (对应结构体 CFG_CAP_EXALARMBOX_INFO)
     */
    CFG_CAP_CMD_EXALARMBOX("alarm.getExAlarmBoxCaps"),
    /**
     * 获取查询记录能力集, (对应结构体 CFG_CAP_RECORDFINDER_INFO)
     */
    CFG_CAP_CMD_RECORDFINDER("RecordFinder.getCaps"),
    /**
     * 模拟量报警输入通道能力(对应结构体 CFG_CAP_ANALOGALARM)
     */
    CFG_CAP_CMD_ANALOGALARM("AnalogAlarm.getCaps"),
    /**
     * 获取LowRateWPAN能力(对应的结构体 CFG_CAP_LOWRATEWPAN)
     */
    CFG_CAP_CMD_LOWRATEWPAN("LowRateWPAN.getCaps"),
    /**
     * 获取编码自适应编码能力(对应的结构体 CFG_CAP_ADAPT_ENCODE_INFO)
     */
    CFG_CAP_CMD_ADAPTENCODE("encode.getNAACaps"),
    /**
     * 获取该云台实际能够使用的协议，按介质区分 (对应结构体 CFG_CAP_PTZ_PROTOCOL)
     */
    CFG_CAP_CMD_PTZPROTOCAL("ptz.getProtocol"),
    /**
     * 查询是否支持视频裁剪能力 (对应结构体 CFG_CAP_MEDIA_CROP)
     */
    CFG_CAP_CMD_MEDIACROP("encode.getCropCaps"),
    /**
     * 获取OSD叠加能力(对应结构体CFG_CAP_OSDMANAGER_INFO)
     */
    CFG_CAP_CMD_OSDMANAGER("OSDManager.getCaps"),
    /**
     * 获取自定义标题能力集(对应结构体CFG_CAP_CUSTOM_OSD_INFO)
     */
    CFG_CAP_CMD_CUSTOM("OSDManager.getCustomCaps");

    private EM_NEW_QUERY_SYSTEM_INFO(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
