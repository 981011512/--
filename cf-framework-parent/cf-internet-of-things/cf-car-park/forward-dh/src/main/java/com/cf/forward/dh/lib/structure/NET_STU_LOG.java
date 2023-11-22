package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 日志结构体
 * @author 47081
 */
public class NET_STU_LOG extends NetSDKLib.SdkStructure {
    /**
     * 日志备注信息
     */
    public byte[]            szLogContext=new byte[64];
    /**
     * 日志旧的结构体的对齐后结构体
     */
    public NET_STU_OLD_LOG   stuOldLog;
}
