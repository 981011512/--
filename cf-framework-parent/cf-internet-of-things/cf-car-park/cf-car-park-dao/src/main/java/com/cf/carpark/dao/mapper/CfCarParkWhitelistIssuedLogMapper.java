package com.cf.carpark.dao.mapper;

import com.cf.carpark.domain.CfCarParkWhitelistIssuedLog;
import com.cf.carpark.domain.CfCarParkWhitelistIssuedLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfCarParkWhitelistIssuedLogMapper {
    int countByExample(CfCarParkWhitelistIssuedLogExample example);

    int deleteByExample(CfCarParkWhitelistIssuedLogExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfCarParkWhitelistIssuedLog record);

    int insertSelective(CfCarParkWhitelistIssuedLog record);

    List<CfCarParkWhitelistIssuedLog> selectByExample(CfCarParkWhitelistIssuedLogExample example);

    CfCarParkWhitelistIssuedLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfCarParkWhitelistIssuedLog record, @Param("example") CfCarParkWhitelistIssuedLogExample example);

    int updateByExample(@Param("record") CfCarParkWhitelistIssuedLog record, @Param("example") CfCarParkWhitelistIssuedLogExample example);

    int updateByPrimaryKeySelective(CfCarParkWhitelistIssuedLog record);

    int updateByPrimaryKey(CfCarParkWhitelistIssuedLog record);

    int batchAdd(List<CfCarParkWhitelistIssuedLog> cfCarParkWhitelistIssuedLogList);
}