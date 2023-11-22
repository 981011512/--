package com.cf.carpark.api.swagger;

import com.cf.carpark.domain.request.CfCarParkChargingRulesQuery;
import com.cf.framework.domain.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags = {"收费规则"})
public interface CfCarParkChargingRulesSwagger {
    @ApiOperation(value = "获取停车场收费规则")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult getListByQuery(CfCarParkChargingRulesQuery cfCarParkChargingRulesQuery) throws Exception;
}
