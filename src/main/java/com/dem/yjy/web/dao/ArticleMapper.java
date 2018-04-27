package com.dem.yjy.web.dao;

import com.dem.yjy.core.generic.GenericDao;
import com.dem.yjy.web.model.Article;
import com.dem.yjy.web.model.ArticleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleMapper extends GenericDao<Article, String> {
	long countByExample(ArticleExample example);

	int deleteByExample(ArticleExample example);

	int deleteByPrimaryKey(String id);

	int insert(Article record);

	int insertSelective(Article record);

	List<Article> selectByExample(ArticleExample example);

	Article selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") Article record, @Param("example") ArticleExample example);

	int updateByExample(@Param("record") Article record, @Param("example") ArticleExample example);

	int updateByPrimaryKeySelective(Article record);

	int updateByPrimaryKey(Article record);
}