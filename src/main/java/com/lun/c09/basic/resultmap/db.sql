DROP DATABASE IF EXISTS learnmybatis;
CREATE DATABASE learnmybatis DEFAULT CHARACTER SET utf8mb4;
USE learnmybatis;

DROP TABLE IF EXISTS tb_user2;

CREATE TABLE `tb_user2` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(18) DEFAULT NULL,
  `user_sex` char(2) DEFAULT NULL,
  `user_age` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;


INSERT INTO `tb_user2` VALUES (2, 'admin', '男', 26);
INSERT INTO `tb_user2` VALUES (3, 'admin', '男', 26);
INSERT INTO `tb_user2` VALUES (4, 'admin', '男', 26);
INSERT INTO `tb_user2` VALUES (5, 'admin', '男', 26);
INSERT INTO `tb_user2` VALUES (6, 'admin', '男', 26);
INSERT INTO `tb_user2` VALUES (7, 'jack', '男', 22);


create table tb_clazz(
id int primary key auto_increment,
code varchar(18)
);

insert into tb_clazz(code) values('j1601');
insert into tb_clazz(code) values('j1602');

create table tb_student(
id int primary key auto_increment,
name varchar(18),
sex char(3),
age int,
clazz_id int,
foreign key (clazz_id) references tb_clazz(id)
);

insert into tb_student(name,sex,age,clazz_id) values ('jack','男',22,1);
insert into tb_student(name,sex,age,clazz_id) values ('jack','男',22,1);
insert into tb_student(name,sex,age,clazz_id) values ('jack','男',22,2);
insert into tb_student(name,sex,age,clazz_id) values ('jack','男',22,2);

