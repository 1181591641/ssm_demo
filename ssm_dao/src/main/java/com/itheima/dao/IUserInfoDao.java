package com.itheima.dao;


import com.itheima.domain.UserInfo;

/**
 * @Author: XXX
 * @Date: 2018/11/1 18:25
 * @Version 1.0
 */
public interface IUserInfoDao {
   UserInfo findByUsername(String username)throws Exception;
}
