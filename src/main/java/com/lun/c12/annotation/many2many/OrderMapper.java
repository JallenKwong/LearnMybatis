package com.lun.c12.annotation.many2many;


import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import com.lun.c10.associationdynamic.many2many.Order;

public interface OrderMapper {

	@Select("SELECT * FROM TB_ORDER WHERE ID = #{id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="code",property="code"),
		@Result(column="total",property="total"),
		@Result(column="user_id",property="user",
			one=@One(select="com.lun.c12.annotation.many2many.UserMapper.selectById",
		fetchType=FetchType.EAGER)),
		@Result(column="id",property="articles",
			many=@Many(select="com.lun.c12.annotation.many2many.ArticleMapper.selectByOrderId",
		fetchType=FetchType.LAZY))
	})
	Order selectById(Integer id);
	
}
