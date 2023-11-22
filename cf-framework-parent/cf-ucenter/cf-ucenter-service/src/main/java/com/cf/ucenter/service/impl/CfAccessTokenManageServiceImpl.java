package com.cf.ucenter.service.impl;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.IdWorker;
import com.cf.ucenter.dao.mapper.CfAccessTokenManageMapper;
import com.cf.ucenter.domain.CfAccessTokenManage;
import com.cf.ucenter.domain.CfAccessTokenManageExample;
import com.cf.ucenter.domain.CfThirdPartyPlatformApplication;
import com.cf.ucenter.domain.CfWeixinConfig;
import com.cf.ucenter.request.CfAccessTokenManageQuery;
import com.cf.ucenter.request.CfThirdPartyPlatformApplicationQuery;
import com.cf.ucenter.request.CfWeixinConfigQuery;
import com.cf.ucenter.service.CfAccessTokenManageService;
import com.cf.ucenter.service.CfThirdPartyPlatformApplicationService;
import com.cf.ucenter.service.CfWeixinConfigService;
import com.cf.ucenter.type.ThirdPartyPlatformType;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfAccessTokenManageServiceImpl implements CfAccessTokenManageService {

    @Autowired
    private CfAccessTokenManageMapper cfAccessTokenManageMapper;
    @Autowired
    private CfThirdPartyPlatformApplicationService cfThirdPartyPlatformApplicationService;
    @Autowired
    private CfWeixinConfigService cfWeixinConfigService;
    @Autowired
    private IdWorker idWorker;


    @Override
    public CfAccessTokenManage add(CfAccessTokenManage cfAccessTokenManage) {
        cfAccessTokenManage.setId(idWorker.nextLongId());
        cfAccessTokenManageMapper.insertSelective(cfAccessTokenManage);
        return cfAccessTokenManage;
    }

    @Override
    public CfAccessTokenManage update(CfAccessTokenManage cfAccessTokenManage) {
        cfAccessTokenManageMapper.updateByPrimaryKeySelective(cfAccessTokenManage);
        return cfAccessTokenManage;
    }

    @Override
    public Integer delete(Long id) {
        return cfAccessTokenManageMapper.deleteByPrimaryKey(id);
    }

    @Override
    public CfAccessTokenManage findById(Long id) {
        return cfAccessTokenManageMapper.selectByPrimaryKey(id);
    }

    @Override
    public CfAccessTokenManage findById(Long id, boolean expectEmpty) {
        CfAccessTokenManage cfAccessTokenManage = findById(id);
        if(expectEmpty && cfAccessTokenManage!=null){
            ExceptionCast.cast(CommonCode.DUPLICATE_DATA);
        }
        if(!expectEmpty && cfAccessTokenManage==null){
            ExceptionCast.cast(CommonCode.NO_MORE_DATAS);
        }
        return cfAccessTokenManage;
    }

    @Override
    public List<CfAccessTokenManage> getListByQuery(CfAccessTokenManageQuery cfAccessTokenManageQuery) {
        return cfAccessTokenManageMapper.selectByExample(getExampleByQuery(cfAccessTokenManageQuery));
    }

    @Override
    public Integer countByQuery(CfAccessTokenManageQuery cfAccessTokenManageQuery) {
        cfAccessTokenManageQuery.setPage(null);
        return cfAccessTokenManageMapper.countByExample(getExampleByQuery(cfAccessTokenManageQuery));
    }

    @Override
    public CfAccessTokenManageExample getExampleByQuery(CfAccessTokenManageQuery cfAccessTokenManageQuery) {
        CfAccessTokenManageExample cfAccessTokenManageExample = new CfAccessTokenManageExample();
        CfAccessTokenManageExample.Criteria criteria = cfAccessTokenManageExample.createCriteria();
        if(cfAccessTokenManageQuery.getAppid()!=null){
            criteria.andAppidEqualTo(cfAccessTokenManageQuery.getAppid());
        }
        if(cfAccessTokenManageQuery.getApplicationScenes()!=null){
            criteria.andApplicationScenesEqualTo(cfAccessTokenManageQuery.getApplicationScenes());
        }
        if(StringUtils.isNotEmpty(cfAccessTokenManageQuery.getOrderBy())){
            cfAccessTokenManageExample.setOrderByClause(cfAccessTokenManageQuery.getOrderBy());
        }
        if(cfAccessTokenManageQuery.getPage()!=null && cfAccessTokenManageQuery.getSize()!=null){
            PageHelper.startPage(cfAccessTokenManageQuery.getPage(), cfAccessTokenManageQuery.getSize());
        }
        return cfAccessTokenManageExample;
    }

    @Override
    public String getWeiXinAccessToken(String applicationScenes, String weixinAppId) throws Exception {
        CfThirdPartyPlatformApplication cfThirdPartyPlatformApplication = maintainWeiXinAccessToken(applicationScenes, weixinAppId);
        return cfThirdPartyPlatformApplication.getTokenValue();
    }

    @Override
    public CfThirdPartyPlatformApplication maintainWeiXinAccessToken(String applicationScenes, String weixinAppId) throws Exception {
        CfAccessTokenManageQuery cfAccessTokenManageQuery = new CfAccessTokenManageQuery();
        cfAccessTokenManageQuery.setAppid(weixinAppId);
        cfAccessTokenManageQuery.setApplicationScenes(applicationScenes);
        List<CfAccessTokenManage> cfAccessTokenManageList = getListByQuery(cfAccessTokenManageQuery);

        //获取微信配置
        CfThirdPartyPlatformApplication cfThirdPartyPlatformApplication = cfThirdPartyPlatformApplicationService.findByAppId(weixinAppId, false);

        String accessToken = null;
        if(cfAccessTokenManageList==null || cfAccessTokenManageList.size()==0){
            accessToken = cfWeixinConfigService.httpAccessToken(weixinAppId, cfThirdPartyPlatformApplication.getPublicKey());
            CfAccessTokenManage cfAccessTokenManage = new CfAccessTokenManage();
            switch (applicationScenes){
                case ThirdPartyPlatformType.WX_WB:
                    cfAccessTokenManage.setTokenNotes("微信公众号accessToken");
                    break;
                case ThirdPartyPlatformType.WX_MP:
                    cfAccessTokenManage.setTokenNotes("微信小程序accessToken");
                    break;
                case ThirdPartyPlatformType.WX_APP:
                    cfAccessTokenManage.setTokenNotes("微信APP应用accessToken");
                    break;
                default:
                    throw new Exception("applicationScenes not supoort !");
            }
            cfAccessTokenManage.setAppid(weixinAppId);
            cfAccessTokenManage.setApplicationScenes(applicationScenes);
            cfAccessTokenManage.setTokenValue(accessToken);
            cfAccessTokenManage.setExpiredTime(System.currentTimeMillis()+7200000);
            add(cfAccessTokenManage);
        }else if(cfAccessTokenManageList.get(0).getExpiredTime()+300000<System.currentTimeMillis()){
            accessToken = cfWeixinConfigService.httpAccessToken(weixinAppId, cfThirdPartyPlatformApplication.getPublicKey());
            cfAccessTokenManageList.get(0).setTokenValue(accessToken);
            cfAccessTokenManageList.get(0).setExpiredTime(System.currentTimeMillis()+7200000);
            update(cfAccessTokenManageList.get(0));
        }else{
            accessToken = cfAccessTokenManageList.get(0).getTokenValue();
        }
        cfThirdPartyPlatformApplication.setTokenValue(accessToken);
        return cfThirdPartyPlatformApplication;
    }
}
