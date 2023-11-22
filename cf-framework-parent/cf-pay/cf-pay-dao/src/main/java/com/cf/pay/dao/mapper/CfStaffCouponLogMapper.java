package com.cf.pay.dao.mapper;

import com.cf.pay.domain.CfStaffCouponLog;
import com.cf.pay.domain.CfStaffCouponLogExample;
import com.cf.pay.domain.request.CfStaffCouponLogQuery;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface CfStaffCouponLogMapper {
    int countByExample(CfStaffCouponLogExample example);

    int deleteByExample(CfStaffCouponLogExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfStaffCouponLog record);

    int insertSelective(CfStaffCouponLog record);

    List<CfStaffCouponLog> selectByExample(CfStaffCouponLogExample example);

    CfStaffCouponLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfStaffCouponLog record, @Param("example") CfStaffCouponLogExample example);

    int updateByExample(@Param("record") CfStaffCouponLog record, @Param("example") CfStaffCouponLogExample example);

    int updateByPrimaryKeySelective(CfStaffCouponLog record);

    int updateByPrimaryKey(CfStaffCouponLog record);

    List<CfStaffCouponLog> selectByQuery(CfStaffCouponLogQuery cfStaffCouponLogQuery);

    /**
     * 统计某个用户在指定活动，时间中的发券额度
     * @param cfStaffCouponLogQuery
     * @return
     */
    BigDecimal countDenominationByQuery(CfStaffCouponLogQuery cfStaffCouponLogQuery);
}