package com.cf.charging.dao.mapper;

import com.cf.charging.domain.CfChargingStation;
import com.cf.charging.domain.CfChargingStationExample;
import com.cf.charging.domain.request.CfChargingStationQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfChargingStationMapper {
    int countByExample(CfChargingStationExample example);

    int deleteByExample(CfChargingStationExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfChargingStation record);

    int insertSelective(CfChargingStation record);

    List<CfChargingStation> selectByExample(CfChargingStationExample example);

    CfChargingStation selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfChargingStation record, @Param("example") CfChargingStationExample example);

    int updateByExample(@Param("record") CfChargingStation record, @Param("example") CfChargingStationExample example);

    int updateByPrimaryKeySelective(CfChargingStation record);

    int updateByPrimaryKey(CfChargingStation record);

    /**
     * 根据条件查询充电站数据列表
     * @param conditions
     * @return
     */
    List<CfChargingStation> selectListByCondition(String conditions);

    /**
     * 根据条件查询停车场数据列表数
     * @param conditions
     * @return
     */
    Integer selectListByConditionCounts(String conditions);

    /**
     * 查询附近充电站并返回其距离当前位置的距离(单位米)
     * @param cfChargingStationQuery
     * @return
     */
    List<CfChargingStation> selectContalDistanceListByQuery(CfChargingStationQuery cfChargingStationQuery);

    /**
     * 更新部分字段的值
     * @param cfChargingStation
     * @return
     */
    Integer increaseOrreduceFieldValue(CfChargingStation cfChargingStation);
}