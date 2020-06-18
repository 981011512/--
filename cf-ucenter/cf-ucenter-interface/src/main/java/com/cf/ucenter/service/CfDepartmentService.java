package com.cf.ucenter.service;

import com.cf.ucenter.domain.CfDepartment;

import java.util.List;

/**
 * 部门管理
 *
 * @ClassName CfDepartmentService
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/4/7/007 16:48
 * @Version 1.0
 **/
public interface CfDepartmentService {
    /**
     * 获取部门列表
     * @return
     */
    List<CfDepartment> list();

    /**
     * 添加部门
     * @param cfDepartment
     * @return
     */
    CfDepartment add(CfDepartment cfDepartment);

    /**
     * 更新部门
     * @param cfDepartment
     * @return
     */
    CfDepartment update(CfDepartment cfDepartment);

    /**
     * 删除部门
     * @param id
     * @return
     */
    Integer delete(String id);
}
