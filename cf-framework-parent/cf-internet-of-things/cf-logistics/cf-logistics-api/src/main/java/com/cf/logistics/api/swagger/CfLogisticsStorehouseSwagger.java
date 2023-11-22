package com.cf.logistics.api.swagger;

import com.cf.framework.domain.response.ResponseResult;
import com.cf.logistics.domain.CfLogisticsStorehouse;
import com.cf.logistics.domain.request.CfLogisticsStorehouseForm;
import com.cf.logistics.domain.request.CfLogisticsStorehouseQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags = {"物流仓库接口"})
public interface CfLogisticsStorehouseSwagger {

    @ApiOperation(value = "根据名字模糊查询仓库数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult getListByQuery(CfLogisticsStorehouseQuery cfLogisticsStorehouseQuery) throws Exception;

    @ApiOperation(value = "根据仓库id查询仓库数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name="id",value = "物流仓库id",required=true,paramType="query",dataType="string")
    })
    public ResponseResult findById(Long id) throws Exception;

}
