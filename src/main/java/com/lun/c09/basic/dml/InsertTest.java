package com.lun.c09.basic.dml;

import org.apache.ibatis.session.SqlSession;

import com.lun.c08.hello.User;

public class InsertTest {

	public static void main(String[] args) throws Exception {
		// 获得Session实例
		SqlSession session = FKSqlSessionFactory.getSqlSession();
		// 创建User对象
		User user = new User("jack", "男", 22);
		// 插入数据
		session.insert("com.lun.c09.basic.dml.UserMapper.saveUser", user);
		// 提交事务
		session.commit();
		// 关闭Session
		session.close();
	}

}
