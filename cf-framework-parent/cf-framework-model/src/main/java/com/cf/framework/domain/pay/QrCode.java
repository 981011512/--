package com.cf.framework.domain.pay;

import com.cf.framework.domain.response.ResultCode;

/**
 * 二维码
 *
 * @ClassName MessageCode
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/12/15/015 21:45
 * @Version 1.0
 **/
public enum QrCode implements ResultCode {

    QR_CODE_NOT_EXIST(false,28000,"指定的二维码不存在！"),
    QR_CODE_INVALID(false,28001,"指定的二维码已失效！")
    ;
    //操作代码
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;
    private QrCode(boolean success, int code, String message){
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
