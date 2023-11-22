package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

import static com.cf.forward.dh.lib.NetSDKLib.MAX_PATH;

/**
 * @author ： 47040
 * @since ： Created in 2020/12/28 15:58
 */
public class NET_DOWNLOAD_CONDITION_INFO extends NetSDKLib.SdkStructure {

    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * 条件ID, 由用户自己分配
     */
    public int dwConditionID;
    /**
     * 通道号
     */
    public int nChannel;
    /**
     * 开始时间
     */
    public NET_TIME stuStartTime;
    /**
     * 结束时间
     */
    public NET_TIME stuEndTime;
    /**
     * {link EM_DOWNLOAD_TIME_TYPE} 时间类型
     */
    public int emTimeType;
    /**
     * {link EM_DOWNLOAD_DATA_TYPE} 数据类型
     */
    public int emDataType;
    /**
     * 文件保存路径
     */
    public byte[] szSavedFileName = new byte[MAX_PATH];

    public NET_DOWNLOAD_CONDITION_INFO() {
        dwSize = this.size();
    }

}
