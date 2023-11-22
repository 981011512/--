package com.cf.pay.api.swagger;

import com.cf.framework.domain.response.ResponseResult;
import com.cf.pay.domain.request.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

@Api(tags = {"优惠券活动相关"})
public interface CfCouponActivitySwagger {

    @ApiOperation(value = "获取我的优惠券活动列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
    })
    ResponseResult getMyCouponActivityList(CfCouponActivityQuery cfCouponActivityQuery) throws Exception;

    @ApiOperation(value = "获取优惠券活动详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name="activityId",value = "活动id",required=true,paramType="query",dataType="string")
    })
    ResponseResult activityDetail(String activityId) throws Exception;

    @ApiOperation(value = "店主添加优惠券活动优惠券类型(设置发券时的 金额,有效期)")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
    })
    ResponseResult shopkeeperAddCouponActivityCouponType(CfCouponActivityCouponTypeForm cfCouponActivityCouponTypeForm) throws Exception;

    @ApiOperation(value = "店主更新优惠券活动优惠券类型(设置发券时的 金额,有效期)")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
    })
    ResponseResult shopkeeperUpdateCouponActivityCouponType(CfCouponActivityCouponTypeForm cfCouponActivityCouponTypeForm) throws Exception;

    @ApiOperation(value = "店主删除优惠券活动优惠券类型")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name="couponActivityCouponTypeId",value = "优惠券活动优惠券类型数据id",required=true,paramType="query",dataType="string")
    })
    ResponseResult shopkeeperDeleteCouponActivityCouponType(String couponActivityCouponTypeId) throws Exception;

    @ApiOperation(value = "获取优惠券活动优惠券类型")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
    })
    ResponseResult getCouponActivityCouponTypeListByQuery(CfCouponActivityCouponTypeQuery cfCouponActivityQuery) throws Exception;

    @ApiOperation(value = "获取发券记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
    })
    ResponseResult getCouponActivityCouponLogList(CfStaffCouponLogQuery cfStaffCouponLogQuery) throws Exception;

    @ApiOperation(value = "员工生成领券二维码")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
    })
    ResponseResult staffCreateCouponQrCode(CfQrCodeForm cfQrCodeForm) throws Exception;

    @ApiOperation(value = "员工或者店主直接给车辆赠送优惠券")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    ResponseResult staffOrShopkeeperGiveCouponToCar(StaffOrShopkeeperGiveCouponToCar staffOrShopkeeperGiveCouponToCar) throws Exception;

    @ApiOperation(value = "通过二维码领取优惠券")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    ResponseResult getCouponByQrCode(GetCouponByQrCode getCouponByQrCode) throws Exception;

    @ApiOperation(value = "给优惠活动充值")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    ResponseResult rechargeToCouponActivity(HttpServletRequest httpServletRequest, RechargeToCouponActivity rechargeToCouponActivity) throws Exception;



}
