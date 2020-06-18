package com.cf.ucenter.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.IdWorker;
import com.cf.ucenter.dao.mapper.CfRoleAuthMapper;
import com.cf.ucenter.dao.mapper.CfRoleMapper;
import com.cf.ucenter.domain.CfRole;
import com.cf.ucenter.domain.CfRoleAuth;
import com.cf.ucenter.domain.CfRoleAuthExample;
import com.cf.ucenter.domain.CfRoleExample;
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
import java.util.Map;

/**
 * 角色管理
 *
 * @ClassName CfRoleServiceImpl
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/4/6/006 15:15
 * @Version 1.0
 **/
@Service(version = "1.0.0")
@Transactional
public class CfRoleServiceImpl implements CfRoleService {

    @Autowired
    private CfRoleMapper cfRoleMapper;
    @Autowired
    private CfRoleAuthMapper cfRoleAuthMapper;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private CfUserRoleService cfUserRoleService;

    @Override
    public List<CfRole> list() {
        return cfRoleMapper.selectByExample(new CfRoleExample());
    }

    @Override
    public CfRole add(CfRole cfRole) {
        cfRole.setId(idWorker.nextId());
        Integer effectRows = cfRoleMapper.insert(cfRole);
        if(effectRows>0){
            return cfRole;
        }
        return null;
    }

    @Override
    public CfRole update(CfRoleForm cfRoleForm) {
        CfRole cfRole = new CfRole();
        BeanUtils.copyProperties(cfRoleForm, cfRole);
        if(cfRole.getIcon()==null){
            cfRole.setIcon("");
        }
        Integer effectRows = cfRoleMapper.updateByPrimaryKey(cfRole);
        if(effectRows==0){
            return null;
        }
        if(StringUtils.isNotEmpty(cfRoleForm.getAuthIds())){
            ArrayList<CfRoleAuth> cfRoleAuths = new ArrayList<>();
            String[] authIds = cfRoleForm.getAuthIds().split(",");
            for(String authId: authIds){
                CfRoleAuth cfRoleAuth = new CfRoleAuth();
                cfRoleAuth.setId(idWorker.nextId());
                cfRoleAuth.setAuthId(authId);
                cfRoleAuth.setRoleId(cfRoleForm.getId());
                cfRoleAuths.add(cfRoleAuth);
            }
            updateRoleAuth(cfRoleAuths, cfRoleForm.getId());
        }
        return cfRole;
    }

    @Override
    public Integer delete(String id) {
        int i = cfRoleMapper.deleteByPrimaryKey(id);
        deleteRoleAuthByRoleId(id);
        cfUserRoleService.deleteUserRoleByRoleId(id);
        return i;
    }

    @Override
    public Integer deleteRoleAuthByRoleId(String roleId) {
        CfRoleAuthExample cfRoleAuthExample = new CfRoleAuthExample();
        CfRoleAuthExample.Criteria criteria = cfRoleAuthExample.createCriteria();
        criteria.andRoleIdEqualTo(roleId);
        return cfRoleAuthMapper.deleteByExample(cfRoleAuthExample);
    }

    @Override
    public Integer updateRoleAuth(List<CfRoleAuth> cfRoleAuths, String roleId) {
        deleteRoleAuthByRoleId(roleId);
        Integer effectRows = 0;
        if(cfRoleAuths!=null && cfRoleAuths.size()>0){
            effectRows = cfRoleAuthMapper.batchInsert(cfRoleAuths);
            if(effectRows<cfRoleAuths.size()){
                ExceptionCast.cast(CommonCode.FAIL);
            }
        }
        return effectRows;
    }

    @Override
    public List<CfRole> getRolesByUid(String uid) {
        return cfRoleMapper.selectContainDepartmentByUid(uid);
    }
}
