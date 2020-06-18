package com.cf.ucenter.service;

import com.cf.framework.domain.ucenter.ext.AuthToken;
import com.cf.ucenter.domain.CfAuth;
import com.cf.ucenter.domain.CfUserAuth;
import org.springframework.security.jwt.Jwt;

import java.util.List;

/**
 * 请在此填写描述
 *
 * @ClassName AuthService
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2019/12/11/011 23:06
 * @Version 1.0
 **/
public interface AuthService {

    public AuthToken login(String username, String password, String clientId, String clientSecret);

    public boolean delToken(String access_token);

    public AuthToken getUserToken(String token);

    /**
     * 校验jwt令牌是否合法
     * @param jwtString
     * @return
     */
    public String checkJwtToken(String jwtString);

    /**
     * 递归查询
     * @param authLevel
     * @param whereVal
     * @return
     */
    public List<CfAuth> recursiveQuery(Byte authLevel, String whereVal);

    /**
     * 获取所有权限列表数据，同时标识指定用户拥有的权限
     * @param uid
     * @return
     */
    public List<CfAuth> getAuthsByUid(String uid);

    public List<CfAuth> selectByUidAndLevel(String uid, Byte level, Boolean recursive);

    public List<CfAuth> selectByUidAndModuleAndLevel(String uid, String module, Byte level, Boolean recursive);

    public List<CfAuth> selectByUidAndControllerAndLevel(String uid, String controller, Byte level);

    public List<CfAuth> getAuthsByRoleId(String roleId);

    public List<CfAuth> selectByRoleIdAndLevel(String roleId, Byte level, Boolean recursive);

    public List<CfAuth> selectByRoleIdAndModuleAndLevel(String roleId, String module, Byte level, Boolean recursive);

    public List<CfAuth> selectByRoleIdAndControllerAndLevel(String roleId, String controller, Byte level);

    public CfAuth addAuth(CfAuth cfAuth);

    public CfAuth updateAuth(CfAuth cfAuth);

    public Integer deleteAuth(String id);

    /**
     * 根据数据制作权限层级
     * @param cfAuth
     * @return
     */
    public CfAuth makeAuthLevel(CfAuth cfAuth);

    /**
     * 检查是否存在下级
     * @param cfAuth
     */
    public Boolean checkIsExistSubordinate(CfAuth cfAuth);

    /**
     * 添加用户权限
     * @param cfUserAuths
     * @return
     */
    public Integer addUserAuths(List<CfUserAuth> cfUserAuths);

    /**
     * 删除用户权限
     * @param uid
     * @return
     */
    public Integer deleteUserAuths(String uid);

    /**
     * 刷新用户权限
     * @param cfUserAuths
     */
    public void flushUserAuths(List<CfUserAuth> cfUserAuths);
}
