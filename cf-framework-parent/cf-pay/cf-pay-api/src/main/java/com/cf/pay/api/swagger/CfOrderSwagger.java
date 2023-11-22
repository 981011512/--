package com.cf.pay.api.swagger;

import com.cf.framework.domain.response.ResponseResult;
import com.cf.pay.domain.request.CfOrderQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags = {"订单相关"})
public interface CfOrderSwagger {

    @ApiOperation(value = "订单列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
    })
    public ResponseResult orderList(CfOrderQuery cfOrderQuery) throws Exception;

}
