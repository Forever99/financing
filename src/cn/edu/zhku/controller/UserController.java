package cn.edu.zhku.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.zhku.pojo.User;
import cn.edu.zhku.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("index")
	public String showpage() {
		return "singInAndUp";
	}

	@RequestMapping("list")
	public String queryUserList(Model model) {
		List<User> list = userService.queryAllUser();
		model.addAttribute("userlist", list);
		return "userlist";
	}

	@RequestMapping("login")
	public String login() {
		return null;
	}
	//ʵ�� ǰ�� �û�ע��ʱ �Ƿ����и��û� �����ݿ��д��� ajax���첽����
	@RequestMapping(value = "findUserAjax", method = RequestMethod.POST)
	@ResponseBody // ����json���ݸ� ǰ�� ��ǰ�˵� ajax�� �����json���� data Ҫת��Ϊ json�ַ��� ������json����
	public String findUser(@RequestBody User user) { // @RequestBody ���ܵ��� json ������ַ��� ������ json���� ��ǰ����Ҫ
														// ��JSON.stringify(data)��json�����Ǹ�ת��Ϊjson����
		String username = user.getUsername();
		User user2 = userService.queryUserByUserName(username);
		if (user2 != null && !user2.getUsername().trim().equals(""))
			return "{\"name\":\"1\"}";
		else
			return "{\"name\":\"0\"}";
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register() {
		return null;
	}

	@RequestMapping("logout")
	public String logout() {
		return null;
	}

	@RequestMapping("updatePassword")
	public String changePassword() {
		return null;
	}
}
