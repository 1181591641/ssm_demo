package com.itheima.dao;

import com.itheima.domain.UserInfo;

import java.util.List;

/**
 * @Author: XXX
 * @Date: 2018/11/1 18:25
 * @Version 1.0
 */
public interface IUserInfoDao {
    //根据姓名查询用户
    UserInfo findByUsername(String username) throws Exception;

    //查询所有用户
    List<UserInfo> findAll() throws Exception;

    //添加用户信息
    void save(UserInfo userInfo) throws Exception;

    //查询重复邮箱
    UserInfo userEmail(String email) throws Exception;

    //显示详细用户
    UserInfo findById(String id) throws Exception;
}
