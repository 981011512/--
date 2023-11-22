package com.cf.ucenter.service.impl;

import com.cf.framework.utils.IdWorker;
import com.cf.ucenter.dao.mapper.CfRoleAuthMapper;
import com.cf.ucenter.domain.CfRoleAuth;
import com.cf.ucenter.domain.CfRoleAuthExample;
import com.cf.ucenter.request.CfRoleAuthQuery;
import com.cf.ucenter.service.CfRoleAuthService;
import com.github.pagehelper.PageHelper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 角色权限管理
 *
 * @ClassName CfRoleAuthServiceImpl
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2022/10/6/006 15:15
 * @Version 1.0
 **/
@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfRoleAuthServiceImpl implements CfRoleAuthService {

    @Autowired
    private CfRoleAuthMapper cfRoleAuthMapper;
    @Autowired
    private IdWorker idWorker;


    @Override
    public CfRoleAuth add(CfRoleAuth cfRoleAuth) {
        cfRoleAuth.setId(idWorker.nextId());
        cfRoleAuthMapper.insert(cfRoleAuth);
        return cfRoleAuth;
    }

    @Override
    public CfRoleAuth update(CfRoleAuth cfRoleAuth) {
        cfRoleAuthMapper.updateByPrimaryKey(cfRoleAuth);
        return cfRoleAuth;
    }

    @Override
    public Integer delete(String id) {
        return cfRoleAuthMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer deleteByQuery(CfRoleAuthQuery cfRoleAuthQuery) {
        return cfRoleAuthMapper.deleteByExample(getExampleByQuery(cfRoleAuthQuery));
    }

    @Override
    public CfRoleAuthExample getExampleByQuery(CfRoleAuthQuery cfRoleAuthQuery) {

        CfRoleAuthExample cfRoleAuthExample = new CfRoleAuthExample();
        CfRoleAuthExample.Criteria criteria = cfRoleAuthExample.createCriteria();

        if(cfRoleAuthQuery.getAuthId()!=null){
            criteria.andAuthIdEqualTo(cfRoleAuthQuery.getAuthId());
        }
        if(cfRoleAuthQuery.getRoleId()!=null){
            criteria.andRoleIdEqualTo(cfRoleAuthQuery.getRoleId());
        }

        if(cfRoleAuthQuery.getPage()!=null && cfRoleAuthQuery.getSize()!=null){
            PageHelper.startPage(cfRoleAuthQuery.getPage(), cfRoleAuthQuery.getSize());
        }

        return cfRoleAuthExample;
    }

    @Override
    public List<CfRoleAuth> getListByQuery(CfRoleAuthQuery cfRoleAuthQuery) {
        return cfRoleAuthMapper.selectByExample(getExampleByQuery(cfRoleAuthQuery));
    }

    @Override
    public Integer countByQuery(CfRoleAuthQuery cfRoleAuthQuery) {
        return cfRoleAuthMapper.countByExample(getExampleByQuery(cfRoleAuthQuery));
    }
}
