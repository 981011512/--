package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.sun.jna.Pointer;

/**
 * className：NET_FACE_PIC_INFO
 * description： 人脸图片信息
 * author：251589
 * createTime：2020/12/28 11:14
 *
 * @version v1.0
 */
public class NET_FACE_PIC_INFO extends NetSDKLib.SdkStructure {
    public int    dwOffSet;    // 文件在二进制数据块中的偏移位置, 单位:字节
    public int    dwFileLenth;    // 文件大小, 单位:字节
    public int    dwWidth;    // 图片宽度, 单位:像素
    public int    dwHeight;    // 图片高度, 单位:像素
    public int    bIsDetected;    // 图片是否算法检测出来的检测过的提交识别服务器时,
    public int    nFilePathLen;    // 文件路径长度 既pszFilePath 的大小
    public Pointer pszFilePath;    // 文件路径, 由用户申请空间, 作为输入条件时不需要
    public byte[]    szPictureID = new byte[32];    // 图片ID, 针对一人多人脸的情况, 用于区分不同人脸
    public int    emFeatureState;    // 图片建模状态
    public int    emFeatureErrCode;    // 建模失败原因
    public int    emPicOperate;    // 图片操作类型
    public byte[]    bReserved = new byte[20];    // 预留字节
}
