package com.cf.ucenter.service.impl;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.IdWorker;
import com.cf.ucenter.dao.mapper.CfThirdPartyLoginMapper;
import com.cf.ucenter.domain.CfThirdPartyLogin;
import com.cf.ucenter.domain.CfThirdPartyLoginExample;
import com.cf.ucenter.request.CfThirdPartyLoginQuery;
import com.cf.ucenter.service.CfThirdPartyLoginService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfThirdPartyLoginServiceImpl implements CfThirdPartyLoginService {

    @Autowired
    private IdWorker idWorker;
    @Autowired
    private CfThirdPartyLoginMapper cfThirdPartyLoginMapper;

    @Override
    public CfThirdPartyLogin add(CfThirdPartyLogin cfThirdPartyLogin) {
        cfThirdPartyLogin.setId(idWorker.nextId());
        cfThirdPartyLogin.setCreateTime(System.currentTimeMillis());
        cfThirdPartyLoginMapper.insert(cfThirdPartyLogin);
        return cfThirdPartyLogin;
    }

    @Override
    public CfThirdPartyLogin update(CfThirdPartyLogin cfThirdPartyLogin) {
        cfThirdPartyLoginMapper.updateByPrimaryKey(cfThirdPartyLogin);
        return cfThirdPartyLogin;
    }

    @Override
    public Integer updateByQuery(CfThirdPartyLogin cfThirdPartyLogin, CfThirdPartyLoginQuery cfThirdPartyLoginQuery) {
        return cfThirdPartyLoginMapper.updateByExampleSelective(cfThirdPartyLogin, getExampleByQuery(cfThirdPartyLoginQuery));
    }

    @Override
    public Integer delete(String id) {
        return cfThirdPartyLoginMapper.deleteByPrimaryKey(id);
    }

    @Override
    public CfThirdPartyLogin findById(String id) {
        return cfThirdPartyLoginMapper.selectByPrimaryKey(id);
    }

    @Override
    public CfThirdPartyLogin findById(String id, boolean expectEmpty) {
        CfThirdPartyLogin cfThirdPartyLogin = findById(id);
        if(expectEmpty && cfThirdPartyLogin!=null){
            ExceptionCast.cast(CommonCode.DUPLICATE_DATA);
        }
        if(!expectEmpty && cfThirdPartyLogin==null){
            ExceptionCast.cast(CommonCode.NO_MORE_DATAS);
        }
        return cfThirdPartyLogin;
    }

    @Override
    public CfThirdPartyLoginExample getExampleByQuery(CfThirdPartyLoginQuery cfThirdPartyLoginQuery) {
        CfThirdPartyLoginExample cfThirdPartyLoginExample = new CfThirdPartyLoginExample();
        CfThirdPartyLoginExample.Criteria criteria = cfThirdPartyLoginExample.createCriteria();
        if(StringUtils.isNotEmpty(cfThirdPartyLoginQuery.getUid())){
            criteria.andUidEqualTo(cfThirdPartyLoginQuery.getUid());
        }
        if(StringUtils.isNotEmpty(cfThirdPartyLoginQuery.getAppid())){
            criteria.andAppidEqualTo(cfThirdPartyLoginQuery.getAppid());
        }
        if(StringUtils.isNotEmpty(cfThirdPartyLoginQuery.getOpenid())){
            criteria.andOpenidEqualTo(cfThirdPartyLoginQuery.getOpenid());
        }
        if(StringUtils.isNotEmpty(cfThirdPartyLoginQuery.getUnionid())){
            criteria.andUnionidEqualTo(cfThirdPartyLoginQuery.getUnionid());
        }
        if(StringUtils.isNotEmpty(cfThirdPartyLoginQuery.getPlatform())){
            criteria.andPlatformEqualTo(cfThirdPartyLoginQuery.getPlatform());
        }
        if(StringUtils.isNotEmpty(cfThirdPartyLoginQuery.getMainBodyId())){
            criteria.andMainBodyIdEqualTo(cfThirdPartyLoginQuery.getMainBodyId());
        }
        if(cfThirdPartyLoginQuery.getMinCreateTime()!=null){
            criteria.andCreateTimeGreaterThanOrEqualTo(cfThirdPartyLoginQuery.getMinCreateTime());
        }
        if(cfThirdPartyLoginQuery.getMaxCreateTime()!=null){
            criteria.andCreateTimeLessThanOrEqualTo(cfThirdPartyLoginQuery.getMaxCreateTime());
        }
        if(StringUtils.isNotEmpty(cfThirdPartyLoginQuery.getOrderBy())){
            cfThirdPartyLoginExample.setOrderByClause(cfThirdPartyLoginQuery.getOrderBy());
        }
        if(cfThirdPartyLoginQuery.getPage()!=null && cfThirdPartyLoginQuery.getSize()!=null){
            PageHelper.startPage(cfThirdPartyLoginQuery.getPage(), cfThirdPartyLoginQuery.getSize());
        }
        return cfThirdPartyLoginExample;
    }

    @Override
    public List<CfThirdPartyLogin> getListByQuery(CfThirdPartyLoginQuery cfThirdPartyLoginQuery) {
        return cfThirdPartyLoginMapper.selectByExample(getExampleByQuery(cfThirdPartyLoginQuery));
    }

    @Override
    public Integer countByQuery(CfThirdPartyLoginQuery cfThirdPartyLoginQuery) {
        cfThirdPartyLoginQuery.setPage(null);
        return cfThirdPartyLoginMapper.countByExample(getExampleByQuery(cfThirdPartyLoginQuery));
    }
}
