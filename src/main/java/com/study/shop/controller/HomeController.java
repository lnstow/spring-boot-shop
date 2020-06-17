package com.study.shop.controller;

import java.util.List;

import com.study.shop.domain.Product;
import com.study.shop.service.impl.ProductServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @Autowired
    ProductServiceImpl productService;

    @GetMapping(value = { "/", "/index" })
    public String home(Model model) {
        List<Product> producList = productService.list();
        if (producList.size() >= 2)
            for (int i = 0; i < 10; i++)
                producList.add(producList.get(i % 2));
        model.addAttribute("productList", producList);
        return "index";
    }

    @GetMapping(value = "/product/{id}")
    public String product(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", productService.getById(id));
        return "product/product";
    }

}