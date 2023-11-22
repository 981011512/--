package com.cf.carpark.dao.mapper;

import com.cf.carpark.domain.CfDailyParkingStatistcs;
import com.cf.carpark.domain.CfDailyParkingStatistcsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfDailyParkingStatistcsMapper {
    int countByExample(CfDailyParkingStatistcsExample example);

    int deleteByExample(CfDailyParkingStatistcsExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfDailyParkingStatistcs record);

    int insertSelective(CfDailyParkingStatistcs record);

    List<CfDailyParkingStatistcs> selectByExample(CfDailyParkingStatistcsExample example);

    CfDailyParkingStatistcs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfDailyParkingStatistcs record, @Param("example") CfDailyParkingStatistcsExample example);

    int updateByExample(@Param("record") CfDailyParkingStatistcs record, @Param("example") CfDailyParkingStatistcsExample example);

    int updateByPrimaryKeySelective(CfDailyParkingStatistcs record);

    int updateByPrimaryKey(CfDailyParkingStatistcs record);
}