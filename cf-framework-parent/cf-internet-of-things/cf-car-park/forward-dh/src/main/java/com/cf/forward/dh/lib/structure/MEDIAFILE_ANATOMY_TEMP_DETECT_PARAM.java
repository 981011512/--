package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 251823
 * @description 热成像人体测温查询条件( CLIENT_FindFileEx + DH_FILE_QUERY_ANATOMY_TEMP_DETECT )
 * @date 2021/02/22
 */
public class MEDIAFILE_ANATOMY_TEMP_DETECT_PARAM extends NetSDKLib.SdkStructure{
	 /**
     *  结构体大小 
     */
    public int dwSize;

    /**
     *  通道号,从0开始,-1表示查询所有通道
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
     *  过滤信息
     */
    public NET_ANATOMY_TEMP_DETECT_FILTER stuFilter;

    public MEDIAFILE_ANATOMY_TEMP_DETECT_PARAM(){
        this.dwSize = this.size();
    }		

}
