package com.cf.framework.domain.carpark.response;

import com.cf.framework.domain.response.ResultCode;

/**
 * 停车场返回
 *
 * @ClassName MessageCode
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/12/15/015 21:45
 * @Version 1.0
 **/
public enum CarParkCode implements ResultCode {

    BIND_CAR_REACHED_THE_UPPER_LIMIT(false,11000,"绑定车辆已达上限！"),
    BIND_LICENSE_PLATES_REPEATEDLY(false,11001,"重复绑定车牌！"),
    DEVICE_IS_NOT_REGISTERED(false,11002,"设备未注册！"),
    UNABLE_TO_PARSE_DEVICE_DATA(false,11003,"无法解析设备数据！"),
    CAR_PARK_NOT_EXISTS(false,11004,"指定的停车场不存在！"),
    MISS_PARKING_ID_AND_LICENSE_PLATE_NUMBER(false,11005,"请提供停车场id和车牌号！"),
    PARKING_LOT_RECORD_DOES_NOT_EXIST(false,11006,"指定的停车记录不存在！"),
    AN_EXCEPTION_IN_THIS_RECORD(false,11007,"记录存在异常！"),
    CHECKPOINT_DOES_NOT_EXIST(false,11008,"进出口关卡不存在！"),
    END_TIME_MUST_BE_GREATER_THAN_START_TIME(false,11009,"结束时间必须大于开始时间！"),
    CHARGING_RULES_NOT_FOUND(false,11010,"没有找到收费规则！"),
    BRAND_DEVICES_THAT_IS_NOT_CURRENTLY_SUPPORTED(false,11011,"暂时未支持的品牌设备！"),
    DEVICE_BRAND_IS_NOT_SPECIFIED(false,11012,"设备品牌未指定！"),
    DEVICE_SERIAL_NUMBER_IS_NOT_SPECIFIED(false,11013,"设备序列号未指定！"),
    REPEAT_APPLY_FORACCESS(false,11014,"重复申请通行！"),
    APPLY_FORACCESS_NOT_FOUND(false,11015,"申请通行记录不存在！"),
    UNPAID_PARKING_FEE(false,11016,"未缴纳停车费！"),
    TOO_CLOSE_TO_SUBSCRIPTION_TIME(false,11017,"距离订阅时间太近！"),
    TOO_LONG_TO_SUBSCRIBE(false,11018,"距离订阅时间太长！"),
    INSUFFICIENT_PARKING_SPACES(false,11019,"车位不足！"),
    SUSPEND_BUSINESS(false,11020,"暂停营业！"),
    NO_PERMISSION(false,11021,"没权限操作该停车场相关数据！"),
    CAR_NOT_IN_CARPARK(false,11022,"指定的车辆不在停车场内！"),
    CAR_NOT_IN_CARPARK_OUT_CHECKPOINT(false,11023,"车辆不在出口！"),
    LICENSE_PLATE_NUMBER_HAS_NOT_BEEN_BOUND_YET(false,11024,"还未绑定车牌号！"),
    MISS_MIAN_SHOP(false,11025,"该活动未设置主店铺！"),
    CAR_TYPE_NOT_EXISTS(false,11026,"车辆类型不存在！"),
    PACKAGE_PRICE_NOT_EXISTS(false,11027,"套餐产品不存在！"),
    NOT_BIND_ANY_CARPARK(false,11028,"还未绑定任何停车场！"),
    VISIT_RECORD_NOT_FOUND(false,11029,"到访记录未找到！"),
    VISIT_RECORD_ALREADY_EXISTS(false,11030,"到访记录已存在！"),
    MISS_DEVICE_NO(false,11031,"缺少设备编号！"),
    DEVICE_OCCUPIED(false,11032,"设备被占用！")
    ;
    //操作代码
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;
    private CarParkCode(boolean success, int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }

    @Override
    public boolean success() {
        return success;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }

    @Override
    public void setMessage(String _message) {
        this.message = _message;
    }

    String mixMessage;
    @Override
    public String mixMessage() {
        return mixMessage;
    }

    @Override
    public void setMixMessage(String _mixMessage) {
        this.mixMessage = _mixMessage;
    }
}
