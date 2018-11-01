package com.itheima.service.Impl;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.IProductDao;
import com.itheima.domain.Product;
import com.itheima.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: XXX
 * @Date: 2018/10/30 18:27
 * @Version 1.0
 */
@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductDao dao;

    @Override
    public void save(Product product)throws  Exception {
        dao.save(product);
    }

    @Override
    public List<Product> findAll(int page,int size) throws Exception {
        PageHelper.startPage(page,size);
        return dao.findAll();
    }
}
