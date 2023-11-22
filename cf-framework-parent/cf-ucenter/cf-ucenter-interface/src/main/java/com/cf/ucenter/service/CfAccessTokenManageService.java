package com.cf.ucenter.service;

import com.cf.ucenter.domain.CfAccessTokenManage;
import com.cf.ucenter.domain.CfAccessTokenManageExample;
import com.cf.ucenter.domain.CfThirdPartyPlatformApplication;
import com.cf.ucenter.request.CfAccessTokenManageQuery;

import java.util.List;

public interface CfAccessTokenManageService {

    CfAccessTokenManage add(CfAccessTokenManage cfAccessTokenManage);

    CfAccessTokenManage update(CfAccessTokenManage cfAccessTokenManage);

    Integer delete(Long id);

    CfAccessTokenManage findById(Long id);

    CfAccessTokenManage findById(Long id, boolean expectEmpty);

    List<CfAccessTokenManage> getListByQuery(CfAccessTokenManageQuery cfAccessTokenManageQuery);

    Integer countByQuery(CfAccessTokenManageQuery cfAccessTokenManageQuery);

    CfAccessTokenManageExample getExampleByQuery(CfAccessTokenManageQuery cfAccessTokenManageQuery);

    /**
     * 获取微信AccessToken
     * @param applicationScenes 应用场景请传(wx_web-微信公众号/wx_mp-微信小程序/wx_app-微信app)
     * @param weixinAppId
     * @return
     */
    String getWeiXinAccessToken(String applicationScenes, String weixinAppId) throws Exception;

    /**
     * 维护微信AccessToken
     * @param applicationScenes 应用场景请传(wx_web-微信公众号/wx_mp-微信小程序/wx_app-微信app)
     * @param weixinAppId
     * @return
     */
    CfThirdPartyPlatformApplication maintainWeiXinAccessToken(String applicationScenes, String weixinAppId) throws Exception;

}
