package com.cf.carpark.dao.mapper;

import com.cf.carpark.domain.CfCarParkDeviceLinkUser;
import com.cf.carpark.domain.CfCarParkDeviceLinkUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfCarParkDeviceLinkUserMapper {
    int countByExample(CfCarParkDeviceLinkUserExample example);

    int deleteByExample(CfCarParkDeviceLinkUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfCarParkDeviceLinkUser record);

    int insertSelective(CfCarParkDeviceLinkUser record);

    List<CfCarParkDeviceLinkUser> selectByExample(CfCarParkDeviceLinkUserExample example);

    CfCarParkDeviceLinkUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfCarParkDeviceLinkUser record, @Param("example") CfCarParkDeviceLinkUserExample example);

    int updateByExample(@Param("record") CfCarParkDeviceLinkUser record, @Param("example") CfCarParkDeviceLinkUserExample example);

    int updateByPrimaryKeySelective(CfCarParkDeviceLinkUser record);

    int updateByPrimaryKey(CfCarParkDeviceLinkUser record);

    Integer batchAdd(String batchSQL);
}