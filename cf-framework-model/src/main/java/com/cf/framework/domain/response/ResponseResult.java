package com.cf.framework.domain.response;

import com.cf.framework.domain.ucenter.ext.AuthToken;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author: mrt.
 * @Description:
 * @Date:Created in 2018/1/24 18:33.
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

    //提示信息
    String message;

    //返回的数据
    Object data;

    Integer total = 0;

    private AuthToken token;

    public ResponseResult(ResultCode resultCode){
        this.success = resultCode.success();
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

    public ResponseResult(ResultCode resultCode, Object _datas){
        this.success = resultCode.success();
        this.code = resultCode.code();
        this.message = resultCode.message();
        this.data = _datas;
    }

    public ResponseResult(ResultCode resultCode, Object _datas, AuthToken _token, Integer _total) {
        this.success = resultCode.success();
        this.code = resultCode.code();
        this.message = resultCode.message();
        this.data = _datas;
        this.token = _token;
        this.total = _total;
    }

}
