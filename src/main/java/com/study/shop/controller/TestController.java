package com.study.shop.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class TestController {

    @GetMapping(value = "/test")
    public String test() {
        return "new String()";
    }

}