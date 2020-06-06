package com.study.shop.domain;

/**
 *      管理员信息表
 *     `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
 *     `username` varchar(20) NOT NULL DEFAULT '' COMMENT '管理员账号',
 *     `password` varchar(20) NOT NULL DEFAULT '' COMMENT '管理员密码',
 *     `email` varchar(30) NOT NULL DEFAULT '' COMMENT '管理员邮箱',
 *     `authority` varchar(20) NOT NULL DEFAULT 'ROLE_admin' COMMENT '权限',
 */

public class Admin {

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
        return "Admin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", authority='" + authority + '\'' +
                '}';
    }
}
