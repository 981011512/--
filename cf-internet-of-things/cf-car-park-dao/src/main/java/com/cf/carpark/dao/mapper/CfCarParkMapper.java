package com.cf.carpark.dao.mapper;

import com.cf.carpark.domain.CfCarPark;
import com.cf.carpark.domain.CfCarParkExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfCarParkMapper {
    int countByExample(CfCarParkExample example);

    int deleteByExample(CfCarParkExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfCarPark record);

    int insertSelective(CfCarPark record);

    List<CfCarPark> selectByExample(CfCarParkExample example);

    CfCarPark selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfCarPark record, @Param("example") CfCarParkExample example);

    int updateByExample(@Param("record") CfCarPark record, @Param("example") CfCarParkExample example);

    int updateByPrimaryKeySelective(CfCarPark record);

    int updateByPrimaryKey(CfCarPark record);

    /**
     * 根据条件查询停车场数据列表
     * @param conditions
     * @return
     */
    List<CfCarPark> selectListByCondition(String conditions);
}