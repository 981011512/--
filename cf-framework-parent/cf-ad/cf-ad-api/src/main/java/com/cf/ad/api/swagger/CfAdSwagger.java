package com.cf.ad.api.swagger;

import com.cf.framework.domain.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags = {"广告接口"})
public interface CfAdSwagger {

    @ApiOperation(value = "根据id获取广告详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name="id",value = "广告id",required=true,paramType="query",dataType="long")
    })
    ResponseResult findById(String id) throws Exception;
}
