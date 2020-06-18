package com.cf.ucenter.service;

import com.cf.ucenter.domain.CfRole;
import com.cf.ucenter.domain.CfRoleAuth;
import com.cf.ucenter.domain.CfUserRole;
import com.cf.ucenter.request.CfRoleForm;

import java.util.List;

/**
 * 角色管理
 *
 * @ClassName CfUserRoleService
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/4/6/006 14:57
 * @Version 1.0
 **/
public interface CfUserRoleService {

    /**
     * 删除指定用户的所有角色
     * @param uid
     * @return
     */
    public Integer deleteUserRoles(String uid);

    /**
     * 根据角色id删除用户角色表中的数据
     * @param roleId
     * @return
     */
    Integer deleteUserRoleByRoleId(String roleId);

    /**
     * 添加用户角色(批量添加)
     * @param cfUserRoles
     * @return
     */
    public Integer addCfUserRoles(List<CfUserRole> cfUserRoles);

    /**
     * 刷新用户角色(先全部删除后再添加)
     * @param cfUserRoles
     * @return
     */
    public List<CfUserRole> flushUserRoles(List<CfUserRole> cfUserRoles);
}
