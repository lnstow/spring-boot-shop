package com.study.shop.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 *      会员详情信息表
 *     `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
 *     `truename` VARCHAR(30) NOT NULL DEFAULT '' COMMENT '真实姓名',
 *     `age` TINYINT NOT NULL DEFAULT '0' COMMENT '年龄',
 *     `sex` varchar(4) NOT NULL DEFAULT '男' COMMENT '性别',
 *     `telephone` VARCHAR(30) NOT NULL DEFAULT '' COMMENT '电话',
 *     `address` TEXT COMMENT '详细地址',
 *     `userid` int NOT NULL DEFAULT '0' COMMENT '用户id',
 */
@Data
public class Profile {

    @TableId(value = "id",type= IdType.AUTO)
    private int id;
    private String truename;
    private int age;
    private String sex;
    private String telephone;
    private String address;
    private int userid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", truename='" + truename + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                ", userid=" + userid +
                '}';
    }
}
