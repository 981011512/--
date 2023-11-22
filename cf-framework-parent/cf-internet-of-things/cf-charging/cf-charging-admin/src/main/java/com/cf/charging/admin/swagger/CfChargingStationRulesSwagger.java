package com.cf.charging.admin.swagger;

import com.cf.charging.domain.request.CfChargingStationRulesForm;
import com.cf.charging.domain.request.CfChargingStationRulesQuery;
import com.cf.framework.domain.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags = {"充电站收费规则管理"})
public interface CfChargingStationRulesSwagger {

    @ApiOperation(value = "添加收费规则")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult add(CfChargingStationRulesForm cfChargingStationRulesForm) throws Exception;

    @ApiOperation(value = "更新收费规则")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult update(CfChargingStationRulesForm cfChargingStationRulesForm) throws Exception;

    @ApiOperation(value = "删除收费规则")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name="id",value = "设备id",required=false,paramType="query",dataType="string")
    })
    public ResponseResult delete(String id) throws Exception;

    @ApiOperation(value = "根据Query查询数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult getListByQuery(CfChargingStationRulesQuery cfChargingStationRulesQuery) throws Exception;

}
