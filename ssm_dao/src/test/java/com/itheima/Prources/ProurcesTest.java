package com.itheima.Prources;

import com.itheima.dao.*;
import com.itheima.domain.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: XXX
 * @Date: 2018/10/30 19:29
 * @Version 1.0
 */
public class ProurcesTest {
    @Test
    public void testProurcesTest() throws Exception {
        ApplicationContext ac=new ClassPathXmlApplicationContext("spring/applicationContext-dao.xml");
        IUserInfoDao bean = ac.getBean(IUserInfoDao.class);
        UserInfo byUsername = bean.findByUsername("tom");
        System.out.println(byUsername);

    }
}
