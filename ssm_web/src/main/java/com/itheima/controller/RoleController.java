package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.dao.IUserInfoDao;
import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import com.itheima.service.IRoleService;
import com.itheima.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author: XXX
 * @Date: 2018/11/3 19:14
 * @Version 1.0
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService service;
    @Autowired
    private IUserService userService;

    private static String roleid="1";
    /**
     * 查询所有用户
     *
     * @return
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "4") int size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Role> roleList = service.findAll(page, size);
        PageInfo pageInfo = new PageInfo(roleList);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("role-list");
        return mv;
       
    }

    /**
     * 根据id获取角色详情
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Role roleList = service.findById(id);
        mv.addObject("roleList", roleList);
        System.out.println(roleList);
        mv.setViewName("role-show");
        return mv;
    }

    /**
     * 添加角色
     *
     * @param role
     * @return
     * @throws Exception
     */
    @RequestMapping("/save.do")
    public String save(Role role) throws Exception {
        service.save(role);
        return "redirect:findAll.do";
    }

    /**
     * 查询所有用户用于绑定用户操作
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    @RequestMapping("/userfindAll.do")
    public ModelAndView userfindAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "4") int size,String id) throws Exception {
        roleid=id;
        System.out.println(id);
        ModelAndView mv = new ModelAndView();
        List<UserInfo> users = userService.findAll(page, size);
        PageInfo pageInfo = new PageInfo(users);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("user-list-add");
        return mv;
    }


}
