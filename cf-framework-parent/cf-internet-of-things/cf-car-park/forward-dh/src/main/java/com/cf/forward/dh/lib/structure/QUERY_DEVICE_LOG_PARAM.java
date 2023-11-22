package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 查询条件
 * @author 47081
 */
public class QUERY_DEVICE_LOG_PARAM extends NetSDKLib.SdkStructure {
    /**
     * 查询日志类型,类型请参考DH_LOG_QUERY_TYPE
     */
    public int   emLogType;
    /**
     * 查询日志的开始时间
     */
    public NET_TIME            stuStartTime;
    /**
     * 查询日志的结束时间
     */
    public NET_TIME             stuEndTime;
    /**
     * 在时间段中从第几条日志开始查询,开始第一次查询可设为0
     */
    public int                  nStartNum;
    /**
     * 一次查询中到第几条日志结束,日志返回条数的最大值为1024
     */
    public int                  nEndNum;
    /**
     * 日志数据结构体类型,
     * 0:表示DH_DEVICE_LOG_ITEM；
     * 1:表示DH_DEVICE_LOG_ITEM_EX
     */
    public byte                 nLogStuType;
    /**
     * 保留 对齐
     */
    public byte[]               reserved=new byte[3];
    /**
     * 通道号,
     * 0:兼容之前表示所有通道号,
     * 所以通道号从1开始;
     * 1:第一个通道
     */
    public int                  nChannelID;
    public byte[]               bReserved=new byte[40];

}
