package com.kuang.shirospringboot.config;

import com.kuang.shirospringboot.pojo.User;
import com.kuang.shirospringboot.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guoyh
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

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
        //String name = "root";
        //String pwd = "root";

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        //使用真实数据库
        User user = userService.queryUserByName(usernamePasswordToken.getUsername());
        if (user == null) {
            // 抛出异常 UnknownAccountException
            return null;
        }
        // 判断用户是否存在
        //if (!usernamePasswordToken.getUsername().equals(name)) {
        //    // 抛出异常 UnknownAccountException
        //    return null;
        //}

        /*
         判断密码是否正确,shiro自己在做,参数:
         Object principal 获取当前用户的认证,传递数据
         Object credentials 用户的正确密码,可以加密
         String realmName 认证名
         */
        //SimpleAuthenticationInfo info = new SimpleAuthenticationInfo("", pwd, "");
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), "");
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
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //真实是从数据库中获取,应该有个权限表
        //List<String> list = new ArrayList<>();
        //list.add("user:add");
        //list.add("user:update");
        //for (String perm : list) {
        //    //对用户增加授权
        //    info.addStringPermission(perm);
        //}

        //拿到当前用户对象
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        String[] perms = user.getPerms().split(";");
        for (String perm : perms) {
            info.addStringPermission(perm);
        }

        return info;
    }
}
