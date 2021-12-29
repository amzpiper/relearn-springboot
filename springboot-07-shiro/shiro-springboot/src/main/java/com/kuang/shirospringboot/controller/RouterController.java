package com.kuang.shirospringboot.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author guoyh
 */
@Controller
public class RouterController {

    @RequestMapping({"/","index","index.html"})
    public String toIndex(Model model) {
        model.addAttribute("msg", "Hello,Shiro");
        return "index";
    }

    @RequestMapping("/user/add")
    public String toAdd(Model model) {
        return "user/add";
    }

    @RequestMapping("/user/update")
    public String toUpdate(Model model) {
        return "user/update";
    }

    @RequestMapping("/toLogin")
    public String toLogin(Model model) {
        return "login";
    }

    @RequestMapping("/login")
    public String login(String username, String password, Model model) {
        // 获取当前的用户
        Subject subject = SecurityUtils.getSubject();
        // 封装用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            // 执行登录
            subject.login(token);
            Object principal = subject.getPrincipal();
            model.addAttribute("msg", principal.toString());
            return "index";
        } catch (UnknownAccountException e) {
            System.out.println("用户名不存在");
            model.addAttribute("msg", "用户名不存在");
            return "login";
        } catch (IncorrectCredentialsException e) {
            System.out.println("密码错误");
            model.addAttribute("msg", "密码错误");
            return "login";
        } catch (AuthenticationException e) {
            System.out.println("其他错误");
            model.addAttribute("msg", "其他错误");
            return "login";
        }
    }

}
