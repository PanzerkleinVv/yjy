package com.dem.yjy.web.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dem.yjy.web.enums.MessageColor;
import com.dem.yjy.web.model.Preference;
import com.dem.yjy.web.service.PreferenceService;

@Controller
@RequestMapping("/preference")
public class PreferenceController {

	@Resource
	private PreferenceService preferenceService;

	@RequestMapping("/info")
	public String info(Model model) {
		List<Preference> preferences = preferenceService.selectList();
		model.addAttribute("preferences", preferences);
		return "preference";
	}

	@RequestMapping("/save")
	public String save(Model model, HttpServletRequest request) {
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String keywords = request.getParameter("keywords");
		String description = request.getParameter("description");
		String aboutme = request.getParameter("aboutme");
		List<Preference> preferences = new ArrayList<Preference>();
		Preference preference = new Preference();
		preference.setId(1);
		preference.setValue(name);
		preferences.add(preference);
		preference = new Preference();
		preference.setId(2);
		preference.setValue(title);
		preferences.add(preference);
		preference = new Preference();
		preference.setId(3);
		preference.setValue(keywords);
		preferences.add(preference);
		preference = new Preference();
		preference.setId(4);
		preference.setValue(description);
		preferences.add(preference);
		preference.setId(5);
		preference.setValue(aboutme);
		preferences.add(preference);

		int result = 0;
		preference = null;
		for (Preference preference0 : preferences) {
			result = preferenceService.update(preference0);
			if (result != 1) {
				model.addAttribute("msg0", MessageColor.FAILURE.getColor());
				model.addAttribute("msg", "保存出错");
				List<Preference> preferences0 = preferenceService.selectList();
				model.addAttribute("preferences", preferences0);
				return "preference";
			}
		}
		model.addAttribute("msg0", MessageColor.SUCCESS.getColor());
		model.addAttribute("msg", "保存成功");
		List<Preference> preferences1 = preferenceService.selectList();
		model.addAttribute("preferences", preferences1);
		return "preference";
	}
}
