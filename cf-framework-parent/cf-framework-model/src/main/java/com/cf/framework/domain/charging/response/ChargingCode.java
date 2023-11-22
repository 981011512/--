package com.cf.framework.domain.charging.response;

import com.cf.framework.domain.response.ResultCode;

/**
 * 充电站返回
 *
 * @ClassName MessageCode
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2022/12/15/015 21:45
 * @Version 1.0
 **/
public enum ChargingCode implements ResultCode {

    CHARING_EQUIPMENT_FAILURE(false,14000,"充电设备故障！"),
    BIND_LICENSE_PLATES_REPEATEDLY(false,14001,"重复绑定车牌！"),
    DEVICE_IS_NOT_REGISTERED(false,14002,"设备未注册！"),
    UNABLE_TO_PARSE_DEVICE_DATA(false,14003,"无法解析设备数据！"),
    END_TIME_MUST_BE_GREATER_THAN_START_TIME(false,14004,"结束时间必须大于开始时间！"),
    CHARGING_RULES_NOT_FOUND(false,14005,"没有找到收费规则！"),
    BRAND_DEVICES_THAT_IS_NOT_CURRENTLY_SUPPORTED(false,14006,"暂时未支持的品牌设备！"),
    DEVICE_BRAND_IS_NOT_SPECIFIED(false,14007,"设备品牌未指定！"),
    DEVICE_SERIAL_NUMBER_IS_NOT_SPECIFIED(false,14008,"设备序列号未指定！"),
    DEVICE_OFFLINE(false,14009,"设备不在线！"),
    CHARGING_PORT_NOT_EXIST(false,14010,"充电口不存在！"),
    CHARGING_PORT_USED(false,14011,"充电口已被占用！"),
    NON_CHARGING_USERS(false,14012,"非充电中用户！"),
    MISSING_FEE_RULES(false,14013,"缺少收费规则！"),
    NOT_MATCHED_TO_CHARGING_PRICE(false,14014,"未匹配到充电价格！"),
    THE_RECORD_DOES_NOT_BELONG_TO_YOU(false,14015,"该记录不属于您！")
    ;
    //操作代码
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;
    private ChargingCode(boolean success, int code, String message){
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
