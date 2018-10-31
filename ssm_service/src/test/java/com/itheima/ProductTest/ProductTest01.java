package com.itheima.ProductTest;

import com.itheima.dao.IOrdersDao;
import com.itheima.domain.Orders;
import com.itheima.domain.Product;
import com.itheima.service.IProductService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Author: XXX
 * @Date: 2018/10/30 19:49
 * @Version 1.0
 */
public class ProductTest01 {
    @Test
    public void testProductTest01() throws Exception {
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        IOrdersDao bean = ac.getBean(IOrdersDao.class);
        List<Orders> all = bean.findAll();
        all.forEach(System.out::println);
    }
}
