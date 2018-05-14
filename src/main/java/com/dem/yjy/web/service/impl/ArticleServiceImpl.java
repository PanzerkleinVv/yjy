package com.dem.yjy.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dem.yjy.web.dao.ArticleMapper;
import com.dem.yjy.web.model.ArticleExample;
import com.dem.yjy.web.model.ArticleExample.Criteria;
import com.dem.yjy.web.model.ArticleQuery;
import com.dem.yjy.web.service.ArticleService;
import com.dem.yjy.web.model.Article;
import com.dem.yjy.core.feature.orm.mybatis.Page;
import com.dem.yjy.core.generic.GenericDao;
import com.dem.yjy.core.generic.GenericServiceImpl;

@Service
public class ArticleServiceImpl extends GenericServiceImpl<Article, String> implements ArticleService {

	@Resource
	private ArticleMapper articleMapper;

	@Override
	public int insert(Article model) {
		return articleMapper.insertSelective(model);
	}

	@Override
	public int update(Article model) {
		return articleMapper.updateByPrimaryKeySelective(model);
	}

	@Override
	public int delete(String id) {
		return articleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Article selectById(String id) {
		return articleMapper.selectByPrimaryKey(id);
	}

	@Override
	public Article selectOne() {
		return null;
	}

	@Override
	public List<Article> selectList() {
		ArticleExample example = new ArticleExample();
		example.createCriteria().andArticleStatusEqualTo(1);
		example.setOrderByClause("article_sort desc");
		return articleMapper.selectByExample(example);
	}

	@Override
	public GenericDao<Article, String> getDao() {
		return articleMapper;
	}

	@Override
	public List<Article> getListFront() {
		ArticleExample example = new ArticleExample();
		example.createCriteria().andArticleStatusEqualTo(1);
		example.setOrderByClause("article_sort desc");
		return articleMapper.selectByExample(example);
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public int updateSort(String[] ids) throws Exception {
		int flag = 0;
		Article article = null;
		if (ids != null) {
			for (int i = 0; i < ids.length; i++) {
				article = new Article();
				article.setArticleSort(i + 1);
				article.setId(ids[i]);
				//flag = articleMapper.updateSortByPrimaryKey(article);
				if (flag < 1) {
					throw new Exception("保存栏目排序出错");
				}
			}
			flag = ids.length;
		} else {
			flag = 0;
		}
		return flag;
	}

	@Override
	public long countAll() {
		ArticleExample example = new ArticleExample();
		example.createCriteria().andIdIsNotNull();
		return articleMapper.countByExample(example);
	}

	@Override
	public int getTop() {
		final Integer max = articleMapper.getTop();
		if (max == null) {
			return 0;
		} else {
			return max;
		}
	}

	@Override
	public Page<Article> getPage(ArticleQuery articleQuery) {
		if (articleQuery != null) {
			int pageNo = 1;
			if (articleQuery.getPageNo() != null) {
				pageNo = articleQuery.getPageNo();
			}
			Page<Article> page = new Page<>(pageNo);
			ArticleExample example = new ArticleExample();
			Criteria criteria = example.createCriteria();
			criteria.andIdIsNotNull().andArticleStatusEqualTo(1);
			if (articleQuery.getColumn() != null && !"".equals(articleQuery.getColumn())) {
				criteria.andArticleColumnEqualTo(articleQuery.getColumn());
			}
			example.setOrderByClause("article_sort desc");
			articleMapper.selectByExampleAndPage(example, page);
			return page;
		} else {
			return null;
		}
	}

}
