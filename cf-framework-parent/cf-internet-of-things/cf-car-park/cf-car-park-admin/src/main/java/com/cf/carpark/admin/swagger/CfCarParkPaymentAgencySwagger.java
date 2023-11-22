package com.cf.carpark.admin.swagger;

import com.cf.carpark.domain.CfCarParkPaymentAgency;
import com.cf.carpark.domain.request.CfCarParkPaymentAgencyForm;
import com.cf.carpark.domain.request.CfCarParkPaymentAgencyQuery;
import com.cf.framework.domain.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.List;

/**
 * 停车场关联支付账户管理
 *
 * @ClassName CfCarParkPackageSwagger
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/12/31/031 10:03
 * @Version 1.0
 **/
@Api(tags = {"停车场收款账户"})
public interface CfCarParkPaymentAgencySwagger {

    @ApiOperation(value = "新增停车场收款账户")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
    })
    ResponseResult add(CfCarParkPaymentAgencyForm cfCarParkPaymentAgencyForm) throws Exception;

    @ApiOperation(value = "更新停车场收款账户")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
    })
    ResponseResult update(CfCarParkPaymentAgencyForm cfCarParkPaymentAgencyForm) throws Exception;

    @ApiOperation(value = "解除停车场收款账户")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
    })
    ResponseResult delete(String id) throws Exception;

    @ApiOperation(value = "根据条件搜索停车场收款账户")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
    })
    ResponseResult selectByQuery(CfCarParkPaymentAgencyQuery cfCarParkPaymentAgencyQuery) throws Exception;

}
