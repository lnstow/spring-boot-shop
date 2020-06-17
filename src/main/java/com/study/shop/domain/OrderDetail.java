package com.study.shop.domain;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 *      订单详情表
 *     `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '主键id',
 *     `orderid` int NOT NULL DEFAULT '0' COMMENT '订单id',
 *     `productid` int NOT NULL DEFAULT '0' COMMENT '商品id',
 *     `num` INT NOT NULL DEFAULT '0' COMMENT '商品数量',
 *     `price` DECIMAL(10, 2) NOT NULL DEFAULT '0.00' COMMENT '商品价格',
 */
@Data
public class OrderDetail {

    @TableId(value = "id",type= IdType.AUTO)
    private int id;
    private int orderid;
    private int productid;
    private int num;
    private BigDecimal price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", orderid=" + orderid +
                ", productid=" + productid +
                ", num=" + num +
                ", price=" + price +
                '}';
    }

}
