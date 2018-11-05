package com.itheima.ProductTest;

import com.itheima.dao.IOrdersDao;
import com.itheima.dao.IUserInfoDao;
import com.itheima.domain.Orders;
import com.itheima.domain.Product;
import com.itheima.service.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

/**
 * @Author: XXX
 * @Date: 2018/10/30 19:49
 * @Version 1.0
 */
public class ProductTest01 {
    @Test
    public void testProductTest01() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        IRoleService bean = ac.getBean(IRoleService.class);
        Map<String,Object> rolemap = new LinkedHashMap<String,Object>();
        rolemap.put("userid", "111-222");
        rolemap.put("roleid", "38BC647DCE5344DA8A5F3B55D447E944");


        bean.addRoleToUser(rolemap);



    }
}
