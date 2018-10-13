CREATE TABLE tb_employee (
  ID INT(11) PRIMARY KEY AUTO_INCREMENT,
  loginname VARCHAR(18),
  PASSWORD VARCHAR(18),
  NAME VARCHAR(18) DEFAULT NULL,
  SEX CHAR(2) DEFAULT NULL,
  AGE INT(11) DEFAULT NULL,
  phone VARCHAR(21),
  sal DOUBLE,
  state VARCHAR(18)
);
 
INSERT INTO tb_employee(loginname,PASSWORD,NAME,sex,age,phone,sal,state)
 VALUES('jack','123456','杰克','男',26,'13902019999',9800,'ACTIVE');

 INSERT INTO tb_employee(loginname,PASSWORD,NAME,sex,age,phone,sal,state)
 VALUES('rose','123456','露丝','女',21,'13902018888',6800,'ACTIVE');