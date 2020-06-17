package com.study.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.shop.domain.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
