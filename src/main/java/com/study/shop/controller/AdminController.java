package com.study.shop.controller;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.study.shop.domain.Product;
import com.study.shop.domain.User;
import com.study.shop.service.impl.ProductServiceImpl;
import com.study.shop.service.impl.UserServiceImpl;
import com.study.shop.utils.UserUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    UserServiceImpl userService;

    @Autowired
    ProductServiceImpl productService;

    // user
    @GetMapping(value = "/user")
    public String showUser(Model model) {
        QueryWrapper<User> wrapper3 = new QueryWrapper<>();
        wrapper3.eq("authority", "ROLE_user").or().eq("authority", "ROLE_vip");
        model.addAttribute("userList", userService.list(wrapper3));
        return "admin/user";
    }

    @GetMapping(value = "/user/add")
    public String addUser() {
        return "admin/addUser";
    }

    @PostMapping(value = "/user/add")
    public String addUser(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        try {
            userService.save(user);
        } catch (Exception e) {
            return "redirect:/admin/user";
        }
        return "redirect:/admin/user";
    }

    @GetMapping(value = "/user/del/{id}")
    public String delUser(@PathVariable("id") int id) {
        userService.removeById(id);
        return "redirect:/admin/user";
    }

    @GetMapping(value = "/user/upd/{id}")
    public String updUser(@PathVariable("id") int id) {
        User user = userService.getById(id);
        user.setAuthority("ROLE_vip");
        userService.updateById(user);
        return "redirect:/admin/user";
    }

    // product
    @GetMapping(value = "/product")
    public String showProduct(Model model) {
        model.addAttribute("productList", productService.list());
        return "admin/product";
    }

    @GetMapping(value = "/product/add")
    public String addProduct() {
        return "admin/addProduct";
    }

    @PostMapping(value = "/product/add")
    public String addProduct(Product product) {
        product.setId(0);
        try {
            productService.save(product);
        } catch (Exception e) {
            return "redirect:/admin/product";
        }
        return "redirect:/admin/product";
    }

    @GetMapping(value = "/product/del/{id}")
    public String delProduct(@PathVariable("id") int id) {
        productService.removeById(id);
        return "redirect:/admin/product";
    }

    @GetMapping(value = "/product/upd/{id}")
    public String updProduct(@PathVariable("id") int id, Model model) {
        Product product = productService.getById(id);
        model.addAttribute("product", product);
        return "admin/updProduct";
    }

    @PostMapping(value = "/product/upd")
    public String updProduct(Product product) {
        productService.updateById(product);
        return "redirect:/admin/product";
    }

}