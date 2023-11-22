package com.cf.ucenter.admin.swagger;

import com.cf.framework.domain.response.ResponseResult;
import com.cf.ucenter.domain.CfUserDriverLicense;
import com.cf.ucenter.request.CfUserDriverLicenseForm;
import com.cf.ucenter.request.CfUserDriverLicenseQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 部门相关
 *
 * @ClassName DepartmentSwagger
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2022/12/21/021 14:57
 * @Version 1.0
 **/
@Api(tags = {"用户驾驶证管理"})
public interface CfUserDriverLicenseSwagger {

    @ApiOperation(value = "驾驶证列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string")
    })
    public ResponseResult getListByQuery(CfUserDriverLicenseQuery cfUserDriverLicenseQuery);

    @ApiOperation(value = "添加驾驶证")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string")
    })
    public ResponseResult add(CfUserDriverLicenseForm cfUserDriverLicenseForm) throws Exception;

    @ApiOperation(value = "更新驾驶证")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string")
    })
    public ResponseResult update(CfUserDriverLicenseForm cfUserDriverLicenseForm) throws Exception;

    @ApiOperation(value = "删除驾驶证")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="id",value = "数据id",required=true,paramType="query",dataType="long")
    })
    public ResponseResult delete(Long id);

    @ApiOperation(value = "手动同步TMS系统数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string")
    })
    public ResponseResult manuallySynchronizeTmsSystemData() throws Exception;

    @ApiOperation(value = "批量导入司机数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    ResponseResult importExcelUserDriverLicense(@RequestParam(value = "file", required = true) MultipartFile file) throws Exception;

}
