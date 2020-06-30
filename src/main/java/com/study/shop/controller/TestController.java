package com.study.shop.controller;

import com.study.shop.utils.UserUtils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping(value = "/test")
    public String test() {
        // BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        // String pwd = encoder.encode("test");
        // System.out.println(encoder.matches("test", pwd));
        String username = UserUtils.getUserName();
        System.out.println(username);
        return username;
    }

}