package com.cf.carpark.dao.mapper;

import com.cf.carpark.domain.CfCarParkUseLog;
import com.cf.carpark.domain.CfCarParkUseLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfCarParkUseLogMapper {
    int countByExample(CfCarParkUseLogExample example);

    int deleteByExample(CfCarParkUseLogExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfCarParkUseLog record);

    int insertSelective(CfCarParkUseLog record);

    List<CfCarParkUseLog> selectByExample(CfCarParkUseLogExample example);

    CfCarParkUseLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfCarParkUseLog record, @Param("example") CfCarParkUseLogExample example);

    int updateByExample(@Param("record") CfCarParkUseLog record, @Param("example") CfCarParkUseLogExample example);

    int updateByPrimaryKeySelective(CfCarParkUseLog record);

    int updateByPrimaryKey(CfCarParkUseLog record);
}