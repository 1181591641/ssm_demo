package com.itheima.service.Impl;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.IRoleDao;
import com.itheima.domain.Permission;
import com.itheima.domain.Role;

import com.itheima.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author: XXX
 * @Date: 2018/11/3 19:32
 * @Version 1.0
 */
@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleDao dao;



    /**
     * 查询所有角色
     * @return
     * @throws Exception
     */
    @Override
    public List<Role> findAll(int page,int size) throws Exception {
        PageHelper.startPage(page, size);
        return dao.findAll();

    }

    @Override
    public Role findById(String id) throws Exception {
        return dao.findById(id);
    }

    @Override
    public void save(Role role) throws Exception {
         dao.save(role);

    }

    /**
     * 根据用户id获取没有绑定的角色
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public List<Role> findUserByIdAndAllRole(String id)throws Exception {

        return dao.findUserByIdAndAllRole(id);
    }

    @Override
    public void addRoleToUser( String userId, String[] roleIds) throws Exception {
        for (String roleId : roleIds) {
            dao.addRoleToUser(userId,roleId);
        }

    }

    @Override
    public List<Permission> findROleAndAllRole(String roleid) throws Exception {
        return   dao.findROleAndAllRole(roleid);
    }

    @Override
    public void addPermissionToRole(String roleid, String[] Permission) throws Exception {

        for (String Permissionid : Permission) {
            dao.addPermissionToRole(Permissionid,roleid);
        }
    }

}
