package com.study.shop;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.shop.domain.*;
import com.study.shop.mapper.AdminMapper;
import com.study.shop.mapper.OrderDetailMapper;
import com.study.shop.mapper.UserMapper;
import com.study.shop.service.UserService;
import com.study.shop.service.impl.CartServiceImpl;
import com.study.shop.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private OrderDetailMapper orderDetailMapper;

	@Autowired
	private UserService UserService;

	@Autowired
	private CartServiceImpl cartService;

	@Autowired
	ProductServiceImpl productService;

	@Test
	public void testSelect() {
//		User user = UserMapper.selectById(1);
//		String password = user.getPassword();
//		System.out.println("password:"+password);
//		String string = "123456";
//		BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
//		String hashPass = bcryptPasswordEncoder.encode(string);
//		System.out.println(string+":"+hashPass);
//		boolean f = bcryptPasswordEncoder.matches("123456",password);
//		System.out.println(f);
		OrderDetail orderDetail = orderDetailMapper.selectById(1);
		System.out.println(orderDetail);

	}

	@Test
	public void testSelect2(){
		//查询所有表信息
//		List<User> list = userMapper.selectList(null);
//		for (User user: list) {
//			System.out.println(user);
//		}
		List<Cart> cartList = cartService.list(new QueryWrapper<Cart>().eq("userid", 1));

		BigDecimal maxPrice=new BigDecimal("0");

		BigDecimal maxPrice1 = null;

		System.out.println(cartList.size());

		for (int i=0 ;i<cartList.size();i++){
			System.out.println(cartList.get(i));
		}

		for (int i=0;i<cartList.size();i++){
			Cart cart = cartList.get(i);
			//查出商品购买量
			int num = cart.getNum();
			System.out.println(num);
			//查出商品价格
			int productid = cart.getProductid();
			Product product = productService.getById(productid);
			BigDecimal price = product.getPrice();
			System.out.println(price);
			//得到总价
//			System.out.println(price.multiply(new BigDecimal(num)));
//			BigDecimal multiply = price.multiply(new BigDecimal(num));
//
//
//			maxPrice=maxPrice.add(multiply);
//			System.out.println(maxPrice);

			maxPrice=maxPrice.add(price.multiply(new BigDecimal(num)));
			System.out.println(maxPrice);

		}

//		BigDecimal bignum1 = new BigDecimal("0");
//		BigDecimal bignum2 = new BigDecimal("5");
//		BigDecimal bignum3 = null;
//
//		bignum3 =  bignum1.add(bignum2);
//		System.out.println("和 是：" + bignum3);



	}
}
