package com.cf.forward.dh.lib.enumeration;
/**
 * @description  标尺信息
 * @author 119178
 * @date 2021/3/16
 */
public enum NET_EM_STAFF_TYPE {
    NET_EM_STAFF_TYPE_ERR(0),
    /**
     * "Horizontal" 水平线段
     */
    NET_EM_STAFF_TYPE_HORIZONTAL(1), 
    /**
     * "Vertical" 垂直线段
     */
    NET_EM_STAFF_TYPE_VERTICAL(2), 
    /**
     * "Any" 任意线段
     */
    NET_EM_STAFF_TYPE_ANY(3), 
    /**
     * "Cross" 垂直面交线段
     */
    NET_EM_STAFF_TYPE_CROSS(4);                   
    
	private int id ;

	private NET_EM_STAFF_TYPE(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
