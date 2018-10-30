package com.itheima.controller;

import com.itheima.domain.Product;
import com.itheima.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author: XXX
 * @Date: 2018/10/30 19:54
 * @Version 1.0
 */
@RequestMapping("/product")
@Controller
public class ProductController {

    @Autowired
    private IProductService service;

    @RequestMapping("/findAll")
    public String findAll(Model model) throws Exception {
        List<Product> Product = service.findAll();
        model.addAttribute("productList", Product);
        return "product-list";

    }
}
