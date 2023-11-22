package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 *
 * @author 47081
 * @version 1.0
 * @description CLIENT_PreUploadRemoteFile 接口输入参数(设置文件长度)
 * @date 2020/6/10
 */
public class NET_IN_PRE_UPLOAD_REMOTE_FILE extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int                  dwSize;
    /**
     * 源文件路径
     */
    public String               pszFileSrc;
    /**
     * 保存在设备端的文件路径
     */
    public String               pszFileDst;

    public NET_IN_PRE_UPLOAD_REMOTE_FILE() {
        this.dwSize=this.size();
    }
}
