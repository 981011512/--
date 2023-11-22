package com.cf.carpark.dao.mapper;

import com.cf.carpark.domain.CfCarParkPackageLog;
import com.cf.carpark.domain.CfCarParkPackageLogExample;
import com.cf.carpark.domain.request.CfCarParkPackageLogQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfCarParkPackageLogMapper {
    int countByExample(CfCarParkPackageLogExample example);

    int deleteByExample(CfCarParkPackageLogExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfCarParkPackageLog record);

    int insertSelective(CfCarParkPackageLog record);

    List<CfCarParkPackageLog> selectByExample(CfCarParkPackageLogExample example);

    CfCarParkPackageLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfCarParkPackageLog record, @Param("example") CfCarParkPackageLogExample example);

    int updateByExample(@Param("record") CfCarParkPackageLog record, @Param("example") CfCarParkPackageLogExample example);

    int updateByPrimaryKeySelective(CfCarParkPackageLog record);

    int updateByPrimaryKey(CfCarParkPackageLog record);

    List<CfCarParkPackageLog> selectByQuery(CfCarParkPackageLogQuery cfCarParkPackageLogQuery);
}