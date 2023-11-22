package com.cf.charging.api.swagger;

import com.cf.charging.domain.request.CfChargingStationDeviceForm;
import com.cf.charging.domain.request.CfChargingStationDeviceQuery;
import com.cf.charging.domain.request.CfChargingStationForm;
import com.cf.charging.domain.request.CfChargingStationQuery;
import com.cf.framework.domain.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags = {"充电站设备相关"})
public interface CfChargingStationDeviceSwagger {

    @ApiOperation(value = "根据Query条件查询数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult getListByQuery(CfChargingStationDeviceQuery cfChargingStationDeviceQuery) throws Exception;

    @ApiOperation(value = "开始充电")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult startCharging(CfChargingStationDeviceForm cfChargingStationDeviceForm) throws Exception;

    @ApiOperation(value = "停止充电")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult stopCharging(CfChargingStationDeviceForm cfChargingStationDeviceForm) throws Exception;

}
