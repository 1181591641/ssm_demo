package com.itheima.dao;

import com.itheima.domain.Orders;

import java.util.List;

/**
 * @Author: XXX
 * @Date: 2018/10/31 19:38
 * @Version 1.0
 */
public interface IOrdersDao {

    //查询所有订单
    public List<Orders> findAll() throws Exception;
}
