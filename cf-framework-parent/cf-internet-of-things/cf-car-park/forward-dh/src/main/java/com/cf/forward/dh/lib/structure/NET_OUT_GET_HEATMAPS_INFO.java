package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.sun.jna.Pointer;

/**
 * @author 251589
 * @version 1.0
 * @description {@link NetSDKLib#CLIENT_GetHeatMapsDirectly}的输出参数
 * @date 2020/11/10
 */
public class NET_OUT_GET_HEATMAPS_INFO extends NetSDKLib.SdkStructure{

    public int dwSize;

    /**
     *  元数据
     */
    public NetSDKLib.NET_RADIOMETRY_METADATA stMetaData;

    /**
     *  热图数据缓存区 pbDataBuf 的大小, 由用户指定
     */
    public int dwMaxDataBufLen;
    /**
     *  热图数据缓冲区(压缩过的数据,里面是每个像素点的温度数据,可以使用元数据信息解压),需要用户分配空间
     */
    public Pointer pbDataBuf;
    /**
     * 缓存区中返回的实际文件数据大小
     */
    public int dwRetDataBufLen;
    /**
     *  字节对齐
     */
    public byte[] byReserved = new byte[4];


    public NET_OUT_GET_HEATMAPS_INFO() {
        this.dwSize = this.size();
    }
}
