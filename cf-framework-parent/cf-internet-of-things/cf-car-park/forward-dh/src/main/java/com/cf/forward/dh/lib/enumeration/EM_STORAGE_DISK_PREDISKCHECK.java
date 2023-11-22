package com.cf.forward.dh.lib.enumeration;

public class EM_STORAGE_DISK_PREDISKCHECK {
	public static final int 		EM_STORAGE_DISK_PREDISKCHECK_UNKNOWN 			= 0;    // UnKnown状态
	public static final int 	    EM_STORAGE_DISK_PREDISKCHECK_GOOD     			= 1;    // 硬盘读速度到120以上, 运行良好
	public static final int 	    EM_STORAGE_DISK_PREDISKCHECK_WARN         		= 2;    // cmd信息里有少量错误记录,smart信息有错误记录
	public static final int 	    EM_STORAGE_DISK_PREDISKCHECK_ERROR    			= 3;    // cmd信息有错误记录,smart信息由错误记录.坏扇区有坏扇区记录
	public static final int 	    EM_STORAGE_DISK_PREDISKCHECK_WILLFAIL           = 4;     // 硬盘速度比较低64M以下.cmd信息有错误记录,smart信息由错误记录.坏扇区有坏扇区记录
	public static final int 	    EM_STORAGE_DISK_PREDISKCHECK_FAIL    			= 5;    // 硬盘返回错误
	public static final int 	    EM_STORAGE_DISK_PREDISKCHECK_NONE    			= 6;    // 未知状态
	public static final int 		EM_STORAGE_DISK_PREDISKCHECK_BECHECK			= 7;    // 正在查询中状态
	public static final int 		EM_STORAGE_DISK_PREDISKCHECK_CHECKFAIL   		= 8;	// 查询失败状态                          
}
