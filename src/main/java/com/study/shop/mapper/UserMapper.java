package com.study.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.shop.domain.User;
import org.apache.ibatis.annotations.Mapper;


/**
 * 用户查询接口，实现基本查询语句
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
