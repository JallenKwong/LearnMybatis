package com.lun.c12.annotation.many2many;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.lun.c10.associationdynamic.many2many.Article;

public interface ArticleMapper {

	@Select("SELECT * FROM tb_article WHERE id IN (SELECT article_id FROM tb_item WHERE order_id = #{id} ) ")
	List<Article> selectByOrderId(Integer order_id);
	
}
