package com.cf.logistics.admin.swagger;

import com.cf.framework.domain.response.ResponseResult;
import com.cf.logistics.domain.request.CfLogisticsLedDeviceForm;
import com.cf.logistics.domain.request.CfLogisticsLedDeviceQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags = {"物流LED设备管理"})
public interface CfLogisticsLedDeviceSwagger {

    @ApiOperation(value = "添加物流LED设备")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
    })
    public ResponseResult add(CfLogisticsLedDeviceForm cfLogisticsLedDeviceForm) throws Exception;

    @ApiOperation(value = "更新物流LED设备")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult update(CfLogisticsLedDeviceForm cfLogisticsLedDeviceForm);

    @ApiOperation(value = "删除物流LED设备")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name="id",value = "物流LED设备id",required=false,paramType="query",dataType="string")
    })
    public ResponseResult delete(Long id);

    @ApiOperation(value = "根据Query条件查询数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult getListByQuery(CfLogisticsLedDeviceQuery cfLogisticsLedDeviceQuery) throws Exception;

    @ApiOperation(value = "发送tcp数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name="serialNumber",value = "物流LED设备序列号",required=true,paramType="query",dataType="string"),
            @ApiImplicitParam(name="screenWidth",value = "屏幕宽度",required=false,paramType="query",dataType="int", defaultValue = "256"),
            @ApiImplicitParam(name="screenHigh",value = "屏幕高度",required=false,paramType="query",dataType="int", defaultValue = "48"),
            @ApiImplicitParam(name="x",value = "节目开始横向位置",required=false,paramType="query",dataType="int", defaultValue = "0"),
            @ApiImplicitParam(name="y",value = "节目开始纵向位置",required=false,paramType="query",dataType="int", defaultValue = "0"),
            @ApiImplicitParam(name="width",value = "节目宽",required=false,paramType="query",dataType="int", defaultValue = "256"),
            @ApiImplicitParam(name="high",value = "节目高",required=false,paramType="query",dataType="int", defaultValue = "48"),
            @ApiImplicitParam(name="fontRowSpacing",value = "当页内容行间距",required=false,paramType="query",dataType="int", defaultValue = "0"),
            @ApiImplicitParam(name="contents",value = "显示内容",required=true,paramType="query",dataType="string")
    })
    public ResponseResult setTcpData(String serialNumber, Integer screenWidth, Integer screenHigh, Integer x, Integer y, Integer width, Integer high, Integer fontRowSpacing, String contents) throws Exception;


    @ApiOperation(value = "刷新led大屏显示数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name="queuingAreaId",value = "队列id(排队区域)",required=true,paramType="query",dataType="string")
    })
    public ResponseResult flushLesScreenData(Long queuingAreaId) throws Exception;

}
