package com.lun.c11.txandcache.twocache;

import java.util.List;

import com.lun.c08.hello.User;


public interface UserMapper {
	
	// 根据id查询User
	User selectUserById(Integer id);
	
	// 查询所有User
	List<User> selectAllUser();
	
	// 根据id删除User
	void deleteUserById(Integer id);

}
