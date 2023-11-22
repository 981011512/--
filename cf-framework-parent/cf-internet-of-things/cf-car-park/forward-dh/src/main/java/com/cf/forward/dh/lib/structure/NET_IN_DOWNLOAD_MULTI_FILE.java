package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.enumeration.EM_DOWNLOAD_FILE_TYPE;
import com.cf.forward.dh.lib.enumeration.EM_SUBCLASSID_TYPE;
import com.sun.jna.Pointer;

/**
 * 批量下载文件 入参
 * 接口 {@link NetSDKLib#CLIENT_DownLoadMultiFile}
 * 出参 {@link NET_OUT_DOWNLOAD_MULTI_FILE}
 *
 * @author ： 47040
 * @since ： Created in 2020/12/28 15:19
 */
public class NET_IN_DOWNLOAD_MULTI_FILE extends NetSDKLib.SdkStructure {

    public int dwSize;
    /**
     * 待下载文件数,emDownloadType为EM_DOWNLOAD_BY_FILENAME有效
     */
    public int nFileCount;
    /**
     * {@link NET_DOWNLOADFILE_INFO} 待下载文件信息,emDownloadType为 EM_DOWNLOAD_BY_FILENAME 时有效
     * emDownloadType为EM_DOWNLOAD_BY_FILENAME有效
     * 由用户申请内存，大小为 sizeof(NET_DOWNLOADFILE_INFO)*nFileCount
     */
    public Pointer pFileInfos;
    /**
     * 进度回调函数
     */
    public NetSDKLib.fMultiFileDownLoadPosCB cbPosCallBack;
    /**
     * 用户数据
     */
    public Pointer dwUserData;
    /**
     * {@link EM_DOWNLOAD_FILE_TYPE} 下载方式
     */
    public int emDownloadType;
    /**
     * 按查询条件下载: 下载条件数,emDownloadType为EM_DOWNLOAD_BY_CONDITION有效
     */
    public int nConditionCount;
    /**
     * {@link NET_DOWNLOAD_CONDITION_INFO}
     * 下载条件,emDownloadType为EM_DOWNLOAD_BY_CONDITION有效
     * 由用户申请内存，大小为sizeof(NET_DOWNLOAD_CONDITION_INFO)*nConditionCount
     */
    public Pointer pConditionInfos;
    /**
     * 从设备类型（定制）{@link EM_SUBCLASSID_TYPE}
     */
    public int emSubClass;
    /**
     * {@link NET_DOWNLOADFILE_OPTIONS_INFO}
     * 待下载文件信息, 下载选项; emDownloadType为EM_DOWNLOAD_BY_FILENAME有效
     */
    public Pointer pFileOptions;

    public NET_IN_DOWNLOAD_MULTI_FILE(){
        dwSize = this.size();
    }
}
