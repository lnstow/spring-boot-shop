package com.study.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.shop.domain.Admin;
import org.apache.ibatis.annotations.Mapper;

/**
 * 管理员查询接口，实现基本的查询CRUD
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {

}
