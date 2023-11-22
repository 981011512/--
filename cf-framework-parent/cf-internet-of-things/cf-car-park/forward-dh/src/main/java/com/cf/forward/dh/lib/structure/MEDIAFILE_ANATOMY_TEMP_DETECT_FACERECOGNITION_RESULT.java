package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 251823
 * @description 人脸识别信息
 * @date 2021/02/22
 */
public class MEDIAFILE_ANATOMY_TEMP_DETECT_FACERECOGNITION_RESULT extends NetSDKLib.SdkStructure {
	/**
     *  全景图是否存在
     */
    public int bGlobalScenePic;

    /**
     *  全景图片文件路径
     */
    public NetSDKLib.NET_PIC_INFO_EX stuGlobalScenePic;

    /**
     *  当前人脸匹配到的候选对象数量
     */
    public int nCandidateNum;

    /**
     *  当前人脸匹配到的候选对象信息, 实际返回个数为 nCandidateNum
     */
    public MEDIAFILE_ANATOMY_TEMP_DETECT_CANDIDATE_INFO[] stuCandidates = (MEDIAFILE_ANATOMY_TEMP_DETECT_CANDIDATE_INFO[]) new MEDIAFILE_ANATOMY_TEMP_DETECT_CANDIDATE_INFO().toArray(NetSDKLib.NET_MAX_CANDIDATE_NUM);
      /**
     *  人脸小图信息
     */
    public NetSDKLib.FACE_INFO_OBJECT stuFaceInfo;

    /**
     *  预留字段
     */
    public byte[] byReserved = new byte[1024];
    
    public MEDIAFILE_ANATOMY_TEMP_DETECT_FACERECOGNITION_RESULT() {
    	
    }
    
}
