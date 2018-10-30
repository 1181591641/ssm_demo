package com.itheima.service;

import com.itheima.dao.IProductDao;
import com.itheima.domain.Product;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: XXX
 * @Date: 2018/10/30 18:26
 * @Version 1.0
 */
public interface IProductService {

    //查询所有的产品信息
    public List<Product> findAll() throws  Exception;
}
