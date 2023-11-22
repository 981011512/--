package com.cf.ucenter.service;

import com.cf.ucenter.domain.CfStaff;
import com.cf.ucenter.domain.CfStaffExample;
import com.cf.ucenter.request.CfStaffQuery;

import java.util.List;

public interface CfStaffService {

    CfStaff add(CfStaff cfStaff);

    CfStaff update(CfStaff cfStaff);

    Integer delete(String id);

    CfStaffExample getExampleByQuery(CfStaffQuery cfStaffQuery);

    List<CfStaff> getListByQuery(CfStaffQuery cfStaffQuery);

    /**
     * 根据Query条件原生SQL查询
     * @param cfStaffQuery
     * @return
     */
    List<CfStaff> selectByQuery(CfStaffQuery cfStaffQuery);

    /**
     * 根据Query条件原生SQL查询，同时包含员工发券统计
     * @param cfStaffQuery
     * @return
     */
    List<CfStaff> selectByQueryContainCouponCount(CfStaffQuery cfStaffQuery);

    Integer countByQuery(CfStaffQuery cfStaffQuery);

    /**
     * 雇主删除员工
     * @param employerId
     * @param id
     * @return
     */
    CfStaff employerDeleteStaff(String employerId, String id);

    /**
     * 雇主更新员工
     * @param cfStaff
     * @return
     */
    CfStaff employerUpdateStaff(CfStaff cfStaff);

    /**
     * 雇主添加员工
     * @param cfStaff
     * @return
     */
    CfStaff employerAddStaff(CfStaff cfStaff);

    /**
     * 通过雇主id和员工id判断该雇主是否雇佣了该员工
     * @param employerId
     * @param staffId
     * @param exceptionScene 抛出异常的场景(传yes：当有数据时会抛出该员工已经存在异常,传no当没有数据时会
     *                       抛出该员工不存在异常，传其他值无论有无数据都不会抛出异常)
     * @return
     */
    CfStaff checkStaffExistByEmployerIdAndStaffId(String employerId, String staffId, String exceptionScene);

}
