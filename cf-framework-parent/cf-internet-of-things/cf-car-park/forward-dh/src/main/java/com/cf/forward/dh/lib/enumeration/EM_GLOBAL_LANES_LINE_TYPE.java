package com.cf.forward.dh.lib.enumeration;
/**
 * @description 车道线属性
 * @author 119178
 * @date 2021/3/16
 */
public enum EM_GLOBAL_LANES_LINE_TYPE {
	/**
	 * 未知
	 */
	EM_GLOBAL_LANES_LINE_TYPE_UNKNOWN(0),	
	/**
	 * 白实线
	 */
	EM_GLOBAL_LANES_LINE_TYPE_WHITESOLID(1),
	/**
	 * 白虚线
	 */
	EM_GLOBAL_LANES_LINE_TYPE_WHITEDOTTED(2),
	/**
	 * 黄线
	 */
	EM_GLOBAL_LANES_LINE_TYPE_YELLOW(3),		
	/**
	 * 上实下虚
	 */
	EM_GLOBAL_LANES_LINE_TYPE_UPSOLIDDOWNDOTTED(4),  
	/**
	 * 上虚下实
	 */
	EM_GLOBAL_LANES_LINE_TYPE_UPDOTTEDDOWNSOLID(5);   
	
	private int id ;

	private EM_GLOBAL_LANES_LINE_TYPE(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
