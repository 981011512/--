package com.cf.framework.domain.weixin;

import com.cf.framework.domain.response.ResultCode;

/**
 * 二维码
 *
 * @ClassName WeiXinCode
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2022/07/25/015 21:45
 * @Version 1.0
 **/
public enum WeiXinCode implements ResultCode {
    WECHAT_TEMPLATE_DOES_NOT_EXIST(false,33000,"微信模板不存在！"),
    ;
    //操作代码
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;
    private WeiXinCode(boolean success, int code, String message){
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
