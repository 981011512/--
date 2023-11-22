package com.cf.ad.admin.controller;

import com.cf.ad.admin.swagger.CfAdSwagger;
import com.cf.ad.domain.CfAd;
import com.cf.ad.domain.CfAdLinks;
import com.cf.ad.domain.request.CfAdForm;
import com.cf.ad.domain.request.CfAdQuery;
import com.cf.ad.service.CfAdService;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.utils.FileUtils;
import com.cf.framework.utils.Snowflake;
import com.cf.ucenter.service.CfSystemConfigService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *
 * @ClassName CfCarParkUseLogController
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/4/28/028 8:55
 * @Version 1.0
 **/
@RestController
@RequestMapping("adAdmin/")
@Validated
public class CfAdController implements CfAdSwagger {
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfAdService cfAdService;
    @Autowired
    protected HttpServletRequest request;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfSystemConfigService cfSystemConfigService;

    private static Logger logger = LoggerFactory.getLogger(Snowflake.class);

//    @PreAuthorize("hasAuthority('ad-CfAdController-findById')")
    @Override
    @RequestMapping(value = "findById", method = RequestMethod.GET)
    public ResponseResult findById(String id) throws Exception {
        if(id!=null){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        CfAdQuery cfAdQuery = new CfAdQuery();
        cfAdQuery.setId(id);
        List<CfAd> cfAdList = cfAdService.getListByQuery(cfAdQuery);
        if(cfAdList==null || cfAdList.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfAdList.get(0));
    }

//    @PreAuthorize("hasAuthority('ad-CfAdController-add')")
    @Override
    @RequestMapping(value = "add", method = RequestMethod.PUT)
    public ResponseResult add(@Validated CfAdForm cfAdForm) throws Exception {
        CfAd cfAd = new CfAd();
        BeanUtils.copyProperties(cfAdForm, cfAd);
        CfAd ad = cfAdService.add(cfAd);
        return new ResponseResult(CommonCode.SUCCESS, ad);
    }

//    @PreAuthorize("hasAuthority('ad-CfAdController-update')")
    @Override
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResponseResult update(@Validated CfAdForm cfAdForm) throws Exception {
        CfAd cfAd = new CfAd();
        BeanUtils.copyProperties(cfAdForm, cfAd);
        CfAd ad = cfAdService.update(cfAd);
        return new ResponseResult(CommonCode.SUCCESS, ad);
    }

//    @PreAuthorize("hasAuthority('ad-CfAdController-delete')")
    @Override
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseResult delete(String id) throws Exception {
        Integer delete = cfAdService.delete(id);
        return delete>0 ? new ResponseResult(CommonCode.SUCCESS) : new ResponseResult(CommonCode.FAIL);
    }

//    @PreAuthorize("hasAuthority('ad-CfAdController-getListByQuery')")
    @Override
    @RequestMapping(value = "getListByQuery", method = RequestMethod.GET)
    public ResponseResult getListByQuery(CfAdQuery cfAdQuery) throws Exception {
        List<CfAd> cfAdList = cfAdService.getListByQuery(cfAdQuery);
        if(cfAdList==null || cfAdList.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        String fileSourceAddress = cfSystemConfigService.getValueByKey("file_source_address", "http://file.cfeng.wang/");
        for (CfAd cfAd: cfAdList){
            if(StringUtils.isNotEmpty(cfAd.getCover())){
                FileUtils.handleFileSourcePrefix(cfAd, fileSourceAddress, "cover");
            }
        }
        Integer integer = cfAdService.countByQuery(cfAdQuery);
        return new ResponseResult(CommonCode.SUCCESS, cfAdList, integer);
    }
}
