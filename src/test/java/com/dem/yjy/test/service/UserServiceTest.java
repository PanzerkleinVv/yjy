package com.dem.yjy.test.service;

import java.util.Date;
import javax.annotation.Resource;

import com.dem.yjy.core.feature.test.TestSupport;
import com.dem.yjy.core.util.ApplicationUtils;
import org.junit.Test;

import com.dem.yjy.web.model.User;
import com.dem.yjy.web.service.UserService;

public class UserServiceTest extends TestSupport {

	@Resource
	private UserService userService;

	@Test
	public void test_insert() {
		User model = new User();
		model.setId(2L);
		model.setUsername("starzou");
		model.setPassword(ApplicationUtils.sha256Hex("123456"));
		model.setCreateTime(new Date());
		userService.insert(model);
	}

	@Test
	public void test_10insert() {
		for (int i = 0; i < 10; i++) {
			User model = new User();
			model.setUsername("starzou" + i);
			model.setPassword(ApplicationUtils.sha256Hex("123456"));
			model.setCreateTime(new Date());
			userService.insert(model);
		}
	}

}
