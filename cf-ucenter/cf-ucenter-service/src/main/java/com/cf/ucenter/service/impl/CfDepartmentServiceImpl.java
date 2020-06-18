package com.cf.ucenter.service.impl;

import com.cf.framework.utils.IdWorker;
import com.cf.ucenter.dao.mapper.CfDepartmentMapper;
import com.cf.ucenter.domain.CfDepartment;
import com.cf.ucenter.domain.CfDepartmentExample;
import com.cf.ucenter.service.CfDepartmentService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 部门管理
 *
 * @ClassName CfDepartmentServiceImpl
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/4/7/007 16:49
 * @Version 1.0
 **/
@Service(version = "1.0.0")
@Transactional
public class CfDepartmentServiceImpl implements CfDepartmentService {

    @Autowired
    private CfDepartmentMapper cfDepartmentMapper;
    @Autowired
    private IdWorker idWorker;

    @Override
    public List<CfDepartment> list() {
        return cfDepartmentMapper.selectByExample(new CfDepartmentExample());
    }

    @Override
    public CfDepartment add(CfDepartment cfDepartment) {
        cfDepartment.setId(idWorker.nextId());
        Integer effectRows = cfDepartmentMapper.insert(cfDepartment);
        if(effectRows>0){
            return cfDepartment;
        }
        return null;
    }

    @Override
    public CfDepartment update(CfDepartment cfDepartment) {
        Integer effectRows = cfDepartmentMapper.updateByPrimaryKey(cfDepartment);
        if(effectRows>0){
            return cfDepartment;
        }
        return null;
    }

    @Override
    public Integer delete(String id) {
        return cfDepartmentMapper.deleteByPrimaryKey(id);
    }
}
