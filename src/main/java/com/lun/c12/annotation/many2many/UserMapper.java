package com.lun.c12.annotation.many2many;

import org.apache.ibatis.annotations.Select;

import com.lun.c10.associationdynamic.many2many.User;

public interface UserMapper {

	@Select("SELECT * FROM TB_USER WHERE ID = #{id} ")
	User selectById(Integer id);
	
}
