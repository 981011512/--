package com.cf.carpark.api.swagger;

import com.cf.carpark.domain.request.CfCarParkUseLogForm;
import com.cf.carpark.domain.request.CfCarParkUseLogQuery;
import com.cf.framework.domain.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Api(tags = {"停车记录管理"})
public interface CfCarParkUseLogSwagger {

    public String getHttpData(HttpServletRequest httpServletRequest) throws Exception;

    @ApiOperation(value = "添加记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name="contents",value = "推送内容",required=false,paramType="query",dataType="string"),
            @ApiImplicitParam(name="deviceBrand",value = "硬件品牌",required=false,paramType="query",dataType="string")
    })
    public Object add(HttpServletRequest httpServletRequest, HttpServletResponse response, String contents, String deviceBrand) throws Exception;

    @ApiOperation(value = "获取停车记录")
    @ApiImplicitParams({
//            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult getCarParkUseLogList(CfCarParkUseLogQuery cfCarParkUseLogQuery) throws Exception;

    @ApiOperation(value = "轮询监听")
    @ApiImplicitParams({
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name="deviceBrand",value = "硬件品牌",required=true,paramType="query",dataType="string")
    })
    public Object pollingMonitoring(HttpServletRequest httpServletRequest, String deviceBrand) throws Exception;

    @ApiOperation(value = "申请通行(无牌或无法识别车牌)")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name="direction",value = "方向(in/out)",required=true,paramType="query",dataType="string"),
            @ApiImplicitParam(name="checkPointId",value = "关卡id",required=true,paramType="query",dataType="string"),
            @ApiImplicitParam(name="type",value = "放行类型(1-正常放行/2-异常放行)",required=true,paramType="query",dataType="byte"),
            @ApiImplicitParam(name="deviceNo",value = "设备编号",required=false,paramType="query",dataType="string")
    })
    public ResponseResult applyForAccess(
        @Pattern(regexp = "^(in|out){1}$", message = "请提供方向in/out")
         String direction,
        @NotEmpty(message = "请提供关卡id")
         String checkPointId,
        @Min(value = 1, message = "1-正常放行/2-异常放行")
        @Max(value = 2, message = "1-正常放行/2-异常放行")
                byte type,
        String deviceNo
        ) throws Exception;

    @ApiOperation(value = "预订车位")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult subscribeParkingSpace(HttpServletRequest httpServletRequest, CfCarParkUseLogForm cfCarParkUseLogForm) throws Exception;

    @ApiOperation(value = "获取指定出口关卡最新的车牌识别记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult getLastCarParkUseLogList(CfCarParkUseLogQuery cfCarParkUseLogQuery) throws Exception;

    @ApiOperation(value = "测试建行扫码扣款支付")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name="cfCarParkUseLogId",value = "停车记录id",required=true,paramType="query",dataType="string"),
            @ApiImplicitParam(name="numberPlate",value = "车牌号",required=true,paramType="query",dataType="string")
    })
    public ResponseResult ccbPayTest(String cfCarParkUseLogId, String numberPlate) throws Exception;

    @ApiOperation(value = "人工主动上报停车记录(断电断网  人工手机一键快捷补录停车数据)")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name="carParkCheckPointId",value = "通道(出入口)id",required=true,paramType="query",dataType="string"),
            @ApiImplicitParam(name="time",value = "进入或进出时间",required=false,paramType="query",dataType="long"),
            @ApiImplicitParam(name="platform",value = "文件服务平台(默认ali_oss)",required=false,paramType="query",dataType="string", defaultValue = "ali_oss")
    })
    ResponseResult manuallyUpload(MultipartFile file, String carParkCheckPointId, Long time, String platform) throws Exception;
}
