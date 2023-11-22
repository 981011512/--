package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 251823
 * @description 人体测温过滤条件
 * @date 2021/02/22
 */
public class NET_ANATOMY_TEMP_DETECT_FILTER extends NetSDKLib.SdkStructure{
	 /**
     *  温度类型 ,参考{ @link EM_QUERY_TEMPERATURE_TYPE}
     */
    public int emTempType;

    /**
     *  预留字段
     */
    public byte[] byReserved1 = new byte[4];

    /**
     *  温度值，当 emTempType 取值为全部、正常、高温时有效
     *  emTempType 为全部时，表示大于等于 dbTemperature 的温度会被筛选出来
     *  emTempType 为正常时，表示体温正常且大于等于 dbTemperature 的温度会被筛选出来
     *  emTempType 为高温时，表示体温超温且大于等于 dbTemperature 的温度会被筛选出来
     */
    public double dbTemperature;

    /**
     *  人员信息
     */
    public ANATOMY_TEMP_DETECT_PERSON_FILTER stuPersonInfo;

    /**
     *  保留字节
     */
    public byte[] byReserved = new byte[1024];
	
}
