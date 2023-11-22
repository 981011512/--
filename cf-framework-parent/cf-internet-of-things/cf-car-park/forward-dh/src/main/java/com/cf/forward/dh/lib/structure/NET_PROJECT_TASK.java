package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib.NET_TSECT;
import com.cf.forward.dh.lib.NetSDKLib.SdkStructure;

public class NET_PROJECT_TASK  extends SdkStructure{
	public int							bEnable;									// 任务是否使能
	public byte[]							szTaskName = new byte[260];						// 任务名称Ansi编码
	public CFG_TIME_SECTION[]            Section=(CFG_TIME_SECTION[])new CFG_TIME_SECTION().toArray(7); // 任务时间段
	public int                            bIsCycle;                                   // 任务是否循环,TRUE表示循环,FALSE表示不循环
	public byte[]      						byReserved = new byte[512];      						// 保留字节
	
	public static class CFG_TIME_SECTION extends SdkStructure
    {
        public NET_TSECT[]	 			stuTimeSection = (NET_TSECT[])new NET_TSECT().toArray(6);	     // 事件响应时间段, 每天最多6个时间段
    }
}
