package com.study.shop.domain;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 *      商品表
 *     `id` int NOT NULL AUTO_INCREMENT COMMENT '商品id',
 *     `title` VARCHAR(100) NOT NULL DEFAULT '' COMMENT '商品名',
 *     `cover` VARCHAR(200) NOT NULL DEFAULT '' COMMENT '封面图',
 *     `num` int NOT NULL DEFAULT '0' COMMENT '库存',
 *     `price` DECIMAL(10, 2) NOT NULL DEFAULT '0.00' COMMENT '价格',
 */
@Data
public class Product {

    @TableId(value = "id",type= IdType.AUTO)
    private int id;
    private String title;
    private String cover;
    private int num;
    private BigDecimal price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
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
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cover='" + cover + '\'' +
                ", num=" + num +
                ", price=" + price +
                '}';
    }
}
