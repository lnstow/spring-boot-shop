package com.study.shop.controller;

import com.study.shop.domain.User;
import com.study.shop.service.impl.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String toRegister(Model model) {
        model.addAttribute("error", model.getAttribute("error"));
        model.addAttribute("user", model.getAttribute("user"));
        return "register/register";
    }

    @PostMapping(value = "/userRegister")
    public String addUser(User user, String okpwd, RedirectAttributes attr) {
        if (!user.getPassword().equals(okpwd)) {
            attr.addFlashAttribute("error", "两次输入的密码不一样！");
            attr.addFlashAttribute("user", user);
            return "redirect:/userRegister";
        }
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        try {
            // 重复注册会抛出异常
            userService.save(user);
        } catch (Exception e) {
            attr.addFlashAttribute("error", "此用户已注册，请更换！");
            attr.addFlashAttribute("user", user);
            return "redirect:/userRegister";
        }
        return "redirect:/";
    }

}
