package com.cf.carpark.service;

import com.cf.carpark.domain.CfCarParkCar;
import com.cf.carpark.domain.CfCarParkCarExample;
import com.cf.carpark.domain.request.CfCarParkCarQuery;
import com.cf.carpark.domain.request.CfCarParkUseLogQuery;

import java.util.List;
import java.util.Map;

/**
 * 车辆管理
 *
 * @ClassName CfCarParkService
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/3/13/013 11:22
 * @Version 1.0
 **/
public interface CfCarParkCarService {

    /**
     * 添加车辆
     * @param cfCarParkCar
     * @return
     */
    CfCarParkCar add(CfCarParkCar cfCarParkCar);

    /**
     * 给指定用户绑定车牌
     * @param cfCarParkCar
     * @return
     */
    CfCarParkCar bindCarToUser(CfCarParkCar cfCarParkCar);

    /**
     * 删除车辆
     * @param id
     * @return
     */
    Integer delete(String id);

    /**
     * 根据条件删除车辆
     * @param cfCarParkCarQuery
     * @return
     */
    Integer deleteByQuery(CfCarParkCarQuery cfCarParkCarQuery);

    /**
     * 更新车辆信息
     * @param cfCarParkCar
     * @return
     */
    CfCarParkCar update(CfCarParkCar cfCarParkCar);

    /**
     * 根据Query条件进行更新
     * @param cfCarParkCar
     * @param cfCarParkCarQuery
     * @return
     */
    Integer updateByQuery(CfCarParkCar cfCarParkCar, CfCarParkCarQuery cfCarParkCarQuery);

    /**
     * 根据id获取一条车辆数据
     * @param id
     * @return
     */
    CfCarParkCar findById(String id);

    /**
     * 根据条件查询车辆数据列表
     * @param conditions example {"字段名":"表别名"}
     * @param allowFiledsMap example {"字段名":"表别名"}
     * @param allowFileds example {"字段名"}
     * @return
     */
    List<CfCarParkCar> selectListByCondition(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds);

    /**
     * 根据条件查询车辆数据列表数
     * @param conditions example {"字段名":"表别名"}
     * @param allowFiledsMap example {"字段名":"表别名"}
     * @param allowFileds example {"字段名"}
     * @return
     */
    Integer selectListByConditionCounts(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds);

    /**
     * 获取指定用户的车辆
     * @param cfCarParkCarQuery
     * @return
     */
    List<CfCarParkCar> getMyCarsByCondition(CfCarParkCarQuery cfCarParkCarQuery);

    /**
     * 根据条件搜索数据(原生sql)
     * @param cfCarParkCarQuery
     * @return
     */
    List<CfCarParkCar> selectByQuery(CfCarParkCarQuery cfCarParkCarQuery);

    /**
     * 处理停车数据默认值
     * @param cfCarParkCar
     * @return
     */
    CfCarParkCar handleCfCarParkCarDefaultValue(CfCarParkCar cfCarParkCar);

    CfCarParkCarExample getExampleByQuery(CfCarParkCarQuery cfCarParkCarQuery);

    /**
     * 根据query条件标准查询数据列表(使用内置mapper查询)
     * @param cfCarParkCarQuery
     * @return
     */
    List<CfCarParkCar> mapperSelectByQuery(CfCarParkCarQuery cfCarParkCarQuery);

    /**
     * 根据query条件统计数据量
     * @param cfCarParkCarQuery
     * @return
     */
    Integer countByQuery(CfCarParkCarQuery cfCarParkCarQuery);



}
