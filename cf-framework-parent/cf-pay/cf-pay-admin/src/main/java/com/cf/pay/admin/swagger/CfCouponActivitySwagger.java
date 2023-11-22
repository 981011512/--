package com.cf.pay.admin.swagger;

import com.cf.framework.domain.response.ResponseResult;
import com.cf.pay.domain.request.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

@Api(tags = {"优惠券活动管理相关"})
public interface CfCouponActivitySwagger {

    @ApiOperation(value = "根据条件查询活动数据列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name="conditions",
                    value = "条件,例子{\"id\":{\"operator\":\"=\",\"value\":200},\"province_id\":{\"operator\":\"between\",\"min\":200,\"max\":300},\"order\":" +
                            "{\"operator\":\"order\",\"list\":{\"id\":{\"type\":\"DESC\",\"alias\":\"cp\"},\"country_id\":{\"type\":\"ASC\",\"alias\":\"cp\"}}}," +
                            "\"limit\":{\"operator\":\"limit\",\"page\":1,\"limit\":10},\"like\":{\"operator\":\"like\",\"list\":{\"name\":{\"0\":{\"value\":\"绿地国博\"," +
                            "\"alias\":\"cp\"},\"1\":{\"value\":\"财富中心\",\"alias\":\"cp\"}},\"country_id\":{\"0\":{\"value\":\"1111\",\"alias\":\"cp\"},\"1\":{\"value\":\"2222\"," +
                            "\"alias\":\"cp\"}}}}}解析出的sql为：SELECT cp.* FROM cf_car_park cp WHERE cp.id=200 AND cp.province_id>=200 AND cp.province_id<=300 AND (cp.name LIKE '%绿地国博%'" +
                            " OR cp.name LIKE '%财富中心%')  AND (cp.country_id LIKE '%1111%' OR cp.country_id LIKE '%2222%') ORDER BY cp.id DESC,cp.country_id ASC LIMIT 0,10",
                    required=true,paramType="query",dataType="string")
    })
    public ResponseResult selectListByCondition(String conditions) throws Exception;

    @ApiOperation(value = "获取优惠券活动详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name="activityId",value = "活动id",required=true,paramType="query",dataType="string")
    })
    ResponseResult activityDetail(String activityId) throws Exception;

    @ApiOperation(value = "添加优惠券活动优惠券类型(设置发券时的 金额,有效期)")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
    })
    ResponseResult addCouponActivityCouponType(CfCouponActivityCouponTypeForm cfCouponActivityCouponTypeForm) throws Exception;

    @ApiOperation(value = "更新优惠券活动优惠券类型(设置发券时的 金额,有效期)")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
    })
    ResponseResult updateCouponActivityCouponType(CfCouponActivityCouponTypeForm cfCouponActivityCouponTypeForm) throws Exception;

    @ApiOperation(value = "删除优惠券活动优惠券类型")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name="couponActivityCouponTypeId",value = "优惠券活动优惠券类型数据id",required=true,paramType="query",dataType="string")
    })
    ResponseResult deleteCouponActivityCouponType(String couponActivityCouponTypeId) throws Exception;

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

    @ApiOperation(value = "给优惠活动充值")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name="couponActivityId",value = "优惠券活动id",required=true,paramType="query",dataType="string"),
            @ApiImplicitParam(name="amountOfMoney",value = "充值金额",required=true,paramType="query",dataType="string"),
            @ApiImplicitParam(name="useScenes",value = "使用场景(wx_web微信网页/wx_mp微信小程序/app/ali_web阿里网页/web-网页通用)",required=true,paramType="query",dataType="string"),
            @ApiImplicitParam(name="couponType",value = "优惠券类型(1-次数券/2-金额券/3-时长券)",required=false,paramType="query",dataType="byte")
    })
    ResponseResult rechargeToCouponActivity(HttpServletRequest httpServletRequest, String couponActivityId, BigDecimal amountOfMoney, String useScenes, Byte couponType) throws Exception;

    @ApiOperation(value = "添加优惠券活动")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
    })
    ResponseResult add(CfCouponActivityForm cfCouponActivityForm) throws Exception;

    @ApiOperation(value = "更新优惠券活动")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
    })
    ResponseResult update(CfCouponActivityForm cfCouponActivityForm) throws Exception;

    @ApiOperation(value = "删除优惠券活动")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name="id",value = "活动id",required=true,paramType="query",dataType="string")
    })
    ResponseResult delete(String id) throws Exception;

    @ApiOperation(value = "获取活动相关店铺")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name="couponActivityType",value = "优惠券活动类型(0-通用/1-停车场/2-传统商城)",required=true,paramType="query",dataType="byte"),
            @ApiImplicitParam(name="couponActivityId",value = "活动id",required=true,paramType="query",dataType="string")
    })
    ResponseResult getCouponActivityLinkShops(byte couponActivityType, String couponActivityId) throws Exception;

    @ApiOperation(value = "添加活动关联店铺")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
    })
    ResponseResult addActivityLinkShop(CfCouponActivityLinkShopForm cfCouponActivityLinkShopForm) throws Exception;

    @ApiOperation(value = "更新活动关联店铺")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
    })
    ResponseResult updateActivityLinkShop(CfCouponActivityLinkShopForm cfCouponActivityLinkShopForm) throws Exception;

    @ApiOperation(value = "删除活动关联店铺")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
    })
    ResponseResult deleteActivityLinkShop(String cfCouponActivityLinkShopId) throws Exception;



}
