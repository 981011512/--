package com.cf.carpark.dao.mapper;

import com.cf.carpark.domain.CfCarParkCheckpoint;
import com.cf.carpark.domain.CfCarParkCheckpointExample;
import com.cf.carpark.domain.request.CfCarParkCheckpointQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfCarParkCheckpointMapper {
    int countByExample(CfCarParkCheckpointExample example);

    int deleteByExample(CfCarParkCheckpointExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfCarParkCheckpoint record);

    int insertSelective(CfCarParkCheckpoint record);

    List<CfCarParkCheckpoint> selectByExample(CfCarParkCheckpointExample example);

    CfCarParkCheckpoint selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfCarParkCheckpoint record, @Param("example") CfCarParkCheckpointExample example);

    int updateByExample(@Param("record") CfCarParkCheckpoint record, @Param("example") CfCarParkCheckpointExample example);

    int updateByPrimaryKeySelective(CfCarParkCheckpoint record);

    int updateByPrimaryKey(CfCarParkCheckpoint record);

    /**
     * 查询附近的停车场(可以指定停车场查询)
     * @param cfCarParkCheckpointQuery
     * @return
     */
    List<CfCarParkCheckpoint> selectNearbyCheckPoint(CfCarParkCheckpointQuery cfCarParkCheckpointQuery);

    /**
     * 根据Query条件进行原生sql查询
     * @param cfCarParkCheckpointQuery
     * @return
     */
    List<CfCarParkCheckpoint> selectByQuery(CfCarParkCheckpointQuery cfCarParkCheckpointQuery);
}