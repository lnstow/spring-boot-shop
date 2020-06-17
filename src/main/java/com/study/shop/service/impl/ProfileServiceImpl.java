package com.study.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.shop.domain.Profile;
import com.study.shop.mapper.ProfileMapper;
import com.study.shop.service.ProfileService;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl extends ServiceImpl<ProfileMapper, Profile> implements ProfileService {

}
