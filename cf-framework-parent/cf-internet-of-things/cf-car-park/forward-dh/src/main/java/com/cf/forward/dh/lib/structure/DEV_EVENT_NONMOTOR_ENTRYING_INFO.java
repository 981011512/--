package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * className：DEV_EVENT_NONMOTOR_ENTRYING_INFO
 * description： 事件类型 EVENT_IVS_NONMOTOR_ENTRYING (非机动车进入电梯事件)对应的数据块描述信息
 * author：251589
 * createTime：2020/12/21 13:47
 *
 * @version v1.0
 */
public class DEV_EVENT_NONMOTOR_ENTRYING_INFO extends NetSDKLib.SdkStructure {
    public 	int									nChannelID;				// 通道号
    public 	int									nAction;				// 1:开始 2:停止
    public 	byte[]szName		                = new byte[128];		// 事件名称
    public 	double								PTS;					// 时间戳(单位是毫秒)
    public 	NET_TIME_EX							UTC;					// 事件发生的时间
    public 	int									nEventID;				// 事件ID
    public 	int									nRuleID;				// 规则ID
    public 	int									nSequence;				// 视频帧序号
    public  int             emClassType;			// 智能事件所属大类
    public 	int									nObjectNum;				// 目标个数
    public  NetSDKLib.VA_OBJECT_NONMOTOR[] stuObjects = new NetSDKLib.VA_OBJECT_NONMOTOR[8];			// 非机动车目标
    public  NetSDKLib.SCENE_IMAGE_INFO_EX stuSceneImage;			// 全景广角图
    public 	byte[] byReserved = 	new byte[1020];	 		    // 预留字段

}
