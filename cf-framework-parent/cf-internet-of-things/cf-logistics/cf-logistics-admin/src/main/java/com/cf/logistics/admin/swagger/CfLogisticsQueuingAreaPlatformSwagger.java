package com.cf.logistics.admin.swagger;

import com.cf.framework.domain.response.ResponseResult;
import com.cf.logistics.domain.request.CfLogisticsQueuingAreaPlatformForm;
import com.cf.logistics.domain.request.CfLogisticsQueuingAreaPlatformQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags = {"物流排队区域关联月台管理"})
public interface CfLogisticsQueuingAreaPlatformSwagger {

    @ApiOperation(value = "添加物流排队区域关联月台")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
    })
    public ResponseResult add(CfLogisticsQueuingAreaPlatformForm cfLogisticsQueuingAreaPlatformForm) throws Exception;

    @ApiOperation(value = "更新物流排队区域关联月台")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult update(CfLogisticsQueuingAreaPlatformForm cfLogisticsQueuingAreaPlatformForm);

    @ApiOperation(value = "删除物流排队区域关联月台")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name="id",value = "物流排队区域关联月台id",required=false,paramType="query",dataType="string")
    })
    public ResponseResult delete(Long id);

    @ApiOperation(value = "根据Query条件查询数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult selectByQuery(CfLogisticsQueuingAreaPlatformQuery cfLogisticsQueuingAreaPlatformQuery) throws Exception;

}
