package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import com.itheima.service.IRoleService;
import com.itheima.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.*;

/**
 * @Author: XXX
 * @Date: 2018/11/3 10:03
 * @Version 1.0
 */
@Controller
@RequestMapping("/user")
public class UsersController {
    @Autowired
    private IUserService service;
    @Autowired
    private IRoleService roleService;

    /**
     * 查询所有用户
     *
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("/findAll.do")

    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "4") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> users = service.findAll(page, size);
        PageInfo pageInfo = new PageInfo(users);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("user-list");

        return mv;
    }

    /**
     * 添加用户信息
     *
     * @param userInfo
     * @return
     * @throws Exception
     */
    @RequestMapping("/save.do")
    public String save(UserInfo userInfo) throws Exception {
        service.save(userInfo);
        return "redirect:findAll.do";
    }

    /**
     * 查询邮箱是否重复
     *
     * @param email
     * @return
     * @throws Exception
     */
    @RequestMapping("/userEmail.do")
    @ResponseBody
    public UserInfo userEmail(String email) throws Exception {
        UserInfo userInfo = service.userEmail(email);
        return userInfo;
    }

    /**
     * 根据id显示详细用户
     *
     * @param page
     * @param size
     * @param id
     * @return
     * @throws Exception
     */

    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "4") Integer size, String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = service.findById(id);
        mv.addObject("user", userInfo);
        mv.setViewName("user-show");
        return mv;
    }

    /**
     * 根据用户id获取没有绑定的角色
     *
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Role> roleList = roleService.findUserByIdAndAllRole(id);
        mv.addObject("id", id);
        mv.addObject("roleList", roleList);

        mv.setViewName("user-role-add");
        return mv;
    }

    /***
     * 根据id绑定角色
     * @param userid
     * @param ids
     * @return
     * @throws Exception
     */
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId", required = true) String userid, @RequestParam(name = "ids", required = true) String[] ids) throws Exception {

        roleService.addRoleToUser(userid, ids);
        return "redirect:findUserByIdAndAllRole.do?id=" + userid;

    }
}

