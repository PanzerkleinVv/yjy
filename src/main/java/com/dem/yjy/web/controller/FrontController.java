package com.dem.yjy.web.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dem.yjy.web.model.Column;
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

    /**
     * 用户登录
     * 
     * @param user
     * @param result
     * @return
     */
    @RequestMapping(value = "/frontpage")
    public String frontpage(Model model, HttpServletRequest request) {
        final Map<String, String> preferences = preferenceService.selectAllPreferences();
        model.addAttribute("preferences", preferences);
        return "frontpage";
    }
    
	@Resource
	private ColumnService columnService;

	@RequestMapping(value = "/get")
	@ResponseBody
	public List<Column> get() {
		return columnService.getListFront();
	}

}
