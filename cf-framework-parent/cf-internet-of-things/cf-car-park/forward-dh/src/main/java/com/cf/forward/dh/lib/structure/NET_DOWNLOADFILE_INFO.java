package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

import static com.cf.forward.dh.lib.NetSDKLib.MAX_PATH;

/**
 * CLIENT_DownLoadMultiFile 接口参数
 *
 * @author ： 47040
 * @since ： Created in 2020/12/28 15:36
 */
public class NET_DOWNLOADFILE_INFO extends NetSDKLib.SdkStructure {

    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * 文件ID, 由用户自己分配
     */
    public int dwFileID;
    /**
     * 查询到的文件大小
     */
    public int nFileSize;
    /**
     * 查询到的文件路径
     */
    public byte[] szSourceFilePath = new byte[MAX_PATH];
    /**
     * 文件保存路径
     */
    public byte[] szSavedFileName = new byte[MAX_PATH];

    public NET_DOWNLOADFILE_INFO() {
        dwSize = this.size();
    }

}
