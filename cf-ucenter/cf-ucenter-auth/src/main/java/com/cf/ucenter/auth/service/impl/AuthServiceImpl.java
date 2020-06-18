package com.cf.ucenter.auth.service.impl;

import com.alibaba.fastjson.JSON;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.ucenter.ext.AuthToken;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.domain.ucenter.response.AuthCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.IdWorker;
import com.cf.ucenter.dao.mapper.CfAuthMapper;
import com.cf.ucenter.dao.mapper.CfUserAuthMapper;
import com.cf.ucenter.domain.CfAuth;
import com.cf.ucenter.domain.CfAuthExample;
import com.cf.ucenter.domain.CfUserAuth;
import com.cf.ucenter.domain.CfUserAuthExample;
import com.cf.ucenter.service.AuthService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.util.Base64Utils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @version 1.0
 **/
@Service(version = "1.0.0")
public class AuthServiceImpl implements AuthService {

    @Value("${auth.tokenValiditySeconds}")
    int tokenValiditySeconds;
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
    //用户认证申请令牌，将令牌存储到redis
    public AuthToken login(String username, String password, String clientId, String clientSecret) {

        //请求spring security申请令牌
        AuthToken authToken = this.applyToken(username, password, clientId, clientSecret);
        if(authToken == null){
            ExceptionCast.cast(AuthCode.AUTH_LOGIN_APPLYTOKEN_FAIL);
        }
        //用户身份令牌
//        String access_token = authToken.getAccess_token();
        //存储到redis中的内容
//        String jsonString = JSON.toJSONString(authToken);
        //将令牌存储到redis
//        boolean result = this.saveToken(access_token, jsonString, tokenValiditySeconds);
//        if (!result) {
//            ExceptionCast.cast(AuthCode.AUTH_LOGIN_TOKEN_SAVEFAIL);
//        }
        return authToken;

    }
    //存储到令牌到redis

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
    private AuthToken applyToken(String username, String password, String clientId, String clientSecret){
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
}
