package com.lun.c13.spring;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lun.c08.hello.User;
import com.lun.c08.hello.UserMapper;

@Repository
public class UserDao {

	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	@Transactional
	public int save(User user) {
		return sessionTemplate.insert("com.lun.c08.hello.UserMapper.save", user);
	}
	
	@Transactional
	public void save2(User user) {
		 sessionTemplate.getMapper(UserMapper.class).save(user);
	}
	
	
}
