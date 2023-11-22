package com.cf.ucenter.service;

import com.cf.ucenter.domain.CfWeixinConfig;
import com.cf.ucenter.domain.CfWeixinConfigExample;
import com.cf.ucenter.request.CfWeixinConfigQuery;
import com.cf.ucenter.request.UnlimitedForm;

import java.util.List;

public interface CfWeixinConfigService {

    CfWeixinConfig add(CfWeixinConfig cfWeixinConfig);

    Integer delete(String id);

    CfWeixinConfig update(CfWeixinConfig cfWeixinConfig);

    CfWeixinConfig findById(String id);

    CfWeixinConfig findById(String id, Boolean expectEmpty);

    CfWeixinConfigExample getExampleByQuery(CfWeixinConfigQuery cfWeixinConfigQuery);

    List<CfWeixinConfig> getListByQuery(CfWeixinConfigQuery cfWeixinConfigQuery);

    Integer countByQuery(CfWeixinConfigQuery cfWeixinConfigQuery);



    /**
     * 获取AccessToken
     * @param scenes 请传(h5-网页/mp-小程序/app-手机应用)
     * @param weixinAppId
     * @param appSecret
     * @return
     */
    String getAccessToken(String scenes, String weixinAppId, String appSecret) throws Exception;

    /**
     * 获取海康AccessToken
     * @param scenes  例如 hk
     * @param appKey
     * @param appSecret
     * @return
     * @throws Exception
     */
    String getHKAccessToken(String scenes, String appKey, String appSecret) throws Exception;

    /**
     * 向微信请求accessToken
     * @param weixinAppId
     * @param appSecret
     * @return
     * @throws Exception
     */
    String httpAccessToken(String weixinAppId, String appSecret) throws Exception;

    /**
     * 获取微信配置
     * @param scenes 场景
     * @return
     */
    List<CfWeixinConfig> getWeiXinLoginConfigragtion(String scenes);

    /**
     * 获取微信小程序二维码
     * @param unlimitedForm
     * @return
     * @throws Exception
     */
    Object getUnlimited(UnlimitedForm unlimitedForm) throws Exception;

    /**
     * 返回获取ip的url地址
     * @return
     */
    String returnGetIpUrl();

}
