package com.cf.carpark.dao.mapper;

import com.cf.carpark.domain.CfCarParkCarType;
import com.cf.carpark.domain.CfCarParkCarTypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfCarParkCarTypeMapper {
    int countByExample(CfCarParkCarTypeExample example);

    int deleteByExample(CfCarParkCarTypeExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfCarParkCarType record);

    int insertSelective(CfCarParkCarType record);

    List<CfCarParkCarType> selectByExample(CfCarParkCarTypeExample example);

    CfCarParkCarType selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfCarParkCarType record, @Param("example") CfCarParkCarTypeExample example);

    int updateByExample(@Param("record") CfCarParkCarType record, @Param("example") CfCarParkCarTypeExample example);

    int updateByPrimaryKeySelective(CfCarParkCarType record);

    int updateByPrimaryKey(CfCarParkCarType record);
}