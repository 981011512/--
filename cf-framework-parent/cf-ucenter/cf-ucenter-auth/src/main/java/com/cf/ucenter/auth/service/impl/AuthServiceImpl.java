package com.cf.ucenter.auth.service.impl;

import com.alibaba.fastjson.JSON;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.ucenter.ext.AuthToken;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.domain.ucenter.response.AuthCode;
import com.cf.framework.domain.ucenter.response.UcenterCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.IdWorker;
import com.cf.framework.utils.SpringUtil;
import com.cf.framework.utils.StringTools;
import com.cf.sms.service.SmsService;
import com.cf.ucenter.dao.mapper.CfAuthMapper;
import com.cf.ucenter.dao.mapper.CfUserAuthMapper;
import com.cf.ucenter.domain.*;
import com.cf.ucenter.request.CfAuthQuery;
import com.cf.ucenter.request.CfRoleAuthQuery;
import com.cf.ucenter.service.AuthService;
import com.cf.ucenter.service.CfRoleAuthService;
import com.cf.ucenter.service.CfUserService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaSigner;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import org.springframework.util.Base64Utils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @version 1.0
 **/
@Service(version = "1.0.0", loadbalance = "roundrobin")
public class AuthServiceImpl implements AuthService {

    @Value("${auth.tokenValiditySeconds}")
    int tokenValiditySeconds;
    @Value("${encrypt.key-store.location}")
    String keyStoreLocation;
    @Value("${encrypt.key-store.secret}")
    String keyStoreSecret;
    @Value("${encrypt.key-store.alias}")
    String keyStoreAlias;
    @Value("${encrypt.key-store.password}")
    String keyStorePassword;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    private CfAuthMapper cfAuthMapper;
    @Autowired
    private CfUserAuthMapper cfUserAuthMapper;
    @Autowired
    IdWorker idWorker;
    @Autowired
    RestTemplate restTemplate;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfRoleAuthService cfRoleAuthService;

    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private SmsService smsService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfUserService cfUserService;

    public final static Long loginTimeOut = 604800l;

    //用户认证申请令牌，将令牌存储到redis
    public AuthToken login(String username, String password, String clientId, String clientSecret) {

        //请求spring security申请令牌
        AuthToken authToken = this.applyToken(username, password, clientId, clientSecret, "password");
        if(authToken == null){
            ExceptionCast.cast(AuthCode.AUTH_LOGIN_APPLYTOKEN_FAIL);
        }
//        //用户身份令牌
//        String access_token = authToken.getAccess_token();
//        //存储到redis中的内容
//        String jsonString = JSON.toJSONString(authToken);
//        //将令牌存储到redis
//        boolean result = this.saveToken(access_token, jsonString, tokenValiditySeconds);
//        if (!result) {
//            ExceptionCast.cast(AuthCode.AUTH_LOGIN_TOKEN_SAVEFAIL);
//        }

        stringRedisTemplate.boundSetOps("user:"+username).add(authToken.getJwt_token());
        stringRedisTemplate.expire("user:"+username, AuthServiceImpl.loginTimeOut, TimeUnit.SECONDS);

        return authToken;

    }

    @Override
    public AuthToken loginByPhone(String phone, String smsCode, String clientId, String clientSecret) {
        //请求spring security申请令牌
        AuthToken authToken = this.applyToken(phone, smsCode, clientId, clientSecret, "sms");
        if(authToken == null){
            ExceptionCast.cast(AuthCode.AUTH_LOGIN_APPLYTOKEN_FAIL);
        }
        CfUser cfUser = cfUserService.findByPhone(phone);
        if(cfUser==null){
            ExceptionCast.cast(UcenterCode.PHONE_IS_NOT_REGISTERED);
        }
        stringRedisTemplate.boundSetOps("user:"+phone).add(authToken.getJwt_token());
        stringRedisTemplate.expire("user:"+phone, AuthServiceImpl.loginTimeOut, TimeUnit.SECONDS);

        return authToken;
    }

