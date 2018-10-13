 CREATE TABLE tb_user(
id INT PRIMARY KEY AUTO_INCREMENT,
username VARCHAR(18),
loginname VARCHAR(18),
PASSWORD VARCHAR(18),
phone VARCHAR(18),
address VARCHAR(18)
);

INSERT INTO tb_user(username,loginname,PASSWORD,phone,address)
VALUES('杰克','jack','123456','13920001616','广州');

CREATE TABLE tb_article(
id INT PRIMARY KEY AUTO_INCREMENT,
NAME VARCHAR(18),
price DOUBLE,
remark VARCHAR(18)
);

INSERT INTO tb_article(NAME,price,remark) 
VALUES('疯狂Java讲义',108.9,'李刚老师经典著作');
INSERT INTO tb_article(NAME,price,remark) 
VALUES('疯狂Android讲义',99.9,'李刚老师经典著作');
INSERT INTO tb_article(NAME,price,remark) 
VALUES('疯狂iOS讲义',89.9,'李刚老师经典著作');
INSERT INTO tb_article(NAME,price,remark) 
VALUES('Spring开发',69.9,'肖文吉老师经典著作');

CREATE TABLE tb_order(
id INT PRIMARY KEY AUTO_INCREMENT,
CODE VARCHAR(32),
total DOUBLE,
user_id INT,
FOREIGN KEY (user_id) REFERENCES tb_user(id)
);

INSERT INTO tb_order(CODE,total,user_id)
VALUES('6aa3fa359ff14619b77fab5990940a2d',388.6,1);

INSERT INTO tb_order(CODE,total,user_id)
VALUES('6aa3fa359ff14619b77fab5990940b3c',217.8,1);

CREATE TABLE tb_item(
order_id INT,
article_id INT,
amount INT,
PRIMARY KEY(order_id,article_id),
FOREIGN KEY (order_id) REFERENCES tb_order(id),
FOREIGN KEY (article_id) REFERENCES tb_article(id)
);

INSERT INTO tb_item(order_id,article_id,amount) 
VALUES(1,1,1);
INSERT INTO tb_item(order_id,article_id,amount) 
VALUES(1,2,1);
INSERT INTO tb_item(order_id,article_id,amount) 
VALUES(1,3,2);

INSERT INTO tb_item(order_id,article_id,amount) 
VALUES(2,4,2);
INSERT INTO tb_item(order_id,article_id,amount) 
VALUES(2,1,1);