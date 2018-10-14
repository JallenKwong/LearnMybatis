package com.lun.c12.annotation.dml;

import org.apache.ibatis.session.SqlSession;


public class DeleteTest {

	public static void main(String[] args) throws Exception {
		// 获得Session实例
		SqlSession session = FKSqlSessionFactory.getSqlSession();
		// 创建UserMapper实例
		UserMapper um = session.getMapper(UserMapper.class);
		// 删除User对象
		um.removeUser(5);
		// 提交事务
		session.commit();
		// 关闭Session
		session.close();
	}

}