    /**
     *
     * @param access_token 用户身份令牌
     * @param content  内容就是AuthToken对象的内容
     * @param ttl 过期时间
     * @return
     */
    private boolean saveToken(String access_token,String content,long ttl){
        String key = "user_token:" + access_token;
        stringRedisTemplate.boundValueOps(key).set(content,ttl, TimeUnit.SECONDS);
        Long expire = stringRedisTemplate.getExpire(key, TimeUnit.SECONDS);
        return expire>0;
    }
    //删除token
    public boolean delToken(String access_token){
        String key = "user_token:" + access_token;
        stringRedisTemplate.delete(key);
        return true;
    }

    public void logout(String tokenString) {
        TokenStore tokenStore = SpringUtil.getBean(TokenStore.class);
        OAuth2AccessToken accessToken = tokenStore.readAccessToken(tokenString);
        tokenStore.removeAccessToken(accessToken);
    }

    //从redis查询令牌
    public AuthToken getUserToken(String token){
        String key = "user_token:" + token;
        //从redis中取到令牌信息
        String value = stringRedisTemplate.opsForValue().get(key);
        //转成对象
        try {
            AuthToken authToken = JSON.parseObject(value, AuthToken.class);
            return authToken;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    //申请令牌
    private AuthToken applyToken(String username, String password, String clientId, String clientSecret, String grantType){
        //从eureka中获取认证服务的地址（因为spring security在认证服务中）
        //从eureka中获取认证服务的一个实例的地址
//        ServiceInstance serviceInstance = loadBalancerClient.choose(XcServiceList.XC_SERVICE_UCENTER_AUTH);
        //此地址就是http://ip:port
//        URI uri = serviceInstance.getUri();
        //令牌申请的地址 http://localhost:40400/auth/oauth/token
        String authUrl = "http://localhost:8082/auth/oauth/token";
        //定义header
        LinkedMultiValueMap<String, String> header = new LinkedMultiValueMap<>();
        String httpBasic = getHttpBasic(clientId, clientSecret);
        header.add("Authorization",httpBasic);

        //定义body
        LinkedMultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type","password");
        body.add("username",username);
        body.add("password",password);
        body.add("auth_type",grantType);

        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(body, header);
        //String url, HttpMethod method, @Nullable HttpEntity<?> requestEntity, Class<T> responseType, Object... uriVariables

        //设置restTemplate远程调用时候，对400和401不让报错，正确返回数据
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler(){
            @Override
            public void handleError(ClientHttpResponse response) throws IOException {
                if(response.getRawStatusCode()!=400 && response.getRawStatusCode()!=401){
                    super.handleError(response);
                }
            }
        });

        ResponseEntity<Map> exchange = restTemplate.exchange(authUrl, HttpMethod.POST, httpEntity, Map.class);

        //申请令牌信息
        Map bodyMap = exchange.getBody();
        if(bodyMap == null ||
            bodyMap.get("access_token") == null ||
                bodyMap.get("refresh_token") == null ||
                bodyMap.get("jti") == null){

            //解析spring security返回的错误信息
            if(bodyMap!=null && bodyMap.get("error_description")!=null){
                String error_description = (String) bodyMap.get("error_description");
                if(error_description.indexOf("UserDetailsServiceImpl returned null")>=0){
                    ExceptionCast.cast(AuthCode.AUTH_ACCOUNT_NOTEXISTS);
                }else if(error_description.indexOf("坏的凭证")>=0){
                    ExceptionCast.cast(AuthCode.AUTH_CREDENTIAL_ERROR);
                }
            }


            return null;
        }
        AuthToken authToken = new AuthToken();
        authToken.setAccess_token((String) bodyMap.get("jti"));//用户身份令牌
        authToken.setRefresh_token((String) bodyMap.get("refresh_token"));//刷新令牌
        authToken.setJwt_token((String) bodyMap.get("access_token"));//jwt令牌
        return authToken;
    }

    @Override
    public AuthToken createJwtToken(UserBasicInfo userBasicInfo) {
        //密钥库文件
        String keystore = "xc.keystore";
        //密钥库的密码
        String keystore_password = "xuechengkeystore";

        //密钥库文件路径
        ClassPathResource classPathResource = new ClassPathResource(keystore);
        //密钥别名
        String alias  = "xckey";
        //密钥的访问密码
        String key_password = "xuecheng";
        //密钥工厂
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(classPathResource,keystore_password.toCharArray());
        //密钥对（公钥和私钥）
        KeyPair keyPair = keyStoreKeyFactory.getKeyPair(alias, key_password.toCharArray());
        //获取私钥
        RSAPrivateKey aPrivate = (RSAPrivateKey) keyPair.getPrivate();
        //jwt令牌的内容
        userBasicInfo.setUserpic(StringTools.getRandomString("",10));
        String bodyString = JSON.toJSONString(userBasicInfo);
        //生成jwt令牌
        Jwt jwt = JwtHelper.encode(bodyString, new RsaSigner(aPrivate));
        //生成jwt令牌编码
        AuthToken authToken = new AuthToken();
        authToken.setJwt_token(jwt.getEncoded());
        stringRedisTemplate.opsForSet().pop("user:"+userBasicInfo.getUsername());
        stringRedisTemplate.boundSetOps("user:"+userBasicInfo.getUsername()).add(authToken.getJwt_token());
        Long exp = userBasicInfo.getExp()!=null && userBasicInfo.getExp().longValue()>0 ? userBasicInfo.getExp() : AuthServiceImpl.loginTimeOut;
        stringRedisTemplate.expire("user:"+userBasicInfo.getUsername(), exp, TimeUnit.SECONDS);
        return authToken;
    }

    //获取httpbasic的串
    private String getHttpBasic(String clientId,String clientSecret){
        String string = clientId+":"+clientSecret;
        //将串进行base64编码
        byte[] encode = Base64Utils.encode(string.getBytes());
        return "Basic "+new String(encode);
    }

    @Override
    public String checkJwtToken(String jwtString) {
        //公钥
        String publickey = "-----BEGIN PUBLIC KEY-----MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnASXh9oSvLRLxk901HANYM6KcYMzX8vFPnH/To2R+SrUVw1O9rEX6m1+rIaMzrEKPm12qPjVq3HMXDbRdUaJEXsB7NgGrAhepYAdJnYMizdltLdGsbfyjITUCOvzZ/QgM1M4INPMD+Ce859xse06jnOkCUzinZmasxrmgNV3Db1GtpyHIiGVUY0lSO1Frr9m5dpemylaT0BV3UwTQWVW9ljm6yR3dBncOdDENumT5tGbaDVyClV0FEB1XdSKd7VjiDCDbUAUbDTG1fm3K9sx7kO1uMGElbXLgMfboJ963HEJcU01km7BmFntqI5liyKheX+HBUCD4zbYNPw236U+7QIDAQAB-----END PUBLIC KEY-----";
        //校验jwt令牌
        String claims = JwtHelper.decodeAndVerify(jwtString, new RsaVerifier(publickey)).getClaims();
        UserBasicInfo userBasicInfo = JSON.parseObject(claims, UserBasicInfo.class);
        if(userBasicInfo.getExp()*1000<=System.currentTimeMillis()){
            ExceptionCast.cast(AuthCode.AUTH_LOGIN_TOKEN_EXPIRED);
        }
        return claims;
    }

    @Override
    public List<CfAuth> recursiveQuery(Byte authLevel, String whereVal) {
        CfAuthExample cfAuthExample = new CfAuthExample();
        CfAuthExample.Criteria criteria = cfAuthExample.createCriteria();
        criteria.andLevelEqualTo(authLevel);
        if(authLevel==1){
            criteria.andModuleEqualTo(whereVal);
        }else if(authLevel==2){
            criteria.andControllerEqualTo(whereVal);
        }
        cfAuthExample.setOrderByClause("sort_index asc");
        List<CfAuth> cfAuths = cfAuthMapper.selectByExample(cfAuthExample);
        if(cfAuths!=null && authLevel<2){
            if(authLevel==0){
                Integer index = 0;
                for (CfAuth cfAuth: cfAuths){
                    List<CfAuth> cfAuthsChildren = recursiveQuery((byte) (authLevel + 1), cfAuth.getModule());
                    cfAuths.get(index).setChildren(cfAuthsChildren);
                    index++;
                }
            }else if(authLevel==1){
                Integer index = 0;
                for (CfAuth cfAuth: cfAuths){
                    List<CfAuth> cfAuthsChildren = recursiveQuery((byte) (authLevel + 1), cfAuth.getController());
                    cfAuths.get(index).setChildren(cfAuthsChildren);
                    index++;
                }
            }
        }
        return cfAuths;
    }

    @Override
    public List<CfAuth> getAuthsByUid(String uid) {
        List<CfAuth> cfAuths = selectByUidAndLevel(uid, (byte) 0, true);
        if(cfAuths==null){
            return null;
        }
        return cfAuths;
    }

    @Override
    public List<CfAuth> selectByUidAndLevel(String uid, Byte level, Boolean recursive) {
        List<CfAuth> cfAuths = cfAuthMapper.selectByUidAndRoleIdAndLevel(uid, level);
        if(!recursive){
            return cfAuths;
        }
        if(recursive && level==0){
            Integer index = 0;
            for (CfAuth cfAuth: cfAuths){
                List<CfAuth> cfAuthsChildren = selectByUidAndModuleAndLevel(uid, cfAuth.getModule(), (byte) (level + 1), true);
                cfAuths.get(index).setChildren(cfAuthsChildren);
                index++;
            }
        }
        return cfAuths;
    }

    @Override
    public List<CfAuth> selectByUidAndModuleAndLevel(String uid, String module, Byte level, Boolean recursive) {
        if(!recursive){
            return cfAuthMapper.selectByUidAndModuleAndLevel(uid, module, level);
        }
        List<CfAuth> cfAuths = cfAuthMapper.selectByUidAndModuleAndLevel(uid, module, level);
        Integer index = 0;
        for (CfAuth cfAuth: cfAuths){
            List<CfAuth> cfAuthsChildren = selectByUidAndControllerAndLevel(uid, cfAuth.getController(), (byte) (level + 1));
            cfAuths.get(index).setChildren(cfAuthsChildren);
            index++;
        }
        return cfAuths;
    }

    @Override
    public List<CfAuth> selectByUidAndControllerAndLevel(String uid, String controller, Byte level) {
        return cfAuthMapper.selectByUidAndControllerAndLevel(uid, controller, level);
    }

    @Override
    public List<CfAuth> getAuthsByRoleId(String roleId) {
        List<CfAuth> cfAuths = selectByRoleIdAndLevel(roleId, (byte) 0, true);
        if(cfAuths==null){
            return null;
        }
        return cfAuths;
    }

    @Override
    public List<CfAuth> selectByRoleIdAndLevel(String roleId, Byte level, Boolean recursive) {
        if(!recursive){
            return cfAuthMapper.selectByRoleIdAndLevel(roleId, level);
        }
        List<CfAuth> cfAuths = cfAuthMapper.selectByRoleIdAndLevel(roleId, level);
        if(recursive && level==0){
            Integer index = 0;
            for (CfAuth cfAuth: cfAuths){
                List<CfAuth> cfAuthsChildren = selectByRoleIdAndModuleAndLevel(roleId, cfAuth.getModule(), (byte) (level + 1), true);
                cfAuths.get(index).setChildren(cfAuthsChildren);
                index++;
            }
        }
        return cfAuths;
    }

    @Override
    public List<CfAuth> selectByRoleIdAndModuleAndLevel(String roleId, String module, Byte level, Boolean recursive) {
        if(!recursive){
            return cfAuthMapper.selectByRoleIdAndModuleAndLevel(roleId, module, level);
        }
        List<CfAuth> cfAuths = cfAuthMapper.selectByRoleIdAndModuleAndLevel(roleId, module, level);
        Integer index = 0;
        for (CfAuth cfAuth: cfAuths){
            List<CfAuth> cfAuthsChildren = selectByRoleIdAndControllerAndLevel(roleId, cfAuth.getController(), (byte) (level + 1));
            cfAuths.get(index).setChildren(cfAuthsChildren);
            index++;
        }
        return cfAuths;
    }

    @Override
    public List<CfAuth> selectByRoleIdAndControllerAndLevel(String roleId, String controller, Byte level) {
        return cfAuthMapper.selectByRoleIdAndControllerAndLevel(roleId, controller, level);
    }

    @Override
    public CfAuth addAuth(CfAuth cfAuth) {
        cfAuth.setId(idWorker.nextId());
        makeAuthLevel(cfAuth);
        cfAuthMapper.insert(cfAuth);
        return cfAuth;
    }

    @Override
    public CfAuth updateAuth(CfAuth cfAuth) {
        CfAuth cfAuthOld = cfAuthMapper.selectByPrimaryKey(cfAuth.getId());
        Boolean checkIsExistSubordinate = checkIsExistSubordinate(cfAuthOld);
        makeAuthLevel(cfAuth);
        if(checkIsExistSubordinate && !cfAuthOld.getLevel().equals(cfAuth.getLevel())){
            ExceptionCast.cast(AuthCode.AUTH_EXIST_SUBORDINATE_FORBID_MOVE);
        }
        cfAuthMapper.updateByPrimaryKey(cfAuth);
        return cfAuth;
    }

    @Override
    public Integer deleteAuth(String id) {
        CfAuth cfAuth = cfAuthMapper.selectByPrimaryKey(id);
        if(cfAuth==null){
            ExceptionCast.cast(CommonCode.NO_MORE_DATAS);
        }
        Boolean checkIsExistSubordinate = checkIsExistSubordinate(cfAuth);
        if(checkIsExistSubordinate){
            ExceptionCast.cast(AuthCode.AUTH_EXIST_SUBORDINATE);
        }
        return cfAuthMapper.deleteByPrimaryKey(id);
    }

    @Override
    public CfAuth makeAuthLevel(CfAuth cfAuth) {
        if(StringUtils.isNotEmpty(cfAuth.getModule()) && StringUtils.isNotEmpty(cfAuth.getController()) && StringUtils.isNotEmpty(cfAuth.getMethod())){
            cfAuth.setLevel((byte)2);
            cfAuth.setPath(cfAuth.getModule()+"-"+cfAuth.getController()+"-"+cfAuth.getMethod());
            return cfAuth;
        }else if(StringUtils.isNotEmpty(cfAuth.getModule()) && StringUtils.isNotEmpty(cfAuth.getController()) && StringUtils.isEmpty(cfAuth.getMethod())){
            cfAuth.setLevel((byte)1);
            cfAuth.setPath(cfAuth.getModule()+"-"+cfAuth.getController());
            return cfAuth;
        }else if(StringUtils.isNotEmpty(cfAuth.getModule()) && StringUtils.isEmpty(cfAuth.getController()) && StringUtils.isEmpty(cfAuth.getMethod())){
            cfAuth.setLevel((byte)0);
            cfAuth.setPath(cfAuth.getModule());
            return cfAuth;
        }else{
            ExceptionCast.cast(AuthCode.AUTH_MODULE_CONTROLLER_METHOD_FORMAT_ERROR);
            return null;
        }
    }

    @Override
    public Boolean checkIsExistSubordinate(CfAuth cfAuth) {
        if(cfAuth.getLevel()<2){
            CfAuthExample cfAuthExample = new CfAuthExample();
            CfAuthExample.Criteria criteria = cfAuthExample.createCriteria();
            if(cfAuth.getLevel()==0){
                criteria.andLevelEqualTo((byte)1).andModuleEqualTo(cfAuth.getModule());
            }else {
                criteria.andLevelEqualTo((byte)2).andModuleEqualTo(cfAuth.getController());
            }
            List<CfAuth> cfAuths = cfAuthMapper.selectByExample(cfAuthExample);
            if(cfAuths!=null){
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer addUserAuths(List<CfUserAuth> cfUserAuths) {
        return cfUserAuthMapper.batchInsert(cfUserAuths);
    }

    @Override
    public Integer deleteUserAuths(String uid) {
        CfUserAuthExample cfUserAuthExample = new CfUserAuthExample();
        CfUserAuthExample.Criteria criteria = cfUserAuthExample.createCriteria();
        criteria.andUidEqualTo(uid);
        return cfUserAuthMapper.deleteByExample(cfUserAuthExample);
    }

    @Override
    public void flushUserAuths(List<CfUserAuth> cfUserAuths) {
        if(cfUserAuths==null || cfUserAuths.size()==0){
            ExceptionCast.cast(AuthCode.HAVE_NOT_USER_AUTH);
        }
        deleteUserAuths(cfUserAuths.get(0).getUid());
        addUserAuths(cfUserAuths);
    }

    @Override
    public void removeCheckPointDutyByUid(String uid) {
        cfUserAuthMapper.removeCheckPointDutyByUid(uid);
    }

    @Override
    public String[] getAuthPathByRoleId(String roleId) {
        return cfAuthMapper.getAuthPathByRoleId(roleId);
    }

    @Override
    public CfAuthExample getExampleByQuery(CfAuthQuery cfAuthQuery) {
        CfAuthExample cfAuthExample = new CfAuthExample();

        CfAuthExample.Criteria criteria = cfAuthExample.createCriteria();
        if(cfAuthQuery.getIds()!=null && cfAuthQuery.getIds().size()>0){
            criteria.andIdIn(cfAuthQuery.getIds());
        }
        if(cfAuthQuery.getLevel()!=null){
            criteria.andLevelEqualTo(cfAuthQuery.getLevel());
        }
        if(StringUtils.isNotEmpty(cfAuthQuery.getPath())){
            criteria.andPathEqualTo(cfAuthQuery.getPath());
        }
        if(StringUtils.isNotEmpty(cfAuthQuery.getModule())){
            criteria.andModuleEqualTo(cfAuthQuery.getModule());
        }
        if(StringUtils.isNotEmpty(cfAuthQuery.getController())){
            criteria.andControllerEqualTo(cfAuthQuery.getController());
        }
        if(cfAuthQuery.getBreadcrumbHidden()!=null){
            criteria.andBreadcrumbHiddenEqualTo(cfAuthQuery.getBreadcrumbHidden());
        }
        if(cfAuthQuery.getShowMenu()!=null){
            criteria.andShowMenuEqualTo(cfAuthQuery.getShowMenu());
        }

        if(StringUtils.isNotEmpty(cfAuthQuery.getOrderBy())){
            cfAuthExample.setOrderByClause(cfAuthQuery.getOrderBy());
        }
        if(cfAuthQuery.getPage()!=null && cfAuthQuery.getSize()!=null){
            PageHelper.startPage(cfAuthQuery.getPage(), cfAuthQuery.getSize());
        }
        return cfAuthExample;
    }

    @Override
    public List<CfAuth> getListByQuery(CfAuthQuery cfAuthQuery) {
        return cfAuthMapper.selectByExample(getExampleByQuery(cfAuthQuery));
    }

    @Override
    public List<CfAuth> getFullAuthsByRoleId(String roleId) {

        CfAuthQuery cfAuthQuery = new CfAuthQuery();
        cfAuthQuery.setLevel((byte)0);
        cfAuthQuery.setIds(new ArrayList<>());

        CfRoleAuthQuery cfRoleAuthQuery = new CfRoleAuthQuery();
        cfRoleAuthQuery.setRoleId(roleId);
        List<CfRoleAuth> cfRoleAuthList = cfRoleAuthService.getListByQuery(cfRoleAuthQuery);
        if(cfRoleAuthList==null || cfRoleAuthList.size()==0){
            return null;
        }else{
            for (CfRoleAuth cfRoleAuth: cfRoleAuthList){
                cfAuthQuery.getIds().add(cfRoleAuth.getAuthId());
            }
        }
        cfAuthQuery.setOrderBy("sort_index asc");
        cfAuthQuery.setShowMenu((byte)1);
        List<CfAuth> cfAuthList = getListByQuery(cfAuthQuery);
        if(cfAuthList==null || cfAuthList.size()==0){
            return null;
        }
        for (CfAuth cfAuth: cfAuthList){
            cfAuth.setMeta(new CfAuthMeta());
            cfAuth.getMeta().setIcon(cfAuth.getIcon());
            cfAuth.getMeta().setTitle(cfAuth.getName());
            if(cfAuth.getBreadcrumbHidden()==(byte)0){
                cfAuth.getMeta().setBreadcrumbHidden(false);
            }else{
                cfAuth.getMeta().setBreadcrumbHidden(true);
            }
            cfAuth.setPath(cfAuth.getRouterPath());
            cfAuth.setName(cfAuth.getRouterName());
            //查找它的子级
            cfAuthQuery.setLevel((byte)1);
            cfAuthQuery.setIds(null);
            cfAuthQuery.setModule(cfAuth.getModule());
            List<CfAuth> controllerAuthList = getListByQuery(cfAuthQuery);
            if(controllerAuthList!=null && controllerAuthList.size()>0){
                for (CfAuth controllerCfAuth: controllerAuthList){
                    controllerCfAuth.setMeta(new CfAuthMeta());
                    controllerCfAuth.getMeta().setIcon(controllerCfAuth.getIcon());
                    controllerCfAuth.getMeta().setTitle(controllerCfAuth.getName());
                    if(controllerCfAuth.getBreadcrumbHidden()==(byte)0){
                        controllerCfAuth.getMeta().setBreadcrumbHidden(false);
                    }else{
                        controllerCfAuth.getMeta().setBreadcrumbHidden(true);
                    }
                    controllerCfAuth.setPath(controllerCfAuth.getRouterPath());
                    controllerCfAuth.setName(controllerCfAuth.getRouterName());
                    //找到它的子级别
                    //start
                    cfAuthQuery.setLevel((byte)2);
                    cfAuthQuery.setIds(null);
                    cfAuthQuery.setModule(null);
                    cfAuthQuery.setController(controllerCfAuth.getController());
                    List<CfAuth> methodAuthList = getListByQuery(cfAuthQuery);
                    if(methodAuthList!=null && methodAuthList.size()>0){
                        for (CfAuth methodCfAuth: methodAuthList){
                            methodCfAuth.setMeta(new CfAuthMeta());
                            methodCfAuth.getMeta().setIcon(methodCfAuth.getIcon());
                            methodCfAuth.getMeta().setTitle(methodCfAuth.getName());
                            if(methodCfAuth.getBreadcrumbHidden()==(byte)0){
                                methodCfAuth.getMeta().setBreadcrumbHidden(false);
                            }else{
                                methodCfAuth.getMeta().setBreadcrumbHidden(true);
                            }
                            methodCfAuth.setPath(methodCfAuth.getRouterPath());
                            methodCfAuth.setName(methodCfAuth.getRouterName());
                        }
                        controllerCfAuth.setChildren(methodAuthList);
                    }
                }
                cfAuth.setChildren(controllerAuthList);
            }
        }
        return cfAuthList;
    }
}
