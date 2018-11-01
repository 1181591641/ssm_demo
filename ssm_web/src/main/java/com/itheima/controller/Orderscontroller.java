package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Orders;
import com.itheima.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author: XXX
 * @Date: 2018/10/31 20:50
 * @Version 1.0
 */
@Controller
@RequestMapping("/orders")
public class Orderscontroller {

    @Autowired
    private IOrdersService service;

    //查询全都订单未分页
    //@RequestMapping("/findAll.do")
    //public ModelAndView findAll() throws Exception {
    //    ModelAndView mv = new ModelAndView();
    //    List<Orders> orders = dao.findAll();
    //    mv.addObject("ordersList", orders);
    //    mv.setViewName("orders-list");
    //    return mv;

    //}
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "4") int size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Orders> orders = service.findAll(page, size);
        //PageInfo就是分页bean
        PageInfo pageInfo = new PageInfo(orders);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }
    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) throws Exception
    {
        ModelAndView mv = new ModelAndView();
        Orders orders = service.findById(id);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }

}
