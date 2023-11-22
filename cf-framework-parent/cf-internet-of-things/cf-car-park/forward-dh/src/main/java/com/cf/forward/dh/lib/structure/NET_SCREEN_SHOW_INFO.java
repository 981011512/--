package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib.SdkStructure;

public class NET_SCREEN_SHOW_INFO  extends SdkStructure {
	/**
	 * 屏幕编号
	 */
	public int					nScreenNo;			
	/**
	 *  显示文本(文本类型为EM_SCREEN_TEXT_TYPE_LOCAL_TIME时的时间格式,
	 *         %Y 年
	 *	       %M 月
	 *         %D 日
	 *         %H 时(24小时机制)
	 *			%h 时(12小时)
	 *			%m 分
	 *			%S 秒
	 *			%W 星期
	 *			%T 显示上午或下午
	 *			%X 表示显示普通文本内容
	 */
	public byte[]				szText = new byte[256];	
	/**
	 * 文本类型EM_SCREEN_TEXT_TYPE
	 */
	public int		 emTextType;		
	/**
	 * 文本颜色EM_SCREEN_TEXT_COLOR
	 */
	public int	 emTextColor;		
	/**
	 * 文本滚动模式EM_SCREEN_TEXT_ROLL_MODE
	 */
	public int emTextRollMode;	
	/**
	 * 文本滚动速度由慢到快分为1~5
	 */
	public int					 nRollSpeed;		
	/**
	 * 保留字节
	 */
	public byte[]					 byReserved = new byte[252];		
}
