package com.cf.carpark.admin.controller;

import com.cf.carpark.admin.config.AuthenticationInterceptor;
import com.cf.carpark.admin.swagger.CfCarParkLoginSwagger;
import com.cf.carpark.domain.CfCarParkCheckpoint;
import com.cf.carpark.domain.CfCarParkLinkUser;
import com.cf.carpark.domain.request.CfCarParkCheckpointQuery;
import com.cf.carpark.domain.request.CfCarParkLinkUserQuery;
import com.cf.carpark.service.CfCarParkCheckpointService;
import com.cf.carpark.service.CfCarParkLinkUserService;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.ext.AuthToken;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.utils.HttpHearderUtils;
import com.cf.pay.domain.CfAccount;
import com.cf.pay.domain.request.CfAccountQuery;
import com.cf.ucenter.domain.CfUser;
import com.cf.ucenter.service.AuthService;
import com.cf.ucenter.service.CfUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("carparkLoginAdmin/")
public class CfCarParkLoginController implements CfCarParkLoginSwagger {

    @Value("${auth.clientId}")
    String clientId;
    @Value("${auth.clientSecret}")
    String clientSecret;

    @Autowired
    protected HttpServletRequest request;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private AuthService authService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfUserService cfUserService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfCarParkLinkUserService cfCarParkLinkUserService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfCarParkCheckpointService cfCarParkCheckpointService;

    @Override
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResponseResult login(String username,String password,String code) throws Exception {
        AuthToken authToken = authService.login(username, password, clientId, clientSecret);
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(authToken.getJwt_token());
        CfUser cfUser = cfUserService.getUserByUid(userBasicInfo.getId(), true);
        cfUser.setPassword(null);
        //找到该用户所关联的停车场和通道
        CfCarParkLinkUserQuery cfCarParkLinkUserQuery = new CfCarParkLinkUserQuery();
        cfCarParkLinkUserQuery.setUid(userBasicInfo.getId());
        List<CfCarParkLinkUser> cfCarParkLinkUsers = cfCarParkLinkUserService.getListByQuery(cfCarParkLinkUserQuery);
        if(cfCarParkLinkUsers!=null && cfCarParkLinkUsers.size()>0){
            //自动值班
            for(CfCarParkLinkUser cfCarParkLinkUser: cfCarParkLinkUsers){
                if(StringUtils.isNotEmpty(cfCarParkLinkUser.getCheckPointIds())){
                    CfCarParkCheckpointQuery cfCarParkCheckpointQuery = new CfCarParkCheckpointQuery();
                    String[] checkPointIds = cfCarParkLinkUser.getCheckPointIds().split(",");
                    cfCarParkCheckpointQuery.setIds(new ArrayList<>());
                    for(int i=0;i<checkPointIds.length;i++){
                        cfCarParkCheckpointQuery.getIds().add(checkPointIds[i]);
                    }
//                    cfCarParkCheckpointQuery.setDutyUid("");
                    List<CfCarParkCheckpoint> cfCarParkCheckpoints = cfCarParkCheckpointService.getListByQuery(cfCarParkCheckpointQuery);
                    if(cfCarParkCheckpoints!=null && cfCarParkCheckpoints.size()>0){
                        cfCarParkCheckpointQuery.setIds(new ArrayList<>());
                        for (CfCarParkCheckpoint cfCarParkCheckpoint: cfCarParkCheckpoints){
                            cfCarParkCheckpointQuery.getIds().add(cfCarParkCheckpoint.getId());
                        }
                        cfCarParkCheckpointQuery.setDutyUid(null);
                        CfCarParkCheckpoint cfCarParkCheckpoint = new CfCarParkCheckpoint();
                        cfCarParkCheckpoint.setDutyUid(userBasicInfo.getId());
                        cfCarParkCheckpointService.updateByQuery(cfCarParkCheckpoint,cfCarParkCheckpointQuery);
                    }
                }
            }
            //智能记录其开始有效值班时间，若11小时内有值班记录，按最早一次算开始值班时间，否则本次登录时间算开始值班时间
            if(System.currentTimeMillis()-cfCarParkLinkUsers.get(0).getStartDutyTime()>39600000){
                CfCarParkLinkUser cfCarParkLinkUser = new CfCarParkLinkUser();
                cfCarParkLinkUser.setStartDutyTime(System.currentTimeMillis());
                cfCarParkLinkUserService.updateByQuery(cfCarParkLinkUser, cfCarParkLinkUserQuery);
            }
        }

        return new ResponseResult(CommonCode.SUCCESS, cfUser, authToken, 0);
    }

    @Override
    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public ResponseResult logout(String type) throws Exception {
        String jwt = HttpHearderUtils.getAuthorization(request);
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(jwt);
        Object deleteResult = null;
        if(type.equals("all")){
            deleteResult = stringRedisTemplate.delete("user:" + userBasicInfo.getUsername());
        }else if(type.equals("current")){
            deleteResult = stringRedisTemplate.boundSetOps("user:" + userBasicInfo.getUsername()).remove(jwt);
        }else{
            return new ResponseResult(CommonCode.FAIL, null, "invalid typ");
        }
        //自动脱班(解除岗亭值班)
        CfCarParkCheckpointQuery cfCarParkCheckpointQuery = new CfCarParkCheckpointQuery();
        cfCarParkCheckpointQuery.setDutyUid(userBasicInfo.getId());

        CfCarParkCheckpoint cfCarParkCheckpoint = new CfCarParkCheckpoint();
        cfCarParkCheckpoint.setDutyUid("");

        cfCarParkCheckpointService.updateByQuery(cfCarParkCheckpoint,cfCarParkCheckpointQuery);
        return new ResponseResult(CommonCode.SUCCESS, deleteResult);
    }
}
