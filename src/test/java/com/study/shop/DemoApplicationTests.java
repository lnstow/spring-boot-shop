package com.study.shop;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.shop.domain.Admin;
import com.study.shop.domain.OrderDetail;
import com.study.shop.domain.User;
import com.study.shop.mapper.AdminMapper;
import com.study.shop.mapper.OrderDetailMapper;
import com.study.shop.mapper.UserMapper;
import com.study.shop.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private OrderDetailMapper orderDetailMapper;

	@Autowired
	private UserService UserService;

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
		List<User> list = userMapper.selectList(null);
		for (User user: list) {
			System.out.println(user);
		}

	}
}
