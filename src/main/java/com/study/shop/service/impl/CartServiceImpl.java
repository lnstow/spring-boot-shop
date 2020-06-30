package com.study.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.shop.domain.Cart;
import com.study.shop.mapper.CartMapper;
import com.study.shop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {

    @Autowired
    CartMapper cartMapper;

    public int getCartIdService(int userid, int productid){
        int cartId = cartMapper.getCartId(userid,productid);
        return cartId;
    }

}
