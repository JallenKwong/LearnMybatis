# MyBatis简介 #

## ORM 和 MyBatis ##

### 对象/关系数据库映射 ###

### 基本映射方式 ###

- 数据表映射类
- 数据表的行映射对象(即实例)
- 数据表的列(字段)映射对象的属性

### 流行的ORM框架简介 ###

- JPA
- Hiberante
- MyBatis

### MyBatis概述 ###

MyBatis是一个支持普通SQL查询、存储过程和高级映射的优秀持久层框架。

MyBatis去掉几乎所有的JDBC代码和参数的手工设置以及对结果集的检索封装。(优点)

MyBatis可以使用简单XML或注解进行配置和原始映射，以将接口和Java的POJO映射成数据库的记录

MyBatis作为持久层，其主要思想是将程序中的大量SQL语句剥离出来，配置在配置文件中，以实现SQL的灵活配置。这样做的好处是将SQL与程序代码分离，做到可以在不修改程序代码的情况下，直接在配置文件中修改


**Hibernate力有不逮之处**

1. 系统部分或全部数据来自现有数据库，出于安全只对开发团队提供几条Select SQL(或存储过程)以获取所需数据，具体表结构不公开
2. 开发规范中要求，所有涉及到业务逻辑部分的数据库操作，必须在数据库层由存储过程实现（就金融行业，开发规范中严格指定）
3. 系统数据处理量巨大，性能要求苛刻，这往往意味着我们必须通过经过高度优化的SQL语句(或存储过程)才能达到系统性能设计指标

## MyBatis入门 ##

### 引入MyBatis ###

	<dependency>
	    <groupId>org.mybatis</groupId>
	    <artifactId>mybatis</artifactId>
	    <version>3.4.1</version>
	</dependency>

### MyBatis数据库操作 ###

1.创建数据库和表

	CREATE TABLE `tb_user` (
	  `id` INT(11) NOT NULL AUTO_INCREMENT,
	  `name` VARCHAR(18) DEFAULT NULL,
	  `sex` CHAR(2) DEFAULT NULL,
	  `age` INT(11) DEFAULT NULL,
	  PRIMARY KEY  (`id`)
	)

2.创建POJO

[User](User.java)

	public class User implements Serializable{
		// 用户标识
		private Integer id;
		// 用户姓名
		private String name;
		// 用户性别
		private String sex;
		// 用户年龄
		private Integer age;

		...
	}

3.创建XML文件，完成持久化类和数据库表之间的映射关系

[UserMapper](UserMapper.xml)

4.创建MyBatis配置文件

[Config](hello-mybatis-config.xml)


5.MyBatis运行类

[MyBatisTest](MyBatisTest.java)

6.log4j日志

## 小结 ##

为了使用MyBatis进行持久化操作，通常步骤

1. 开发持久化类PO和编写持久化操作Mapper.xml，在其中定义要执行的SQL语句
2. 获取SqlSessionFactory
3. 获取SqlSession
4. 用面向对象的方式操作数据库
5. 关闭事务，关闭SqlSession

对比JDBC，MyBatis有两个显著特点

1. 只需要在Mapper.xml配置文件中编写SQL语句，在应用中可采用OO方式来访问数据库
2. 在JDBC访问过程中大量的checked异常被包装MyBatis的Runtime异常，从而不再要求程序必须处理所有异常
