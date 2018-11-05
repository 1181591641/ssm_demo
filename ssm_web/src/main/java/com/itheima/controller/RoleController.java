package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.dao.IUserInfoDao;
import com.itheima.domain.*;
import com.itheima.service.IRoleService;
import com.itheima.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
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

    /**
     * 查询所有用户
     *
     * @return
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "4") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Role> roleList = service.findAll(page, size);
        PageInfo pageInfo = new PageInfo(roleList);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("role-list");
        return mv;

    }

    /**
     * 根据id获取角色详情
     *
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

    /***
     * 查询未绑定的所有权限资源
     * @param id
     * @return
     * @throws Exception
     */

    @RequestMapping("/findROleAndAllRole.do")
    public ModelAndView findROleAndAllRole(String id) throws Exception {
        ModelAndView mv = new ModelAndView();
     List<Permission> permissions=  service.findROleAndAllRole(id);
        mv.addObject("role" ,id);
        mv.addObject("permission",permissions);
        mv.setViewName("role-permission-add");
        return mv;
    }

    /**
     * 根据角色id添加权限
     * @param roleid
     * @param Permission
     * @return
     * @throws Exception
     */
    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "roleId", required = true) String roleid, @RequestParam(name = "ids", required = true) String [] Permission) throws Exception {
        service.addPermissionToRole(roleid , Permission);
        return "redirect:findROleAndAllRole.do?id="+roleid;
    }

}
