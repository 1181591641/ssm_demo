package com.itheima.service;

import com.itheima.domain.Orders;

import java.util.List;

/**
 * @Author: XXX
 * @Date: 2018/10/31 19:38
 * @Version 1.0
 */

public interface IOrdersService {
    //查询所有订单
    public List<Orders> findAll(int page, int size) throws Exception;

    public Orders findById(String id) throws Exception;
}
