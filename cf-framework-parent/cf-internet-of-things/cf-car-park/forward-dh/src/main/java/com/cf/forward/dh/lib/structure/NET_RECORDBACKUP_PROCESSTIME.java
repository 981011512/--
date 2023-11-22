package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib.SdkStructure;

public class NET_RECORDBACKUP_PROCESSTIME  extends SdkStructure{
	public NET_TIME_EX1            stuStartTime;            // 开始时间
	public NET_TIME_EX1            stuEndTime;              // 结束时间
	public byte[]                  bReserved=new byte[64];          // 保留字段
}
