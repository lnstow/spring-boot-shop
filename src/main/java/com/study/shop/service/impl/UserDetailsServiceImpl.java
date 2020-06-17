package com.study.shop.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.study.shop.domain.User;
import com.study.shop.mapper.UserMapper;
import com.study.shop.utils.UserUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        User user = userMapper.selectOne(wrapper);
        if (user == null)
            throw new UsernameNotFoundException("当前用户不存在！");
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        String role = "user";
        if (user.getAuthority().equals("ROLE_user"))
            role = "user";
        list.add(new SimpleGrantedAuthority(role));
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), list);
        UserUtils.userName = user.getUsername();
        UserUtils.userId = user.getId();
        return userDetails;
    }
}
