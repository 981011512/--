package com.cf.forward.dh.lib.enumeration;
/**
 * @description 烟雾/火焰检测场景
 * @author 119178
 * @date 2021/3/11
 */
public enum NET_EM_SCENEDETECTION_TYPE {
	/**
	 * 未知
	 */
	NET_EM_SCENEDETECTION_UNKNOWN (0),
	/**
	 * 室内场景
	 */
	NET_EM_SCENEDETECTION_INDOORSCENE (1),				
	/**
	 * 室内场景
	 */
	NET_EM_SCENEDETECTION_OUTDOORSCENE(2),				
	/**
	 * 交通隧道场景
	 */
	NET_EM_SCENEDETECTION_TUNNEL(3),					
	/**
	 * 森林场景
	 */
	NET_EM_SCENEDETECTION_FOREST(4);		
	
	private int id;

	private NET_EM_SCENEDETECTION_TYPE(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}	
}
