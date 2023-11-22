package com.cf.ucenter.api.controller;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.utils.FileUtils;
import com.cf.framework.utils.HttpHearderUtils;
import com.cf.ucenter.api.config.AuthenticationInterceptor;
import com.cf.ucenter.api.swagger.CfUserDriverLicenseSwagger;
import com.cf.ucenter.domain.CfUser;
import com.cf.ucenter.domain.CfUserDriverLicense;
import com.cf.ucenter.request.CfUserDriverLicenseForm;
import com.cf.ucenter.request.CfUserDriverLicenseQuery;
import com.cf.ucenter.service.CfUserDriverLicenseService;
import com.cf.ucenter.service.CfUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("UserDriverLicense/")
@Validated
public class CfUserDriverLicenseController implements CfUserDriverLicenseSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfUserDriverLicenseService cfUserDriverLicenseService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfUserService cfUserService;
    @Autowired
    protected HttpServletRequest request;

    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@RequestBody @Validated CfUserDriverLicenseForm cfUserDriverLicenseForm) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        //先判断是否已经添加过，只允许添加一次
        CfUserDriverLicenseQuery cfUserDriverLicenseQuery = new CfUserDriverLicenseQuery();
        cfUserDriverLicenseQuery.setUid(userBasicInfo.getId());
        Integer countByQuery = cfUserDriverLicenseService.countByQuery(cfUserDriverLicenseQuery);
        if(countByQuery>0){
            return new ResponseResult(CommonCode.DUPLICATE_DATA, cfUserDriverLicenseForm, "已经上传过驾驶证信息了");
        }
        CfUserDriverLicense cfUserDriverLicense = new CfUserDriverLicense();
        BeanUtils.copyProperties(cfUserDriverLicenseForm, cfUserDriverLicense);
        cfUserDriverLicense.setUid(userBasicInfo.getId());
        cfUserDriverLicense.setCheckStatus((byte)0);
        CfUserDriverLicense userIdCard = cfUserDriverLicenseService.add(cfUserDriverLicense);
        //处理驾驶证照片
        if(StringUtils.isNotEmpty(cfUserDriverLicense.getImages())){
            FileUtils.handleFileSourcePrefix(cfUserDriverLicense, "", "images");
        }
        return new ResponseResult(CommonCode.SUCCESS, userIdCard);
    }

    @Override
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseResult update(@RequestBody @Validated CfUserDriverLicenseForm cfUserDriverLicenseForm) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        CfUserDriverLicense idCard = cfUserDriverLicenseService.findById(cfUserDriverLicenseForm.getId(), false);
        if(!idCard.getUid().equals(userBasicInfo.getId())){
            return new ResponseResult(CommonCode.FAIL, cfUserDriverLicenseForm, "该驾驶证资料不属于您");
        }
        CfUserDriverLicense cfUserDriverLicense = new CfUserDriverLicense();
        BeanUtils.copyProperties(cfUserDriverLicenseForm, cfUserDriverLicense);
        cfUserDriverLicense.setCheckStatus((byte)0);
        CfUserDriverLicense userIdCard = cfUserDriverLicenseService.update(cfUserDriverLicense);
        //处理驾驶证照片
        if(StringUtils.isNotEmpty(cfUserDriverLicense.getImages())){
            FileUtils.handleFileSourcePrefix(cfUserDriverLicense, "", "images");
        }
        return new ResponseResult(CommonCode.SUCCESS, userIdCard);
    }

    @Override
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseResult delete(Long id) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        CfUserDriverLicense idCard = cfUserDriverLicenseService.findById(id, false);
        if(!idCard.getUid().equals(userBasicInfo.getId())){
            return new ResponseResult(CommonCode.FAIL, id, "该驾驶证资料不属于您");
        }
        Integer delete = cfUserDriverLicenseService.delete(id);
        return delete>0 ? new ResponseResult(CommonCode.SUCCESS) : new ResponseResult(CommonCode.FAIL);
    }

    @Override
    @RequestMapping(value = "getMyIdCardInfo", method = RequestMethod.GET)
    public ResponseResult getMyIdCardInfo() throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        CfUserDriverLicenseQuery cfUserDriverLicenseQuery = new CfUserDriverLicenseQuery();
        cfUserDriverLicenseQuery.setUid(userBasicInfo.getId());
        List<CfUserDriverLicense> cfUserDriverLicenseList = cfUserDriverLicenseService.getListByQuery(cfUserDriverLicenseQuery);
        if(cfUserDriverLicenseList==null || cfUserDriverLicenseList.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS, null, "您还未上传驾驶证信息");
        }
        //处理驾驶证照片
        if(StringUtils.isNotEmpty(cfUserDriverLicenseList.get(0).getImages())){
            FileUtils.handleFileSourcePrefix(cfUserDriverLicenseList.get(0), "", "images");
        }
        return new ResponseResult(CommonCode.SUCCESS, cfUserDriverLicenseList.get(0));
    }

    @Override
    @RequestMapping(value = "autoAdd", method = RequestMethod.GET)
    public ResponseResult autoAdd() throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        CfUser cfUser = cfUserService.getUserByUid(userBasicInfo.getId(), false);
        if(cfUser==null || StringUtils.isEmpty(cfUser.getPhone())){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        //如果已经存在驾驶证，不做任何操作
        CfUserDriverLicenseQuery cfUserDriverLicenseQuery = new CfUserDriverLicenseQuery();
        cfUserDriverLicenseQuery.setUid(userBasicInfo.getId());
        Integer countByQuery = cfUserDriverLicenseService.countByQuery(cfUserDriverLicenseQuery);
        if(countByQuery>0){
            return new ResponseResult(CommonCode.SUCCESS);
        }
        CfUserDriverLicense cfUserDriverLicense = new CfUserDriverLicense();
        String tureName = StringUtils.isNotEmpty(cfUser.getTrueName()) ? cfUser.getTrueName() : cfUser.getNickName();
        if(tureName.length()>16){
            tureName.substring(0,15);
        }
        cfUserDriverLicense.setUid(userBasicInfo.getId());
        cfUserDriverLicense.setUserName(tureName);
        cfUserDriverLicense.setSex((byte)1);
        cfUserDriverLicense.setCarClass("A1");
        cfUserDriverLicense.setPhone(cfUser.getPhone());
        cfUserDriverLicense.setCheckStatus((byte)1);
        cfUserDriverLicenseService.add(cfUserDriverLicense);

        //更新用户驾驶证状态
        CfUser updateUser = new CfUser();
        updateUser.setId(userBasicInfo.getId());
        updateUser.setDriverLicenseStatus((byte)2);
        cfUserService.update(updateUser);

        return new ResponseResult(CommonCode.SUCCESS);
    }
}
