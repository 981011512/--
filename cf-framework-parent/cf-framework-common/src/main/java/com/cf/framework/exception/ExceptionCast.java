package com.cf.framework.exception;

import com.cf.framework.domain.lang.I18n;
import com.cf.framework.domain.response.ResultCode;

/**
 * @author Administrator
 * @version 1.0
 * @create 2018-09-14 17:31
 **/
public class ExceptionCast {
    public static void cast(ResultCode resultCode){
        throw new CustomException(resultCode);
    }

    public static void cast(ResultCode resultCode, String mixMessage){
        resultCode.setMixMessage(mixMessage);
//        ExceptionCast.cast(resultCode);
        throw new CustomException(resultCode);
    }
}
