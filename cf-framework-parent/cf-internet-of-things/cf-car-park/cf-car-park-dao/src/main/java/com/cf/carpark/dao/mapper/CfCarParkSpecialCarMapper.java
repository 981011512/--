package com.cf.carpark.dao.mapper;

import com.cf.carpark.domain.CfCarParkSpecialCar;
import com.cf.carpark.domain.CfCarParkSpecialCarExample;
import com.cf.carpark.domain.request.CfCarParkSpecialCarQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfCarParkSpecialCarMapper {
    int countByExample(CfCarParkSpecialCarExample example);

    int deleteByExample(CfCarParkSpecialCarExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfCarParkSpecialCar record);

    int insertSelective(CfCarParkSpecialCar record);

    List<CfCarParkSpecialCar> selectByExample(CfCarParkSpecialCarExample example);

    CfCarParkSpecialCar selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfCarParkSpecialCar record, @Param("example") CfCarParkSpecialCarExample example);

    int updateByExample(@Param("record") CfCarParkSpecialCar record, @Param("example") CfCarParkSpecialCarExample example);

    int updateByPrimaryKeySelective(CfCarParkSpecialCar record);

    int updateByPrimaryKey(CfCarParkSpecialCar record);

    List<CfCarParkSpecialCar> selectContinCarParkByQuery(CfCarParkSpecialCarQuery cfCarParkSpecialCarQuery);

    int batchAdd(List<CfCarParkSpecialCar> cfCarParkSpecialCarList);
}