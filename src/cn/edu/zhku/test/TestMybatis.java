package cn.edu.zhku.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.edu.zhku.pojo.User;
import cn.edu.zhku.service.UserService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring/applicationContext-*.xml"})
public class TestMybatis {
	@Resource
	private UserService userService;
	@Test
	public void testuser1() {
		@SuppressWarnings("unused")
		List<User> list = userService.queryAllUser();
	}
}
