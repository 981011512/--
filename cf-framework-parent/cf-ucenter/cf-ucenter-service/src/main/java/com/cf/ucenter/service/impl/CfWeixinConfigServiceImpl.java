package com.cf.ucenter.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.ucenter.response.AuthCode;
import com.cf.framework.domain.ucenter.response.UcenterCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.HttpClient;
import com.cf.framework.utils.IdWorker;
import com.cf.ucenter.dao.mapper.CfWeixinConfigMapper;
import com.cf.ucenter.domain.CfWeixinConfig;
import com.cf.ucenter.domain.CfWeixinConfigExample;
import com.cf.ucenter.request.CfWeixinConfigQuery;
import com.cf.ucenter.request.UnlimitedForm;
import com.cf.ucenter.service.CfAccessTokenManageService;
import com.cf.ucenter.service.CfWeixinConfigService;
import com.cf.ucenter.type.ThirdPartyPlatformType;
import com.cf.ucenter.wxtools.WeiXinConfigUtils;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfWeixinConfigServiceImpl implements CfWeixinConfigService {

    @Value("${cf.getIpUrl}")
    private String getIpUrl;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private CfWeixinConfigMapper cfWeixinConfigMapper;
    @Autowired
    private CfAccessTokenManageService cfAccessTokenManageService;


    @Override
    public CfWeixinConfig add(CfWeixinConfig cfWeixinConfig) {
        cfWeixinConfig.setId(idWorker.nextId());
        cfWeixinConfig.setCreateTime(System.currentTimeMillis());
        cfWeixinConfig.setUpdateTime(System.currentTimeMillis());
        cfWeixinConfigMapper.insert(cfWeixinConfig);
        return cfWeixinConfig;
    }

    @Override
    public Integer delete(String id) {
        return cfWeixinConfigMapper.deleteByPrimaryKey(id);
    }

    @Override
    public CfWeixinConfig update(CfWeixinConfig cfWeixinConfig) {
        cfWeixinConfig.setUpdateTime(System.currentTimeMillis());
        cfWeixinConfigMapper.updateByPrimaryKeySelective(cfWeixinConfig);
        return cfWeixinConfig;
    }

    @Override
    public CfWeixinConfig findById(String id) {
        return cfWeixinConfigMapper.selectByPrimaryKey(id);
    }

    @Override
    public CfWeixinConfig findById(String id, Boolean expectEmpty) {
        CfWeixinConfig cfWeixinConfig = findById(id);
        if(!expectEmpty && cfWeixinConfig==null){
            ExceptionCast.cast(UcenterCode.WECHAT_CONFIGURATION_DOES_NOT_EXIST);
        }
        if(expectEmpty && cfWeixinConfig!=null){
            ExceptionCast.cast(CommonCode.DUPLICATE_DATA);
        }
        return cfWeixinConfig;
    }

    @Override
    public CfWeixinConfigExample getExampleByQuery(CfWeixinConfigQuery cfWeixinConfigQuery) {
        CfWeixinConfigExample cfWeixinConfigExample = new CfWeixinConfigExample();
        CfWeixinConfigExample.Criteria criteria = cfWeixinConfigExample.createCriteria();
        if(StringUtils.isNotEmpty(cfWeixinConfigQuery.getEnName())){
            criteria.andEnNameEqualTo(cfWeixinConfigQuery.getEnName());
        }
        if(StringUtils.isNotEmpty(cfWeixinConfigQuery.getUseScenes())){
            criteria.andUseScenesEqualTo(cfWeixinConfigQuery.getUseScenes());
        }
        if(StringUtils.isNotEmpty(cfWeixinConfigQuery.getOrderBy())){
            cfWeixinConfigExample.setOrderByClause(cfWeixinConfigQuery.getOrderBy());
        }
        if(cfWeixinConfigQuery.getPage()!=null && cfWeixinConfigQuery.getSize()!=null){
            PageHelper.startPage(cfWeixinConfigQuery.getPage(), cfWeixinConfigQuery.getSize());
        }
        return cfWeixinConfigExample;
    }

    @Override
    public List<CfWeixinConfig> getListByQuery(CfWeixinConfigQuery cfWeixinConfigQuery) {
        return cfWeixinConfigMapper.selectByExample(getExampleByQuery(cfWeixinConfigQuery));
    }

    @Override
    public Integer countByQuery(CfWeixinConfigQuery cfWeixinConfigQuery) {
        cfWeixinConfigQuery.setPage(null);
        return cfWeixinConfigMapper.countByExample(getExampleByQuery(cfWeixinConfigQuery));
    }

    @Override
    public String getAccessToken(String scenes, String weixinAppId, String appSecret) throws Exception{
        CfWeixinConfigQuery cfWeixinConfigQuery = new CfWeixinConfigQuery();
        cfWeixinConfigQuery.setEnName(scenes+"_access_token");
        List<CfWeixinConfig> weixinConfigs = getListByQuery(cfWeixinConfigQuery);
        String accessToken = null;
        if(weixinConfigs==null || weixinConfigs.size()==0){
            accessToken = httpAccessToken(weixinAppId, appSecret);
            CfWeixinConfig cfWeixinConfig = new CfWeixinConfig();
            cfWeixinConfig.setEnName(scenes+"_access_token");
            cfWeixinConfig.setZhName("微信accessToken");
            cfWeixinConfig.setUseScenes(scenes+"_global");
            cfWeixinConfig.setValue(accessToken);
            cfWeixinConfig.setDescription("");
            cfWeixinConfig.setExpireTime(System.currentTimeMillis()+7200000);
            CfWeixinConfig weixinConfig = add(cfWeixinConfig);
        }else if(weixinConfigs.get(0).getExpireTime()+300000<System.currentTimeMillis()){
            accessToken = httpAccessToken(weixinAppId, appSecret);
            weixinConfigs.get(0).setValue(accessToken);
            weixinConfigs.get(0).setExpireTime(System.currentTimeMillis()+7200000);
            update(weixinConfigs.get(0));
        }else{
            accessToken = weixinConfigs.get(0).getValue();
        }

        return accessToken;
    }

    @Override
    public String getHKAccessToken(String scenes, String appKey, String appSecret) throws Exception {
        CfWeixinConfigQuery cfWeixinConfigQuery = new CfWeixinConfigQuery();
        cfWeixinConfigQuery.setEnName(scenes+"_access_token");
        List<CfWeixinConfig> weixinConfigs = getListByQuery(cfWeixinConfigQuery);
        String accessToken = null;
        if(weixinConfigs==null || weixinConfigs.size()==0){
            Map<String, Object> hkToken = httpAccessHKToken(appKey, appSecret);
            accessToken = hkToken.get("accessToken").toString();

            CfWeixinConfig cfWeixinConfig = new CfWeixinConfig();
            cfWeixinConfig.setEnName(scenes+"_access_token");
            cfWeixinConfig.setZhName("海康accessToken");
            cfWeixinConfig.setUseScenes(scenes+"_global");
            cfWeixinConfig.setValue(accessToken);
            cfWeixinConfig.setDescription("");
            Long expireTime = (Long)hkToken.get("expireTime");
            cfWeixinConfig.setExpireTime(expireTime);
            CfWeixinConfig weixinConfig = add(cfWeixinConfig);
        }else if(weixinConfigs.get(0).getExpireTime()+300000<System.currentTimeMillis()){
            Map<String, Object> hkToken = httpAccessHKToken(appKey, appSecret);
            accessToken = hkToken.get("accessToken").toString();

            weixinConfigs.get(0).setValue(accessToken);
            Long expireTime = (Long)hkToken.get("expireTime");
            weixinConfigs.get(0).setExpireTime(expireTime);
            update(weixinConfigs.get(0));
        }else{
            accessToken = weixinConfigs.get(0).getValue();
        }

        return accessToken;
    }

    public String httpAccessToken(String weixinAppId, String appSecret) throws Exception
    {
        JSONObject userInfoJson = HttpClient.doGet("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + weixinAppId +
                "&secret=" + appSecret);
        if(userInfoJson.get("errcode")!=null){
            ExceptionCast.cast(AuthCode.WECHAT_LOGIN_FAILED, userInfoJson.get("errmsg")+"");
            return null;
        }
        return userInfoJson.getString("access_token");
    }

    /**
     * 向海康请求accessToken
     * @param appKey
     * @param appSecret
     * @return
     * @throws Exception
     */
    private Map<String, Object> httpAccessHKToken(String appKey, String appSecret) throws Exception
    {
        JSONObject body=new JSONObject();
        body.put("appKey",appKey);
        body.put("appSecret",appSecret);
        Map<String, String> headers = new HashMap<>();
        JSONObject result = (JSONObject)HttpClient.doPost(body, "https://open.ys7.com/api/lapp/token/get?appKey=" + appKey +
                "&appSecret=" + appSecret, headers, true);
        if(!result.get("code").toString().equals("200")){
            ExceptionCast.cast(AuthCode.AUTH_LOGIN_TOKEN_SAVEFAIL, result.get("msg")+"");
            return null;
        }
        return (Map)result.get("data");
    }

    public List<CfWeixinConfig> getWeiXinLoginConfigragtion(String scenes)
    {
        CfWeixinConfigQuery cfWeixinConfigQuery = new CfWeixinConfigQuery();
        cfWeixinConfigQuery.setUseScenes(scenes);
        List<CfWeixinConfig> cfWeixinConfigs = getListByQuery(cfWeixinConfigQuery);
        if(cfWeixinConfigs.size()==0){
            ExceptionCast.cast(UcenterCode.MISSING_WECHAT_CONFIGURATION, "database miss weixin login configragtion data");
        }
        return cfWeixinConfigs;
    }

    @Override
    public Object getUnlimited(UnlimitedForm unlimitedForm) throws Exception {
        if(StringUtils.isEmpty(unlimitedForm.getAppid())){
            //获取系统默认微信小程序appid
            List<CfWeixinConfig> cfWeixinConfigs = getWeiXinLoginConfigragtion("mp_login");
            unlimitedForm.setAppid(WeiXinConfigUtils.getWeiXinConfigragtionByEnName("mp_appid", cfWeixinConfigs));
        }
        String accessToken = cfAccessTokenManageService.getWeiXinAccessToken(ThirdPartyPlatformType.WX_MP, unlimitedForm.getAppid());

        return HttpClient.doPost(JSONObject.parseObject(JSONObject.toJSONString(unlimitedForm)), "https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=" + accessToken, new HashMap<>(), false);
    }

    @Override
    public String returnGetIpUrl() {
        return getIpUrl;
    }
}
