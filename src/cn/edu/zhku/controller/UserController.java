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
		String msg = "��¼ʧ�ܣ�4�����ת����¼ע��ҳ�� <meta http-equiv=\"refresh\" content=\"4;url=/financing/user/firstfont.action\"></meta>";
		request.setAttribute("msg", msg);
		return "error";
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
	public String register(User user,HttpServletRequest request) {
		//��Ȼǰ̨ ��ajax ��ֹ�� �û��ظ�ע�� ���� ��̨����Ҫ��ֹ
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
		String msg = "���û��Ѵ��ڣ�4�����ת����¼ע��ҳ�� <meta http-equiv=\"refresh\" content=\"4;url=/financing/user/firstfont.action\"></meta>";
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
