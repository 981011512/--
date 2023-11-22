package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 日志信息,对应接口CLIENT_QueryLog接口
 * @author 47081
 */
public class DH_LOG_ITEM extends NetSDKLib.SdkStructure {

    /**
     * 日期
     */
    public DHDEVTIME           time;
    /**
     * 日志类型，对应结构体 DH_LOG_TYPE
     */
    public short               type;
    /**
     * 保留
     */
    public byte                reserved;
    /**
     * 数据
     */
    public byte                data;
    /**
     * 内容
     */
    public byte[]              context=new byte[8];

}
