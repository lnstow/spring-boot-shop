package com.study.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FilemController {


    // 向用户登录页面跳转
    @GetMapping("/userLogin")
    public String toLoginPage() {
        return "login/login";
    }

    //向用户注册页面跳转
    @GetMapping("/userRegistered")
    public String toRegistered(){
        return "registered/registered";
    }

}
