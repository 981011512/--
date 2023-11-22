package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * className：NET_IN_DELIVER_USER_PICTURE
 * description： 下发人脸数据 <—— 入参
 * author：251589
 * createTime：2020/12/21 21:51
 *
 * @version v1.0
 */
public class NET_IN_DELIVER_USER_PICTURE extends NetSDKLib.SdkStructure {
    public int                          dwSize;                                             // 结构体大小
    public int                          nResult;                                            // 平台查询结果// 0：有数据  1：不在人员库
    public byte[]                       szCitizenID = new byte[32];                         // 身份证信息
    public byte[]                       szUserID = new byte[64];                            // 用户标识（选填）
    public NET_USER_PICTURE_DATA[]      stuPictureData = new NET_USER_PICTURE_DATA[5];      // 图片信息
    public int                          nPictureData;                                       // stuPictureData 个数
    public byte[]                       byReserved = new byte[4];                           // 预留字段

    public NET_IN_DELIVER_USER_PICTURE() {
        this.dwSize = this.size();
    }
}
