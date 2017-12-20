package cn.edu.zhku.service;

import java.util.List;

import cn.edu.zhku.pojo.User;

public interface UserService {
	List<User> queryAllUser();
	User queryUserByUserName(String username);
	void addUser(User user);
}
