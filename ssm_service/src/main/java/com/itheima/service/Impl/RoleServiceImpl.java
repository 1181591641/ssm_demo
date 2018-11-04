package com.itheima.service.Impl;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.IRoleDao;
import com.itheima.domain.Role;

import com.itheima.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
