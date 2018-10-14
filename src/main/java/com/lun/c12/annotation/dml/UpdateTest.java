package com.lun.c12.annotation.dml;

import org.apache.ibatis.session.SqlSession;

import com.lun.c08.hello.User;


public class UpdateTest {

	public static void main(String[] args) throws Exception {
		// 获得Session实例
		SqlSession session = FKSqlSessionFactory.getSqlSession();
		// 创建UserMapper实例
		UserMapper um = session.getMapper(UserMapper.class);
		// 查询id=5的User对象
		User user = um.selectUserById(1);
		// 修改查询到的User对象
		user.setName("update");
		user.setSex("女");
		user.setAge(19);
		// 修改User对象
		um.modifyUser(user);
		// 提交事务
		session.commit();
		// 关闭Session
		session.close();
	}

}
