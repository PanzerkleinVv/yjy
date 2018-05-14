package com.dem.yjy.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dem.yjy.core.util.ApplicationUtils;
import com.dem.yjy.web.enums.MessageColor;
import com.dem.yjy.web.model.Article;
import com.dem.yjy.web.model.ArticleQuery;
import com.dem.yjy.web.model.Column;
import com.dem.yjy.web.service.ArticleService;
import com.dem.yjy.web.service.ColumnService;
import com.dem.yjy.core.feature.orm.mybatis.Page;

@Controller
@RequestMapping(value = "/article")
public class ArticleController {

	@Resource
	private ArticleService articleService;

	@Resource
	private ColumnService columnService;

	@RequestMapping(value = "/getList")
	public String getList(@ModelAttribute("articleQuery") ArticleQuery articleQuery, Model model) {
		Page<Article> page = null;
		List<Article> articles = null;
		page = articleService.getPage(articleQuery);
		articles = page.getResult();
		List<Column> columns = columnService.getListFront();
		Map<String, String> columnMap = new HashMap<String, String>();
		if (columns != null && columns.size() > 0) {
			for (Column column : columns) {
				columnMap.put(column.getId(), column.getColumnName());
			}
		}
		model.addAttribute("articles", articles);
		model.addAttribute("columns", columns);
		model.addAttribute("columnMap", columnMap);
		model.addAttribute("page", page);
		model.addAttribute("queryColumn", (articleQuery == null ? null : articleQuery.getColumn()));
		return "article";
	}

	@RequestMapping(value = "/getOne")
	@ResponseBody
	public Article getOne(@Valid String id) {
		return articleService.selectById(id);
	}

	@RequestMapping(value = "/save")
	@ResponseBody
	public Article save(Article article) {
		if (article != null && article.getId() != null) {
			if ("add".equals(article.getId())) {
				article.setId(ApplicationUtils.sha256Hex(ApplicationUtils.randomUUID()));
				article.setArticleSort(articleService.getTop() + 1);
				article.setArticleStatus(1);
				final int flag = articleService.insert(article);
				if (flag != 0) {
					article.setMsg0(MessageColor.SUCCESS.getColor());
					article.setMsg("新增成功");
				} else {
					article.setMsg0(MessageColor.FAILURE.getColor());
					article.setMsg("新增失败");
				}
				return article;
			} else {
				final int flag = articleService.update(article);
				final Article article0 = articleService.selectById(article.getId());
				if (flag > 0) {
					article0.setMsg0(MessageColor.SUCCESS.getColor());
					article0.setMsg("保存成功");
				} else {
					article0.setMsg0(MessageColor.FAILURE.getColor());
					article0.setMsg("保存失败");
				}
				return article0;
			}
		} else {
			article.setMsg0(MessageColor.FAILURE.getColor());
			article.setMsg("保存失败");
			return article;
		}
	}

	@RequestMapping(value = "/del")
	public String del(ArticleQuery articleQuery, RedirectAttributes model) {
		if (articleQuery != null && articleQuery.getId() != null) {
			Article article = new Article();
			article.setId(articleQuery.getId());
			article.setArticleStatus(0);
			articleService.update(article);
		}
		model.addFlashAttribute("articleQuery", articleQuery);
		return "redirect:/rest/article/getList";
	}

	@RequestMapping(value = "/top")
	public String top(ArticleQuery articleQuery, RedirectAttributes model) {
		if (articleQuery != null && articleQuery.getId() != null) {
			Article article = new Article();
			Integer max = articleService.getTop();
			article.setId(articleQuery.getId());
			article.setArticleSort(max + 1);
			articleService.update(article);
		}
		model.addFlashAttribute("articleQuery", articleQuery);
		return "redirect:/rest/article/getList";
	}
}
