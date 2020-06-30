package com.study.shop.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.study.shop.domain.User;
import com.study.shop.service.UserService;
import com.study.shop.service.impl.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UserUtils {

    public static String getUserName() {
        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if ("anonymousUser".equals(object))
            return "null";
        else
            return ((UserDetails) object).getUsername();
    }

    public static User getCurrentUser(UserService userService) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", UserUtils.getUserName());
        User user = userService.getOne(wrapper);
        return user;
    }
}