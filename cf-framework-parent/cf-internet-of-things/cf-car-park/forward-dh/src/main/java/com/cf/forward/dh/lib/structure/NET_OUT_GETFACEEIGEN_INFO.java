package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 251589
 * @version V1.0
 * @Description:
 * @date 2020/12/9 19:43
 */
public class NET_OUT_GETFACEEIGEN_INFO extends NetSDKLib.SdkStructure {

    public int dwSize;
    public int nInFaceEigenLen;          // 用户申请的人脸特征值数据大小
    public int nOutFaceEigenLen;         // 人脸特征值数据实际的大小
    public String pszFaceEigen;          // 人脸特征值数据, 由用户申请释放, 每张照片最大为8K
    public NET_OUT_GETFACEEIGEN_INFO() {
        dwSize = this.size();
    }
}
