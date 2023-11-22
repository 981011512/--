package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 251823
 * @description 热成像人体测温查询结果 ( CLIENT_FindFileEx + DH_FILE_QUERY_ANATOMY_TEMP_DETECT )
 * @date 2021/02/22
 */
public class MEDIAFILE_ANATOMY_TEMP_DETECT_INFO extends NetSDKLib.SdkStructure{
	 /**
     *  结构体大小 
     */
    public int dwSize;

    /**
     *  通道号从0开始,-1表示查询所有通道
     */
    public int nChannelID;

    /**
     *  开始时间 
     */
    public NET_TIME stuBeginTime;

    /**
     *  结束时间 
     */
    public NET_TIME stuEndTime;

    /**
     *  事件发生时间
     */
    public NET_TIME stuEventTime;

    /**
     *  文件长度
     */
    public long nFileSize;

    /**
     *  文件类型,查考枚举{ @link EM_FILE_TYPE}
     */
    public int emFileType;

    /**
     *  文件路径 
     */
    public byte[] szFilePath = new byte[NetSDKLib.MAX_PATH];

    /**
     *  关联的事件列表,事件类型列表,参见智能分析事件类型
     */
    public int[] nEventList = new int[NetSDKLib.MAX_IVS_EVENT_NUM];

    /**
     *  事件总数
     */
    public int nEventCount;

    /**
     *  分区号
     */
    public int nPartition;

    /**
     *  磁盘号
     */
    public int nDriveNo;

    /**
     *  簇号
     */
    public int nCluster;

    /**
     *  表示在簇中的图片序号
     *  对于同一个簇中打包多张图片,提供索引方式定位图片
     */
    public int nPicIndex;

    /**
     *  温度信息(低温、正常、超温有效),查考枚举{ @link EM_QUERY_TEMPERATURE_TYPE}
     */
    public int emTempType;

    /**
     *  温度值 
     */
    public double dbTemperature;

    /**
     *  预留字段
     */
    public byte[] byReserved1 = new byte[4];

    /**
     *  关联的智能事件码: EVENT_IVS_ANATOMY_TEMP_DETECT,EVENT_IVS_FACEDETECT,EVENT_IVS_FACERECOGNITION 
     */
    public int nEventType;

    /**
     *  nEventType 为 EVENT_IVS_ANATOMY_TEMP_DETECT 时，有效
     */
    public NET_ANATOMY_TEMP_DETECT_ANATOMYTEMPDETECT_RESULT stuAnatomyDetectResult;

    /**
     *  nEventType 为 EVENT_IVS_FACEDETECT 时，有效
     */
    public MEDIAFILE_ANATOMY_TEMP_DETECT_FACEDETECT_RESULT stuFaceDetectResult;

    /**
     *  nEventType 为 EVENT_IVS_FACERECOGNITION 时，有效 
     */
    public MEDIAFILE_ANATOMY_TEMP_DETECT_FACERECOGNITION_RESULT stuFaceRecognitionResult;

    /**
     *  目标图路径
     */    
    public ObjectPath[] szObjectPath = (ObjectPath[])new ObjectPath().toArray(8);   

    /**
     *  szObjectPath 的个数
     */
    public int nObjectPathNum;

    /**
     *  人脸图路径
     */
    public byte[] szFacePicturePath = new byte[NetSDKLib.MAX_PATH];

    public MEDIAFILE_ANATOMY_TEMP_DETECT_INFO(){
        this.dwSize = this.size();
    }

}
