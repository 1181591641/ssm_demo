package com.itheima.controller;

import com.alibaba.druid.stat.TableStat;
import com.github.pagehelper.PageInfo;
import com.itheima.domain.Product;
import com.itheima.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "4") int size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> Product = service.findAll(page,size);
        PageInfo pageInfo = new PageInfo(Product);
        mv.addObject("pageInfo", pageInfo);
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
