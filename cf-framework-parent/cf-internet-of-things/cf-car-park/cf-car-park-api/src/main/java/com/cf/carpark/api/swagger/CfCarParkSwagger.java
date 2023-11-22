package com.cf.carpark.api.swagger;

import com.cf.carpark.domain.request.CfCarParkForm;
import com.cf.carpark.domain.request.CfCarParkQuery;
import com.cf.framework.domain.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.math.BigDecimal;

@Api(tags = {"停车场相关"})
public interface CfCarParkSwagger {

    @ApiOperation(value = "查询附近停车场")
    @ApiImplicitParams({
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name="positionX",value = "位置经度",required=true,paramType="query",dataType="float"),
            @ApiImplicitParam(name="positionY",value = "位置纬度",required=true,paramType="query",dataType="float"),
            @ApiImplicitParam(name="page",value = "页码",required=false,paramType="query",dataType="int",defaultValue = "1"),
            @ApiImplicitParam(name="limit",value = "每页数据条数",required=false,paramType="query",dataType="int",defaultValue = "10"),
    })
    public ResponseResult selectNearbyDatas(BigDecimal positionX, BigDecimal positionY, Integer page, Integer limit) throws Exception;

    @ApiOperation(value = "根据条件查询停车场列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult getListByQuery(CfCarParkQuery cfCarParkQuery) throws Exception;

    @ApiOperation(value = "获取指定停车场的收费规则")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name="carParkId",value = "停车场id",required=true,paramType="query",dataType="string"),
    })
    public ResponseResult getCarParkChargingRules(String carParkId) throws Exception;

    @ApiOperation(value = "根据传入的经纬度(计算距离)和优惠券id查询该优惠券可用的停车场列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name="positionX",value = "位置经度",required=true,paramType="query",dataType="float"),
            @ApiImplicitParam(name="positionY",value = "位置纬度",required=true,paramType="query",dataType="float"),
            @ApiImplicitParam(name="couponId",value = "优惠券id(必须是停车场优惠id，其他类型优惠券可能无法返回数据)",required=true,paramType="query",dataType="string")
    })
    ResponseResult selectContalDistanceListByCouponId(BigDecimal positionX, BigDecimal positionY, String couponId) throws Exception;

    @ApiOperation(value = "获取mqtt协议连接数最少的服务器ip")
    @ApiImplicitParams({
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public String getMqttLinkIp() throws Exception;

    @ApiOperation(value = "测试")
    public Object test() throws Exception;
}
