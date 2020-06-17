package com.study.shop.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.study.shop.domain.Cart;
import com.study.shop.domain.User;
import com.study.shop.service.impl.CartServiceImpl;
import com.study.shop.service.impl.UserServiceImpl;
import com.study.shop.utils.UserUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    CartServiceImpl cartService;

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

}