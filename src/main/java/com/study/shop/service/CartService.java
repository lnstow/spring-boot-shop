package com.study.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.study.shop.domain.Cart;
import org.springframework.stereotype.Service;

@Service
public interface CartService extends IService<Cart> {

    public int getCartIdService(int userid,int productid);

}
