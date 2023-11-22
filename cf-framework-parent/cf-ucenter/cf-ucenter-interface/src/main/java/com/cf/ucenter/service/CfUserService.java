package com.cf.ucenter.service;

import com.cf.framework.domain.report.CountByDay;
import com.cf.ucenter.domain.*;
import com.cf.ucenter.request.CfCountUserQuery;
import com.cf.ucenter.request.CfUserQuery;

import java.util.List;
import java.util.Map;

/**
 * 请在此填写描述
 *
 * @ClassName CfUserService
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/12/18/018 23:01
 * @Version 1.0
 **/
public interface CfUserService {

    /**
     * 根据用户名查询用户
     * @param userName
     * @return
     */
    public CfUser findByUserName(String userName);

    /**
     * 根据手机号查询用户
     * @param phone
     * @return
     */
    public CfUser findByPhone(String phone);

    /**
     * 注册用户
     * @param phone
     * @param smsCode
     * @param userName
     * @param password
     * @param nickName
     * @return
     */
    public CfUser register(String phone, String smsCode, String userName, String password, String nickName);

    /**
     * 检查用户名是否已经存在
     * @param userName
     */
    public void checkUserNameExist(String userName);

    /**
     * 检查手机号是否已经存在
     * @param phone
     */
    public CfUser checkPhoneExist(String phone);

    /**
     * 根据id获取指定用户
     * @param uid
     * @param fillingRole 是否要填充角色数据
     * @return
     */
    public CfUser getUserByUid(String uid, Boolean fillingRole);

    /**
     * 获取用户管理员信息
     * @param uid
     * @return
     */
    public CfUserExt getUserAdministratorByUid(String uid);

    /**
     * 根据用户id判断用户是否存在
     * @param uid
     * @param expectEmpty 期望数据为空(true-若用户存在抛出用户已存在异常/false-若用户不存在则抛出用户不存在异常)
     */
    public CfUser checkUserExistByUid(String uid, Boolean expectEmpty);

    /**
     * 根据手机号/用户id/用户名查询用户
     *
     * @param key
     * @return
     */
    public List<CfUser> findByPhoneOrUidOrName(String key);

    /**
     * 根据条件查询用户数据列表
     * @param conditions example {"字段名":"表别名"}
     * @param allowFiledsMap example {"字段名":"表别名"}
     * @param allowFileds example {"字段名"}
     * @return
     */
    public List<CfUser> selectListByCondition(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds);

    /**
     * 根据条件查询用户数据列表数
     * @param conditions example {"字段名":"表别名"}
     * @param allowFiledsMap example {"字段名":"表别名"}
     * @param allowFileds example {"字段名"}
     * @return
     */
    public Integer selectListByConditionCounts(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds);

    /**
     * 更新用户信息
     * @param cfUser
     * @return
     */
    public CfUser update(CfUser cfUser);

    /**
     * 更新用户信息
     * @param cfUser
     * @return
     */
    public int updateByPrimaryKeySelective(CfUser cfUser);

    /**
     * 根据条件更新用户信息
     * @param cfUser
     * @param cfUserQuery
     * @return
     */
    public int updateByQuery(CfUser cfUser, CfUserQuery cfUserQuery);

    /**
     * 直接更新用户信息(不作任何校验)
     * @param cfUser
     * @return
     */
    public CfUser directUpdate(CfUser cfUser);

    /**
     * 更新用户信息(包含更新角色数据)
     * @param cfUser
     * @param roleIds
     * @return
     */
    public CfUser update(CfUser cfUser, String roleIds);

    /**
     * 创建用户
     * @param cfUser
     * @return
     */
    public CfUser add(CfUser cfUser);

    /**
     * 新增用户(包含新增角色数据)
     * @param cfUser
     * @param roleIds
     * @return
     */
    public CfUser add(CfUser cfUser, String roleIds);

    /**
     * 制作用户角色数据
     * @param uid
     * @param roleIds
     * @return
     */
    public List<CfUserRole> makeCfUserRoles(String uid, String roleIds);

    /**
     * 根据校验手机和短信验证码修改密码
     * @param uid
     * @param password
     * @param smsCode
     */
    public void modifyPasswordByPhoneAndCode(String uid, String password, String smsCode);

    /**
     * 根据校验手机和短信验证码找回密码
     * @param phone
     * @param password
     * @param smsCode
     */
    public void recoverPasswordByPhoneAndCode(String phone, String password, String smsCode);

    /**
     * 绑定手机号
     * @param uid
     * @param phone
     * @param smsCode
     */
    CfUser bindPhone(String uid, String phone, String smsCode);

    /**
     * 根据用户和短信验证码更新密码(会去校验该用户绑定手机号验证码是否有效)
     * @param cfUser
     * @param password
     * @param smsCode
     */
    public void updatePasswordByUserAndCode(CfUser cfUser, String password, String smsCode);

    /**
     * 用户自主更新基础用户数据(只会更新非关键字段数据)
     * @param cfUser
     * @return
     */
    public CfUser customerBaseUpdate(CfUser cfUser);

    /**
     * 根据传入的微信用户数据进行新增或者更新用户数据
     * @param wxUser
     * @param platform
     * @return
     */
    public CfUser addOrUpdateUserByWxUser(WxUser wxUser, String platform);

    /**
     * 根据传入的微信用户数据进行新增用户数据
     * @param wxUser
     * @param platform
     * @return
     */
    public CfUser addUserByWxUser(WxUser wxUser, String platform);

    /**
     * 随机生成用户名
     * @param optionalCharacter
     * @param length
     * @return
     */
    public String randomMakeUserName(String optionalCharacter, Integer length);

    /**
     * 统计前N天每天的用户注册录数
     * @param cfCountUserQuery
     * @return
     */
    public List<CountByDay> limitDaysCountByDay(CfCountUserQuery cfCountUserQuery);

    /**
     * 获取某个年份某个月数的用户注册录数
     * @param cfCountUserQuery
     * @return
     */
    public List<CountByDay> yearMonthCountByDay(CfCountUserQuery cfCountUserQuery);

    /**
     * 获取某个年份每个月份的用户注册录数
     * @param cfCountUserQuery
     * @return
     */
    public List<CountByDay> yearCountByMonth(CfCountUserQuery cfCountUserQuery);

    public CfUserExample getExampleByQuery(CfUserQuery cfUserQuery);

    public List<CfUser> getListByQuery(CfUserQuery cfUserQuery);

    public Integer getCountByQuery(CfUserQuery cfUserQuery);

    /**
     * 检查用户的身份证和驾驶证是否已经上传并审核通过，如果正常会返回驾驶证和身份证数据
     * @param uid
     */
    Map<String, Object> checkUserDocumentsStatus(String uid) throws Exception;

    /**
     * 检查用户的身份证是否已经上传并审核通过，如果正常会返回驾驶证和身份证数据
     * @param uid
     */
    CfUserIdCard checkUserIdCardDocumentsStatus(String uid) throws Exception;

    /**
     * 检查用户的驾驶证是否已经上传并审核通过，如果正常会返回驾驶证和身份证数据
     * @param uid
     */
    CfUserDriverLicense checkUserDriverDocumentsStatus(String uid) throws Exception;
}
