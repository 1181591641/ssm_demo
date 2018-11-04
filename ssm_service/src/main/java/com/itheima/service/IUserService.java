package com.itheima.service;

import com.itheima.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @Author: XXX
 * @Date: 2018/11/1 18:16
 * @Version 1.0
 */
public interface IUserService extends UserDetailsService {
    //查询所有用户
    List<UserInfo> findAll(int page, int size) throws Exception;

    //添加用户信息
    void save(UserInfo userInfo) throws Exception;

    UserInfo userEmail(String email)throws Exception;

    UserInfo findById(String id) throws  Exception;
}
