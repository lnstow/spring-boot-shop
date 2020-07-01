package com.study.shop.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.shop.domain.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {

    @Insert("insert into `order`(`amount`,`userid`) values (#{amount},#{userid})")
    public int addOne(Order order);

    @Select("select max(id) from `order`")
    public Integer getLastId();

    @Select("select * from `order` where userid = #{userid}")
    public List<Order> listByUserId(int userid);

    @Select("SELECT * FROM `order`")
    public List<Order> listAll();

    @Update("update `order` set status=#{status},progress=#{progress} where id=#{id}")
    public int updOrder(Order order);

}
