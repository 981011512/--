package com.cf.carpark.dao.mapper;

import com.cf.carpark.domain.CfCarParkDevice;
import com.cf.carpark.domain.CfCarParkDeviceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfCarParkDeviceMapper {
    int countByExample(CfCarParkDeviceExample example);

    int deleteByExample(CfCarParkDeviceExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfCarParkDevice record);

    int insertSelective(CfCarParkDevice record);

    List<CfCarParkDevice> selectByExample(CfCarParkDeviceExample example);

    CfCarParkDevice selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfCarParkDevice record, @Param("example") CfCarParkDeviceExample example);

    int updateByExample(@Param("record") CfCarParkDevice record, @Param("example") CfCarParkDeviceExample example);

    int updateByPrimaryKeySelective(CfCarParkDevice record);

    int updateByPrimaryKey(CfCarParkDevice record);

    /**
     * 根据条件查询停车场硬件数据列表
     * @param conditions
     * @return
     */
    List<CfCarParkDevice> selectListByCondition(String conditions);

    /**
     * 根据条件查询停车场硬件数据列表数
     * @param conditions
     * @return
     */
    Integer selectListByConditionCounts(String conditions);
}