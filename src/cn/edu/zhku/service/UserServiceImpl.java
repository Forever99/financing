package cn.edu.zhku.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.zhku.mapper.UserMapper;
import cn.edu.zhku.pojo.User;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	@Override
	public List<User> queryAllUser() {
		return userMapper.queryAllUser();
	}
	@Override
	public User queryUserByUserName(String username) {
		return userMapper.queryUserByName(username);
	}
	@Override
	public void addUser(User user) {
		userMapper.addUser(user);
	}
	@Override
	public User singin(User user) {
		return userMapper.queryUserSingin(user);
	}
	@Override
	public int updateUserName(User user) {
		return userMapper.updateUserName(user);
	}
	@Override
	public int updateUserPassword(User user) {
		return userMapper.updateUserPassword(user);
	}
	/*@Override
	public int updateTestreturn(String password) {
		return userMapper.updateTestreturn(password);
	}*/

}
