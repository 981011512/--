package com.cf.pay.api.swagger;

import com.cf.framework.domain.response.ResponseResult;
import com.cf.pay.domain.request.CfPaymentAgencyQuery;
import com.cf.pay.domain.request.CfUserPaymentAgencyQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 支付方式
 *
 * @ClassName CfUserPaymentAgencySwagger
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/29/029 7:31
 * @Version 1.0
 **/
@Api(tags = {"支付方式(机构)"})
public interface CfPaymentAgencySwagger {
    @ApiOperation(value = "获取停车场的支付方式(机构)")
    @ApiImplicitParams({
//            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name="carParkId",value = "停车场id",required=true,paramType="query",dataType="string"),
            @ApiImplicitParam(name="useScenes",value = "使用场景(wx_web微信网页/wx_mp微信网页/app/ali_web阿里网页/web-网页通用)",required=true,paramType="query",dataType="string"),
    })
    public ResponseResult getPaymentAgencyListByCarParkId(String carParkId, String useScenes);

    @ApiOperation(value = "根据条件获取支付机构列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult getPaymentAgencyListByQuery(CfPaymentAgencyQuery cfPaymentAgencyQuery);

    @ApiOperation(value = "根据条件获取支付账号基础数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult getUserPaymentAgencyListByQuery(CfUserPaymentAgencyQuery cfUserPaymentAgencyQuery);
}
