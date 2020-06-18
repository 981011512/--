package com.cf.ucenter.service.impl;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.ucenter.response.UcenterCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.IdWorker;
import com.cf.sms.domain.CfSms;
import com.cf.sms.service.SmsService;
import com.cf.ucenter.dao.mapper.CfAuthMapper;
import com.cf.ucenter.dao.mapper.CfRoleMapper;
import com.cf.ucenter.dao.mapper.CfUserMapper;
import com.cf.ucenter.domain.*;
import com.cf.ucenter.service.CfRoleService;
import com.cf.ucenter.service.CfUserRoleService;
import com.cf.ucenter.service.CfUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 请在此填写描述
 *
 * @ClassName CfUserServiceImpl
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2019/12/18/018 23:06
 * @Version 1.0
 **/
@Service(version = "1.0.0")
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
    @Reference(version = "1.0.0", retries = 0, timeout = 10000)
    private SmsService smsService;
    @Autowired
    private CfRoleService cfRoleService;
    @Autowired
    private CfUserRoleService cfUserRoleService;

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
        CfUser cfUser = new CfUser(idWorker.nextId(), userName, new BCryptPasswordEncoder().encode(password), "", 0,
                nickName, "", 0L, 0, "",
                System.currentTimeMillis(), phone, "");
        cfUserMapper.insert(cfUser);
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
    public void checkPhoneExist(String phone) {
        CfUser byUserName = findByPhone(phone);
        if(byUserName!=null){
            ExceptionCast.cast(UcenterCode.UCENTER_PHONE_REGISTERED);
        }
    }

    @Override
    public CfUser getUserByUid(String uid, Boolean fillingRole) {
        CfUser cfUser = cfUserMapper.selectByPrimaryKey(uid);
        if(fillingRole){
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
            ExceptionCast.cast(UcenterCode.UCENTER_NOT_EXIST);
            return null;
        }else if(!expectEmpty && userByUid==null){
            ExceptionCast.cast(UcenterCode.UCENTER_EXIST);
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
        if (Pattern.matches("^((13[0-9])|(14[5,7,9])|(15[^4])|(18[0-9])|(17[0,1,3,5,6,7,8]))[0-9]{8}$", key) && cfUser == null) {
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
        int counts = 0;

        for (String field: allowFileds){
            if(conditions.containsKey(field)){
                String key = field;
                Map<String, Object> conditionValue = conditions.get(key);
                String andStr = counts == 0 ? " WHERE " : " AND ";
                counts++;

                if(conditionValue.get("operator").equals("=") || conditionValue.get("operator").equals(">") || conditionValue.get("operator").equals(">=")
                        || conditionValue.get("operator").equals("<") || conditionValue.get("operator").equals("<=") || conditionValue.get("operator").equals("!=")){
                    if(conditionValue.get("value") instanceof Integer){
                        sql += andStr+allowFiledsMap.get(key)+"."+key+conditionValue.get("operator")+conditionValue.get("value");
                    }else{
                        sql += andStr+allowFiledsMap.get(key)+"."+key+conditionValue.get("operator")+"'"+conditionValue.get("value")+"'";
                    }
                }else if(conditionValue.get("operator").equals("between")){
                    sql += andStr+allowFiledsMap.get(key)+"."+key+">="+(Long)conditionValue.get("min")+
                            " AND "+allowFiledsMap.get(key)+"."+key+"<="+(Long)conditionValue.get("max");
                }else if(conditionValue.get("operator").equals("like")){
                    Map<String, Object> likeList = (Map<String, Object>) conditionValue.get("list");
                    for(Map.Entry<String, Object> entry: likeList.entrySet()){
                        String entryKey = entry.getKey();
                        if(allowFiledsMap.containsKey(entryKey)){
                            int likeCounts = 0;
                            Map<String, Object> likeItems = (Map<String, Object>) entry.getValue();
                            for(Map.Entry<String, Object> likeItemsEntry: likeItems.entrySet()){
                                Map<String,String> likeItemsEntryValue = (Map<String,String>)likeItemsEntry.getValue();
                                if(likeCounts==0) {
                                    sql += andStr+"(" + likeItemsEntryValue.get("alias") + "." + entryKey + " LIKE '%" + likeItemsEntryValue.get("value")+"%'";
                                }else{
                                    sql += " OR " + likeItemsEntryValue.get("alias") + "." + entryKey + " LIKE '%" + likeItemsEntryValue.get("value")+"%'";
                                }
                                likeCounts++;
                            }
                            if(likeCounts>0){
                                sql += ") ";
                            }
                        }
                    }
                }else if(conditionValue.get("operator").equals("order")){
                    Map<String, Object> orderList = (Map<String, Object>) conditionValue.get("list");
                    int orderCounts = 0;
                    for(Map.Entry<String, Object> entry: orderList.entrySet()){
                        if(allowFiledsMap.containsKey(entry.getKey())){
                            Map<String, String> orderItem = (Map<String, String>) entry.getValue();
                            if((((String)orderItem.get("type")).toLowerCase().equals("asc")
                                    || ((String)orderItem.get("type")).toLowerCase().equals("desc"))
                                    && allowFiledsMap.containsValue((String)orderItem.get("alias"))){
                                if(orderCounts==0) {
                                    sql += " ORDER BY " + orderItem.get("alias") + "." + entry.getKey() + " " + orderItem.get("type");
                                }else{
                                    sql += "," + orderItem.get("alias") + "." + entry.getKey() + " " + orderItem.get("type");
                                }
                                orderCounts++;
                            }
                        }
                    }
                }else if(conditionValue.get("operator").equals("limit")
                        && conditionValue.get("page")!=null && conditionValue.get("page") instanceof Integer
                        && conditionValue.get("limit")!=null && conditionValue.get("limit") instanceof Integer){
                    sql += " LIMIT "+(((Integer)conditionValue.get("page")-1)*(Integer)conditionValue.get("limit"))+","+(Integer)conditionValue.get("limit");
                }
            }
        }
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
        int counts = 0;

        for (String field: allowFileds){
            if(conditions.containsKey(field)){
                String key = field;
                Map<String, Object> conditionValue = conditions.get(key);
                String andStr = counts == 0 ? " WHERE " : " AND ";
                counts++;

                if(conditionValue.get("operator").equals("=") || conditionValue.get("operator").equals(">") || conditionValue.get("operator").equals(">=")
                        || conditionValue.get("operator").equals("<") || conditionValue.get("operator").equals("<=") || conditionValue.get("operator").equals("!=")){
                    if(conditionValue.get("value") instanceof Integer){
                        sql += andStr+allowFiledsMap.get(key)+"."+key+conditionValue.get("operator")+conditionValue.get("value");
                    }else{
                        sql += andStr+allowFiledsMap.get(key)+"."+key+conditionValue.get("operator")+"'"+conditionValue.get("value")+"'";
                    }
                }else if(conditionValue.get("operator").equals("between")){
                    sql += andStr+allowFiledsMap.get(key)+"."+key+">="+(Long)conditionValue.get("min")+
                            " AND "+allowFiledsMap.get(key)+"."+key+"<="+(Long)conditionValue.get("max");
                }else if(conditionValue.get("operator").equals("like")){
                    Map<String, Object> likeList = (Map<String, Object>) conditionValue.get("list");
                    for(Map.Entry<String, Object> entry: likeList.entrySet()){
                        String entryKey = entry.getKey();
                        if(allowFiledsMap.containsKey(entryKey)){
                            int likeCounts = 0;
                            Map<String, Object> likeItems = (Map<String, Object>) entry.getValue();
                            for(Map.Entry<String, Object> likeItemsEntry: likeItems.entrySet()){
                                Map<String,String> likeItemsEntryValue = (Map<String,String>)likeItemsEntry.getValue();
                                if(likeCounts==0) {
                                    sql += andStr+"(" + likeItemsEntryValue.get("alias") + "." + entryKey + " LIKE '%" + likeItemsEntryValue.get("value")+"%'";
                                }else{
                                    sql += " OR " + likeItemsEntryValue.get("alias") + "." + entryKey + " LIKE '%" + likeItemsEntryValue.get("value")+"%'";
                                }
                                likeCounts++;
                            }
                            if(likeCounts>0){
                                sql += ") ";
                            }
                        }
                    }
                }
            }
        }
        return cfUserMapper.selectListByConditionCounts(sql);
    }

    @Override
    public CfUser update(CfUser cfUser) {
        CfUser user = checkUserExistByUid(cfUser.getId(), false);
        if(StringUtils.isNotEmpty(cfUser.getPassword())){
            cfUser.setPassword(new BCryptPasswordEncoder().encode(cfUser.getPassword()));
        }else{
            cfUser.setPassword(user.getPassword());
        }
        cfUserMapper.updateByPrimaryKey(cfUser);
        return cfUser;
    }

    @Override
    public CfUser update(CfUser cfUser, String roleIds) {
        update(cfUser);
        List<CfUserRole> cfUserRoles = makeCfUserRoles(cfUser.getId(), roleIds);
        cfUserRoleService.flushUserRoles(cfUserRoles);
        cfUser.setCfRoles(cfRoleService.getRolesByUid(cfUser.getId()));
        return cfUser;
    }

    @Override
    public CfUser add(CfUser cfUser) {
        int insert = cfUserMapper.insert(cfUser);
        if(insert==0){
            ExceptionCast.cast(CommonCode.FAIL);
        }
        return cfUser;
    }

    @Override
    public CfUser add(CfUser cfUser, String roleIds) {
        cfUser.setId(idWorker.nextId());
        cfUser.setPassword(new BCryptPasswordEncoder().encode(cfUser.getPassword()));
        cfUser.setCreateTime(System.currentTimeMillis());
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
}
