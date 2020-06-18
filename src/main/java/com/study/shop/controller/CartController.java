package com.study.shop.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.study.shop.domain.*;
import com.study.shop.service.impl.*;
import com.study.shop.utils.UserUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    CartServiceImpl cartService;

    @Autowired
    ProductServiceImpl productService;

    @Autowired
    OrderServiceImpl orderService;

    @Autowired
    OrderDetailServiceImpl orderDetailService;

    @GetMapping(value = "/add/{id}")
    public String addToCart(@PathVariable("id") int id, Model model) {
        User user = userService.getById(UserUtils.userId);
        QueryWrapper<Cart> wrapper2 = new QueryWrapper<>();
        wrapper2.eq("userid", user.getId());
        wrapper2.eq("productid", id);
        Cart cart = cartService.getOne(wrapper2);


        if (cart == null) {
            cart = new Cart();
            cart.setId(0);
            cart.setNum(1);
            cart.setProductid(id);
            cart.setUserid(user.getId());
            cartService.save(cart);
        } else {
            cart.setNum(cart.getNum() + 1);
            cartService.updateById(cart);
        }


        QueryWrapper<Cart> wrapper3 = new QueryWrapper<>();
        wrapper3.eq("userid", user.getId());
        model.addAttribute("cartList", cartService.list(wrapper3));
        return "cart/cart";
    }

    //从购物车下单    ps：只能选一种物品下单
    @GetMapping(value = "/cart/buy/{id}{num}")
    public String buyCart(@PathVariable("id") int id, @PathVariable("num") int num, Model model){

        // 将商品库存减去用户所购买的数量
        Product product = productService.getById(id);
        int num1 = product.getNum() - num;
        product.setNum(num1);

        // 生成订单
        Order order = new Order();
        order.setAmount(product.getPrice().multiply(new BigDecimal("1")));
        order.setUserid(UserUtils.userId);
        orderService.addOne(order);

        // 添加商品详情表
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderid(order.getId());
        orderDetail.setProductid(id);
        //前端传回所要购买的数量
        int a = num;
        orderDetail.setNum(a);
        //商品价格乘以商品数量
        BigDecimal i = new BigDecimal(a);
        orderDetail.setPrice(product.getPrice().multiply(i));
        orderDetailService.save(orderDetail);

        return "cart/cart";
    }

}