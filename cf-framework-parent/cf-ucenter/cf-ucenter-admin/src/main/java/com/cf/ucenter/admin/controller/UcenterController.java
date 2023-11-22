package com.cf.ucenter.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.cf.framework.domain.report.CountByDay;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.utils.HttpHearderUtils;
import com.cf.ucenter.admin.config.AuthenticationInterceptor;
import com.cf.ucenter.admin.swagger.UcenterSwagger;
import com.cf.ucenter.domain.CfUser;
import com.cf.ucenter.request.CfCountUserQuery;
import com.cf.ucenter.request.CfUserForm;
import com.cf.ucenter.request.CfUserQuery;
import com.cf.ucenter.service.CfUserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 请在此填写描述
 *
 * @ClassName UcenterController
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/12/21/021 15:05
 * @Version 1.0
 **/
@RestController
@RequestMapping("ucenterAdmin/")
@Validated
public class UcenterController implements UcenterSwagger {
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfUserService cfUserService;
    @Autowired
    protected HttpServletRequest request;

    @Override
    @RequestMapping(value = "create", method = RequestMethod.PUT)
    public ResponseResult create(
            @RequestParam("phone")
        @Pattern(regexp = "^(1[3-9])[0-9]{9}$", message = "手机号不合法") String phone,
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
    public ResponseResult findByKey(@RequestParam("key")String key) {
        List<CfUser> cfUsers = cfUserService.findByPhoneOrUidOrName(key);
        return cfUsers != null ? new ResponseResult(CommonCode.SUCCESS, cfUsers) : new ResponseResult(CommonCode.NO_MORE_DATAS);
    }

    @PreAuthorize("hasAuthority('ucenter-UcenterController-findById')")
    @Override
    @RequestMapping(value = "findById", method = RequestMethod.GET)
    public ResponseResult findById(String uid) {
        CfUser cfUser = cfUserService.getUserByUid(uid, true);
        if (cfUser != null) {
            cfUser.setPassword("");
            return new ResponseResult(CommonCode.SUCCESS, cfUser);
        } else {
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
    }

    @Override
    @RequestMapping(value = "getMyInfo", method = RequestMethod.GET)
    public ResponseResult getMyInfo() throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        CfUser cfUser = cfUserService.getUserAdministratorByUid(userBasicInfo.getId());
        if (cfUser != null) {
            cfUser.setPassword("");
            return new ResponseResult(CommonCode.SUCCESS, cfUser);
        } else {
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
    }

    @PreAuthorize("hasAuthority('ucenter-UcenterController-selectListByCondition')")
    @Override
    @RequestMapping(value = "selectListByCondition", method = RequestMethod.GET)
    public ResponseResult selectListByCondition(String conditions) {
        Map conditionsMap = (JSONObject.parseObject(conditions));
        ArrayList<String> allowFileds = new ArrayList<>();
        allowFileds.add("id");
        allowFileds.add("user_name");
        allowFileds.add("type");
        allowFileds.add("nick_name");
        allowFileds.add("true_name");
        allowFileds.add("phone");
        allowFileds.add("sex");
        allowFileds.add("create_time");
        allowFileds.add("like");
        allowFileds.add("order");
        allowFileds.add("limit");
        Map<String, String> allowFiledsMap = new HashMap<String, String>();
        allowFiledsMap.put("id","u");
        allowFiledsMap.put("user_name","u");
        allowFiledsMap.put("type","u");
        allowFiledsMap.put("nick_name","u");
        allowFiledsMap.put("true_name","u");
        allowFiledsMap.put("phone","u");
        allowFiledsMap.put("sex","u");
        allowFiledsMap.put("create_time","u");
        allowFiledsMap.put("like","");
        allowFiledsMap.put("order","");
        allowFiledsMap.put("limit","");
        List<CfUser> cfCarParks = cfUserService.selectListByCondition(conditionsMap, allowFiledsMap,allowFileds);
        Integer counts = cfUserService.selectListByConditionCounts(conditionsMap, allowFiledsMap, allowFileds);
        if(cfCarParks!=null && cfCarParks.size()>0){
            return new ResponseResult(CommonCode.SUCCESS, cfCarParks, null, counts);
        }
        return new ResponseResult(CommonCode.NO_MORE_DATAS);
    }

    @PreAuthorize("hasAuthority('ucenter-UcenterController-update')")
    @Override
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseResult update(@Validated @RequestBody CfUserForm cfUserForm) {
        CfUser cfUser = new CfUser();
        BeanUtils.copyProperties(cfUserForm, cfUser);
        if(cfUser.getAvatar()==null){
            cfUser.setAvatar("");
        }
        CfUser newCfUser = cfUserService.update(cfUser, cfUserForm.getCfRoles());
        return new ResponseResult(CommonCode.SUCCESS, newCfUser);
    }

    @PreAuthorize("hasAuthority('ucenter-UcenterController-add')")
    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@Validated @RequestBody CfUserForm cfUserForm) {
        CfUser cfUser = new CfUser();
        BeanUtils.copyProperties(cfUserForm, cfUser);
        if(cfUser.getAvatar()==null){
            cfUser.setAvatar("");
        }
        CfUser user = cfUserService.add(cfUser, cfUserForm.getCfRoles());
        return new ResponseResult(CommonCode.SUCCESS, user);
    }

    @PreAuthorize("hasAuthority('ucenter-UcenterController-countAddLogs')")
    @Override
    @RequestMapping(value = "countAddLogs", method = RequestMethod.GET)
    public ResponseResult countAddLogs(CfCountUserQuery cfCountUserQuery) {
        if(cfCountUserQuery.getDate().equals("") || cfCountUserQuery.getDate().equals("null")){
            cfCountUserQuery.setDate(null);
        }
        if(cfCountUserQuery.getEndDate().equals("") || cfCountUserQuery.getEndDate().equals("null")){
            cfCountUserQuery.setEndDate(null);
        }
        if(cfCountUserQuery.getYear().equals("") || cfCountUserQuery.getYear().equals("null")){
            cfCountUserQuery.setYear(null);
        }
        if(cfCountUserQuery.getMonth().equals("") || cfCountUserQuery.getMonth().equals("null")){
            cfCountUserQuery.setMonth(null);
        }
        if(cfCountUserQuery.getDay().equals("") || cfCountUserQuery.getDay().equals("null")){
            cfCountUserQuery.setDay(null);
        }
        List<CountByDay> list = null;
        switch (cfCountUserQuery.getCountType()){
            case "before_day_count_by_day":
                list = cfUserService.limitDaysCountByDay(cfCountUserQuery);
                break;
            case "month_count_by_day":
                list = cfUserService.yearMonthCountByDay(cfCountUserQuery);
                break;
            case "year_count_by_month":
                list = cfUserService.yearCountByMonth(cfCountUserQuery);
                break;
        }

        if(list==null || list.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        return new ResponseResult(CommonCode.SUCCESS, list, cfUserService.getCountByQuery(new CfUserQuery()));
    }
}
