package com.study.shop.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class UserUtils {
    public static String getUserName() {
        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if ("anonymousUser".equals(object))
            return "null";
        else
            return ((UserDetails) object).getUsername();
    }
}