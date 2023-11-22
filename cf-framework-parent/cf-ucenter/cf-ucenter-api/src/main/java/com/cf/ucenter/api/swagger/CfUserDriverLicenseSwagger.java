package com.cf.ucenter.api.swagger;

import com.cf.framework.domain.response.ResponseResult;
import com.cf.ucenter.request.CfUserDriverLicenseForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @ClassName CfUserDriverLicenseSwagger
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2022/06/30/025 11:30
 * @Version 1.0
 **/
@Api(tags = {"用户驾驶证信息管理"})
public interface CfUserDriverLicenseSwagger {

    @ApiOperation(value = "上传驾驶证信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    ResponseResult add(CfUserDriverLicenseForm cfUserDriverLicenseForm) throws Exception;

    @ApiOperation(value = "更新驾驶证信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    ResponseResult update(CfUserDriverLicenseForm cfUserDriverLicenseForm) throws Exception;

    @ApiOperation(value = "删除驾驶证信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    ResponseResult delete(Long id) throws Exception;

    @ApiOperation(value = "获取我的驾驶证信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    ResponseResult getMyIdCardInfo() throws Exception;

    @ApiOperation(value = "自动生成默认的驾驶证")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    ResponseResult autoAdd() throws Exception;

}
