package com.xu.shiro.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name="t_user")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Integer id;
    String username;
    String password;
    Integer isDelete;
    Date createDate;
    @OneToMany(mappedBy="user",cascade=CascadeType.ALL)
    List<UserRole> userRoles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}
