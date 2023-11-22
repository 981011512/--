package com.cf.carpark.api.controller;

import com.cf.carpark.api.config.AuthenticationInterceptor;
import com.cf.carpark.api.swagger.CfCarParkPackageSwagger;
import com.cf.carpark.domain.CfCarParkPackage;
import com.cf.carpark.domain.CfCarParkPackagePrice;
import com.cf.carpark.domain.ext.CfCarParkOrder;
import com.cf.carpark.domain.request.BuyCfCarParkPackage;
import com.cf.carpark.domain.request.CfCarParkPackagePriceQuery;
import com.cf.carpark.domain.request.CfCarParkPackageQuery;
import com.cf.carpark.service.CfCarParkPackagePriceService;
import com.cf.carpark.service.CfCarParkPackageService;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.utils.HttpClient;
import com.cf.framework.utils.HttpHearderUtils;
import com.cf.pay.domain.response.ResultMap;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @ClassName CfCarParkPackageController
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/23/023 20:35
 * @Version 1.0
 **/
@RestController
@RequestMapping("carparkpackage/")
@Validated
public class CfCarParkPackageController implements CfCarParkPackageSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCarParkPackageService cfCarParkPackageService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCarParkPackagePriceService cfCarParkPackagePriceService;
    @Autowired
    protected HttpServletRequest request;

    @Override
    @RequestMapping(value = "getMyCarParkPackageByCondition", method = RequestMethod.GET)
    public ResponseResult getMyCarParkPackageByCondition(CfCarParkPackageQuery cfCarParkPackageQuery) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        cfCarParkPackageQuery.setUid(userBasicInfo.getId());
        cfCarParkPackageQuery.setTransRegional((byte)0);
        List<CfCarParkPackage> cfCarParkPackages = cfCarParkPackageService.getListByQueryContainCarParkName(cfCarParkPackageQuery);
        if(cfCarParkPackages==null || cfCarParkPackages.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfCarParkPackages);
    }

    @Override
    @RequestMapping(value = "getCarParkPackagePriceByCondition", method = RequestMethod.GET)
    public ResponseResult getCarParkPackagePriceByCondition(CfCarParkPackagePriceQuery cfCarParkPackagePriceQuery) {
        cfCarParkPackagePriceQuery.setSpecialGive((byte)0);
        List<CfCarParkPackagePrice> cfCarParkPackagePrices = cfCarParkPackagePriceService.getListByQuery(cfCarParkPackagePriceQuery);
        if(cfCarParkPackagePrices==null || cfCarParkPackagePrices.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfCarParkPackagePrices);
    }

    @Override
    @RequestMapping(value = "buyCfCarParkPackage", method = RequestMethod.POST)
    public ResponseResult buyCfCarParkPackage(HttpServletRequest httpServletRequest,@RequestBody @Validated BuyCfCarParkPackage buyCfCarParkPackage) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        ResultMap resultMap = cfCarParkPackagePriceService.buyCfCarParkPackage(buyCfCarParkPackage.getCfCarParkPackagePriceId(), userBasicInfo.getId(), buyCfCarParkPackage.getPayTypeId(), buyCfCarParkPackage.getNumberPlate(), HttpClient.getIPAddress(httpServletRequest));
        return new ResponseResult(CommonCode.SUCCESS, resultMap);
    }

    @Override
    @RequestMapping(value = "queryCfCarParkPackageRecoverFee", method = RequestMethod.GET)
    public ResponseResult queryCfCarParkPackageRecoverFee(BuyCfCarParkPackage buyCfCarParkPackage) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        CfCarParkPackagePrice cfCarParkPackagePrice = cfCarParkPackagePriceService.findById(buyCfCarParkPackage.getCfCarParkPackagePriceId());
        if(cfCarParkPackagePrice==null){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        CfCarParkOrder cfCarParkOrder = cfCarParkPackagePriceService.queryCfCarParkPackageRecoverFee(cfCarParkPackagePrice, userBasicInfo.getId(), buyCfCarParkPackage.getNumberPlate());
        return cfCarParkOrder==null ? new ResponseResult(CommonCode.NO_MORE_DATAS) : new ResponseResult(CommonCode.SUCCESS, cfCarParkOrder);
    }

    @Override
    @RequestMapping(value = "getCarParkPackagePriceDetail", method = RequestMethod.GET)
    public ResponseResult getCarParkPackagePriceDetail(HttpServletRequest httpServletRequest, String cfCarParkPackagePriceId) throws Exception {
        CfCarParkPackagePrice cfCarParkPackagePrice = cfCarParkPackagePriceService.findByIdContainName(cfCarParkPackagePriceId);
        if(cfCarParkPackagePrice!=null && cfCarParkPackagePrice.getId()!=null){
            return new ResponseResult(CommonCode.SUCCESS, cfCarParkPackagePrice);
        }
        return new ResponseResult(CommonCode.NO_MORE_DATAS);
    }
}
