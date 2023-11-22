package com.cf.carpark.service;

import com.cf.carpark.domain.CfCarParkCheckpoint;
import com.cf.carpark.domain.CfCarParkCheckpointExample;
import com.cf.carpark.domain.request.CfCarParkCheckpointQuery;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;

import java.util.List;

/**
 * 停车场出入口
 *
 * @ClassName CfCarParkCheckpointService
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/7/007 7:53
 * @Version 1.0
 **/
public interface CfCarParkCheckpointService {

    public CfCarParkCheckpoint findById(String id);

    public CfCarParkCheckpoint findById(String id, Boolean expectEmpty);

    /**
     * 根据条件获取出入口数据列表
     * @param cfCarParkCheckpointQuery
     * @return
     */
    public List<CfCarParkCheckpoint> getListByQuery(CfCarParkCheckpointQuery cfCarParkCheckpointQuery);

    CfCarParkCheckpointExample getExampleByQuery(CfCarParkCheckpointQuery cfCarParkCheckpointQuery);

    /**
     * 原生sql条件查询
     * @param cfCarParkCheckpointQuery
     * @return
     */
    public List<CfCarParkCheckpoint> selectByQuery(CfCarParkCheckpointQuery cfCarParkCheckpointQuery);

    public CfCarParkCheckpoint add(CfCarParkCheckpoint cfCarParkCheckpoint);

    public CfCarParkCheckpoint update(CfCarParkCheckpoint cfCarParkCheckpoint);

    Integer updateByQuery(CfCarParkCheckpoint cfCarParkCheckpoint, CfCarParkCheckpointQuery cfCarParkCheckpointQuery);

    public Integer delete(String id);

    public Integer deleteByQuery(CfCarParkCheckpointQuery cfCarParkCheckpointQuery);


    /**
     * 查询附近的停车场(可以指定停车场查询)
     * @param cfCarParkCheckpointQuery
     * @return
     */
    List<CfCarParkCheckpoint> selectNearbyCheckPoint(CfCarParkCheckpointQuery cfCarParkCheckpointQuery);

    /**
     * 解除指定用户的所有岗亭通道值班
     * @param uid
     * @return
     */
    Integer removeCheckPointDutyByUid(String uid);

    /**
     * 检查指定用户是否有指定通道的权限
     * @param userBasicInfo
     * @param checkPointId
     */
    CfCarParkCheckpoint checkUserAuthOfCheckPoint(UserBasicInfo userBasicInfo, String checkPointId);

}
