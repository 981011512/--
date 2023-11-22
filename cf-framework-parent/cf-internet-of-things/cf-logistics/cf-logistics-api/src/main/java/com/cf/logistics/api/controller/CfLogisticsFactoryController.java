package com.cf.logistics.api.controller;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.utils.HttpHearderUtils;
import com.cf.logistics.api.config.AuthenticationInterceptor;
import com.cf.logistics.api.swagger.CfLogisticsFactorySwagger;
import com.cf.logistics.domain.CfLogisticsFactory;
import com.cf.logistics.domain.request.CfLogisticsFactoryQuery;
import com.cf.logistics.service.CfLogisticsFactoryService;
import com.cf.ucenter.domain.CfUser;
import com.cf.ucenter.service.CfUserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("LogisticsFactory/")
@Validated
@CrossOrigin
public class CfLogisticsFactoryController implements CfLogisticsFactorySwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfLogisticsFactoryService cfLogisticsFactoryService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfUserService cfUserService;
    @Autowired
    protected HttpServletRequest request;

    @Override
    @RequestMapping(value = "selectNearLogisticsFactory", method = RequestMethod.GET)
    public ResponseResult selectNearLogisticsFactory(CfLogisticsFactoryQuery cfLogisticsFactoryQuery) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        //检查用户合法性
        CfUser cfUser = cfUserService.getUserByUid(userBasicInfo.getId(), false);
        if(cfUser.getDriverLicenseStatus().byteValue()!=( byte)2){
            return new ResponseResult(CommonCode.FAIL,null, "您的驾驶证未上传或者未通过审核，请联系管理员处理");
        }
        CfLogisticsFactoryQuery search = new CfLogisticsFactoryQuery();
        search.setPositionX(cfLogisticsFactoryQuery.getPositionX());
        search.setPositionY(cfLogisticsFactoryQuery.getPositionY());
        List<CfLogisticsFactory> cfLogisticsFactorys = cfLogisticsFactoryService.selectNearLogisticsFactory(search);
        if(cfLogisticsFactorys==null || cfLogisticsFactorys.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS, null);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfLogisticsFactorys, cfLogisticsFactorys.size());
    }
}
