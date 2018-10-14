# MyBatis事务管理和缓存机制 #

## 事务管理 ##

事务是一步或几步操作组成的逻辑执行单元，这些基本操作作为一个整体执行单元，它们要么全部执行，要么全部取消执行，绝不能仅仅执行一部分。

事务的酸性

- 原子性
- 一致性
- 隔离性
- 持续性

### Transaction接口 ###
	org.apache.ibatis.transaction.Transaction;

	public interface Transaction {
	
	  /**
	   * Retrieve inner database connection
	   * @return DataBase connection
	   * @throws SQLException
	   */
	  Connection getConnection() throws SQLException;
	
	  /**
	   * Commit inner database connection.
	   * @throws SQLException
	   */
	  void commit() throws SQLException;
	
	  /**
	   * Rollback inner database connection.
	   * @throws SQLException
	   */
	  void rollback() throws SQLException;
	
	  /**
	   * Close inner database connection.
	   * @throws SQLException
	   */
	  void close() throws SQLException;
	
	  /**
	   * Get transaction timeout if set
	   * @throws SQLException
	   */
	  Integer getTimeout() throws SQLException;
	  
	}

MyBatis的事物管理分两种形式

- 使用JDBC的事物管理机制
- 使用MANAGED的事务管理机制

### 事务配置创建和使用 ###

	<environments default="mysql">
		<!-- 环境配置，即连接的数据库。 -->
		<environment id="mysql">
			<!-- 指定事务管理类型，type="JDBC"指直接简单使用了JDBC的提交和回滚设置 -->
			<transactionManager type="JDBC" />
			<!-- dataSource指数据源配置，POOLED是JDBC连接对象的数据源连接池的实现。 -->
			<dataSource type="POOLED">
				<property name="driver" value="com.mysql.jdbc.Driver" />
				<property name="url"
					value="jdbc:mysql://127.0.0.1:3306/learnmybatis" />
				<property name="username" value="root" />
				<property name="password" value="123" />
			</dataSource>
		</environment>
	</environments>

**事务工厂TransactionFactory**

**JdbcTransaction**

**ManagedTransaction** 由JBOSS等容器管理实现

## 缓存机制 ##

MyBatis的查询缓存分为一级缓存和二级缓存。

一级缓存是SqlSession级别的缓存，二级缓存是mapper级别的缓存，多个SqlSession是共享的。

需要注意的是，若SqlSession执行DML操作(insert，update，delete)，并提交到数据库，MyBatis则会清空SqlSession中的一级缓存，这样做的目的是为了保证缓存中存储的是最新的信息，避免出现脏读数据。

### 一级缓存 ###

[示例程序](onecache/)

### 二级缓存 ###


mybatis配置文件设置

	<settings>
		<setting name="logImpl" value="LOG4J"/>
		<!-- 开启二级缓存 -->
		<setting name="cacheEnabled" value="true"/>
	</settings>

---

UserMapper.xml中

	<!-- 开启二级缓存 
   	回收策略为先进先出
   	自动刷新时间60s
   	最多缓存512个引用对象
   	只读
    -->
	<cache 
	eviction="LRU"  
	flushInterval="60000" 
	size="512" 
	readOnly="true"/> 

[示例程序](twocache/)

