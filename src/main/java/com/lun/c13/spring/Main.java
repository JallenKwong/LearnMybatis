package com.lun.c13.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lun.c08.hello.User;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("c13-applicationContext.xml");
		UserDao dao = (UserDao)ctx.getBean("userDao");
		
		dao.save(new User("admin", "男", 26));
		
		dao.save2(new User("admin2", "男", 33));
		
	}

}
