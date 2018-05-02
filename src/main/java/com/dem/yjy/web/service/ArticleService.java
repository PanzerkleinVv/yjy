package com.dem.yjy.web.service;

import com.dem.yjy.web.model.Article;

import java.util.List;

import com.dem.yjy.core.generic.GenericService;

public interface ArticleService extends GenericService<Article, String> {

	public List<Article> getListFront();

	public int updateSort(String[] ids) throws Exception;
	
	public long countAll();
}
