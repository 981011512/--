package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * className：NET_USER_PICTURE_DATA
 * description：
 * author：251589
 * createTime：2020/12/22 21:56
 *
 * @version v1.0
 */
public class NET_USER_PICTURE_DATA extends NetSDKLib.SdkStructure {
    public String  pszPictureData;                     // 图片数据，最大 200K
    public int      nPictureLen;                        // pszPictureData 长度
    public byte[]   byReserved = new byte[1020];        // 预留字段
}
