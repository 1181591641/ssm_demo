package com.itheima.controller;

import com.itheima.dao.ISysLogDao;
import com.itheima.domain.SysLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @Author: XXX
 * @Date: 2018/11/5 10:24
 * @Version 1.0
 */
@Component
@Aspect
public class LogAop {
    @Autowired
    private HttpServletRequest request;//获取request对象

    private Date visitTime;//开始时间
    private Class clazz;//访问的类
    private Method method;//访问的方法

    @Autowired
    private ISysLogDao service;

    /**
     * 前置通知
     * 获取开始时间，执行的类是那一个，执行的是哪一个方法
     *
     * @param jp
     */
    @Before("execution(* com.itheima.controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
        visitTime = new Date();//当前时间就是开始访问的时间
        clazz = jp.getTarget().getClass();//具体访问的类对象
        String methodName = jp.getSignature().getName();//获取访问的方法的名称
        Object[] args = jp.getArgs();
        //获取具体执行的方法的Method对象
        if (args == null || args.length == 0) {
            method = clazz.getMethod(methodName);//只能获取无参的方法
        } else {

            Class[] classArgs = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classArgs[i] = args[i].getClass();
            }
            method=  clazz.getMethod(methodName, classArgs);
        }

    }

    /**
     * 后置通知
     *
     * @param jp
     */
    @After("execution(* com.itheima.controller.*.*(..))")
    public void doAfter(JoinPoint jp) throws Exception {
        long time = new Date().getTime() - visitTime.getTime();//获取访问时长
        String url = "";
        //获取url
        if (clazz != null && method != null && clazz != LogAop.class) {
            //1.获取类上的RequestMapping的值
            RequestMapping clazzAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if (clazzAnnotation != null) {
                //获取类上的RequestMapping的value值
                String[] classValue = clazzAnnotation.value();
                //获取方法上的RequestMapping的值
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null) {
                    //获取方法上的RequestMapping值
                    String[] MethodValue = methodAnnotation.value();
                    url = classValue[0] + MethodValue[0];
                }
            }


            //获取访问的ip地址
            String ip = request.getRemoteAddr();//获取访问的ip地址
            //获取当前操作用户
            SecurityContext context = SecurityContextHolder.getContext();//从上下文中获取当前登陆对象
            User principal = (User) context.getAuthentication().getPrincipal();//获取当前对象
            String username = principal.getUsername();//获取当前用户名
            //将相关对象封装到SysLog对象
            SysLog sysLog = new SysLog();
            sysLog.setExecutionTime(time);//执行时长
            sysLog.setIp(ip);//ip地址
            sysLog.setUsername(username);//获取用户名
            sysLog.setUrl(url);//获取访问路径
            sysLog.setMethod("[类名] " + clazz.getName() + "[方法名] " + method.getName());
            sysLog.setVisitTime(visitTime);//访问时间
            //调用Service完成操作
            service.save(sysLog);
        }


    }
}
