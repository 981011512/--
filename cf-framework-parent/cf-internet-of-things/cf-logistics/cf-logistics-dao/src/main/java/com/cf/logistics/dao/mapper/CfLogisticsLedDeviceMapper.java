package com.cf.logistics.dao.mapper;

import com.cf.logistics.domain.CfLogisticsLedDevice;
import com.cf.logistics.domain.CfLogisticsLedDeviceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfLogisticsLedDeviceMapper {
    int countByExample(CfLogisticsLedDeviceExample example);

    int deleteByExample(CfLogisticsLedDeviceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CfLogisticsLedDevice record);

    int insertSelective(CfLogisticsLedDevice record);

    List<CfLogisticsLedDevice> selectByExample(CfLogisticsLedDeviceExample example);

    CfLogisticsLedDevice selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CfLogisticsLedDevice record, @Param("example") CfLogisticsLedDeviceExample example);

    int updateByExample(@Param("record") CfLogisticsLedDevice record, @Param("example") CfLogisticsLedDeviceExample example);

    int updateByPrimaryKeySelective(CfLogisticsLedDevice record);

    int updateByPrimaryKey(CfLogisticsLedDevice record);
}