package com.cf.pay.api.controller;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.utils.HttpHearderUtils;
import com.cf.pay.api.config.AuthenticationInterceptor;
import com.cf.pay.api.swagger.CfOrderSwagger;
import com.cf.pay.domain.CfOrder;
import com.cf.pay.domain.request.CfOrderQuery;
import com.cf.pay.service.CfOrderService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("pay/")
@Validated
public class CfOrderController implements CfOrderSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfOrderService cfOrderService;
    @Autowired
    protected HttpServletRequest request;

    @Override
    @RequestMapping(value = "orderList", method = RequestMethod.GET)
    public ResponseResult orderList(CfOrderQuery cfOrderQuery) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        cfOrderQuery.setUid(userBasicInfo.getId());
        //如果未指定排序，排序按更新时间进行倒叙
        if(StringUtils.isEmpty(cfOrderQuery.getOrderBy())){
            cfOrderQuery.setOrderBy("update_time desc");
        }
        List<CfOrder> cfOrders = cfOrderService.getListByQuery(cfOrderQuery);
        if(cfOrders==null || cfOrders.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfOrders);
    }
}
