CREATE DATABASE IF NOT EXISTS `shop` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `shop`;
DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
    `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `username` varchar(20) NOT NULL DEFAULT '' COMMENT '管理员账号',
    `password` varchar(20) NOT NULL DEFAULT '' COMMENT '管理员密码',
    `email` varchar(30) NOT NULL DEFAULT '' COMMENT '管理员邮箱',
    `authority` varchar(20) NOT NULL DEFAULT 'ROLE_admin' COMMENT '权限',
    PRIMARY KEY (`id`),
    UNIQUE shop_admin_username_password(`username`, `password`),
    UNIQUE shop_admin_username_email(`username`, `email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT '管理员表';

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
    `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `username` VARCHAR(20) NOT NULL DEFAULT '' COMMENT '用户名',
    `password` VARCHAR(20) NOT NULL DEFAULT '' COMMENT '用户密码',
    `email` VARCHAR(30) NOT NULL DEFAULT '' COMMENT '用户邮箱',
    `authority` varchar(20) NOT NULL DEFAULT 'ROLE_user' COMMENT '权限',
    PRIMARY KEY (`id`),
    UNIQUE shop_user_username_password(`username`, `password`),
    UNIQUE shop_user_username_email(`username`, `email`)
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


insert into `product`(`title`,`cover`,`num`,`price`) values ('西瓜','https://5b0988e595225.cdn.sohucs.com/q_70,c_zoom,w_640/images/20180524/95e445560f9c4f5494aa0a304635ffce.jpeg','100','20.0'),('苹果','https://m.360buyimg.com/mobilecms/s750x750_jfs/t2086/31/684730686/113101/a62d7df2/561f5164N5d57d1fd.jpg!q80.dpg','50','10.0');