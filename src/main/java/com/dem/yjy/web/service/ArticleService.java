package com.dem.yjy.web.service;

import com.dem.yjy.web.model.ArticleQuery;
import com.dem.yjy.web.model.Article;

import java.util.List;

import com.dem.yjy.core.feature.orm.mybatis.Page;
import com.dem.yjy.core.generic.GenericService;

public interface ArticleService extends GenericService<Article, String> {

	public List<Article> getListFront();

	public int updateSort(String[] ids) throws Exception;
	
	public long countAll();
	
	public int getTop();
	
	public Page<Article> getPage(ArticleQuery articleQuery);
	
	public Page<Article> getFrontPage(ArticleQuery articleQuery);
}
