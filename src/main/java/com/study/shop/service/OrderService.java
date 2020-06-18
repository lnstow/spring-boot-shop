package com.study.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.study.shop.domain.Order;
import com.study.shop.mapper.OrderMapper;
import org.springframework.stereotype.Service;

@Service
public interface OrderService extends IService<Order> {

    public int addOne(Order order);


}
