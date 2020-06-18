package com.cf.carpark.dao.mapper;

import com.cf.carpark.domain.CfCar;
import com.cf.carpark.domain.CfCarExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfCarMapper {
    int countByExample(CfCarExample example);

    int deleteByExample(CfCarExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfCar record);

    int insertSelective(CfCar record);

    List<CfCar> selectByExample(CfCarExample example);

    CfCar selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfCar record, @Param("example") CfCarExample example);

    int updateByExample(@Param("record") CfCar record, @Param("example") CfCarExample example);

    int updateByPrimaryKeySelective(CfCar record);

    int updateByPrimaryKey(CfCar record);
}