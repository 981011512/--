package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 251823
 * @description 人员过滤信息
 * @date 2021/02/22
 */
public class ANATOMY_TEMP_DETECT_PERSON_FILTER extends NetSDKLib.SdkStructure{
	 /**
     *  姓名 
     */
    public byte[] szName = new byte[64];

    /**
     *  保留字节
     */
    public byte[] byReserved = new byte[1024];
}
