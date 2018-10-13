# MyBatis关联映射和动态SQL #

## 关联映射 ##

- 一对一
- 一对多
- 多对多

### 一对一 ###

[card](one2one/Card.java) - [person](one2one/Person.java)

[示例源码](one2one/)

### 一对多 ###

一[Clazz](one2many/Clazz.java) - 多[Student](one2many/Student.java)

[示例源码](one2many/)

### 多对多 ###

多[商品Article](many2many/Article.java) - 多[订单Order](many2many/Order.java)

[示例源码](many2many/)

## 动态SQL ##

MyBatis采用功能强大的基于**OGNL**的表达式完成动态SQL

常用动态SQL元素包括

- if
- choose(when、otherwise) 类似Java的switch
- where 用于sql的where条件智能修改
- set 用于update
- foreach 通常用于 in
- bind 可以从OGNL表达式中创建一个变量并将其绑定到上下文

[示例源码](dynamicsql/EmployeeMapper.xml)
















