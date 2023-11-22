package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.enumeration.EM_SERVER_OPTION;
import com.sun.jna.Pointer;

import static com.cf.forward.dh.lib.constant.SDKStructureFieldLenth.*;

/**
 * SIP服务器信息
 *
 * @author 47040
 * @version 1.0.0
 * @since Created in 2021/3/9 8:41
 */
public class NET_SIP_SERVER_INFO extends NetSDKLib.SdkStructure {

    /**
     * 单个平台接入启动选项 枚举值{@link EM_SERVER_OPTION}
     */
    public int emServerOption;
    /**
     * SIP服务器编号
     */
    public byte[] szSipSvrId = new byte[MAX_SIP_SVR_ID_LEN];
    /**
     * SIP域
     */
    public byte[] szDomain = new byte[MAX_SIP_DOMAIN_LEN];
    /**
     * SIP服务器 IP
     */
    public byte[] szSipSvrIp = new byte[MAX_SIP_SVR_IP_LEN];
    /**
     * 设备编号
     */
    public byte[] szDeviceId = new byte[MAX_SIP_SERVER_DEVICE_ID_LEN];
    /**
     * 注册密码
     */
    public byte[] szPassword = new byte[MAX_REG_PASSWORD_LEN];
    /**
     * 本地SIP服务端口
     */
    public short nLocalSipPort;
    /**
     * SIP服务器端口
     */
    public short nSipSvrPort;
    /**
     * 注册有效期,单位:秒
     */
    public int nSipRegExpires;
    /**
     * 注册失败后重新注册间隔,单位:秒
     */
    public int nRegInterval;
    /**
     * 心跳周期,单位:秒
     */
    public int nKeepAliveCircle;
    /**
     * 最大心跳超时次数
     */
    public int nMaxTimeoutTimes;
    /**
     * 行政区划代码
     */
    public byte[] szCivilCode = new byte[MAX_CIVIL_CODE_LEN];
    /**
     * 接入模块识别码
     */
    public byte[] szIntervideoID = new byte[MAX_INTERVIDEO_ID_LEN];
    /**
     * 通道相关信息,由用户申请内存,大小为 sizeof(NET_CHANNEL_INFO)*nChannelInfoNum
     * JNA指针类型 -> {@link NET_CHANNEL_INFO}
     */
    public Pointer pstuChannelInfo;
    /**
     * 通道信息个数,可以根据登陆时获取的通道数为准
     */
    public int nChannelInfoNum;
    /**
     * 实际返回的通道号信息个数
     */
    public int nRetChannelInfoNum;
    /**
     * 报警通道相关信息,由用户申请内存,大小为 sizeof(NET_ALARM_INFO)*nAlarmInfoNum
     * JNA指针类型 -> {@link NET_ALARM_INFO}
     */
    public Pointer pstuAlarmInfo;
    /**
     * 报警信息个数,最大值为 640
     */
    public int nAlarmInfoNum;
    /**
     * 实际返回的报警通道信息个数
     */
    public int nRetAlarmInfoNum;
    /**
     * 音频输出通道相关信息,由用户申请内存,大小为 sizeof(NET_AUDIO_OUTPUT_CHANNEL_INFO)*nAudioOutputChnInfoNum
     * JNA指针类型 -> {@link NET_AUDIO_OUTPUT_CHANNEL_INFO}
     */
    public Pointer pstuAudioOutputChnInfo;
    /**
     * 音频输出通道相关信息个数,最大值为181
     */
    public int nAudioOutputChnInfoNum;
    /**
     * 实际返回的音频输出通道信息个数
     */
    public int nRetAudioOutputChnInfoNum;
    /**
     * 预留字节
     */
    public byte[] byReserved = new byte[1024];

}
