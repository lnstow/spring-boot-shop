package com.study.shop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Autowired
    private MyInterceptor myInterceptor;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // registry.addViewController("/toLoginPage").setViewName("login");
        // registry.addViewController("/login.html").setViewName("login");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // registry.addInterceptor(myInterceptor).addPathPatterns("/**").excludePathPatterns("/login.html");
        // registry.addInterceptor(myInterceptor).excludePathPatterns("/**");
    }
}