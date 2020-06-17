package com.study.shop.domain;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 *     下单表
 *     `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '订单id',
 *     `amount` DECIMAL(10, 2) NOT NULL DEFAULT '0.00' COMMENT '订单总价',
 *     `status` varchar(12) NOT NULL DEFAULT '待支付' COMMENT '订单状态',
 *     `progress` TINYINT NOT NULL DEFAULT '0' COMMENT '快递进度',
 *     -- `expressno` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '快递单号',
 *     -- `tradeno` VARCHAR(100) NOT NULL DEFAULT '' COMMENT '支付交易号',
 *     `userid` int NOT NULL DEFAULT '0' COMMENT '下单人id',
 */
@Data
public class Order {

    @TableId(value = "id",type= IdType.AUTO)
    private int id;
    private BigDecimal amount;
    private String status;
    private int progress;
    private int userid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", progress=" + progress +
                ", userid=" + userid +
                '}';
    }
}
