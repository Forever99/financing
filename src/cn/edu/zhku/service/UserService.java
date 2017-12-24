package cn.edu.zhku.service;

import java.util.List;

import cn.edu.zhku.pojo.User;

public interface UserService {
	List<User> queryAllUser();
	User queryUserByUserName(String username);
	void addUser(User user);
	User singin(User user);
	int updateUserName(User user);
	int updateUserPassword(User user);
	/*int updateTestreturn(String password);测试 mybatis 更新操作 返回值 是否是 影响的行数 测试结果证明是的*/
	User queryUserById(int id);
}
