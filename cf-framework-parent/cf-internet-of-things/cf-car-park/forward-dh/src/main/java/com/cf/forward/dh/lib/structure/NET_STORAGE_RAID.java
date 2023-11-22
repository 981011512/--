package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

public class NET_STORAGE_RAID extends NetSDKLib.SdkStructure {
	
	public NET_STORAGE_RAID() {
		this.dwSize = this.size();
		for (int i = 0; i < stuMemberInfos.length; i ++) {
			stuMemberInfos[i] =  new NET_RAID_MEMBER_INFO();
		}
	}
	
    public int                 dwSize;
    public int                 nLevel;                                     // 等级    
    public int                 nState;                                     // RAID状态组合, 如 DH_RAID_STATE_ACTIVE | DH_RAID_STATE_DEGRADED
    public int                 nMemberNum;                                 // 成员数量
    public byte[]              szMembers=new byte[32*128];    // RAID成员	
    public float               fRecoverPercent;                            // 同步百分比, 0~100, RAID状态中有"Recovering"或"Resyncing"时有效
    public float               fRecoverMBps;                               // 同步速度, 单位MBps, RAID状态中有"Recovering"或"Resyncing"时有效
    public float               fRecoverTimeRemain;                         // 同步剩余时间, 单位分钟, RAID状态中有"Recovering"或"Resyncing"时有效
    //public NET_RAID_MEMBER_INFO[] stuMemberInfos = (NET_RAID_MEMBER_INFO[])new NET_RAID_MEMBER_INFO().toArray(32);    // RAID成员信息
    
    public NET_RAID_MEMBER_INFO[] stuMemberInfos = new NET_RAID_MEMBER_INFO[32];    // RAID成员信息
	public int                 nRaidDevices;                               // RAID设备个数
	public int                 nTotalDevices;                              // RAID设备总数
	public int                 nActiveDevices;                             // 活动设备个数
	public int                 nWorkingDevices;                            // 工作设备个数
	public int                 nFailedDevices;                             // 失败设备个数
	public int                 nSpareDevices;                              // 热备设备个数
	
	public byte[]              szAliasName = new byte[24];           // RAID别名,UTF-8编码
}
