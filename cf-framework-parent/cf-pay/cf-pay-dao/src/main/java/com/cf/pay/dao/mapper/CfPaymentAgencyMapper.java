package com.cf.pay.dao.mapper;

import com.cf.pay.domain.CfPaymentAgency;
import com.cf.pay.domain.CfPaymentAgencyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfPaymentAgencyMapper {
    int countByExample(CfPaymentAgencyExample example);

    int deleteByExample(CfPaymentAgencyExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfPaymentAgency record);

    int insertSelective(CfPaymentAgency record);

    List<CfPaymentAgency> selectByExample(CfPaymentAgencyExample example);

    CfPaymentAgency selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfPaymentAgency record, @Param("example") CfPaymentAgencyExample example);

    int updateByExample(@Param("record") CfPaymentAgency record, @Param("example") CfPaymentAgencyExample example);

    int updateByPrimaryKeySelective(CfPaymentAgency record);

    int updateByPrimaryKey(CfPaymentAgency record);

    /**
     * 获取指定停车场的支付方式(机构)列表
     * @param carParkId
     * @param useScenes
     * @return
     */
    public List<CfPaymentAgency> getPaymentAgencyListByCarParkId(@Param("carParkId")String carParkId, @Param("useScenes") String useScenes);

    /**
     * 根据条件查询支付机构数据列表
     * @param conditions
     * @return
     */
    List<CfPaymentAgency> selectListByCondition(String conditions);

    /**
     * 根据条件查询支付机构数据列表数
     * @param conditions
     * @return
     */
    Integer selectListByConditionCounts(String conditions);
}