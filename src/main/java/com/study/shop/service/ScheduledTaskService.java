package com.study.shop.service;

import java.util.List;

import com.study.shop.domain.Order;
import com.study.shop.service.impl.OrderServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledTaskService {

    @Autowired
    OrderServiceImpl orderService;

    // 15秒更新一次订单支付状态
    @Scheduled(fixedDelay = 15000)
    public void updateStatus() {
        List<Order> orderList = orderService.getBaseMapper().listAll();
        Order order;
        for (int i = 0; i < orderList.size(); i++) {
            order = orderList.get(i);
            if (order.getStatus().equals("待收货")) {
                if (order.getProgress() != 100)
                    order.setProgress(order.getProgress() + 10);
                else
                    order.setStatus("已完成");
            } else if (order.getStatus().equals("待支付"))
                order.setStatus("待收货");

            orderService.getBaseMapper().updOrder(order);
        }
        // orderService.updateBatchById(order);
    }

}