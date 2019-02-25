package com.xu.shiro.service;

import com.xu.shiro.dao.BaseDao;
import com.xu.shiro.entity.Permission;
import com.xu.shiro.entity.Role;
import com.xu.shiro.entity.User;
import com.xu.shiro.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    private BaseDao dao;

    /****
     * 通过用户名获取用户对象
     *
     * @param username
     * @return
     */
    public User getUserByUserName(String username) {
        User user = (User) dao.findObjectByHQL("from User where username=?", new Object[]{username});
        return user;
    }

    /***
     * 通过用户名获取权限资源
     *
     * @param username
     * @return
     */
    public List<String> getPermissionsByUserName(String username) {
        System.out.println("调用");
        User user = getUserByUserName(username);
        if (user == null) {
            return null;
        }
        List<String> list = new ArrayList<String>();
        for (UserRole userRole : user.getUserRoles()) {
            Role role = userRole.getRole();
            List<Permission> permissions = dao.findAllByHQL("FROM Permission WHERE roleId = ?", new Object[]{role.getId()});
            for (Permission p : permissions) {
                list.add(p.getUrl());
            }
        }
        return list;
    }
}
