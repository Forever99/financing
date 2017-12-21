package cn.edu.zhku.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

	@RequestMapping("firstfont")
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
	public String login(User user,HttpServletRequest request) {
		User user1 = userService.singin(user);
		HttpSession session = request.getSession();
		if(user1!=null) {
			session.setAttribute("username", user1.getUsername());
			return "index";
		}
		String msg = "登录失败，4秒后跳转到登录注册页面 <meta http-equiv=\"refresh\" content=\"4;url=/financing/user/firstfont.action\"></meta>";
		request.setAttribute("msg", msg);
		return "error";
	}
	//实现 前端 用户注册时 是否已有该用户 在数据库中存在 ajax的异步操作
	@RequestMapping(value = "findUserAjax", method = RequestMethod.POST)
	@ResponseBody // 返回json数据给 前端 在前端的 ajax中 请求的json数据 data 要转换为 json字符串 而不是json对象
	public String findUser(@RequestBody User user) { // @RequestBody 接受的是 json 对象的字符串 而不是 json对象 在前端需要
														// 用JSON.stringify(data)将json对象那个转换为json数据
		String username = user.getUsername();
		User user2 = userService.queryUserByUserName(username);
		if (user2 != null && !user2.getUsername().trim().equals(""))
			return "{\"name\":\"1\"}";
		else
			return "{\"name\":\"0\"}";
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(User user,HttpServletRequest request) {
		//虽然前台 用ajax 防止了 用户重复注册 但是 后台还是要防止
		String username = user.getUsername();
		User user2 = userService.queryUserByUserName(username);
		HttpSession session = request.getSession();
		if (user2 != null && !user2.getUsername().trim().equals("")) {
			return "error";
		}else {
			userService.addUser(user);
			int num = user.getId();
			if(num!=0) {
				session.setAttribute("username", user.getUsername());
				return "index";
			}
		}
		String msg = "该用户已存在，4秒后跳转到登录注册页面 <meta http-equiv=\"refresh\" content=\"4;url=/financing/user/firstfont.action\"></meta>";
		request.setAttribute("msg", msg);
		return "error";
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
