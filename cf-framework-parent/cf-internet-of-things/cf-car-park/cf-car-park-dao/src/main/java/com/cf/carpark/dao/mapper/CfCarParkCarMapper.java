package com.cf.carpark.dao.mapper;

import com.cf.carpark.domain.CfCarParkCar;
import com.cf.carpark.domain.CfCarParkCarExample;
import com.cf.carpark.domain.request.CfCarParkCarQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfCarParkCarMapper {
    int countByExample(CfCarParkCarExample example);

    int deleteByExample(CfCarParkCarExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfCarParkCar record);

    int insertSelective(CfCarParkCar record);

    List<CfCarParkCar> selectByExample(CfCarParkCarExample example);

    CfCarParkCar selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfCarParkCar record, @Param("example") CfCarParkCarExample example);

    int updateByExample(@Param("record") CfCarParkCar record, @Param("example") CfCarParkCarExample example);

    int updateByPrimaryKeySelective(CfCarParkCar record);

    int updateByPrimaryKey(CfCarParkCar record);

    /**
     * 根据条件查询用户车辆数据列表
     * @param conditions
     * @return
     */
    List<CfCarParkCar> selectListByCondition(String conditions);

    /**
     * 根据条件查询用户车辆数据列表数
     * @param conditions
     * @return
     */
    Integer selectListByConditionCounts(String conditions);

    /**
     * 查询某个用户的车辆数
     * @param uid
     * @return
     */
    Integer getCountsByUid(String uid);

    /**
     * 根据条件查询(自定义原生sql)
     * @param cfCarParkCarQuery
     * @return
     */
    List<CfCarParkCar> selectByQuery(CfCarParkCarQuery cfCarParkCarQuery);
}