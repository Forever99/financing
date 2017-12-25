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
			//������ ������ʾ��׼��
			List<SpendCategory> listSpendCate = spendService.queryAllSpendCate();
			session.setAttribute("cate", listSpendCate);
			session.setAttribute("user", user1);
			return "index";
		}
		String msg = "��¼ʧ�ܣ�3�����ת����¼ע��ҳ�� <meta http-equiv=\"refresh\" content=\"3;url=/financing/user/firstfont.action\"></meta>";
		request.setAttribute("msg", msg);
		return "message";
	}
	//����session ���ֲ�ͬ�û�����
	/*@RequestMapping(value="index")
	public String testsession() {
		return "index";
	}*/
	
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
		String msg = "���û��Ѵ��ڣ�3�����ת����¼ע��ҳ�� <meta http-equiv=\"refresh\" content=\"3;url=/financing/user/firstfont.action\"></meta>";
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
		String msg = "�����޸�ʧ�ܣ�3�����ת����¼ע��ҳ�� <meta http-equiv=\\\"refresh\\\" content=\\\"3;url=/financing/user/firstfont.action\\\"></meta>";
		if(num!=0) {
			msg = "�����޸ĳɹ���3�����ת����¼ע��ҳ�� <meta http-equiv=\"refresh\" content=\"3;url=/financing/user/firstfont.action\"></meta>";
		}
		request.setAttribute("msg", msg);
		return "message";
	}
	
	//��ʾ�û� ���� ��ҳ ���� �����޸ĵ�ҳ��
	@RequestMapping(value="showuserPage")
	public String showUserPage(@RequestParam(value="id") String id) {
		int userId = Integer.parseInt(id);
		User user = userService.queryUserById(userId);
		//�ŷ��� ���Դ�session��ȡ���ݡ�������
		return "userpage";
	}
	@RequestMapping(value="testhaha")
	public String testhaha() {
		return "test";
	}
}
