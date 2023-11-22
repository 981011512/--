package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib.SdkStructure;

public class NET_TIME_RECORDBACKUP_TASK  extends SdkStructure{
	public int                      nChannelCount;                   // 通道有效个数
	public int[]                    nChannels=new int[512];          // 通道号
	public int[]                    nRemoteChannels=new int[512];    // 远程通道号
	    
	public byte[]                   szDeviceIP=new byte[64];         // IP地址
	public int                      nPort;                           // 端口
	public byte[]                   szUserName=new byte[64];         // 用户名
	public byte[]                   szPassword=new byte[64];         // 密码
	public NET_TIME_EX1             stuStartTime;                    // 开始时间
	public NET_TIME_EX1             stuEndTime;                      // 结束时间
	public byte[]                   szStorageGroupName=new byte[32]; // 保存的盘组名称 
	public byte[]                   byReserved=new byte[512];        // 保留字段
}
