package com.study.shop.controller;

import com.study.shop.utils.UserUtils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping(value = "/test")
    public String test() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String pwd = encoder.encode("test");
        System.out.println(encoder.matches("test", pwd));
        System.out.println(encoder.encode("123"));
        System.out.println(encoder.encode("vip"));
        System.out.println(encoder.encode("admin"));
        System.out.println(encoder.encode("root"));
        // String username = UserUtils.getUserName();
        // System.out.println(username);
        return pwd;
    }

}