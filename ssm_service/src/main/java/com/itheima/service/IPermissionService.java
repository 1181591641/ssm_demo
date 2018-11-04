package com.itheima.service;

import com.itheima.domain.Permission;

import java.util.List;

/**
 * @Author: XXX
 * @Date: 2018/11/3 20:59
 * @Version 1.0
 */
public interface IPermissionService {

    List<Permission> findAll(int page,int size) throws Exception;

    void save(Permission permission) throws Exception;
}
