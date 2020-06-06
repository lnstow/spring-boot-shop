package com.study.shop;

import com.study.shop.domain.Admin;
import com.study.shop.domain.User;
import com.study.shop.mapper.AdminMapper;
import com.study.shop.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private AdminMapper adminMapper;

	@Test
	public void testSelect() {
		Admin admin = adminMapper.selectById(1);
		System.out.println(admin);
	}
}
