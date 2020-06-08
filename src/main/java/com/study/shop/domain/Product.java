package com.study.shop.domain;


/**
 *      商品表
 *     `id` int NOT NULL AUTO_INCREMENT COMMENT '商品id',
 *     `title` VARCHAR(100) NOT NULL DEFAULT '' COMMENT '商品名',
 *     `cover` VARCHAR(200) NOT NULL DEFAULT '' COMMENT '封面图',
 *     `num` int NOT NULL DEFAULT '0' COMMENT '库存',
 *     `price` DECIMAL(10, 2) NOT NULL DEFAULT '0.00' COMMENT '价格',
 */

public class Product {


    private int id;
    private String title;
    private String cover;
    private int num;
    private double price;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cover='" + cover + '\'' +
                ", num=" + num +
                ", price=" + price +
                '}';
    }
}
