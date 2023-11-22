package com.cf.ucenter.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cf.framework.domain.report.CountByDay;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.ucenter.response.UcenterCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.DbUtils;
import com.cf.framework.utils.IdWorker;
import com.cf.framework.utils.StringTools;
import com.cf.pay.domain.CfAccount;
import com.cf.pay.service.CfAccountService;
import com.cf.sms.domain.CfSms;
import com.cf.sms.service.SmsService;
import com.cf.ucenter.dao.mapper.CfAuthMapper;
import com.cf.ucenter.dao.mapper.CfRoleMapper;
import com.cf.ucenter.dao.mapper.CfUserMapper;
import com.cf.ucenter.domain.*;
import com.cf.ucenter.request.*;
import com.cf.ucenter.service.*;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 请在此填写描述
 *
 * @ClassName CfUserServiceImpl
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/12/18/018 23:06
 * @Version 1.0
 **/
@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfUserServiceImpl implements CfUserService {

    @Autowired
    private CfUserMapper cfUserMapper;
    @Autowired
    private CfRoleMapper cfRoleMapper;
    @Autowired
    private CfAuthMapper cfAuthMapper;
    @Autowired
    private IdWorker idWorker;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private SmsService smsService;
    @Autowired
    private CfRoleService cfRoleService;
    @Autowired
    private CfUserRoleService cfUserRoleService;
    @Autowired
    private CfThirdPartyLoginService cfThirdPartyLoginService;
    @Autowired
    private CfUserDriverLicenseService cfUserDriverLicenseService;
    @Autowired
    private CfUserIdCardService cfUserIdCardService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfAccountService cfAccountService;

    @Override
    public CfUser findByUserName(String userName) {
        CfUserExample cfUserExample = new CfUserExample();
        CfUserExample.Criteria criteria = cfUserExample.createCriteria();
        criteria.andUserNameEqualTo(userName);
        List<CfUser> cfUsers = cfUserMapper.selectByExample(cfUserExample);
        if(cfUsers==null || cfUsers.size()==0){
            return null;
        }
        return cfUsers.get(0);
    }

    @Override
    public CfUser findByPhone(String phone) {
        CfUserExample cfUserExample = new CfUserExample();
        CfUserExample.Criteria criteria = cfUserExample.createCriteria();

        criteria.andPhoneEqualTo(phone);
        List<CfUser> cfUsers = cfUserMapper.selectByExample(cfUserExample);
        if(cfUsers==null || cfUsers.size()==0){
            return null;
        }
        return cfUsers.get(0);
    }

    @Override
    public CfUser register(String phone, String smsCode, String userName, String password, String nickName) {
        checkUserNameExist(userName);
        checkPhoneExist(phone);
        smsService.checkCode(phone,smsCode,CfSms.SMS_TYPE_REGISTER);
        CfUser cfUser = new CfUser(idWorker.nextId(), userName, password, "", (byte)0,
                nickName, "", phone,"", 0L, (byte)0, "",
                System.currentTimeMillis(), null, new BigDecimal(0),0l);
        add(cfUser);
        return cfUser;
    }

    @Override
    public void checkUserNameExist(String userName) {
        CfUser byUserName = findByUserName(userName);
        if(byUserName!=null){
            ExceptionCast.cast(UcenterCode.UCENTER_USERNAME_EXIST);
        }
    }

    @Override
    public CfUser checkPhoneExist(String phone) {
        CfUser cfUser = findByPhone(phone);
        if(cfUser!=null){
            ExceptionCast.cast(UcenterCode.UCENTER_PHONE_REGISTERED);
        }
        return cfUser;
    }

    @Override
    public CfUser getUserByUid(String uid, Boolean fillingRole) {
        CfUser cfUser = cfUserMapper.selectByPrimaryKey(uid);
        if(fillingRole && cfUser!=null){
            cfUser.setCfRoles(cfRoleService.getRolesByUid(cfUser.getId()));
        }
        return cfUser;
    }

    @Override
    public CfUserExt getUserAdministratorByUid(String uid) {
        CfUser cfUser = checkUserExistByUid(uid, false);
        CfUserExt cfUserExt = new CfUserExt();
        BeanUtils.copyProperties(cfUser,cfUserExt);
        List<CfRole> cfRoles = cfRoleMapper.selectContainDepartmentByUid(uid);
        cfUserExt.setCfRole(cfRoles);
        List<CfAuth> cfAuths = cfAuthMapper.selectByUid(uid);
        cfUserExt.setPermissions(cfAuths);
        return cfUserExt;
    }

    @Override
    public CfUser checkUserExistByUid(String uid, Boolean expectEmpty) {
        CfUser userByUid = getUserByUid(uid, false);
        if(expectEmpty && userByUid!=null){
            ExceptionCast.cast(UcenterCode.UCENTER_EXIST);
            return null;
        }else if(!expectEmpty && userByUid==null){
            ExceptionCast.cast(UcenterCode.UCENTER_NOT_EXIST);
            return null;
        }
        return userByUid;
    }

    @Override
    public List<CfUser> findByPhoneOrUidOrName(String key) {
        CfUser cfUser = null;
        if (Pattern.matches("^[0-9_]{19}$", key)) {
            cfUser = getUserByUid(key, false);
        }
        if (Pattern.matches("^(1[3-9])[0-9]{9}$", key) && cfUser == null) {
            cfUser = findByPhone(key);
        } else if (cfUser == null) {
            cfUser = findByUserName(key);
        }

        if (cfUser != null) {
            cfUser.setPassword("");
            cfUser.setBirthday(0L);
            cfUser.setCreateTime(0L);
            cfUser.setEmail("");
            cfUser.setPhone("");
            cfUser.setTrueName("");
            ArrayList<CfUser> cfUsers = new ArrayList<>();
            cfUsers.add(cfUser);
            return cfUsers;
        }
        return null;
    }

    @Override
    public List<CfUser> selectListByCondition(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds) {
        String sql = "SELECT u.id,u.user_name,u.avatar,u.type,u.nick_name,u.true_name,u.phone,u.email,u.birthday,u.sex,u.sign,u.create_time FROM cf_user u";
        sql = DbUtils.makeQuery(conditions, allowFiledsMap, allowFileds, sql, false);
        List<CfUser> cfUsers = cfUserMapper.selectListByCondition(sql);
        if(cfUsers!=null){
            for (CfUser cfUser: cfUsers){
                cfUser.setCfRoles(cfRoleService.getRolesByUid(cfUser.getId()));
            }
        }
        return cfUsers;
    }

    @Override
    public Integer selectListByConditionCounts(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds) {
        String sql = "SELECT count(*) FROM cf_user u";
        sql = DbUtils.makeQuery(conditions, allowFiledsMap, allowFileds, sql, false);
        return cfUserMapper.selectListByConditionCounts(sql);
    }

    @Override
    public CfUser update(CfUser cfUser) {
        if(StringUtils.isEmpty(cfUser.getPassword())){
            cfUser.setPassword(null);
        }else{
            cfUser.setPassword(new BCryptPasswordEncoder().encode(cfUser.getPassword()));
        }
        return directUpdate(cfUser);
    }

    @Override
    public int updateByPrimaryKeySelective(CfUser cfUser) {
        return cfUserMapper.updateByPrimaryKeySelective(cfUser);
    }

    @Override
    public int updateByQuery(CfUser cfUser, CfUserQuery cfUserQuery) {
        return cfUserMapper.updateByExampleSelective(cfUser, getExampleByQuery(cfUserQuery));
    }

    @Override
    public CfUser directUpdate(CfUser cfUser) {
        if(cfUser.getLastLoginTime()==null){
            cfUser.setLastLoginTime(System.currentTimeMillis());
        }
        cfUserMapper.updateByPrimaryKeySelective(cfUser);
        return cfUser;
    }

    @Override
    public CfUser update(CfUser cfUser, String roleIds) {
        if(cfUser.getLastLoginTime()==null){
            cfUser.setLastLoginTime(System.currentTimeMillis());
        }
        update(cfUser);
        List<CfUserRole> cfUserRoles = makeCfUserRoles(cfUser.getId(), roleIds);
        cfUserRoleService.flushUserRoles(cfUserRoles);
        cfUser.setCfRoles(cfRoleService.getRolesByUid(cfUser.getId()));
        return cfUser;
    }

    @Override
    public CfUser add(CfUser cfUser) {
        if(cfUser.getLastLoginTime()==null){
            cfUser.setLastLoginTime(System.currentTimeMillis());
        }
        cfUser.setId(idWorker.nextId());
        cfUser.setPassword(new BCryptPasswordEncoder().encode(cfUser.getPassword()));
        cfUser.setCreateTime(System.currentTimeMillis());
        int insert = cfUserMapper.insertSelective(cfUser);
        if(insert==0){
            ExceptionCast.cast(CommonCode.FAIL);
        }
        //创建用户资金账户
        CfAccount cfAccount = new CfAccount();
        cfAccount.setUid(cfUser.getId());
        cfAccount.setScoreType("cny");
        cfAccount.setBalance(new BigDecimal("0.00"));
        cfAccount.setFreeze(0l);
        cfAccount.setType((byte)0);
        cfAccount.setCreateTime(System.currentTimeMillis());
        cfAccountService.add(cfAccount);
        return cfUser;
    }

    @Override
    public CfUser add(CfUser cfUser, String roleIds) {
        if(cfUser.getLastLoginTime()==null){
            cfUser.setLastLoginTime(System.currentTimeMillis());
        }
        add(cfUser);
        List<CfUserRole> cfUserRoles = makeCfUserRoles(cfUser.getId(), roleIds);
        cfUserRoleService.addCfUserRoles(cfUserRoles);
        cfUser.setCfRoles(cfRoleService.getRolesByUid(cfUser.getId()));
        return cfUser;
    }

    @Override
    public List<CfUserRole> makeCfUserRoles(String uid, String roleIds) {
        String[] cfRoleIds = roleIds.split(",");
        ArrayList<CfUserRole> cfUserRoles = new ArrayList<>();
        for (String cfRoleId: cfRoleIds){
            CfUserRole cfUserRole = new CfUserRole();
            cfUserRole.setId(idWorker.nextId());
            cfUserRole.setUid(uid);
            cfUserRole.setRoleId(cfRoleId);
            cfUserRoles.add(cfUserRole);
        }
        return cfUserRoles;
    }

    @Override
    public void modifyPasswordByPhoneAndCode(String uid, String password, String smsCode) {
        CfUser cfUser = checkUserExistByUid(uid, false);
        updatePasswordByUserAndCode(cfUser, password, smsCode);
    }

    @Override
    public void recoverPasswordByPhoneAndCode(String phone, String password, String smsCode) {
        CfUser cfUser = findByPhone(phone);
        if(cfUser==null){
            ExceptionCast.cast(UcenterCode.PHONE_IS_NOT_REGISTERED);
        }
        updatePasswordByUserAndCode(cfUser, password, smsCode);
    }

    @Override
    public CfUser bindPhone(String uid, String phone, String smsCode) {
        smsService.checkCode(phone,smsCode,CfSms.SMS_TYPE_IDENTITY);
        //判断该手机号是否已经被绑定
        CfUser userByPhone = findByPhone(phone);
        if(userByPhone!=null){
            ExceptionCast.cast(UcenterCode.UCENTER_PHONE_REGISTERED);
        }
        CfUser cfUser = cfUserMapper.selectByPrimaryKey(uid);
        if(cfUser==null){
            ExceptionCast.cast(UcenterCode.UCENTER_NOT_EXIST);
        }
        cfUser.setPhone(phone);
        CfUser user = update(cfUser);
        user.setPassword("");
        return user;
    }

    @Override
    public void updatePasswordByUserAndCode(CfUser cfUser, String password, String smsCode) {
        smsService.checkCode(cfUser.getPhone(),smsCode,CfSms.SMS_TYPE_IDENTITY);
        cfUser.setPassword(password);
        update(cfUser);
    }

    @Override
    public CfUser customerBaseUpdate(CfUser cfUser) {
        CfUser user = checkUserExistByUid(cfUser.getId(), false);
        if(StringUtils.isNotEmpty(cfUser.getNickName())){
            user.setNickName(cfUser.getNickName());
        }
        if(StringUtils.isNotEmpty(cfUser.getAvatar())){
            user.setAvatar(cfUser.getAvatar());
        }
        if(StringUtils.isNotEmpty(cfUser.getSign())){
            user.setSign(cfUser.getSign());
        }
        if(cfUser.getSex()!=null){
            user.setSex(cfUser.getSex());
        }
        directUpdate(user);
        user.setPassword(null);
        return user;
    }

    @Override
    public CfUser addOrUpdateUserByWxUser(WxUser wxUser, String platform) {
        CfThirdPartyLoginQuery cfThirdPartyLoginQuery = new CfThirdPartyLoginQuery();
        cfThirdPartyLoginQuery.setPlatform(platform);
        String toJSONString = JSONObject.toJSONString(wxUser);
        if(StringUtils.isNotEmpty(wxUser.getUnionid())){
            cfThirdPartyLoginQuery.setUnionid(wxUser.getUnionid());
        }
        cfThirdPartyLoginQuery.setAppid(wxUser.getAppid());
        List<CfThirdPartyLogin> cfThirdPartyLogins = cfThirdPartyLoginService.getListByQuery(cfThirdPartyLoginQuery);
        if(cfThirdPartyLogins!=null && cfThirdPartyLogins.size()>0){
            CfUser cfUser = getUserByUid(cfThirdPartyLogins.get(0).getUid(), true);
            CfUser user = new CfUser();
            if(cfUser!=null){
                user.setId(cfUser.getId());
                if(StringUtils.isNotEmpty(cfUser.getNickName())){
                    user.setNickName(wxUser.getNickname().replaceAll("[^a-zA-Z0-9\\u4e00-\\u9fa5]", " "));
                    cfUser.setNickName(wxUser.getNickname().replaceAll("[^a-zA-Z0-9\\u4e00-\\u9fa5]", " "));
                }
                if(StringUtils.isNotEmpty(cfUser.getAvatar())){
                    user.setAvatar(wxUser.getHeadimgurl());
                    cfUser.setAvatar(wxUser.getHeadimgurl());
                }
                if(StringUtils.isEmpty(cfThirdPartyLogins.get(0).getOpenid())){
                    //更新微信用户信息，考虑第三方平台与本平台数据互动只是unionid导致用户不完全的问题
                    CfThirdPartyLogin cfThirdPartyLogin = cfThirdPartyLogins.get(0);
                    cfThirdPartyLogin.setOpenid(wxUser.getOpenid());
                    cfThirdPartyLoginService.update(cfThirdPartyLogin);
                }
                cfUser.setPassword(null);
                update(user);    //只做局部更新
                return cfUser;
            }else{
                cfThirdPartyLoginService.delete(cfThirdPartyLogins.get(0).getId());
                return addUserByWxUser(wxUser, platform);
            }
        }
        return addUserByWxUser(wxUser, platform);
    }

    @Override
    public CfUser addUserByWxUser(WxUser wxUser, String platform) {

        CfThirdPartyLoginQuery cfThirdPartyLoginQuery = new CfThirdPartyLoginQuery();
        cfThirdPartyLoginQuery.setPlatform(platform);
        if(StringUtils.isNotEmpty(wxUser.getUnionid())){
            cfThirdPartyLoginQuery.setUnionid(wxUser.getUnionid());
        }else{
            cfThirdPartyLoginQuery.setOpenid(wxUser.getOpenid());
        }
        List<CfThirdPartyLogin> cfThirdPartyLogins = cfThirdPartyLoginService.getListByQuery(cfThirdPartyLoginQuery);
        CfUser user = null;
        if(cfThirdPartyLogins==null || cfThirdPartyLogins.size()==0){
            //判断同样的unionid是否存在
            cfThirdPartyLoginQuery.setPlatform(null);
            cfThirdPartyLogins = cfThirdPartyLoginService.getListByQuery(cfThirdPartyLoginQuery);
            if(cfThirdPartyLogins!=null && cfThirdPartyLogins.size()>0){
                user = getUserByUid(cfThirdPartyLogins.get(0).getUid(), false);
            }else{
                CfUser cfUser = new CfUser();
                cfUser.setId(idWorker.nextId());
                cfUser.setUserName(randomMakeUserName("",0));
                cfUser.setAvatar(wxUser.getHeadimgurl());
                cfUser.setNickName(wxUser.getNickname().replaceAll("[^a-zA-Z0-9\\u4e00-\\u9fa5]", " "));
                cfUser.setPassword(StringTools.getRandomString("", 0));
                cfUser.setType((byte)0);
                cfUser.setPhone("");
                cfUser.setTrueName("");
                cfUser.setBirthday(0L);
                cfUser.setSign("");
                cfUser.setEmail("");
                cfUser.setSex(wxUser.getSex().byteValue());
                cfUser.setCreateTime(System.currentTimeMillis());
                user = add(cfUser);
            }

        }else{
            user = getUserByUid(cfThirdPartyLogins.get(0).getUid(), false);
        }
        CfThirdPartyLogin cfThirdPartyLogin = new CfThirdPartyLogin();
        cfThirdPartyLogin.setAppid(wxUser.getAppid());
        cfThirdPartyLogin.setOpenid(wxUser.getOpenid());
        cfThirdPartyLogin.setUnionid(wxUser.getUnionid());
        cfThirdPartyLogin.setUid(user.getId());
        cfThirdPartyLogin.setPlatform(platform);
        cfThirdPartyLogin.setMainBodyId("");
        cfThirdPartyLoginService.add(cfThirdPartyLogin);
        return user;
    }

    @Override
    public String randomMakeUserName(String optionalCharacter, Integer length) {
        String userName = StringTools.getRandomString(optionalCharacter, length);
        CfUser cfUser = findByUserName(userName);
        if(cfUser!=null){
            return randomMakeUserName(optionalCharacter, length);
        }
        return userName;
    }

    @Override
    public List<CountByDay> limitDaysCountByDay(CfCountUserQuery cfCountUserQuery) {
        return cfUserMapper.limitDaysCountByDay(cfCountUserQuery);
    }

    @Override
    public List<CountByDay> yearMonthCountByDay(CfCountUserQuery cfCountUserQuery) {
        cfCountUserQuery.setDate(cfCountUserQuery.getYear()+"-"+cfCountUserQuery.getMonth()+"-16"+" 00:00:00");
        return cfUserMapper.yearMonthCountByDay(cfCountUserQuery);
    }

    @Override
    public List<CountByDay> yearCountByMonth(CfCountUserQuery cfCountUserQuery) {
        cfCountUserQuery.setDate(cfCountUserQuery.getYear()+"-01-01 00:00:00");
        cfCountUserQuery.setEndDate(cfCountUserQuery.getYear()+"-12-31 23:59:59");
        return cfUserMapper.yearCountByMonth(cfCountUserQuery);
    }

    @Override
    public CfUserExample getExampleByQuery(CfUserQuery cfUserQuery) {
        CfUserExample cfUserExample = new CfUserExample();
        CfUserExample.Criteria criteria = cfUserExample.createCriteria();
        if(StringUtils.isNotEmpty(cfUserQuery.getUserName())){
            criteria.andUserNameEqualTo(cfUserQuery.getUserName());
        }
        if(cfUserQuery.getIdCardStatus()!=null){
            criteria.andIdCardStatusEqualTo(cfUserQuery.getIdCardStatus());
        }
        if(cfUserQuery.getDriverLicenseStatus()!=null){
            criteria.andDriverLicenseStatusEqualTo(cfUserQuery.getDriverLicenseStatus());
        }
        if(cfUserQuery.getType()!=null){
            criteria.andTypeEqualTo(cfUserQuery.getType());
        }
        if(StringUtils.isNotEmpty(cfUserQuery.getOrderBy())){
            cfUserExample.setOrderByClause(cfUserQuery.getOrderBy());
        }
        if(cfUserQuery.getPage()!=null && cfUserQuery.getSize()!=null){
            PageHelper.startPage(cfUserQuery.getPage(), cfUserQuery.getSize());
        }
        return cfUserExample;
    }

    @Override
    public List<CfUser> getListByQuery(CfUserQuery cfUserQuery) {
        return cfUserMapper.selectByExample(getExampleByQuery(cfUserQuery));
    }

    @Override
    public Integer getCountByQuery(CfUserQuery cfUserQuery) {
        cfUserQuery.setPage(null);
        return cfUserMapper.countByExample(getExampleByQuery(cfUserQuery));
    }

    @Override
    public Map<String, Object> checkUserDocumentsStatus(String uid) throws Exception {
        Map<String, Object> userDocuments = new HashMap<>();
        //判断用户驾驶证是否有上传并且审核通过
        CfUserDriverLicense cfUserDriverLicense = checkUserDriverDocumentsStatus(uid);
        userDocuments.put("UserDriverLicense",cfUserDriverLicense);
        //判断用户身份证是否有上传并且审核通过
        CfUserIdCard cfUserIdCard = checkUserIdCardDocumentsStatus(uid);
        userDocuments.put("UserIdCard",cfUserIdCard);
        return userDocuments;
    }

    @Override
    public CfUserIdCard checkUserIdCardDocumentsStatus(String uid) throws Exception {
        CfUserIdCardQuery cfUserIdCardQuery = new CfUserIdCardQuery();
        cfUserIdCardQuery.setUid(uid);
        List<CfUserIdCard> cfUserIdCards = cfUserIdCardService.getListByQuery(cfUserIdCardQuery);
        if(cfUserIdCards==null || cfUserIdCards.size()==0 || cfUserIdCards.get(0).getCheckStatus()==(byte)0){
            ExceptionCast.cast(UcenterCode.USER_ID_IS_ABNORMAL,"身份证出现了问题，请自己确认或者联系管理员确认");
        }
        return cfUserIdCards.get(0);
    }

    @Override
    public CfUserDriverLicense checkUserDriverDocumentsStatus(String uid) throws Exception {
        CfUserDriverLicenseQuery cfUserDriverLicenseQuery = new CfUserDriverLicenseQuery();
        cfUserDriverLicenseQuery.setUid(uid);
        List<CfUserDriverLicense> cfUserDriverLicenses = cfUserDriverLicenseService.getListByQuery(cfUserDriverLicenseQuery);
        if(cfUserDriverLicenses==null || cfUserDriverLicenses.size()==0 || cfUserDriverLicenses.get(0).getCheckStatus()==(byte)0){
            ExceptionCast.cast(UcenterCode.USER_ID_IS_ABNORMAL,"驾驶证出现了问题，请自己确认或者联系管理员确认");
        }
        return cfUserDriverLicenses.get(0);
    }
}
