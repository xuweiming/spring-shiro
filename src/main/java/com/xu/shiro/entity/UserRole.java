package com.xu.shiro.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_user_role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", unique = true)
    User user;
    @ManyToOne
    @JoinColumn(name = "roleId", unique = true)
    Role role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
