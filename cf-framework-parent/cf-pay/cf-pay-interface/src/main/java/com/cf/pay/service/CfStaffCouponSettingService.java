package com.cf.pay.service;

import com.cf.pay.domain.CfStaffCouponSetting;
import com.cf.pay.domain.CfStaffCouponSettingExample;
import com.cf.pay.domain.request.CfStaffCouponSettingQuery;

import java.util.List;

public interface CfStaffCouponSettingService {

    CfStaffCouponSetting add(CfStaffCouponSetting cfStaffCouponSetting);

    Integer batchAdd(List<CfStaffCouponSetting> cfStaffCouponSettingList);

    /**
     * 雇主添加员工活动优惠券发放设置
     * @param employerId    雇主id
     * @param cfStaffCouponSetting
     * @return
     */
    CfStaffCouponSetting employerAddStaffCouponSetting(String employerId, CfStaffCouponSetting cfStaffCouponSetting);

    CfStaffCouponSetting update(CfStaffCouponSetting cfStaffCouponSetting);

    /**
     * 雇主更新员工活动优惠券发放设置
     * @param employerId    雇主id
     * @param cfStaffCouponSetting
     * @return
     */
    CfStaffCouponSetting employerUpdateStaffCouponSetting(String employerId, CfStaffCouponSetting cfStaffCouponSetting);

    Integer delete(String id);

    /**
     * 根据query条件删除数据
     * @param cfStaffCouponSettingQuery
     * @return
     */
    Integer deleteByQuery(CfStaffCouponSettingQuery cfStaffCouponSettingQuery);

    CfStaffCouponSetting findById(String id);

    CfStaffCouponSettingExample getExampleByQuery(CfStaffCouponSettingQuery cfStaffCouponSettingQuery);

    List<CfStaffCouponSetting> getListByQuery(CfStaffCouponSettingQuery cfStaffCouponSettingQuery);

    Integer countByQuery(CfStaffCouponSettingQuery cfStaffCouponSettingQuery);

}
