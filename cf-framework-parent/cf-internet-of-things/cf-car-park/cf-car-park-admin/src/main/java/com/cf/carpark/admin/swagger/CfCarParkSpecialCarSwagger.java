package com.cf.carpark.admin.swagger;

import com.cf.carpark.domain.request.CfCarParkCarLimitForm;
import com.cf.carpark.domain.request.CfCarParkCarLimitQuery;
import com.cf.carpark.domain.request.CfCarParkSpecialCarForm;
import com.cf.carpark.domain.request.CfCarParkSpecialCarQuery;
import com.cf.framework.domain.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Api(tags = {"特殊车辆管理"})
public interface CfCarParkSpecialCarSwagger {

    @ApiOperation(value = "添加")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult add(CfCarParkSpecialCarForm cfCarParkSpecialCarForm);

    @ApiOperation(value = "更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult update(CfCarParkSpecialCarForm cfCarParkSpecialCarForm);

    @ApiOperation(value = "删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult delete(String id);

    @ApiOperation(value = "根据Query条件查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult getListByQuery(CfCarParkSpecialCarQuery cfCarParkSpecialCarQuery) throws Exception;

    @ApiOperation(value = "根据Query条件查询,包含停车场信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult selectContinCarParkByQuery(CfCarParkSpecialCarQuery cfCarParkSpecialCarQuery) throws Exception;

    @ApiOperation(value = "批量导入特殊车辆数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    ResponseResult importExcelParkSpecialCar(@RequestParam(value = "file", required = true) MultipartFile file) throws Exception;
}
