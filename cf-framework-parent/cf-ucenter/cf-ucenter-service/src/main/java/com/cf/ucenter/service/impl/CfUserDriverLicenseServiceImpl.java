package com.cf.ucenter.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.ucenter.response.UcenterCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.HttpClient;
import com.cf.framework.utils.IdWorker;
import com.cf.framework.utils.StringTools;
import com.cf.ucenter.dao.mapper.CfUserDriverLicenseMapper;
import com.cf.ucenter.domain.CfThirdPartyLogin;
import com.cf.ucenter.domain.CfUser;
import com.cf.ucenter.domain.CfUserDriverLicense;
import com.cf.ucenter.domain.CfUserDriverLicenseExample;
import com.cf.ucenter.request.CfUserDriverLicenseQuery;
import com.cf.ucenter.service.CfThirdPartyLoginService;
import com.cf.ucenter.service.CfUserDriverLicenseService;
import com.cf.ucenter.service.CfUserService;
import com.cf.ucenter.type.ThirdPartyPlatformType;
import com.github.pagehelper.PageHelper;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfUserDriverLicenseServiceImpl implements CfUserDriverLicenseService {

    @Value("${logistics.tms-url}")
    private String tmsUrl;
    @Autowired
    private CfUserDriverLicenseMapper cfUserDriverLicenseMapper;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private CfUserService cfUserService;
    @Autowired
    private CfThirdPartyLoginService cfThirdPartyLoginService;

    @Override
    public CfUserDriverLicense add(CfUserDriverLicense cfUserDriverLicense) throws Exception {
        checkRepeatByLicenseNumber(cfUserDriverLicense);
        updateUserDocumentsStatus(cfUserDriverLicense);
        cfUserDriverLicense.setId(idWorker.nextLongId());
        cfUserDriverLicenseMapper.insertSelective(cfUserDriverLicense);

        return cfUserDriverLicense;
    }

    @Override
    public CfUserDriverLicense update(CfUserDriverLicense cfUserDriverLicense) throws Exception {
        checkRepeatByLicenseNumber(cfUserDriverLicense);
        updateUserDocumentsStatus(cfUserDriverLicense);
        cfUserDriverLicenseMapper.updateByPrimaryKeySelective(cfUserDriverLicense);
        return cfUserDriverLicense;
    }

    @Override
    public Integer updateByQUery(CfUserDriverLicense cfUserIdCard, CfUserDriverLicenseQuery cfUserIdCardQuery) throws Exception {
        return cfUserDriverLicenseMapper.updateByExampleSelective(cfUserIdCard, getExampleByQuery(cfUserIdCardQuery));
    }

    @Override
    public Integer delete(Long id) {
        return cfUserDriverLicenseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public CfUserDriverLicense findById(Long id) {
        return cfUserDriverLicenseMapper.selectByPrimaryKey(id);
    }

    @Override
    public CfUserDriverLicense findById(Long id, boolean expectEmpty) {
        CfUserDriverLicense cfUserDriverLicense = findById(id);
        if(expectEmpty && cfUserDriverLicense!=null){
            ExceptionCast.cast(CommonCode.DUPLICATE_DATA);
        }
        if(!expectEmpty && cfUserDriverLicense==null){
            ExceptionCast.cast(CommonCode.NO_MORE_DATAS);
        }
        return cfUserDriverLicense;
    }

    @Override
    public List<CfUserDriverLicense> getListByQuery(CfUserDriverLicenseQuery cfUserDriverLicenseQuery) {
        return cfUserDriverLicenseMapper.selectByExample(getExampleByQuery(cfUserDriverLicenseQuery));
    }

    @Override
    public Integer countByQuery(CfUserDriverLicenseQuery cfUserDriverLicenseQuery) {
        cfUserDriverLicenseQuery.setPage(null);
        return cfUserDriverLicenseMapper.countByExample(getExampleByQuery(cfUserDriverLicenseQuery));
    }

    @Override
    public void checkRepeatByLicenseNumber(CfUserDriverLicense cfUserDriverLicense) {
        if(StringUtils.isEmpty(cfUserDriverLicense.getCertificateNumber())){
            return;
        }
        CfUserDriverLicenseQuery cfUserDriverLicenseQuery = new CfUserDriverLicenseQuery();
        cfUserDriverLicenseQuery.setCertificateNumber(cfUserDriverLicense.getCertificateNumber());
        List<CfUserDriverLicense> cfUserDriverLicenseList = getListByQuery(cfUserDriverLicenseQuery);
        if((cfUserDriverLicense.getId()==null && cfUserDriverLicenseList!=null && cfUserDriverLicenseList.size()>0) || (cfUserDriverLicense.getId()!=null && cfUserDriverLicenseList!=null && cfUserDriverLicenseList.size()>0 && cfUserDriverLicense.getId().longValue()!=cfUserDriverLicenseList.get(0).getId().longValue())){
            ExceptionCast.cast(UcenterCode.ID_NUMBER_IS_BOUND);
        }
    }

    @Override
    public CfUserDriverLicenseExample getExampleByQuery(CfUserDriverLicenseQuery cfUserDriverLicenseQuery) {
        CfUserDriverLicenseExample cfUserDriverLicenseExample = new CfUserDriverLicenseExample();
        CfUserDriverLicenseExample.Criteria criteria = cfUserDriverLicenseExample.createCriteria();
        if(cfUserDriverLicenseQuery.getUid()!=null){
            criteria.andUidEqualTo(cfUserDriverLicenseQuery.getUid());
        }
        if(cfUserDriverLicenseQuery.getCheckStatus()!=null){
            criteria.andCheckStatusEqualTo(cfUserDriverLicenseQuery.getCheckStatus());
        }
        if(cfUserDriverLicenseQuery.getCertificateNumber()!=null){
            criteria.andCertificateNumberEqualTo(cfUserDriverLicenseQuery.getCertificateNumber());
        }
        if(cfUserDriverLicenseQuery.getPhone()!=null){
            criteria.andPhoneEqualTo(cfUserDriverLicenseQuery.getPhone());
        }
        if(cfUserDriverLicenseQuery.getUserName()!=null){
            criteria.andUserNameEqualTo(cfUserDriverLicenseQuery.getUserName());
        }
        if(StringUtils.isNotEmpty(cfUserDriverLicenseQuery.getOrderBy())){
            cfUserDriverLicenseExample.setOrderByClause(cfUserDriverLicenseQuery.getOrderBy());
        }
        if(cfUserDriverLicenseQuery.getPage()!=null && cfUserDriverLicenseQuery.getSize()!=null){
            PageHelper.startPage(cfUserDriverLicenseQuery.getPage(), cfUserDriverLicenseQuery.getSize());
        }
        return cfUserDriverLicenseExample;
    }

    @Override
    public List<CfUserDriverLicense> synchronizeTmsDriver()throws Exception {
        if(StringUtils.isEmpty(tmsUrl)){
            return null;
        }
        List<CfUserDriverLicense> cfUserDriverLicenseList = new ArrayList<>();
        JSONObject driverList = HttpClient.doGet(tmsUrl+"/interface/adapter/interface_paidui_driver");
        if(driverList!=null && driverList.containsKey("messageType") && driverList.get("data")!=null){
            Object[] data = ((JSONArray) driverList.get("data")).stream().toArray();
            ArrayList<JSONObject> dataList = new ArrayList<>();
            HashMap<String, String> requestHeaders = new HashMap<>();
            requestHeaders.put("Content-Type","application/json;charset=UTF-8");
            CfUserDriverLicenseQuery cfUserDriverLicenseQuery = new CfUserDriverLicenseQuery();
            for(int i=0; i<data.length; i++){
                //限制单次同步数据为30条
                if(i>30){
                    break;
                }
                CfUserDriverLicense cfUserDriverLicense = new CfUserDriverLicense();
                JSONObject params = new JSONObject();
                JSONObject jsonObject = (JSONObject) data[i];
                cfUserDriverLicense.setUid("");
                cfUserDriverLicense.setUserName(jsonObject.getString("name"));
                cfUserDriverLicense.setSex((byte)2);
                cfUserDriverLicense.setNationality("");
                cfUserDriverLicense.setAddress("");
                cfUserDriverLicense.setBirthdayYear((short)0);
                cfUserDriverLicense.setBirthdayMonth((byte)0);
                cfUserDriverLicense.setBirthdayDay((byte)0);
                cfUserDriverLicense.setFirstIssueYear((short)0);
                cfUserDriverLicense.setFirstIssueMonth((byte)0);
                cfUserDriverLicense.setFirstIssueDay((byte)0);
                cfUserDriverLicense.setCarClass(jsonObject.getString("driverCarType"));
                cfUserDriverLicense.setStartTime(0l);
                cfUserDriverLicense.setEndTime(0l);
                cfUserDriverLicense.setCertificateNumber(jsonObject.getString("idcard"));
                cfUserDriverLicense.setIssuingAuthority("");
                cfUserDriverLicense.setFileNumber("");
                cfUserDriverLicense.setInternshipPeriodEnds(0l);
                cfUserDriverLicense.setCheckStatus((byte)1);
                cfUserDriverLicense.setPhone(jsonObject.getString("tel"));
                cfUserDriverLicense.setQualificationCertificateNumber(jsonObject.getString("certificate"));


                //判断是否存在重复的手机号
                cfUserDriverLicenseQuery.setPhone(jsonObject.getString("tel"));
                List<CfUserDriverLicense> driverLicenseList = getListByQuery(cfUserDriverLicenseQuery);
                try {
                    if(driverLicenseList!=null && driverLicenseList.size()>0){
                        cfUserDriverLicense.setId(driverLicenseList.get(0).getId());
                        update(cfUserDriverLicense);
                    }else{
                        add(cfUserDriverLicense);
                        if(jsonObject.containsKey("wechatid") && StringUtils.isNotEmpty(jsonObject.getString("wechatid"))){
                            //创建对应的微信公众号用户
                            CfThirdPartyLogin cfThirdPartyLogin = new CfThirdPartyLogin();
                            //TODO 暂时写死，后期动态查询
                            cfThirdPartyLogin.setAppid("wx462c90069807ae19");
                            cfThirdPartyLogin.setOpenid(jsonObject.getString("wechatid"));
                            cfThirdPartyLogin.setUid(cfUserDriverLicense.getUid());
                            cfThirdPartyLogin.setPlatform(ThirdPartyPlatformType.WX_WB);
                            cfThirdPartyLoginService.add(cfThirdPartyLogin);
                        }
                    }
                } catch (Exception e) {
                    continue;
                }
                cfUserDriverLicenseList.add(cfUserDriverLicense);
                params.put("name",cfUserDriverLicense.getUserName());
                params.put("tel",cfUserDriverLicense.getPhone());
                params.put("success","true");
                dataList.add(params);
            }
            if(dataList.size()>0){
                JSONObject[] paramsList = new JSONObject[dataList.size()];
                int i  = 0;
                for(JSONObject params: dataList){
                    paramsList[i] = params;
                    i++;
                }
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("data",paramsList);
                updateTMSData(jsonObject, requestHeaders);
            }
        }
        return cfUserDriverLicenseList;
    }

    /**
     * 告诉TMS系统指定数据已更新
     */
    private void updateTMSData(JSONObject paramsObject, HashMap<String, String> requestHeaders) throws Exception{
        if(StringUtils.isEmpty(tmsUrl)){
            return;
        }
        try {
            JSONObject updateResult = (JSONObject)HttpClient.doPostByString(paramsObject.toJSONString(),tmsUrl+"/interface/adapter/paidui_update_driver",requestHeaders, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    };

    /**
     * 如果手机号用户未注册，创建一个用户
     * 更新指定用户证件状态为正常
     * @param cfUserDriverLicense
     */
    private void updateUserDocumentsStatus(CfUserDriverLicense cfUserDriverLicense) throws Exception{
        //先判断该手机号是否存在用户
        CfUser cfUser = cfUserService.findByPhone(cfUserDriverLicense.getPhone());
        if(cfUser!=null){
            //更新用户证件状态
            CfUser updateUser = new CfUser();
            updateUser.setId(cfUser.getId());
            if(cfUserDriverLicense.getCheckStatus()!=null && cfUserDriverLicense.getCheckStatus().byteValue()==(byte)1){
                updateUser.setDriverLicenseStatus((byte)2);
            }else{
                updateUser.setDriverLicenseStatus((byte)1);
            }
            updateUser.setNickName("司机-"+cfUserDriverLicense.getUserName());
            updateUser.setPhone(cfUserDriverLicense.getPhone());
            updateUser.setTrueName(cfUserDriverLicense.getUserName());
            cfUserService.updateByPrimaryKeySelective(updateUser);
            cfUserDriverLicense.setUid(updateUser.getId());
        }else{
            //创建新用户
            cfUser = new CfUser();
            cfUser.setId(idWorker.nextId());
            cfUser.setUserName(cfUserService.randomMakeUserName("",0));
            cfUser.setAvatar("");
            cfUser.setNickName("司机-"+cfUserDriverLicense.getUserName());
            cfUser.setPassword(StringTools.getRandomString("", 0));
            cfUser.setType((byte)0);
            cfUser.setPhone(cfUserDriverLicense.getPhone());
            cfUser.setTrueName(cfUserDriverLicense.getUserName());
            cfUser.setBirthday(0L);
            cfUser.setSign("");
            cfUser.setEmail("");
            cfUser.setSex((byte)1);
            cfUser.setCreateTime(System.currentTimeMillis());
            if(cfUserDriverLicense.getCheckStatus()!=null && cfUserDriverLicense.getCheckStatus().byteValue()==(byte)1){
                cfUser.setDriverLicenseStatus((byte)2);
            }else{
                cfUser.setDriverLicenseStatus((byte)1);
            }

            CfUser lastUser = cfUserService.add(cfUser);
            cfUserDriverLicense.setUid(lastUser.getId());
        }
    }
}
