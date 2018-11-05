package com.itheima.dao;

import com.alibaba.druid.filter.AutoLoad;
import com.itheima.domain.Permission;
import com.itheima.domain.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;
import java.util.Map;

/**
 * @Author: XXX
 * @Date: 2018/11/1 19:19
 * @Version 1.0
 */
public interface IRoleDao {
    //查询所有角色
    List<Role> findAll() throws Exception;

    Role findById(String id) throws Exception;

    void save(Role role) throws Exception;

    //根据用户id获取没有绑定的角色
    List<Role> findUserByIdAndAllRole(String id) throws Exception;

    void addRoleToUser(@Param("userid") String userid, @Param("roleid") String roleid);

    List<Permission> findROleAndAllRole(String roleid) throws Exception;

    void addPermissionToRole(@Param("permissionid") String permissionid, @Param("roleid") String roleid) throws Exception;
}
