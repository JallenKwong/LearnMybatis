CREATE TABLE tb_clazz(
id INT PRIMARY KEY AUTO_INCREMENT,
CODE VARCHAR(18),
NAME VARCHAR(18)
);

INSERT INTO tb_clazz(CODE,NAME) VALUES('j1601','Java就业班');

CREATE TABLE tb_student(
id INT PRIMARY KEY AUTO_INCREMENT,
NAME VARCHAR(18),
sex VARCHAR(18),
age INT,
clazz_id INT,
FOREIGN KEY (clazz_id) REFERENCES tb_clazz(id)
);

INSERT INTO tb_student(NAME,sex,age,clazz_id) VALUES('jack','男',23,1);
INSERT INTO tb_student(NAME,sex,age,clazz_id) VALUES('rose','女',18,1);
INSERT INTO tb_student(NAME,sex,age,clazz_id) VALUES('tom','男',21,1);
INSERT INTO tb_student(NAME,sex,age,clazz_id) VALUES('alice','女',20,1);