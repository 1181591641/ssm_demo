package com.itheima.service;

import com.itheima.domain.Role;

import java.util.List;

/**
 * @Author: XXX
 * @Date: 2018/11/3 19:32
 * @Version 1.0
 */
public interface IRoleService {
    //查询所有角色
    List<Role> findAll(int page, int size) throws Exception;

    Role  findById(String id) throws Exception;

    void save(Role role) throws Exception;
}
