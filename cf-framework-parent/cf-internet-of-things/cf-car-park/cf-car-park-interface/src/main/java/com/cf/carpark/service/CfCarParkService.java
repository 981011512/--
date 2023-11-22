package com.cf.carpark.service;

import com.cf.carpark.domain.CfCarPark;
import com.cf.carpark.domain.CfCarParkExample;
import com.cf.carpark.domain.CfCarParkFinanceReport;
import com.cf.carpark.domain.request.CfCarParkQuery;
import com.cf.carpark.domain.request.CfCarParkUseLogQuery;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.pay.domain.request.CfOrderQuery;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 停车场管理
 *
 * @ClassName CfCarParkService
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/3/13/013 11:22
 * @Version 1.0
 **/
public interface CfCarParkService {

    /**
     * 添加停车场
     * @param cfCarPark
     * @return
     */
    public CfCarPark add(CfCarPark cfCarPark);

    /**
     * 删除停车场
     * @param id
     * @return
     */
    public Integer delete(String id) throws Exception;

    /**
     * 更新停车场信息
     * @param cfCarPark
     * @return
     */
    public CfCarPark update(CfCarPark cfCarPark);

    /**
     * 根据条件更新停车场数据
     * @param cfCarPark
     * @param cfCarParkQuery
     * @return
     */
    public Integer updateByQuery(CfCarPark cfCarPark, CfCarParkQuery cfCarParkQuery);

    /**
     * 根据id获取一条停车场数据
     * @param id
     * @return
     */
    public CfCarPark findById(String id);

    /**
     * 根据id获取一条停车场数据
     * @param id
     * @param expectEmpty 是否期望为空
     * @return
     */
    public CfCarPark findById(String id, Boolean expectEmpty);

    /**
     * 根据条件查询停车场数据列表
     * @param conditions example {"字段名":"表别名"}
     * @param allowFiledsMap example {"字段名":"表别名"}
     * @param allowFileds example {"字段名"}
     * @return
     */
    public List<CfCarPark> selectListByCondition(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds);

    /**
     * 根据条件查询停车场数据列表数
     * @param conditions example {"字段名":"表别名"}
     * @param allowFiledsMap example {"字段名":"表别名"}
     * @param allowFileds example {"字段名"}
     * @return
     */
    public Integer selectListByConditionCounts(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds);

    /**
     * 查询附近停车场并返回其距离当前位置的距离(单位米)
     * @param positionX
     * @param positionY
     * @param page  注意此要自己计算好,sql里面并未计算
     * @param limit  注意此要自己计算好,sql里面并未计算
     * @return
     */
    List<CfCarPark> selectNearbyDatas(BigDecimal positionX, BigDecimal positionY, Integer page, Integer limit) throws Exception;

    /**
     * 根据query查询实体条件获取停车场列表
     * @param cfCarParkQuery
     * @return
     */
    List<CfCarPark> getListByQuery(CfCarParkQuery cfCarParkQuery);

    /**
     * 根据query实体获取mybatis的Example
     * @param cfCarParkQuery
     * @return
     */
    CfCarParkExample getExampleByQuery(CfCarParkQuery cfCarParkQuery);

    List<CfCarPark> selectContalDistanceListByQuery(CfCarParkQuery cfCarParkQuery);

    /**
     * 根据传入的经纬度(计算距离)和优惠券id查询该优惠券可用的停车场列表
     * @param positionX
     * @param positionY
     * @param couponId
     * @return
     */
    List<CfCarPark> selectContainDistanceListByCouponId(BigDecimal positionX, BigDecimal positionY, String couponId);

    /**
     * 获取某个用户名下的停车场
     * @param uid
     * @param page
     * @param size
     * @return
     */
    List<CfCarPark> getListByLinkerUser(String uid, Integer page, Integer size);

    /**
     * 获取停车场报表
     * @param cfOrderQuery
     * @return
     */
    CfCarParkFinanceReport getCarParkFinanceReportList(CfOrderQuery cfOrderQuery) throws Exception;

    /**
     * 获取停车场汇总报表
     * @param cfOrderQuery
     * @return
     */
    CfCarParkFinanceReport getCarParkTotalFinanceReport(CfOrderQuery cfOrderQuery) throws Exception;

    /**
     * 更新已用车位数
     * @param carParkId
     * @param changeValue
     * @return
     */
    Integer updateUsedParkingSpaceNumber(String carParkId, Integer changeValue);

    /**
     * 维护历史账单
     * @param totalCarParkFinanceReport
     * @param ShopId
     */
    void updateHistoryOrder(CfCarParkFinanceReport totalCarParkFinanceReport, String ShopId);

    /**
     * 统计某个字段
     * @param cfCarParkQuery
     * @return
     */
    Long countByField(CfCarParkQuery cfCarParkQuery);
}
