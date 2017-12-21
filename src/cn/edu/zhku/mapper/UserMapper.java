package cn.edu.zhku.mapper;

import java.util.List;

import cn.edu.zhku.pojo.User;

public interface UserMapper {
	public List<User> queryAllUser();
	public User queryUserByName(String username);
	public void addUser(User user);
	public User queryUserSingin(User user);
	public int updateUserName(User user);
	public int updateUserPassword(User user);
	/*public int updateTestreturn(String password);*/
}
