package com.itheima.dao;

import com.itheima.domain.Role;

import java.util.List;

/**
 * @Author: XXX
 * @Date: 2018/11/1 19:19
 * @Version 1.0
 */
public interface IRoleDao {
    //查询所有角色
    List<Role> findAll() throws Exception;

    Role findById(String id)throws  Exception;

    void save(Role role) throws Exception;
}
