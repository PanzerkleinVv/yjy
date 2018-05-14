package com.dem.yjy.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dem.yjy.core.util.ApplicationUtils;
import com.dem.yjy.web.enums.MessageColor;
import com.dem.yjy.web.model.Article;
import com.dem.yjy.web.model.ArticleQuery;
import com.dem.yjy.web.model.Column;
import com.dem.yjy.web.service.ArticleService;

@Controller
@RequestMapping(value = "/article")
public class ArticleController {

	@Resource
	private ArticleService articleService;

	@RequestMapping(value = "/getList")
	public String getList(ArticleQuery articleQuery, Model model) {
		List<Article> articles = articleService.getPage(articleQuery);
		model.addAttribute("articles", articles);
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

	@RequestMapping(value = "/start")
	@ResponseBody
	public Article start(Article article) {
		article.setArticleStatus(1);
		final int flag = articleService.update(article);
		final Article article0 = articleService.selectById(article.getId());
		if (flag > 0) {
			article0.setMsg0(MessageColor.SUCCESS.getColor());
			article0.setMsg("启用成功");
		} else {
			article0.setMsg0(MessageColor.FAILURE.getColor());
			article0.setMsg("启用失败");
		}
		return article0;
	}

	@RequestMapping(value = "/top")
	@ResponseBody
	public Column top(HttpServletRequest request) throws Exception {
		String[] ids = request.getParameterValues("ids[]");
		final int flag = articleService.updateSort(ids);
		Column column = new Column();
		if (flag != 0) {
			column.setMsg0(MessageColor.SUCCESS.getColor());
			column.setMsg("排序成功");
		} else {
			column.setMsg0(MessageColor.FAILURE.getColor());
			column.setMsg("排序失败");
		}
		return column;
	}
}
