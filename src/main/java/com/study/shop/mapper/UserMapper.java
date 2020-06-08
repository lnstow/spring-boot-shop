package com.study.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.shop.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * 用户查询接口，实现基本查询语句
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    //查询用户明在数据库是否存在
    @Select("select username, password from user where username = #{username}")
    public User getUserNameAndPwd(String UserName);

    //查询用户权限
    @Select("select authority from user where username = #{username}")
    public List<User> getUserAuthority(String UserName);

}
