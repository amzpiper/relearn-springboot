package com.kuang.shirospringboot.config;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

/**
 * @author guoyh
 */
public class UserRealm extends AuthorizingRealm {

    /**
     * 先认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行了==>认证doGetAuthenticationInfo");
        // 用户名密码 ~ 数据库中取
        String name = "root";
        String pwd = "root";

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        // 判断用户是否存在
        if (!usernamePasswordToken.getUsername().equals(name)) {
            // 抛出异常 UnknownAccountException
            return null;
        }
        /*
         判断密码是否正确,shiro自己在做,参数:
         Object principal 获取当前用户的认证
         Object credentials 用户的正确密码
         String realmName 认证名
         */
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo("", pwd, "");
        return info;
    }

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了==>授权doGetAuthorizationInfo");
        return null;
    }
}
