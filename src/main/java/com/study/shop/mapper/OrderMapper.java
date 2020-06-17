package com.study.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.shop.domain.Order;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {

    @Insert("insert into `order`(`amount`,`userid`) values (#{amount},#{userid})")
    public int addOne(Order order);

    @Select("select max(id) from `order`")
    public Integer getLastId();
}
