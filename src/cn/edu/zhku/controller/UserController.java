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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.zhku.pojo.SpendCategory;
import cn.edu.zhku.pojo.User;
import cn.edu.zhku.service.SpendService;
import cn.edu.zhku.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private SpendService spendService;

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
			//先做好 数据显示的准备
			List<SpendCategory> listSpendCate = spendService.queryAllSpendCate();
			session.setAttribute("cate", listSpendCate);
			session.setAttribute("user", user1);
			return "index";
		}
		String msg = "登录失败，3秒后跳转到登录注册页面 <meta http-equiv=\"refresh\" content=\"3;url=/financing/user/firstfont.action\"></meta>";
		request.setAttribute("msg", msg);
		return "message";
	}
	//测试session 区分不同用户问题
	/*@RequestMapping(value="index")
	public String testsession() {
		return "index";
	}*/
	
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
			return "message";
		}else {
			userService.addUser(user);
			int num = user.getId();
			if(num!=0) {
				List<SpendCategory> listSpendCate = spendService.queryAllSpendCate();
				session.setAttribute("user", user);
				session.setAttribute("cate", listSpendCate);
				return "index";
			}
		}
		String msg = "该用户已存在，3秒后跳转到登录注册页面 <meta http-equiv=\"refresh\" content=\"3;url=/financing/user/firstfont.action\"></meta>";
		request.setAttribute("msg", msg);
		return "message";
	}

	@RequestMapping("logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		session.removeAttribute("cate");
		return "singInAndUp";
	}

	@RequestMapping(value="updatePassword",method=RequestMethod.POST)
	public String changePassword(User user,HttpServletRequest request) {
		User user2 = userService.queryUserByUserName(user.getUsername());
		user.setId(user2.getId());
		int num = userService.updateUserPassword(user);
		String msg = "密码修改失败，3秒后跳转到登录注册页面 <meta http-equiv=\\\"refresh\\\" content=\\\"3;url=/financing/user/firstfont.action\\\"></meta>";
		if(num!=0) {
			msg = "密码修改成功，3秒后跳转到登录注册页面 <meta http-equiv=\"refresh\" content=\"3;url=/financing/user/firstfont.action\"></meta>";
		}
		request.setAttribute("msg", msg);
		return "message";
	}
	
	//显示用户 个人 主页 包括 可以修改的页面
	@RequestMapping(value="showuserPage")
	public String showUserPage(@RequestParam(value="id") String id) {
		int userId = Integer.parseInt(id);
		User user = userService.queryUserById(userId);
		//才发现 可以从session中取数据。。。。
		return "userpage";
	}
	@RequestMapping(value="testhaha")
	public String testhaha() {
		return "test";
	}
}
