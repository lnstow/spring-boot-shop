package com.study.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.shop.domain.Cart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CartMapper extends BaseMapper<Cart> {

    //根据用户id和商品id查询出购物车id
    @Select("SELECT id FROM cart WHERE userid=#{userid} and productid=#{productid}")
    public int getCartId(int userid, int productid);

    //根据当前购车id删除当前列


}
