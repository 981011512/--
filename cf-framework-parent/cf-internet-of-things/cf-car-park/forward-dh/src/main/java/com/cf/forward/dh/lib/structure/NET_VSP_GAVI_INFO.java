package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib.SdkStructure;
import com.sun.jna.Pointer;
/**
 * @author 119178
 * @description 注册平台信息
 * @date 2021/4/19
 */
public class NET_VSP_GAVI_INFO extends SdkStructure{
	/**
	 * 注册平台IP地址或网络名。IP为空时，不做接入
	 */
	public byte[]                		szAddress = new byte[128];  
	/**
	 * 设备登陆帐号
	 */
	public byte[]                 		szUserId = new byte[64];       	
	/**
	 * 登陆密码
	 */
    public byte[]                 		szPassword = new byte[64];     
    /**
     * 注册平台端口号
     */
    public int                			nPort;              
    /**
     * 接入使能
     */
    public int							bEnable;			
    /**
     * 会话保活周期，范围[10,90],单位秒
     */
    public int							nKeepAliveTime;	
    /**
     * 最大超时次数，范围[2,5]
     */
    public int							nMaxTimeoutTimes;	
    /**
     * 注册失败后重新注册随机时间上限，范围[30,300],单位秒	
     */
    public int							nRegisterInterval;			
    /**
     * 注册设备ID	
     */
	public byte[]						szDeviceID = new byte[24];	
	/**
	 * {@link NET_VSP_GAVI_CHANNEL_INFO}
	 * 通道信息，用户分配内存
	 */
	public Pointer              		pstuChannelInfo; 	
	/**
	 * pstuChannelInfo 个数，和通道数保持一致
	 */
	public int							nChannelCount;		
	/**
	 * 返回的 pstuChannelInfo 个数
	 */
	public int							nChannelCountRet;		
	/**
	 * {@link EM_VSP_GAVI_PLATFORM_CODE}
	 * 当前平台
	 */
	public int		                    emPlatform;	
	/**
	 * 是否在线，不可修改
	 */
	public int							bIsOnLine;
	/**
	 * {@link NET_HKIMAGESERVER_INFO}
	 * 海康视图云存储服务器鉴权密钥信息，emPlatform 为 EM_VSP_GAVI_PLATFORM_CODE_HKTDA_CLOUDSTORAGE时有效
	 */
	public Pointer			pHKImageServerInfo;	
	/**
	 * 保留字节 
	 */
	public byte[]                			byReserved = new byte[68];    			
}
