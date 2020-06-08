package com.study.shop.domain;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 *      用户信息表
 *     `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
 *     `username` VARCHAR(20) NOT NULL DEFAULT '' COMMENT '用户名',
 *     `password` VARCHAR(20) NOT NULL DEFAULT '' COMMENT '用户密码',
 *     `email` VARCHAR(30) NOT NULL DEFAULT '' COMMENT '用户邮箱',
 *     `authority` varchar(20) NOT NULL DEFAULT 'ROLE_user' COMMENT '权限',
 */

public class User {

    @TableId(value = "id",type= IdType.AUTO)
    private int id;
    private String username;
    private String password;
    private String email;
    private String authority;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", authority='" + authority + '\'' +
                '}';
    }
}
