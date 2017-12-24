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
	/*int updateTestreturn(String password);���� mybatis ���²��� ����ֵ �Ƿ��� Ӱ������� ���Խ��֤���ǵ�*/
	User queryUserById(int id);
}
