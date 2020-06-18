package com.cf.carpark.dao.mapper;

import com.cf.carpark.domain.CfCarParkCheckpoint;
import com.cf.carpark.domain.CfCarParkCheckpointExample;
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
}