package com.study.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.shop.domain.Product;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品查询接口，实现基本的查询CRUD
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {
}
