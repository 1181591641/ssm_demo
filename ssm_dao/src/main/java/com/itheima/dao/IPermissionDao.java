package com.itheima.dao;

import com.itheima.domain.Permission;

import java.util.List;

/**
 * @Author: XXX
 * @Date: 2018/11/3 18:50
 * @Version 1.0
 */
public interface IPermissionDao {
    List<Permission> findAll() throws Exception;

    void save(Permission permission) throws Exception;
}
