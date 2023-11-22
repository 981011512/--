package com.cf.logistics.admin.swagger;

import com.cf.framework.domain.response.ResponseResult;
import com.cf.logistics.domain.request.CfLogisticsTaskLogForm;
import com.cf.logistics.domain.request.CfLogisticsTaskLogQuery;
import com.cf.logistics.domain.request.ReserveParams;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags = {"物流任务预约管理"})
public interface CfLogisticsTaskLogSwagger {

    @ApiOperation(value = "添加物流任务预约")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
    })
    public ResponseResult add(CfLogisticsTaskLogForm cfLogisticsTaskLogForm) throws Exception;

    @ApiOperation(value = "更新物流任务预约")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult update(CfLogisticsTaskLogForm cfLogisticsTaskLogForm) throws Exception;

    @ApiOperation(value = "删除物流任务预约")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name="id",value = "物流任务预约id",required=false,paramType="query",dataType="string")
    })
    public ResponseResult delete(Long id) throws Exception;

    @ApiOperation(value = "根据Query条件查询数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult selectListByQuery(CfLogisticsTaskLogQuery cfLogisticsTaskLogQuery) throws Exception;

    @ApiOperation(value = "根据Query条件查询数据(含驾驶证)")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult selectDeliverListByQuery(CfLogisticsTaskLogQuery cfLogisticsTaskLogQuery) throws Exception;

    @ApiOperation(value = "获取用户数据证件数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name="taskLogId",value = "预约记录id",required=false,paramType="query",dataType="long")
    })
    public ResponseResult getUserIdentityInformaiton(Long taskLogId) throws Exception;

    @ApiOperation(value = "通过记录id获取任务详情和司机信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name="taskLogId",value = "预约记录id",required=false,paramType="query",dataType="long")
    })
    public ResponseResult getLogInfoAndUserIdentityInformaiton(Long taskLogId) throws Exception;

    @ApiOperation(value = "代人预约")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult helpOthersMakeAnAppointment(CfLogisticsTaskLogForm cfLogisticsTaskLogForm) throws Exception;

    @ApiOperation(value = "取消预约")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name="taskLogId",value = "任务预约记录id",required=true,paramType="query",dataType="long")
    })
    public ResponseResult cancelAppointment(Long taskLogId) throws Exception;

    @ApiOperation(value = "预约任务更换司机")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult taskUseLogChangeDriver(ReserveParams reserveParams) throws Exception;

    @ApiOperation(value = "物流任务货物核对")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name="taskLogId",value = "预约记录id",required=false,paramType="query",dataType="long")
    })
    public ResponseResult cargoCheck(Long taskLogId) throws Exception;

    @ApiOperation(value = "确认车辆入库")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name="taskLogId",value = "预约记录id",required=false,paramType="query",dataType="long")
    })
    public ResponseResult confirmVehicleStorage(Long taskLogId) throws Exception;

    @ApiOperation(value = "通过手机号查看指定用户是否存在并且身份证和驾驶证是否正常")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name="phone",value = "手机号",required=true,paramType="query",dataType="string")
    })
    public ResponseResult checkUserDocumentsStatusByPhone(String phone) throws Exception;

    @ApiOperation(value = "任务预约记录顺序置顶")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name="taskLogId",value = "任务预约记录id",required=true,paramType="query",dataType="long")
    })
    public ResponseResult logisticsTaskLogTop(Long taskLogId) throws Exception;

    @ApiOperation(value = "过号处理")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name="taskLogId",value = "任务预约记录id",required=true,paramType="query",dataType="long")
    })
    public ResponseResult numberOver(Long taskLogId) throws Exception;

    @ApiOperation(value = "更换队列(排队区域)")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name="taskLogId",value = "任务预约记录id",required=true,paramType="query",dataType="long"),
            @ApiImplicitParam(name="queuingAreaId",value = "任务预约记录id",required=true,paramType="query",dataType="long")
    })
    public ResponseResult changeQueuingArea(Long taskLogId, Long queuingAreaId) throws Exception;

}
