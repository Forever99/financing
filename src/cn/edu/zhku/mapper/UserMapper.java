package cn.edu.zhku.mapper;

import java.util.List;

import cn.edu.zhku.pojo.User;

public interface UserMapper {
	public List<User> queryAllUser();
	public User queryUserByName(String username);
}
