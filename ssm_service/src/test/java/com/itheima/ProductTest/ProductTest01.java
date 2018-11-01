package com.itheima.ProductTest;

import com.itheima.dao.IOrdersDao;
import com.itheima.dao.IUserInfoDao;
import com.itheima.domain.Orders;
import com.itheima.domain.Product;
import com.itheima.service.IProductService;
import com.itheima.service.IUserService;
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
        IUserInfoDao bean = ac.getBean(IUserInfoDao.class);
        System.out.println(bean);

    }
}
