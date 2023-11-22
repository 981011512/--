package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

public class NET_STORAGE_DEVICE extends NetSDKLib.SdkStructure {
	
	public NET_STORAGE_DEVICE() {
		this.dwSize = this.size();
        for (int i = 0; i < stuPartitions.length; i ++) {
            stuPartitions[i] =  new NET_STORAGE_PARTITION();
        }
	}
	
	public int          		dwSize;
    public byte[]       		szName = new byte[128];                    		// 名称
    public long         		nTotalSpace;                                    // 总空间, byte
    public long         		nFreeSpace;                                     // 剩余空间, byte
    public byte                	byMedia;                                        // 介质, 0-DISK, 1-CDROM, 2-FLASH
    public byte                	byBUS;                                          // 总线, 0-ATA, 1-SATA, 2-USB, 3-SDIO, 4-SCSI
    public byte                	byVolume;                                       // 卷类型, 0-物理卷, 1-Raid卷, 2-VG虚拟卷, 3-ISCSI, 4-独立物理卷, 5-全局热备卷, 6-NAS卷(包括FTP, SAMBA, NFS)
    public byte                	byState;                                        // 物理硬盘状态, 取值为 NET_STORAGE_DEV_OFFLINE 和 NET_STORAGE_DEV_RUNNING 等
    public int                 	nPhysicNo;                                      	// 同类设备存储接口的物理编号
    public int                 	nLogicNo;                                       	// 同类设备存储接口的逻辑编号
    public byte[]               szParent = new byte[128];                  	// 上级存储组名称
    public byte[]               szModule = new byte[128];                  	// 设备模块
    public byte[]               szSerial = new byte[48];                      	// 设备序列号
    public byte[]               szFirmware = new byte[64];                     // 固件版本
    public int                 	nPartitionNum;                                  // 分区数
    public NET_STORAGE_PARTITION[] stuPartitions = (NET_STORAGE_PARTITION[])new NET_STORAGE_PARTITION().toArray(32);   // 分区信息
    public NET_STORAGE_RAID stuRaid;                                        // RAID信息, 只对RAID有效(byVolume == 1)
    public NET_ISCSI_TARGET stuISCSI;                                       // ISCSI信息, 只对ISCSI盘有效(byVolume == 3)
    public int                	abTank;                                         // 扩展柜使能
    public NET_STORAGE_TANK stuTank;                                        // 硬盘所在扩展柜信息, abTank为TRUE时有效

    /**
     * 硬盘电源状态
     * {@link EM_STORAGE_DISK_POWERMODE}
     */
    public int           		emPowerMode;                    // 硬盘电源状态
    
    /**
     * 硬盘预检状态(EVS定制字段，配合磁盘预检功能使用)
     * {@link EM_STORAGE_DISK_PREDISKCHECK}
     */
    public int        emPreDiskCheck;                 // 硬盘预检状态(EVS定制字段，配合磁盘预检功能使用)
}
