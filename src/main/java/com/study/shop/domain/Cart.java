package com.study.shop.domain;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 *     购物车表
 *    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '购物车id',
 *     `userid` int NOT NULL DEFAULT '0' COMMENT '用户id',
 *     `productid` int NOT NULL DEFAULT '0' COMMENT '商品id',
 *     `num` int NOT NULL DEFAULT '0' COMMENT '商品数量',
 */
@Data
public class Cart {

    @TableId(value = "id",type= IdType.AUTO)
    private int id;
    private int userid;
    private int productid;
    private int num;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", userid=" + userid +
                ", productid=" + productid +
                ", num=" + num +
                '}';
    }
}
