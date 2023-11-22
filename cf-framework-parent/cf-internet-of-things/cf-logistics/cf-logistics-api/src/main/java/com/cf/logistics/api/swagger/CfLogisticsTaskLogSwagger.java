package com.cf.logistics.api.swagger;

import com.cf.framework.domain.response.ResponseResult;
import com.cf.logistics.domain.request.CfLogisticsTaskLogForm;
import com.cf.logistics.domain.request.CfLogisticsTaskLogQuery;
import com.cf.logistics.domain.request.ReserveParams;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;

@Api(tags = {"物流任务预约接口"})
public interface CfLogisticsTaskLogSwagger {

    @ApiOperation(value = "根据Query条件查询数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult selectListByQuery(CfLogisticsTaskLogQuery cfLogisticsTaskLogQuery) throws Exception;

    @ApiOperation(value = "获取预约详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name="taskLogId",value = "预约记录id",required=true,paramType="query",dataType="string")
    })
    public ResponseResult findById(Long taskLogId) throws Exception;

    @ApiOperation(value = "预约任务")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult reserveTask(ReserveParams reserveParams) throws Exception;

    @ApiOperation(value = "预约签到")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult reserveSignIn(ReserveParams reserveParams) throws Exception;

    @ApiOperation(value = "取消预约")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name="taskLogId",value = "任务预约记录id",required=true,paramType="query",dataType="long")
    })
    public ResponseResult cancelAppointment(Long taskLogId) throws Exception;

}
