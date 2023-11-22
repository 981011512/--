package com.cf.charging.admin.swagger;

import com.cf.charging.domain.request.CfChargingStationLinkUserForm;
import com.cf.charging.domain.request.CfChargingStationLinkUserQuery;
import com.cf.framework.domain.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags = {"充电站关联人员管理"})
public interface CfChargingStationLinkUserSwagger {

    @ApiOperation(value = "添加充电站关联人员")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult add(CfChargingStationLinkUserForm cfChargingStationLinkUserForm) throws Exception;

    @ApiOperation(value = "更新充电站关联人员")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult update(CfChargingStationLinkUserForm cfChargingStationLinkUserForm);

    @ApiOperation(value = "根据条件查询充电站关联人员数据列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")

    })
    public ResponseResult getListByQuery(CfChargingStationLinkUserQuery cfChargingStationLinkUserQuery) throws Exception;

    @ApiOperation(value = "删除充电站关联人员")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name="id",value = "充电站关联人员数据id",required=false,paramType="query",dataType="string")
    })
    public ResponseResult delete(String id) throws Exception;

}
