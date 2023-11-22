package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 251823
 * @version 1.0
 * @description 相机的信息
 * @date 2020/11/06
 */
public class NET_CAMERA_CFG_INFO extends NetSDKLib.SdkStructure{
	
	//IP地址
    public byte[] szIP=new byte[32];	  
    
	//端口
	public int nPort;
	
	// 登陆用户名
	public byte[] szLoginName=new byte[32];		   
	
	// 登陆密码，设置的时候不填表示不修改密码
	public byte[] szLoginPwd=new byte[32];	
	
	// 保留字节
	public byte[] byReserved = new byte[1024];	  
}
