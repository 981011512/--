package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.NetSDKLib.fRadarAlarmPointInfoCallBack;
import com.sun.jna.Pointer;

/**
 * 订阅雷达的报警点信息入参(对应接口 CLIENT_AttachRadarAlarmPointInfo)
 *
 * @author ： 119178
 * @since ： Created in 2021/2/03 13:56
 */
public class NET_IN_RADAR_ALARMPOINTINFO extends NetSDKLib.SdkStructure {
	/**
	 * 结构体大小
	 */
	public int                       dwSize;    
	/**
	 * 雷达报警点信息回调
	 */
	public fRadarAlarmPointInfoCallBack    cbAlarmPointInfo;    
	/**
	 * 用户数据
	 */
	public Pointer                      dwUser; 
	/**
	 * 通道号
	 */
	public int							nChannel;				
	
	  public NET_IN_RADAR_ALARMPOINTINFO() {
          this.dwSize = this.size();
      }
}
