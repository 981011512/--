package com.cf.ucenter.service;

import com.cf.ucenter.domain.CfRole;
import com.cf.ucenter.domain.CfRoleAuth;
import com.cf.ucenter.request.CfRoleForm;

import java.util.List;

/**
 * 角色管理
 *
 * @ClassName CfRoleService
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/4/6/006 14:57
 * @Version 1.0
 **/
public interface CfRoleService {

    /**
     * 获取权限列表
     * @return
     */
    List<CfRole> list();

    /**
     * 添加角色
     * @param cfRole
     * @return
     */
    CfRole add(CfRole cfRole);

    /**
     * 更新角色
     * @param cfRoleForm
     * @return
     */
    CfRole update(CfRoleForm cfRoleForm);

    /**
     * 删除角色
     * @param id
     * @return
     */
    Integer delete(String id);

    /**
     * 删除角色对应的权限
     * @param roleId
     * @return
     */
    Integer deleteRoleAuthByRoleId(String roleId);

    /**
     * 更新角色的权限
     * @param cfRoleAuths
     * @param roleId
     * @return
     */
    Integer updateRoleAuth(List<CfRoleAuth> cfRoleAuths, String roleId);

    /**
     * 获取指定用所拥有的角色
     * @param uid
     * @return
     */
    List<CfRole> getRolesByUid(String uid);
}
