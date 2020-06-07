package com.study.shop.controller;

import java.util.List;

import com.study.shop.domain.Product;
import com.study.shop.mapper.ProductMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    ProductMapper productMapper;

    @GetMapping(value = "/")
    public String home(Model model) {
        List<Product> producList = productMapper.selectList(null);
        for (int i = 0; i < 10; i++)
            producList.add(producList.get(i % 2));
        model.addAttribute("productList", producList);
        return "index";
    }

}