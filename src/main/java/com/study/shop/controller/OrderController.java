package com.study.shop.controller;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.study.shop.domain.Cart;
import com.study.shop.domain.Order;
import com.study.shop.domain.OrderDetail;
import com.study.shop.domain.Product;
import com.study.shop.service.UserService;
import com.study.shop.service.impl.OrderDetailServiceImpl;
import com.study.shop.service.impl.OrderServiceImpl;
import com.study.shop.service.impl.ProductServiceImpl;
import com.study.shop.service.impl.UserServiceImpl;
import com.study.shop.utils.UserUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    ProductServiceImpl productService;

    @Autowired
    OrderServiceImpl orderService;

    @Autowired
    OrderDetailServiceImpl orderDetailService;

    @Autowired
    UserServiceImpl userService;

    @GetMapping(value = "/add/{id}")
    public String addToOrder(@PathVariable("id") int id, Model model) {

        // 将商品库存减一
        Product product = productService.getById(id);
        int num = product.getNum() - 1;
        product.setNum(num);
        productService.updateById(product);

        // 生成订单
        Order order = new Order();
        order.setAmount(product.getPrice().multiply(new BigDecimal("1")));
        order.setUserid(UserUtils.getCurrentUser(userService).getId());
        orderService.addOne(order);

        // 添加商品详情表
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderid(order.getId());
        orderDetail.setProductid(id);
        // 前端传回所要购买的数量
        int a = 1;
        orderDetail.setNum(a);
        // 商品价格乘以商品数量
        BigDecimal i = new BigDecimal(a);
        orderDetail.setPrice(product.getPrice().multiply(i));
        orderDetailService.save(orderDetail);

        return "redirect:/order";
    }

    @GetMapping(value = "")
    public String order(Model model) {
        model.addAttribute("orderList", orderService.listByUserId(UserUtils.getCurrentUser(userService).getId()));
        return "order/order";
    }

    @GetMapping(value = "/detail/{orderid}")
    public String detail(@PathVariable("orderid") int orderid, Model model) {
        QueryWrapper<OrderDetail> wrapper3 = new QueryWrapper<>();
        wrapper3.eq("orderid", orderid);
        model.addAttribute("detailList", orderDetailService.list(wrapper3));
        return "order/detail";
    }

}
