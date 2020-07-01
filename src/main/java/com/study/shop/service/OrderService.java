package com.study.shop.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.study.shop.domain.Order;

import org.springframework.stereotype.Service;

@Service
public interface OrderService extends IService<Order> {

    public int addOne(Order order);

    public List<Order> listByUserId(int userid);

}
