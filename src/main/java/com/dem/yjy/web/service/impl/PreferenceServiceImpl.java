package com.dem.yjy.web.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.dem.yjy.core.generic.GenericDao;
import com.dem.yjy.core.generic.GenericServiceImpl;
import com.dem.yjy.web.dao.PreferenceMapper;
import com.dem.yjy.web.model.Preference;
import com.dem.yjy.web.model.PreferenceExample;
import com.dem.yjy.web.service.PreferenceService;

/**
 * 角色Service实现类
 *
 * @author StarZou
 * @since 2014年6月10日 下午4:16:33
 */
@Service
public class PreferenceServiceImpl extends GenericServiceImpl<Preference, Integer> implements PreferenceService {

	@Resource
	private PreferenceMapper preferenceMapper;

	@Override
	public GenericDao<Preference, Integer> getDao() {
		return preferenceMapper;
	}

	@Override
	public Map<String, String> selectAllPreferences() {
		PreferenceExample example = new PreferenceExample();
		example.createCriteria().andIdIsNotNull();
		final List<Preference> preferences0 = preferenceMapper.selectByExample(example);
		final Map<String, String> perferences = new HashMap<String, String>();
		for (Preference preference : preferences0) {
			perferences.put(preference.getName(), preference.getValue());
		}
		return perferences;
	}

	@Override
	public List<Preference> selectList() {
		PreferenceExample example = new PreferenceExample();
		example.createCriteria().andIdIsNotNull();
		return preferenceMapper.selectByExample(example);
	}

	@Override
	public int updateByName(Preference preference) {
		PreferenceExample example = new PreferenceExample();
		example.createCriteria().andNameEqualTo(preference.getName());
		return preferenceMapper.updateByExampleSelective(preference, example);
	}

}
