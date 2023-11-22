package com.cf.pay.dao.mapper;

import com.cf.pay.domain.CarParkPaymentAgency;
import com.cf.pay.domain.CfUserPaymentAgency;
import com.cf.pay.domain.CfUserPaymentAgencyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfUserPaymentAgencyMapper {
    int countByExample(CfUserPaymentAgencyExample example);

    int deleteByExample(CfUserPaymentAgencyExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfUserPaymentAgency record);

    int insertSelective(CfUserPaymentAgency record);

    List<CfUserPaymentAgency> selectByExample(CfUserPaymentAgencyExample example);

    CfUserPaymentAgency selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfUserPaymentAgency record, @Param("example") CfUserPaymentAgencyExample example);

    int updateByExample(@Param("record") CfUserPaymentAgency record, @Param("example") CfUserPaymentAgencyExample example);

    int updateByPrimaryKeySelective(CfUserPaymentAgency record);

    int updateByPrimaryKey(CfUserPaymentAgency record);

    /**
     * 根据条件查询用户支付账户数据列表
     * @param conditions
     * @return
     */
    List<CfUserPaymentAgency> selectListByCondition(String conditions);

    /**
     * 根据条件查询用户支付账户数据列表数
     * @param conditions
     * @return
     */
    Integer selectListByConditionCounts(String conditions);

    /**
     * 根据停车场id和支付机构简称查询支付数据(联停车支付相关表)
     * @param carParkId
     * @param paymentAgencyShortName
     * @return
     */
    List<CfUserPaymentAgency> selectListByCarParkIdAndPaymentAgencyShortName(@Param("carParkId") String carParkId, @Param("paymentAgencyShortName") String paymentAgencyShortName);

    /**
     * 根据停车场和支付场景获取停车场的支付数据
     * @param carParkId
     * @return
     */
    List<CarParkPaymentAgency> findCarParkPaymentAgencyByCarParkIdAndScenes(@Param("carParkId") String carParkId, @Param("useScenes") String useScenes);
}