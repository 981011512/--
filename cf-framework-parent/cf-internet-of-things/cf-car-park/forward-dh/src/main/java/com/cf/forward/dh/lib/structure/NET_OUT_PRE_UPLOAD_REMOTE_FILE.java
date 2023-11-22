package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 47081
 * @version 1.0
 * @description {@link NetSDKLib#CLIENT_PreUploadRemoteFile(NetSDKLib.LLong, NET_IN_PRE_UPLOAD_REMOTE_FILE, NET_OUT_PRE_UPLOAD_REMOTE_FILE, int)} 接口输出参数(设置文件长度)
 * @date 2020/6/10
 */
public class NET_OUT_PRE_UPLOAD_REMOTE_FILE extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int               dwSize;
    /**
     * 标志是否继续上传该文件, true:上传 false:不上传
     */
    public boolean           bContinue2Upload;
    /**
     * 错误原因, 当bContinue2Upload为false时emType有效,错误原因请参考{@link com.cf.forward.dh.lib.enumeration.EM_REASON_TYPE}
     */
    public int               emType;
    public NET_OUT_PRE_UPLOAD_REMOTE_FILE(){
        this.dwSize=this.size();
    }
}
