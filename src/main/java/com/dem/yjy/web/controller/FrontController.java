package com.dem.yjy.web.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dem.yjy.core.feature.orm.mybatis.Page;
import com.dem.yjy.web.model.Article;
import com.dem.yjy.web.model.ArticleQuery;
import com.dem.yjy.web.model.Column;
import com.dem.yjy.web.service.ArticleService;
import com.dem.yjy.web.service.ColumnService;
import com.dem.yjy.web.service.PreferenceService;

/**
 * 用户控制器
 * 
 * @author StarZou
 * @since 2014年5月28日 下午3:54:00
 **/
@Controller
@RequestMapping(value = "/front")
public class FrontController {

	@Resource
	private PreferenceService preferenceService;

	@Resource
	private ColumnService columnService;

	@Resource
	private ArticleService articleService;

	/**
	 * 用户登录
	 * 
	 * @param user
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/frontpage")
	public String frontpage(Model model, String columnId) {
		Map<String, String> preferences = preferenceService.selectAllPreferences();;
		final List<Column> columns = columnService.getListFront();
		if (columnId != null && !"".equals(columnId)) {
			for (Column column : columns) {
				if (columnId.equals(column.getId())) {
					preferences.put("title", column.getColumnTitle());
					preferences.put("keywords", column.getColumnKeyword());
					preferences.put("description", column.getColumnInfo());
				}
			}
		}
		model.addAttribute("preferences", preferences);
		model.addAttribute("columnId", columnId);
		model.addAttribute("columns", columns);
		return "frontpage";
	}

	@RequestMapping(value = "/article")
	@ResponseBody
	public Page<Article> article(ArticleQuery articleQuery) {
		articleQuery.setPageSize(5);
		return articleService.getPage(articleQuery);
	}

}
