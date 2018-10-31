package com.itheima.controller;

import com.alibaba.druid.stat.TableStat;
import com.itheima.domain.Product;
import com.itheima.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author: XXX
 * @Date: 2018/10/30 19:54
 * @Version 1.0
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService service;

    /**
     * 查询所有的产品信息
     *
     * @return mv
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> Product = service.findAll();
        mv.addObject("productList", Product);
        mv.setViewName("product-list");
        return mv;

    }

    /**
     * 产品添加
     *
     * @param product
     * @return
     */
    @RequestMapping("/save.do")
    public String save(Product product)throws  Exception {

            service.save(product);

        return "redirect:findAll.do";

    }
}
