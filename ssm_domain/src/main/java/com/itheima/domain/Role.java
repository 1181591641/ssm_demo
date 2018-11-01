package com.itheima.domain;

import org.springframework.security.core.userdetails.User;

import java.util.List;

/**
 * 角色
 * @Author: XXX
 * @Date: 2018/11/1 18:26
 * @Version 1.0
 */
public class Role {
    private String id;//id
    private String roleName;//角色名
    private String roleDesc;//角色描述
    private List<Permission> permissions;
    private List<UserInfo> users;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<UserInfo> getUsers() {
        return users;
    }

    public void setUsers(List<UserInfo> users) {
        this.users = users;
    }
}
