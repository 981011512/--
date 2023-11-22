package com.cf.carpark.dao.mapper;

import com.cf.carpark.domain.CfCarParkCarLimit;
import com.cf.carpark.domain.CfCarParkCarLimitExample;
import com.cf.carpark.domain.request.CfCarParkCarLimitQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfCarParkCarLimitMapper {
    int countByExample(CfCarParkCarLimitExample example);

    int deleteByExample(CfCarParkCarLimitExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfCarParkCarLimit record);

    int insertSelective(CfCarParkCarLimit record);

    List<CfCarParkCarLimit> selectByExample(CfCarParkCarLimitExample example);

    CfCarParkCarLimit selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfCarParkCarLimit record, @Param("example") CfCarParkCarLimitExample example);

    int updateByExample(@Param("record") CfCarParkCarLimit record, @Param("example") CfCarParkCarLimitExample example);

    int updateByPrimaryKeySelective(CfCarParkCarLimit record);

    int updateByPrimaryKey(CfCarParkCarLimit record);

    List<CfCarParkCarLimit> selectContinCarParkByQuery(CfCarParkCarLimitQuery cfCarParkCarLimitQuery);
}