package com.cf.ucenter.api.controller;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.utils.FileUtils;
import com.cf.framework.utils.HttpHearderUtils;
import com.cf.ucenter.api.config.AuthenticationInterceptor;
import com.cf.ucenter.api.swagger.CfUserIdCardSwagger;
import com.cf.ucenter.domain.CfUserIdCard;
import com.cf.ucenter.request.CfUserIdCardForm;
import com.cf.ucenter.request.CfUserIdCardQuery;
import com.cf.ucenter.service.CfUserGroupService;
import com.cf.ucenter.service.CfUserIdCardService;
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
@RequestMapping("UserIdCard/")
@Validated
public class CfUserIdCardController implements CfUserIdCardSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfUserIdCardService cfUserIdCardService;
    @Autowired
    protected HttpServletRequest request;

    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@RequestBody @Validated CfUserIdCardForm cfUserIdCardForm) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        //先判断是否已经添加过，只允许添加一次
        CfUserIdCardQuery cfUserIdCardQuery = new CfUserIdCardQuery();
        cfUserIdCardQuery.setUid(userBasicInfo.getId());
        Integer countByQuery = cfUserIdCardService.countByQuery(cfUserIdCardQuery);
        if(countByQuery>0){
            return new ResponseResult(CommonCode.DUPLICATE_DATA, cfUserIdCardForm, "已经上传过身份证信息了");
        }
        CfUserIdCard cfUserIdCard = new CfUserIdCard();
        BeanUtils.copyProperties(cfUserIdCardForm, cfUserIdCard);
        cfUserIdCard.setUid(userBasicInfo.getId());
        cfUserIdCard.setCheckStatus((byte)0);
        CfUserIdCard userIdCard = cfUserIdCardService.add(cfUserIdCard);
        //处理身份证照片
        if(StringUtils.isNotEmpty(cfUserIdCard.getImages())){
            FileUtils.handleFileSourcePrefix(cfUserIdCard, "", "images");
        }
        return new ResponseResult(CommonCode.SUCCESS, userIdCard);
    }

    @Override
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseResult update(@RequestBody @Validated CfUserIdCardForm cfUserIdCardForm) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        CfUserIdCard idCard = cfUserIdCardService.findById(cfUserIdCardForm.getId(), false);
        if(!idCard.getUid().equals(userBasicInfo.getId())){
            return new ResponseResult(CommonCode.FAIL, cfUserIdCardForm, "该身份证资料不属于您");
        }
        CfUserIdCard cfUserIdCard = new CfUserIdCard();
        BeanUtils.copyProperties(cfUserIdCardForm, cfUserIdCard);
        cfUserIdCard.setCheckStatus((byte)0);
        CfUserIdCard userIdCard = cfUserIdCardService.update(cfUserIdCard);
        //处理身份证照片
        if(StringUtils.isNotEmpty(cfUserIdCard.getImages())){
            FileUtils.handleFileSourcePrefix(cfUserIdCard, "", "images");
        }
        return new ResponseResult(CommonCode.SUCCESS, userIdCard);
    }

    @Override
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseResult delete(Long id) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        CfUserIdCard idCard = cfUserIdCardService.findById(id, false);
        if(!idCard.getUid().equals(userBasicInfo.getId())){
            return new ResponseResult(CommonCode.FAIL, id, "该身份证资料不属于您");
        }
        Integer delete = cfUserIdCardService.delete(id);
        return delete>0 ? new ResponseResult(CommonCode.SUCCESS) : new ResponseResult(CommonCode.FAIL);
    }

    @Override
    @RequestMapping(value = "getMyIdCardInfo", method = RequestMethod.GET)
    public ResponseResult getMyIdCardInfo() throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        CfUserIdCardQuery cfUserIdCardQuery = new CfUserIdCardQuery();
        cfUserIdCardQuery.setUid(userBasicInfo.getId());
        List<CfUserIdCard> cfUserIdCardList = cfUserIdCardService.getListByQuery(cfUserIdCardQuery);
        if(cfUserIdCardList==null || cfUserIdCardList.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS, null, "您还未上传身份证信息");
        }
        //处理身份证照片
        if(StringUtils.isNotEmpty(cfUserIdCardList.get(0).getImages())){
            FileUtils.handleFileSourcePrefix(cfUserIdCardList.get(0), "", "images");
        }
        return new ResponseResult(CommonCode.SUCCESS, cfUserIdCardList.get(0));
    }
}
