package com.itheima.dao;

import com.itheima.domain.Product;

import java.util.List;

/**
 * @Author: XXX
 * @Date: 2018/10/30 18:22
 * @Version 1.0
 */
public interface IProductDao {
    //查询所有的产品信息
    public List<Product> findAll() throws  Exception;
   //添加商品
    void save(Product product)throws  Exception;
}
