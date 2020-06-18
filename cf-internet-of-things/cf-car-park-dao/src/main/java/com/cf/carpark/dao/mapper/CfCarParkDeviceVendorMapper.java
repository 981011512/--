package com.cf.carpark.dao.mapper;

import com.cf.carpark.domain.CfCarParkDeviceVendor;
import com.cf.carpark.domain.CfCarParkDeviceVendorExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfCarParkDeviceVendorMapper {
    int countByExample(CfCarParkDeviceVendorExample example);

    int deleteByExample(CfCarParkDeviceVendorExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfCarParkDeviceVendor record);

    int insertSelective(CfCarParkDeviceVendor record);

    List<CfCarParkDeviceVendor> selectByExampleWithBLOBs(CfCarParkDeviceVendorExample example);

    List<CfCarParkDeviceVendor> selectByExample(CfCarParkDeviceVendorExample example);

    CfCarParkDeviceVendor selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfCarParkDeviceVendor record, @Param("example") CfCarParkDeviceVendorExample example);

    int updateByExampleWithBLOBs(@Param("record") CfCarParkDeviceVendor record, @Param("example") CfCarParkDeviceVendorExample example);

    int updateByExample(@Param("record") CfCarParkDeviceVendor record, @Param("example") CfCarParkDeviceVendorExample example);

    int updateByPrimaryKeySelective(CfCarParkDeviceVendor record);

    int updateByPrimaryKeyWithBLOBs(CfCarParkDeviceVendor record);

    int updateByPrimaryKey(CfCarParkDeviceVendor record);
}