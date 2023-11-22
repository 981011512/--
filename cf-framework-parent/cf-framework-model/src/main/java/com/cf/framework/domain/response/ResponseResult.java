package com.cf.framework.domain.response;

import com.cf.framework.domain.lang.I18n;
import com.cf.framework.domain.ucenter.ext.AuthToken;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: mrt.
 * @Description:
 * @Date:Created in 2020/1/24 18:33.
 * @Modified By:
 */
@Data
@ToString
@NoArgsConstructor
public class ResponseResult implements Response, Serializable {

    //操作是否成功
    boolean success = SUCCESS;

    //操作代码
    int code = SUCCESS_CODE;

    //纯提示消息(前端建议使用此字段)
    String message;

    //混合提示信息，可能含有其它数据，排查错误时建议查看此字段内容
    String mixMessage;

    //返回的数据
    Object data;

    Integer total = 0;

    BigDecimal doubleTotal = new BigDecimal("0");

    private AuthToken token;

    public ResponseResult(ResultCode resultCode){
        this.fillingCommonProperty(resultCode);
    }

    public ResponseResult(ResultCode resultCode, Object _datas){
        this.fillingCommonProperty(resultCode);
        this.data = _datas;
    }

    public ResponseResult(ResultCode resultCode, Object _datas, Integer _total){
        this.fillingCommonProperty(resultCode);
        this.data = _datas;
        this.total = _total;
    }

    public ResponseResult(ResultCode resultCode, Object _datas, BigDecimal _total){
        this.fillingCommonProperty(resultCode);
        this.data = _datas;
        this.doubleTotal = _total;
    }

    public ResponseResult(ResultCode resultCode, Object _datas, String mixMessage){
        resultCode.setMixMessage(mixMessage);
        this.fillingCommonProperty(resultCode);
        this.data = _datas;
    }

    public ResponseResult(ResultCode resultCode, Object _datas, AuthToken _token, Integer _total) {
        this.fillingCommonProperty(resultCode);
        this.data = _datas;
        this.token = _token;
        this.total = _total;
    }

    public ResponseResult(ResultCode resultCode, String mixMessage, Object _datas, AuthToken _token, Integer _total) {
        resultCode.setMixMessage(mixMessage);
        this.fillingCommonProperty(resultCode);
        this.data = _datas;
        this.token = _token;
        this.total = _total;
    }

    public void fillingCommonProperty(ResultCode resultCode)
    {
        try{
            resultCode = I18n.getFullMessage(resultCode);
            this.mixMessage = resultCode.mixMessage();
            this.success = resultCode.success();
            this.code = resultCode.code();
            this.message = resultCode.message();
        } catch (Exception e){
            e.printStackTrace();
        }

    }

}
