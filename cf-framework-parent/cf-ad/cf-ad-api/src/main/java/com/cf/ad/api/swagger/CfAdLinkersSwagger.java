package com.cf.ad.api.swagger;

import com.cf.ad.domain.request.AdCounts;
import com.cf.ad.domain.request.CfAdLinksQuery;
import com.cf.framework.domain.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags = {"广告关联接口"})
public interface CfAdLinkersSwagger {

    @ApiOperation(value = "根据Query条件查询数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    ResponseResult getListByQuery(CfAdLinksQuery cfAdLinksQuery) throws Exception;

    @ApiOperation(value = "根据Query条件查询数据(含广告数据)")
    @ApiImplicitParams({
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    ResponseResult selectContainAdByQuery(CfAdLinksQuery cfAdLinksQuery) throws Exception;

    @ApiOperation(value = "广告统计")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    ResponseResult adCounts(AdCounts adCounts) throws Exception;
}
