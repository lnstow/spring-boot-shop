package com.study.shop.controller;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.study.shop.domain.Product;
import com.study.shop.domain.Profile;
import com.study.shop.service.impl.ProductServiceImpl;
import com.study.shop.service.impl.ProfileServiceImpl;
import com.study.shop.service.impl.UserServiceImpl;
import com.study.shop.utils.UserUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    ProductServiceImpl productService;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    ProfileServiceImpl profileService;

    @GetMapping(value = { "/", "/index" })
    public String home(Model model, String key) {
        List<Product> producList;
        if (key == null || key.isEmpty()) {
            producList = productService.list();
            if (producList.size() >= 2)
                for (int i = 0; i < 8; i++)
                    producList.add(producList.get(i % 2));
        } else
            producList = productService.list(new QueryWrapper<Product>().like("title", key));
        model.addAttribute("productList", producList);
        return "index";
    }

    @GetMapping(value = "/product/{id}")
    public String product(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", productService.getById(id));
        return "product/product";
    }

    @GetMapping(value = "/profile")
    public String profile(Model model) {
        int userId = UserUtils.getCurrentUser(userService).getId();
        Profile profile = profileService.getOne(new QueryWrapper<Profile>().eq("userid", userId));
        if (profile == null) {
            profile = new Profile();
            profile.setId(0);
            profile.setTruename("");
            profile.setAge(0);
            profile.setSex("男");
            profile.setTelephone("");
            profile.setAddress("");
            profile.setUserid(userId);
        }
        model.addAttribute("profile", profile);
        return "profile/profile";
    }

    @PostMapping(value = "/profile")
    public String profile(Profile profile) {
        try {
            if (profile.getId() == 0)
                profileService.save(profile);
            else
                profileService.updateById(profile);
        } catch (Exception e) {
            return "redirect:/";
        }
        return "redirect:/";
    }

}