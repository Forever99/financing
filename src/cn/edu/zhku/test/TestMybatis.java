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
	@Test
	public void test2() {
		User user = new User();
		user.setUsername("wowo");
		user.setPassword("123123");
		User user2 = userService.singin(user);
		System.out.println(user2.getEmail());
	}
	@Test
	public void test3() {
		User user = new User();
		user.setId(1);
		
		user.setUsername("wowo");
		int num = userService.updateUserName(user);
		System.out.println(num);
	}
	@Test
	public void test4() {
		User user = new User();
		user.setId(1);
		user.setPassword("123123");
		
		int num = userService.updateUserPassword(user);
		System.out.println(num);
	}
	@Test
	public void test5() {
		String password = "222111";
		//以下 输入 2 说明 返回的值就是 被影响的 行数！!
		/*System.out.println(userService.updateTestreturn(password));*/
	}
}
