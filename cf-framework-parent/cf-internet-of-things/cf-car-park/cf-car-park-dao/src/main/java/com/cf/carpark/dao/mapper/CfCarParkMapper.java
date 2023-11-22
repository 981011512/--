package com.cf.carpark.dao.mapper;

import com.cf.carpark.domain.CfCarPark;
import com.cf.carpark.domain.CfCarParkExample;
import com.cf.carpark.domain.CfCarParkFinanceReport;
import com.cf.carpark.domain.request.CfCarParkQuery;
import com.cf.carpark.domain.request.CfCarParkUseLogQuery;
import com.cf.pay.domain.request.CfOrderQuery;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface CfCarParkMapper {
    int countByExample(CfCarParkExample example);

    int deleteByExample(CfCarParkExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfCarPark record);

    int insertSelective(CfCarPark record);

    List<CfCarPark> selectByExample(CfCarParkExample example);

    CfCarPark selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfCarPark record, @Param("example") CfCarParkExample example);

    int updateByExample(@Param("record") CfCarPark record, @Param("example") CfCarParkExample example);

    int updateByPrimaryKeySelective(CfCarPark record);

    int updateByPrimaryKey(CfCarPark record);

    /**
     * 根据条件查询停车场数据列表
     * @param conditions
     * @return
     */
    List<CfCarPark> selectListByCondition(String conditions);

    /**
     * 根据条件查询停车场数据列表数
     * @param conditions
     * @return
     */
    Integer selectListByConditionCounts(String conditions);

    /**
     * 查询附近停车场并返回其距离当前位置的距离(单位米)
     * @param positionX
     * @param positionY
     * @param page
     * @param limit
     * @return
     */
    List<CfCarPark> selectNearbyDatas(@Param("positionX") BigDecimal positionX, @Param("positionY") BigDecimal positionY, @Param("page") Integer page,
                                      @Param("limit") Integer limit, @Param("currentHourTime") Long currentHourTime, @Param("currentTimeStamp") Long currentTimeStamp);

    List<CfCarPark> selectContalDistanceListByQuery(CfCarParkQuery cfCarParkQuery);

    /**
     * 根据传入的经纬度(计算距离)和优惠券id查询该优惠券可用的停车场列表
     * @param positionX
     * @param positionY
     * @param couponId
     * @return
     */
    List<CfCarPark> selectContainDistanceListByCouponId(@Param("positionX") BigDecimal positionX, @Param("positionY") BigDecimal positionY, @Param("couponId") String couponId);

    List<CfCarPark> getListByLinkerUser(@Param("uid") String uid,@Param("page")  Integer page,@Param("size")  Integer size);

    /**
     * 获取停车场报表
     * @param cfOrderQuery
     * @return
     */
    Double getCarParkFinanceReport(CfOrderQuery cfOrderQuery);

    /**
     * 更新已用车位数
     * @param carParkId 停车场id
     * @param changeValue   改变的值
     * @return
     */
    Integer updateUsedParkingSpaceNumber(@Param("carParkId") String carParkId,@Param("changeValue")  Integer changeValue);

    /**
     * 统计停车场的某些字段
     * @param cfCarParkQuery
     * @return
     */
    Long countByField(CfCarParkQuery cfCarParkQuery);
}