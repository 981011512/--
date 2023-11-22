package com.cf.pay.admin.controller;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.utils.HttpHearderUtils;
import com.cf.pay.admin.config.AuthenticationInterceptor;
import com.cf.pay.admin.swagger.CfAccountSwagger;
import com.cf.pay.domain.CfAccount;
import com.cf.pay.domain.request.CfAccountForm;
import com.cf.pay.domain.request.CfAccountQuery;
import com.cf.pay.service.CfAccountService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 请在此填写描述
 *
 * @ClassName CfCouponController
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/6/7/007 17:15
 * @Version 1.0
 **/
@RestController
@RequestMapping("accountAdmin/")
@Validated
public class CfAccountController implements CfAccountSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfAccountService cfAccountService;
    @Autowired
    protected HttpServletRequest request;

    @Override
    @PreAuthorize("hasAuthority('pay-CfAccountController-selectByQuery')")
    @RequestMapping(value = "selectByQuery", method = {RequestMethod.GET})
    public ResponseResult getListByQuery(CfAccountQuery cfAccountQuery) {
        List<CfAccount> cfAccountList = cfAccountService.getListByQuery(cfAccountQuery);
        if(cfAccountList==null || cfAccountList.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        Integer count = cfAccountService.countByQuery(cfAccountQuery);
        return new ResponseResult(CommonCode.SUCCESS, cfAccountList, count);
    }

    @Override
    @PreAuthorize("hasAuthority('pay-CfAccountController-update')")
    @RequestMapping(value = "update", method = {RequestMethod.PUT})
    public ResponseResult update(CfAccountForm cfAccountForm) {
        CfAccount cfCoupon = new CfAccount();
        BeanUtils.copyProperties(cfAccountForm, cfCoupon);
        CfAccount cfAccount = cfAccountService.update(cfCoupon);
        return new ResponseResult(CommonCode.SUCCESS, cfAccount);
    }

    @Override
    @PreAuthorize("hasAuthority('pay-CfAccountController-checkAndAddBalanceByQuery')")
    @RequestMapping(value = "checkAndAddBalanceByQuery", method = {RequestMethod.PUT})
    public ResponseResult checkAndAddBalanceByQuery(@RequestBody CfAccountQuery cfAccountQuery) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        cfAccountQuery.setHandleUid(userBasicInfo.getId());
        Integer integer = cfAccountService.checkAndAddBalanceByQuery(cfAccountQuery);
        return integer>0?new ResponseResult(CommonCode.SUCCESS): new ResponseResult(CommonCode.FAIL);
    }

    @Override
    @PreAuthorize("hasAuthority('pay-CfAccountController-checkAndReduceBalanceByQuery')")
    @RequestMapping(value = "checkAndReduceBalanceByQuery", method = {RequestMethod.PUT})
    public ResponseResult checkAndReduceBalanceByQuery(CfAccountQuery cfAccountQuery) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        cfAccountQuery.setHandleUid(userBasicInfo.getId());
        Integer integer = cfAccountService.checkAndReduceBalanceByQuery(cfAccountQuery);
        return integer>0?new ResponseResult(CommonCode.SUCCESS): new ResponseResult(CommonCode.FAIL);
    }
}
