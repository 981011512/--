package com.cf.carpark.dao.mapper;

import com.cf.carpark.domain.CfCarParkVisit;
import com.cf.carpark.domain.CfCarParkVisitExample;
import com.cf.carpark.domain.request.CfCarParkVisitQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfCarParkVisitMapper {
    int countByExample(CfCarParkVisitExample example);

    int deleteByExample(CfCarParkVisitExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CfCarParkVisit record);

    int insertSelective(CfCarParkVisit record);

    List<CfCarParkVisit> selectByExample(CfCarParkVisitExample example);

    CfCarParkVisit selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CfCarParkVisit record, @Param("example") CfCarParkVisitExample example);

    int updateByExample(@Param("record") CfCarParkVisit record, @Param("example") CfCarParkVisitExample example);

    int updateByPrimaryKeySelective(CfCarParkVisit record);

    int updateByPrimaryKey(CfCarParkVisit record);

    List<CfCarParkVisit> selectContinByQuery(CfCarParkVisitQuery cfCarParkVisitQuery);
}