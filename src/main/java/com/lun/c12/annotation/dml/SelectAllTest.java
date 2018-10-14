package com.lun.c12.annotation.dml;

import java.util.List;
import org.apache.ibatis.session.SqlSession;

import com.lun.c08.hello.User;


public class SelectAllTest {

	public static void main(String[] args) throws Exception {
		// 获得Session实例
		SqlSession session = FKSqlSessionFactory.getSqlSession();
		// 创建UserMapper实例
		UserMapper um = session.getMapper(UserMapper.class);
		// 根据id查询User对象
		List<User> list = um.selectAllUser();
		// 查看查询到的User对象
		list.forEach(user->System.out.println(user));
		// 提交事务
		session.commit();
		// 关闭Session
		session.close();
	}

}
