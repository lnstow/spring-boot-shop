package com.study.shop.controller;

import com.study.shop.domain.User;
import com.study.shop.service.impl.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    UserServiceImpl userService;

    // 向用户登录页面跳转
    @GetMapping("/userLogin")
    public String toLoginPage() {
        return "login/login";
    }

    // 向用户注册页面跳转
    @GetMapping("/userRegister")
    public String toRegister() {
        return "register/register";
    }

    @PostMapping(value = "/userRegister")
    public String addUser(User user, String okpwd) {
        if (!user.getPassword().equals(okpwd))
            return "redirect:/userRegister";
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        try {
            // 重复注册会抛出异常
            userService.save(user);
        } catch (Exception e) {
            return "redirect:/userRegister";
        }
        return "redirect:/";
    }

}
