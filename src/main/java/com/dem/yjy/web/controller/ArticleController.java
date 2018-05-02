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
import com.dem.yjy.web.model.Column;
import com.dem.yjy.web.service.ArticleService;
import com.dem.yjy.web.service.ColumnService;

@Controller
@RequestMapping(value = "/column")
public class ArticleController {

	@Resource
	private ArticleService articleService;

	@RequestMapping(value = "/getList")
	public String getList(Model model) {
		List<Article> columns = columnService.selectList();
		model.addAttribute("columns", columns);
		return "column";
	}

	@RequestMapping(value = "/getOne")
	@ResponseBody
	public Article getOne(@Valid String id) {
		return columnService.selectById(id);
	}

	@RequestMapping(value = "/save")
	@ResponseBody
	public Article save(Article column) {
		final int flag = columnService.update(column);
		final Article column0 = columnService.selectById(column.getId());
		if (flag > 0) {
			column0.setMsg0(MessageColor.SUCCESS.getColor());
			column0.setMsg("保存成功");
		} else {
			column0.setMsg0(MessageColor.FAILURE.getColor());
			column0.setMsg("保存失败");
		}
		return column0;
	}

	@RequestMapping(value = "/start")
	@ResponseBody
	public Article start(Article column) {
		column.setArticleStatus(1);
		final int flag = columnService.update(column);
		final Column column0 = columnService.selectById(column.getId());
		if (flag > 0) {
			column0.setMsg0(MessageColor.SUCCESS.getColor());
			column0.setMsg("启用成功");
		} else {
			column0.setMsg0(MessageColor.FAILURE.getColor());
			column0.setMsg("启用失败");
		}
		return column0;
	}

	@RequestMapping(value = "/sort")
	@ResponseBody
	public Column sort(HttpServletRequest request) throws Exception {
		String[] ids = request.getParameterValues("ids[]");
		final int flag = columnService.updateSort(ids);
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

	@RequestMapping(value = "/add")
	public String add(Column column, Model model) {
		final long count = columnService.countAll();
		column.setId(ApplicationUtils.sha256Hex(ApplicationUtils.randomUUID()));
		column.setColumnSort((int) count + 1);
		column.setColumnStatus(1);
		final int flag = columnService.insert(column);
		if (flag != 0) {
			model.addAttribute("msg0", MessageColor.SUCCESS.getColor());
			model.addAttribute("msg", "新增成功");
		} else {
			model.addAttribute("msg0", MessageColor.FAILURE.getColor());
			model.addAttribute("msg", "新增失败");
		}
		List<Column> columns = columnService.selectList();
		model.addAttribute("columns", columns);
		return "column";
	}
}
