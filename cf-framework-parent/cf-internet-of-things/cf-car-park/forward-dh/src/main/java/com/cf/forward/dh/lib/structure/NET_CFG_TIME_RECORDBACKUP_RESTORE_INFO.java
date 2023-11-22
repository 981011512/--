package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

public class NET_CFG_TIME_RECORDBACKUP_RESTORE_INFO  extends NetSDKLib.SdkStructure{
	public int                               dwSize;                  // 结构体大小
	public int                               bEnable;            // 使能开关，未使能，全天可备份
	public int                               nProcessTimeCount;  // 备份任务处理时间有效个数
	public NET_RECORDBACKUP_PROCESSTIME[]    stuProcessTime=(NET_RECORDBACKUP_PROCESSTIME[])new NET_RECORDBACKUP_PROCESSTIME().toArray(4); // 备份任务处理时间
	public int                               nTaskCount;         // 任务有效个数
	public NET_TIME_RECORDBACKUP_TASK[]      stuTask =(NET_TIME_RECORDBACKUP_TASK[])new NET_TIME_RECORDBACKUP_TASK().toArray(512);       // 任务信息, 最大支持个;

	public NET_CFG_TIME_RECORDBACKUP_RESTORE_INFO()
    {
        this.dwSize = this.size();
    }
}
