package com.cf.carpark.admin.controller;

import com.cf.carpark.admin.config.AuthenticationInterceptor;
import com.cf.carpark.admin.swagger.CfCarParkVisitSwagger;
import com.cf.carpark.domain.*;
import com.cf.carpark.domain.request.*;
import com.cf.carpark.service.*;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.utils.HttpHearderUtils;
import com.cf.pay.service.CfAccountService;
import com.cf.ucenter.service.CfUserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("CarParkVisitAdmin/")
@Validated
public class CfCarParkVisitController implements CfCarParkVisitSwagger {
    @Reference(version = "1.0.0", retries = 0, timeout = 15000, check = false)
    private CfCarParkVisitService cfCarParkVisitService;
    @Reference(version = "1.0.0", retries = 0, timeout = 15000, check = false)
    private CfCarParkService cfCarParkService;
    @Reference(version = "1.0.0", retries = 0, timeout = 15000, check = false)
    private CfCarParkLinkUserService cfCarParkLinkUserService;
    @Reference(version = "1.0.0", retries = 0, timeout = 15000, check = false)
    private CfUserService cfUserService;
    @Reference(version = "1.0.0", retries = 0, timeout = 15000, check = false)
    private CfAccountService cfAccountService;
    @Reference(version = "1.0.0", retries = 0, timeout = 15000, check = false)
    private CfCarParkCarService cfCarParkCarService;

    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected CarParkController carParkController;

    @PreAuthorize("hasAuthority('carpark-CfCarParkVisitController-add')")
    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@RequestBody CfCarParkVisitForm cfCarParkVisitForm) {
        CfCarParkVisit cfCarParkVisit = new CfCarParkVisit();
        BeanUtils.copyProperties(cfCarParkVisitForm,cfCarParkVisit);
        CfCarParkVisit carParkVisit = cfCarParkVisitService.add(cfCarParkVisit);
        return new ResponseResult(CommonCode.SUCCESS, carParkVisit);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkVisitController-update')")
    @Override
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseResult update(@RequestBody CfCarParkVisitForm cfCarParkVisitForm) {
        CfCarParkVisit cfCarParkVisit = new CfCarParkVisit();
        BeanUtils.copyProperties(cfCarParkVisitForm,cfCarParkVisit);
        CfCarParkVisit carParkVisit = cfCarParkVisitService.update(cfCarParkVisit);
        return new ResponseResult(CommonCode.SUCCESS, carParkVisit);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkVisitController-delete')")
    @Override
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseResult delete(Long id) {
        Integer delete = cfCarParkVisitService.delete(id);
        return delete>0 ? new ResponseResult(CommonCode.SUCCESS) : new ResponseResult(CommonCode.FAIL);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkVisitController-getListByQuery')")
    @Override
    @RequestMapping(value = "getListByQuery", method = RequestMethod.GET)
    public ResponseResult getListByQuery(CfCarParkVisitQuery cfCarParkVisitQuery) throws Exception {
        limitQuery(cfCarParkVisitQuery);
        List<CfCarParkVisit> cfCarParkVisits = cfCarParkVisitService.getListByQuery(cfCarParkVisitQuery);
        if(cfCarParkVisits==null || cfCarParkVisits.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        Integer countByQuery = cfCarParkVisitService.countByQuery(cfCarParkVisitQuery);
        return  new ResponseResult(CommonCode.SUCCESS, cfCarParkVisits, countByQuery);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkVisitController-selectContinByQuery')")
    @Override
    @RequestMapping(value = "selectContinByQuery", method = RequestMethod.GET)
    public ResponseResult selectContinByQuery(CfCarParkVisitQuery cfCarParkVisitQuery) throws Exception {
        limitQuery(cfCarParkVisitQuery);
        List<CfCarParkVisit> cfCarParkVisits = cfCarParkVisitService.selectContinByQuery(cfCarParkVisitQuery);
        Integer total = 0;
        if(cfCarParkVisitQuery.getPage()==1){
            total = cfCarParkVisitService.countByQuery(cfCarParkVisitQuery);
        }
        return cfCarParkVisits!=null && cfCarParkVisits.size()>0 ? new ResponseResult(CommonCode.SUCCESS, cfCarParkVisits, total) : new ResponseResult(CommonCode.NO_MORE_DATAS);
    }

    /**
     * 限制查询条件(非管理人员只能查询自己名下的停车场相关数据)
     * @param cfCarParkVisitQuery
     * @throws Exception
     */
    private void limitQuery(CfCarParkVisitQuery cfCarParkVisitQuery) throws Exception{
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));

        List<CfCarParkLinkUser> linkUsers = carParkController.getLinkUsersAndCheck(userBasicInfo);
        if(linkUsers!=null && linkUsers.size()>0){
            if(cfCarParkVisitQuery.getCarParkIds()==null){
                cfCarParkVisitQuery.setCarParkIds(new ArrayList<>());
            }
            for (CfCarParkLinkUser cfCarParkLinkUser: linkUsers){
                cfCarParkVisitQuery.getCarParkIds().add(new Long(cfCarParkLinkUser.getCarParkId()));
            }
        }
    }
}
