package com.cf.carpark.admin.swagger;

import com.cf.carpark.domain.request.CfCarParkLinkUserForm;
import com.cf.carpark.domain.request.CfCarParkLinkUserQuery;
import com.cf.framework.domain.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 请在此填写描述
 *
 * @ClassName CfCarParkPackageSwagger
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/31/031 10:03
 * @Version 1.0
 **/
@Api(tags = {"停车场员工管理"})
public interface CfCarParkLinkUserSwagger {

    @ApiOperation(value = "新增停车场员工")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
    })
    public ResponseResult add(@Validated @RequestBody CfCarParkLinkUserForm cfCarParkLinkUserForm) throws Exception;

    @ApiOperation(value = "更新停车场员工")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
    })
    public ResponseResult update(@Validated @RequestBody CfCarParkLinkUserForm cfCarParkLinkUserForm) throws Exception;

    @ApiOperation(value = "删除停车场员工")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
    })
    public ResponseResult delete(String id) throws Exception;

    @ApiOperation(value = "根据条件获取停车场员工列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
    })
    public ResponseResult getCarParkLinkUserListByQuery(@Validated CfCarParkLinkUserQuery cfCarParkLinkUserQuery) throws Exception;



}
