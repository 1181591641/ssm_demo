package com.itheima.Prources;

import com.itheima.dao.IOrdersDao;
import com.itheima.dao.IProductDao;
import com.itheima.domain.Orders;
import com.itheima.domain.Product;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.*;
import java.time.format.TextStyle;
import java.util.List;

/**
 * @Author: XXX
 * @Date: 2018/10/30 19:29
 * @Version 1.0
 */
public class ProurcesTest {
    @Test
    public void testProurcesTest() throws Exception {
        ApplicationContext ac=new ClassPathXmlApplicationContext("spring/applicationContext-dao.xml");
        IOrdersDao bean = ac.getBean(IOrdersDao.class);
        List<Orders> all = bean.findAll();
        System.out.println(all.get(0).getOrderNum());
        System.out.println(all.get(0).getOrderTime());
        System.out.println(all.get(0).getOrderStatus());
    }
}
