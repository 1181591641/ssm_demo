package com.itheima.controller;


import com.github.pagehelper.PageInfo;
import com.itheima.domain.Product;
import com.itheima.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
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
    //只有ROLE_ADMIN权限的用户才允许访问
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "4") Integer size) throws Exception {
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
    //authentication.principal.userId：获取当前正在操作的用户
    //当前操作的用户为tom允许访问
    @PreAuthorize("authentication.principal.username=='tom'")
    public String save(Product product)throws  Exception {

            service.save(product);

        return "redirect:findAll.do";

    }
}
