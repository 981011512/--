package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 251823
 * @description 跟随车辆报警自定义信息
 * @date 2021/01/13
 */
public class NET_FOLLOW_CAR_ALARM_IMAGE_INFO extends NetSDKLib.SdkStructure{
	
	/**
	 * 同一组大小图片内GroupID相同
	 */
	public int nGroupID;
	
	/**
	 * 图片类型,参考{ @link EM_FOLLOW_CAR_ALARM_IMAGE_TYPE}
	 */
	public int emImageType;
	
	/**
	 * 在二进制数据块中的偏移,单位:字节
	 */
	public int dwoffset;
	
	/**
	 * 图片大小,单位:字节
	 */
	public int dwLength;
	
	/**
	 * 保留字节
	 */
	public byte[] byReserved = new byte[256];

}
