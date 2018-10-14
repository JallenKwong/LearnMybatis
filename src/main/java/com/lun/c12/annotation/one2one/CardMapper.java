package com.lun.c12.annotation.one2one;

import org.apache.ibatis.annotations.Select;

import com.lun.c10.associationdynamic.one2one.Card;

public interface CardMapper {

	@Select("SELECT * FROM TB_CARD WHERE ID = #{id} ")
	Card selectCardById(Integer id);
	
}
