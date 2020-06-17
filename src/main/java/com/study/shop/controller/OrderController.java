package com.study.shop.controller;

import java.math.BigDecimal;

import com.study.shop.domain.Order;
import com.study.shop.domain.OrderDetail;
import com.study.shop.domain.Product;
import com.study.shop.service.impl.OrderDetailServiceImpl;
import com.study.shop.service.impl.OrderServiceImpl;
import com.study.shop.service.impl.ProductServiceImpl;
import com.study.shop.utils.UserUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    ProductServiceImpl productService;

    @Autowired
    OrderServiceImpl orderService;

    @Autowired
    OrderDetailServiceImpl orderDetailService;

    @GetMapping(value = "/add/{id}")
    public String addToOrder(@PathVariable("id") int id, Model model) {

        // 将商品库存减一
        Product product = productService.getById(id);
        int num = product.getNum() - 1;
        product.setNum(num);

        // 生成订单
        Order order = new Order();
        order.setAmount(product.getPrice().multiply(new BigDecimal("1")));
        order.setUserid(UserUtils.userId);
        orderService.addOne(order);

        // 添加商品详情表
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderid(order.getId());
        orderDetail.setProductid(id);
        orderDetail.setNum(1);
        orderDetail.setPrice(product.getPrice());
        orderDetailService.save(orderDetail);

        return "cart/cart";
    }
}
