package com.cf.ucenter.api.controller;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.ucenter.api.swagger.UcenterSwagger;
import com.cf.ucenter.service.AuthService;
import com.cf.ucenter.domain.CfUser;
import com.cf.ucenter.service.CfUserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.*;
import java.util.List;

/**
 * 请在此填写描述
 *
 * @ClassName UcenterController
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2019/12/21/021 15:05
 * @Version 1.0
 **/
@RestController
@RequestMapping("ucenter/")
@Validated
public class UcenterController implements UcenterSwagger {
    @Reference(version = "1.0.0", retries = 0, timeout = 10000)
    private CfUserService cfUserService;
    @Autowired
    private HttpServletRequest request;
    @Reference(version = "1.0.0", retries = 0, timeout = 10000)
    private AuthService authService;

    @Override
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResponseResult register(
            @RequestParam("phone")
        @Pattern(regexp = "^((13[0-9])|(14[5,7,9])|(15[^4])|(18[0-9])|(17[0,1,3,5,6,7,8]))[0-9]{8}$", message = "手机号不合法") String phone,
            @RequestParam("sms_code")
        @NotEmpty String smsCode,
            @RequestParam("username")
        @Pattern(regexp = "^[a-zA-Z0-9_]{5,32}$", message = "用户名长度5-32位") String userName,
            @RequestParam("password")
        @Size(min = 10, max = 32, message = "密码长度10-32位") String password,
            @RequestParam("nick_name")
            @Size(min = 1, max = 20, message = "昵称长度1-20位") String nickName) {
        return new ResponseResult(CommonCode.SUCCESS, cfUserService.register(phone, smsCode, userName, password, nickName));
    }

    @Override
    @RequestMapping(value = "findByKey", method = RequestMethod.GET)
    public ResponseResult findByKey(
            @RequestParam("key")
            @Pattern(regexp = "^[a-zA-Z0-9_]{1,64}$", message = "关键字长度1-64位") String key) {
        List<CfUser> cfUsers = cfUserService.findByPhoneOrUidOrName(key);
        return cfUsers != null ? new ResponseResult(CommonCode.SUCCESS, cfUsers) : new ResponseResult(CommonCode.NO_MORE_DATAS);
    }

    @Override
    @RequestMapping(value = "findById", method = RequestMethod.GET)
    public ResponseResult findById(String uid) {
        CfUser cfUser = cfUserService.getUserByUid(uid, true);
        if (cfUser != null) {
            cfUser.setPassword("");
            cfUser.setPhone("");
            cfUser.setEmail("");
            return new ResponseResult(CommonCode.SUCCESS, cfUser);
        } else {
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
    }
}
