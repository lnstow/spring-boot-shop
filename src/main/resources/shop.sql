-- https://www.cnblogs.com/maoriaty/p/9330642.html
CREATE DATABASE IF NOT EXISTS `shop` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `shop`;
DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
    `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `username` varchar(20) NOT NULL DEFAULT '' COMMENT '管理员账号',
    `password` varchar(150) NOT NULL DEFAULT '' COMMENT '管理员密码',
    `email` varchar(30) NOT NULL DEFAULT '' COMMENT '管理员邮箱',
    `authority` varchar(20) NOT NULL DEFAULT 'ROLE_admin' COMMENT '权限',
    PRIMARY KEY (`id`),
    UNIQUE admin_username(`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT '管理员表';

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
    `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `username` VARCHAR(20) NOT NULL DEFAULT '' COMMENT '用户名',
    `password` VARCHAR(150) NOT NULL DEFAULT '' COMMENT '用户密码',
    `email` VARCHAR(30) NOT NULL DEFAULT '' COMMENT '用户邮箱',
    `authority` varchar(20) NOT NULL DEFAULT 'ROLE_user' COMMENT '权限',
    PRIMARY KEY (`id`),
    UNIQUE user_username(`username`),
    check (`authority` in ('ROLE_user','ROLE_vip','ROLE_admin','ROLE_root'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT '会员表';

DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
    `id` int NOT NULL AUTO_INCREMENT COMMENT '商品id',
    `title` VARCHAR(100) NOT NULL DEFAULT '' COMMENT '商品名',
    `cover` VARCHAR(200) NOT NULL DEFAULT '' COMMENT '封面图',
    `num` int NOT NULL DEFAULT '0' COMMENT '库存',
    `price` DECIMAL(10, 2) NOT NULL DEFAULT '0.00' COMMENT '价格',
    -- `description` TEXT COMMENT '商品描述',
    -- `pics` TEXT COMMENT '图片集合',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT '商品表';

insert into `product` values ('0','西瓜','https://i.loli.net/2020/07/01/qcDNhu95O6d2Qt7.jpg','100','20.0');
insert into `product` values ('0','苹果','https://i.loli.net/2020/07/01/NU9w8WODaGuSlx3.jpg','50','10.0');
insert into `product` values ('0','香蕉','https://i.loli.net/2020/07/01/MXH4Qjm2hRLS5JD.jpg','100','10.5');
insert into `product` values ('0','樱桃','https://i.loli.net/2020/07/01/Bc6yWI7w9ZGVOJU.jpg','100','12.5');
insert into `product` values ('0','葡萄','https://i.loli.net/2020/07/01/DBUwJMGLCvmjfoP.jpg','100','14.5');
insert into `product` values ('0','芒果','https://i.loli.net/2020/07/01/9l5t6inQ2EfWVw3.jpg','100','16.5');
insert into `product` values ('0','橘子','https://i.loli.net/2020/07/01/qANyIwKB3bRaFg5.jpg','100','18.5');
insert into `product` values ('0','梨子','https://i.loli.net/2020/07/01/JNo97Y53R4bXWjA.png','100','20.5');
insert into `product` values ('0','菠萝','https://i.loli.net/2020/07/01/eOoHrRN5tSUp149.jpg','100','22.5');
insert into `product` values ('0','草莓','https://i.loli.net/2020/07/01/QjBLGixdn6NCthF.jpg','100','24.5');

insert into `user`(`id`,`username`,`password`) values ('0','test','$2a$10$qI5XS7bi7zbo136ZlalUtudkRKINrMuxTdHQcjC/tpeQOeBbMhUW.');
insert into `user`(`id`,`username`,`password`) values ('0','123','$2a$10$fXiwYxE68GXWX.N0tCXr.uCa7/9IKldS33f/dANURSJWlsQrTG5iq');
insert into `user`(`id`,`username`,`password`,`authority`) values ('0','vip','$2a$10$lk1JXLJ9fWYfg9flEaVqOOPHYjlu54prHgcc0WFCG3LkWUBiVowEm','ROLE_vip');
insert into `user`(`id`,`username`,`password`,`authority`) values ('0','admin','$2a$10$lwlU45EDqdZQgJrfFslRQe6tAN599BBGG0n.zX.GoGAeb0P06AyNi','ROLE_admin');
insert into `user`(`id`,`username`,`password`,`authority`) values ('0','root','$2a$10$oFa0wC9iBYfdIl1A9cIoROAycZ8HiFK2XZRNMG6S6ctzn9oGB3UQK','ROLE_root');

DROP TABLE IF EXISTS `profile`;
CREATE TABLE IF NOT EXISTS `profile` (
    `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `truename` VARCHAR(30) NOT NULL DEFAULT '' COMMENT '真实姓名',
    `age` TINYINT NOT NULL DEFAULT '0' COMMENT '年龄',
    `sex` varchar(4) NOT NULL DEFAULT '男' COMMENT '性别',
    `telephone` VARCHAR(30) NOT NULL DEFAULT '' COMMENT '电话',
    `address` TEXT COMMENT '详细地址',
    `userid` int NOT NULL DEFAULT '0' COMMENT '用户id',
    PRIMARY KEY (`id`),
    UNIQUE profile_userid(`userid`),
    check (`sex` in ('男','女')) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT '会员详细信息表';

DROP TABLE IF EXISTS `order`;
CREATE TABLE IF NOT EXISTS `order` (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '订单id',
    `amount` DECIMAL(10, 2) NOT NULL DEFAULT '0.00' COMMENT '订单总价',
    `status` varchar(12) NOT NULL DEFAULT '待支付' COMMENT '订单状态',
    `progress` TINYINT NOT NULL DEFAULT '0' COMMENT '快递进度',
    -- `expressno` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '快递单号',
    -- `tradeno` VARCHAR(100) NOT NULL DEFAULT '' COMMENT '支付交易号',
    `userid` int NOT NULL DEFAULT '0' COMMENT '下单人id',
    KEY order_userid(`userid`),
    check (`status` in ('已完成','已取消','待支付','待收货'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT '订单表';

DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE IF NOT EXISTS `order_detail`(
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '主键id',
    `orderid` int NOT NULL DEFAULT '0' COMMENT '订单id',
    `productid` int NOT NULL DEFAULT '0' COMMENT '商品id',
    `num` INT NOT NULL DEFAULT '0' COMMENT '商品数量',
    `price` DECIMAL(10, 2) NOT NULL DEFAULT '0.00' COMMENT '商品价格',
    KEY order_detail_orderid(`orderid`),
    KEY order_detail_productid(`productid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT '订单详情表';

DROP TABLE IF EXISTS `cart`;
CREATE TABLE IF NOT EXISTS `cart` (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '购物车id',
    `userid` int NOT NULL DEFAULT '0' COMMENT '用户id',
    `productid` int NOT NULL DEFAULT '0' COMMENT '商品id',
    `num` int NOT NULL DEFAULT '0' COMMENT '商品数量',
    KEY cart_userid(`userid`),
    KEY cart_productid(`productid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT '购物车表'

