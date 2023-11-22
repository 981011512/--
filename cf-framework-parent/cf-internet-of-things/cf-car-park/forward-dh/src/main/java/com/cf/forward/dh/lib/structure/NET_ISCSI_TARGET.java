package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

public class NET_ISCSI_TARGET extends NetSDKLib.SdkStructure {
	
	public NET_ISCSI_TARGET() {
		this.dwSize = this.size();
		
		//System.out.println("NET_ISCSI_TARGET " + this.size());
	}

    public int                dwSize;
    public byte[]             szName = new byte[128];              // 名称
    public byte[]             szAddress = new byte[64];     // 服务器地址
    public byte[]             szUser =new byte[128];            // 用户名
    public int                nPort;                                      // 端口
    public int                nStatus;                                    // 状态, 0-未知, 1-已连接, 2-未连接, 3-连接失败, 4-认证失败, 5-连接超时, 6-不存在    
}
