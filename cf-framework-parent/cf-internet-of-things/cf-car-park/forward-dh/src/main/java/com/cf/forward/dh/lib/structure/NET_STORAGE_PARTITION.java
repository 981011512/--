package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

public class NET_STORAGE_PARTITION extends NetSDKLib.SdkStructure {
	public NET_STORAGE_PARTITION() {
		this.dwSize =  this.size();
	}
	
	public int               dwSize;
	public byte[]            szName = new byte[128];                // 名称
	public long               nTotalSpace;                                // 总空间, byte
	public long               nFreeSpace;                                 // 剩余空间, byte
    public byte[]                szMountOn = new byte[64];            // 挂载点
    public byte[]                szFileSystem = new byte[16];   // 文件系统
    public int                 nStatus;                                    // 分区状态, 0-LV不可用, 1-LV可用
}
