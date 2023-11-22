package com.cf.pay.dao.mapper;

import com.cf.pay.domain.CfStaffCouponSetting;
import com.cf.pay.domain.CfStaffCouponSettingExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfStaffCouponSettingMapper {
    int countByExample(CfStaffCouponSettingExample example);

    int deleteByExample(CfStaffCouponSettingExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfStaffCouponSetting record);

    int insertSelective(CfStaffCouponSetting record);

    List<CfStaffCouponSetting> selectByExample(CfStaffCouponSettingExample example);

    CfStaffCouponSetting selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfStaffCouponSetting record, @Param("example") CfStaffCouponSettingExample example);

    int updateByExample(@Param("record") CfStaffCouponSetting record, @Param("example") CfStaffCouponSettingExample example);

    int updateByPrimaryKeySelective(CfStaffCouponSetting record);

    int updateByPrimaryKey(CfStaffCouponSetting record);

    int batchAdd(List<CfStaffCouponSetting> cfStaffCouponSettingList);
}