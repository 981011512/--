package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 批量下载文件 出参
 * 接口 {@link NetSDKLib#CLIENT_DownLoadMultiFile}
 * 出参 {@link NET_IN_DOWNLOAD_MULTI_FILE}
 *
 * @author ： 47040
 * @since ： Created in 2020/12/28 16:11
 */
public class NET_OUT_DOWNLOAD_MULTI_FILE extends NetSDKLib.SdkStructure {

    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * 下载句柄
     */
    public NetSDKLib.LLong lDownLoadHandle;

    public NET_OUT_DOWNLOAD_MULTI_FILE() {
        dwSize = this.size();
    }

}
