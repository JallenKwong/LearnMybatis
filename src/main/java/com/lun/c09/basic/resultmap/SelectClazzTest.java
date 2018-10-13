package com.lun.c09.basic.resultmap;

import java.util.List;
import org.apache.ibatis.session.SqlSession;


public class SelectClazzTest {

	public static void main(String[] args) throws Exception {
		// 获得Session实例
		SqlSession session = FKSqlSessionFactory.getSqlSession();
		// 查询TB_CLAZZ表所有数据返回List集合,集合中的每个元素都是一个Clazz对象
		List<Clazz> clazz_list 
			= session.selectList("com.lun.c09.basic.resultmap.UserMapper.selectClazz");
		// 遍历List集合，打印每一个Clazz对象和该Clazz关联的所有Student对象
		for(Clazz clazz : clazz_list){
			System.out.println(clazz);
			List<Student> student_list = clazz.getStudents();
			for(Student stu : student_list){
				System.out.println(stu.getId() + " " + stu.getName() + " " + stu.getSex() + " " + stu.getAge());
			}
		}
		// 提交事务
		session.commit();
		// 关闭Session
		session.close();
	}

}
