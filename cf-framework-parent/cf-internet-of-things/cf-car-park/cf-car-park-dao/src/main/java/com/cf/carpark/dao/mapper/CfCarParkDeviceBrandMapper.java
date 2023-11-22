package com.cf.carpark.dao.mapper;

import com.cf.carpark.domain.CfCarParkDeviceBrand;
import com.cf.carpark.domain.CfCarParkDeviceBrandExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfCarParkDeviceBrandMapper {
    int countByExample(CfCarParkDeviceBrandExample example);

    int deleteByExample(CfCarParkDeviceBrandExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfCarParkDeviceBrand record);

    int insertSelective(CfCarParkDeviceBrand record);

    List<CfCarParkDeviceBrand> selectByExample(CfCarParkDeviceBrandExample example);

    CfCarParkDeviceBrand selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfCarParkDeviceBrand record, @Param("example") CfCarParkDeviceBrandExample example);

    int updateByExample(@Param("record") CfCarParkDeviceBrand record, @Param("example") CfCarParkDeviceBrandExample example);

    int updateByPrimaryKeySelective(CfCarParkDeviceBrand record);

    int updateByPrimaryKey(CfCarParkDeviceBrand record);
}