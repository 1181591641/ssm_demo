package com.itheima.service;

import com.itheima.domain.Permission;
import com.itheima.domain.Role;

import java.util.List;
import java.util.Map;

/**
 * @Author: XXX
 * @Date: 2018/11/3 19:32
 * @Version 1.0
 */
public interface IRoleService {
    //查询所有角色
    List<Role> findAll(int page, int size) throws Exception;

    Role findById(String id) throws Exception;

    void save(Role role) throws Exception;

    //根据用户id获取没有绑定的角色
    List<Role> findUserByIdAndAllRole(String id)throws Exception;

    void addRoleToUser(String userId, String[] roleIds)throws Exception;

    List<Permission> findROleAndAllRole(String roleid) throws Exception;

    void addPermissionToRole(String roleid,String [] Permission) throws Exception;

}
