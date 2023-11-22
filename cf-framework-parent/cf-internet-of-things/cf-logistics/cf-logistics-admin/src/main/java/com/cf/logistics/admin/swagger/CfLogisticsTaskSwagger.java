package com.cf.logistics.admin.swagger;

import com.cf.framework.domain.response.ResponseResult;
import com.cf.logistics.domain.request.CfLogisticsTaskForm;
import com.cf.logistics.domain.request.CfLogisticsTaskQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags = {"物流任务管理"})
public interface CfLogisticsTaskSwagger {

    @ApiOperation(value = "第三方任务推送")
    @ApiImplicitParams({
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
    })
    public ResponseResult thirdPartyPaskPush(CfLogisticsTaskForm cfLogisticsTaskForm) throws Exception;

    @ApiOperation(value = "第三方任务更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
    })
    public ResponseResult thirdPartyPaskUpdate(CfLogisticsTaskForm cfLogisticsTaskForm) throws Exception;

    @ApiOperation(value = "第三方任务删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
    })
    public ResponseResult thirdPartyPaskDelete(CfLogisticsTaskForm cfLogisticsTaskForm) throws Exception;

    @ApiOperation(value = "添加物流任务")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
    })
    public ResponseResult add(CfLogisticsTaskForm cfLogisticsTaskForm) throws Exception;

    @ApiOperation(value = "更新物流任务")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult update(CfLogisticsTaskForm cfLogisticsTaskForm) throws Exception;

    @ApiOperation(value = "删除物流任务")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name="id",value = "物流任务id",required=false,paramType="query",dataType="string")
    })
    public ResponseResult delete(Long id) throws Exception;

    @ApiOperation(value = "根据Query条件查询数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult selectListByQuery(CfLogisticsTaskQuery cfLogisticsTaskQuery) throws Exception;

    @ApiOperation(value = "切换父子任务或子任务之间的顺序")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name="taskId",value = "物流任务id",required=true,paramType="query",dataType="long"),
            @ApiImplicitParam(name="sortIndex",value = "任务排序序号",required=true,paramType="query",dataType="int")
    })
    public ResponseResult changeSortIndex(Long taskId, Integer sortIndex) throws Exception;

}
