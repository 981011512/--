package com.cf.carpark.admin.controller;

import com.cf.carpark.admin.config.AuthenticationInterceptor;
import com.cf.carpark.admin.swagger.CfCarParkCheckpointSwagger;
import com.cf.carpark.domain.CfCarParkCheckpoint;
import com.cf.carpark.domain.CfCarParkLinkUser;
import com.cf.carpark.domain.request.CfCarParkCheckpointForm;
import com.cf.carpark.domain.request.CfCarParkCheckpointQuery;
import com.cf.carpark.service.CfCarParkCheckpointService;
import com.cf.carpark.service.CfCarParkLinkUserService;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.utils.HttpHearderUtils;
import com.cf.framework.utils.StringTools;
import org.apache.commons.lang3.StringUtils;
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
@RequestMapping("carparkCheckPointDeviceAdmin/")
@Validated
public class CfCarParkCheckpointController implements CfCarParkCheckpointSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 10000, check = false)
    private CfCarParkCheckpointService cfCarParkCheckpointService;
    @Reference(version = "1.0.0", retries = 0, timeout = 10000, check = false)
    private CfCarParkLinkUserService cfCarParkLinkUserService;

    @Autowired
    protected HttpServletRequest request;

    @PreAuthorize("hasAuthority('carpark-CfCarParkCheckpointController-getListByQuery')")
    @Override
    @RequestMapping(value = "getListByQuery", method = RequestMethod.GET)
    public ResponseResult getListByQuery(CfCarParkCheckpointQuery cfCarParkCheckpointQuery) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        if(StringTools.findStringInArray(userBasicInfo.getRoleFlag().split(","), "admin")<0){
            CfCarParkLinkUserController cfCarParkLinkUserController = new CfCarParkLinkUserController();
            List<CfCarParkLinkUser> cfCarParkLinkUserList = cfCarParkLinkUserController.getCarParkLinkUser(userBasicInfo, cfCarParkLinkUserService);
            if(cfCarParkLinkUserList==null){
                return new ResponseResult(CommonCode.NO_MORE_DATAS);
            }else{
                cfCarParkCheckpointQuery.setIds(new ArrayList<>());
                for (CfCarParkLinkUser cfCarParkLinkUser: cfCarParkLinkUserList){
                    if(StringUtils.isEmpty(cfCarParkLinkUser.getCheckPointIds())){
                        continue;
                    }
                    String[] checkpointIdArray = cfCarParkLinkUser.getCheckPointIds().split(",");
                    for(int i=0; i<checkpointIdArray.length; i++){
                        cfCarParkCheckpointQuery.getIds().add(checkpointIdArray[i]);
                    }
                }
            }
        }

        List<CfCarParkCheckpoint> cfCarParkCheckpoints = cfCarParkCheckpointService.getListByQuery(cfCarParkCheckpointQuery);
        if(cfCarParkCheckpoints==null || cfCarParkCheckpoints.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfCarParkCheckpoints);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkCheckpointController-add')")
    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@RequestBody CfCarParkCheckpointForm cfCarParkCheckpointForm) {
        CfCarParkCheckpoint cfCarParkCheckpoint = new CfCarParkCheckpoint();
        BeanUtils.copyProperties(cfCarParkCheckpointForm, cfCarParkCheckpoint);
        CfCarParkCheckpoint carParkCheckpoint = cfCarParkCheckpointService.add(cfCarParkCheckpoint);
        return new ResponseResult(CommonCode.SUCCESS, carParkCheckpoint);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkCheckpointController-update')")
    @Override
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseResult update(@RequestBody CfCarParkCheckpointForm cfCarParkCheckpointForm) throws Exception {
        CfCarParkCheckpoint cfCarParkCheckpoint = new CfCarParkCheckpoint();
        BeanUtils.copyProperties(cfCarParkCheckpointForm, cfCarParkCheckpoint);
        CfCarParkCheckpoint carParkCheckpoint = cfCarParkCheckpointService.update(cfCarParkCheckpoint);
        return new ResponseResult(CommonCode.SUCCESS, carParkCheckpoint);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkCheckpointController-goOffWorkOrGoToWork')")
    @Override
    @RequestMapping(value = "goOffWorkOrGoToWork", method = RequestMethod.PUT)
    public ResponseResult goOffWorkOrGoToWork(@RequestBody CfCarParkCheckpointForm cfCarParkCheckpointForm) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        CfCarParkCheckpoint parkCheckpoint = cfCarParkCheckpointService.findById(cfCarParkCheckpointForm.getId(), false);
        if(StringUtils.isNotEmpty(parkCheckpoint.getDutyUid()) && !userBasicInfo.getId().equals(parkCheckpoint.getDutyUid())){
            //值班通道被占用
            return new ResponseResult(CommonCode.FAIL, "该通道已有其它人员值班");
        }else if(StringUtils.isNotEmpty(parkCheckpoint.getDutyUid()) && userBasicInfo.getId().equals(parkCheckpoint.getDutyUid())){
            //取消值班
            parkCheckpoint.setDutyUid("");
        }else{
            //值班
            parkCheckpoint.setDutyUid(userBasicInfo.getId());
        }

        CfCarParkCheckpoint carParkCheckpoint = cfCarParkCheckpointService.update(parkCheckpoint);
        return new ResponseResult(CommonCode.SUCCESS, carParkCheckpoint);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkCheckpointController-delete')")
    @Override
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseResult delete(String id) {
        Integer delete = cfCarParkCheckpointService.delete(id);
        return delete>0?new ResponseResult(CommonCode.SUCCESS, delete):new ResponseResult(CommonCode.FAIL);
    }
}
