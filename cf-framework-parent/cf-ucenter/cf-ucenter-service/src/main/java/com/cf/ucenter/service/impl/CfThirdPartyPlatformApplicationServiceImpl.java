package com.cf.ucenter.service.impl;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.ucenter.dao.mapper.CfThirdPartyPlatformApplicationMapper;
import com.cf.ucenter.domain.CfThirdPartyPlatformApplication;
import com.cf.ucenter.domain.CfThirdPartyPlatformApplicationExample;
import com.cf.ucenter.request.CfThirdPartyPlatformApplicationQuery;
import com.cf.ucenter.service.CfThirdPartyPlatformApplicationService;
import com.github.pagehelper.PageHelper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfThirdPartyPlatformApplicationServiceImpl implements CfThirdPartyPlatformApplicationService {

    @Autowired
    private CfThirdPartyPlatformApplicationMapper cfThirdPartyPlatformApplicationMapper;

    @Override
    public CfThirdPartyPlatformApplication add(CfThirdPartyPlatformApplication cfThirdPartyPlatformApplication) {
        cfThirdPartyPlatformApplicationMapper.insert(cfThirdPartyPlatformApplication);
        return cfThirdPartyPlatformApplication;
    }

    @Override
    public CfThirdPartyPlatformApplication update(CfThirdPartyPlatformApplication cfThirdPartyPlatformApplication) {
        cfThirdPartyPlatformApplicationMapper.updateByPrimaryKey(cfThirdPartyPlatformApplication);
        return cfThirdPartyPlatformApplication;
    }

    @Override
    public Integer delete(String appid) {
        return cfThirdPartyPlatformApplicationMapper.deleteByPrimaryKey(appid);
    }

    @Override
    public CfThirdPartyPlatformApplication findByAppId(String appid) {
        return cfThirdPartyPlatformApplicationMapper.selectByPrimaryKey(appid);
    }

    @Override
    public CfThirdPartyPlatformApplication findByAppId(String appid, boolean expectEmpy) {
        CfThirdPartyPlatformApplication cfThirdPartyPlatformApplication = findByAppId(appid);
        if(expectEmpy && cfThirdPartyPlatformApplication!=null){
            ExceptionCast.cast(CommonCode.DUPLICATE_DATA);
        }
        if(!expectEmpy && cfThirdPartyPlatformApplication==null){
            ExceptionCast.cast(CommonCode.NO_MORE_DATAS);
        }
        return cfThirdPartyPlatformApplication;
    }

    @Override
    public List<CfThirdPartyPlatformApplication> getListByQuery(CfThirdPartyPlatformApplicationQuery cfThirdPartyPlatformApplicationQuery) {
        return cfThirdPartyPlatformApplicationMapper.selectByExample(getExampleByQuery(cfThirdPartyPlatformApplicationQuery));
    }

    @Override
    public Integer countByQuery(CfThirdPartyPlatformApplicationQuery cfThirdPartyPlatformApplicationQuery) {
        cfThirdPartyPlatformApplicationQuery.setPage(null);
        return cfThirdPartyPlatformApplicationMapper.countByExample(getExampleByQuery(cfThirdPartyPlatformApplicationQuery));
    }

    @Override
    public CfThirdPartyPlatformApplicationExample getExampleByQuery(CfThirdPartyPlatformApplicationQuery cfThirdPartyPlatformApplicationQuery) {
        CfThirdPartyPlatformApplicationExample cfThirdPartyPlatformApplicationExample = new CfThirdPartyPlatformApplicationExample();
        if(cfThirdPartyPlatformApplicationQuery.getPage()!=null && cfThirdPartyPlatformApplicationQuery.getSize()!=null){
            PageHelper.startPage(cfThirdPartyPlatformApplicationQuery.getPage(), cfThirdPartyPlatformApplicationQuery.getSize());
        }
        return cfThirdPartyPlatformApplicationExample;
    }
}
