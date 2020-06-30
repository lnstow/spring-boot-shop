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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;


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
        User user = UserUtils.getCurrentUser(userService);
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

        return "redirect:/cart";
    }

    //从购物车下单    ps：只能选一种物品下单
    @GetMapping(value = "/buy/{id}{num}")
    public String buyCart(@PathVariable("id") int id, @PathVariable("num") int num, Model model){

        // 将商品库存减去用户所购买的数量
        Product product = productService.getById(id);
        int num1 = product.getNum() - num;
        product.setNum(num1);
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
        //前端传回所要购买的数量
        int a = num;
        orderDetail.setNum(a);
        //商品价格乘以商品数量
        BigDecimal i = new BigDecimal(a);
        orderDetail.setPrice(product.getPrice().multiply(i));
        orderDetailService.save(orderDetail);

        return "redirect:/cart";
    }

    //全部购买
    @PostMapping(value = "/buyAll")
    public String buyAll() {

        //获取当前用户id
        int UserId = UserUtils.getCurrentUser(userService).getId();
        List<Cart> cartList = cartService.list(new QueryWrapper<Cart>().eq("userid", UserId));
        //得到有几条商品
        int size = cartList.size();
        //全部商品总价
        BigDecimal maxPrice=new BigDecimal("0");

        //获得全部商品总价
        for (int i=0;i<size;i++){
            Cart cart = cartList.get(i);
            //查出商品购买量
            int num = cart.getNum();
            //查出商品价格
            int productid = cart.getProductid();
            Product product = productService.getById(productid);
            BigDecimal price = product.getPrice();
            //得到总价
            maxPrice.add(price.multiply(new BigDecimal(num)));
        }


        // 生成订单
        Order order = new Order();
        order.setAmount(maxPrice);
        order.setUserid(UserUtils.getCurrentUser(userService).getId());
        orderService.addOne(order);

        for (int i=0;i<size;i++){

            Cart cart = cartList.get(i);
            int productid = cart.getProductid();
            int num = cart.getNum();

            // 将商品库存减去用户所购买的数量
            Product product = productService.getById(productid);
            int num1 = product.getNum() - num;
            product.setNum(num1);
            productService.updateById(product);

            // 添加商品详情表
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderid(order.getId());
            orderDetail.setProductid(product.getId());

            //所要购买的数量
            int a = num;
            orderDetail.setNum(a);
            //商品价格乘以商品数量
            BigDecimal decimal = new BigDecimal(a);
            orderDetail.setPrice(product.getPrice().multiply(decimal));
            orderDetailService.save(orderDetail);

        }

        return "redirect:/cart";
    }

    @GetMapping(value="")
    public String cart(Model model) {
        QueryWrapper<Cart> wrapper3 = new QueryWrapper<>();
        wrapper3.eq("userid", UserUtils.getCurrentUser(userService).getId());
        model.addAttribute("cartList", cartService.list(wrapper3));
        return "cart/cart";
    }

    //购物车列表的单个商品减一
    @GetMapping(value = "/sub/{id}")
    public String lessCart(@PathVariable("id") int id, Model model) {

        //获取当前用户id
        int UserId = UserUtils.getCurrentUser(userService).getId();
        //查询出当前用户需要减一商品的购物车id
        Cart cart = cartService.getOne(new QueryWrapper<Cart>().eq("userid",UserId).eq("productid",id));
        //购物车当前商品购买量减一
        cart.setNum(cart.getNum()-1);
        //更新当前商品列
        cartService.updateById(cart);

        return "redirect:/cart";
    }

    //从购物车删除当前用户所选中的商品
    @GetMapping(value = "/del/{id}")
    public String deleteCart(@PathVariable("id") int id, Model model){

        //获取当前用户id
        int UserId = UserUtils.getCurrentUser(userService).getId();
        //查询出当前用户需要删除商品的购物车id
        Cart cart = cartService.getOne(new QueryWrapper<Cart>().eq("userid",UserId).eq("productid",id));
        int cartId =cart.getId();
        //购物车将当前商品删除
        cartService.removeById(cartId);

        return "redirect:/cart";
    }


}