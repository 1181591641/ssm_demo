package com.itheima.Prources;

import com.itheima.dao.*;
import com.itheima.domain.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        IRoleDao bean = ac.getBean(IRoleDao.class);
        Role byId = bean.findById("1111");
        System.out.println(byId.toString());

    }
}
