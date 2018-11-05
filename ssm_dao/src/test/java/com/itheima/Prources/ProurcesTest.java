package com.itheima.Prources;

import com.itheima.dao.*;
import com.itheima.domain.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

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
        Map<String,Object> rolemap = new LinkedHashMap<String,Object>();
        rolemap.put("userid", "111-222");
        rolemap.put("roleid", "EFEBA0395EB749449958A4C58EA06A70");


        bean.addRoleToUser(rolemap);



    }
}
