package com.cf.framework.exception;

import com.cf.framework.domain.response.ResultCode;

import java.io.Serializable;

/**
 * 自定义异常类型
 * @author Administrator
 * @version 1.0
 * @create 2018-09-14 17:28
 **/
public class CustomException extends RuntimeException implements Serializable {

    //错误代码
    ResultCode resultCode;

    public CustomException(ResultCode resultCode){
        this.resultCode = resultCode;
    }
    public ResultCode getResultCode(){
        return resultCode;
    }


}
