package com.study.shop.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class TestController {

    @GetMapping(value = "/test")
    public String test() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String pwd = encoder.encode("test");
        System.out.println(encoder.matches("test", pwd));
        return pwd;
    }

}