package com.study.shop.service.impl;

import com.study.shop.domain.User;
import com.study.shop.mapper.UserMapper;
import com.study.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user=userMapper.getUserNameAndPwd(username);
        List<SimpleGrantedAuthority> list=null;
        UserDetails userDetails=new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),list);
        return  userDetails;
    }
}
