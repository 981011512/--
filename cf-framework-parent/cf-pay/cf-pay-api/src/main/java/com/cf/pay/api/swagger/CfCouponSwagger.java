package com.cf.pay.api.swagger;

import com.cf.framework.domain.response.ResponseResult;
import com.cf.pay.domain.CfCoupon;
import com.cf.pay.domain.request.CfCouponForm;
import com.cf.pay.domain.request.CfCouponQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;

@Api(tags = {"优惠券相关"})
public interface CfCouponSwagger {

    @ApiOperation(value = "优惠券列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
    })
    public ResponseResult orderList(CfCouponQuery cfCouponQuery) throws Exception;

    @ApiOperation(value = "绑定优惠作用商品id")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
    })
    public ResponseResult bindGoodsId(@RequestBody CfCouponQuery cfCouponQuery) throws Exception;

}
