package com.itheima.service.Impl;

import com.github.pagehelper.PageHelper;

import com.itheima.dao.IOrdersDao;
import com.itheima.domain.Orders;
import com.itheima.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: XXX
 * @Date: 2018/10/31 19:38
 * @Version 1.0
 */
@Service
public class OrdersServiceImpl implements IOrdersService {
    @Autowired
    private IOrdersDao dao;

    @Override
    public List<Orders> findAll(int page, int size) throws Exception {
        //参数pagenum是页码值 pageSize是每页显示条数
        PageHelper.startPage(page, size);
        return dao.findAll();
    }

    @Override
    public Orders findById(String id) throws Exception {
        return dao.findById(id);
    }
}
