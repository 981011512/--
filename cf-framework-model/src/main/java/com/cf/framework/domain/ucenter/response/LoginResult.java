package com.cf.framework.domain.ucenter.response;

import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.response.ResultCode;
import com.cf.framework.domain.ucenter.ext.AuthToken;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString
@NoArgsConstructor
public class LoginResult extends ResponseResult {
    public LoginResult(ResultCode resultCode, AuthToken token) {
        super(resultCode);
        this.token = token;
    }
    private AuthToken token;
}
