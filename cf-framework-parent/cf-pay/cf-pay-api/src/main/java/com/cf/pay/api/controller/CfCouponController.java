package com.cf.pay.api.controller;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.utils.HttpHearderUtils;
import com.cf.pay.api.config.AuthenticationInterceptor;
import com.cf.pay.api.swagger.CfCouponSwagger;
import com.cf.pay.domain.CfCoupon;
import com.cf.pay.domain.request.CfCouponForm;
import com.cf.pay.domain.request.CfCouponQuery;
import com.cf.pay.domain.type.CouponScenes;
import com.cf.pay.domain.type.CouponStatus;
import com.cf.pay.service.CfCouponService;
import com.cf.pay.service.CfTaxAccountService;
import org.apache.commons.lang3.StringUtils;
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
@RequestMapping("coupon/")
@Validated
public class CfCouponController implements CfCouponSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCouponService cfCouponService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfTaxAccountService cfTaxAccountService;
    @Autowired
    protected HttpServletRequest request;

    @Override
    @RequestMapping(value = "orderList", method = RequestMethod.GET)
    public ResponseResult orderList(CfCouponQuery cfCouponQuery) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        if(StringUtils.isEmpty(cfCouponQuery.getGoodsId())){
            cfCouponQuery.setToUid(userBasicInfo.getId());
        }
        List<CfCoupon> cfCouponList = cfCouponService.getListByQuery(cfCouponQuery);
        if(cfCouponList==null || cfCouponList.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfCouponList);
    }

    @Override
    @RequestMapping(value = "bindGoodsId", method = RequestMethod.PUT)
    public ResponseResult bindGoodsId(@RequestBody CfCouponQuery cfCouponQuery) throws Exception {
        if(StringUtils.isEmpty(cfCouponQuery.getId())){
            return new ResponseResult(CommonCode.INVALID_PARAM,null,"请提供优惠券id");
        }
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        CfCoupon cfCoupon = new CfCoupon();
        cfCoupon.setGoodsId(cfCouponQuery.getGoodsId());
        cfCouponQuery.setToUid(userBasicInfo.getId());
        cfCouponQuery.setGoodsId("");
        cfCouponQuery.setStatus(CouponStatus.NOT_USED);
        int i = cfCouponService.updateByQuery(cfCouponQuery, cfCoupon);
        return i>0?new ResponseResult(CommonCode.SUCCESS):new ResponseResult(CommonCode.FAIL);
    }
}
