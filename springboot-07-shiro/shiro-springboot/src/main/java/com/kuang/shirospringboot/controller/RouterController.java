package com.kuang.shirospringboot.controller;

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
}
