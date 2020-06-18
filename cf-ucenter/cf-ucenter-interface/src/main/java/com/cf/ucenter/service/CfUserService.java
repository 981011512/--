package com.cf.ucenter.service;

import com.cf.ucenter.domain.CfUser;
import com.cf.ucenter.domain.CfUserExt;
import com.cf.ucenter.domain.CfUserRole;

import java.util.List;
import java.util.Map;

/**
 * 请在此填写描述
 *
 * @ClassName CfUserService
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2019/12/18/018 23:01
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
    public void checkPhoneExist(String phone);

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
     * 更新用户信息(包含新增角色数据)
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
}
