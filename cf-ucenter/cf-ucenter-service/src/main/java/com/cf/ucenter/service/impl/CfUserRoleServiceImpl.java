package com.cf.ucenter.service.impl;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.ucenter.response.RoleCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.IdWorker;
import com.cf.ucenter.dao.mapper.CfRoleAuthMapper;
import com.cf.ucenter.dao.mapper.CfRoleMapper;
import com.cf.ucenter.dao.mapper.CfUserRoleMapper;
import com.cf.ucenter.domain.*;
import com.cf.ucenter.request.CfRoleForm;
import com.cf.ucenter.service.CfRoleService;
import com.cf.ucenter.service.CfUserRoleService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户角色管理
 *
 * @ClassName CfUserRoleServiceImpl
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/4/6/006 15:15
 * @Version 1.0
 **/
@Service(version = "1.0.0")
@Transactional
public class CfUserRoleServiceImpl implements CfUserRoleService {

    @Autowired
    private CfUserRoleMapper cfUserRoleMapper;
    @Autowired
    private IdWorker idWorker;

    @Override
    public Integer deleteUserRoles(String uid) {
        CfUserRoleExample cfUserRoleExample = new CfUserRoleExample();
        CfUserRoleExample.Criteria criteria = cfUserRoleExample.createCriteria();
        criteria.andUidEqualTo(uid);
        return cfUserRoleMapper.deleteByExample(cfUserRoleExample);
    }

    @Override
    public Integer deleteUserRoleByRoleId(String roleId) {
        CfUserRoleExample cfUserRoleExample = new CfUserRoleExample();
        CfUserRoleExample.Criteria criteria = cfUserRoleExample.createCriteria();
        criteria.andRoleIdEqualTo(roleId);
        return cfUserRoleMapper.deleteByExample(cfUserRoleExample);
    }

    @Override
    public Integer addCfUserRoles(List<CfUserRole> cfUserRoles) {
        return cfUserRoleMapper.batchInsert(cfUserRoles);
    }

    @Override
    public List<CfUserRole> flushUserRoles(List<CfUserRole> cfUserRoles) {
        if(cfUserRoles==null || cfUserRoles.size()==0){
            ExceptionCast.cast(RoleCode.HAVE_NOT_USER_ROLES);
        }
        deleteUserRoles(cfUserRoles.get(0).getUid());
        addCfUserRoles(cfUserRoles);
        return cfUserRoles;
    }
}
