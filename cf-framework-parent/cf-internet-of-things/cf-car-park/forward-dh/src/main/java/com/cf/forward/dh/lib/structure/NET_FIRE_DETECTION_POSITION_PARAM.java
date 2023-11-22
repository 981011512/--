package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib.SdkStructure;
/**
 * @description IPC的Web需求,火焰定位参数
 * @author 119178
 * @date 2021/3/11
 */
public class NET_FIRE_DETECTION_POSITION_PARAM extends SdkStructure{
	/**
	 * 是否支持火焰定位 false时web页面隐藏火焰定位参数
	 */
	public int						bEnable;	
	/**
	 * 字节对齐
	 */
	public byte[]                        byReserved1 = new byte[4];	
	/**
	 * 画面中心点离X轴3/4点地面距离，单位：米
	 */
	public float						fAB;	
    /**
     * 画面X轴3/4点离底部垂直点地面距离，单位：米
     */
	public float						fBC;
	/**
	 * 画面底部3/4点点到底部中心点地面距离，单位：米
	 */
	public float						fCD;								
	/**
	 * 底部中心点到画面中心点地面距离，单位：米
	 */
	public float						fDA;					
	/**
	 * 底部中心点离相机水平点距离，单位：米
	 */
	public float						fOD;			
	/**
	 * 保留字节
	 */
	public byte[]                        byReserved = new byte[464];                        
}
