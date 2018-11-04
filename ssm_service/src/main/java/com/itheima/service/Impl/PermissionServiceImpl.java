package com.itheima.service.Impl;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.IPermissionDao;
import com.itheima.domain.Permission;
import com.itheima.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

/**
 * @Author: XXX
 * @Date: 2018/11/3 21:00
 * @Version 1.0
 */
@Service
public class PermissionServiceImpl implements IPermissionService {
    @Autowired
    private IPermissionDao dao;
    @Override
    public List<Permission> findAll(int page,int size) throws Exception {
        PageHelper.startPage(page,size);
        return dao.findAll();

    }

    @Override
    public void save(Permission permission) throws Exception {
        dao.save(permission);
    }
}
