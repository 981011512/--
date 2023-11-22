package com.cf.pay.api.controller;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.utils.HttpClient;
import com.cf.framework.utils.HttpHearderUtils;
import com.cf.pay.api.config.AuthenticationInterceptor;
import com.cf.pay.api.swagger.CfAccountApiSwagger;
import com.cf.pay.domain.CfAccount;
import com.cf.pay.domain.CfScoreType;
import com.cf.pay.domain.request.CfAccountQuery;
import com.cf.pay.domain.request.CfScoreTypeQuery;
import com.cf.pay.domain.response.ResultMap;
import com.cf.pay.service.CfAccountService;
import com.cf.pay.service.CfScoreTypeService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("account/")
@Validated
public class CfAccountApiController implements CfAccountApiSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfAccountService cfAccountService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfScoreTypeService cfScoreTypeService;
    @Autowired
    protected HttpServletRequest request;

    @Override
    @RequestMapping(value = "myAccountList", method = {RequestMethod.GET})
    public ResponseResult myAccountList(CfAccountQuery cfAccountQuery) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        cfAccountQuery.setUid(userBasicInfo.getId());
        List<CfAccount> cfAccounts = cfAccountService.myAccountList(cfAccountQuery);
        if(cfAccounts==null || cfAccounts.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfAccounts);
    }

    @Override
    @RequestMapping(value = "customerCheckAndAddBalanceByQuery", method = {RequestMethod.PUT})
    public ResponseResult customerCheckAndAddBalanceByQuery(HttpServletRequest httpServletRequest, @RequestBody CfAccountQuery cfAccountQuery) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        cfAccountQuery.setUid(userBasicInfo.getId());
        cfAccountQuery.setIpAddress(HttpClient.getIPAddress(httpServletRequest));
        ResultMap resultMap = cfAccountService.customerCheckAndAddBalanceByQuery(cfAccountQuery);
        return new ResponseResult(CommonCode.SUCCESS, resultMap);
    }

    @Override
    @RequestMapping(value = "getScoreTypeListByQuery", method = {RequestMethod.GET})
    public ResponseResult getScoreTypeListByQuery(CfScoreTypeQuery cfScoreTypeQuery) throws Exception {
        List<CfScoreType> cfScoreTypes = cfScoreTypeService.getListByQuery(cfScoreTypeQuery);
        if(cfScoreTypes==null || cfScoreTypes.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfScoreTypes);
    }
}
