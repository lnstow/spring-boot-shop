package com.study.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.shop.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
