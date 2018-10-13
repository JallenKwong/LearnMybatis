package com.lun.c09.basic.dml;

import org.apache.ibatis.session.SqlSession;

import com.lun.c08.hello.User;

public class UpadeTest {

	public static void main(String[] args) throws Exception {
		// 获得Session实例
		SqlSession session = FKSqlSessionFactory.getSqlSession();
		// 根据id查询User对象
		User user = session.selectOne("com.lun.c09.basic.dml.UserMapper.selectUser",1);
		// 修改User对象的属性值
		user.setName("tom");
		user.setAge(25);
		// 修改User对象
		session.update("com.lun.c09.basic.dml.UserMapper.modifyUser", user);
		// 提交事务
		session.commit();
		// 关闭Session
		session.close();
	}

}
