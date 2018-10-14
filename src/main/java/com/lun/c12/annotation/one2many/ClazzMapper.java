package com.lun.c12.annotation.one2many;


import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import com.lun.c10.associationdynamic.one2many.Clazz;

public interface ClazzMapper {

	// 根据id查询班级信息
	@Select("SELECT * FROM TB_CLAZZ  WHERE ID = #{id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="code",property="code"),
		@Result(column="name",property="name"),
		@Result(column="id",property="students",
		many=@Many(
				select="com.lun.c12.annotation.one2many.StudentMapper.selectByClazzId",
				fetchType=FetchType.LAZY))
	})
	Clazz selectById(Integer id);

		
}
