package com.study.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.shop.domain.Order;
import com.study.shop.mapper.OrderMapper;
import com.study.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {


    @Autowired
    OrderMapper orderMapper;

    public int addOne(Order order) {
//        OrderMapper orderMapper = getBaseMapper();
        Integer id = orderMapper.getLastId();
        if (id == null)
            id = 0;
        order.setId(id + 1);
        return orderMapper.addOne(order);

    }
}
