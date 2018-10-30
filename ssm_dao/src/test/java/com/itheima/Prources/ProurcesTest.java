package com.itheima.Prources;

import com.itheima.dao.IProductDao;
import com.itheima.domain.Product;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        IProductDao bean = ac.getBean(IProductDao.class);
        List<Product> all = bean.findAll();
        all.forEach(System.out::println);
    }
}
